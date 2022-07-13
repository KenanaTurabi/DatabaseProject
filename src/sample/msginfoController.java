package sample;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class msginfoController implements Initializable {
    @FXML
    private AnchorPane msginfopane;

    @FXML
    private Label from;

    @FXML
    private Label supject;

    @FXML
    private JFXTextArea content;
    @FXML private javafx.scene.control.Button logoutbtn;
    @FXML
    void reply(ActionEvent event) {
       /* FXMLLoader loader=new FXMLLoader(getClass().getResource("sendmsg.fxml"));
        Parent root;
        root=loader.load();
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);

        stage.show();*/

        Stage stage=(Stage) logoutbtn.getScene().getWindow();
        stage.close();

    }

public void setData(message m){
        supject.setText(m.getSubject());
        content.setText(m.getContent());
}



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
