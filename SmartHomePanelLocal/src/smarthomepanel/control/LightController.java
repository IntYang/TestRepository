package smarthomepanel.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class LightController implements Initializable {

    @FXML
    private ImageView imgRoom1;
    @FXML
    private ImageView imgRoom2;
    @FXML
    private ImageView imgMain;
    @FXML
    private ImageView imgBig;
    @FXML
    private ImageView imgKitchen;
    @FXML
    private Button btnMain;
    @FXML
    private Button btnBig;
    @FXML
    private Button btnKitchen;
    @FXML
    private Button btnRoom1;
    @FXML
    private Button btnRoom2;
    @FXML
    private Button btnAllOff;
    @FXML
    private Button btnAllOn;
    @FXML
    private Button btnBack;
    @FXML
    private AnchorPane lightControl;
    @FXML
    private Button btnHome;
    Image switch_off = new Image(getClass().getResource("images/icons/control/light_off2.png").toString());
    Image switch_on = new Image(getClass().getResource("images/icons/control/light_on.png").toString());
    public static String Main="OFF";
    public static String Big="OFF";
    public static String Room1="OFF";
    public static String Room2="OFF";
    public static String Kitchen="OFF";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setting();
        btnMain.setOnAction(e -> handleBtnMain(e));
        btnBig.setOnAction(e -> handleBtnBig(e));
        btnKitchen.setOnAction(e -> handleBtnKitchen(e));
        btnRoom1.setOnAction(e -> handleBtnRoom1(e));
        btnRoom2.setOnAction(e -> handleBtnRoom2(e));
        btnAllOff.setOnAction(e -> handleBtnAllOff(e));
        btnAllOn.setOnAction(e -> handleBtnAllOn(e));
        btnBack.setOnAction(e -> handleBtnBack(e));
        btnHome.setOnAction(e -> handleBtnHome(e));

    }

    private void setting() {
        if (Main.equals("OFF")) {
            imgMain.setImage(switch_off);
        } else {
            imgMain.setImage(switch_on);            
        }
        if (Big.equals("OFF")) {
            imgBig.setImage(switch_off);
        } else {
            imgBig.setImage(switch_on);
        }
        if (Room1.equals("OFF")) {
            imgRoom1.setImage(switch_off);
        } else {
            imgRoom1.setImage(switch_on);
        }
        if (Room2.equals("OFF")) {
            imgRoom2.setImage(switch_off);
        } else {
            imgRoom2.setImage(switch_on);
        }
        if (Kitchen.equals("OFF")) {
            imgKitchen.setImage(switch_off);
        } else {
            imgKitchen.setImage(switch_on);
        }
    }

    private void handleBtnMain(ActionEvent e) {
        if (imgMain.getImage() == switch_on) {
            imgMain.setImage(switch_off);
            Main="OFF";
        } else {
            imgMain.setImage(switch_on);
            Main="ON";
        }
    }

    private void handleBtnBig(ActionEvent e) {
        if (imgBig.getImage() == switch_on) {
            imgBig.setImage(switch_off);
            Big="OFF";
        } else {
            imgBig.setImage(switch_on);
            Big="ON";
        }
    }

    private void handleBtnRoom1(ActionEvent e) {
        if (imgRoom1.getImage() == switch_on) {
            imgRoom1.setImage(switch_off);
            Room1="OFF";
        } else {
            imgRoom1.setImage(switch_on);
            Room1="ON";
        }
    }

    private void handleBtnRoom2(ActionEvent e) {
        if (imgRoom2.getImage() == switch_on) {
            imgRoom2.setImage(switch_off);
            Room2="OFF";
        } else {
            imgRoom2.setImage(switch_on);
            Room2="ON";
        }
    }

    private void handleBtnKitchen(ActionEvent e) {
        if (imgKitchen.getImage() == switch_on) {
            imgKitchen.setImage(switch_off);
            Kitchen="OFF";
        } else {
            imgKitchen.setImage(switch_on);
            Kitchen="ON";
        }
    }

    private void handleBtnBack(ActionEvent e) {
        StackPane rootPane = (StackPane) btnBack.getScene().getRoot();
        lightControl.setOpacity(1);
        KeyValue keyValue = new KeyValue(lightControl.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),
                event -> rootPane.getChildren().remove(lightControl),
                keyValue
        );
        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().add(keyFrame);
        timeLine.play();
    }

    private void handleBtnHome(ActionEvent e) {
        StackPane rootPane = (StackPane) btnBack.getScene().getRoot();
        rootPane.getChildren().remove(1);
        lightControl.setOpacity(1);
        KeyValue keyValue = new KeyValue(lightControl.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),
                event -> rootPane.getChildren().remove(lightControl),
                keyValue
        );
        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().add(keyFrame);
        timeLine.play();
    }

    private void handleBtnAllOff(ActionEvent e) {
        if (imgMain.getImage() == switch_on) {
            handleBtnMain(e);
        }
        if (imgBig.getImage() == switch_on) {
            handleBtnBig(e);
        }
        if (imgRoom1.getImage() == switch_on) {
            handleBtnRoom1(e);
        }
        if (imgRoom2.getImage() == switch_on) {
            handleBtnRoom2(e);
        }
        if (imgKitchen.getImage() == switch_on) {
            handleBtnKitchen(e);
        }

    }

    private void handleBtnAllOn(ActionEvent e) {
        if (imgMain.getImage() == switch_off) {
            handleBtnMain(e);
        }
        if (imgBig.getImage() == switch_off) {
            handleBtnBig(e);
        }
        if (imgRoom1.getImage() == switch_off) {
            handleBtnRoom1(e);
        }
        if (imgRoom2.getImage() == switch_off) {
            handleBtnRoom2(e);
        }
        if (imgKitchen.getImage() == switch_off) {
            handleBtnKitchen(e);
        }
    }
}
