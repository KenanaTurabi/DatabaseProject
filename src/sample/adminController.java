/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import com.jfoenix.controls.JFXButton;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.sun.javafx.collections.MappingChange;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import oracle.jdbc.datasource.impl.OracleDataSource;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author kenana
 */
public class adminController
 implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private Label Menu;

    @FXML
    private Label MenuClose;

    @FXML
    private AnchorPane slider;

    @FXML
    private AnchorPane Req_pane;

    @FXML
    private ImageView imge;

    @FXML
    private TableView<user> UserTable;

    @FXML
    private TableColumn<user, String> Id;

    @FXML
    private TableColumn<user, String> Fname;

    @FXML
    private TableColumn<user, String> Lname;

    @FXML
    private TableColumn<user, String> Email;

    @FXML
    private TableColumn<user,String>Pnumber;

    @FXML
    private TableColumn<user, String> DB;

    @FXML
    private TableColumn<user, String> Sex;

    @FXML
    private TableColumn<user, String> Emoney;

    @FXML
    private JFXButton userinfoback;

    @FXML
    private JFXButton UserInfoButton;

    @FXML
    private AnchorPane UserInfoTblPane;

    @FXML
    private AnchorPane Adminpane;
    @FXML
    private TableView <Requests>Req_tbl;
    @FXML
    private TableColumn<Requests,String> sur_name_col;

    @FXML
    private TableColumn<Requests,String> desc_col;

    @FXML
    private TableColumn<Requests,String> s_id_col;

    @FXML
    private TableColumn<Requests,String> user_id_col;

    @FXML
    private TableColumn<Requests,String> price_col;

    @FXML
    private TableColumn<Requests,String> Period_col;




    ObservableList <user> list = FXCollections.observableArrayList();
    ObservableList<Requests> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        slider.setTranslateX(-176);
        Menu.setOnMouseClicked(event -> {
            imge.setRotate(90);
            TranslateTransition slide =new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-176);
            slide.setOnFinished((ActionEvent e)->{
                Menu.setVisible(false);
                MenuClose.setVisible(true);
            });
        });

        MenuClose.setOnMouseClicked(event -> {
            TranslateTransition slide =new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-176);
            slide.play();

            slider.setTranslateX(0);
            slide.setOnFinished((ActionEvent e)->{
                Menu.setVisible(true);
                MenuClose.setVisible(false);
            });
        });

        Id.setCellValueFactory(new PropertyValueFactory<user,String>("Id"));
        Fname.setCellValueFactory(new PropertyValueFactory<user,String>("Fname"));
        Lname.setCellValueFactory(new PropertyValueFactory<user,String>("Lname"));
        Email.setCellValueFactory(new PropertyValueFactory<user,String>("Email"));
        Pnumber.setCellValueFactory(new PropertyValueFactory<user,String>("PhoneNum"));
        DB.setCellValueFactory(new PropertyValueFactory<user,String>("DB"));
        Sex.setCellValueFactory(new PropertyValueFactory<user,String>("Sex"));
        Emoney.setCellValueFactory(new PropertyValueFactory<user,String>("money"));
        UserTable.setItems(list);



        sur_name_col.setCellValueFactory(new PropertyValueFactory<Requests,String>("Sur_name"));
        desc_col.setCellValueFactory(new PropertyValueFactory<Requests,String>("Sur_description"));
        s_id_col.setCellValueFactory(new PropertyValueFactory<Requests,String>("Sur_id"));
        user_id_col.setCellValueFactory(new PropertyValueFactory<Requests,String>("User_id"));
        price_col.setCellValueFactory(new PropertyValueFactory<Requests,String>("Sur_price"));
        Period_col.setCellValueFactory(new PropertyValueFactory<Requests,String>("Sur_Needed_time"));
