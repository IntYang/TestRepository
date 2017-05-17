package ch18.test.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ServerController implements Initializable {

  @FXML
  private Button btnStartStop;
  @FXML
  private TextArea txtDisplay;

  private ExecutorService executorService;
  private ServerSocket serverSocket;
  private List<Client> connections = new Vector<Client>();

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    btnStartStop.setOnAction(event -> handleBtnStartStop(event));
  }
  
  private void handleBtnStartStop(ActionEvent event) {
    //System.out.println("start");
    if (btnStartStop.getText().equals("Start")) {
      startServer();
    } else if (btnStartStop.getText().equals("Stop")) {
      stopServer();
    }
  }

  private void startServer() {
    btnStartStop.setText("Stop");
    display("Server running!");
  }
 
  private void stopServer() {
    btnStartStop.setText("Start");
    display("Server stopped...");
  }

  private void display(String text) {
    txtDisplay.appendText(text + "\n");
  }
  
  class Client {
    Socket socket;
    
    Client(Socket socket) {
      this.socket = socket;
    }
    
    void receive() {
      
    }
    
    void send(String message) {
      
    }
  }
}
