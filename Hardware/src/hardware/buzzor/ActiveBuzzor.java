
package hardware.buzzor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class ActiveBuzzor {
//부저는 출력 장치
	//Field
	private GpioController gpioController;
	private GpioPinDigitalOutput buzzorPin;
	private String status = "off";
	//Contructor
	public ActiveBuzzor(Pin buzzorPinNo){
		gpioController = GpioFactory.getInstance();
		buzzorPin = gpioController.provisionDigitalOutputPin(buzzorPinNo,PinState.HIGH); //  첨에 핀 상태 하이그
		buzzorPin.setShutdownOptions(false,PinState.HIGH); // true 주면 출력모드 해제한다.
		// false : 출력모드 상태에서 그대로 내버려 두겠다. 출력이 계속 나오는 상태  == HIGH상태
		// 소리 안나게 할려고
	}
	//method
	public void on(){
		buzzorPin.low();
		status="on";
	}
	public void off(){
	  buzzorPin.high();
		status="off";
	}
	public String getStatus(){
		return status;
	}
	
	public static void main(String[] args) throws InterruptedException {
		ActiveBuzzor buzzor = new ActiveBuzzor(RaspiPin.GPIO_02);
		for(int i=0;i<5;i++){
			Thread.sleep(1000);
			buzzor.on();
			Thread.sleep(1000);
			buzzor.off();
			
		}
	}
}