reportpane.setVisible(false);



    }
    @FXML
    void OpenAdminPane(ActionEvent event) {
        Adminpane.setVisible(true);
        UserInfoTblPane.setVisible(false);
        Req_pane.setVisible(false);
    }
    @FXML
    void OpenUserInfo(ActionEvent event) throws SQLException {
        Adminpane.setVisible(false);
        UserInfoTblPane.setVisible(true);
        Req_pane.setVisible(false);
        reportpane.setVisible(false);
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        c.setAutoCommit(false);
        Statement s=c.createStatement();
        String sql="select * from user1";
        ResultSet set=s.executeQuery(sql);
        UserTable.getItems().clear();
        while (set.next()){
            user u=new user();
            u.setId(String.valueOf(set.getInt(1)));
            u.setFname(set.getString(2));
            u.setLname(set.getString(3));
            u.setDB(set.getString(4));
            u.setSex(set.getString(5));
            u.setEmail(set.getString(6));
            u.setPhoneNum(set.getString(7));
            u.setMoney(String.valueOf(set.getInt(8)) );
            list.add(u);
        }
        UserTable.setItems(list);
        c.close();
    }
    @FXML
    private void deleteRowFromTable (ActionEvent event){
        Req_tbl.getItems().removeAll(Req_tbl.getSelectionModel().getSelectedItem());
    }


    @FXML
    void acceptservice(ActionEvent event) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        connection.setAutoCommit(false);
        Statement statement=connection.createStatement();
        String sq="select admin_id from current_admin_in";
        ResultSet set=statement.executeQuery(sq);
        int admin_id=0;
        while (set.next()){
            admin_id=set.getInt(1);
        }
        connection.close();

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        c.setAutoCommit(false);
        Statement s=c.createStatement();
        String sql="insert into control values("+admin_id+","+Integer.parseInt(Req_tbl.getSelectionModel().getSelectedItem().getSur_id())+")";
        s.executeQuery(sql);
        c.commit();
        c.close();
        Req_tbl.getItems().removeAll(Req_tbl.getSelectionModel().getSelectedItem());
         JOptionPane.showMessageDialog(null,"This service Added successfully ");

    }




    @FXML

    void BackT0AdminPane(ActionEvent event) {
        Adminpane.setVisible(true);
        Req_pane.setVisible(false);
        UserInfoTblPane.setVisible(false);
    }
    @FXML
    void OpenReq_pane(ActionEvent event) throws SQLException {
        Adminpane.setVisible(false);
        UserInfoTblPane.setVisible(false);
        Req_pane.setVisible(true);
        reportpane.setVisible(false);
data.clear();
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
        c.setAutoCommit(false);
        Statement s=c.createStatement();
        String sql="select * from service where service_id not in (select service_id from control)";
        ResultSet set=s.executeQuery(sql);
        while (set.next()){
           Requests r=new Requests();
           r.setSur_id(String.valueOf(set.getInt(1)));
           r.setSur_name(set.getString(2));
           r.setSur_description(set.getString(3));
           r.setSur_price(String.valueOf(set.getInt(4)));
           r.setSur_Needed_time(set.getString(5));
           r.setUser_id(String.valueOf(set.getInt(7)));
           r.setDep_id(set.getInt(6));
           data.add(r);

        }
        Req_tbl.setItems(data);
        c.close();
    }


    @FXML private javafx.scene.control.Button logout;
    @FXML
    void logout(ActionEvent event) throws SQLException {

        int v = JOptionPane.showConfirmDialog(null, "Do you want to logout ?");
        if (v == 1 || v == 2) return;
        else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
            connection.setAutoCommit(false);
            Statement statement=connection.createStatement();
            String sql="delete from current_admin_in";
            statement.executeQuery(sql);
            connection.commit();
            connection.close();
            Stage stage=(Stage) logout.getScene().getWindow();
            stage.close();
        }
    }


    ////show report

    @FXML
    void showreport(ActionEvent event){
        OracleDataSource ods;
        try{
            ods=new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##baraa");
            ods.setPassword("654321");
            Connection con=ods.getConnection();
            InputStream in =new FileInputStream(new File("test.jrxml"));
            JasperDesign jd=JRXmlLoader.load(in);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp;
            jp=JasperFillManager.fillReport(jr,null,con);
            JasperViewer viewer=new JasperViewer(jp,false);
            viewer.setTitle("report");
            viewer.setVisible(true);
            con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }

    }

    @FXML
    private AnchorPane welcomepane;

    @FXML
    private AnchorPane reportpane;

    @FXML
    void openreportpane(ActionEvent event) {
reportpane.setVisible(true);
welcomepane.setVisible(false);

        UserInfoTblPane.setVisible(false);
        Req_pane.setVisible(false);
    }
    @FXML
    void back(ActionEvent event) {
reportpane.setVisible(false);
welcomepane.setVisible(true);

    }

    @FXML
    void showreport1(ActionEvent event) {

        OracleDataSource ods;
        try{
            ods=new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##baraa");
            ods.setPassword("654321");
            Connection con=ods.getConnection();
            InputStream in =new FileInputStream(new File("pro.jrxml"));
            JasperDesign jd=JRXmlLoader.load(in);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp;
            jp=JasperFillManager.fillReport(jr,null,con);
            JasperViewer viewer=new JasperViewer(jp,false);
            viewer.setTitle("report");
            viewer.setVisible(true);
            con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }





    }

    @FXML
    private TextField id;
    @FXML
    void showreport2(ActionEvent event) {


        OracleDataSource ods;
        try{
            ods=new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##baraa");
            ods.setPassword("654321");
            Connection con=ods.getConnection();
            InputStream in =new FileInputStream(new File("project.jrxml"));
            JasperDesign jd=JRXmlLoader.load(in);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp;
            Map<String,Object> para=new HashMap<String,Object>();
            para.put("Parameter1",id.getText());
            jp=JasperFillManager.fillReport(jr,para,con);
            JasperViewer viewer=new JasperViewer(jp,false);
            viewer.setTitle("report");
            viewer.setVisible(true);
            con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }



    }






    @FXML
    void create1(ActionEvent event) {

        OracleDataSource ods;
        try{
            ods=new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##baraa");
            ods.setPassword("654321");
            Connection con=ods.getConnection();
            InputStream in =new FileInputStream(new File("test.jrxml"));
            JasperDesign jd=JRXmlLoader.load(in);
            JasperReport jr=JasperCompileManager.compileReport(jd);

            JasperPrint jp=JasperFillManager.fillReport(jr,null,con);
            OutputStream ou=new FileOutputStream(new File("Dep-report.pdf"));
            JasperExportManager.exportReportToPdfStream(jp,ou);
            ou.close();
            in.close();
            con.close();
            JOptionPane.showMessageDialog(null, "pdf report created successfully");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }



    }

    @FXML
    void create2(ActionEvent event) {


        OracleDataSource ods;
        try{
            ods=new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##baraa");
            ods.setPassword("654321");
            Connection con=ods.getConnection();
            InputStream in =new FileInputStream(new File("pro.jrxml"));
            JasperDesign jd=JRXmlLoader.load(in);
            JasperReport jr=JasperCompileManager.compileReport(jd);

            JasperPrint jp=JasperFillManager.fillReport(jr,null,con);
            OutputStream ou=new FileOutputStream(new File("Buy-report.pdf"));
            JasperExportManager.exportReportToPdfStream(jp,ou);
            ou.close();
            in.close();
            con.close();
            JOptionPane.showMessageDialog(null, "pdf report created successfully");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    @FXML
    void create3(ActionEvent event) {


        OracleDataSource ods;
        try{
            ods=new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##baraa");
            ods.setPassword("654321");
            Connection con=ods.getConnection();
            InputStream in =new FileInputStream(new File("test.jrxml"));
            JasperDesign jd=JRXmlLoader.load(in);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            Map<String,Object> para=new HashMap<String,Object>();
            para.put("Parameter1",id.getText());
            JasperPrint jp=JasperFillManager.fillReport(jr,para,con);
            OutputStream ou=new FileOutputStream(new File("Dep-services-report.pdf"));
            JasperExportManager.exportReportToPdfStream(jp,ou);
            ou.close();
            in.close();
            con.close();
            JOptionPane.showMessageDialog(null, "pdf report created successfully");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

  @FXML
    void close(ActionEvent event) throws SQLException {
      int v = JOptionPane.showConfirmDialog(null, "Do you want to logout ?");
      if (v == 1 || v == 2) return;
      else {
          DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
          Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##baraa", "654321");
          connection.setAutoCommit(false);
          Statement statement=connection.createStatement();
          String sql="delete from current_admin_in";
          statement.executeQuery(sql);
          connection.commit();
          connection.close();
          Stage stage=(Stage) logout.getScene().getWindow();
          stage.close();
      }

  }



}