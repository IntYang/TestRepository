
package ch17.exam27;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class RootController implements Initializable {

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    // 메뉴 클릭에 대한 이벤트 처리!
    @FXML
    private void menuItemNew(ActionEvent event) {
    
        System.out.println("새로 만들기 클릭됨");
    }

    @FXML
    private void menuItemJavaApp(ActionEvent event) {
        System.out.println("자바 어플리케이션 생성");
    
    }
    
}
