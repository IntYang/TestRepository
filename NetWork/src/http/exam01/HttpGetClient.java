package http.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

public class HttpGetClient {
	//Field
	//private HttpClient httpClient;

	//Constructor
	//Method
	public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
					URIBuilder uriBuilder = new URIBuilder("http://192.168.3.144:8080/IoTWebProgramming/http/exam01");
					uriBuilder.setParameter("thermistor", String.valueOf(25));
					uriBuilder.setParameter("photoresistor", String.valueOf(200));
          
					HttpGet httpGet = new HttpGet(uriBuilder.build()); //POST 방식 HttpPost으로 쓴다
          CloseableHttpResponse response = httpClient.execute(httpGet);//GET방식으로 통신하여 응답 받음
            try {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    InputStream is = resEntity.getContent();
                    try {
											String json = ""; // inputstream으로 받은 내용을 저장
											InputStreamReader isr = new InputStreamReader(is);
											BufferedReader br = new BufferedReader(isr); // 속도빨라짐, 한 행씩 읽을 수 있는 readLine쓰는 장점
										
											while(true){
												String data = br.readLine();
												if(data == null){
													break;
												}
												json += data;
											}
											JSONObject jsonObject = new JSONObject(json); // 파싱
											double thermistor= jsonObject.getDouble("thermistor");
											double photoresistor= jsonObject.getDouble("photoresistor");
											System.out.println("thermistor: "+thermistor);
											System.out.println("photoresistor: "+photoresistor);
                    } catch (Exception e) {
											e.printStackTrace();
                    } finally {
                        is.close();
                    }
                }
            } finally {
                response.close();
            }
        } catch(Exception e){
								e.printStackTrace();
								}finally {
            httpClient.close();
        }
	}
}
