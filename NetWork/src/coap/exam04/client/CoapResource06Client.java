
package coap.exam04.client;

import java.io.IOException;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;

public class CoapResource06Client {
	
	
//Field
	private CoapClient coapClient;
	private CoapObserveRelation coapObserveRelation; 
	
	
//Consturctor
	public CoapResource06Client(){
		coapClient = new CoapClient();
	}
	
	
	
//Method
	
	//Method
	public void observe(){
		coapClient.setURI("coap://192.168.3.22/resource06");
		coapObserveRelation = coapClient.observe(new CoapHandler() {
			@Override
			public void onLoad(CoapResponse response) { //통보메시지 왔을 때
				String text = response.getResponseText();
				System.out.println(text);
			}

			@Override
			public void onError() { // 네트워크 불능일때
			}
		});
		
	}


public void shutdown(){
		coapObserveRelation.proactiveCancel(); // 서버에게 관찰기능 중지하라고 알려줌
		coapClient.shutdown(); // 클라이언트 안전 종료
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		CoapResource06Client client = new CoapResource06Client();
		client.observe();
		System.in.read();
		client.shutdown();
	}	
	

}
