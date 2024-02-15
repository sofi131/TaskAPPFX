package com.ceica.taskappfx.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Rol extends ModeloBase {
    private int idrol;
    private String description;

    public Rol() {
    }

    //---------------------------------------getter y setter--------------------------
    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    protected String getNombreTabla() {
        return "rol";
    }
    //-----------------------------------toString--------------------------------
    @Override
    public String toString() {
        return "Rol{" +
                "idrol=" + idrol +
                ", description='" + description + '\'' +
                '}';
    }
//de task para llenar rol
    public List<Rol> getAll() {
        //lista de roles vacía
        List<Rol> rolList = new ArrayList<>();
        //obj user obtener la conn
        Rol rol = new Rol();
        //consulta contra la bd
        Connection conn = rol.getConnection();
        String consulta = "select idrol,description from rol";
        try {
            Statement stm = conn.createStatement();
            ResultSet resultSet = stm.executeQuery(consulta);
            while (resultSet.next()) {
                Rol rol1 = new Rol();
                rol1.setIdrol(resultSet.getInt("idrol"));
                rol1.setDescription(resultSet.getString("description"));
                rolList.add(rol1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rolList;
    }
}
