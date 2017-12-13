/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bo.RentaBO;
import bo.VehiculoBO;
import dao.EstilosDAO;
import dao.MarcaDAO;
import dao.ModeloDAO;
import dao.VehiculoDAO;
import entities.MiError;
import entities.Renta;
import entities.Vehiculo;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jenni
 */
public class registroVehiculo extends javax.swing.JFrame {

    /**
     * Creates new form registroVehiculo
     */
    ImageIcon img = new ImageIcon();
    private Image img2;
    ArrayList modelos = new ArrayList();
    ArrayList marcas = new ArrayList();
    ArrayList estilo = new ArrayList();
    String tipoAccion = "";
    String direccionFoto = "";

    public registroVehiculo(String tipoaccion) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Regristro de Vehiculo");
        tipoAccion = tipoaccion;
        cargarModelos();
        cargarMarcas();
        cargarEstilo();
        realizarAccion();
        cargarPlacas();
    }

    public void realizarAccion() {
        System.out.println(tipoAccion);
        if (tipoAccion.equals("registrar")) {
            btnFoto.setEnabled(true);
            txtAno.setEnabled(true);
            txtPlaca.setEnabled(true);
            txtPrecio.setEnabled(true);
            cbxEstado.setEnabled(true);
            cbxMarcas.setEnabled(true);
            cbxTransmis.setEnabled(true);
            cbxmodelos.setEnabled(true);
            cbxEstilos.setEnabled(true);
            btnRegistrar.setEnabled(true);

        } else if (tipoAccion.equals("editar")) {
            btnFoto3.setEnabled(true);
            txtAno3.setEnabled(true);
            txtPlaca3.setEnabled(true);
            txtPrecio3.setEnabled(true);
            cbxEstado3.setEnabled(true);
            cbxMarcas3.setEnabled(true);
            cbxTransmis3.setEnabled(true);
            cbxmodelos3.setEnabled(true);
            btnModificar.setEnabled(true);
            cbxPlacaSelec.setEnabled(true);
            cbxEstilos3.setEnabled(true);

        } else if (tipoAccion.equals("eliminar")) {
            tabla.setEnabled(true);
            borrartable();
            cargarTabla();
            cargarPlacas();
            btnEliminar.setEnabled(true);
        }
    }

    public void cargarModelos() {
        ModeloDAO modelo = new ModeloDAO();
        modelos = modelo.cargarModelo();
        for (int x = 0; x < modelos.size(); x++) {
            cbxmodelos.addItem(modelos.get(x).toString());
            cbxmodelos3.addItem(modelos.get(x).toString());
        }
    }

    public void cargarMarcas() {
        MarcaDAO marca = new MarcaDAO();
        marcas = marca.cargarMarcas();
        for (int x = 0; x < marcas.size(); x++) {
            cbxMarcas.addItem(marcas.get(x).toString());
            cbxMarcas3.addItem(marcas.get(x).toString());
        }
    }

    public void cargarEstilo() {
        EstilosDAO esti = new EstilosDAO();
        estilo = esti.cargarEstilos();
        for (int x = 0; x < estilo.size(); x++) {
            cbxEstilos.addItem(estilo.get(x).toString());
            cbxEstilos3.addItem(estilo.get(x).toString());
        }

    }

    public void borrartable() {
        int num = tabla.getRowCount();
        try {
            if (num > 0) {
                for (int i = num - 1; i >= 0; i--) {
                    DefaultTableModel temp2 = (DefaultTableModel) tabla.getModel();
                    tabla.getModel();
                    temp2.removeRow(i);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    public void cargarTabla() {
        VehiculoDAO dao = new VehiculoDAO();
        LinkedList<Vehiculo> vehi = dao.cargarTodo1();
        for (Vehiculo vehiculo : vehi) {
            DefaultTableModel temp2 = (DefaultTableModel) tabla.getModel();
            Object nuevo[] = {vehiculo.getPlaca(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getTransmision(),
                vehiculo.getAño(), vehiculo.getEstilo(), vehiculo.getPrecio(), vehiculo.getEstado()};
            temp2.addRow(nuevo);
        }
    }

    public void cargarPlacas() {
        VehiculoDAO dao = new VehiculoDAO();
        LinkedList<Vehiculo> vehi = dao.cargarTodo1();
        for (Vehiculo vehiculo : vehi) {
            cbxPlacaSelec.addItem(vehiculo.getPlaca());
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

        fcFoto = new javax.swing.JFileChooser();
        jPanel4 = new javax.swing.JPanel();
        btnFoto = new javax.swing.JButton();
        txtPlaca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxMarcas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxmodelos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxTransmis = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxEstilos = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnFoto3 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtPlaca3 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtAno3 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtPrecio3 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cbxMarcas3 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        cbxmodelos3 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cbxEstado3 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        cbxTransmis3 = new javax.swing.JComboBox<>();
        cbxPlacaSelec = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbxEstilos3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/camara.png"))); // NOI18N
        btnFoto.setEnabled(false);
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        txtPlaca.setEnabled(false);
        txtPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPlacaKeyPressed(evt);
            }
        });

        jLabel1.setText("Placa:");

        jLabel5.setText("Año:");

        txtAno.setEnabled(false);
        txtAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoKeyTyped(evt);
            }
        });

        jLabel6.setText("Precio:");

        txtPrecio.setEnabled(false);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel2.setText("Marca:");

        cbxMarcas.setEnabled(false);

        jLabel3.setText("Modelo:");

        cbxmodelos.setEnabled(false);

        jLabel7.setText("Estado:");

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupado" }));
        cbxEstado.setEnabled(false);

        jLabel4.setText("Transmisión:");

        cbxTransmis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manual", "Automatica" }));
        cbxTransmis.setEnabled(false);

        btnRegistrar.setText("Registrar");
        btnRegistrar.setEnabled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel8.setText("Estilo:");

        cbxEstilos.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbxEstilos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxTransmis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtAno)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxmodelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbxMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnRegistrar)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxmodelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxEstilos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxTransmis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar)
                .addGap(0, 46, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnFoto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/camara.png"))); // NOI18N
        btnFoto3.setEnabled(false);
        btnFoto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoto3ActionPerformed(evt);
            }
        });

        jLabel23.setText("Placa:");

        txtPlaca3.setEnabled(false);

        jLabel24.setText("Año:");

        txtAno3.setEnabled(false);
        txtAno3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAno3KeyTyped(evt);
            }
        });

        jLabel25.setText("Precio:");

        txtPrecio3.setEnabled(false);
        txtPrecio3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecio3KeyTyped(evt);
            }
        });

        jLabel26.setText("Marca:");

        cbxMarcas3.setEnabled(false);

        jLabel27.setText("Modelo:");

        cbxmodelos3.setEnabled(false);

        jLabel28.setText("Estado:");

        cbxEstado3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupado" }));
        cbxEstado3.setEnabled(false);

        jLabel29.setText("Transmisión:");

        cbxTransmis3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manual", "Automatica" }));
        cbxTransmis3.setEnabled(false);

        cbxPlacaSelec.setEnabled(false);
        cbxPlacaSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPlacaSelecActionPerformed(evt);
            }
        });

        jLabel30.setText("Seleccionar placa:");

        btnModificar.setText("Modificar Vehiculo");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel9.setText("Estilo:");

        cbxEstilos3.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(cbxEstilos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxEstado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPlaca3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel25)
                                .addComponent(jLabel24))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtAno3)
                                .addComponent(txtPrecio3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxmodelos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addGap(18, 18, 18)
                            .addComponent(cbxMarcas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnFoto3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(cbxPlacaSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnModificar))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTransmis3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPlacaSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnFoto3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtPlaca3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtAno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(cbxMarcas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(cbxmodelos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(cbxEstado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbxEstilos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cbxTransmis3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnModificar)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Placa", "Marca", "Modelo", "Transmision", "Año", "Estilo", "Precio", "Estado"
            }
        ));
        tabla.setEnabled(false);
        jScrollPane1.setViewportView(tabla);

        btnEliminar.setText("Eliminar vehiculo");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnEliminar)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Image", "jpg", "png");
        fcFoto.setFileFilter(filtro);
        int option = fcFoto.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                direccionFoto = String.valueOf(fcFoto.getSelectedFile());
                img = new ImageIcon(fcFoto.getSelectedFile().getAbsolutePath());
                Icon icon = new ImageIcon(img.getImage().getScaledInstance(btnFoto.getWidth(), btnFoto.getHeight(), Image.SCALE_DEFAULT));
                File pathToFile = new File(fcFoto.getSelectedFile().getAbsolutePath());
                Image image = ImageIO.read(pathToFile.getAbsoluteFile());
                img2 = image;
                btnFoto.setIcon(icon);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar la imagen, intente nuevamente.");
            }
        }
    }//GEN-LAST:event_btnFotoActionPerformed

    private void txtPlacaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaKeyPressed
        // TODO add your handling code here:
        String placa = txtPlaca.getText();
        if (placa.length() > 2 & placa.length() < 4) {
            txtPlaca.setText(placa += "-");
        }
        if (placa.length() == 7) {
            txtPlaca.setEnabled(false);
        }
    }//GEN-LAST:event_txtPlacaKeyPressed

    private void txtAnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoKeyTyped
        // TODO add your handling code here:
        char numero = evt.getKeyChar();

        if (Character.isLetter(numero)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtAnoKeyTyped

    private void btnFoto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoto3ActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Image", "jpg", "png");
        fcFoto.setFileFilter(filtro);
        int option = fcFoto.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                direccionFoto = String.valueOf(fcFoto.getSelectedFile());
                img = new ImageIcon(fcFoto.getSelectedFile().getAbsolutePath());
                Icon icon = new ImageIcon(img.getImage().getScaledInstance(btnFoto3.getWidth(), btnFoto3.getHeight(), Image.SCALE_DEFAULT));
                File pathToFile = new File(fcFoto.getSelectedFile().getAbsolutePath());
                Image image = ImageIO.read(pathToFile.getAbsoluteFile());
                img2 = image;
                btnFoto3.setIcon(icon);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar la imagen, intente nuevamente.");
            }
        }
    }//GEN-LAST:event_btnFoto3ActionPerformed

    private void cbxPlacaSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPlacaSelecActionPerformed
        // TODO add your handling code here:
        String placa = cbxPlacaSelec.getSelectedItem().toString();
        VehiculoDAO dao = new VehiculoDAO();
        LinkedList<Vehiculo> vehi = dao.cargarTodo1();
        for (Vehiculo vehiculo : vehi) {
            if (placa.equals(vehiculo.getPlaca())) {

                txtPlaca3.setText(vehiculo.getPlaca());
                txtAno3.setText(String.valueOf(vehiculo.getAño()));
                txtPrecio3.setText(String.valueOf(vehiculo.getPrecio()));
                cbxEstilos3.setSelectedItem(vehiculo.getEstilo());
                cbxEstado3.setSelectedItem(vehiculo.getEstado());
                cbxMarcas3.setSelectedItem(vehiculo.getMarca());
                cbxmodelos3.setSelectedItem(vehiculo.getModelo());
                cbxTransmis3.setSelectedItem(vehiculo.getTransmision());
                img2 = vehiculo.getFoto();
                btnFoto3.setIcon(new ImageIcon(vehiculo.getFoto().getScaledInstance(btnFoto3.getWidth(), btnFoto3.getHeight(), Image.SCALE_DEFAULT)));
            }

        }
    }//GEN-LAST:event_cbxPlacaSelecActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        Vehiculo vehi = new Vehiculo();
        try {
            vehi.setFoto(img2);
            vehi.setPlaca(txtPlaca.getText());
            vehi.setAño(Integer.parseInt(txtAno.getText()));
            vehi.setPrecio(Integer.parseInt(txtPrecio.getText()));
            vehi.setMarca((String) cbxMarcas.getSelectedItem());
            vehi.setModelo((String) cbxmodelos.getSelectedItem());
            vehi.setEstado((String) cbxEstado.getSelectedItem());
            vehi.setEstilo((String) cbxEstilos.getSelectedItem());
            vehi.setTransmision((String) cbxTransmis.getSelectedItem());
            vehi.setDireccion_foto(direccionFoto);

            VehiculoBO veBo = new VehiculoBO();
            if (veBo.registrarVehi(vehi)) {
                JOptionPane.showMessageDialog(null, "Vehiculo registrado correctamente");
                txtAno.setText("");
                txtPrecio.setText("");
                txtPlaca.setEnabled(true);
                txtPlaca.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Intente nuevamente");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Solo numeros en año y precio");
        } catch (MiError ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
        char numero = evt.getKeyChar();
        if (Character.isLetter(numero)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Administration_Window view = new Administration_Window();
        view.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtAno3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAno3KeyTyped
        // TODO add your handling code here:
        char numero = evt.getKeyChar();
        if (Character.isLetter(numero)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtAno3KeyTyped

    private void txtPrecio3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio3KeyTyped
        // TODO add your handling code here:
        char numero = evt.getKeyChar();
        if (Character.isLetter(numero)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtPrecio3KeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int row;
        row = tabla.getSelectedRow();
        TableModel tablaModelo = (TableModel) tabla.getModel();
        if (row != -1) {
            try {
                Vehiculo ve = new Vehiculo();
                ve.setPlaca((String) tablaModelo.getValueAt(row, 0));
                VehiculoBO rBO = new VehiculoBO();
                if (rBO.EliminarVehiculo(ve)) {
                    JOptionPane.showMessageDialog(null, "Vehiculo eliminado correctamente");
                    DefaultTableModel tempo = (DefaultTableModel) tabla.getModel();
                    tempo.setRowCount(0);
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "El vehiculo no se puede eliminar porque se encuentra ocupado.");
                }

            } catch (MiError ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar en la tabla el vehiculo que desea eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        Vehiculo vehi = new Vehiculo();
        try {
            vehi.setFoto(img2);
            vehi.setPlaca(txtPlaca3.getText());
            vehi.setAño(Integer.parseInt(txtAno3.getText()));
            vehi.setPrecio(Integer.parseInt(txtPrecio3.getText()));
            vehi.setMarca((String) cbxMarcas3.getSelectedItem());
            vehi.setModelo((String) cbxmodelos3.getSelectedItem());
            vehi.setEstado((String) cbxEstado3.getSelectedItem());
            vehi.setEstilo((String) cbxEstilos3.getSelectedItem());
            vehi.setTransmision((String) cbxTransmis3.getSelectedItem());
            vehi.setDireccion_foto(direccionFoto);

            VehiculoBO veBo = new VehiculoBO();
            if (veBo.ModificarVehi(vehi, cbxPlacaSelec.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Vehiculo modificado correctamente");
                txtAno3.setText("");
                txtPrecio3.setText("");
                txtPlaca3.setEnabled(true);
                txtPlaca3.setText("");
                ImageIcon icono = new ImageIcon(getClass().getResource("/image/camara.png"));
                btnFoto3.setIcon(icono);
            } else {
                JOptionPane.showMessageDialog(null, "Intente nuevamente");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Solo numeros en año y precio");
        } catch (MiError ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(registroVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroVehiculo("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnFoto3;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxEstado3;
    private javax.swing.JComboBox<String> cbxEstilos;
    private javax.swing.JComboBox<String> cbxEstilos3;
    private javax.swing.JComboBox<String> cbxMarcas;
    private javax.swing.JComboBox<String> cbxMarcas3;
    private javax.swing.JComboBox<String> cbxPlacaSelec;
    private javax.swing.JComboBox<String> cbxTransmis;
    private javax.swing.JComboBox<String> cbxTransmis3;
    private javax.swing.JComboBox<String> cbxmodelos;
    private javax.swing.JComboBox<String> cbxmodelos3;
    private javax.swing.JFileChooser fcFoto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtAno3;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPlaca3;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecio3;
    // End of variables declaration//GEN-END:variables
}
