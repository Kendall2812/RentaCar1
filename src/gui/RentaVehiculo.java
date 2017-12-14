/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bo.RentaBO;
import dao.Conexion;
import dao.EstilosDAO;
import dao.MarcaDAO;
import dao.ModeloDAO;
import dao.OficinaDAO;
import dao.VehiculoDAO;
import entities.MiError;
import entities.Oficina;
import entities.Renta;
import entities.Vehiculo;
import static gui.RentaVehiculo.cal;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jenni
 */
public class RentaVehiculo extends javax.swing.JFrame {

    /**
     * Creates new form RentaVehiculo
     */
    Date hora3;
    Date hora4;
    Date fecha1;
    Date fecha2;
    int adicionales, cedula;
    int dias = -1;
    int total;
    String nombre;
    int precio;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat horaFormat = new SimpleDateFormat("hh:mm:ss");
    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
    public static Date date = new Date();
    public static Calendar cal = Calendar.getInstance();
    Date fechaRe;
    Date fechaDe;
    ArrayList modelos = new ArrayList();
    ArrayList marcas = new ArrayList();
    ArrayList estilo = new ArrayList();

    public RentaVehiculo(String nombreuser, int cedulauser) {
        nombre = nombreuser;
        cedula = cedulauser;
        initComponents();
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("RENTA VEHICULOS");
        this.setLocationRelativeTo(null);
        cargarOficina();
        cargarMarcas();
        cargarModelos();
        cargarEstilo();
        lblBienvenida.setText("Bienvenido(a) " + nombre);
//        ImageIcon icono = new ImageIcon(getClass().getResource("/image/usuario.png"));
//
//        ImageIcon ponerImagen = new ImageIcon(icono.getImage().getScaledInstance(70, 100, 10));
//
//        modelo.addColumn("Imagen", new Object[]{ponerImagen});
//        modelo.addColumn("Nombre", new Object[]{"jenni"});
//        tabla.setRowHeight(100);
//        this.tabla.setModel(modelo);

        cal.add(Calendar.YEAR, +2000);//2000 year after
        Date min = cal.getTime();
        Date max = new Date();//actual date
        jDateRetiro.setSelectableDateRange(max, min);
        jDateDevolu.setSelectableDateRange(max, min);

        txtAño.setVisible(false);
        txtPrecio.setVisible(false);
        cbxEstilo.setVisible(false);
        cbxMarca.setVisible(false);
        cbxModelo.setVisible(false);
        cbxTransmi.setVisible(false);
    }

    public void adicionales() {
        int adi = 0;
        if (rbtGps.isSelected()) {
            adi = adi + 9;
        }
        if (rbtBooster.isSelected()) {
            adi = adi + 11;
        }
        if (rbtSilla.isSelected()) {
            adi = adi + 3;
        }
        adicionales = adi;

    }

    public void cargarOficina() {
        OficinaDAO dao = new OficinaDAO();
        LinkedList<Oficina> oficinas = dao.cargarTodo();
        for (Oficina oficina : oficinas) {
            CbxOfiRetiro.addItem(oficina.getNombre());
            CbxOfiDevol.addItem(oficina.getNombre());
        }
    }

    public void cargarModelos() {
        ModeloDAO modelo1 = new ModeloDAO();
        modelos = modelo1.cargarModelo();
        for (int x = 0; x < modelos.size(); x++) {
            cbxModelo.addItem(modelos.get(x).toString());
        }
    }

    public void cargarMarcas() {
        MarcaDAO marca = new MarcaDAO();
        marcas = marca.cargarMarcas();
        for (int x = 0; x < marcas.size(); x++) {
            cbxMarca.addItem(marcas.get(x).toString());
        }
    }

    public void cargarEstilo() {
        EstilosDAO esti = new EstilosDAO();
        estilo = esti.cargarEstilos();
        for (int x = 0; x < estilo.size(); x++) {
            cbxEstilo.addItem(estilo.get(x).toString());
        }

    }

