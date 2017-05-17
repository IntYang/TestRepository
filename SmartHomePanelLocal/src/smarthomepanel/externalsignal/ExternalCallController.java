package smarthomepanel.externalsignal;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ExternalCallController implements Initializable {

	@FXML
	private TextField txtDong;
	@FXML
	private TextField txtHo;
	private Socket socket;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		startClient();

	}

	private void startClient() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// Socket 생성
					socket = new Socket();
					// Server와 연결하기
					socket.connect(new InetSocketAddress("192.168.3.125", 50001));
					// 연결 성공 출력하기
					System.out.println("연결성공");
					// 데이터받기
				} catch (IOException ex) {
					stopClient();
					return;
				}
			}
		};
		thread.start();
	}

	private void stopClient() {
		try {
			System.out.println("클라이언트 정상 종료");
			socket.close();
		} catch (IOException ex) {
			System.out.println("소켓 안닫힘");
		}
	}

	private void send(String str) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					OutputStream os = socket.getOutputStream();
					byte[] byteArr = str.getBytes();
					os.write(byteArr);
					os.flush();
					os.close();
					txtDong.clear();
					txtHo.clear();
				} catch (IOException e) {
					try {
						socket.close();
					} catch (IOException ex) {
					}
				}
				stopClient();
				startClient();
			}
		};
		thread.start();
	}

	@FXML
	private void handleBtnCall() {
		send(txtDong.getText() + ":" + txtHo.getText());
	}

}
