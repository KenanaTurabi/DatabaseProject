package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.myorder;
import model.order;
import model.service;
import javafx.collections.ObservableList;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {

    private int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @FXML
    private AnchorPane mainpane;

    @FXML
    private AnchorPane welcome;


    @FXML
    private Label showinfoname;

    @FXML
    private Label showinfoprice;

    @FXML
    private JFXTextArea showinfodisc;

    @FXML
    private Label showinfotime;

    @FXML
    private TableView<myorder> order_tableview;

    @FXML
    private TableColumn<myorder, Integer> order_id;

    @FXML
    private TableColumn<myorder,String> order_time;

    @FXML
    private TableColumn<myorder, String> order_date;

    @FXML
    private TableColumn<myorder, Integer> customer_id;

    @FXML
    private TableColumn<myorder,Integer> service_id;

    @FXML
    private TableColumn<myorder, String> service_name;

    @FXML
    private TableColumn<myorder,Integer> service_price;


    @FXML
    private JFXButton profilebtn;

    @FXML
    private JFXButton security;

    @FXML
    private JFXButton openbuypane;

    @FXML
    private AnchorPane msgpane;

    @FXML
    public GridPane gridmsgpane;

    public void setGridmsgpane(HBox hBox) {
        gridmsgpane.getChildren().add(hBox);
    }

    @FXML
    private AnchorPane profilepane;
    @FXML
    private AnchorPane addservicepane;
    @FXML
    private ImageView profilephoto;

    @FXML
    private JFXButton choosefromfile;

    @FXML
    private Label imageinfo;

    @FXML
    private TextField profilename;

    @FXML
    private TextField db;

    @FXML
    private TextField gender;

    @FXML
    private TextField email;

    @FXML
    private TextField phone;

    @FXML
    public AnchorPane showpane;

    @FXML
    private TextField id;

    @FXML
    private JFXButton choosefromfile1;

    @FXML
    private JFXButton editbtn;

    @FXML
    private AnchorPane buypane;

    @FXML
    private AnchorPane programmingpane;
    @FXML
    private AnchorPane translatepane;
    @FXML
    private TextField search;

    @FXML
    private JFXButton programingbtn;

    @FXML
    private JFXButton videoproductionbtn;

    @FXML
    private JFXButton translatebtn;

    @FXML
    private JFXButton fashionbtn;

    @FXML
    private AnchorPane securitypane;
    @FXML
    private AnchorPane vediopane;

    @FXML
    private AnchorPane fashionpane;

    @FXML
    private AnchorPane notification;

    @FXML
    private AnchorPane cartpane;

    @FXML
    private AnchorPane sendmsgspane;

    @FXML
    private TextField email1;

    @FXML
    private TextField code;

    @FXML
    private JFXButton sendcode;

    @FXML
    private Label codenotcorrect;

    @FXML
    private TextField newpass;

    @FXML
    private TextField confirmnewpass;

    @FXML
    private JFXButton savepass;

    @FXML
    private ImageView codetruefalse;

    @FXML
    private ImageView emailtruefalse;

    @FXML
    private ImageView showimgfromcard;
    @FXML
    private ImageView showimgfromcard1;
    @FXML
    private ImageView showimgfromcard2;
    @FXML
    private ImageView showimgfromcard3;
    @FXML
    private Label imageinfo1;
    @FXML
    private ImageView emailtruefalse1;
    ArrayList<message> msgs = new ArrayList<message>();

    @FXML
    public TableView<message> msgstable;

    @FXML
    private TableColumn<message, String> fromcol;

    @FXML
    private TableColumn<message, String> subjectcol;

    @FXML
    private TableColumn<message, String> contentcol;

    @FXML
    private ImageView cardimage;
    String src;
    Image image;

    @FXML
    void choosefromfile1(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");

            File file = fileChooser.showOpenDialog(new Stage());
            Image image1 = new Image(file.toURI().toString());
            src = file.toURI().toString();

            cardimage.setImage(new Image(file.toURI().toString()));
            image = cardimage.getImage();
        } catch (NullPointerException e) {
            imageinfo1.setText("there is no selected image");

        }
    }

    String name;

    @FXML
    private Label showinfoname1;

    @FXML
    private Label showinfoprice1;

    @FXML
    private JFXTextArea showinfodisc1;


    @FXML
    private Label showinfotime1;


    @FXML
    private Label showinfoname2;

    @FXML
    private Label showinfoprice2;

    @FXML
    private JFXTextArea showinfodisc2;

    @FXML
    private Label showinfotime2;

    @FXML
    private Label showinfoname21;

    @FXML
    private Label showinfoprice21;

    @FXML
    private JFXTextArea showinfodisc21;

    @FXML
    private Label showinfotime21;

