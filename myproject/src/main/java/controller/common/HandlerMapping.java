package controller.common;

import java.util.HashMap;
import java.util.Map;

import controller.action.GetBoardController;
import controller.action.InsertBoardController;
import controller.action.InsertMemberController;
import controller.action.LoginController;
import controller.action.LogoutController;
import controller.action.MainController;

// ��û���� Aciton���� ���� � ��Ʈ�ѷ�(POJO)�� �̿����� ����
// ��, POJO�� �������ִ� "��ü"
// ���ڷ� URL�� ��û�޾� --- HandlerMapping ---> ��Ʈ�ѷ� ��ü ��ȯ
// �α��� �� ������� ��û�� ���������� �����ϴ� ��ü�� Controller ��ü�̰�, ��Ʈ�ѷ��� ����� �����ϵ��� ���ִ� ��ü�� HandlerMapping�̴�.
public class HandlerMapping {
	
	private Map<String, Controller> mappings;
	
	public HandlerMapping() { // HandlerMapping�� �����ڷ� �ʱ�ȭ
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
