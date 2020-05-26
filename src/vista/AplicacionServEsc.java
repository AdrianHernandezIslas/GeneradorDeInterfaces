/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ManejaDatos;
import control.ManejaDatosServEsc;
import datos.ModeloTabla;
import datos.ModeloTablaServEsc;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 *
 * @author ChuyPablo
 */
public class AplicacionServEsc extends Aplicacion{
    
    private JLabel Titulo,Numero,Nombre,Direccion,Edad,Sexo,Semestre,Creditos,Carrera;
    private JTextField cNombre,cDireccion;
    private JComboBox cCarrera;
    private SpinnerModel model1,model2,model3;
    private JSpinner spinner, spinnerSemestre, spinnerCreditos;
    private JRadioButton hombre, mujer;
    private ButtonGroup grupo;
    private JPanel panelSexo;
    
    public AplicacionServEsc()
    {
      String consulta = "select * from dsos.estudiante";
      mt = new ModeloTablaServEsc();
      baseDatos = new ManejaDatosServEsc();
      mt.setDatos(baseDatos.consultaDatos(consulta), baseDatos);
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
        Titulo = new JLabel("SERVICIOS ESCOLARES", SwingConstants.CENTER);
        Titulo.setFont(negrita);
        Nombre = new JLabel("Nombre");
        Numero = new JLabel("Num.Control");
        Edad = new JLabel("Edad");
        Direccion = new JLabel("Direccion");
        Sexo = new JLabel("Sexo");
        Semestre = new JLabel("Semestre");
        Creditos = new JLabel("Creditos");
        Carrera = new JLabel("Carrera");
        model1 = new SpinnerNumberModel(20, 0, 100, 1); 
        model2 = new SpinnerNumberModel(1, 0, 13, 1);
        model3 = new SpinnerNumberModel(5, 0, 50, 1); 
        spinner = new JSpinner(model1);
        spinnerSemestre = new JSpinner(model2);
        spinnerCreditos = new JSpinner(model3);
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
        cCarrera = new JComboBox();
        cCarrera.addItem("Ing. Sistemas Comp");
        cCarrera.addItem("Ing. Civil");
        cCarrera.addItem("Ing. Mecanica");
        cCarrera.addItem("Ing. Gestion Empresarial");
        cCarrera.addItem("Ing. Quimica");
        cCarrera.addItem("Ing. Industrial");
        cCarrera.addItem("Lic. Administracion");
		
        
        btnRegistrar.addActionListener(this);
        btnTerminar.addActionListener(this);
       
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
       pnlOpciones.add(Carrera);
       pnlOpciones.add(cCarrera);
       pnlOpciones.add(Semestre);
       pnlOpciones.add(spinnerSemestre);
       pnlOpciones.add(Creditos);
       pnlOpciones.add(spinnerCreditos);
       pnlBtns.add(btnTerminar);
       pnlTabla.add(scBar);
       pnlCentro.add(pnlOpciones);
       pnlCentro.add(btnRegistrar);
       pnlArriba.add(Titulo, BorderLayout.NORTH);
       pnlArriba.add(pnlCentro, BorderLayout.CENTER);
       add(pnlArriba,BorderLayout.NORTH);
       add(pnlTabla,BorderLayout.CENTER);
       add(pnlBtns,BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnRegistrar){
             
             String sql = "insert into dsos.estudiante (nombre,direccion,edad,sexo,semestre,creditos,carrera) values('"+cNombre.getText()+"','"+cDireccion.getText()+"',"+spinner.getValue().toString()+",'"+(hombre.isSelected()?"Hombre":"Mujer")+"',"+spinnerSemestre.getValue().toString()+","+spinnerCreditos.getValue().toString()+",'"+cCarrera.getSelectedItem().toString()+"')";
             baseDatos.actualizarDatos(sql);
             mt.setDatos(baseDatos.consultaDatos("select * from dsos.estudiante"), baseDatos);
             mt.fireTableDataChanged();
             JOptionPane.showMessageDialog(null,"Alumno registrado con éxito");
         }else{
             if(baseDatos.cerrarSesion()){
                 System.exit(0);
             }else{
                 dispose();
             }
         }
    }

    @Override
    public void run() {
       setSize(1000,400);
        setTitle("Conexion DB");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
