package controller.common;

// 요청 결과를 가지고 View로 이동해주는 역할
public class ViewResolver {
	
	public String prefix; // 경로의 머릿말
	public String suffix; // 경로의 꼬릿말
	
	// ViewResolver는 setter함수로 초기화
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String view) { // 컨트롤러의 반환값 == 이동할 경로
		return prefix + view + suffix;
	}
}