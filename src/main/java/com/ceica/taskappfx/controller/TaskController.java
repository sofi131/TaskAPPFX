package com.ceica.taskappfx.controller;



import com.ceica.taskappfx.models.Task;
import com.ceica.taskappfx.models.User;

import java.time.LocalDate;
import java.util.List;

public class TaskController {
    public static User userLogged;

    public boolean login(String username,String password){

        User user=new User();
        userLogged=user.login(username,password);
        if(userLogged!=null){
            return true;
        }else {
            return false;
        }
    }
    //crear usuario
    public boolean createUser(String username,String pass,int rol){
        User user=new User();
        return user.insertar("(username,password,idrol) values (?,?,?)",username,pass,rol);
    }
    //editar contraseña
    public boolean editPassword(String username,String password){
        User user=new User();
        return user.actualizar("password=? where username=?",password,username);
    }
    //crear tarea
    public boolean createTask(String title, String description, LocalDate deadline){
        Task task=new Task();
        task.insertar("(title,description,deadline,iduser) values (?,?,?,?)",title,description,deadline,userLogged.getIduser());
        return true;
    }

    public List<Task> getAllTaskByUser(){
        Task task=new Task();
        return task.getAllByUser(userLogged.getIduser());
    }
    public List<Task> getAllTask(){
        Task task=new Task();
        return task.getAll();
    }
    //completar task
    public boolean completeTask(int idtask){
        Task task=new Task();
        return task.actualizar("status=? where idtask=?",true, idtask);
    }
//si es admin
    public static boolean isAdmin() {
        return userLogged.getRol().getIdrol()==2?true:false;
    }
}