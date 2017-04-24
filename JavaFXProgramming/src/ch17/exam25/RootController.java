package ch17.exam25;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class RootController implements Initializable {

	 @FXML
	 private MediaView mediaView;
	 @FXML
	 private Button btnPlay;
	 @FXML
	 private Button btnPause;
	 @FXML
	 private Button btnStop;

	 private boolean endOfMedia;

	 @FXML
	 private Slider sliderVolumn;
	 @FXML
	 private ProgressBar progressBar;
	 @FXML
	 private ProgressIndicator progressIndicator;
	 @FXML
	 private Label labelTime;
	 @FXML
	 private Slider timeSlider;

	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
			Media media = new Media(getClass().getResource("media/video.m4v").toString());
			//Media media = new Media(getClass().getResource("media/audio.wav").toString());
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			// 동영상을 보여주는 미디어 뷰 등록 -> 미디어 플레어 상태에 따라 동영상 보여주겠다는 의미
			// 음악파일일 경우 미디어뷰 필요읎다
			mediaView.setMediaPlayer(mediaPlayer);

			// 곧바로 레디에서 플레이 불가능 하므로 Runnable 객체로 레디 셋팅해줌
			mediaPlayer.setOnReady(() -> {
				 // 재생버튼 활성화
				 btnPlay.setDisable(false);
				 btnPause.setDisable(true);
				 btnStop.setDisable(true);
				 // 시간 라벨 초기화값
				 labelTime.setText("0 " + "/" + (int) mediaPlayer.getTotalDuration().toSeconds() + "초");
			});

			//재생이 되고 있으면 다른 버튼 활성화
			mediaPlayer.setOnPlaying(() -> {
				 btnPlay.setDisable(true);
				 btnPause.setDisable(false);
				 btnStop.setDisable(false);
			});

			// 중지 했으면 다른 버튼 활성화
			mediaPlayer.setOnPaused(() -> {
				 btnPlay.setDisable(false);
				 btnPause.setDisable(true);
				 btnStop.setDisable(false);
			});

			// stop 했을 때 다른 버튼 활성화
			mediaPlayer.setOnStopped(() -> {
				 btnPlay.setDisable(false);
				 btnPause.setDisable(true);
				 btnStop.setDisable(true);
			});

			//
			mediaPlayer.setOnEndOfMedia(() -> {
				 endOfMedia = true;
				 btnPlay.setDisable(false);
				 btnPause.setDisable(true);
				 btnStop.setDisable(true);
				 // vprogress indicator 와 bar 100프로 나오게 강제적으로맞춤
				 progressBar.setProgress(1.0);
				 progressIndicator.setProgress(1.0);
			});

			// 버튼 들의 각각 이벤트 처리
			btnPlay.setOnAction(event -> {

				 if (endOfMedia) { // 재생시간 다 끝났으면
						// 재생시간 앞으로 돌리기
						mediaPlayer.stop();
						mediaPlayer.seek(mediaPlayer.getStartTime()); // 시작 시간으로 돌아가라
				 }
				 mediaPlayer.play();
				 endOfMedia = false;
			});

			btnPause.setOnAction(event -> mediaPlayer.pause());
			btnStop.setOnAction(event -> mediaPlayer.stop());

			// 볼륨 슬라이더 속성 감시
			sliderVolumn.valueProperty().addListener(new ChangeListener<Number>() {
				 @Override
				 public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						// 슬라이더 변경된 값이 newValue로 들어옴
						// newValue의 범위 0~100
						// Volumn 범위는 0~1 이므로 매핑 필요
						mediaPlayer.setVolume(newValue.doubleValue() / 100.0);
				 }
			});

			sliderVolumn.setValue(50); // 속성 감시 한 다음에 기본값 설정해야 동기화됨

			// 재생 시간 속성 감시
			mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
				 @Override
				 public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
						//출력되는지 확인
						//System.out.println(newValue.toSeconds());

						//progressBar도 범위 0~1
						//음악 파일의 전체 재생 시간을얻기위해서는 currentTime
						//60초로 매핑하면 newValue.toSeconds/60.0
						//음악 파일의 전체 재생 시간
						double progress = newValue.toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
						progressBar.setProgress(progress);
						progressIndicator.setProgress(progress);

						// 타임 슬라이드의 전체 재생 시간
						timeSlider.setValue((newValue.toSeconds() / mediaPlayer.getTotalDuration().toSeconds()) * 100);

						// 시간 라벨 타임 바꾸기
						labelTime.setText((int) newValue.toSeconds() + "/" + (int) mediaPlayer.getTotalDuration().toSeconds() + "초");

				 }

			});
/*
			// 타임 슬라이더 속성 감시
			timeSlider.valueProperty().addListener(new ChangeListener<Duration>() {
				 @Override
				 public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
						// 재생 시간을 받아와서
						Duration d = Duration.seconds((newValue.toSeconds() * mediaPlayer.getTotalDuration().toSeconds()) / 100);
						// 타임 슬라이더가 움직이고 있으면
						if (timeSlider.isValueChanging()) {
							 mediaPlayer.seek(d);//슬라이더가 이동한 위치로 이동
						}
						else {
							 if(Math.abs(oldValue - newValue)>0.5)
							 {
                        mediaPlayer.seek(d);
							 }
						}

				 }
			});
			*/
			timeSlider.valueProperty().addListener((observable, oldValue, newValue)->{
						Duration d = Duration.seconds((newValue.doubleValue() * mediaPlayer.getTotalDuration().toSeconds()) / 100);
						// 타임 슬라이더가 움직이고 있으면
						if (timeSlider.isValueChanging()) {
							 mediaPlayer.seek(d);//슬라이더가 이동한 위치로 이동
						}
						else {
							 if(Math.abs(oldValue.doubleValue() - newValue.doubleValue())>0.5)
							 {
                        mediaPlayer.seek(d);
							 }
						}
					});
							
							
							
			
			
			

	 }

}
