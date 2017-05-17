package hw0411_ch15.queue;

import java.util.LinkedList;
import java.util.Queue;
//  큐: 선입 선출
public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<>();
		
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "신용권"));
		messageQueue.offer(new Message("sendkakao", "홍두께"));
		
		while(!messageQueue.isEmpty()){
			Message m = messageQueue.poll();
			
			switch(m.command){
				case "sendMail" : System.out.println(m.to + "님에게 메일 "); break;
				case "sendSMS" : System.out.println(m.to + "님에게 문자"); break;
				case "sendkakao" : System.out.println(m.to + "님에게 카톡"); break;
			}
		}
		
	}
}
