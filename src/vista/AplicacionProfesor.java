/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ManejaDatos;
import control.ManejaDatosAlumno;
import control.ManejaDatosProfesor;
import control.ManejaDatosServEsc;
import datos.ModeloTabla;
import datos.ModeloTablaAlumno;
import datos.ModeloTablaProfesor;
import datos.ModeloTablaServEsc;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 *
 * @author ChuyPablo
 */
public class AplicacionProfesor extends Aplicacion{
     private JLabel Titulo,Numero,Nombre,Creditos,Calificacion;
    private JTextField cNombre;
    private SpinnerModel model1,model2;
    private JSpinner spinner,spinnerCalif;
    
    public AplicacionProfesor()
    {
      String consulta = "select numControl,nombre,creditos,calificacion from dsos.estudiante";
      mt = new ModeloTablaProfesor();
      baseDatos = new ManejaDatosProfesor();
      mt.setDatos(baseDatos.consultaDatos(consulta), baseDatos);
      tabla.setModel(mt);
      elementos();
        
    }

    @Override
    public ManejaDatos creaManejaDatos() {
       return new ManejaDatosProfesor();
    }

    @Override
    public ModeloTabla creaModeloTabla() {
        return new ModeloTablaProfesor();
    }

    @Override
    public void elementos() {
        setLayout(new BorderLayout());
        Titulo = new JLabel("MODULO PROFESOR", SwingConstants.CENTER);
        Titulo.setFont(negrita);
        /*Nombre = new JLabel("Nombre");
        Numero = new JLabel("Num.Control");
        Creditos = new JLabel("Creditos");
        Calificacion = new JLabel("Calificacion");
       
       
        model1 = new SpinnerNumberModel(20, 0, 100, 1); 
        model2 = new SpinnerNumberModel(70, 0, 100, 1);
       
        spinner = new JSpinner(model1);
        spinnerCalif = new JSpinner(model2);

        cNombre = new JTextField();
        cNombre.setSize(10, 10);
       
       
        btnTerminar.addActionListener(this);

       pnlOpciones.add(Nombre);
       pnlOpciones.add(cNombre);
    
       pnlOpciones.add(Creditos);
       pnlOpciones.add(spinner);
       pnlOpciones.add(Calificacion);
       pnlOpciones.add(spinnerCalif);
      
       */
       btnTerminar.addActionListener(this);
       pnlBtns.add(btnTerminar);
       pnlTabla.add(scBar);
       //pnlCentro.add(pnlOpciones);
       
       pnlArriba.add(Titulo, BorderLayout.NORTH);
       pnlArriba.add(pnlCentro, BorderLayout.CENTER);
       add(pnlArriba,BorderLayout.NORTH);
       add(pnlTabla,BorderLayout.CENTER);
       add(pnlBtns,BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
             if(baseDatos.cerrarSesion()){
                 System.exit(0);
             }else{
                 dispose();
             }
         
    }

    @Override
    public void run() {
       setSize(600,300);
        setTitle("Conexion DB");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
