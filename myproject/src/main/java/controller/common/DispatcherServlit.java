package controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// FrontController == DispatcherServlit
// 서블릿 클래스 - 클라이언트의 모든 요청이 현재 서블릿으로 들어옴 -> 요청받은 Aciton값에 따라 어떤 컨트롤러(POJO)를 이용할지 결정 -- HendlertMapping --> POJO를 매핑
// HendlertMapping 클래스 - POJO를 매핑해주는 "주체"
// 어노테이션 or xml 설정파일에 Action(POJO)를 등록하면 HendlertMapping이 기억했다가 자동으로 매핑시켜준다.
public class DispatcherServlit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	// 싱글톤 패턴을 위한 초기화 메소드 -> 설정파일에서 프로그램 종료 시 해당 함수 close 설정 가능
	public void init () {
		handlerMapping =  new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./"); // 경로의 머릿말 설정
		viewResolver.setSuffix(".jsp"); // 경로의 꼬릿말 설정
	}

    public DispatcherServlit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 1. 클라이언트의 "요청"을 분석 */
		String uri = request.getRequestURI(); // uri : /FrontController/main.do
		String cp = request.getContextPath(); // cp :/FrontController
		String action = uri.substring(cp.length()); // action : /main/do - 실제 액션값만 추출 -> 유지 보수성 증가
		
		/* 2. HM에게 action 값 전달 -> Controller 객체 반환 
		 	  이 과정을 Look up이라고 함 == 객체를 찾는 행위 */
		Controller controller = handlerMapping.getController(action);		
		
		// 클라이언트의 요청을 실질적으로 수행하는 Controller 객체 -> "경로" 반환
		String view = controller.execute(request, response); // 다형성 실현
		
		if (!view.contains(".do")) { // 경로에 .do가 없으면 viewResolver가 .jsp를 붙여준다.
			view = viewResolver.getView(view);
		}
		
		/* 3. 화면으로 이동 */
		response.sendRedirect(view);
		
		// 흐름
		// DS -> HM -> C -> VR
		
	}
}
