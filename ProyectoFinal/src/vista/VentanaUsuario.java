/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlVentanaUsuario;
import javax.swing.JOptionPane;



/**
 *
 * @author Andrey
 */
public class VentanaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VentanaUsuario
     */
    ControlVentanaUsuario control;
    public VentanaUsuario() {
        initComponents();
        control=new ControlVentanaUsuario(this);
        comboBox();
        eventosBotones();
        inicioBotones();
        inicioVentana();
    }
    public void comboBox()
    {
        this.jc_Tipo.removeAllItems();
        this.jc_Tipo.addItem("Estudiante");
         this.jc_Tipo.addItem("Administrador"); 
    }
    public void eventosBotones()
    {
        this.jB_Buscar.addActionListener(control);
        this.jb_Agregar.addActionListener(control);
        this.jb_Modificar.addActionListener(control);
        this.jb_Eliminar.addActionListener(control);
        
    }
    public boolean conprobarContrasena()
    {
        boolean correcto=false;
        if(new String(this.jPasw_contrasena.getPassword()).equals(new String(this.jPaw_contrasenaRepetir.getPassword())))
        {
            correcto=true;
        }
        return correcto;
    }
    public String[] devolverInfo()
    {
        String arreglo[]=new String[6];
        arreglo[0]=this.jText_Cedula.getText();
         arreglo[1]=this.jText_NombreCompleto.getText();
          arreglo[2]=new String(this.jText_NombreUsuario.getText());
          arreglo[3]=new String(this.jPasw_contrasena.getPassword());
          arreglo[4]=new String(this.jPaw_contrasenaRepetir.getPassword());
          arreglo[5]="" + this.jc_Tipo.getSelectedItem();
          return arreglo; 
    }
    public void mensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public String devolverCedula()
    {
        return this.jText_Cedula.getText();
    }
    public void mostrar(String arreglo[])
    {
        
        this.jText_NombreCompleto.setText(arreglo[0]);
        this.jText_NombreUsuario.setText(arreglo[1]);
        this.jPasw_contrasena.setText(arreglo[2]);
        this.jPaw_contrasenaRepetir.setText(arreglo[3]);
        this.jc_Tipo.setSelectedItem(arreglo[4]);
    }
    public void mostrarXML(String arreglo[])
    {
        
        this.jText_NombreCompleto.setText(arreglo[1]);
        this.jText_NombreUsuario.setText(arreglo[2]);
        this.jPasw_contrasena.setText(arreglo[3]);
        this.jPaw_contrasenaRepetir.setText(arreglo[4]);
        this.jc_Tipo.setSelectedItem(arreglo[5]);
    }
    public void inicioBotones()
    {
        this.jb_Agregar.setEnabled(false);
        this.jB_Buscar.setEnabled(true);
        this.jb_Modificar.setEnabled(false);
        this.jb_Eliminar.setEnabled(false);
    }
     public void botones2()
    {
        this.jb_Agregar.setEnabled(true);
        this.jB_Buscar.setEnabled(false);
        this.jb_Modificar.setEnabled(false);
        this.jb_Eliminar.setEnabled(false);
    }
     public void botones3()
    {
        this.jb_Agregar.setEnabled(false);
        this.jB_Buscar.setEnabled(false);
        this.jb_Modificar.setEnabled(true);
        this.jb_Eliminar.setEnabled(true);
    }
    
    public void inicioVentana()
    {
        this.jText_Cedula.setText("");
        this.jText_Cedula.setEnabled(true);
        
        this.jText_NombreCompleto.setText("");
        this.jText_NombreCompleto.setEnabled(false);
        
        this.jText_NombreUsuario.setText("");
        this.jText_NombreUsuario.setEnabled(false);
        
        this.jPasw_contrasena.setText("");
        this.jPasw_contrasena.setEnabled(false);
        
        this.jPaw_contrasenaRepetir.setText("");
        this.jPaw_contrasenaRepetir.setEnabled(false);
    }
    public void ventana2()
    {
        this.jText_Cedula.setEnabled(false);
        
        this.jText_NombreCompleto.setText("");
        this.jText_NombreCompleto.setEnabled(true);
        
        this.jText_NombreUsuario.setText("");
        this.jText_NombreUsuario.setEnabled(true);
        
        this.jPasw_contrasena.setText("");
        this.jPasw_contrasena.setEnabled(true);
        
        this.jPaw_contrasenaRepetir.setText("");
        this.jPaw_contrasenaRepetir.setEnabled(true);
    }
    public void ventana3()
    {
        this.jText_Cedula.setEnabled(false);
        
      
        this.jText_NombreCompleto.setEnabled(true);
        
     
        this.jText_NombreUsuario.setEnabled(true);
        
     
        this.jPasw_contrasena.setEnabled(true);
        
        this.jPaw_contrasenaRepetir.setEnabled(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jText_Cedula = new javax.swing.JTextField();
        jText_NombreCompleto = new javax.swing.JTextField();
        jText_NombreUsuario = new javax.swing.JTextField();
        jPasw_contrasena = new javax.swing.JPasswordField();
        jPaw_contrasenaRepetir = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jc_Tipo = new javax.swing.JComboBox<>();
        jB_Buscar = new javax.swing.JButton();
        jb_Agregar = new javax.swing.JButton();
        jb_Modificar = new javax.swing.JButton();
        jb_Eliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jLabel1.setText("Cedula");

        jLabel2.setText("Nombre Completo");

        jLabel3.setText("Nombre Usuario");

        jLabel4.setText("contraseña");

        jLabel5.setText("Repetir Contraseña");

        jLabel6.setText("Tipo:");

        jc_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jB_Buscar.setText("Buscar");

        jb_Agregar.setText("Agregar");

        jb_Modificar.setText("Modificar");

        jb_Eliminar.setText("Eliminar");

        jButton1.setText("Agregar a archivos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jc_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPaw_contrasenaRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPasw_contrasena, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jText_NombreUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jText_NombreCompleto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jText_Cedula, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jB_Buscar)
                        .addGap(32, 32, 32)
                        .addComponent(jb_Agregar)
                        .addGap(30, 30, 30)
                        .addComponent(jb_Modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jb_Eliminar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jText_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jText_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jText_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jPasw_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPaw_contrasenaRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jc_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Buscar)
                    .addComponent(jb_Agregar)
                    .addComponent(jb_Modificar)
                    .addComponent(jb_Eliminar))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
      
    }//GEN-LAST:event_formComponentHidden

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(PrincipalVentana.numSeleccion==1)
       {
        control.agregarArchivoUsuario();// TODO add your handling code here:
       } // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasw_contrasena;
    private javax.swing.JPasswordField jPaw_contrasenaRepetir;
    private javax.swing.JTextField jText_Cedula;
    private javax.swing.JTextField jText_NombreCompleto;
    private javax.swing.JTextField jText_NombreUsuario;
    private javax.swing.JButton jb_Agregar;
    private javax.swing.JButton jb_Eliminar;
    private javax.swing.JButton jb_Modificar;
    private javax.swing.JComboBox<String> jc_Tipo;
    // End of variables declaration//GEN-END:variables
}
