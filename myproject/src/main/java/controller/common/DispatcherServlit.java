package controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// FrontController == DispatcherServlit
// ���� Ŭ���� - Ŭ���̾�Ʈ�� ��� ��û�� ���� �������� ���� -> ��û���� Aciton���� ���� � ��Ʈ�ѷ�(POJO)�� �̿����� ���� -- HendlertMapping --> POJO�� ����
// HendlertMapping Ŭ���� - POJO�� �������ִ� "��ü"
// ������̼� or xml �������Ͽ� Action(POJO)�� ����ϸ� HendlertMapping�� ����ߴٰ� �ڵ����� ���ν����ش�.
public class DispatcherServlit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	// �̱��� ������ ���� �ʱ�ȭ �޼ҵ� -> �������Ͽ��� ���α׷� ���� �� �ش� �Լ� close ���� ����
	public void init () {
		handlerMapping =  new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./"); // ����� �Ӹ��� ����
		viewResolver.setSuffix(".jsp"); // ����� ������ ����
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
		
		/* 1. Ŭ���̾�Ʈ�� "��û"�� �м� */
		String uri = request.getRequestURI(); // uri : /FrontController/main.do
		String cp = request.getContextPath(); // cp :/FrontController
		String action = uri.substring(cp.length()); // action : /main/do - ���� �׼ǰ��� ���� -> ���� ������ ����
		
		/* 2. HM���� action �� ���� -> Controller ��ü ��ȯ 
		 	  �� ������ Look up�̶�� �� == ��ü�� ã�� ���� */
		Controller controller = handlerMapping.getController(action);		
		
		// Ŭ���̾�Ʈ�� ��û�� ���������� �����ϴ� Controller ��ü -> "���" ��ȯ
		String view = controller.execute(request, response); // ������ ����
		
		if (!view.contains(".do")) { // ��ο� .do�� ������ viewResolver�� .jsp�� �ٿ��ش�.
			view = viewResolver.getView(view);
		}
		
		/* 3. ȭ������ �̵� */
		response.sendRedirect(view);
		
		// �帧
		// DS -> HM -> C -> VR
		
	}
}
