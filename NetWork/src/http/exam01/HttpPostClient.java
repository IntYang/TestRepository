package http.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class HttpPostClient {
	//Field
	//private HttpClient httpClient;

	//Constructor
	//Method
	public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
				
          
					HttpPost httpPost = new HttpPost("http://192.168.3.144:8080/IoTWebProgramming/http/exam01"); //POST 방식 HttpPost으로 쓴다
          
					List<NameValuePair> params = new ArrayList<>(); // thermistor=25?photoresistor=200이걸 리스트 쌍으로 연결 
					params.add(new BasicNameValuePair("thermistor", String.valueOf(25)));
					params.add(new BasicNameValuePair("photoresistor", String.valueOf(200)));
					HttpEntity reqEntity = new UrlEncodedFormEntity(params,Charset.forName("UTF-8"));
					httpPost.setEntity(reqEntity);
					
					CloseableHttpResponse response = httpClient.execute(httpPost);//GET방식으로 통신하여 응답 받음
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
