/*
 * 책에없는 내용이니 복습할것
* 앞에 컨트롤러 삭제해야 메이커컨트롤러 됨
 */
package ch17.exam20;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;


public class RootController implements Initializable {

    @FXML
    private ListView<Food> listView;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //하나의 행을 만드는 놈을 셋팅하겠다
         
        listView.setCellFactory(new Callback<ListView<Food>, ListCell<Food>>() { // 리스트뷰에 하나의 행의 내용을 만들어주는 셋 팩토리를 등록하는 메소드
                                //만들어주는게 콜백 객체, 제네릭 타입 두개 신경쓰지 말것...리스트 셀은 안에 들어가는 객체니
            @Override
            public ListCell<Food> call(ListView<Food> param) { // 언제실행? -> 리스트뷰의 데이터가 제공이 될 때= (Phone)객체 실행될 때
                // 이 부분 이해 어렵
                ListCell<Food> listCell = new ListCell<Food>(){
                    @Override
                    protected void updateItem(Food item, boolean empty) {
                        // Phone  하나를 받아서 가지고 리스트 셀 안에 뭐가 들어가는지 정의하는 메소드
                        super.updateItem(item, empty);
                        
                        if(empty) return; // 폰 객체가 없으면 널이니까 걍 리턴해라 -> true시켜 지나가게
                        try{
                            //셀에 들어갈 컨테이너 생성
                            HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("item.fxml")); //최고 엘레먼트가 hbox이므로
                            ImageView phoneImage = (ImageView) hbox.lookup("#image"); // image 뷰의 아이디
                            Label phoneName = (Label) hbox.lookup("#name");
                            Label phoneContent = (Label) hbox.lookup("#content");
                            
                            phoneImage.setImage(new Image(getClass().getResource("images/" + item.getImage()).toString()));
                            phoneName.setText(item.getName());
                            phoneContent.setText(item.getContent());
                            setGraphic(hbox); // 셀에 내용으로 설정한다
                            
                        }catch(IOException ex){
                            ex.printStackTrace(); // 어디서 에러 났나 출력
                        }
                    }
                
                }; //상속이다
                return listCell;
                         }
        });
        
        // (선택 속성 감시) 선택 이벤트 처리
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Food>() {
            @Override
            public void changed(ObservableValue<? extends Food> observable, Food oldValue, Food newValue) {
                System.out.println(newValue.getName() + "" + newValue.getImage());
            }
        }
            
        );
        
        
        
        // 데이터 셋팅
        ObservableList<Food> value = FXCollections.observableArrayList();
        value.add(new Food("phone01.png", "갤럭시 s1", "삼성스마트폰 최초 모델"));
        value.add(new Food("phone02.png", "갤럭시 s2", "삼성스마트폰 2 모델"));
        value.add(new Food("phone03.png", "갤럭시 s3", "삼성스마트폰 3 모델"));
        listView.setItems(value);
       
    }    
    
}
