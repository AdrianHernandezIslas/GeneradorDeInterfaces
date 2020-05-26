/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ManejaDatos;
import control.ManejaDatosAlumno;
import control.ManejaDatosServEsc;
import datos.ModeloTabla;
import datos.ModeloTablaAlumno;
import datos.ModeloTablaServEsc;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class AplicacionAlumno extends Aplicacion{
    private JLabel Titulo,Numero,Nombre,Direccion,Edad,Sexo;
    private JTextField cNombre,cDireccion;
    private SpinnerModel model1;
    private JSpinner spinner;
    private JRadioButton hombre, mujer;
    private ButtonGroup grupo;
    private JPanel panelSexo;
    
    public AplicacionAlumno()
    {
      String num;
      num = JOptionPane.showInputDialog("Ingresa tu número de control:");
      String consulta = "select numControl,nombre,direccion,edad,sexo from dsos.estudiante where numControl="+num;
      mt = new ModeloTablaAlumno();
      baseDatos = new ManejaDatosAlumno();
      mt.setDatos(baseDatos.consultaDatos(consulta), baseDatos);
      if(mt.getRowCount() == 0){
         JOptionPane.showMessageDialog(null,"No existe ningún alumno con ese número de control");
         System.exit(0);
      }
      tabla.setModel(mt);
      elementos();
        
    }

    @Override
    public ManejaDatos creaManejaDatos() {
       return new ManejaDatosServEsc();
    }

    @Override
    public ModeloTabla creaModeloTabla() {
        return new ModeloTablaServEsc();
    }

    @Override
    public void elementos() {
        setLayout(new BorderLayout());
        Titulo = new JLabel("INFORMACIÓN ALUMNO", SwingConstants.CENTER);
        Titulo.setFont(negrita);
        /*Nombre = new JLabel("Nombre");
        Numero = new JLabel("Num.Control");
        Edad = new JLabel("Edad");
        Direccion = new JLabel("Direccion");
        Sexo = new JLabel("Sexo");
       
        model1 = new SpinnerNumberModel(20, 0, 100, 1); 
       
        spinner = new JSpinner(model1);
       
        hombre = new JRadioButton("H");
        mujer = new JRadioButton("M");
        hombre.setSelected(true);
        grupo = new ButtonGroup();
        grupo.add(mujer);
        grupo.add(hombre);
        panelSexo = new JPanel();
        panelSexo.setSize(10, 10);
        cNombre = new JTextField();
        cNombre.setSize(10, 10);
        cDireccion = new JTextField();

       panelSexo.add(hombre);
       panelSexo.add(mujer);

       pnlOpciones.add(Nombre);
       pnlOpciones.add(cNombre);
       pnlOpciones.add(Direccion);
       pnlOpciones.add(cDireccion);
       pnlOpciones.add(Edad);
       pnlOpciones.add(spinner);
       pnlOpciones.add(Sexo);
       pnlOpciones.add(panelSexo);
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
       setSize(900,200);
        setTitle("Conexion DB");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
