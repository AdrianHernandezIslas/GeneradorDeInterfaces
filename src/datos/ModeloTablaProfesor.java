/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author ChuyPablo
 */
public class ModeloTablaProfesor extends ModeloTabla{
      public ModeloTablaProfesor()
    {
        encabezado = new String[]{"numControl","nombre","creditos","calificacion"};
        tipos = new Class[]{Integer.class,String.class,Integer.class,Integer.class};
    }

    @Override
    public void setValueAt(Object aValue, int r, int c) {
         if(c>0){
            dato.get(r)[c] = (Object) aValue;
            String datos = "UPDATE dsos.estudiante set"+
                           " creditos="+dato.get(r)[2]+", calificacion="+dato.get(r)[3]+
                    " where numControl = "+dato.get(r)[0];
            baseDatos.actualizarDatos(datos);
        }
        
    }
    
    @Override
    public boolean isCellEditable(int row,int col){
        return col>1;
    }
    
    
}
