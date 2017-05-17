package smarthomepanel.setting;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SettingScreenController implements Initializable {

	@FXML
	private Button btnBack;
	@FXML
	private Slider LightSlider;
	@FXML
	private Slider FontSlider;
	@FXML
	private ProgressIndicator LightProgress;
	@FXML
	private ProgressIndicator FontProgress;
	@FXML
	private Button btnHome;
	@FXML
	private AnchorPane ScreenControl;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnHome.setOnAction(e -> handleBtnHome(e));
		btnBack.setOnAction(e -> handleBtnBack(e));

		LightSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(LightSlider.getValue());
				LightProgress.setProgress(LightSlider.getValue() / 100);
			}
		});
		FontSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(FontSlider.getValue());
				FontProgress.setProgress(FontSlider.getValue() / 100);
			}
		});
	}

	private void handleBtnBack(ActionEvent e) {
		StackPane rootPane = (StackPane) btnHome.getScene().getRoot();
		ScreenControl.setOpacity(1);
		KeyValue keyValue = new KeyValue(ScreenControl.opacityProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500),
				event -> rootPane.getChildren().remove(ScreenControl),
				keyValue
		);
		Timeline timeLine = new Timeline();
		timeLine.getKeyFrames().add(keyFrame);
		timeLine.play();
	}

	private void handleBtnHome(ActionEvent e) {
		StackPane rootPane = (StackPane) btnHome.getScene().getRoot();
		//바로 홈으로 가기위해 중간에 Control.fxml 화면 미리 삭제
		rootPane.getChildren().remove(1);
		ScreenControl.setOpacity(1);
		KeyValue keyValue = new KeyValue(ScreenControl.opacityProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500),
				event -> rootPane.getChildren().remove(ScreenControl),
				keyValue
		);
		Timeline timeLine = new Timeline();
		timeLine.getKeyFrames().add(keyFrame);
		timeLine.play();
	}
}
