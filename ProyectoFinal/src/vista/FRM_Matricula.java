/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_Matricula;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.BaseDatos;
import modelo.MetodosMatricula;

/**
 *
 * @author tecnologiamultimedia
 */
public class FRM_Matricula extends javax.swing.JFrame {

    DefaultTableModel modelo;
    Controlador_FRM_Matricula controlador;
    MetodosMatricula metodosMatricula;
    BaseDatos base;
    public FRM_Matricula( FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes, FRM_MantenimientoCursos frm_MantenimientoCursos) {
        initComponents();
        setLocation(200,200);
        controlador= new Controlador_FRM_Matricula(frm_MantenimientoEstufiantes,frm_MantenimientoCursos,this);
        agregarEventos();
        metodosMatricula=controlador.metodosMatricula;
        modelo=new DefaultTableModel();
        base=new BaseDatos();
        colocarTitulosTabla();
        
    }
    public void Limpiar()
    {
        this.jt_Cedula.setText("");
        this.jt_CodigoMatricula.setText("");
        this.jt_NombreCurso.setText("");
        this.jt_NombreEstudiante.setText("");
        this.jt_Sigla.setText("");
    }
    public String[] devolverInfo()
    {
        String informacion[]=new String[3];
        informacion[0]=this.jt_CodigoMatricula.getText();
        informacion[1]=this.jt_Cedula.getText();
        informacion[2]=this.jt_Sigla.getText();
        
        return informacion;
    }
     public String[] devolverInfoXML()
    {
        String informacion[]=new String[4];
        informacion[0]=this.jt_CodigoMatricula.getText();
        informacion[1]=this.jt_Cedula.getText();
        informacion[2]=this.jt_NombreEstudiante.getText();
        informacion[3]=this.jt_Sigla.getText();
        
        return informacion;
    }
    public void agregarEventos()
    {
        this.jb_BuscarCedula.addActionListener(controlador);
        this.jb_BuscarSigla.addActionListener(controlador);
        this.jt_Cedula.addActionListener(controlador);
        this.jb_Finalizar.addActionListener(controlador);
        this.panel_Botones1.agregarEventos(controlador);
    }
     
    public int devolverFilaSeleccionada()
    {
      return this.tbl_Tabla.getSelectedRow();
    }
    
    public void habilitarOpciones()
    {
      this.panel_Botones1.habilitarEdicion();
    }
    
    public void limpiarSigla(){
      this.jt_Sigla.setText("");
      this.jt_NombreCurso.setText("");
    }
   /*
    public void limpiarCedula(){
      this.jt_Cedula.setText("");
      this.jt_NombreEstudiante.setText("");
    }
    */
    public void resetearVentana()
    {
     this.jt_Cedula.setText("");
     this.jt_NombreEstudiante.setText("");
     this.jt_Sigla.setText("");
     this.jt_NombreCurso.setText("");
     int tamanio=modelo.getRowCount();
     
     for(int i=0; i<tamanio;i++) //Limpia la tabla
     {
       modelo.removeRow(0);
     }
   }
    public void colocarTitulosTabla(){
     this.tbl_Tabla.setModel(modelo);
     modelo.addColumn("Codigo");
     modelo.addColumn("Cedula");
     modelo.addColumn("Nombre Estudiante");
     modelo.addColumn("Sigla");
    /* 
     String arreglo[]=new String[4];
     arreglo[0]="001";
     arreglo[1]="1 1175 358";
     arreglo[2]="Stephany";
     arreglo[3]="IF-3100";
     
     modelo.addRow(arreglo);
     */
    }
    public void agregarInformacionTabla()
    {
      String arreglo[]=new String[4];
      arreglo[0]=this.jt_CodigoMatricula.getText();
      arreglo[1]=this.jt_Cedula.getText();
      arreglo[2]=this.jt_NombreEstudiante.getText();
      arreglo[3]=this.jt_Sigla.getText();
      modelo.addRow(arreglo);
    }
    public void agregarInformacionTabla(String arreglo[])
    {
      this.jt_Cedula.setText(arreglo[1]);
      this.jt_NombreEstudiante.setText(arreglo[2]);
      this.jt_Sigla.setText(arreglo[3]);
      
      modelo.addRow(arreglo);
      //colocarNombreEstudiante(arreglo[2]);
     
    }
    public void agregarInformacionTablaXML(String arreglo[])
    {
        this.jt_CodigoMatricula.setText(arreglo[0]);
      this.jt_Cedula.setText(arreglo[1]);
      this.jt_NombreEstudiante.setText(arreglo[2]);
      this.jt_Sigla.setText(arreglo[3]);
      
      modelo.addRow(arreglo);
      //colocarNombreEstudiante(arreglo[2]);
     
    }
    public String devolverNombre()
    {
        return this.jt_NombreEstudiante.getText();
    }
    
