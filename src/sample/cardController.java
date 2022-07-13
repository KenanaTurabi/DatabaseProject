package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.service;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

public class cardController {
    @FXML
    public HBox cardlayout;

    @FXML
    private ImageView cardimage;

    @FXML
    private AnchorPane cardinfo;

    @FXML
    public Label cardname;

    private listner l;

    public Label getPrice() {
        return price;
    }

    public void setPrice(Label price) {
        this.price = price;
    }

    @FXML
    private Label price;


 private  String disc;
 private String time;

    @FXML
    private Label ordernumber;


    @FXML
    private JFXButton showcard;
    private String[] colors = {"B9E5FF", "BDB2FE", "FB9AA8", "F3F3F3"};

    public void setData(service sr, listner l) {
        cardimage.setImage(sr.imagesrc);
        this.service=sr;
        this.l=l;
      //  ordernumber.setText(String.valueOf(sr.ordern));
      //  price.setText(sr.price);
        cardname.setText(sr.name);
        cardlayout.setStyle("-fx-background-color :#" + colors[(int) (Math.random() * colors.length)]);
disc=sr.discription;
time=sr.timetofinish;
    }

    private service getdata(){
        service s=new service();
        s.name=this.cardname.getText();
       // s.price=this.price.getText();
s.discription=disc;
s.timetofinish=time;
s.imagesrc=cardimage.getImage();


        return s;
    }
    service service;
    @FXML
    void showinfo(ActionEvent mouseEvent) throws IOException {
l.onclick(service);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root;
        root=loader.load();
        Controller c=loader.getController();
        c.setdata(getdata());

    }
}
