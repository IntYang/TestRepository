

package ch17.exam02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppMain extends Application {

    
    // 일반적으로 start와 main만 주로 작성한다.
    
    
    @Override
    public void start(Stage stage) throws Exception { 

        VBox vbox = new VBox();
        vbox.setPrefHeight(300);
        vbox.setPrefWidth(400);
        
        Label label = new Label();
        label.setText("Hello, Java FX");
        vbox.getChildren().add(label);
        
        Button button = new Button();
        button.setText("확인");
        vbox.getChildren().add(button);
        
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    
    }

  
    
    public static void main(String[] args) {
        launch(args);
        //Platform.exit();
    }
    
    
    

}
