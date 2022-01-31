package com.example.exammanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;

public class LoginController  {
    DBC dbc = new DBC();
    Connection connection= null;
    @FXML
    protected TextField username;
    @FXML
    protected PasswordField pass;




@FXML
    private Button LoginBtn;

       public void login(javafx.event.ActionEvent event) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("question.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 980, 620);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // window.setTitle("Employee Management System");
        window.setScene(scene);
        window.show();
    }

    /*public void l2(ActionEvent event) throws Exception {


        }*/
    public void l2(javafx.event.ActionEvent event) throws Exception {  connection = dbc.connMethod();
//        PreparedStatement pst = connection.prepareStatement("select * from Login");

        try{
            ResultSet res= connection.createStatement().executeQuery("select * from Login");
            while(res.next()) {
                if ((username.getText().equals(res.getString(1))) && (pass.getText().equals(res.getString(2)))) {
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("question.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 980, 620);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setTitle("Exam Management System");
                    window.setScene(scene);
                    window.show();
                } else {

                }
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
