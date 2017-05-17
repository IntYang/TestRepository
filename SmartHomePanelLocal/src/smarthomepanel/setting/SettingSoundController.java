package smarthomepanel.setting;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SettingSoundController implements Initializable {

	@FXML
	private ComboBox<String> SelectBell;
	@FXML
	private Button btnBack;
	@FXML
	private Button btnHome;
	@FXML
	private Slider SoundSlider;
	@FXML
	private AnchorPane soundControl;
	@FXML
	private ProgressIndicator SoundProgress;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		ObservableList<String> value = FXCollections.observableArrayList();
		value.add("개");
		value.add("나");
		value.add("리");
		value.add("개");
		SelectBell.setItems(value);

		btnHome.setOnAction(e -> handleBtnHome(e));
		btnBack.setOnAction(e -> handleBtnBack(e));

		SoundSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(SoundSlider.getValue());
				SoundProgress.setProgress(SoundSlider.getValue() / 100);
			}
		});
	}

	private void handleBtnBack(ActionEvent e) {
		StackPane rootPane = (StackPane) btnHome.getScene().getRoot();
		soundControl.setOpacity(1);
		KeyValue keyValue = new KeyValue(soundControl.opacityProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500),
				event -> rootPane.getChildren().remove(soundControl),
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
		soundControl.setOpacity(1);
		KeyValue keyValue = new KeyValue(soundControl.opacityProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500),
				event -> rootPane.getChildren().remove(soundControl),
				keyValue
		);
		Timeline timeLine = new Timeline();
		timeLine.getKeyFrames().add(keyFrame);
		timeLine.play();
	}
}
