package beat_15;

public class Main {

	//3.�ε�������߰�
	//public static�� ��� ������Ʈ���� ���������� ���� final�� �ѹ� �����ϸ� ������ �ʴ� �� �̴�.
	//���� �ѹ� ������ �� ���� ��ġ ���� ����� ���� �빮�ڷ� ����
	public static final int SCREEN_WIDTH = 1280;//���ȭ�� ũ�Ⱑ �´°� ���� �ٲ��.
	public static final int SCREEN_HEIGHT = 720;
	public static final int NOTE_SPEED = 5;
	public static final int SLEEP_TIME = 10;
	public static final int REACH_TIME = 1;//��Ʈ�� �����ð�
	
	public static void main(String[] args) {

		new DynamicBeat();//���̳��� ��Ʈ�� ����
		
	}

}
