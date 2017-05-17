
package ch17.exam04;
//2017.04.17
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        Parent parent = FXMLLoader.load(getClass().getResource("root.xml"));
       // HBox hjc  = (HBox)FXMLLoader.load(getClass().getResource("root.xml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    

}