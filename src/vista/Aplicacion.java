/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ManejaDatos;
import datos.ModeloTabla;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author ChuyPablo
 */
public abstract class Aplicacion extends JFrame implements ActionListener,Runnable{
    protected ModeloTabla mt;
    protected ManejaDatos baseDatos;
    protected JTable tabla;
    protected JScrollPane scBar;
    protected JPanel pnlTabla,pnlOpciones,pnlBtns,pnlArriba,pnlCentro;
    protected JButton btnRegistrar,btnTerminar;
    protected Font negrita;
    
    public Aplicacion(){
        negrita = new Font("Futura", Font.BOLD, 13);
        tabla = new JTable();
        scBar = new JScrollPane(tabla);
        pnlTabla = new JPanel(new GridLayout(0,1));
        pnlOpciones = new JPanel(new GridLayout(0,4));
        pnlBtns = new JPanel(new FlowLayout());
        pnlArriba = new JPanel(new BorderLayout());
        pnlCentro = new JPanel();
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(negrita);
        btnTerminar = new JButton("Terminar");
        btnTerminar.setFont(negrita);
        
    }
    
    public abstract ManejaDatos creaManejaDatos();
    public abstract ModeloTabla creaModeloTabla();
    public abstract void elementos();
}
