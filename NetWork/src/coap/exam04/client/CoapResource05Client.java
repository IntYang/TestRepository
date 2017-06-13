
package coap.exam04.client;

import java.io.IOException;
import java.util.Random;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
// 관찰 요청을 하는 클라이언트
public class CoapResource05Client {

	//Field
	private CoapClient coapClient;
	private CoapObserveRelation coapObserveRelation; 
	
	//Consturctor
	public CoapResource05Client(){
			coapClient = new CoapClient();
	}
	//Method
	public void observe(){
		coapClient.setURI("coap://192.168.3.22/resource05");
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
		CoapResource05Client client = new CoapResource05Client();
		client.observe();
		System.in.read();
		client.shutdown();
	}
}
