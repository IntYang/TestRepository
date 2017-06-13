package coap.exam02.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

public class CoapResource02Client {
	//Field
	private CoapClient coapClient;
	
	//Constructor
	public CoapResource02Client(){
		coapClient = new CoapClient();
		coapClient.useCONs();
		//coapClient.useNONs()();
	}
	
	//Method
	public String get(int angle){ // json 방식으로 서버에 보낼 수가 없음
		String queryString ="kind=ultrasonicsensor&angle=" + angle;
		
		coapClient.setURI("coap://192.168.3.22/resource02?" + queryString);
		CoapResponse response = coapClient.get(); //서버에서 응답 오면 다음거 처리하게 (블로킹방식 = 동기방식)
		
		if(response == null){
			return get(angle); // 재귀호출
		}else{
		
			if(response.getCode() == CoAP.ResponseCode.CONTENT){ //코드가 정상 인지
				return response.getResponseText();
			}
		else { //컨텐트가 안실려있으면
			return get(angle); // 널리턴
		}
		}
	}
	
	public String post(int angle){
		//String queryString ="kind=ultrasonicsensor&angle=" + angle;
	  JSONObject jsonObject = new JSONObject();
		jsonObject.put("kind", "ultrasonicsensor");
		jsonObject.put("angle", angle);
		String json = jsonObject.toString();
		//System.out.println(json);
		coapClient.setURI("coap://192.168.3.22/resource02");
		CoapResponse response = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
		
		if(response == null){
			return post(angle); // 재귀호출
		}else{
		
			if(response.getCode() == CoAP.ResponseCode.CONTENT){ //코드가 정상 인지
				return response.getResponseText();
			}
		else { //컨텐트가 안실려있으면
			return post(angle); // 널리턴
		}
		}
		
		
		
		
	
	}
	
	
	
	
	
	public void shutdown(){
		coapClient.shutdown();
	}
	
	public static void main(String[] args) throws InterruptedException {
		CoapResource02Client client = new CoapResource02Client();

		for(int i=0;i<=180;i+=10){
			String text = client.post(i);
				System.out.println(i+ " 각도 거리: " + text);
			
		}
		
			
				
	
	
		client.shutdown();
	}
	
}
