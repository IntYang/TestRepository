package smarthomepanel.setting;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class SettingController implements Initializable {

	@FXML
	private Button btnSound;
	@FXML
	private Button btnScreen;
	@FXML
	private AnchorPane settingControl;
	@FXML
	private Button btnBack;
	@FXML
	private Label lblTime;
	private boolean stop;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		btnSound.setOnAction(e -> handleBtnSound(e));
		btnScreen.setOnAction(e -> handleBtnScreen(e));
		btnBack.setOnAction(e -> handleBtnBack());

		Thread thread = new Thread() {
			@Override
			public void run() {
				stop = false;
				SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm");
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

	private void handleBtnSound(ActionEvent e) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("SettingSound.fxml"));
			StackPane rootPane = (StackPane) btnSound.getScene().getRoot();
			rootPane.getChildren().add(parent);
			parent.setOpacity(0);
			KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
			Timeline timeLine = new Timeline();
			timeLine.getKeyFrames().add(keyFrame);
			timeLine.play();

		} catch (IOException ex) {
		}

	}

	private void handleBtnScreen(ActionEvent e) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("SettingScreen.fxml"));
			StackPane rootPane = (StackPane) btnScreen.getScene().getRoot();
			rootPane.getChildren().add(parent);
			parent.setOpacity(0);
			KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
			Timeline timeLine = new Timeline();
			timeLine.getKeyFrames().add(keyFrame);
			timeLine.play();

		} catch (IOException ex) {
		}

	}

	private void handleBtnBack() {
		StackPane rootPane = (StackPane) btnBack.getScene().getRoot();
		settingControl.setOpacity(1);
		KeyValue keyValue = new KeyValue(settingControl.opacityProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), e -> rootPane.getChildren().remove(settingControl), keyValue);
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

}
