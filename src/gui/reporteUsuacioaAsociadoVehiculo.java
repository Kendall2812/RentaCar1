/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bo.RentaBO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entities.UsuAdm;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kendall
 */
public class reporteUsuacioaAsociadoVehiculo extends javax.swing.JFrame {

    /**
     * Creates new form reporteUsuacioaAsociadoVehiculo
     */
    String Foto = null;
    String Foto2 = null;
    ArrayList datosUsuarioVehiculo = new ArrayList();
    public reporteUsuacioaAsociadoVehiculo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Vehiculo asocido a Usuario.");
    }
    public void reporteAsociacion() throws FileNotFoundException {
        String nombre = "Reporte Vehiculo asociado a Usuario.";
        try {
            UsuAdm u = new UsuAdm();
            u.setCedula(Integer.parseInt(txtCedula.getText()));
            RentaBO resultado = new RentaBO();
            datosUsuarioVehiculo = resultado.reporteUsuarioVehiculo(u);
            
            if (datosUsuarioVehiculo.isEmpty() == false) {

                FileOutputStream archivo = new FileOutputStream(nombre + ".pdf");
                Document documento = new Document();
                PdfWriter.getInstance(documento, archivo);
                documento.open();
                
                Paragraph texto = new Paragraph();
                texto.add("Informacion del vehiculo asociado al usuario.");
                texto.setAlignment(Element.ALIGN_MIDDLE);
                documento.add(texto);
                
                for(int x = 0; x < datosUsuarioVehiculo.size(); x++){
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("Informacion Usuario." , FontFactory.getFont("Arial", 12)));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("Cedula: " + datosUsuarioVehiculo.get(x), FontFactory.getFont("Arial", 10)));
                    documento.add(new Paragraph("Nombre: " + datosUsuarioVehiculo.get(x + 1), FontFactory.getFont("Arial", 10)));
                    documento.add(new Paragraph("Telefono: " + datosUsuarioVehiculo.get(x + 2), FontFactory.getFont("Arial", 10)));
                    documento.add(new Paragraph("Dirección: " + datosUsuarioVehiculo.get(x + 3), FontFactory.getFont("Arial", 10)));
                    Foto = datosUsuarioVehiculo.get(x + 4).toString();//direccio Foto usuario
                    Image imagen = Image.getInstance(Foto);//agregar direccion
                    imagen.scaleAbsolute(150, 100);
                    imagen.setAlignment(Element.ALIGN_LEFT);
                    imagen.setBorder(Image.BOX);
                    imagen.setBorderWidth(4);
                    imagen.setBorderColor(BaseColor.RED);
                    documento.add(imagen);
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("Informacion Vehiculo." , FontFactory.getFont("Arial", 12)));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("Placa: " + datosUsuarioVehiculo.get(x+5), FontFactory.getFont("Arial", 10)));
                    documento.add(new Paragraph("Marca: " + datosUsuarioVehiculo.get(x+6), FontFactory.getFont("Arial", 10)));
                    documento.add(new Paragraph("Modelo: " + datosUsuarioVehiculo.get(x+7), FontFactory.getFont("Arial", 10)));
                    documento.add(new Paragraph("Transmision: " + datosUsuarioVehiculo.get(x+8), FontFactory.getFont("Arial", 10)));
                    documento.add(new Paragraph("Año: " + datosUsuarioVehiculo.get(x+9), FontFactory.getFont("Arial", 10)));
                    documento.add(new Paragraph("Estilo: " + datosUsuarioVehiculo.get(x+10), FontFactory.getFont("Arial", 10)));
                    documento.add(new Paragraph("Precio: $"+ datosUsuarioVehiculo.get(x+11), FontFactory.getFont("Arial", 10)));
                    Foto2 = datosUsuarioVehiculo.get(x + 12).toString();//direccion foto vehiculo
                    Image imagen2 = Image.getInstance(Foto2);//agregar direccion
                    imagen2.scaleAbsolute(150, 100);
                    imagen2.setAlignment(Element.ALIGN_LEFT);
                    imagen2.setBorder(Image.BOX);
                    imagen2.setBorderWidth(4);
                    imagen2.setBorderColor(BaseColor.RED);
                    documento.add(imagen2);
                    
                    x = x + 12;
                } 
                documento.close();
                
                //Esta parte abre el documento
                try {
                    File path = new File(nombre + ".pdf");
                    Desktop.getDesktop().open(path);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se pudo abrir el documento. " + e);
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el numero de cedula digitado. ");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro el numero de cedula digitado. " + e);
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

        btnGenerarPDF = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGenerarPDF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGenerarPDF.setText("Generar PDF");
        btnGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPDFActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Digite numero de cedula");

        txtCedula.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnRegresar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Se mostrara la \ninformación del \nUsuario y \nla del Vehiculo \nel cual el usuario \nalquilo.");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGenerarPDF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(btnGenerarPDF))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPDFActionPerformed
        try {
            reporteAsociacion();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(reporteUsuacioaAsociadoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarPDFActionPerformed

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
            java.util.logging.Logger.getLogger(reporteUsuacioaAsociadoVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reporteUsuacioaAsociadoVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reporteUsuacioaAsociadoVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reporteUsuacioaAsociadoVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reporteUsuacioaAsociadoVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPDF;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
