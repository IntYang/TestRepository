
package ch17.exam28;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
  File file = fileChooser.showOpenDialog(primaryStage);
  
        // 오픈했을 때 리턴하는 것 파일 경로
        System.out.println(file.getPath());
        
    }

    @FXML
    private void handleSaveFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
//how1        File file = fileChooser.showSaveDialog(AppMain.primaryStage);
        
 //how2       File file = fileChooser.showSaveDialog(primaryStage);
 
//how3
        /*
        Button button = (Button) event.getSource();
        Scene scene = button.getScene();
        Stage stage = (Stage)scene.getWindow(); // 주 스테이지 얻는 것
        File file = fileChooser.showSaveDialog(stage);
        */
        File file = fileChooser.showSaveDialog(primaryStage);
        
        System.out.println(file.getPath());
    }

    @FXML
    private void handleDirectoryFileChooser(ActionEvent event) {
   
        DirectoryChooser directoryChooser =  new DirectoryChooser();
        File file = directoryChooser.showDialog(((Button)event.getSource()).getScene().getWindow());
//         File file = fileChooser.showSaveDialog(((Button)event.getSource()).getScene().getWindow());
    }

    @FXML
    private void handlePopup(ActionEvent event) throws Exception {
        /*
        Popup popup = new Popup();
        // 팝업 xml의 최상위 element가 hbox이기 때문 -> 한 번 띄우면 계속 최 상위
        // 닫으려면
        // 1. 주윈도우 닫음 2. 버튼으로 타입 호출
        HBox hbox = (HBox)FXMLLoader.load(getClass().getResource("popup.fxml"));
        ImageView imgMessage = (ImageView)hbox.lookup("#imgMessage");
        Label lblMeassage = (Label) hbox.lookup("#lblMessage");
                
        popup.getContent().add(hbox);
       //팝업 자동으로 없어지게
        popup.setAutoHide(true);
        popup.show(AppMain.primaryStage);
*/
//      showNotification("알림", "메시지 도착");
        showNotification("경고", "도둑놈");
    }
    
    private void showNotification(String type, String message) throws Exception{
    
    Popup popup = new Popup();
        // 팝업 xml의 최상위 element가 hbox이기 때문 -> 한 번 띄우면 계속 최 상위
        // 닫으려면
        // 1. 주윈도우 닫음 2. 버튼으로 타입 호출
        HBox hbox = (HBox)FXMLLoader.load(getClass().getResource("popup.fxml"));
        ImageView imgMessage = (ImageView)hbox.lookup("#imgMessage");
        Label lblMessage = (Label) hbox.lookup("#lblMessage");
         
        // 메시지에 따라ㅏ 이미지 바뀌게
        if(type.equals("알림")){
            imgMessage.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
        }
        else if(type.equals("경고")){
            imgMessage.setImage(new Image(getClass().getResource("images/dialog-warning.png").toString()));
        }
        
        lblMessage.setText(message);
        
        popup.getContent().add(hbox);
        //팝업 자동으로 없어지게
        popup.setAutoHide(true);
        popup.show(AppMain.primaryStage);
    
    }

    @FXML
    private void handleCustom(ActionEvent event) throws IOException {

/*
//        Stage dialog = new Stage(StageStyle.DECORATED);
  //      Stage dialog = new Stage(StageStyle.UNDECORATED);
        //Stage dialog = new Stage(StageStyle.TRANSPARENT);// 배경이 투명인데 왜 투명으로 안나오니//아마 투명처리가 안되어서 그럴 것
//        Stage dialog = new Stage(StageStyle.UNIFIED);
        Stage dialog = new Stage(StageStyle.TRANSPARENT);
        Parent parent = FXMLLoader.load(getClass().getResource("custom-dialog.fxml"));
        Scene scene = new Scene(parent);
        scene.setFill(Color.TRANSPARENT); // 투명 코드
        dialog.setScene(scene); // 이거 주석처리하면 투명 처리
        dialog.initOwner(AppMain.primaryStage); //주소유자 윈도우 지정
        dialog.initModality(Modality.WINDOW_MODAL); // 모달
        dialog.show();
    */
        showCustomDialog("error", "NETWORK ERROR");
        
        
    
    }
    
    
    private void showCustomDialog(String type, String message)throws IOException{
        //        Stage dialog = new Stage(StageStyle.DECORATED);
  //      Stage dialog = new Stage(StageStyle.UNDECORATED);
        //Stage dialog = new Stage(StageStyle.TRANSPARENT);// 배경이 투명인데 왜 투명으로 안나오니//아마 투명처리가 안되어서 그럴 것
//        Stage dialog = new Stage(StageStyle.UNIFIED);
        Stage dialog = new Stage(StageStyle.TRANSPARENT);
        Parent parent = FXMLLoader.load(getClass().getResource("custom-dialog.fxml"));
        
        ImageView icon = (ImageView) parent.lookup("#icon");
        Label lblmessage = (Label) parent.lookup("#message");
        Button btnOK = (Button) parent.lookup("#btnOK");
        
        if(type.equals("error")){
             icon.setImage(new Image(getClass().getResource("images/dialog-error.png").toString()));
        }
        else if(type.equals("help")){
             icon.setImage(new Image(getClass().getResource("images/dialog-help.png").toString()));
        }
        else if(type.equals("info")){
             icon.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
        }
        else if(type.equals("warning")){
             icon.setImage(new Image(getClass().getResource("images/dialog-warning.png").toString()));
        }
        
        lblmessage.setText(message);
        
        btnOK.setOnAction(e->{ dialog.hide();});
        
        
        Scene scene = new Scene(parent);
         scene.setFill(Color.TRANSPARENT);
        
        dialog.setScene(scene); // 이거 주석처리하면 투명 처리
      
        dialog.initOwner(AppMain.primaryStage); //주소유자 윈도우 지정
        dialog.initModality(Modality.WINDOW_MODAL); // 모달
        dialog.show();
    }

    
    
}
