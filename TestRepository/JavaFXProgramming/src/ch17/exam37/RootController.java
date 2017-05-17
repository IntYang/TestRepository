package ch17.exam37;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class RootController implements Initializable {

    @FXML
    private Label lblTime;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnStop;

    private boolean stop;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnStart.setOnAction(e->handleBtnStart(e));
        btnStop.setOnAction(e->handleBtnStop(e));
    }    

    private void handleBtnStart(ActionEvent e) {
        stop = false;
        Thread thread = new Thread(){ // 스레드 생성
            @Override
            public void run() {

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // 현재 시간 정보를 문자열로 만들고(시분초)
                while(!stop){
                    String strTime = sdf.format(new Date());
                    
                    Platform.runLater(()->{
                         // UI를 바꾸는 작업 -> 현재 스레드 말고 나중 스레드가 실행해라(나중이라고 해봣자 엄청 조금있다가임)
                           lblTime.setText(strTime);
                    });
                    
                  
                    try{
                        Thread.sleep(100); // 0.1초간 쉬고
                    }
                    catch(Exception e){
                        
                    }
                }

            }
        };
        thread.setDaemon(true); // 데몬 스레드
        thread.start();
    }
    

    private void handleBtnStop(ActionEvent e) { // 시간을 멈추게 한다 = 스레드 멈추게
        stop = true;
    }
    
}