public int service_show_id=0;
    public void setdata(service s) {
        showimgfromcard.setImage(s.imagesrc);
        showinfoname.setText(s.name);
        showinfodisc.setText(s.discription);
        showinfoprice.setText(s.price);
        showinfotime.setText(s.timetofinish);
        service_show_id=s.service_id;
        name = showinfoname.getText();
        showimgfromcard1.setImage(s.imagesrc);
showinfoname1.setText(s.name);
showinfodisc1.setText(s.discription);
showinfoprice1.setText(s.price);
showinfotime1.setText(s.timetofinish);
        showimgfromcard2.setImage(s.imagesrc);
        showinfoname2.setText(s.name);
        showinfodisc2.setText(s.discription);
        showinfoprice2.setText(s.price);
        showinfotime2.setText(s.timetofinish);
        showimgfromcard3.setImage(s.imagesrc);
        showinfoname21.setText(s.name);
        showinfodisc21.setText(s.discription);
        showinfoprice21.setText(s.price);
        showinfotime21.setText(s.timetofinish);
    }

    /////close btn
    @FXML
    private javafx.scene.control.Button canclebtn;

    @FXML
    void close(ActionEvent event) throws SQLException {
        int v = JOptionPane.showConfirmDialog(null, "Do you want to logout ?");
        if (v == 1 || v == 2) return;
        else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            String sqlst = "delete from current_user_in";
            st.executeQuery(sqlst);
            con.commit();
            con.close();
            Stage stage = (Stage) canclebtn.getScene().getWindow();
            stage.close();
        }
    }


    ///////////////////////////////////////////////////////////////////////
    @FXML
    void showsendmsg(ActionEvent event) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        c.setAutoCommit(false);
        Statement s = c.createStatement();
        String sql="select s.user_id from service s where s.service_discribtion='"+showinfodisc.getText()+"' and s.service_name='"+showinfoname.getText()+"'";
        ResultSet set=s.executeQuery(sql);
        int user_id=0;
        while(set.next()){
            user_id=set.getInt(1);
        }
        tomsg.setText(String.valueOf(user_id));
