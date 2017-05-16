
package hardware.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;



public class RgbLed {
				
				
	//Field
	 // 디지털 출력 핀 객체 필드
	private GpioPinDigitalOutput redPin;
	private GpioPinDigitalOutput greenPin; 
	private GpioPinDigitalOutput bluePin; 
	
	//Constructor
	public RgbLed(Pin redPinNo, Pin greenPinNo, Pin bluePinNo){
		//GpioController 객체 얻기
		GpioController gpioController = GpioFactory.getInstance();
		//디지털 출력핀 생성
		redPin = gpioController.provisionDigitalOutputPin(redPinNo,PinState.HIGH);
		//jvm이 종료될 때 (어플리케이션 종료될 때) 출력 모드를 해제하고, 핀의 출력을 LOW로 한다.
		redPin.setShutdownOptions(true, PinState.LOW);
		
		greenPin = gpioController.provisionDigitalOutputPin(greenPinNo,PinState.HIGH);
		greenPin.setShutdownOptions(true,PinState.LOW);
		
		bluePin = gpioController.provisionDigitalOutputPin(bluePinNo,PinState.HIGH);
		bluePin.setShutdownOptions(true,PinState.LOW);
	}
	//Method
	
	public void red(){
		redPin.low();
		greenPin.high();
		bluePin.high();
		
	}	
	public void green(){
		redPin.high();
		greenPin.low();
		bluePin.high();
	}	
	public void blue(){
		redPin.high();
		greenPin.high();
		bluePin.low();
	}	
	
	
	public static void main(String[] args) throws InterruptedException {
		RgbLed test = new RgbLed(RaspiPin.GPIO_27, RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		//test.green();
		
	while(true){
			test.red();
			Thread.sleep(1000);
			test.green();
			Thread.sleep(1000);
			test.blue();
			Thread.sleep(1000);
		}
		
	}
}
