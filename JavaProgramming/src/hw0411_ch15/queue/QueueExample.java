package hw0411_ch15.queue;

import java.util.LinkedList;
import java.util.Queue;
//  ť: ���� ����
public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<>();
		
		messageQueue.offer(new Message("sendMail", "ȫ�浿"));
		messageQueue.offer(new Message("sendSMS", "�ſ��"));
		messageQueue.offer(new Message("sendkakao", "ȫ�β�"));
		
		while(!messageQueue.isEmpty()){
			Message m = messageQueue.poll();
			
			switch(m.command){
				case "sendMail" : System.out.println(m.to + "�Կ��� ���� "); break;
				case "sendSMS" : System.out.println(m.to + "�Կ��� ����"); break;
				case "sendkakao" : System.out.println(m.to + "�Կ��� ī��"); break;
			}
		}
		
	}
}