c.close();
        sendmsgspane.setVisible(true);
        programmingpane.setVisible(false);
        translatepane.setVisible(false);
        fashionpane.setVisible(false);
        vediopane.setVisible(false);
    }

    @FXML
    private TextField sname;
    @FXML
    private TextField sprice;
    @FXML
    private TextField stime;
    @FXML
    private TextField sdisc;
    @FXML
    private JFXComboBox<String> categories;
    @FXML
    private HBox progitems;
    @FXML
    private HBox translateitems;
    @FXML
    private HBox vedioproductionitems;
    @FXML
    private HBox recentvedio;
    @FXML
    private HBox fashionitems;
    @FXML
    private HBox recentfashion;
    public ArrayList<service> programingitems = new ArrayList<service>();
    public ArrayList<service> transitems = new ArrayList<service>();
    public ArrayList<service> vedioitems = new ArrayList<service>();
    public ArrayList<service> fashitems = new ArrayList<service>();

    @FXML
    void addservice(ActionEvent event) throws MalformedURLException {
        Connection con1 = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            c.setAutoCommit(false);
            Statement s = c.createStatement();
            String sql = "select * from current_user_in";
            int current_id = 0;
            ResultSet rs;
            rs = s.executeQuery(sql);
            while (rs.next()) {
                current_id = rs.getInt(1);
            }
            c.close();
            con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            con1.setAutoCommit(false);
            Statement st = con1.createStatement();
            String sqlst = "select * from user1 where user_id=" + current_id + "";
            ResultSet set;
            set = st.executeQuery(sqlst);
            while (set.next()) {
                id.setText(set.getString(1));
            }
            con1.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int service_id = 0;
        if (categories.getValue().equalsIgnoreCase("Translate")) {
            try {

                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
                con.setAutoCommit(false);
                Statement st = con.createStatement();
                String sqlst = "select * from service";
                ResultSet set;
                set = st.executeQuery(sqlst);
                while (set.next()) {
                    service_id++;
                }
                con.close();
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
                Statement s = connection.createStatement();
                connection.setAutoCommit(false);
                String sql = "insert into service values(" + service_id + ",'" + sname.getText() + "','" + sdisc.getText() + "'," + sprice.getText() + ",'" + stime.getText() + "'," + 3 + "," + Integer.parseInt(id.getText()) + ",'"+cardimage.getImage().getUrl()+"')";
                s.executeQuery(sql);
                connection.commit();
                connection.close();
                JOptionPane.showMessageDialog(null, "Your service added successfully plese wait the acception from the admin");
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null, throwables.toString());
            }

           /* translateitems.getChildren().clear();
            service ser = new service();
            ser.name = sname.getText();
            ser.price = sprice.getText();
            ser.ordern = 4;
            ser.discription = sdisc.getText();
            ser.timetofinish = stime.getText();
            ser.imagesrc = image;

            transitems.add(ser);

            try {
                for (int i = 0; i < transitems.size(); i++) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                    HBox cardbox = fxmlLoader.load();
                    cardController CardController = fxmlLoader.getController();
                    CardController.setData(transitems.get(i), l);
                    translateitems.getChildren().add(cardbox);
                }*/
                sname.setText("");
                sdisc.setText("");
                sprice.setText("");
                stime.setText("");
           /* } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
        if (categories.getValue().equalsIgnoreCase("Programming")) {
            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
                con.setAutoCommit(false);
                Statement st = con.createStatement();
                String sqlst = "select * from service";
                ResultSet set;
                set = st.executeQuery(sqlst);
                while (set.next()) {
                    service_id++;
                }
                con.close();
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
                Statement s = connection.createStatement();
                connection.setAutoCommit(false);
                String sql = "insert into service values(" + service_id + ",'" + sname.getText() + "','" + sdisc.getText() + "'," + sprice.getText() + ",'" + stime.getText() + "'," + 1 + "," + Integer.parseInt(id.getText()) + ",'"+cardimage.getImage().getUrl()+"')";
                s.executeQuery(sql);
                connection.commit();
                connection.close();
                JOptionPane.showMessageDialog(null, "Your service added successfully plese wait the acception from the admin");
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null, throwables.toString());
            }
         /*   progitems.getChildren().clear();
            service ser = new service();
            ser.name = sname.getText();
            ser.price = sprice.getText();
            ser.ordern = 4;
            ser.discription = sdisc.getText();
            ser.imagesrc = image;
            programingitems.add(ser);
            ser.timetofinish = stime.getText();

            try {
                for (int i = 0; i < programingitems.size(); i++) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                    HBox cardbox = fxmlLoader.load();
                    cardController CardController = fxmlLoader.getController();
                    CardController.setData(programingitems.get(i), l);
                    progitems.getChildren().add(cardbox);
                }*/
                sname.setText("");
                sdisc.setText("");
                sprice.setText("");
                stime.setText("");
             /*catch (Exception e) {
                e.printStackTrace();
            }*/

        }
        if (categories.getValue().equalsIgnoreCase("Video production")) {

            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
                con.setAutoCommit(false);
                Statement st = con.createStatement();
                String sqlst = "select * from service";
                ResultSet set;
                set = st.executeQuery(sqlst);
                while (set.next()) {
                    service_id++;
                }
                con.close();
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
                Statement s = connection.createStatement();
                connection.setAutoCommit(false);
                String sql = "insert into service values(" + service_id + ",'" + sname.getText() + "','" + sdisc.getText() + "'," + sprice.getText() + ",'" + stime.getText() + "'," + 2 + "," + Integer.parseInt(id.getText()) + ",'"+cardimage.getImage().getUrl()+"')";
                s.executeQuery(sql);
                connection.commit();
                connection.close();
                JOptionPane.showMessageDialog(null, "Your service added successfully plese wait the acception from the admin");
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null, throwables.toString());
            }
          /*  vedioproductionitems.getChildren().clear();
            service ser = new service();
            ser.name = sname.getText();
            ser.price = sprice.getText();
            ser.ordern = 4;
            ser.discription = sdisc.getText();
            ser.timetofinish = stime.getText();
            ser.imagesrc = image;
            vedioitems.add(ser);*/


         /*  try {
                for (int i = 0; i < vedioitems.size(); i++) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                    HBox cardbox = fxmlLoader.load();
                    cardController CardController = fxmlLoader.getController();
                    CardController.setData(vedioitems.get(i), l);
                    vedioproductionitems.getChildren().add(cardbox);
                }*/
                sname.setText("");
                sdisc.setText("");
                sprice.setText("");
                stime.setText("");
          /*  } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
        if (categories.getValue().equalsIgnoreCase("Fashion design")) {
            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
                con.setAutoCommit(false);
                Statement st = con.createStatement();
                String sqlst = "select * from service";
                ResultSet set;
                set = st.executeQuery(sqlst);
                while (set.next()) {
                    service_id++;
                }
                con.close();
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
                Statement s = connection.createStatement();
                connection.setAutoCommit(false);
                String sql = "insert into service values(" + service_id + ",'" + sname.getText() + "','" + sdisc.getText() + "'," + sprice.getText() + ",'" + stime.getText() + "'," + 4 + "," + Integer.parseInt(id.getText()) + ",'"+cardimage.getImage().getUrl()+"')";
                s.executeQuery(sql);
                connection.commit();
                connection.close();
                JOptionPane.showMessageDialog(null, "Your service added successfully plese wait the acception from the admin");
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null, throwables.toString());
            }
            /*fashionitems.getChildren().clear();
            service ser = new service();
            ser.name = sname.getText();
            ser.price = sprice.getText();
            ser.ordern = 4;
            ser.discription = sdisc.getText();
            ser.imagesrc = image;
            ser.timetofinish = stime.getText();
            fashitems.add(ser);*/
            /*try {
                for (int i = 0; i < fashitems.size(); i++) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                    HBox cardbox = fxmlLoader.load();
                    cardController CardController = fxmlLoader.getController();
                    CardController.setData(fashitems.get(i), l);
                    fashionitems.getChildren().add(cardbox);
                }*/
                sname.setText("");
                sdisc.setText("");
                sprice.setText("");
                stime.setText("");
          /*  } catch (Exception e) {
                e.printStackTrace();
            }*/

        }
    }

    @FXML
    public Label shownname;
    @FXML
    public Label shownprice;
    @FXML
    public Label showdisc;
    @FXML
    public ImageView shownimage;


    @FXML
    void showcard(ActionEvent event) {
        cardController c = new cardController();
        shownname.setText(c.cardname.getText());
    }

    ObservableList<message> list = FXCollections.observableArrayList();

    public void recivedmsg(message m) {
        msgstable.getItems().removeAll();
        message ms = new message();
        ms.setFrom(m.getFrom());
        ms.setContent(m.getContent());
        ms.setSubject(m.getSubject());

        list.add(new message(
                ms.getFrom(),
                ms.getSubject(),
                ms.getContent()
        ));
        msgstable.refresh();
        msgstable.setItems(list);
    }


//////////send msg



