/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

import vista.Aplicacion;
import vista.AplicacionProfesor;

/**
 *
 * @author ChuyPablo
 */
public class FabricaProfesor extends FabricaDeInterfaces{
     @Override
    public Aplicacion getAplicacion() {
        return new AplicacionProfesor();
        }
}
