/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
        
import bo.RentaBO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Renta;
import entities.Vehiculo;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import javax.swing.text.Document;

/**
 *
 * @author Kendall
 */
public class reportePorRangoFechasVehiculosAlquilados extends javax.swing.JFrame {

    /**
     * Creates new form reportePorRangoFechasVehiculosAlquilados
     */
    Date fecha1;
    Date fecha2;
    ArrayList Fechas = new ArrayList();
    String nombre;
    String cedula2;
    int cedula;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public reportePorRangoFechasVehiculosAlquilados() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Vehiculos Alquilados Por Rango de Fecha.");
    }

    public void reporteRangoFecha() throws FileNotFoundException { //the method what it does is to capture the two selected dates on the screen to pass it to the query of the database 
        nombre = "Reporte por Rango de Fechas.";                   //and thus obtain the information of the vehicles that were rented in the range of those two dates.  
        fecha1 = jDateChFechaInicio.getDate();
        fecha2 = jDateChFechaFinal.getDate();
        Renta fechas = new Renta();
        Vehiculo datos = new Vehiculo();
        try {
            fechas.setFechaRetiro(dateFormat.format(fecha1));
            fechas.setFechaDevolu(dateFormat.format(fecha2));
            RentaBO resultEstado = new RentaBO();
            Fechas = resultEstado.extraerPorRangoFechas(fechas);
            if (Fechas.isEmpty() == false) {
                fecha1 = jDateChFechaInicio.getDate();
                String Finicial = dateFormat.format(fecha1);
                fecha2 = jDateChFechaFinal.getDate();
                String Ffinal = dateFormat.format(fecha2);

                FileOutputStream archivo = new FileOutputStream(nombre + ".pdf");
                Document documento = new Document();
                PdfWriter.getInstance(documento, archivo);
                documento.open();

                PdfPTable tabla = new PdfPTable(5);
                Paragraph texto = new Paragraph("Vehiculos alquilados por Rango de Fecha\n\n", FontFactory.getFont("Arial", 16, Font.ITALIC, BaseColor.BLUE));
                texto.setAlignment(Element.ALIGN_CENTER);
                documento.add(texto);

                documento.add(new Paragraph(""));

                float[] mediaCeldas = {3.50f, 3.50f, 3.50f, 3.50f, 3.50f}; //tamaño de las celdas

                tabla.setWidths(mediaCeldas);
                tabla.addCell(new Paragraph("Placa Vehiculo", FontFactory.getFont("Arial", 12)));
                tabla.addCell(new Paragraph("Cedula", FontFactory.getFont("Arial", 12)));
                tabla.addCell(new Paragraph("Nombre del Usuario", FontFactory.getFont("Arial", 12)));
                tabla.addCell(new Paragraph("Fecha de Retiro", FontFactory.getFont("Arial", 12)));
                tabla.addCell(new Paragraph("Fecha de Devolución", FontFactory.getFont("Arial", 12)));

                Paragraph texto2 = new Paragraph("Fecha de Incio: " + Finicial, FontFactory.getFont("Arial", 10));
                texto2.setAlignment(Element.ALIGN_LEFT);
                documento.add(texto2);
                Paragraph texto3 = new Paragraph("Fecha Limite: " + Ffinal, FontFactory.getFont("Arial", 10));
                texto3.setAlignment(Element.ALIGN_LEFT);
                documento.add(texto3);
                documento.add(new Paragraph("\n"));

                for (int x = 0; x < Fechas.size(); x++) {
                    datos.setPlaca((String) Fechas.get(x));
                    cedula2 = Fechas.get(x + 1).toString();
                    cedula = Integer.parseInt(cedula2);
                    fechas.setCedula(cedula);
                    fechas.setNombre(Fechas.get(x + 2).toString());
                    fechas.setFechaRetiro(Fechas.get(x + 3).toString());
                    fechas.setFechaDevolu(Fechas.get(x + 4).toString());

                    cedula = fechas.getCedula();
                    cedula2 = String.valueOf(cedula);
                    tabla.addCell(new Paragraph(datos.getPlaca(), FontFactory.getFont("Arial", 10)));
                    tabla.addCell(new Paragraph(cedula2, FontFactory.getFont("Arial", 10)));
                    tabla.addCell(new Paragraph(fechas.getNombre(), FontFactory.getFont("Arial", 10)));
                    tabla.addCell(new Paragraph(fechas.getFechaRetiro(), FontFactory.getFont("Arial", 10)));
                    tabla.addCell(new Paragraph(fechas.getFechaDevolu(), FontFactory.getFont("Arial", 10)));

                    x = x + 4;
                }
                Fechas.clear();
                documento.add(tabla);
                documento.close();

                //Esta parte abre el documento
                try {
                    File path = new File(nombre + ".pdf");
                    Desktop.getDesktop().open(path);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se pudo abrir el documento. " + e);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos entre el rango seleccionado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontraron datos entre el rango seleccionado. " + e);
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

        jDateChFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChFechaFinal = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Fecha Inicio");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Fecha Final");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Selecionar Fechas");

        btnImprimir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jDateChFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(btnRegresar)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(293, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Administration_Window regresar = new Administration_Window();
        regresar.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            reporteRangoFecha();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(reportePorRangoFechasVehiculosAlquilados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(reportePorRangoFechasVehiculosAlquilados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reportePorRangoFechasVehiculosAlquilados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reportePorRangoFechasVehiculosAlquilados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reportePorRangoFechasVehiculosAlquilados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reportePorRangoFechasVehiculosAlquilados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRegresar;
    private com.toedter.calendar.JDateChooser jDateChFechaFinal;
    private com.toedter.calendar.JDateChooser jDateChFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
