




package ch18.exam29.server;

//2017.04.21



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatServer extends Application {

    //start 재정의 
    @Override
    public void start(Stage primaryStage) throws Exception {
        //AnchorPane객체가 나옴
        Parent parent = FXMLLoader.load(getClass().getResource("server.fxml"));
        
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("채팅 서버");
        
        primaryStage.setOnCloseRequest(e->{
					 
				 ServerController.instance.stopServer(); // 서버 컨트롤러 정적으로 선언해서
					 
				});
       
        primaryStage.show();
    }
    
    //main에서 launch시키기
    public static void main(String[] args) {
        launch(args);
    }
    
}
