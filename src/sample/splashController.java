package sample;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author kenana
 */
public class splashController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane parent;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FadeTraansition.applayFadeTransition(parent,Duration.seconds(5),(e) ->{
            try {

                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Stage primaryStage=new Stage();
                primaryStage.setTitle("login");
                Scene scene=new Scene(root);
                scene.setFill(Color.TRANSPARENT);
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.setResizable(false);
                primaryStage.initStyle(StageStyle.TRANSPARENT);
                primaryStage.show();
                //parent.getChildren().removeAll();
                //parent.getChildren().setAll(fxml);

            } catch (IOException ex){
                Logger.getLogger(splashController.class.getName()).log(Level.SEVERE,null,ex);

            }});

    }

}