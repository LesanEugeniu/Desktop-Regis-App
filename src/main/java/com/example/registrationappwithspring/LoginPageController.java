package com.example.registrationappwithspring;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LoginPageController {

    private Stage stage;
    private Scene scene;

    public void SwitchToRegistration(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("RegistrationPage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Registration");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void SwitchToSucces(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Succes.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Succes");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LoginBtn;

    @FXML
    private TextField Password;

    @FXML
    private Button RegistrationBtn;

    @FXML
    private TextField UserName;

    @FXML
    void initialize() {
        LoginBtn.setOnAction(actionEvent -> {
            List<String> arr = new ArrayList();
            DatabaseHandler hd = new DatabaseHandler();
            String password = Password.getText();
            String userName = UserName.getText();
            //System.out.println(password + " " + userName);
            arr = hd.SelectFromDB();
            for (int i = 0; i < arr.size(); i++) {
                String UserAndPass = arr.get(i);
                String subSTR = UserAndPass.substring(1, UserAndPass.length() - 1);
                String[] subARR = subSTR.split(", ");
                if (subARR[0].trim().equals(userName) && subARR[1].trim().equals(password)){
                    System.out.println("Succes.");
                        SwitchToSucces(actionEvent);
                    break;
                }
                else{
                    System.out.println("Password or login incorect.");
                }
            }
        });
    }

}
