/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;

/**
 *
 * @author Kendall
 */
public class Administration_Window extends javax.swing.JFrame {

    /**
     * Creates new form Administration_Window
     */
    String registro = "";
    String edicion = "";
    String eliminar = "";
    public Administration_Window() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Administration_Window");
    }
    public void verificarCombox(){
        if(jRBRegistrar.isSelected()){
            
            registro = jCB1Registrar.getSelectedItem().toString();
            
            if(registro.equals("Registro Vehiculo")){
                registroVehiculo vehiculo= new registroVehiculo("registrar");
                vehiculo.setVisible(true);
                dispose();
            }else if(registro.equals("Registro Modelo")){
                registroModelo modelo = new registroModelo("registrar");
                modelo.setVisible(true);
                dispose();
                
            }else if(registro.equals("Registro Marca")){
                registroMarca marca = new registroMarca("registrar");
                marca.setVisible(true);
                dispose();
                
            }else if(registro.equals("Registro Estilo")){
                registroEstilo ventana = new registroEstilo("registrar");
                ventana.setVisible(true);
                dispose();
                
            }else if(registro.equals("Registro Oficina")){
                registroOficina oficina = new registroOficina("registrar");
                oficina.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar otro Item diferente de Seleccionar.");
            }
            
            
        }else if(jRBEditar.isSelected()){
            
            edicion = jCB2Editar.getSelectedItem().toString();
            
            if(edicion.equals("Editar Info Vehiculo")){
                registroVehiculo vehiculo= new registroVehiculo("editar");
                vehiculo.setVisible(true);
                dispose();
            }else if(edicion.equals("Editar Info Modelo")){
                registroModelo modelo = new registroModelo("editar");
                modelo.setVisible(true);
                dispose();
                
            }else if(edicion.equals("Editar Info Marca")){
                registroMarca marca = new registroMarca("editar");
                marca.setVisible(true);
                dispose();
                
            }else if(edicion.equals("Editar Info Estilo")){
                registroEstilo ventana = new registroEstilo("editar");
                ventana.setVisible(true);
                dispose();
                
            }else if(edicion.equals("Editar Info Oficina")){
                registroOficina oficina = new registroOficina("editar");
                oficina.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar otro Item diferente de Seleccionar.");
            }
            
            
        }else if(jRBEliminar.isSelected()){
             
            eliminar = jCB3Eliminar.getSelectedItem().toString();
            
            if(eliminar.equals("Eliminar Info Vehiculo")){//Eliminar Info Vehiculo
                registroVehiculo vehiculo= new registroVehiculo("eliminar");
                vehiculo.setVisible(true);
                dispose();
            }else if(eliminar.equals("Eliminar Info Modelo")){
                registroModelo modelo = new registroModelo("eliminar");
                modelo.setVisible(true);
                dispose();
                
            }else if(eliminar.equals("Eliminar Info Marca")){
                registroMarca marca = new registroMarca("eliminar");
                marca.setVisible(true);
                dispose();
                
            }else if(eliminar.equals("Eliminar Info Estilo")){
                registroEstilo ventana = new registroEstilo("eliminar");
                ventana.setVisible(true);
                dispose();
                
            }else if(eliminar.equals("Eliminar Info Oficina")){
                registroOficina oficina = new registroOficina("eliminar");
                oficina.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar otro Item diferente de Seleccionar.");
            }
             
        }else{
            JOptionPane.showMessageDialog(null, "Debe primero seleccionar una accion.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jCB1Registrar = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jCB2Editar = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jCB3Eliminar = new javax.swing.JComboBox<>();
        btnIr = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jRBRegistrar = new javax.swing.JRadioButton();
        jRBEditar = new javax.swing.JRadioButton();
        jRBEliminar = new javax.swing.JRadioButton();
        jMB1Opciones = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        CosultaPorCarrosAlquiladoPorFecha = new javax.swing.JMenuItem();
        VehiculoRegistradoAcordeEstado = new javax.swing.JMenuItem();
        VehiculoAsociadoAUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Registrar Informacion");

        jCB1Registrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCB1Registrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Registro Vehiculo", "Registro Modelo", "Registro Marca", "Registro Estilo", "Registro Oficina" }));
        jCB1Registrar.setEnabled(false);

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setText("Editar Informacion");

        jCB2Editar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCB2Editar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Editar Info Vehiculo", "Editar Info Modelo", "Editar Info Marca", "Editar Info Estilo", "Editar Info Oficina" }));
        jCB2Editar.setEnabled(false);

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Eliminar Datos");

        jCB3Eliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCB3Eliminar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Eliminar Info Vehiculo", "Eliminar Info Modelo", "Eliminar Info Marca", "Eliminar Info Estilo", "Eliminar Info Oficina" }));
        jCB3Eliminar.setEnabled(false);

        btnIr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnIr.setText("Ir");
        btnIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setText("Opciones");

        buttonGroup1.add(jRBRegistrar);
        jRBRegistrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRBRegistrar.setText("Registrar Informacion");
        jRBRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBRegistrarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBEditar);
        jRBEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRBEditar.setText("Editar Informacion");
        jRBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBEditarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBEliminar);
        jRBEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRBEliminar.setText("Eliminar informacion");
        jRBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBEliminarActionPerformed(evt);
            }
        });

        jMenu1.setText(" Query   ");

        CosultaPorCarrosAlquiladoPorFecha.setText("Vehiculos Alquilados por Fecha.");
        CosultaPorCarrosAlquiladoPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CosultaPorCarrosAlquiladoPorFechaActionPerformed(evt);
            }
        });
        jMenu1.add(CosultaPorCarrosAlquiladoPorFecha);

        VehiculoRegistradoAcordeEstado.setText("Vehiculos Registrados Acorde Estado.");
        VehiculoRegistradoAcordeEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiculoRegistradoAcordeEstadoActionPerformed(evt);
            }
        });
        jMenu1.add(VehiculoRegistradoAcordeEstado);

        VehiculoAsociadoAUsuario.setText("Informe de Usuario asociado a Vehiculo Alquilado. ");
        VehiculoAsociadoAUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiculoAsociadoAUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(VehiculoAsociadoAUsuario);

        jMB1Opciones.add(jMenu1);

        jMenu2.setText("Sign off");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMB1Opciones.add(jMenu2);

        setJMenuBar(jMB1Opciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIr, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jCB1Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCB2Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCB3Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(83, 83, 83))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jRBRegistrar)
                .addGap(18, 18, 18)
                .addComponent(jRBEditar)
                .addGap(18, 18, 18)
                .addComponent(jRBEliminar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jRBRegistrar)
                    .addComponent(jRBEditar)
                    .addComponent(jRBEliminar))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCB3Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCB2Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCB1Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnIr)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CosultaPorCarrosAlquiladoPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CosultaPorCarrosAlquiladoPorFechaActionPerformed
        reportePorRangoFechasVehiculosAlquilados rango = new reportePorRangoFechasVehiculosAlquilados();
        rango.setVisible(true);
        dispose();
    }//GEN-LAST:event_CosultaPorCarrosAlquiladoPorFechaActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        Login salir = new Login();
        salir.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void VehiculoRegistradoAcordeEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiculoRegistradoAcordeEstadoActionPerformed
        ReportePorVehiculosAcordeEstado estado = new ReportePorVehiculosAcordeEstado();
        estado.setVisible(true);
        dispose();
    }//GEN-LAST:event_VehiculoRegistradoAcordeEstadoActionPerformed

    private void VehiculoAsociadoAUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiculoAsociadoAUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VehiculoAsociadoAUsuarioActionPerformed

    private void btnIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrActionPerformed
        verificarCombox();
    }//GEN-LAST:event_btnIrActionPerformed

    private void jRBRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBRegistrarActionPerformed
            jCB1Registrar.setEnabled(true);
            jCB2Editar.setEnabled(false);
            jCB3Eliminar.setEnabled(false);
            jCB2Editar.setSelectedIndex(0);
            jCB3Eliminar.setSelectedIndex(0);
    }//GEN-LAST:event_jRBRegistrarActionPerformed

    private void jRBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBEditarActionPerformed
            jCB2Editar.setEnabled(true);
            jCB3Eliminar.setEnabled(false);
            jCB1Registrar.setEnabled(false);
            jCB1Registrar.setSelectedIndex(0);
            jCB3Eliminar.setSelectedIndex(0);
    }//GEN-LAST:event_jRBEditarActionPerformed

    private void jRBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBEliminarActionPerformed
            jCB3Eliminar.setEnabled(true);
            jCB1Registrar.setEnabled(false);
            jCB2Editar.setEnabled(false);
            jCB1Registrar.setSelectedIndex(0);
            jCB2Editar.setSelectedIndex(0);
    }//GEN-LAST:event_jRBEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administration_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administration_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administration_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administration_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administration_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CosultaPorCarrosAlquiladoPorFecha;
    private javax.swing.JMenuItem VehiculoAsociadoAUsuario;
    private javax.swing.JMenuItem VehiculoRegistradoAcordeEstado;
    private javax.swing.JButton btnIr;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jCB1Registrar;
    private javax.swing.JComboBox<String> jCB2Editar;
    private javax.swing.JComboBox<String> jCB3Eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMB1Opciones;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JRadioButton jRBEditar;
    private javax.swing.JRadioButton jRBEliminar;
    private javax.swing.JRadioButton jRBRegistrar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
