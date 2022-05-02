package beat_7;

public class Main {

	//3.인드로음악추가
	//public static은 모든 프로젝트에서 공유가능한 변수 final은 한번 선언하면 변하지 않는 수 이다.
	//보통 한번 선언한 뒤 값이 변치 않을 상수는 전부 대문자로 쓴다
	public static final int SCREEN_WIDTH = 1280;//배경화면 크기가 맞는게 없어 바꿨다.
	public static final int SCREEN_HEIGHT = 720;
	
	
	public static void main(String[] args) {

		new DynamicBeat();//다이나믹 비트를 실행
		
	}

}
