
package ch17.exam14;
//2017.04.17
import java.net.URL;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;


public class RootController implements Initializable {
    
    @FXML private Label label;
    @FXML private Slider slider;
    @FXML private TextField txt1;
    @FXML private TextField txt2;
    
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       double value = slider.getValue();
        slider.setValue(50);
        slider.valueProperty().addListener(new ChangeListener<Number>(){
           @Override
           public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//               System.out.println(newValue);
                label.setFont(new Font(newValue.doubleValue()));
           }
            
        });
        
        // txt1이 바뀌면 txt2도 바뀌게 하는 재정의
        txt1.textProperty().addListener(new ChangeListener<String>(){
           @Override
           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               txt2.setText(newValue);
           }
                
        });
        txt1.textProperty().addListener((observable,oldValue, newValue)-> {
               txt2.setText(newValue);
           });
        
    }
   
    
}
