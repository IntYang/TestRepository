package ch17.exam13;

//2017.04.17
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AppMain extends Application {

    //start 재정의 
    @Override
    public void start(Stage primaryStage) throws Exception {
        //AnchorPane객체가 나옴
        Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setTitle("창제목");
        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Closed...");
        });
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //main에서 launch시키기
    public static void main(String[] args) {
        launch(args);
    }
    
}
