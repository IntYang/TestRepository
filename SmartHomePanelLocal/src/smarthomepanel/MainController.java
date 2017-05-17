package smarthomepanel;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class MainController implements Initializable {

    @FXML
    private Button btnVideo;
    @FXML
    private Button btnControl;
    @FXML
    private Button btnConsumed;
    @FXML
    private Button btnNotice;
    @FXML
    private Button btnSetting;
    @FXML
    private Button btnCall;

    @FXML
    private Label lblTime;
    @FXML
    private StackPane stackPane;
    @FXML
    private MediaPlayer mediaPlayer;
    @FXML
    private ImageView packImage;

    private ExecutorService executorService;
    private ServerSocket serverSocket;
    private boolean packNotice = true;
    private Task<Void> task;

    public void setPackNotice(boolean packNotice) {
        this.packNotice = packNotice;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startServer();

        //시간정보 설정
        Thread thread = new Thread() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm");
                while (true) {
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

        //택배알림
        if (packNotice == true) {
            task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Platform.runLater(() -> {
                        FadeTransition ft = new FadeTransition(Duration.millis(700), packImage);
                        ft.setFromValue(1.0);
                        ft.setToValue(0.1);
                        ft.setCycleCount(Timeline.INDEFINITE);
                        ft.setAutoReverse(true);
                        ft.play();
                    });
                    return null;
                }
            };
            Thread threadPack = new Thread(task);
            threadPack.setDaemon(true);
            threadPack.start();
        }

        // packNotice가 false가 되면 cancel
        if (packNotice == false) {
            task.cancel();
        }
        //버튼 눌렀을 때 화면 전환
        btnCall.setOnAction(e -> handleBtnCall(e));
        btnVideo.setOnAction(e -> handleBtnVideo(e));
        btnControl.setOnAction(e -> handleBtnControl(e));
        btnConsumed.setOnAction(e -> handleBtnConsumed(e));
        btnNotice.setOnAction(e -> handleBtnNotice(e));
        btnSetting.setOnAction(e -> handleBtnSetting(e));

    }

    private void handleBtnCall(ActionEvent e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("call/Call.fxml"));
            stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Call.fxml이 쌓인다

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void handleBtnConsumed(ActionEvent e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("chart/Chart.fxml"));
            stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Chart.fxml이 쌓인다

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleBtnVideo(ActionEvent e) { // suyang
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("video1/Video1.fxml"));
            stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Vidio.fxml이 쌓인다

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleBtnControl(ActionEvent e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("control/Control.fxml"));
            stackPane.getChildren().add(parent);

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleBtnNotice(ActionEvent e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("notify/Notify.fxml"));
            stackPane.getChildren().add(parent);

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleBtnSetting(ActionEvent e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("setting/Setting.fxml"));
            stackPane.getChildren().add(parent);

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void startServer() {
        // 스레드풀 생성
        executorService = Executors.newFixedThreadPool(100);

        // 서버 소켓 생성
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("192.168.219.136", 50001));

        } catch (IOException ex) {
            stopServer();
            return;
        }

        // 연결 수락 작업 정의
        Runnable acceptTask = () -> {
            System.out.println("서버 시작..");
            while (true) {
                try {
                    // 수락 코드
                    Socket socket = serverSocket.accept();
                    // 통신용 External 객체 생성
                    External external = new External(socket);
                    // 총 Client 수 출력
                } catch (IOException ex) {
                    stopServer();
                    break;
                }
            }
        };
        // 스레드풀의 작업큐에 작업 넣기
        executorService.submit(acceptTask);
    }

    public void stopServer() {
        try {
            // how1
//			for (Client client : connections) {
//				client.socket.close();
//			}
//			connections.clear();

            // how2
//			Iterator<Client> iterator = connections.iterator();
//			while (iterator.hasNext()) {
//				Client client = iterator.next();
//				client.socket.close();
//				iterator.remove();
//			}
            if (executorService != null) {
                executorService.shutdownNow();
                serverSocket.close();
            }
        } catch (IOException ex) {
        }
        System.out.println("서버 종료");
    }

    class External {

        Socket socket;

        public External(Socket socket) {
            this.socket = socket;
            receive();
        }

        public void receive() {
            // 받기 작업 정의
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            InputStream inputStream = socket.getInputStream();
                            byte[] byteArr = new byte[100];
                            int readBytes = inputStream.read(byteArr);
                            if (readBytes == -1) {
                                throw new Exception();
                            }
                            String str = new String(byteArr, 0, readBytes);
                            if (str.contains(":")) {
                                strStringToken(str);
                            }

                        }
                    } catch (Exception e) {
                        try {
                            System.out.println("서버 소켓 종료");
                            socket.close();
                        } catch (IOException ex) {
                        }
                    }
                }

            };
            thread.start();
        }
    }

    private void ExternalCallDialog(String Dong, String Ho) throws IOException {
        Stage dialog = new Stage(StageStyle.TRANSPARENT);
        Parent parent = FXMLLoader.load(getClass().getResource("call/ExternalCallDialog.fxml"));

        Media media = new Media(getClass().getResource("audio.wav").toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        Button dialogBtnClose = (Button) parent.lookup("#dialogBtnClose");
        Label lblDong = (Label) parent.lookup("#lblDong");
        Label lblHo = (Label) parent.lookup("#lblHo");

        lblDong.setText(Dong);
        lblHo.setText(Ho);

        dialogBtnClose.setOnAction(e -> {
            mediaPlayer.stop();
            mediaPlayer.dispose();

            dialog.close();
            System.gc();
        });

        Scene scene = new Scene(parent);
        scene.setFill(Color.TRANSPARENT);
        dialog.setScene(scene);
        dialog.initOwner(lblTime.getScene().getWindow());
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setX(lblTime.getScene().getWindow().getX() + lblTime.getScene().getWindow().getWidth() / 4);
        dialog.setY(lblTime.getScene().getWindow().getY() + lblTime.getScene().getWindow().getHeight() / 3.6);
        dialog.show();

    }

    private void strStringToken(String str) throws IOException {
        StringTokenizer st = new StringTokenizer(str, ":");
        String Dong = st.nextToken();
        String Ho = st.nextToken();
        Platform.runLater(() -> {
            try {
                ExternalCallDialog(Dong, Ho);
            } catch (IOException ex) {
            }
        });
    }
}
