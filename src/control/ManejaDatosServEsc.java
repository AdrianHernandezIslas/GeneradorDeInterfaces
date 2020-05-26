/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ChuyPablo
 */
public class ManejaDatosServEsc extends ManejaDatos{
    
    public ManejaDatosServEsc()
    {
        NUM_CAMPOS_ESTUDIANTE = 8;
    }

    @Override
    public List<Object[]> consultaDatos(String sql) {
        List<Object []> datos = new ArrayList<Object []>();
        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
                Object dat[] = new Object[NUM_CAMPOS_ESTUDIANTE];
                dat[0] = rs.getInt(1);
                dat[1] = rs.getString(2);
                dat[2] = rs.getString(3);
                dat[3] = rs.getString(4);
                dat[4] = rs.getString(5);
                dat[5] = rs.getString(6);
                dat[6] = rs.getString(7);
                dat[7] = rs.getString(8);
                datos.add(dat);
            }
        } catch (SQLException e) {
            System.err.println(e.getCause()+"\n"+e.getMessage());
            e.printStackTrace();
        }
        
        return datos;
        
    }
    
}
