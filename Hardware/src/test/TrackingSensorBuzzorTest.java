
package test;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzor.ActiveBuzzor;
import hardware.sensor.TrackingSensor;

public class TrackingSensorBuzzorTest {

	public static void main(String[] args) throws InterruptedException {
		ActiveBuzzor buzzor = new ActiveBuzzor(RaspiPin.GPIO_02);
		TrackingSensor trsensor = new TrackingSensor(RaspiPin.GPIO_00);
		System.out.println("ready...");
		while(true){
			if(trsensor.getStatus() == PinState.LOW){
				buzzor.on();
				
			}
			else{
				buzzor.off();
				
			}
		}
		
	
	}
	
}
