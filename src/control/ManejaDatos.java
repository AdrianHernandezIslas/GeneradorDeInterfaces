/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import datos.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author ChuyPablo
 */
public abstract class ManejaDatos {
    protected Connection con;
    protected Conexion conec;
    protected int NUM_CAMPOS_ESTUDIANTE;
    public ManejaDatos(){
        conec = Conexion.getConexion("jdbc:mysql://localhost/dsos","root","15parislondres");
        con = Conexion.getConeccion();
    }
    
    public boolean cerrarSesion(){
        return conec.cerrarConexion();
    }
    
    public boolean actualizarDatos(String sql){
        boolean res = false;
        try {
            Statement st = con.createStatement();
            st.execute(sql);
            res=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public abstract List<Object []> consultaDatos(String sql);
}
