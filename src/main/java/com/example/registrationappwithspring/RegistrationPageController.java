package com.example.registrationappwithspring;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationPageController {
    private Stage stage;
    private Scene scene;

    public void SwitchToLogin(ActionEvent event){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Login");
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
    private TextField FirstName;

    @FXML
    private TextField LastName;

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
        RegistrationBtn.setOnAction(actionEvent -> {
            DatabaseHandler user = new DatabaseHandler();
            user.SignUpUser(FirstName.getText(),LastName.getText(),UserName.getText(),Password.getText());
        });
    }

}