    public void colocarCodigo1(){
      this.jt_CodigoMatricula.setText(base.codigoMatricula());
    }
    public int getCantidadFilas()
    {
       return modelo.getRowCount();
    }
    
    public String devolverCedula()
    {
        return this.jt_Cedula.getText();
    }
    public String devolverCodigo()
    {
        return this.jt_CodigoMatricula.getText();
    }
    public String devolverSigla()
    {
        return this.jt_Sigla.getText();
    }
    public String devolverDato(int fila, int columna)
    {
       return ""+modelo.getValueAt(fila, columna);
    }
    public void colocarNombreCurso(String arregloC[]){ 
      this.jt_NombreCurso.setText(arregloC[0]); 
    }
     public void colocarNombreCursoXML(String arregloC[]){ 
      this.jt_NombreCurso.setText(arregloC[1]); 
    }
    public void colocarNombreEstudiante(String nombre)
    {
        this.jt_NombreEstudiante.setText(nombre);
    }
    
    public void habilitarAgregar()
    {
      this.panel_Botones1.habilitarAgregar();
    }
    public void colocarCodigo(String codigo)
    {
        this.jt_CodigoMatricula.setText(codigo);
    }
    public void mostrarInformacion(String arreglo[])
    {
        this.jt_NombreEstudiante.setText(arreglo[0]);
    }
    public void mostrarInformacionXML(String arreglo[])
    {
        this.jt_NombreEstudiante.setText(arreglo[1]);
    }
    
   
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Tabla = new javax.swing.JTable();
        jl_Cedula = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        jb_BuscarCedula = new javax.swing.JButton();
        jl_NombreEstudiante = new javax.swing.JLabel();
        jt_NombreEstudiante = new javax.swing.JTextField();
        jl_Sigla = new javax.swing.JLabel();
        jt_Sigla = new javax.swing.JTextField();
        jl_NombreCurso = new javax.swing.JLabel();
        jt_NombreCurso = new javax.swing.JTextField();
        jb_BuscarSigla = new javax.swing.JButton();
        panel_Botones1 = new vista.Panel_Botones();
        jl_CodigoMatricula = new javax.swing.JLabel();
        jt_CodigoMatricula = new javax.swing.JTextField();
        jb_Finalizar = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        tbl_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_Tabla);

        jl_Cedula.setText("Cédula");

        jb_BuscarCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        jb_BuscarCedula.setActionCommand("BuscarCedula");

        jl_NombreEstudiante.setText("Nombre Estudiante");

        jt_NombreEstudiante.setEnabled(false);

        jl_Sigla.setText("Sigla");

        jl_NombreCurso.setText("Nombre Curso");

        jt_NombreCurso.setEnabled(false);

        jb_BuscarSigla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        jb_BuscarSigla.setActionCommand("BuscarSigla");

        jl_CodigoMatricula.setText("Codigo Matricula");

        jb_Finalizar.setText("Finalizar Matricula");
        jb_Finalizar.setActionCommand("Finalizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_CodigoMatricula)
                                .addGap(36, 36, 36)
                                .addComponent(jt_CodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_Cedula)
                                    .addComponent(jl_NombreEstudiante)
                                    .addComponent(jl_Sigla)
                                    .addComponent(jl_NombreCurso))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jt_Cedula)
                                    .addComponent(jt_NombreEstudiante)
                                    .addComponent(jt_Sigla)
                                    .addComponent(jt_NombreCurso, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jb_BuscarSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jb_BuscarCedula)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jb_Finalizar)))
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_CodigoMatricula)
                    .addComponent(jt_CodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_Cedula)
                            .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_NombreEstudiante)
                            .addComponent(jt_NombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_Sigla)
                            .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_NombreCurso)
                            .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jb_BuscarCedula)
                        .addGap(38, 38, 38)
                        .addComponent(jb_BuscarSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jb_Finalizar)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
       if(PrincipalVentana.numSeleccion==1)
       {
           controlador.escribirArchivoMatricula();
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_BuscarCedula;
    private javax.swing.JButton jb_BuscarSigla;
    private javax.swing.JButton jb_Finalizar;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_CodigoMatricula;
    private javax.swing.JLabel jl_NombreCurso;
    private javax.swing.JLabel jl_NombreEstudiante;
    private javax.swing.JLabel jl_Sigla;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_CodigoMatricula;
    private javax.swing.JTextField jt_NombreCurso;
    private javax.swing.JTextField jt_NombreEstudiante;
    private javax.swing.JTextField jt_Sigla;
    private vista.Panel_Botones panel_Botones1;
    private javax.swing.JTable tbl_Tabla;
    // End of variables declaration//GEN-END:variables
}
