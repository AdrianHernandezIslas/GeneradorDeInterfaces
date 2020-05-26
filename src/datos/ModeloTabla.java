/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import control.ManejaDatos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ChuyPablo
 */
public abstract class ModeloTabla extends AbstractTableModel{
    protected List<Object []> dato;
    protected ManejaDatos baseDatos;
    protected String encabezado[];
    protected Class tipos[];
    
    public ModeloTabla()
    {
    }
    
    public void setDatos(List<Object []> d, ManejaDatos bd){
        dato = d;
        baseDatos = bd;
    }
    
    public ManejaDatos getBaseDatos(){
        return baseDatos;
    }
    
    @Override
    public Class getColumnClass(int c){
        return tipos[c];
    }
    
    @Override
    public int getRowCount() {
        return dato.size();
    }

    @Override
    public int getColumnCount() {
        return tipos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return dato.get(rowIndex)[columnIndex];
    }
    
    @Override
    public abstract void setValueAt(Object aValue,int r, int c);
    
    @Override
    public String getColumnName(int col){
        return encabezado[col];
    }
    
    
    
}
