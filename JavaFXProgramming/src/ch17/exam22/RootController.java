
package ch17.exam22;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class RootController implements Initializable {

    @FXML
    private TableView<Phone> tableView; // 잘해석, 테이블뷰에 제공되는 데이터 타입이 Phone

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TableColumn tc0 = (TableColumn) tableView.getColumns().get(0);
        TableColumn tc1 = (TableColumn)tableView.getColumns().get(1);
        TableColumn tc2 = (TableColumn)tableView.getColumns().get(2);
        
        tc0.setCellValueFactory(new PropertyValueFactory<Phone,String>("name")); //폰 객체에서 네임 필드의 값을 만들어서 넣어준다
        tc1.setCellValueFactory(new PropertyValueFactory<Phone,String>("image"));
        tc2.setCellValueFactory(new PropertyValueFactory<Phone,String>("content"));
        
        ObservableList<Phone> list = FXCollections.observableArrayList();
        list.add(new Phone("phone01.png", "갤럭시s1", "첫 모델"));
        list.add(new Phone("phone02.png", "갤럭시s2", "두 번째 모델"));
        list.add(new Phone("phone03.png", "갤럭시s3", "세 번째 모델"));
       
        tableView.setItems(list);

    }    
    
}
