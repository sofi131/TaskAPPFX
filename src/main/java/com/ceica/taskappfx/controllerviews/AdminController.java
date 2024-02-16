package com.ceica.taskappfx.controllerviews;

import com.ceica.taskappfx.controller.TaskController;
import com.ceica.taskappfx.models.Rol;
import com.ceica.taskappfx.models.User;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.util.List;

//public class AdminController implements iControllerView {
public class AdminController extends ControllerView /*implements iControllerView*/ {
    //private TaskController taskController;
  /*  @Override
    public void setTaskController(TaskController taskController) {
        this.taskController=taskController;
    }*/

    @FXML
    protected TableView<User> tblUsers;
    @FXML
    protected TableColumn<User, Integer> idColumn;
    @FXML
    protected TableColumn<User, String> userNameColumn;
    @FXML
    protected TableColumn<User, String> rolColumn;
    //elementos del controlador nuevos
    @FXML
    protected TextField txtUsername;
    @FXML
    protected PasswordField txtPassword;
    @FXML
    protected PasswordField txtRePassword;
    @FXML
    protected ComboBox<Rol> comboRol;
    //btn añadir
    @FXML
    protected Label lblMsg;
    @FXML
    protected Button btnAdd;
    @FXML
    protected Button btnUpdate;

    //lista observable
    private ObservableList<User> observableList = FXCollections.observableArrayList();

    //esto es por el tableview, que hay que hacerlo así
    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getIduser()));
        userNameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getUsername()));
        rolColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getRol().getDescription()));
        //tblUser.setItems(observableList);

        //comboRol.getItems().addAll();
        //autogenera el código
        //clase abstracta
        //esto solo muestra NO RECIBE
        comboRol.setConverter(new StringConverter<Rol>() {
            @Override
            public String toString(Rol rol) {
                return rol.getDescription();
            }

            @Override
            public Rol fromString(String s) {
                return null;
            }
        });
        //evento clic
        tblUsers.setOnMouseClicked(e -> {
            if (e.getClickCount() == 1) {
                //esto me devuelve el usuario clicando
                User user = tblUsers.getSelectionModel().getSelectedItem();
                txtUsername.setText(user.getUsername());
                //y esto me devuelve el rol
                comboRol.setValue(user.getRol());
                //visibilidad de los botones a la hora de clicar
               btnAdd.setVisible(false);
               btnUpdate.setVisible(true);
            }
        });

    }

    //contructor
    public AdminController() {
        //conexión a la bd
//        List<User> userList=taskController.getAllUser();
//        observableList.addAll(userList);
    }

    @Override
    public void cargaInicial() {
        List<User> userList = taskController.getAllUser();
        observableList.addAll(userList);
        tblUsers.setItems(observableList);
        //lista de roles
        List<Rol> rolList = taskController.getRol();
        comboRol.getItems().addAll(rolList);
    }

    //método a partir del admin view
    public void btnAddUser(ActionEvent actionEvent) {
        if (txtPassword.getText().equals(txtRePassword.getText())) {
            taskController.createUser(txtUsername.getText(),
                    txtPassword.getText(),
                    comboRol.getSelectionModel().getSelectedItem().getIdrol());
            List<User> userList = taskController.getAllUser();
            observableList.clear();
            observableList.addAll(userList);
            tblUsers.refresh();
        } else {
            lblMsg.setText("Password must be equals");
        }
    }
//a partir de la view que creamos y cambiar la contraseña - generamos en user el set password
    //que no lo teníamos
    public void btnUpdateUser(ActionEvent actionEvent) {
        //comprobar si las 2 pw son iguales y actualizar el resto
        if (txtPassword.getText().equals(txtRePassword.getText())){
            User user=tblUsers.getSelectionModel().getSelectedItem();
            user.setPassword(txtPassword.getText());
            user.setRol(comboRol.getSelectionModel().getSelectedItem());
            taskController.updateUser(user);
            List<User> userList = taskController.getAllUser();
            observableList.clear();
            observableList.addAll(userList);
            tblUsers.refresh();

        }else{
            lblMsg.setText("Passwords must to be equals");
        }
        //taskController.updateUser();
        btnAdd.setVisible(true);
        btnUpdate.setVisible(false);
    }
}