////////////// b u y servic
int u_id=0;
    @FXML
    void buy(ActionEvent event) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        con.setAutoCommit(false);
        Statement statement=con.createStatement();
        String sq="select * from current_user_in";
        ResultSet resultSet=  statement.executeQuery(sq);

        while (resultSet.next()){
            u_id=resultSet.getInt(1);
        }
        con.close();
        //////
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        c.setAutoCommit(false);
        Statement s=c.createStatement();
        String sql="insert into buy values(buy_sequence.nextval,"+u_id+","+service_show_id+")";
        s.executeQuery(sql);
        c.commit();
        c.close();
        ///// select the owner id of the service
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection connection1 =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        connection1.setAutoCommit(false);
        Statement statement11=connection1.createStatement();
        String sql11="select user_id from service where service_id="+service_show_id+"";
        ResultSet set=statement11.executeQuery(sql11);
        int owner_id=0;
        while (set.next()){
            owner_id=set.getInt(1);
        }
        connection1.close();
///
        Date d=new Date();
        d.getTime();
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/YYYY");
        SimpleDateFormat f1=new SimpleDateFormat("hh:mm:ss");
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        connection.setAutoCommit(false);
        Statement statement1=connection.createStatement();
        String sql1="insert into orders values(order_seq.nextval,'"+(String)f1.format(d)+"','"+(String) f.format(d)+"',"+u_id+","+service_show_id+","+owner_id+")";
        statement1.executeQuery(sql1);
        connection.commit();
        connection.close();
        JOptionPane.showMessageDialog(null,"This Service added to your cart successfully");
    }

//////////////////////


    ////delete from msg table

    @FXML
    private void deletefrommsgtable(ActionEvent event) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        con.setAutoCommit(false);
        Statement st=con.createStatement();
        String s="select * from current_user_in";
        ResultSet set=st.executeQuery(s);
        int u_id=0;
        while(set.next()){
            u_id=set.getInt(1);
        }
        con.close();
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        connection.setAutoCommit(false);
        Statement statement=connection.createStatement();
        String sql="delete from MESSAGES where to_user_id="+u_id+" and msg_content='"+msgstable.getSelectionModel().getSelectedItem().getContent()+"'";
        statement.executeQuery(sql);
        connection.commit();
        connection.close();
        msgstable.getItems().removeAll(msgstable.getSelectionModel().getSelectedItem());
        JOptionPane.showMessageDialog(null,"This Message Deleted Successfully");
    }
