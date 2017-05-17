
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Suyang
 */
public class RootController implements Initializable {

    @FXML
    private Button btn_call;
    @FXML
    private Button btn_show;
    @FXML
    private Button btn_door;
    
    @FXML
    private Label lblTime;

    @FXML
    private Button btn_home;
    @FXML
    private Button btn_allback;
    @FXML
    private ImageView screen;
    @FXML
    private Slider soundSlider;
    @FXML
    private ImageView btn_homeImage;
    @FXML
    private ImageView btn_callImage;
    @FXML
    private ImageView btn_showImage;
    
    @FXML
    private ImageView door;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //버튼 처리
        //1. 전화 버튼
        //선택: 문 앞 / 현관(동) 앞
        //음량 조절
        //시간정보 설정
        SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm");
        String strTime = sdf.format(new Date());
        lblTime.setText(strTime);
        
        btn_call.hoverProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue==true){
                    btn_callImage.setImage(new Image(getClass().getResourceAsStream("/images/icons/suyang/phone-call(blue).png")));
                }
                else{
                    btn_callImage.setImage(new Image(getClass().getResourceAsStream("/images/icons/suyang/phone-call.png")));
                }
            
            }
        });
        
        
        btn_call.setOnAction(event->handleBtnCall(event));
        btn_show.setOnAction(event->handleBtnShow(event));
        btn_door.setOnAction(event->handleBtnOpen(event));
        
       }
    
    @FXML
    public void handleBtnCall(ActionEvent e1){
        try{
            Stage dialog = new Stage(StageStyle.UTILITY);
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.initOwner(btn_call.getScene().getWindow());
            dialog.setTitle("통화 화면");
            
            Parent parent = FXMLLoader.load(getClass().getResource("callScreen.fxml"));
            
            Button btn_back1 = (Button) parent.lookup("#btn_back1");
            btn_back1.setOnAction(e->dialog.close());
            
            Scene scene = new Scene(parent);
            dialog.setScene(scene);
            dialog.setResizable(false);
            dialog.show();
            
        }catch(IOException ex){}
       
    }
    
    @FXML
    public void handleBtnShow(ActionEvent e2){
         Image outbuilding = new Image(getClass().getResourceAsStream("/images/icons/suyang/buildingfront.JPG"));
         Image inbuilding = new Image(getClass().getResourceAsStream("/images/icons/suyang/doorfront.png"));
         System.out.println(e2.getSource().toString());
          Button btn_show = (Button) e2.getSource();
       
          // screen.setImage(outbuiding);
           
           if((btn_show.getId()).equals("btn_show")){
            screen.setImage(outbuilding);
            btn_show.setId("btn_show_back");
            //System.out.println(e3.getSource().toString());
            System.out.println("동 앞");
           }
            else if((btn_show.getId()).equals("btn_show_back")){
            screen.setImage(inbuilding);
            btn_show.setId("btn_show");
//            System.out.println(e3.getSource().toString());
            System.out.println("현관 앞");
        }
            
       
    }
    @FXML
    public void handleBtnOpen(ActionEvent e3){
        Image closed_image = new Image(getClass().getResourceAsStream("/images/icons/suyang/closeddoor4.png"));
        Image opened_image = new Image(getClass().getResourceAsStream("/images/icons/suyang/open-exit-door.png"));
        Button btn_door = (Button) e3.getSource();
        System.out.println(e3.getSource().toString());
        
        
        if((btn_door.getId()).equals("btn_door")){
            door.setImage(opened_image);
            btn_door.setId("btn_door_back");
            //System.out.println(e3.getSource().toString());
            System.out.println("문이 열림");
        }
        else if((btn_door.getId()).equals("btn_door_back")){
            door.setImage(closed_image);
            btn_door.setId("btn_door");
//            System.out.println(e3.getSource().toString());
            System.out.println("문이 닫힘");
        }
    }
}

