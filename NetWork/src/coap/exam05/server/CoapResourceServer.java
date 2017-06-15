package coap.exam05.server;

import coap.exam04.server.*;
import coap.exam02.server.*;
import coap.exam01.server.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.proxy.DirectProxyCoapResolver;
import org.eclipse.californium.proxy.ProxyHttpServer;
import org.eclipse.californium.proxy.resources.ForwardingResource;
import org.eclipse.californium.proxy.resources.ProxyCoapClientResource;
import org.eclipse.californium.proxy.resources.ProxyHttpClientResource;

public class CoapResourceServer {
	//Field
	private CoapServer coapServer;
	
	//Constructor
	public CoapResourceServer() throws Exception{
		coapServer = new CoapServer();
		InetSocketAddress isa1 = new InetSocketAddress("192.168.3.22",5683); // IP를 지정해서 코앱서버객체만듦
		InetSocketAddress isa2 = new InetSocketAddress("localhost",5683);
		coapServer.addEndpoint(new CoapEndpoint(isa1));
		coapServer.addEndpoint(new CoapEndpoint(isa2));
		coapServer.add(new CoapResource01());// 온도 센서
		coapServer.add(new CoapResource02());// 초음파 서보모터
		coapServer.add(new CoapResource03());// 관찰기능 제공
		coapServer.add(new CoapResource04());// 외부에서 값을 받아 관찰 요청 클라이언트에게 전달
	  coapServer.add(new CoapResource05());
		coapServer.add(new CoapResource06());
		
		
		//coap->coap 프록시 설정
		ForwardingResource coap2coap = new ProxyCoapClientResource("coap2coap");
		coapServer.add(coap2coap);
		
		//http->coap 포워드 프록시 설정, 내부적으로
		ProxyHttpServer httpServer = new ProxyHttpServer(9090);
		//proxy에서 coap://ip 주소/coap2coap의 coap2coap의 이름을 알게 해주는 역할
		httpServer.setProxyCoapResolver(new DirectProxyCoapResolver(coap2coap)); 
		
		
		coapServer.start();
	}
	
	//Method
	public void shutdown() {
		coapServer.stop();
		coapServer.destroy();
	}
	
	public static void main(String[] args) throws IOException, Exception {
		CoapResourceServer server = new CoapResourceServer();
		System.out.println("CoAP server is listening on port 5683");
		System.in.read();
		server.shutdown();
	}

}
