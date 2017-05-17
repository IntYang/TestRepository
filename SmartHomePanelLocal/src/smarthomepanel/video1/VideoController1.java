package smarthomepanel.video1;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class VideoController1 implements Initializable {

	@FXML
	private StackPane videoControl;
	@FXML
	private ImageView imgScreen; // 화면 이미지뷰
	@FXML
	private Button btn_Back; // 뒤로 가기 버튼	
	@FXML
	private Label lblTime; // 시간 표시 라벨	
	@FXML
	private Button btn_BFront; // 동 앞 보기	버튼
	@FXML
	private ImageView imgBFront; // 동 앞 보기 버튼의 이미지뷰
	@FXML
	private Button btn_DFront; // 현관 앞 보기 버튼
	@FXML
	private ImageView imgDFront; // 현관 앞 보기 버튼의 이미지뷰
	@FXML
	private Button btn_PFront; // 주차장 앞 보기 버튼
	@FXML
	private ImageView imgPFront; // 주차장 앞 보기 버튼의 이미지뷰

	@FXML
	private Button btn_Call; // 전화 호출 버튼
	@FXML
	private ImageView imgCall; // 전화 호출 버튼의 이미지 뷰
	@FXML
	private Button btn_Door; // 문 열기 버튼
	@FXML
	private ImageView imgDoor; // 문 열기 버튼의 이미지뷰
	@FXML
	private Button btn_Siren; // 사이렌 버튼	
	@FXML
	private ImageView imgSiren; // 사이렌 버튼의 이미지뷰
	@FXML
	private Button btn_capture; // 화면 캡쳐 버튼
	@FXML
	private ImageView imgCapture; // 화면 캡쳐 버튼의 이미지뷰
	
	@FXML
	private Slider slider; // 음량 조절 슬라이더
	@FXML
	private Button btn_speaker; // 음량 키기 버튼
	@FXML
	private ImageView imgSpeaker; // 음량 키기 버튼의 이미지 뷰
	
	
	private boolean stop; // 스레드 플래그 
	
	Image closeddoor = new Image(getClass().getResource("images/icons/suyang/closeddoor4.png").toString());
	Image openeddoor = new Image(getClass().getResource("images/icons/suyang/open-exit-door.png").toString());
	Image bfront = new Image(getClass().getResource("images/icons/suyang/buildingfront.JPG").toString());
	Image dfront = new Image(getClass().getResource("images/icons/suyang/doorfront1.JPG").toString());
	Image pfront = new Image(getClass().getResource("images/icons/suyang/parkingfront.PNG").toString());
	
	@FXML
	private AnchorPane anchorpaneScreen;
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		


		// 버튼 이벤트 처리
	  btn_BFront.setOnAction(e -> handleBtnBFront(e));
	  btn_DFront.setOnAction(e -> handleBtnDFront(e));
		btn_PFront.setOnAction(e->handleBtnPark(e));
		
//		btn_Call.setOnAction(e->handleBtnCall(e));
//		btn_capture.setOnAction(e->handleBtnCapture(e));
//		btn_Siren.setOnAction(e->handleBtnSiren(e));
		btn_Door.setOnAction(e -> handleBtnOpen(e));
		
//		btn_speaker.setOnAction(e->handleBtnSpeaker(e));
		btn_Back.setOnAction(e -> handleBtnBack());
		
		

		//시간정보 설정
		Thread thread = new Thread() {
			@Override
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm");
				stop = false;
				while (!stop) {
					String strTime = sdf.format(new Date());
					Platform.runLater(() -> {
						lblTime.setText(strTime);
					});
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
					}
				}
			}
		};
		thread.start();
	}

	@FXML
	private void handleBtnOpen(ActionEvent e) {
		Button btn_Door = (Button) e.getSource();
		if ((btn_Door.getId()).equals("btn_Door")) {
			btn_Door.setId("btn_Door_Back");
			imgDoor.setImage(openeddoor);
		}else if((btn_Door.getId()).equals("btn_Door_Back")){
			btn_Door.setId("btn_Door");
			imgDoor.setImage(closeddoor);
		}
	}

	private void handleBtnBack() {
		StackPane rootPane = (StackPane) btn_Back.getScene().getRoot();
		videoControl.setOpacity(1);
		KeyValue keyValue = new KeyValue(videoControl.opacityProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), e -> rootPane.getChildren().remove(videoControl), keyValue);
		Timeline timeLine = new Timeline();
		timeLine.getKeyFrames().add(keyFrame);
		timeLine.play();
		stop = true;
		System.gc();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("-----------------------------------가비지 컬렉터-------------------------------------------");
	}

	@FXML
	private void handleBtnBFront(ActionEvent e1) {
		Button btn_BFront = (Button) e1.getSource();
		System.out.println((btn_BFront.getId()).toString());
		if((btn_BFront.getId()).equals("btn_BFront")) {
			imgScreen.setImage(bfront);
		} 
	}
	
	@FXML
	private void handleBtnDFront(ActionEvent e) {
		Button btn_DFront = (Button) e.getSource();
			System.out.println((btn_DFront.getId()).toString());
		if((btn_DFront.getId()).equals("btn_DFront")) {
			imgScreen.setImage(dfront);
		} 
	}

	@FXML
	private void handleBtnPark(ActionEvent e) {
		Button btn_PFront = (Button) e.getSource();
		if ((btn_PFront.getId()).equals("btn_PFront")) {
			imgScreen.setImage(pfront);
		} 
	}
	
}
