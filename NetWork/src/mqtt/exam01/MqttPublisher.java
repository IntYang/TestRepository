
package mqtt.exam01;

import java.util.Date;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttPublisher {
	//Field
	private MqttClient mqttClient;
	private MqttCallback mqttCallback = new MqttCallback() {
		@Override // 연결 끊어졌을 때 자동 실행됨
		public void connectionLost(Throwable thrwbl) {
		}

		@Override
		public void messageArrived(String string, MqttMessage mm) throws Exception {
		}

		@Override
		public void deliveryComplete(IMqttDeliveryToken imdt) {
			System.out.println("deliveryComplete(): " + new Date());
		}
	};
	
	
	//Constructor
	public MqttPublisher() throws MqttException{
		//MQTT 클라이언트 생성
		//브로커의 주소
		mqttClient = new MqttClient("tcp://192.168.3.144:1883", MqttClient.generateClientId());
		//통신 결과에 따라 콜백 메소드를 실행할 콜백 객체 생성
		mqttClient.setCallback(mqttCallback);
		//MQTT 브로커와 연결하기
		mqttClient.connect();
	}
	
	//Method
	public void publish(String text) throws MqttException{
		//MQTT 브로커로 보내는 메시지 생성
		MqttMessage message = new MqttMessage(text.getBytes());
		//지정한 topic MQTT 브로커로 메시지 보냄
		mqttClient.publish("/devices/device1/temperature", message);
	}

	public void shutdown() throws MqttException{
	//MQTT 브로커와 연결 끊기
	 mqttClient.disconnect();
	//MqttClient가 사용한 리소스(메모리)를 해제
	 mqttClient.close();
	}
	
	public static void main(String[] args) throws Exception {
		MqttPublisher publisher = new MqttPublisher();
		//매 1초 단위로 온도 메시지를 보냄
		for(int i=1;i<20;i++){
			publisher.publish("상남자");
			Thread.sleep(1000);
		}
		//클라이언트 종료
		publisher.shutdown();
	}
}