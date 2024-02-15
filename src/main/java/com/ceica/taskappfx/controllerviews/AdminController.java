package com.ceica.taskappfx.controllerviews;

import com.ceica.taskappfx.controller.TaskController;
import com.ceica.taskappfx.models.User;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

//public class AdminController implements iControllerView {
public class AdminController extends ControllerView /*implements iControllerView*/ {
    //private TaskController taskController;
  /*  @Override
    public void setTaskController(TaskController taskController) {
        this.taskController=taskController;
    }*/

    @FXML
    protected TableView<User> tblUser;
    @FXML
    protected TableColumn<User, Integer> idColumn;
    @FXML
    protected TableColumn<User, String> userNameColumn;
    @FXML
    protected TableColumn<User, String> rolColumn;
    //lista observable
    private ObservableList<User> observableList = FXCollections.observableArrayList();
    @FXML
    public void initialize(){
        idColumn.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getIduser()));
        userNameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getUsername()));
        rolColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getRol().getDescription()));
        //tblUser.setItems(observableList);
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
        tblUser.setItems(observableList);
    }
}
