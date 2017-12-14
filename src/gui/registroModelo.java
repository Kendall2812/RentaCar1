/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;
import bo.ModeloBO;
import dao.ModeloDAO;
import entities.MiError;
import entities.Modelo;
import java.util.ArrayList;

/**
 *
 * @author Kendall
 */
public class registroModelo extends javax.swing.JFrame {

    /**
     * Creates new form registroMarcaModeloEstilo
     */
    String tipoAccion = "";
    String seleccionado = "";
    String modeloEditado = "";
    String modeloEliminado = "";
    ArrayList modelos = new ArrayList();

    public registroModelo(String tipoaccion) {
        initComponents();
        this.setLocationRelativeTo(null);
        tipoAccion = tipoaccion;
        this.setTitle("Informacion del Modelo Vehiculo.");
        realizarAccion();
    }

    public void realizarAccion() {//the method what it does is check what kind of action is going to be done  whether  to register or modify or delete models
        System.out.println(tipoAccion);
        if (tipoAccion.equals("registrar")) {
            txtNombreModelo.setEnabled(true);
            btnRegistrar.setEnabled(true);

        } else if (tipoAccion.equals("editar")) {
            txtEditarModelo.setEnabled(true);
            btnGuardarModeloEditado.setEnabled(true);
            btnRefrescarListaEditada.setEnabled(true);
            jCBEditarModelos.setEnabled(true);
            cargarModelos();

        } else if (tipoAccion.equals("eliminar")) {
            jCB1EliminarModelos.setEnabled(true);
            btnRefrecarModeloEliminado.setEnabled(true);
            btnEliminar.setEnabled(true);
            cargarModelos();
        }
    }

    public void cargarModelos() {//this method is for load the models in the Combo Box
        ModeloDAO modelo = new ModeloDAO();
        if (tipoAccion.equals("editar")) {
            modelos = modelo.cargarModelo();
            jCBEditarModelos.addItem("Selecionar");
            for (int x = 0; x < modelos.size(); x++) {
                jCBEditarModelos.addItem(modelos.get(x).toString());
            }
        }
        if (tipoAccion.equals("eliminar")) {
            modelos = modelo.cargarModelo();
            jCB1EliminarModelos.addItem("Selecionar");
            for (int x = 0; x < modelos.size(); x++) {
                jCB1EliminarModelos.addItem(modelos.get(x).toString());
            }
        }
    }

    public void registrarModelo() {//this method is for register the models 
        Modelo r = new Modelo();
        try {
            r.setNombre(txtNombreModelo.getText());
            ModeloBO mo = new ModeloBO();
            if (mo.verificarModelo(r)) {
                JOptionPane.showMessageDialog(null, "Se registro con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "vuelva a intentarlo");
            }
        } catch (MiError ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error no puede quedar el espacio en blanco. ");
        }
    }

    public void editarModelo() {//this method is for modify the models
        modeloEditado = txtEditarModelo.getText();
        Modelo mod = new Modelo();
        try {
            mod.setNombremodificado(seleccionado);
            mod.setNombre(modeloEditado);
            ModeloBO mo = new ModeloBO();
            if (mo.editarModelo(mod)) {
                JOptionPane.showMessageDialog(null, "Se modifico con exito.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error el espacio no debe quedar vacio. " + e);
        }
    }

    public void eliminarModelo() {//this method is for delete the models 
        modeloEliminado = jCB1EliminarModelos.getSelectedItem().toString();

        Modelo es = new Modelo();
        try {
            es.setNombre(modeloEliminado);
            ModeloBO mo = new ModeloBO();
            if (mo.EliminarModelo(es)) {
                JOptionPane.showMessageDialog(null, "Se elimino con exito.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error el espacio no debe quedar vacio. " + e);
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

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreModelo = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCBEditarModelos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtEditarModelo = new javax.swing.JTextField();
        btnGuardarModeloEditado = new javax.swing.JButton();
        btnRefrescarListaEditada = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCB1EliminarModelos = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        btnRefrecarModeloEliminado = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setText("Registro de Modelo");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Modelo");

        txtNombreModelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreModelo.setEnabled(false);

        btnRegistrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setEnabled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtNombreModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegresar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Editar Modelos");

        jCBEditarModelos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCBEditarModelos.setEnabled(false);
        jCBEditarModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEditarModelosActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Editar");

        txtEditarModelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEditarModelo.setEnabled(false);

        btnGuardarModeloEditado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGuardarModeloEditado.setText("Guardar");
        btnGuardarModeloEditado.setEnabled(false);
        btnGuardarModeloEditado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarModeloEditadoActionPerformed(evt);
            }
        });

        btnRefrescarListaEditada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRefrescarListaEditada.setText("Refrescar Lista");
        btnRefrescarListaEditada.setEnabled(false);
        btnRefrescarListaEditada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarListaEditadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBEditarModelos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefrescarListaEditada)
                    .addComponent(btnGuardarModeloEditado)
                    .addComponent(txtEditarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBEditarModelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(btnGuardarModeloEditado)
                .addGap(18, 18, 18)
                .addComponent(btnRefrescarListaEditada)
                .addGap(35, 35, 35))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setText("Eliminar Modelo");

        jCB1EliminarModelos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCB1EliminarModelos.setEnabled(false);

        btnEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRefrecarModeloEliminado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRefrecarModeloEliminado.setText("Refrescar Lista");
        btnRefrecarModeloEliminado.setEnabled(false);
        btnRefrecarModeloEliminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrecarModeloEliminadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCB1EliminarModelos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRefrecarModeloEliminado)
                            .addComponent(btnEliminar))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCB1EliminarModelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(btnRefrecarModeloEliminado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnRegresar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrarModelo();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnGuardarModeloEditadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarModeloEditadoActionPerformed
        editarModelo();
    }//GEN-LAST:event_btnGuardarModeloEditadoActionPerformed

    private void jCBEditarModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEditarModelosActionPerformed
        txtEditarModelo.setText("");
        if (jCBEditarModelos != null) {
            if (jCBEditarModelos.getSelectedItem() != null) {
                seleccionado = jCBEditarModelos.getSelectedItem().toString();
                txtEditarModelo.setText(seleccionado);
            }
        }
    }//GEN-LAST:event_jCBEditarModelosActionPerformed

    private void btnRefrescarListaEditadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarListaEditadaActionPerformed
        jCBEditarModelos.removeAllItems();
        txtEditarModelo.setText("");
        cargarModelos();
    }//GEN-LAST:event_btnRefrescarListaEditadaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarModelo();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRefrecarModeloEliminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrecarModeloEliminadoActionPerformed
        jCB1EliminarModelos.removeAllItems();
        cargarModelos();
    }//GEN-LAST:event_btnRefrecarModeloEliminadoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Administration_Window regresar = new Administration_Window();
        regresar.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(registroModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroModelo("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarModeloEditado;
    private javax.swing.JButton btnRefrecarModeloEliminado;
    private javax.swing.JButton btnRefrescarListaEditada;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> jCB1EliminarModelos;
    private javax.swing.JComboBox<String> jCBEditarModelos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtEditarModelo;
    private javax.swing.JTextField txtNombreModelo;
    // End of variables declaration//GEN-END:variables
}
