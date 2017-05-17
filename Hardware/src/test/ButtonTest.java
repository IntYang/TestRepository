
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
import hardware.led.DualColorLed;
import java.io.IOException;

public class ButtonTest {
	//Field
	private GpioPinDigitalInput gpioPinDigitalInput;
	
	private GpioPinDigitalOutput redPin;
	private GpioPinDigitalOutput greenPin; 
	//Constructor
	public ButtonTest(Pin buttonPinNo){
		GpioController gpioController = GpioFactory.getInstance(); // 싱글톤으로 얻기 위해서
		gpioPinDigitalInput = gpioController.provisionDigitalInputPin(buttonPinNo);
		gpioPinDigitalInput.setShutdownOptions(true); // 입력 모드 해제
	}
	

	public void setGpioPinListenerDigital(GpioPinListenerDigital gpioPinlistener){
		gpioPinDigitalInput.addListener(gpioPinlistener);
	}

	//Method
	
	public static void main(String[] args) throws IOException, InterruptedException {
	//	ButtonTest button = new ButtonTest(RaspiPin.GPIO_00);
		DualColorLed dualColorLed = new DualColorLed(RaspiPin.GPIO_01, RaspiPin.GPIO_02);
		//dualColorLed.green();
		ButtonTest button = new ButtonTest(RaspiPin.GPIO_00);
		button.setGpioPinListenerDigital(new GpioPinListenerDigital(){
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event){
				//System.out.println(event.getState());
				if(event.getState() == PinState.HIGH){
					dualColorLed.green();
				}else{
					dualColorLed.red();
				}
			}
		});
		System.out.println("ready..");
		System.in.read();
	}
}
