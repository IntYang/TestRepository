package hw06.ch10.example07;

public class NotExistIDException extends Exception { //����� ���� ����Ŭ����: ExceptionŬ���� ��ӹ޾ƾ���
	//������
	public NotExistIDException(){
		
	}
	
	
	//�޽��� �Ű����� ������
	public NotExistIDException(String message){
		super(message);
	}
}
