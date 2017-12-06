/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import java.io.FileOutputStream;

import bo.VehiculoBO;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import entities.Vehiculo;
import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Kendall
 */
public class ReportePorVehiculosAcordeEstado extends javax.swing.JFrame {

    /**
     * Creates new form ReportePorVehiculosAcordeEstado
     */
    Image imagen ;
    Image imagen2 ;
    String estado = "";
    ArrayList estadoVehi = new ArrayList();
    public ReportePorVehiculosAcordeEstado() {
        initComponents();
        this.setTitle("Consulta por estado de Vehiculo.");
        this.setLocationRelativeTo(null);
    }
    public void imprimirVehiculosAcordeEstado() {
        String nombre = "Reporte de Vehiculos Por Estado.";
        estado = jCBTipoEstado.getSelectedItem().toString();
        if (estado.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "Favor Selecionar otro Item.");
        } else {
            Vehiculo vehi = new Vehiculo();
            try {
                vehi.setEstado(estado);
                VehiculoBO resultEstado = new VehiculoBO();
                estadoVehi = resultEstado.reporteConsultaPorEstado(vehi);
                if(estadoVehi.isEmpty() == false){
                    
                    FileOutputStream archivo = new FileOutputStream(nombre + ".pdf");
                    Document documento = new Document();
                    PdfWriter.getInstance(documento, archivo);
                    documento.open();
                    
                    
                    Paragraph parrafo = new Paragraph("Datos de los Vehiculos " + estado +"s"+ ".");
                    parrafo.setAlignment(Element.ALIGN_CENTER); //alineacion de parrafo
                    documento.add(parrafo);
                    
                    for(int x = 0; x < estadoVehi.size(); x++){
                        documento.add(new Paragraph("\n"));
                        documento.add(new Paragraph("Placa: " + estadoVehi.get(x)));
                        documento.add(new Paragraph("Marca: " + estadoVehi.get(x+1)));
                        documento.add(new Paragraph("Modelo: " + estadoVehi.get(x+2)));
                        documento.add(new Paragraph("Estilo: " + estadoVehi.get(x+3)));
//                        imagen = imagen2;
//                        imagen.scaleAbsolute(100, 100);
//                        imagen.setAlignment(Element.ALIGN_CENTER);
//                        documento.add(imagen);
                        documento.add(new Paragraph("\n"));
                        x = x + 3;
                    }
                    documento.close();
                    
                    //Esta parte abre el documento
                    try{
                        File path = new File(nombre + ".pdf");
                        Desktop.getDesktop().open(path);
                        
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "No se pudo abrir el documento. " + e);
                    }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontraron vehiculos en el estado seleccionado.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error el espacio no debe quedar vacio esta vacio. " + e);
            }
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

        jCBTipoEstado = new javax.swing.JComboBox<>();
        btnImprimir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCBTipoEstado.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jCBTipoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Disponible", "Ocupado" }));

        btnImprimir.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
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
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCBTipoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRegresar))
                .addContainerGap(734, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir)
                    .addComponent(jCBTipoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addContainerGap(387, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        imprimirVehiculosAcordeEstado();
    }//GEN-LAST:event_btnImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(ReportePorVehiculosAcordeEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportePorVehiculosAcordeEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportePorVehiculosAcordeEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportePorVehiculosAcordeEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportePorVehiculosAcordeEstado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> jCBTipoEstado;
    // End of variables declaration//GEN-END:variables
}