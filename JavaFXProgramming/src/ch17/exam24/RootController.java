
package ch17.exam24;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class RootController implements Initializable {

    @FXML
    private MediaView mediaView;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPause;
    @FXML
    private Button btnStop;
    
    @FXML
    private boolean endOfMedia;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Media media = new Media(getClass().getResource("media/video.m4v").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        // 동영상을 보여주는 미디어 뷰 등록 -> 미디어 플레어 상태에 따라 동영상 보여주겠다는 의미
        // 음악파일일 경우 미디어뷰 필요읎다
        mediaView.setMediaPlayer(mediaPlayer);
       
        // 곧바로 레디에서 플레이 불가능 하므로 Runnable 객체로 레디 셋팅해줌
        mediaPlayer.setOnReady(()->{
            // 재생버튼 활성화
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
            });
        
        //재생이 되고 있으면 다른 버튼 활성화
        mediaPlayer.setOnPlaying(()->{
            btnPlay.setDisable(true);
            btnPause.setDisable(false);
            btnStop.setDisable(false);
        });
        
        // 중지 했으면 다른 버튼 활성화
        mediaPlayer.setOnPaused(()->{
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(false);
        });
        
        // stop 했을 때 다른 버튼 활성화
        mediaPlayer.setOnStopped(()->{
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
        });
        
        //
        mediaPlayer.setOnEndOfMedia(()->{
            endOfMedia = true;
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
        });
        
        
        // 버튼 들의 각각 이벤트 처리
        btnPlay.setOnAction(event -> {
            
            if(endOfMedia){ // 재생시간 다 끝났으면
                // 재생시간 앞으로 돌리기
                mediaPlayer.stop();
                mediaPlayer.seek(mediaPlayer.getStartTime()); // 시작 시간으로 돌아가라
            }
            mediaPlayer.play();
            endOfMedia = false;
        });
        
        
        btnPause.setOnAction(event -> mediaPlayer.pause());
        btnStop.setOnAction(event -> mediaPlayer.stop());
        
        
    }    
    
}
