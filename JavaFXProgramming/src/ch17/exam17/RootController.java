package ch17.exam17;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//0418 수업내용
public class RootController implements Initializable {

    @FXML
    private Button btnClose;

    @FXML
    private CheckBox cb1;

    @FXML
    private CheckBox cb2;

    @FXML
    private ImageView checkImageView;

    @FXML
    private ToggleGroup rbGroup;
    
    @FXML
    private RadioButton rb1;
    
     
    @FXML
    private RadioButton rb2;
    
     
    @FXML
    private RadioButton rb3;
            
    @FXML
    private ImageView radioImageView;
        

    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        btnClose.setGraphic(btnClose); // 이미지 넣는 코드 -> root에서 함
//         System.out.println(Thread.currentThread().getName());//자바 fx스레드
        //버튼 닫는 이벤트 처리
        btnClose.setOnAction(e -> {
            Platform.exit();

        });

        cb1.setOnAction(e -> {
            handleChkAction(e);

        });

        cb2.setOnAction(e -> {
            handleChkAction(e);

        });
        
        //how1 
        
        rbGroup.selectedToggleProperty().addListener((boservable, oldValue, newValue) -> {
        //    @Override
           // public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
               /*
                if(newValue == rb1){
                    radioImageView.setImage(new Image(getClass().getResource("images/BubbleChart.png").toString()));
                }
                else if(newValue == rb2){
                     radioImageView.setImage(new Image(getClass().getResource("images/BarChart.png").toString()));
                }
                else if(newValue == rb3){
                     radioImageView.setImage(new Image(getClass().getResource("images/AreaChart.png").toString()));
                } */
            String fileName = newValue.getUserData() + ".png";
             radioImageView.setImage(new Image(getClass().getResource("images/" + fileName).toString()));
           
               
              // Image image = new Image(getClass().getResource("images/" + newValue.getUserData().toString()+".png").toString());
              // radioImageView.setImage(image);
           // }
            
        });
                
                
                

    }

    public void handleChkAction(ActionEvent e) {

        if (cb1.isSelected() && cb2.isSelected()) {
            checkImageView.setImage(new Image(getClass().getResource("images/geek-glasses-hair.gif").toString()));
        } else if (cb1.isSelected()) {
            checkImageView.setImage(new Image(getClass().getResource("images/geek-glasses.gif").toString()));

        } else if (cb2.isSelected()) {
            checkImageView.setImage(new Image(getClass().getResource("images/geek-hair.gif").toString()
            ));
        } else {
            checkImageView.setImage(new Image(getClass().getResource("images/geek.gif").toString()));

        }

    }
    
}
