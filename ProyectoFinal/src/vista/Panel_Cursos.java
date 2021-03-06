package vista;

import controlador.Controlador_FRM_MantenimientoCursos;
/**
 *
 * @author tecnologiamultimedia
 */
public class Panel_Cursos extends javax.swing.JPanel {

    Controlador_FRM_MantenimientoCursos controlador;
    
    public Panel_Cursos() {
        initComponents();
        cargarCreditos();
        deshabilitarCampos();
    }
    public void cargarCreditos()
    {
        this.jcb_Creditos.removeAllItems();
        for(int contador=0;contador<=10;contador++)
        {
            this.jcb_Creditos.addItem(""+contador);
        }
        this.jcb_Creditos.setSelectedIndex(4);
        
    }
    public void agregarEventos(Controlador_FRM_MantenimientoCursos controlador)
    {
      this.controlador=controlador; //para la tecla enter
      this.btn_ConsultaRapida.addActionListener(controlador);
    }
//    public boolean verificar(String arreglo[])
//    {
//        boolean correcto=false;
//        for(int i=0;i<arreglo[1].length();i++)
//        {
//            if(Character.isLetter(arreglo[1].charAt(i)))
//            {
//                correcto=true;
//            }
//        }
//        return correcto;
//    }
    public String devolverSigla()
    {
        return this.jt_Sigla.getText();
    }
    public void habilitarEdicion()
    {
        this.jt_Sigla.setEnabled(false);
        this.jt_Nombre.setEnabled(true);
        this.jcb_Creditos.setEnabled(true);
        this.jt_Horario.setEnabled(true);
    }
    public void mostrarInformacion(String arreglo[])
    {
        this.jt_Nombre.setText(arreglo[0]);
        this.jcb_Creditos.setSelectedIndex(Integer.parseInt(arreglo[1]));
        this.jt_Horario.setText(arreglo[2]);
        
    }
   public void mostrarInformacionXML(String arreglo[])
    {
        this.jt_Nombre.setText(arreglo[1]);
        this.jcb_Creditos.setSelectedIndex(Integer.parseInt(arreglo[2]));
        this.jt_Horario.setText(arreglo[3]);
        
    }
    public void habilitarCampos()
    {
        this.jt_Nombre.setEnabled(true);
        this.jcb_Creditos.setEnabled(true);
        this.jt_Horario.setEnabled(true);
    }
    public String[] devolverInformacion()
    {
        String informacion[]=new String[4];
        informacion[0]=this.jt_Sigla.getText();
        informacion[1]=this.jt_Nombre.getText().replaceAll(" ","").trim();
        informacion[2]=""+this.jcb_Creditos.getSelectedItem();
        informacion[3]=this.jt_Horario.getText().replaceAll(" ","").trim();
        
        return informacion;
    }
    public void deshabilitarCampos()
    {
        this.jt_Sigla.setText("");
        this.jt_Sigla.setEnabled(true);
        
        this.jt_Nombre.setText("");
        this.jt_Nombre.setEnabled(false);
        
        this.jcb_Creditos.setSelectedIndex(4);
        this.jcb_Creditos.setEnabled(false);
        
        this.jt_Horario.setText("");
        this.jt_Horario.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jt_Sigla = new javax.swing.JTextField();
        jl_Sigla = new javax.swing.JLabel();
        jl_Nombre = new javax.swing.JLabel();
        jt_Nombre = new javax.swing.JTextField();
        jl_Creditos = new javax.swing.JLabel();
        jcb_Creditos = new javax.swing.JComboBox<String>();
        btn_ConsultaRapida = new javax.swing.JButton();
        jl_Horario = new javax.swing.JLabel();
        jt_Horario = new javax.swing.JTextField();

        jt_Sigla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_SiglaKeyPressed(evt);
            }
        });

        jl_Sigla.setText("Sigla");

        jl_Nombre.setText("Nombre");

        jl_Creditos.setText("Créditos");

        jcb_Creditos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_ConsultaRapida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaRapida.setActionCommand("ConsultaRapida");

        jl_Horario.setText("Horario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jl_Sigla)
                        .addGap(34, 34, 34)
                        .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ConsultaRapida))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jl_Nombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_Creditos)
                                    .addComponent(jl_Horario))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcb_Creditos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jt_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_Sigla)
                            .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_ConsultaRapida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Nombre)
                    .addComponent(jt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Creditos)
                    .addComponent(jcb_Creditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Horario)
                    .addComponent(jt_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
   //Para que la tecla enter responda a la busqueda del campo de texto
    private void jt_SiglaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_SiglaKeyPressed
        if(evt.getKeyCode()==10)
        {
           // this.controlador.buscar();
        }
    }//GEN-LAST:event_jt_SiglaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConsultaRapida;
    private javax.swing.JComboBox<String> jcb_Creditos;
    private javax.swing.JLabel jl_Creditos;
    private javax.swing.JLabel jl_Horario;
    private javax.swing.JLabel jl_Nombre;
    private javax.swing.JLabel jl_Sigla;
    private javax.swing.JTextField jt_Horario;
    private javax.swing.JTextField jt_Nombre;
    private javax.swing.JTextField jt_Sigla;
    // End of variables declaration//GEN-END:variables
}
