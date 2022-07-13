package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class loginController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signinpane.setVisible(true);
        SignupPane.setVisible(false);
        adminsigninpane.setVisible(false);
        aboutuspane.setVisible(false);
        try {
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            Statement s= con.createStatement();
            con.setAutoCommit(false);
            String sql="delete from current_user_in";
            s.executeQuery(sql);
            con.commit();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    private AnchorPane signinpane;

    public int ID;

    @FXML
    private AnchorPane aboutuspane;


    @FXML
    private JFXRadioButton Rbtn_Female;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private JFXRadioButton Rbtn_Male;
    @FXML
    private AnchorPane mainpane;

    @FXML
    private JFXButton register;
    @FXML
    private JFXButton back;

    @FXML
    private AnchorPane SignupPane;

    @FXML
    private AnchorPane adminsigninpane;


    @FXML
    private JFXButton signinbtn;

    @FXML
    private JFXButton creatbtn;

    @FXML
    private TextField user_fn;
    @FXML
    private TextField user_phone;

    @FXML
    private TextField user_pass;
    @FXML
    private TextField user_ln;

    @FXML
    private TextField user_email;

    @FXML
    private DatePicker user_db;
    @FXML
    void creataccount(ActionEvent event) {
        try {
            String gender;
            if(Rbtn_Female.isSelected())gender="female";
            else gender="male";
            int user_id=0;
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            String sqlst="select * from user1";
            ResultSet set;
            set=st.executeQuery(sqlst);
            while(set.next()){
                user_id++;
            }
            con.close();
            //////////
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            con1.setAutoCommit(false);
            Statement st1 = con1.createStatement();

            String sqlst1="insert into user1 values ("+user_id+",'"+user_fn.getText()+"','"+user_ln.getText()+"','"+user_db.getValue().toString()+"','"+gender+"','"+user_email.getText()+"','"+user_phone.getText()+"',"+100+",'"+user_pass.getText()+"')";
            st1.execute(sqlst1);
            con1.commit();
            con1.close();
            JOptionPane.showMessageDialog(null, "User added successfully.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        user_fn.setText("");
        user_ln.setText("");
        user_email.setText("");
        user_pass.setText("");
    }

    @FXML
    void opensigninpane(ActionEvent event) {
        signinpane.setVisible(true);
        SignupPane.setVisible(false);
        adminsigninpane.setVisible(false);
        aboutuspane.setVisible(false);
    }

    @FXML
    void opensignuppane(ActionEvent event) {
        signinpane.setVisible(false);
        SignupPane.setVisible(true);
        adminsigninpane.setVisible(false);
        aboutuspane.setVisible(false);
    }

    @FXML
    void openadminsigninpane(ActionEvent event) {
        signinpane.setVisible(false);
        SignupPane.setVisible(false);
        adminsigninpane.setVisible(true);
        aboutuspane.setVisible(false);
    }

    @FXML
    private void GetSelectedGender(ActionEvent event) {

    }

    @FXML
    void openaboutuspane(ActionEvent event) {
        signinpane.setVisible(false);
        SignupPane.setVisible(false);
        adminsigninpane.setVisible(false);
        aboutuspane.setVisible(true);
    }



    @FXML
    private TextField useremail;

    @FXML
    private PasswordField userpass;
    @FXML
    void openapplication(ActionEvent event) throws IOException {
       try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        con.setAutoCommit(false);
        Statement st = con.createStatement();
        String email=useremail.getText();
        String pass=userpass.getText();
        String sqlst = "select user_password from user1 where user_email='"+email+"'";
        ResultSet set;
        set=st.executeQuery(sqlst);
        String check=null;
        while(set.next()){
            check=set.getString(1);
        }
        if(check.equalsIgnoreCase(pass)){
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            //////
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            c.setAutoCommit(false);
            Statement s = c.createStatement();
            String mail=useremail.getText();
            String sql = "select user_id from user1 where user_email='"+mail+"'";
            ResultSet resultSet;
            resultSet=s.executeQuery(sql);
            int check1 = 0;
            while(resultSet.next()){
                check1=resultSet.getInt(1);
            }
            c.close();
            //////
            Connection c1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            c1.setAutoCommit(false);
            Statement s1=c1.createStatement();
            String sql1="insert into current_user_in values("+check1+")";
            s1.executeQuery(sql1);
            c1.commit();
            c1.close();

          /*  Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            c.setAutoCommit(false);
            Statement s = c.createStatement();
            String mail=useremail.getText();
            String sql = "select user_id from user1 where user_email='"+mail+"'";
            ResultSet resultSet;
            resultSet=s.executeQuery(sql);
            int check1 = 0;
            while(resultSet.next()){
                check1=resultSet.getInt(1);
            }
           /* FXMLLoader fxmlLoader2=new FXMLLoader();
            fxmlLoader2.setLocation(getClass().getResource("sample.fxml"));
            fxmlLoader2.load();
            Controller controller1=fxmlLoader2.getController();
            controller1.setData(check1);*/

            primaryStage.show();

        }
        else{
            JOptionPane.showMessageDialog(null, "inncorrect email or pass");
        }
        con.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.toString());
    }

    }


    @FXML
    private TextField adminemail;

    @FXML
    private PasswordField adminpass;
    @FXML
    void openadminpane(ActionEvent event) throws IOException {
        try {

            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            String email=adminemail.getText();
            String pass=adminpass.getText();
            String sqlst = "select admin_password from admin where admin_email='"+email+"'";
            ResultSet set;
            set=st.executeQuery(sqlst);
            String check=null;
            while(set.next()){
                check=set.getString(1);
            }
            if(check.equalsIgnoreCase(pass)){
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
                primaryStage.setScene(new Scene(root));
                primaryStage.initModality(Modality.APPLICATION_MODAL);
                primaryStage.setResizable(false);
                primaryStage.initStyle(StageStyle.TRANSPARENT);
                primaryStage.show();
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
                c.setAutoCommit(false);
                Statement s=c.createStatement();
                String sql="select admin_id from admin where admin_email='"+email+"'";
                ResultSet resultSet=s.executeQuery(sql);
                int admin_id = 0;
                while(resultSet.next()){
                    admin_id=resultSet.getInt(1);
                }
                c.close();
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
                connection.setAutoCommit(false);
                Statement statement=connection.createStatement();
                String str="insert into current_admin_in values("+admin_id+")";
                statement.executeQuery(str);
                connection.commit();
                connection.close();
            }
            else{
                JOptionPane.showMessageDialog(null, "inncorrect email or pass");
            }
            con.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }



    }


    @FXML private javafx.scene.control.Button canclebtn;
    @FXML
    void close(ActionEvent event) {


        Stage stage=(Stage) canclebtn.getScene().getWindow();
        stage.close();

    }
}

