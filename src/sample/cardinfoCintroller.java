package sample;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.service;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class cardinfoCintroller implements Initializable {

    @FXML
    private AnchorPane cardinfo;

    @FXML
    private ImageView showinfoimage;

    @FXML
    private Label showinfoname;

    @FXML
    private Label showinfoprice;

    @FXML
    private JFXTextArea showinfodisc;

    @FXML
    private Label showinfotime;


    @FXML
    void buy(ActionEvent event) {

    }



    void setdate(service  s){
        showinfoname.setText(s.name);
        showinfoprice.setText(s.price);
        showinfodisc.setText(s.discription);
        showinfotime.setText(s.timetofinish);
        showinfoimage.setImage(s.imagesrc);

    }

    @FXML private javafx.scene.control.Button showsend;
    @FXML
    void showsendmsg(ActionEvent event) throws IOException {
      /*  FXMLLoader loader=new FXMLLoader(getClass().getResource("sendmsg.fxml"));
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
        FXMLLoader fxmlLoader1=new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("sample.fxml"));
        fxmlLoader1.load();
        Controller controller1=fxmlLoader1.getController();

        Stage stage=(Stage) showsend.getScene().getWindow();
        stage.close();
    }







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
