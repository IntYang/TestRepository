
package test;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.button.Button;
import hardware.buzzor.ActiveBuzzor;
import java.io.IOException;
public class BuzzorTest {
	
	private GpioPinDigitalOutput buzzor;
	public static void main(String[] args) throws IOException {
		ActiveBuzzor buzzor = new ActiveBuzzor(RaspiPin.GPIO_00);
		Button button1 = new Button(RaspiPin.GPIO_02);
		button1.setGpioPinListenerDigital(new GpioPinListenerDigital(){
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event){
				
				if(event.getState() == PinState.LOW){
					buzzor.on();
				}else{
					buzzor.off();
				}
			}
		});
		System.in.read();
	}

}
