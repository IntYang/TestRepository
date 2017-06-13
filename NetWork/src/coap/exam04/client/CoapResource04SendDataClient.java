
package coap.exam04.client;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

public class CoapResource04SendDataClient {

	//Field
	private CoapClient coapClient;
	//Consturctor
	public CoapResource04SendDataClient(){
			coapClient = new CoapClient();
	}
	//Method
	public void post(){
		coapClient.setURI("coap://192.168.3.22/resource04");
		Random random = new Random();
		while(true){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("value", random.nextInt(50));// 0~49 사이 임의의 정수
			String json = jsonObject.toString();
			coapClient.post(json,MediaTypeRegistry.APPLICATION_JSON);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {}
		}
	}
	
	public void shutdown(){
		coapClient.shutdown();
	}
	public static void main(String[] args) {
		CoapResource04SendDataClient client = new CoapResource04SendDataClient();
		client.post();
		client.shutdown();
	}
}
