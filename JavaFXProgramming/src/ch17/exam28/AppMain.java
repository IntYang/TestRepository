package ch17.exam28;

//2017.04.18



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
    
    static Stage primaryStage;

    //start 재정의 
    @Override
    public void start(Stage primaryStage) throws Exception {
        AppMain.primaryStage = primaryStage;
        Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
        
       // Parent parent = FXMLLoader.load("E:/IoTCourse/NetBeansWorkspace/JavaFXProgramming/src/ch17/exam17/root.fxml");
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
