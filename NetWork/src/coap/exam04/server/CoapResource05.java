
package coap.exam04.server;

import coap.exam04.client.CoapResource04Client;
import hardware.converter.PCF8591;
import hardware.sensor.ThermistorSensor;
import java.io.IOException;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoapResource05 extends CoapResource{
	
//Field
	private CoapClient coapClient;
	private  ThermistorSensor thermistorSensor;
	private int value;
	private CoapObserveRelation coapObserveRelation; 

//Constructor
	public CoapResource05(){
		super("resource05");
		
		PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN_1);
		thermistorSensor = new ThermistorSensor(pcf8591);
		
		
		
		//관찰 기능 활성화
		setObservable(true);
		//관찰 기능을 제공한다라는 것을 클라이언트가 알 수 있도록 설정
		getAttributes().setObservable();
		
		//테스트
		Thread thread = new Thread(){
			@Override
			public void run() {
				int i=0;
				while(true){
					value = i;
					changed();
					i++;
					try {
						Thread.sleep(1000);
					} catch (Exception ex) {}
				}
			}
		};
		thread.start();
}
	
	
	
		
	@Override
	public void handleGET(CoapExchange exchange){
		try{
			double value = thermistorSensor.getValue();
			exchange.respond("온도: 섭씨" + value + "도");
		}catch(Exception ex){ ex.printStackTrace();}
	}
	
	}
	

