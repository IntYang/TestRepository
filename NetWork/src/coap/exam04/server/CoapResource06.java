
package coap.exam04.server;

import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzor.ActiveBuzzor;
import hardware.converter.PCF8591;
import hardware.motor.PCA9685;
import hardware.sensor.GasSensor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoapResource06 extends CoapResource{
	
//Field
	private CoapClient coapClient;
	private PCF8591 pcf8591;
	private GasSensor gasSensor; 
	private ActiveBuzzor buzzor;
	String text = "정상";
	int value;
//Constructor
	public CoapResource06() throws Exception{
		super("resource06");
		pcf8591 = new PCF8591(0x48, PCF8591.AIN_2);
	  gasSensor = new GasSensor(pcf8591,RaspiPin.GPIO_23);
		buzzor = new ActiveBuzzor(RaspiPin.GPIO_24);
		
		//관찰 기능 활성화
		setObservable(true);
		//관찰 기능을 제공한다라는 것을 클라이언트가 알 수 있도록 설정
		getAttributes().setObservable();
		
		//테스트
		Thread thread = new Thread(){
			@Override
			public void run() {
				
				while(true){
					try {
						value = gasSensor.getValue();
						
						if(value > 150){
							text = "****가스검출";
							buzzor.on();
						 changed();
						}
						else{
							if(text.equals("****가스검출")){
								text="정상";
								changed();
								buzzor.off();
							}else{
								text="정상";
							
							}
						}
						
					} catch (Exception ex) {
					}
				
				
					try {
						Thread.sleep(1000);
					} catch (Exception ex) {}
				}
			}
		};
		thread.start();
		
		
		
	}
	
	
	@Override
	public void handleGET(CoapExchange exchange) {
		exchange.respond(text);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
