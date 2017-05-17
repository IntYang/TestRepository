
package test;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.led.RgbLed;
import hardware.button.Button;
import java.io.IOException;
public class RgbTest {
	private GpioPinDigitalOutput rgb;
	

	public static void main(String[] args) throws IOException {
		
	  Button button1 = new Button(RaspiPin.GPIO_00);
		Button button2 = new Button(RaspiPin.GPIO_02);
		Button button3 = new Button(RaspiPin.GPIO_03);
		
		RgbLed rgbLed = new RgbLed(RaspiPin.GPIO_27,RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		
		button1.setGpioPinListenerDigital(new GpioPinListenerDigital(){
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event){
				
				if(event.getState() == PinState.HIGH){
					rgbLed.red(true);
				}else{
					rgbLed.red(false);
				}
			}
		});
		button2.setGpioPinListenerDigital(new GpioPinListenerDigital(){
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event){
				
				if(event.getState() == PinState.HIGH){
					rgbLed.green(true);
				}else{
					rgbLed.green(false);
				}
			}
		});
		button3.setGpioPinListenerDigital(new GpioPinListenerDigital(){
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event){
				
				if(event.getState() == PinState.HIGH){
					rgbLed.blue(true);
				}else{
					rgbLed.blue(false);
				}
			}
		});
		
		System.out.println("ready...");
		System.in.read();
	}
	
	
}
