package com.ceica.taskappfx.controllerviews;

import com.ceica.taskappfx.controller.TaskController;

public abstract class ControllerView {
    //clase que van a heredar todos los controladores de vista
    protected TaskController taskController;

    public void setTaskController(TaskController taskController) {
        this.taskController=taskController;
        //carga inicial de datos
        cargaInicial();
    }

    public abstract void cargaInicial();
}
