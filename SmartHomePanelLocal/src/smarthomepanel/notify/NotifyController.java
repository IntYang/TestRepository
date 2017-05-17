package smarthomepanel.notify;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class NotifyController implements Initializable {

	@FXML
	private TableView<Data> tableView;
	@FXML
	private Button btnBack;
	@FXML
	private Label lblTime;
	private boolean stop;
	@FXML
	private AnchorPane notifyControl;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnBack.setOnAction(e -> handleBtnBack());

		Thread thread = new Thread() {
			@Override
			public void run() {
				stop = false;
				SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm");
				while (!stop) {
					System.out.println("콜 스레드 동작");

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

		TableColumn tc0 = tableView.getColumns().get(0);
		TableColumn tc1 = tableView.getColumns().get(1);
		TableColumn tc2 = tableView.getColumns().get(2);

		System.out.println(tc0);
		System.out.println(tc1);
		System.out.println(tc2);

		tc0.setCellValueFactory(new PropertyValueFactory<Data, String>("date"));
		tc1.setCellValueFactory(new PropertyValueFactory<Data, String>("name"));
		tc2.setCellValueFactory(new PropertyValueFactory<Data, String>("content"));

		ObservableList<Data> list = FXCollections.observableArrayList();
		list.add(new Data("05/01", "관리사무소", "공지사항"));
		list.add(new Data("05/02", "관리사무소", "공지사항"));
		list.add(new Data("05/05", "관리사무소", "공지사항"));
		tableView.setItems(list);

		tableView.setOnMouseClicked(e -> {
			Data data = tableView.getSelectionModel().getSelectedItem();
			if (data != null) {
				System.out.println(data.getDate());
				System.out.println(data.getName());
				System.out.println(data.getContent());
			}

		});

	}

	private void handleBtnBack() {
		StackPane rootPane = (StackPane) btnBack.getScene().getRoot();
		notifyControl.setOpacity(1);
		KeyValue keyValue = new KeyValue(notifyControl.opacityProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), e -> rootPane.getChildren().remove(notifyControl), keyValue);
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
