package coap.exam01.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;

public class CoapResource01Client {
	//Field
	private CoapClient coapClient;
	
	//Constructor
	public CoapResource01Client(){
		coapClient = new CoapClient();
	}
	
	//Method
	public String get(){
		coapClient.setURI("coap://192.168.3.22/resource01");
		CoapResponse response = coapClient.get(); //서버에서 응답 오면 다음거 처리하게 (블로킹방식)
		if(response.getCode() == CoAP.ResponseCode.CONTENT){ //코드가 정상 인지
			return response.getResponseText();
		}
		else { //컨텐트가 안실려있으면
			return null; // 널리턴
		}
	}
	
	public void shutdown(){
		coapClient.shutdown();
	}
	
	public static void main(String[] args) {
		CoapResource01Client client = new CoapResource01Client();
		String text = client.get();
		System.out.println(text);
		client.shutdown();
	}
	
}
