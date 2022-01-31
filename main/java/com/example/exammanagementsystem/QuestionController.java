package com.example.exammanagementsystem;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class QuestionController implements Initializable {
    DBC dbc = new DBC();
    Connection con = dbc.connMethod();
    @FXML
    public ComboBox<String> comb;

    public QuestionController() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comb.setItems(FXCollections.observableArrayList("Q1","Q2","Q3","Q4","Q5","Q6","Q7","Q8","Q9","Q10"));
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 420);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private Button backbtn;

    @FXML
    private TextField c1;

    @FXML
    private TextField c2;

    @FXML
    private TextField c3;

    @FXML
    private TextField c4;


    @FXML
    private Button insbtn;

    @FXML
    private Button qnobtn;

    @FXML
    private TextField quest;

    @FXML
    private TextField ans;

  /*  @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("question.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 980, 620);
        Stage window = new Stage();
        window.setTitle("Exam Management System");
        window.setScene(scene);
        window.show();
    }*/


    public void insertMethod() throws SQLException {
        String q = "insert into Question(q,c1,c2,c3,c4,an)values('"+quest.getText()+"','"+c1.getText()+"','"+c2.getText()+"','"+c3.getText()+"','"+c4.getText()+"','"+ans.getText()+"',')";
        ResultSet r = con.createStatement().executeQuery(q);
        while(r.next()){
            JOptionPane.showMessageDialog(null, "successfully refajhddf....");
        }

    }
}