////reply msg
@FXML
void replymsg(ActionEvent event){
        msgpane.setVisible(false);
        tomsg.setText(String.valueOf(msgstable.getSelectionModel().getSelectedItem().getFrom()) );
        sendmsgspane.setVisible(true);
}

    //////////////////////

    @FXML
    private javafx.scene.control.Button logoutbtn;

    @FXML
    void logout(ActionEvent event) throws SQLException {
        int v = JOptionPane.showConfirmDialog(null, "Do you want to logout ?");
        if (v == 1 || v == 2) return;
        else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            String sqlst = "delete from current_user_in";
            st.executeQuery(sqlst);
            con.commit();
            con.close();
            Stage stage = (Stage) logoutbtn.getScene().getWindow();
            stage.close();
        }
    }


    @FXML
    void opencartpane(ActionEvent event) throws SQLException {
        securitypane.setVisible(false);
        profilepane.setVisible(false);
        buypane.setVisible(false);
        programmingpane.setVisible(false);
        addservicepane.setVisible(false);
        translatepane.setVisible(false);
        vediopane.setVisible(false);
        fashionpane.setVisible(false);
        notification.setVisible(false);
        orderpane.setVisible(false);
        cartpane.setVisible(true);
        msgpane.setVisible(false);
        sendmsgspane.setVisible(false);
        welcome.setVisible(false);
        carttable.getItems().clear();
        ////get current user id
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con1 =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        con1.setAutoCommit(false);
        Statement statement1=con1.createStatement();
        String sql="select * from current_user_in";
        ResultSet resultSet1=statement1.executeQuery(sql);
        while(resultSet1.next()){
            u_id=resultSet1.getInt(1);
        }
        con1.close();
        ///
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        con.setAutoCommit(false);
        Statement statement=con.createStatement();
        String sq="select b.buy_row_count,s.service_name,s.service_price,s.user_id,u.user_email from service s,user1 u,buy b where b.s_id=s.service_id and b.u_id="+u_id+" and u.user_id=s.user_id ";
ResultSet resultSet=statement.executeQuery(sq);
orderlist.clear();
while (resultSet.next()){
    order o=new order();
    o.setUserid(resultSet.getInt(4));
    o.setPrice(resultSet.getInt(3));
    o.setServicename(resultSet.getString(2));
    o.setUseremail(resultSet.getString(5));
    orderlist.add(o);
}
//carttable.refresh();
carttable.setItems(orderlist);
con.close();


    }


    /////cart pane handle

    @FXML
    private TableView<order> carttable;

    @FXML
    private TableColumn<order, String> servicename;

    @FXML
    private TableColumn<order, Integer> serviceprice;
    @FXML
    private TableColumn<order, String> servicebuydate;

    @FXML
    private TableColumn<order, Integer> serviceuserid;

    @FXML
    private TableColumn<order, String> serviceuseremail;

    ObservableList<order> orderlist = FXCollections.observableArrayList();


    ///////

    public void opensendmsgspane() {
        securitypane.setVisible(false);
        profilepane.setVisible(false);
        buypane.setVisible(false);
        programmingpane.setVisible(false);
        addservicepane.setVisible(false);
        translatepane.setVisible(false);
        vediopane.setVisible(false);
        fashionpane.setVisible(false);
        notification.setVisible(false);
        cartpane.setVisible(false);
        msgpane.setVisible(false);
        sendmsgspane.setVisible(true);
        welcome.setVisible(false);
        orderpane.setVisible(false);
    }


    @FXML
    private AnchorPane orderpane;
    /////order pane handel---------------------------------------------------------------------------------------------
    ObservableList<myorder> myorder_list = FXCollections.observableArrayList();

    @FXML
    void openorderpane(ActionEvent event) throws SQLException {
        translatepane.setVisible(false);
        programmingpane.setVisible(false);
        buypane.setVisible(false);
        securitypane.setVisible(false);
        addservicepane.setVisible(false);
        profilepane.setVisible(false);
        vediopane.setVisible(false);
        fashionpane.setVisible(false);
        notification.setVisible(false);
        cartpane.setVisible(false);
        msgpane.setVisible(false);
        sendmsgspane.setVisible(false);
        welcome.setVisible(false);
        orderpane.setVisible(true);
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection connection1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        connection1.setAutoCommit(false);
        Statement statement11=connection1.createStatement();
        String s="select * from current_user_in";
        ResultSet set=statement11.executeQuery(s);
        int user_id=0;
        while(set.next()){
            user_id=set.getInt(1);
        }
        connection1.close();
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        connection.setAutoCommit(false);
        Statement statement1=connection.createStatement();
        String sql="select o.order_id,o.order_time,o.order_date,o.order_buyer_id,o.order_service_id,o.saler_id,s.service_name,s.service_price from orders o,service s where saler_id="+user_id+" and s.service_id=o.order_service_id";
        ResultSet set1=statement1.executeQuery(sql);
        while (set1.next()){
            myorder o=new myorder();
            o.setOrder_id(set1.getInt(1));
            o.setOrder_time(set1.getString(2));
            o.setOrder_date(set1.getString(3));
            o.setCustomer_id(set1.getInt(4));
            o.setService_id(set1.getInt(5));
            o.setService_name(set1.getString(7));
            o.setService_price(set1.getInt(8));
            myorder_list.add(o);
        }
        order_tableview.setItems(myorder_list);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void opensecuritypane(ActionEvent event) {
        securitypane.setVisible(true);
        profilepane.setVisible(false);
        buypane.setVisible(false);
        programmingpane.setVisible(false);
        addservicepane.setVisible(false);
        translatepane.setVisible(false);
        vediopane.setVisible(false);
        fashionpane.setVisible(false);
        notification.setVisible(false);
        cartpane.setVisible(false);
        msgpane.setVisible(false);
        sendmsgspane.setVisible(false);
        welcome.setVisible(false);
    }


    @FXML
    void opentranslate(ActionEvent event) throws SQLException {
        translatepane.setVisible(true);
        programmingpane.setVisible(false);
        buypane.setVisible(false);
        securitypane.setVisible(false);
        addservicepane.setVisible(false);
        profilepane.setVisible(false);
        vediopane.setVisible(false);
        fashionpane.setVisible(false);
        notification.setVisible(false);
        cartpane.setVisible(false);
        msgpane.setVisible(false);
        sendmsgspane.setVisible(false);
        welcome.setVisible(false);
        transitems.clear();
        translateitems.getChildren().clear();
        showinfotime1.setText("");
        showinfoprice1.setText("");
        showinfodisc1.setText("");
        showinfoname1.setText("");
        showimgfromcard1.setImage(new Image("file:/C:/Users/baraa/IdeaProjects/freelanceSystem/out/production/freelanceSystem/sample/image_30px.png"));

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        c.setAutoCommit(false);
        Statement s=c.createStatement();
        String sql="select * from service where service_id in(select SERVICE_id from control) and DEP_ID="+3+"";
        ResultSet resultSet=s.executeQuery(sql);
        while (resultSet.next()){
            service ser = new service();
            ser.service_id=resultSet.getInt(1);
            ser.name=resultSet.getString(2);
            ser.discription=resultSet.getString(3);
            ser.price=String.valueOf(resultSet.getInt(4)) ;
            ser.timetofinish=resultSet.getString(5);
            ser.seller_id=resultSet.getInt(7);
            Image image=new Image(resultSet.getString(8));
            ser.imagesrc=image;
            transitems.add(ser);
        }
        try {
            for (int i = 0; i < transitems.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                HBox cardbox = fxmlLoader.load();
                cardController CardController = fxmlLoader.getController();
                CardController.setData(transitems.get(i), l);
                translateitems.getChildren().add(cardbox);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    @FXML
    void openfashion(ActionEvent event) throws SQLException {
        translatepane.setVisible(false);
        programmingpane.setVisible(false);
        buypane.setVisible(false);
        securitypane.setVisible(false);
        addservicepane.setVisible(false);
        profilepane.setVisible(false);
        vediopane.setVisible(false);
        fashionpane.setVisible(true);
        notification.setVisible(false);
        cartpane.setVisible(false);
        msgpane.setVisible(false);
        welcome.setVisible(false);
        sendmsgspane.setVisible(false);
showinfodisc21.setText("");
showinfoname21.setText("");
showinfoprice21.setText("");
showinfotime21.setText("");
        showimgfromcard3.setImage(new Image("file:/C:/Users/baraa/IdeaProjects/freelanceSystem/out/production/freelanceSystem/sample/image_30px.png"));

       fashitems.clear();
       fashionitems.getChildren().clear();
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        c.setAutoCommit(false);
        Statement s=c.createStatement();
        String sql="select * from service where service_id in(select SERVICE_id from control) and DEP_ID="+4+"";
        ResultSet resultSet=s.executeQuery(sql);
        while (resultSet.next()){
            service ser = new service();
            ser.service_id=resultSet.getInt(1);
            ser.name=resultSet.getString(2);
            ser.discription=resultSet.getString(3);
            ser.price=String.valueOf(resultSet.getInt(4)) ;
            ser.timetofinish=resultSet.getString(5);
            ser.seller_id=resultSet.getInt(7);
            Image image=new Image(resultSet.getString(8));
            ser.imagesrc=image;
            fashitems.add(ser);
        }
        try {
            for (int i = 0; i < fashitems.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                HBox cardbox = fxmlLoader.load();
                cardController CardController = fxmlLoader.getController();
                CardController.setData(fashitems.get(i), l);
                fashionitems.getChildren().add(cardbox);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void openvedio(ActionEvent event) throws SQLException {
        translatepane.setVisible(false);
        programmingpane.setVisible(false);
        buypane.setVisible(false);
        securitypane.setVisible(false);
        addservicepane.setVisible(false);
        profilepane.setVisible(false);
        vediopane.setVisible(true);
        fashionpane.setVisible(false);
        notification.setVisible(false);
        orderpane.setVisible(false);
        cartpane.setVisible(false);
        welcome.setVisible(false);
        msgpane.setVisible(false);
        sendmsgspane.setVisible(false);
        vedioitems.clear();
        showinfoname2.setText("");
        showinfotime2.setText("");
        showinfodisc2.setText("");
        showinfoprice2.setText("");
        showimgfromcard2.setImage(new Image("file:/C:/Users/baraa/IdeaProjects/freelanceSystem/out/production/freelanceSystem/sample/image_30px.png"));

        vedioproductionitems.getChildren().clear();
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        c.setAutoCommit(false);
        Statement s=c.createStatement();
        String sql="select * from service where service_id in(select SERVICE_id from control) and DEP_ID="+2+"";
        ResultSet resultSet=s.executeQuery(sql);
        while (resultSet.next()){
            service ser = new service();
            ser.service_id=resultSet.getInt(1);
            ser.name=resultSet.getString(2);
            ser.discription=resultSet.getString(3);
            ser.price=String.valueOf(resultSet.getInt(4)) ;
            ser.timetofinish=resultSet.getString(5);
            ser.seller_id=resultSet.getInt(7);
            Image image=new Image(resultSet.getString(8));
            ser.imagesrc=image;
            vedioitems.add(ser);
        }
        try {
            for (int i = 0; i <vedioitems.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                HBox cardbox = fxmlLoader.load();
                cardController CardController = fxmlLoader.getController();
                CardController.setData(vedioitems.get(i), l);
                vedioproductionitems.getChildren().add(cardbox);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }





    }

    @FXML
    void openprogramming(ActionEvent event) throws SQLException {
        securitypane.setVisible(false);
        profilepane.setVisible(false);
        buypane.setVisible(false);
        programmingpane.setVisible(true);
        translatepane.setVisible(false);
        vediopane.setVisible(false);
        fashionpane.setVisible(false);
        notification.setVisible(false);
        welcome.setVisible(false);
        orderpane.setVisible(false);
        cartpane.setVisible(false);
        msgpane.setVisible(false);
        sendmsgspane.setVisible(false);
        progitems.getChildren().clear();
showinfotime.setText("");
showinfoprice.setText("");
showinfodisc.setText("");
showinfoname.setText("");
showimgfromcard.setImage(new Image("file:/C:/Users/baraa/IdeaProjects/freelanceSystem/out/production/freelanceSystem/sample/image_30px.png"));

        ///////

programingitems.clear();
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        c.setAutoCommit(false);
        Statement s=c.createStatement();
        String sql="select * from service where service_id in(select SERVICE_id from control) and DEP_ID="+1+"";
        ResultSet resultSet=s.executeQuery(sql);
        while (resultSet.next()){
            service ser = new service();
            ser.service_id=resultSet.getInt(1);
            ser.name=resultSet.getString(2);
            ser.discription=resultSet.getString(3);
            ser.price=String.valueOf(resultSet.getInt(4)) ;
            ser.timetofinish=resultSet.getString(5);
            Image image=new Image(resultSet.getString(8));
            ser.seller_id=resultSet.getInt(7);
            ser.imagesrc=image;
            programingitems.add(ser);
        }
        try {
            for (int i = 0; i < programingitems.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                HBox cardbox = fxmlLoader.load();
                cardController CardController = fxmlLoader.getController();
                CardController.setData(programingitems.get(i), l);
                progitems.getChildren().add(cardbox);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void openaddservice(ActionEvent event) {
        buypane.setVisible(false);
        profilepane.setVisible(false);
        securitypane.setVisible(false);
        addservicepane.setVisible(true);
        programmingpane.setVisible(false);
        translatepane.setVisible(false);
        orderpane.setVisible(false);
        vediopane.setVisible(false);
        welcome.setVisible(false);
        fashionpane.setVisible(false);
        notification.setVisible(false);
        cartpane.setVisible(false);
        msgpane.setVisible(false);
        sendmsgspane.setVisible(false);
    }

    @FXML
    void sendcodetoemail(ActionEvent event) throws MessagingException {
        String d_email = "freelancesystem00@gmail.com",
                d_uname = "baraa",
                d_password = "Freelance00$",
                d_host = "smtp.gmail.com",
                d_port = "465",
                m_to = "freelancesystem00@gmail.com",
                m_subject = "Indoors Readable File: ",
                m_text = "This message is from Indoor Positioning App. Required file(s) are attached.";
        Properties props = new Properties();
        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");


        Session session = Session.getInstance(props);
        session.setDebug(true);

        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(d_email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));

            Transport transport = session.getTransport("smtps");
            transport.connect(d_host, Integer.valueOf(d_port), d_uname, d_password);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();

        } catch (AddressException e) {
            e.printStackTrace();

        } catch (MessagingException e) {
            e.printStackTrace();


        }
    }



    @FXML
    void showbuypane(ActionEvent event) {
        profilepane.setVisible(false);
        buypane.setVisible(true);
        securitypane.setVisible(false);
        programmingpane.setVisible(false);
        addservicepane.setVisible(false);
        orderpane.setVisible(false);
        translatepane.setVisible(false);
        vediopane.setVisible(false);
        fashionpane.setVisible(false);
        notification.setVisible(false);
        welcome.setVisible(false);
        cartpane.setVisible(false);
        msgpane.setVisible(false);
        sendmsgspane.setVisible(false);
    }


    @FXML
    void choosefromfile(ActionEvent event) { try {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        File file=  fileChooser.showOpenDialog(new Stage());
        Image image1 = new Image(file.toURI().toString());

        profilephoto.setImage(new Image(file.toURI().toString()));
    }catch (NullPointerException e){
        imageinfo.setText("there is no selected image");

    }
    }
public int user_in_id=0;


    @FXML
    void showprofilepane(ActionEvent event) {
        profilepane.setVisible(true);
        buypane.setVisible(false);
        securitypane.setVisible(false);
        programmingpane.setVisible(false);
        addservicepane.setVisible(false);
        translatepane.setVisible(false);
        orderpane.setVisible(false);
        vediopane.setVisible(false);
        fashionpane.setVisible(false);
        notification.setVisible(false);
        welcome.setVisible(false);
        cartpane.setVisible(false);
        msgpane.setVisible(false);
        sendmsgspane.setVisible(false);

        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            c.setAutoCommit(false);
            Statement s=c.createStatement();
            String sql="select * from current_user_in";
            int current_id = 0;
            ResultSet rs;
            rs=s.executeQuery(sql);
            while (rs.next()){
                current_id=rs.getInt(1);
            }
            user_in_id=current_id;
            c.close();
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        con.setAutoCommit(false);
        Statement st = con.createStatement();

        String sqlst = "select * from user1 where user_id="+current_id+"";
        ResultSet set;
        set=st.executeQuery(sqlst);
        while(set.next()) {
            profilename.setText(set.getString(2) + "   " + set.getString(3));
            db.setText(set.getString(4));
            email.setText(set.getString(6));
            gender.setText(set.getString(5));
            phone.setText(set.getString(7));
            id.setText(set.getString(1));
            Image image=new Image(set.getString(10));
            profilephoto.setImage(image);
        }
con.close();
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }}


        @FXML
    void edit(ActionEvent event) {
        profilename.setEditable(true);
        db.setEditable(true);
        gender.setEditable(true);
        email.setEditable(true);
        phone.setEditable(true);

    }
    public List<service> recentlyadded(){
        List<service> ls=new ArrayList<service>();
        service s=new service();


        s.name="coding";
        s.ordern=2;
        s.price="30";
        s.discription="wdqwdqd";
       //s Image image=new Image(getClass().getResourceAsStream(src));
        s.imagesrc=new Image(getClass().getResourceAsStream("app.jpg")); ls.add(s);s=new service();
        s.name="fffff";
        s.ordern=5;
        s.price="30";
        s.discription="wdqwdqd";
       // Image image1=new Image(getClass().getResourceAsStream(src));
         s.imagesrc=new Image(getClass().getResourceAsStream("app.jpg")); ls.add(s);
        return ls;
    }
private listner l;

    @FXML
    public HBox cardlayout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       // System.out.println("this is user id from controller"+this.getUserid());


                l=new listner() {
                    @Override
                    public void onclick(service s) {
                        setdata(s);
                    }
                };

                fromcol.setCellValueFactory(new PropertyValueFactory<message,String>("from"));
                subjectcol.setCellValueFactory(new PropertyValueFactory<message,String>("subject"));
                contentcol.setCellValueFactory(new PropertyValueFactory<message,String>("content"));
                msgstable.setItems(list);

                    msgstable.refresh();


welcome.setVisible(true);


                servicename.setCellValueFactory(new PropertyValueFactory<order,String>("servicename"));
                servicebuydate.setCellValueFactory(new PropertyValueFactory<order,String>("buydate"));
                serviceuserid.setCellValueFactory(new PropertyValueFactory<order,Integer>("userid"));
                serviceprice.setCellValueFactory(new PropertyValueFactory<order,Integer>("price"));
                serviceuseremail.setCellValueFactory(new PropertyValueFactory<order,String>("useremail"));
                carttable.setItems(orderlist);
                carttable.refresh();


                order_id.setCellValueFactory(new PropertyValueFactory<myorder,Integer>("order_id"));
                order_time.setCellValueFactory(new PropertyValueFactory<myorder,String>("order_time"));
                order_date.setCellValueFactory(new PropertyValueFactory<myorder,String>("order_date"));
                customer_id.setCellValueFactory(new PropertyValueFactory<myorder,Integer>("customer_id"));
               service_id.setCellValueFactory(new PropertyValueFactory<myorder,Integer>("service_id"));
                service_price.setCellValueFactory(new PropertyValueFactory<myorder,Integer>("service_price"));
                service_name.setCellValueFactory(new PropertyValueFactory<myorder,String>("service_name"));

        order_tableview.setItems(myorder_list);
                order_tableview.refresh();

            categories.getItems().addAll("Programming","Translate","Video production","Fashion design");


    }



@FXML
    public void openmsgpane(ActionEvent event) throws SQLException {
        msgpane.setVisible(true);
    profilepane.setVisible(false);
    buypane.setVisible(false);
    securitypane.setVisible(false);
    programmingpane.setVisible(false);
    addservicepane.setVisible(false);
    translatepane.setVisible(false);
    orderpane.setVisible(false);
    welcome.setVisible(false);
    vediopane.setVisible(false);
    fashionpane.setVisible(false);
    notification.setVisible(false);
    cartpane.setVisible(false);
    sendmsgspane.setVisible(false);
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
    con.setAutoCommit(false);
    Statement statement=con.createStatement();
    String sql="select * from current_user_in";
    ResultSet set=statement.executeQuery(sql);
    int u_id=0;
    while(set.next()){
        u_id=set.getInt(1);
    }
    con.close();

    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    Connection connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
    connection.setAutoCommit(false);
    Statement statement1=connection.createStatement();
    String sql1= "select msg_id,msg_supject,msg_content,from_user_id,admin_id from MESSAGES where to_user_id="+u_id+" ";
    ResultSet set1=statement1.executeQuery(sql1);
    msgstable.getItems().clear();
    while (set1.next()){
        message m=new message();
        m.setFrom(set1.getInt(4));
        m.setContent(set1.getString(3));
        m.setSubject(set1.getString(2));
        list.add(m);
    }
    msgstable.setItems(list);

    }

    /////send msg handel
    @FXML
    private TextField tomsg;

    @FXML
    private TextField subjectmsg;

    @FXML
    private JFXTextArea contentmsg;

    @FXML
    private void sendmsg(ActionEvent event) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        con.setAutoCommit(false);
        Statement statement=con.createStatement();
        String s="select * from current_user_in";
        ResultSet set=   statement.executeQuery(s);
        int id=0;
        while (set.next()){
            id=set.getInt(1);
        }
        con.close();
//////////////////////// insert data
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        c.setAutoCommit(false);
        Statement s1=c.createStatement();
        String sql="insert into MESSAGES values(msg_seq.nextval,'"+subjectmsg.getText()+"','"+contentmsg.getText()+"',"+id+","+Integer.parseInt(tomsg.getText())+","+null+")";
        s1.executeQuery(sql);
        c.commit();
        c.close();
        JOptionPane.showMessageDialog(null,"Send Successfully.");

    }





    ////




    ////update profile

    @FXML
    void saveprofile(ActionEvent event) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        con.setAutoCommit(false);
        Statement st=con.createStatement();
        String s="select * from current_user_in";
        ResultSet set=st.executeQuery(s);
        int u_id=0;
        while(set.next()){
            u_id=set.getInt(1);
        }
        con.close();
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        c.setAutoCommit(false);
        Statement s1=c.createStatement();
        String a[]=profilename.getText().split("   ");
        String sql="update user1 set user_fn='"+a[0]+"'where user_id="+u_id+"";
        s1.executeQuery(sql);
        c.commit();
        sql="update user1 set user_ln='"+a[1]+"'where user_id="+u_id+"";
        s1.executeQuery(sql);
        c.commit();
        sql="update user1 set user_db='"+db.getText()+"'where user_id="+u_id+"";
        s1.executeQuery(sql);
        c.commit();
        sql="update user1 set user_gender='"+gender.getText()+"'where user_id="+u_id+"";
        s1.executeQuery(sql);
        c.commit();
        sql="update user1 set user_phone#='"+phone.getText()+"'where user_id="+u_id+"";
        s1.executeQuery(sql);
        c.commit();
        sql="update user1 set user_email='"+email.getText()+"'where user_id="+u_id+"";
        s1.executeQuery(sql);
        c.commit();
        sql="update user1 set user_image='"+profilephoto.getImage().getUrl()+"'where user_id="+u_id+"";
        s1.executeQuery(sql);
        c.commit();
        c.close();
        JOptionPane.showMessageDialog(null,"Saved Changes");
    }
}
