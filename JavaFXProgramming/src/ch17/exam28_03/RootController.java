
package ch17.exam28_03;

import ch17.exam28.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

// how2가 정석적인 방법이긴 함.
public class RootController implements Initializable {
    
  private Stage primaryStage; // 필드 선언
    
  /*  
//셋터 생성 -> primaryStage 주입 시켜줌.
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
  */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    @FXML
    private void handleOpenFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
// how1       File file = fileChooser.showOpenDialog(AppMain.primaryStage);
       
  //how2       
  //File file = fileChooser.showOpenDialog(primaryStage);
  File file = fileChooser.showOpenDialog(((Button)event.getSource()).getScene().getWindow());
        // 오픈했을 때 리턴하는 것 파일 경로
        System.out.println(file.getPath());
        
    }

    @FXML
    private void handleSaveFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
//how1        File file = fileChooser.showSaveDialog(AppMain.primaryStage);
        
 //how2       File file = fileChooser.showSaveDialog(primaryStage);
 
//how3
     
        Button button = (Button) event.getSource();
        Scene scene = button.getScene();
        Stage stage = (Stage)scene.getWindow(); // 주 스테이지 얻는 것
        File file = fileChooser.showSaveDialog(stage);
        
        //File file = fileChooser.showSaveDialog(primaryStage);
        
        System.out.println(file.getPath());
    }

    @FXML
    private void handleDirectoryFileChooser(ActionEvent event) {
   
        DirectoryChooser directoryChooser =  new DirectoryChooser();
        File file = directoryChooser.showDialog(((Button)event.getSource()).getScene().getWindow());
//         File file = fileChooser.showSaveDialog(((Button)event.getSource()).getScene().getWindow());
    }

    @FXML
    private void handlePopup(ActionEvent event) {
    }

    @FXML
    private void handleCustom(ActionEvent event) {
    }

    
    
}
