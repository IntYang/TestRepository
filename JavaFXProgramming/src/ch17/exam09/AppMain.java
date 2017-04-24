package ch17.exam09;
//2017.04.17
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

    //start 재정의 
    @Override
    public void start(Stage primaryStage) throws Exception {
        //AnchorPane객체가 나옴
        Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setTitle("창제목");
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //main에서 launch시키기
    public static void main(String[] args) {
        launch(args);
    }
    
}
