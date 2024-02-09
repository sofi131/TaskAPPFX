package com.ceica.taskappfx.controllerviews;

import com.ceica.taskappfx.controller.TaskController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class LoginController {
    @FXML
    protected TextField txtUsername;
    @FXML
    protected PasswordField txtPassword;
    @FXML
    protected Label lblMessage;

    public TaskController taskController=new TaskController();


    public void btnLogin(ActionEvent actionEvent) {
//        //pone en la consola hola
//        System.out.println("Hola");
        if (taskController.login(txtUsername.getText(),txtPassword.getText())){
            //en la consola
            System.out.println("Todo okay");
        }else{
            lblMessage.setText("User or Password incorrect");
        }
    }



//
//    public void onLoginAction(ActionEvent actionEvent) {
//        if (txtUsr.getText().equals("admin") & txtPass.getText().equals("1234")) {
//            //Cargamos nueva vista
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("user-view.fxml"));
//            try {
//                Parent root = loader.load();
//                UserController userController = loader.getController();
////                userController.datos="Pepe";
//                Scene scene = new Scene(root);
//                Stage stage = new Stage();
//                stage.setTitle("Gestión Usuarios");
//                stage.setScene(scene);
//                stage.show();
//                Node source = (Node) actionEvent.getSource();
//                Stage stage1 = (Stage) source.getScene().getWindow();
//                stage1.close();
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
//            lblMsg.setText("Usr o pass incorrecto");
//        }
//
//    }
}