package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class sendmsgController implements Initializable {

    @FXML
    private TextField subject;

    @FXML
    private JFXTextArea content;

    @FXML
            private JFXButton sendmsgs;

    HBox cardbox;


    @FXML
    void sendmsg(ActionEvent event) throws IOException {
message m=new message();
m.setSubject(subject.getText());
m.setContent(content.getText());
//m.setFrom("baraa");
        FXMLLoader fxmlLoader1=new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("sample.fxml"));
        fxmlLoader1.load();
        Controller controller1=fxmlLoader1.getController();

    }

    void  add_tp_pane(){


    }
    @FXML private javafx.scene.control.Button canclebtn;
    @FXML
    void close(ActionEvent event) {


                Stage stage=(Stage) canclebtn.getScene().getWindow();
                stage.close();

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
