package controller.common;

import java.util.HashMap;
import java.util.Map;

import controller.action.GetBoardController;
import controller.action.InsertBoardController;
import controller.action.InsertMemberController;
import controller.action.LoginController;
import controller.action.LogoutController;
import controller.action.MainController;

// 요청받은 Aciton값에 따라 어떤 컨트롤러(POJO)를 이용할지 결정
// 즉, POJO를 매핑해주는 "주체"
// 인자로 URL을 요청받아 --- HandlerMapping ---> 컨트롤러 객체 반환
// 로그인 등 사용자의 요청을 실제적으로 수행하는 주체는 Controller 객체이고, 컨트롤러가 기능을 수행하도록 해주는 주체가 HandlerMapping이다.
public class HandlerMapping {
	
	private Map<String, Controller> mappings;
	
	public HandlerMapping() { // HandlerMapping는 생성자로 초기화
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/main.do", new MainController());
		mappings.put("/insertMember.do", new InsertMemberController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
