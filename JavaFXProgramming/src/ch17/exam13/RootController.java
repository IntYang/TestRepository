
package ch17.exam13;

import java.net.URL;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class RootController implements Initializable {
    
    @FXML 
    private Button btn1;
    
    @FXML 
    private Button btn2;
    
    @FXML 
    private Button btn3;
    
    @FXML 
    private Button btn4;
    
    @FXML 
    private Button btn5;
    
    @FXML 
    private Button btn6;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //how1
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("button1 clicked. ");
            }
        });
        
        //how2
        btn2.setOnAction(event -> {
             System.out.println("button2 clicked. ");
        });
        
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("buttno4 clicked. ");
            }
            
        });
        
        btn5.setOnAction(event ->{
            System.out.println("button5 clicked. ");
        });
        
     
    }
    //how3
    public void btn3Handle(ActionEvent event){
             System.out.println("button3 clicked. ");
            
        }
    public void btn6Handle(ActionEvent event){
            System.out.println("button6 clicked");
    }
    
}
