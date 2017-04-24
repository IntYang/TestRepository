/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam23;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class RootController implements Initializable {

    @FXML
    private ListView<String> listView;
    @FXML
    private TableView<Phone> tableView;
    @FXML
    private ImageView imageView;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancel;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> data1 = FXCollections.observableArrayList();
        data1.add("갤럭시 s1");
        data1.add("갤럭시 s2");
        data1.add("갤럭시 s3");
         data1.add("갤럭시 s4");
        data1.add("갤럭시 s5");
        data1.add("갤럭시 s6");
        
        listView.setItems(data1);
        
        //속성 감시를 이용해 리스트부->테이블뷰
        
        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                tableView.getSelectionModel().select(newValue.intValue());
                tableView.scrollTo(newValue.intValue()); // 해당 인덱스로 스크롤 되게 보이게


            }
           
        });
        
        
        
        
        
//--------------------------------------리스트뷰 위에
//--------------------------------------테이블뷰 아래에
        TableColumn tc0 = (TableColumn) tableView.getColumns().get(0);
        TableColumn tc1 = (TableColumn)tableView.getColumns().get(1);
        
        tc0.setCellValueFactory(new PropertyValueFactory<Phone,String>("name")); //폰 객체에서 네임 필드의 값을 만들어서 넣어준다
        tc1.setCellValueFactory(new PropertyValueFactory<Phone,String>("image"));
        
        ObservableList<Phone> list = FXCollections.observableArrayList();
        list.add(new Phone("phone01.png", "갤럭시s1", "첫 모델"));
        list.add(new Phone("phone02.png", "갤럭시s2", "두 번째 모델"));
        list.add(new Phone("phone03.png", "갤럭시s3", "세 번째 모델"));
        list.add(new Phone("phone04.png", "갤럭시s4", "네 번째 모델"));
        list.add(new Phone("phone05.png", "갤럭시s5", "다섯 번째 모델"));
        list.add(new Phone("phone06.png", "갤럭시s6", "여섯 번째 모델"));
       
        tableView.setItems(list);
        
        //
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>(){
            @Override
            public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue) {

                    imageView.setImage(new Image(getClass().getResource("images/" + newValue.getImage()).toString()));

            }
            
        
        });
        
        
        
        
        
        


    }    
    
}
