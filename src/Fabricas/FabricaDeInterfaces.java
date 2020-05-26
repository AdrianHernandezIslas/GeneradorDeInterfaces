/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

import vista.Aplicacion;

/**
 *
 * @author ChuyPablo
 */
public abstract class FabricaDeInterfaces {
    
    public FabricaDeInterfaces(){}

    public abstract Aplicacion getAplicacion();

    public static FabricaDeInterfaces getFabricaDe(String type) {
        if (type.equals("Alumno")) {
            return new FabricaAlumno();
        }
        else if (type.equals("Profesor")) {
            return new FabricaProfesor();
        }
        else if (type.equals("ServEscolares")) {
            return new FabricaServEsc();
        }else{
            return null;
        }
        

    }

}
