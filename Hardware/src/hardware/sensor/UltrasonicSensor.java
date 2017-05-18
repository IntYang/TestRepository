package hardware.sensor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UltrasonicSensor {

	//Field
	private GpioPinDigitalOutput trigPin;
	private GpioPinDigitalInput echoPin;

	private int previousDistance;
	private boolean again; // 재측정하면 true
	private int count;

	//Constructor
	public UltrasonicSensor(Pin trigPinNo, Pin echoPinNo) {
		GpioController gpioController = GpioFactory.getInstance();
		trigPin = gpioController.provisionDigitalOutputPin(trigPinNo);
		trigPin.setShutdownOptions(true, PinState.LOW);

		echoPin = gpioController.provisionDigitalInputPin(echoPinNo);
		echoPin.setShutdownOptions(true, PinState.LOW);

	}

	//Method
	public int getDistance() { // 거리 측정 메소드
		//초음파 발신 시간 변수와 수신 시간 변수 선언
		double start = 0;
		double end = 0;

		//펄스를 10마이크로초 동안 발생
		trigPin.high(); // 초음파 발생
		try {
			Thread.sleep(0, 10000); // 10 micro초
		} catch (InterruptedException ex) {
		}

		trigPin.low();// 발생 끝

		count = 0;
		//에코핀이 high될때 까지 계속 기다림
		while (echoPin.isLow()) { // echoPin이 Low 일 때 계속 돈다 // Low상태에서 High 상태로 언제 되냐 검사하는 것
			count++;
			if (count > 50000) {
				return getDistance();
			}
		}

		// 발신 시간 저장
		start = System.nanoTime();

		count = 0; //  무한정 기다리는 거 나오게 해줌
		// 에코핀이 low 될때까지 계속 기다림
		while (!echoPin.isLow()) {
			count++;
			if (count > 50000) {
				return getDistance();
			}
		}

		end = System.nanoTime();

// 편도 시간 
		double seconds = (end - start) / 1000000000 / 2;
// 거리 계산
		int distance = (int) (seconds * 34000);

   //100이상 튀는 값이 있을 경오 다시 측정
		if (again == false && Math.abs(previousDistance - distance) > 100) {
			again = true;
			getDistance(); //dummy : 가짜로한번 읽어보는 것
			distance = getDistance();
		}else{
			again = false;
		}
		
		//초과값 검사(2~400cm)
		if(distance<2){
			distance = 2;
		}
		else if(distance>400){
			distance = 400;
		}
		
		previousDistance = distance; // 다음 측정을 위해 저장

		return distance;
	}

	public static void main(String[] args) throws InterruptedException {
		UltrasonicSensor test = new UltrasonicSensor(RaspiPin.GPIO_00, RaspiPin.GPIO_01);
		while (true) {
			int distance = test.getDistance();
			System.out.println("거리(cm):" + distance);
			Thread.sleep(1000);

		}

	}

}
