
package sensingcar.coap.server.resource;

import com.pi4j.io.gpio.RaspiPin;
import hardware.laser.LaserEmitter;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LaserEmitterResource extends CoapResource {
//Field
private LaserEmitter lasorEmitter;
private String currStatus;
private static final Logger logger = LoggerFactory.getLogger(LaserEmitterResource.class);

//Constructor
public LaserEmitterResource() throws Exception{
	super("laseremitter"); // 리소스 식별명
	lasorEmitter = new LaserEmitter(RaspiPin.GPIO_25);
	stop();
}	


//Method-------------------

	private void shot(){
		lasorEmitter.shot();
		currStatus = "shot";
	}
	private void stop(){
		lasorEmitter.stop();
		currStatus = "stop";
	}

	@Override
	public void handleGET(CoapExchange exchange){
	}

	@Override
	public void handlePOST(CoapExchange exchange){
		//{"command":"change", "status":"on"}
		try {
			String requestJson = exchange.getRequestText();
			JSONObject requestJsonObject = new JSONObject(requestJson);
			String command = requestJsonObject.getString("command");
			if(command.equals("change")) {
				String status = requestJsonObject.getString("status");
				
				if(status.equals("shot")) shot();
				else if(status.equals("stop")) stop();
				
			} else if(command.equals("status")) {
			}
			JSONObject responseJsonObject = new JSONObject();
			responseJsonObject.put("result", "success");
			responseJsonObject.put("status", currStatus);
			String responseJson = responseJsonObject.toString();
			exchange.respond(responseJson);
		} catch(Exception e) {
			logger.info(e.toString());
			JSONObject responseJsonObject = new JSONObject();
			responseJsonObject.put("result", "fail");
			String responseJson = responseJsonObject.toString();
			exchange.respond(responseJson);
		}		
	
	}		
}
	
	

	
	
	

