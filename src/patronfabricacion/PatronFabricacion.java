/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronfabricacion;

import Fabricas.FabricaDeInterfaces;
import datos.ModeloTabla;
import vista.Aplicacion;
import vista.*;

/**
 *
 * @author ChuyPablo
 */
public class PatronFabricacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aplicacion in = new AplicacionServEsc();
        Thread hilo = new Thread(in);
        hilo.start();
        Aplicacion in2 = new AplicacionAlumno();
        Thread hilo2 = new Thread(in2);
        hilo2.start();
        Aplicacion in3 = new AplicacionProfesor();
        Thread hilo3 = new Thread(in3);
        hilo3.start();
      
        
        /*Con fábrica abstracta
            FabricaDeInterfaces fi = FabricaDeInterfaces.getFabricaDe("Alumno");
            Aplicacion app = fi.getAplicacion();
            Thread hilo1 = new Thread(app);
            hilo1.start();
        */
    }
    
}
