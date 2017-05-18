
package hardware.button;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.io.IOException;

public class Button {
	//Field
	private GpioPinDigitalInput gpioPinDigitalInput;
	//Constructor
	public Button(Pin buttonPinNo){
		GpioController gpioController = GpioFactory.getInstance(); // 싱글톤으로 얻기 위해서
		gpioPinDigitalInput = gpioController.provisionDigitalInputPin(buttonPinNo);
		gpioPinDigitalInput.setShutdownOptions(true); // 입력 모드 해제
	}
	
	public void setGpioPinListenerDigital(GpioPinListenerDigital listener){
		gpioPinDigitalInput.addListener(listener);
	}
	//Method
	
	public static void main(String[] args) throws IOException {
		Button button = new Button(RaspiPin.GPIO_02);
		button.setGpioPinListenerDigital(new GpioPinListenerDigital(){
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event){
				if(event.getState() == PinState.HIGH){
					System.out.println("High");
				}else{
					System.out.println("Low");
				}
			}
		});
		System.out.println("ready...");
		System.in.read();
		
	}
}
