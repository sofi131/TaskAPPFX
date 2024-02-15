package com.ceica.taskappfx.controllerviews;

import com.ceica.taskappfx.controller.TaskController;
import com.ceica.taskappfx.models.Rol;
import com.ceica.taskappfx.models.User;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    //lista observable
    private ObservableList<User> observableList = FXCollections.observableArrayList();
    //esto es por el tableview, que hay que hacerlo así
    @FXML
    public void initialize(){
        idColumn.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getIduser()));
        userNameColumn.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getUsername()));
        rolColumn.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getRol().getDescription()));
        //tblUser.setItems(observableList);

        //comboRol.getItems().addAll();
    }
//contructor
    public AdminController() {
        //conexión a la bd
//        List<User> userList=taskController.getAllUser();
//        observableList.addAll(userList);
    }
    @Override
    public void cargaInicial() {
        List<User> userList=taskController.getAllUser();
        observableList.addAll(userList);
        tblUsers.setItems(observableList);
        //lista de roles
        List<Rol> rolList=taskController.getRol();
        comboRol.getItems().addAll(rolList);
    }
}