    public void obtenerCantDias() {
        if (jDateRetiro.getDate() != null && jDateDevolu.getDate() != null) {
            Calendar fecha_inicio = jDateRetiro.getCalendar();
            Calendar fecha_final = jDateDevolu.getCalendar();
            while (fecha_inicio.before(fecha_final)) {
                dias++;
                fecha_inicio.add(Calendar.DATE, 1);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione las fechas", "Calcular Dias", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void llenarTable(ArrayList<String> placa, ArrayList<String> marca, ArrayList<String> modelo, ArrayList<String> estilo,
            ArrayList<String> trans, ArrayList<String> año, ArrayList<String> precio, ArrayList<String> estado) {
        borrartable();
        DefaultTableModel temp3 = (DefaultTableModel) tabla.getModel();
        tabla.getModel();
        temp3.setNumRows(placa.size());
        for (int i = 0; i < placa.size(); i++) {
            tabla.setValueAt(placa.get(i), i, 0);
            tabla.setValueAt(marca.get(i), i, 1);
            tabla.setValueAt(modelo.get(i), i, 2);
            tabla.setValueAt(estilo.get(i), i, 3);
            tabla.setValueAt(trans.get(i), i, 4);
            tabla.setValueAt(precio.get(i), i, 5);
            tabla.setValueAt(año.get(i), i, 6);
            tabla.setValueAt(estado.get(i), i, 7);

            if (placa.size() >= tabla.getRowCount()) {

                DefaultTableModel temp2 = (DefaultTableModel) tabla.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }
        }
        if (tabla.getRowCount() > placa.size()) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) tabla.getModel();
                tabla.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
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

    public String sql() {

        String sql = "SELECT vehiculo.placa,marca.nombre_marca as marca,modelo.nombre_modelo as modelo,"
                + "estilo.nombre_estilo as estilo,"
                + "vehiculo.transmision,vehiculo.año,\n"
                + "vehiculo.precio,vehiculo.estado\n"
                + "from vehiculo inner join marca on vehiculo.marca = marca.nombre_marca\n"
                + "inner join modelo on vehiculo.modelo = modelo.nombre_modelo\n"
                + "inner join estilo on vehiculo.estilo = estilo.nombre_estilo\n"
                + "where vehiculo.estado = 'Disponible'";
        if (rbtAño.isSelected()) {
            sql += " AND vehiculo.año ='" + txtAño.getText() + "'";
        }
        if (rbtPrecio.isSelected()) {
            sql += " AND vehiculo.precio ='" + txtPrecio.getText() + "'";

        }
        if (rbtMarca.isSelected()) {

            sql += " and vehiculo.marca ='" + cbxMarca.getSelectedItem().toString() + "'";

        }
        if (rbtModelo.isSelected()) {

            sql += " and vehiculo.modelo ='" + cbxModelo.getSelectedItem().toString() + "' ";
        }
        if (rbtEstilo.isSelected()) {

            sql += " and vehiculo.estilo ='" + cbxEstilo.getSelectedItem().toString() + "'";
        }
        if (rbttransmision.isSelected()) {
            sql += " AND vehiculo.transmision ='" + cbxTransmi.getSelectedItem() + "'";
        }
        return sql;
    }

    public void buscaVehiculo() {
        ArrayList<String> placa = null;
        ArrayList<String> marca = null;
        ArrayList<String> modelo = null;
        ArrayList<String> estilo = null;
        ArrayList<String> trans = null;
        ArrayList<String> año = null;
        ArrayList<String> precio = null;
        ArrayList<String> estado = null;
        ArrayList<String> imagen = null;

        if (!rbtAño.isSelected() & !rbtMarca.isSelected() & !rbtModelo.isSelected() & !rbtEstilo.isSelected() & !rbtPrecio.isSelected() & !rbttransmision.isSelected()) {

            try (Connection con = Conexion.conexion()) {

                placa = new <String>ArrayList();
                marca = new <String>ArrayList();
                modelo = new <String>ArrayList();
                estilo = new <String>ArrayList();
                trans = new <String>ArrayList();
                año = new <String>ArrayList();
                precio = new <String>ArrayList();
                estado = new <String>ArrayList();
                imagen = new ArrayList<>();

                String sql = ("SELECT v.foto, v.placa, m.nombre_marca as marca, a.nombre_modelo as modelo,"
                        + " e.nombre_estilo as estilo , v.transmision, v.año, v.precio, v.estado "
                        + "FROM vehiculo v, marca m, modelo a, estilo e\n"
                        + "WHERE m.nombre_marca = v.marca AND a.nombre_modelo = v.modelo AND e.nombre_estilo = v.estilo AND v.estado= 'Disponible'"
                        + "ORDER BY placa ASC");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    placa.add(rs.getString("placa"));
                    marca.add(rs.getString("marca"));
                    modelo.add(rs.getString("modelo"));
                    estilo.add(rs.getString("estilo"));
                    trans.add(rs.getString("transmision"));
                    año.add(rs.getString("año"));
                    precio.add(rs.getString("precio"));
                    estado.add(rs.getString("estado"));
                }
            } catch (Exception e) {
                System.out.println("Error de conexión" + e);
            }

            llenarTable(placa, marca, modelo, estilo, trans, año, precio, estado);

        } else {
            System.out.println(sql());
            try (Connection con = Conexion.conexion()) {

                placa = new <String>ArrayList();
                marca = new <String>ArrayList();
                modelo = new <String>ArrayList();
                estilo = new <String>ArrayList();
                trans = new <String>ArrayList();
                año = new <String>ArrayList();
                precio = new <String>ArrayList();
                estado = new <String>ArrayList();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql());

                while (rs.next()) {
                    placa.add(rs.getString("placa"));
                    marca.add(rs.getString("marca"));
                    modelo.add(rs.getString("modelo"));
                    estilo.add(rs.getString("estilo"));
                    trans.add(rs.getString("transmision"));
                    año.add(rs.getString("año"));
                    precio.add(rs.getString("precio"));
                    estado.add(rs.getString("estado"));
                }
            } catch (Exception e) {
                System.out.println("Error de conexión" + e);
            }

            llenarTable(placa, marca, modelo, estilo, trans, año, precio, estado);

        }
        if (tabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No se encuentra algún Resultado!");
        }
        rbtAño.setSelected(false);
        rbtPrecio.setSelected(false);
        rbtMarca.setSelected(false);
        rbtModelo.setSelected(false);
        rbtEstilo.setSelected(false);
        rbttransmision.setSelected(false);
        txtAño.setText("");
        txtPrecio.setText("");
        txtAño.setVisible(false);
        txtPrecio.setVisible(false);
        cbxEstilo.setVisible(false);
        cbxMarca.setVisible(false);
        cbxModelo.setVisible(false);
        cbxTransmi.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CbxOfiRetiro = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateDevolu = new com.toedter.calendar.JDateChooser();
        jDateRetiro = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        CbxOfiDevol = new javax.swing.JComboBox<>();
        cbxHoraRE = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxHoraDE = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        rbtGps = new javax.swing.JRadioButton();
        rbtBooster = new javax.swing.JRadioButton();
        rbtSilla = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        rbtAño = new javax.swing.JRadioButton();
        rbtPrecio = new javax.swing.JRadioButton();
        rbtMarca = new javax.swing.JRadioButton();
        rbtModelo = new javax.swing.JRadioButton();
        txtAño = new javax.swing.JTextField();
        rbttransmision = new javax.swing.JRadioButton();
        rbtEstilo = new javax.swing.JRadioButton();
        txtPrecio = new javax.swing.JTextField();
        cbxMarca = new javax.swing.JComboBox<>();
        cbxEstilo = new javax.swing.JComboBox<>();
        cbxModelo = new javax.swing.JComboBox<>();
        cbxTransmi = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblBienvenida = new javax.swing.JLabel();
        btnRentar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.darkGray), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Oficina de retiro:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 31, -1, -1));

        jPanel1.add(CbxOfiRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, 20));

        jLabel2.setText("Fecha de retiro:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, -1, -1));

        jLabel3.setText("Fecha de devolución:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 66, -1, -1));
        jPanel1.add(jDateDevolu, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 85, 142, 30));
        jPanel1.add(jDateRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 85, 151, 30));

        jLabel4.setText("Oficina de devolucion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        CbxOfiDevol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxOfiDevolActionPerformed(evt);
            }
        });
        jPanel1.add(CbxOfiDevol, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, 20));

        cbxHoraRE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5:00 am", "5:15 am", "5:30 am", "5:45 am", "6:00 am", "6:15 am", "6:30 am", "6:45 am", "7:00 am", "7:15 am", "7:30 am", "7:45 am", "8:00 am", "8:15 am", "8:30 am", "8:45 am", "9:00 am", "9:15 am", "9:30 am", "9:45 am", "10:00 am", "10:15 am", "10:30 am", "10:45 am", "11:00 am", "11:15 am", "11:30 am", "11:45 am", "12:00 pm", "12:15 pm", "12:30 pm", "12:45 pm", "1:00 pm", "1:15 pm", "1:30 pm", "1:45 pm", "2:00 pm", "2:15 pm", "2:30 pm", "2:45 pm", "3:00 pm", "3:15 pm", "3:30 pm", "3:45 pm", "4:00 pm", "4:15 pm", "4:30 pm", "4:45 pm", "5:00 pm", "5:15 pm", "5:30 pm", "5:45 pm", "6:00 pm", "6:15 pm", "6:30 pm", "6:45 pm", "7:00 pm", "7:15 pm", "7:30 pm", "7:45 pm", "8:00 pm", "8:15 pm", "8:30 pm", "8:45 pm", "9:00 pm", "9:15 pm", "9:30 pm", "9:45 pm", "10:00 pm" }));
        jPanel1.add(cbxHoraRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 80, -1));

        jLabel5.setText("Hora de retiro:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel6.setText("Hora de devolución :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        cbxHoraDE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5:00 am", "5:15 am", "5:30 am", "5:45 am", "6:00 am", "6:15 am", "6:30 am", "6:45 am", "7:00 am", "7:15 am", "7:30 am", "7:45 am", "8:00 am", "8:15 am", "8:30 am", "8:45 am", "9:00 am", "9:15 am", "9:30 am", "9:45 am", "10:00 am", "10:15 am", "10:30 am", "10:45 am", "11:00 am", "11:15 am", "11:30 am", "11:45 am", "12:00 pm", "12:15 pm", "12:30 pm", "12:45 pm", "1:00 pm", "1:15 pm", "1:30 pm", "1:45 pm", "2:00 pm", "2:15 pm", "2:30 pm", "2:45 pm", "3:00 pm", "3:15 pm", "3:30 pm", "3:45 pm", "4:00 pm", "4:15 pm", "4:30 pm", "4:45 pm", "5:00 pm", "5:15 pm", "5:30 pm", "5:45 pm", "6:00 pm", "6:15 pm", "6:30 pm", "6:45 pm", "7:00 pm", "7:15 pm", "7:30 pm", "7:45 pm", "8:00 pm", "8:15 pm", "8:30 pm", "8:45 pm", "9:00 pm", "9:15 pm", "9:30 pm", "9:45 pm", "10:00 pm" }));
        jPanel1.add(cbxHoraDE, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        jLabel7.setText("Articulos Adicionales:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 176, -1, -1));

        rbtGps.setText("GPS $9");
        rbtGps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtGpsActionPerformed(evt);
            }
        });
        jPanel1.add(rbtGps, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 197, -1, -1));

        rbtBooster.setText("Booster $11");
        rbtBooster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtBoosterActionPerformed(evt);
            }
        });
        jPanel1.add(rbtBooster, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 220, -1, -1));

        rbtSilla.setText("Silla de bebé $3 ");
        rbtSilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtSillaActionPerformed(evt);
            }
        });
        jPanel1.add(rbtSilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 243, -1, -1));

        jLabel8.setText("Filtro de búsqueda:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 287, -1, -1));

        jButton1.setText("Buscar Vehículo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 478, -1, -1));

        rbtAño.setText("Año");
        rbtAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtAñoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 311, -1, -1));

        rbtPrecio.setText("Precio");
        rbtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(rbtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 337, -1, -1));

        rbtMarca.setText("Marca");
        rbtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(rbtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 363, -1, -1));

        rbtModelo.setText("Modelo");
        rbtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtModeloActionPerformed(evt);
            }
        });
        jPanel1.add(rbtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 414, -1, -1));

        txtAño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAñoKeyTyped(evt);
            }
        });
        jPanel1.add(txtAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 312, 110, -1));

        rbttransmision.setText("Transmisión");
        rbttransmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbttransmisionActionPerformed(evt);
            }
        });
        jPanel1.add(rbttransmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 437, -1, -1));

        rbtEstilo.setText("Estilo");
        rbtEstilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtEstiloActionPerformed(evt);
            }
        });
        jPanel1.add(rbtEstilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 389, -1, -1));

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 338, 110, -1));

        jPanel1.add(cbxMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 364, 102, -1));

        jPanel1.add(cbxEstilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 390, 102, -1));

        jPanel1.add(cbxModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 414, 102, -1));

        cbxTransmi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Automatica", "Manual" }));
        jPanel1.add(cbxTransmi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 102, -1));

        lblBienvenida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnRentar.setText("Rentar");
        btnRentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Marca", "Modelo", "Estilo", "Transmision", "Precio", "Año", "Estado"
            }
        ));
        tabla.setToolTipText("");
        jScrollPane2.setViewportView(tabla);

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Cerrar Sesión");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addContainerGap())
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnRentar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRentar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbttransmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbttransmisionActionPerformed
        // TODO add your handling code here:
        borrartable();
        if (rbttransmision.isSelected()) {
            cbxTransmi.setVisible(true);
        } else {
            cbxTransmi.setVisible(false);
        }
    }//GEN-LAST:event_rbttransmisionActionPerformed

    private void rbtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtModeloActionPerformed
        // TODO add your handling code here:
        borrartable();
        if (rbtModelo.isSelected()) {
            cbxModelo.setVisible(true);
        } else {
            cbxModelo.setVisible(false);
        }
    }//GEN-LAST:event_rbtModeloActionPerformed

    private void rbtGpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtGpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtGpsActionPerformed

    private void rbtBoosterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtBoosterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtBoosterActionPerformed

    private void rbtSillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtSillaActionPerformed
        // TODO add your handling code here:      
    }//GEN-LAST:event_rbtSillaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        buscaVehiculo();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void CbxOfiDevolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxOfiDevolActionPerformed
        // TODO add your handling code here:    
    }//GEN-LAST:event_CbxOfiDevolActionPerformed

    private void rbtAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtAñoActionPerformed
        // TODO add your handling code here:
        borrartable();
        if (rbtAño.isSelected()) {
            txtAño.setVisible(true);
        } else {
            txtAño.setVisible(false);
        }
    }//GEN-LAST:event_rbtAñoActionPerformed

    private void rbtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtPrecioActionPerformed
        // TODO add your handling code here:
        borrartable();
        if (rbtPrecio.isSelected()) {
            txtPrecio.setVisible(true);
        } else {
            txtPrecio.setVisible(false);
        }
    }//GEN-LAST:event_rbtPrecioActionPerformed

    private void rbtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtMarcaActionPerformed
        // TODO add your handling code here:
        borrartable();
        if (rbtMarca.isSelected()) {
            cbxMarca.setVisible(true);
        } else {
            cbxMarca.setVisible(false);
        }
    }//GEN-LAST:event_rbtMarcaActionPerformed

    private void rbtEstiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtEstiloActionPerformed
        // TODO add your handling code here:
        borrartable();
        if (rbtEstilo.isSelected()) {
            cbxEstilo.setVisible(true);
        } else {
            cbxEstilo.setVisible(false);
        }
    }//GEN-LAST:event_rbtEstiloActionPerformed

    private void btnRentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentarActionPerformed
        // TODO add your handling code here:
        obtenerCantDias();
        adicionales();

        int row;
        row = tabla.getSelectedRow();
        TableModel tablaModelo = (TableModel) tabla.getModel();
        if (row != -1) {
            try {
                Renta re = new Renta();

                fecha1 = jDateRetiro.getDate();
                fecha2 = jDateDevolu.getDate();

                re.setFechaRetiro(dateFormat.format(fecha1));
                re.setFechaDevolu(dateFormat.format(fecha2));
                re.setNombre(nombre);
                re.setCedula(cedula);
                re.setPlaca((String) tablaModelo.getValueAt(row, 0));
                re.setOfiRetiro((String) CbxOfiRetiro.getSelectedItem());
                re.setOfiDevolu((String) CbxOfiDevol.getSelectedItem());
                precio = Integer.valueOf(tablaModelo.getValueAt(row, 5).toString());
                if (dias > 0) {
                    if (adicionales == 0) {
                        re.setPrecio(precio * dias);
                        total = (precio * dias);
                    } else if (adicionales != 0) {
                        re.setPrecio((precio + adicionales) * dias);
                        total = ((precio + adicionales) * dias);
                    }
                    re.setHoraRetiro(cbxHoraRE.getSelectedItem().toString());
                    re.setHoraDevolu(cbxHoraDE.getSelectedItem().toString());

                    RentaBO rBO = new RentaBO();
                    if (rBO.registrarRenta(re, false)) {
                        int seleccion = JOptionPane.showOptionDialog(
                                null,
                                "¿Desea rentar el vehiculo?\nPRECIO TOTAL: " + total,
                                "FACTURA DE RENTA",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null, // null para icono por defecto.
                                new Object[]{"Rentar", "Cancelar"}, // null para YES, NO y CANCEL
                                "");
                        if (seleccion != -1) {
                            if ((seleccion + 1) == 1) {
                                if (rBO.registrarRenta(re, true)) {
                                    VehiculoDAO ve = new VehiculoDAO();
                                    ve.modificarEstado((String) tablaModelo.getValueAt(row, 0));
                                    JOptionPane.showMessageDialog(null, "Renta registrada correctamente");
                                    buscaVehiculo();

                                } else {
                                    JOptionPane.showMessageDialog(null, "Intente nuevamente");
                                }
                            } else {
                                adicionales=0;
                                dias=-1;
                            }
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Fechas incorrectas");
                    dias=-1;
                }

            } catch (MiError ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar en la tabla el vehiculo que desea");
        }


    }//GEN-LAST:event_btnRentarActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
        char numero = evt.getKeyChar();
        if (Character.isLetter(numero)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtAñoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAñoKeyTyped
        // TODO add your handling code here:
        char numero = evt.getKeyChar();
        if (Character.isLetter(numero)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtAñoKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Login lo = new Login();
        lo.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(RentaVehiculo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentaVehiculo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentaVehiculo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentaVehiculo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentaVehiculo("", 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbxOfiDevol;
    private javax.swing.JComboBox<String> CbxOfiRetiro;
    private javax.swing.JButton btnRentar;
    private javax.swing.JComboBox<String> cbxEstilo;
    private javax.swing.JComboBox<String> cbxHoraDE;
    private javax.swing.JComboBox<String> cbxHoraRE;
    private javax.swing.JComboBox<String> cbxMarca;
    private javax.swing.JComboBox<String> cbxModelo;
    private javax.swing.JComboBox<String> cbxTransmi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateDevolu;
    private com.toedter.calendar.JDateChooser jDateRetiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JRadioButton rbtAño;
    private javax.swing.JRadioButton rbtBooster;
    private javax.swing.JRadioButton rbtEstilo;
    private javax.swing.JRadioButton rbtGps;
    private javax.swing.JRadioButton rbtMarca;
    private javax.swing.JRadioButton rbtModelo;
    private javax.swing.JRadioButton rbtPrecio;
    private javax.swing.JRadioButton rbtSilla;
    private javax.swing.JRadioButton rbttransmision;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
