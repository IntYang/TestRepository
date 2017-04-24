package ch11.exam02;
//2017.04.04 ��������
public class Key {
	private int number;
	
	public Key(int number){
		this.number = number;
	}
	
	//Ű ��ȣ�� ���ٸ� ���� �ɷ� �����ϰ� �����ϴ� ���
	// �ؽ��ڵ� ������ &&
	// equals() ������
	
	@Override
	public int hashCode() {
		return number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key){ //  Member ��ü�� ������
			Key target = (Key) obj; //���� Ÿ�� ��ȯ�ϴ� ����: �ڽ� ��ü �� �� �ֵ���
			if(number == target.number)
				return true;
		}
		
		return false;
	
	}
	
}
