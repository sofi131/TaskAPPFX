package com.ceica.taskappfx.controllerviews;

import com.ceica.taskappfx.controller.TaskController;

public interface iControllerView {
    //la clase que implemente esa interfaz debe de tener este método -> TaskController
    public void setTaskController (TaskController taskController);
}
