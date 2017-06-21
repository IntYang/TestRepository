
package sensingcar.coap.server.resource;

import com.pi4j.io.gpio.RaspiPin;
import hardware.motor.DCMotor;
import hardware.motor.PCA9685;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackTireResource extends CoapResource {
	//Field
	private DCMotor dcMotorLeft;
	private DCMotor dcMotorRight;
	private PCA9685 pca9685;
	private static final Logger logger = LoggerFactory.getLogger(BackTireResource.class);
	private final int maxStep = 4095;
	private final int minStep = 0;
	private int currStep;
	
	private String currdirection;
	
	//Constructor
public BackTireResource() throws Exception{
	super("backtire"); // 리소스 식별명
	pca9685 = PCA9685.getInstance();
	dcMotorLeft = new DCMotor(RaspiPin.GPIO_00, RaspiPin.GPIO_01, pca9685, PCA9685.PWM_05); // 0번 정방향 ,1번 역방향 ,PCA9685 채널
	dcMotorRight = new DCMotor(RaspiPin.GPIO_02, RaspiPin.GPIO_03, pca9685, PCA9685.PWM_04); // 0번 정방향 ,1번 역방향 ,PCA9685 채널
	forward();

}	



//Method---------------------

	//방향결정
	public void forward(){
		dcMotorLeft.forward();
		dcMotorRight.forward();
		currdirection = "forward";
	}
	public void backward(){
		dcMotorLeft.backward();
		dcMotorRight.backward();
		currdirection = "backward";	
	}

	public void setSpeed(int step){
		if(step < 0) step = minStep;
		if(step > 0) step = maxStep;
		currStep = step;
		dcMotorLeft.setSpeed(currStep);
		dcMotorRight.setSpeed(currStep);
		
	}
	
	public void stop(){
		dcMotorLeft.stop();
		dcMotorRight.stop();
	}

	@Override
	public void handleGET(CoapExchange exchange){
	}

	@Override
	public void handlePOST(CoapExchange exchange){
		// 얻어내는 형식 예
		//{"command":"change","direction":"forward","speed":"1000"}
	
			try{
				String requestJson = exchange.getRequestText(); 
				JSONObject requestJsonObject = new JSONObject(requestJson);
				String command = requestJsonObject.getString("command");
		
				if(command.equals("change")){
					String reqDirection = requestJsonObject.getString("direction");
				int reqSpeed = Integer.parseInt(requestJsonObject.getString("speed"));
				if(reqDirection.equals("forward")){
					forward();
				}else if(reqDirection.equals("backward")){
					backward();
				}
			setSpeed(reqSpeed);
			}
			else if(command.equals("status")){
			}
		
			JSONObject responseJsonObect = new JSONObject();
			responseJsonObect.put("result", "success");
			responseJsonObect.put("direction", currdirection);
			responseJsonObect.put("speed", String.valueOf(currStep));
			String responseJson = responseJsonObect.toString();
			exchange.respond(responseJson);
		}catch(Exception e){
			logger.info(e.toString());
			JSONObject responseJsonObect = new JSONObject();
		responseJsonObect.put("result", "fail");
		responseJsonObect.put("direction", currdirection);
		responseJsonObect.put("speed", String.valueOf(currStep));
		String responseJson = responseJsonObect.toString();
		exchange.respond(responseJson);
		}
		
	
		
	}
	
	
	
}
