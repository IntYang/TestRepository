
package test;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import hardware.sensor.UltrasonicSensor;
import hardware.button.Button;
import hardware.buzzor.ActiveBuzzor;
import java.io.IOException;

public class UltrasonicSensorTest {
	private GpioPinDigitalOutput buzzor;
	private GpioPinDigitalOutput trigPin;
	private GpioPinDigitalInput echoPin;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		ActiveBuzzor buzzor = new ActiveBuzzor(RaspiPin.GPIO_02);
		UltrasonicSensor ultrasonicSensor = new UltrasonicSensor(RaspiPin.GPIO_00, RaspiPin.GPIO_01);
		System.out.println("ready...");
	
		while(true){
			if(ultrasonicSensor.getDistance()<=20){
				buzzor.on();
			}
			
			else{
				buzzor.off();
			}
		}
		
		
//			System.in.read();
		
	}

}
