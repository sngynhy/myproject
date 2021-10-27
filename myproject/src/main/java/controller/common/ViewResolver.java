package controller.common;

// ��û ����� ������ View�� �̵����ִ� ����
public class ViewResolver {
	
	public String prefix; // ����� �Ӹ���
	public String suffix; // ����� ������
	
	// ViewResolver�� setter�Լ��� �ʱ�ȭ
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String view) { // ��Ʈ�ѷ��� ��ȯ�� == �̵��� ���
		return prefix + view + suffix;
	}
}