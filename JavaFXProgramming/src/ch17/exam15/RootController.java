
package ch17.exam15;
//2017.04.17
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;


public class RootController implements Initializable {
    @FXML AnchorPane root;
    @FXML Circle circle;
    
    circle.centerXProperty().bind(Bindings.divide(root.widthProperty(), 2));
    circle.centerYProperty().bind(Bindings.divide(root.HeightProperty(), 2));
   
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        
    }
   
    
}
