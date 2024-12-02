package com.system.view;

import com.system.business.ArticuloBo;
import com.system.business.CompraBo;
import com.system.business.PersonBo;
import com.system.business.ProductoBo;
import com.system.business.UnidadBo;
import com.system.conexion.TextPrompt;
import com.system.identity.Articulo;
import com.system.identity.Compra;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class jpBaja_articulo extends javax.swing.JPanel {

    private DefaultTableModel ArticuloTableModel;
    private DefaultComboBoxModel Unidad_medida;
    private DefaultComboBoxModel Proveedor;

    DefaultTableModel modelo2 = new DefaultTableModel();
    Compra objCompra = new Compra();
    Articulo objArticulo = new Articulo();

    private String numero;
    private String serie;
    private String usua;
    private String unidad = "";
    private String proveedor = "";
    private String trabajador = "";
    private String destino = "C:\\AppJava\\Archivo\\";
    private String ruta_archivo = "";
    private String archivo = "";
    private String descri = "";

    private int id;
    private int canti;

    private double precio;
    private double total;
    private double igv;
    private double descuento;
    private double subtotal;
    private double subtotal1;
    private double total1;
    private double descuento1;
    private double igv1;

    private char opt;

    public jpBaja_articulo() {
        initComponents();
        limpiar();
        loadTableMateria();
        loadComboProveedor();
        
        numero_compra();
        plaseholder();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtex_numero = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtex_descuento1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtex_Total = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtex_subtotal1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtex_igv1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Producto_table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jtex_fecha = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jtex_cantidad = new javax.swing.JTextField();
        jtex_precio = new javax.swing.JTextField();
        jtex_sub_total = new javax.swing.JTextField();
        jtex_descuento = new javax.swing.JTextField();
        jtex_total = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        ComboProveedor = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_detalle_articulo = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnGenerar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_pdf = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1040, 520));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1039, 520));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("NUEVA SALIDA");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 8, 200, 30));

        jtex_numero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jPanel2.add(jtex_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 147, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("#NUM:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("SubTotal: S/.");

        jtex_descuento1.setEditable(false);
        jtex_descuento1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jtex_descuento1.setText("000.00");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Total:  S/.");

        jtex_Total.setEditable(false);
        jtex_Total.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jtex_Total.setText("000.00");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("DES. S/.");

        jtex_subtotal1.setEditable(false);
        jtex_subtotal1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jtex_subtotal1.setText("000.00");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("IGV: S/.");

        jtex_igv1.setEditable(false);
        jtex_igv1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jtex_igv1.setText("000.00");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtex_subtotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtex_descuento1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtex_igv1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jtex_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtex_subtotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jtex_descuento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtex_igv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtex_Total))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("lista de articulos"));

        Producto_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Articulo"
            }
        ));
        Producto_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Producto_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Producto_table);

        jtex_fecha.setText("fecha");

        btn_agregar.setBackground(new java.awt.Color(10, 95, 1));
        btn_agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_agregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_agregarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_agregarMousePressed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/agregar.png"))); // NOI18N
        jLabel12.setText("Agregar");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
        });

        javax.swing.GroupLayout btn_agregarLayout = new javax.swing.GroupLayout(btn_agregar);
        btn_agregar.setLayout(btn_agregarLayout);
        btn_agregarLayout.setHorizontalGroup(
            btn_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
        );
        btn_agregarLayout.setVerticalGroup(
            btn_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_agregarLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jtex_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jtex_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtex_cantidad.setText("cantidad");

        jtex_precio.setText("precio");
        jtex_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtex_precioKeyReleased(evt);
            }
        });

        jtex_sub_total.setText("subtotal");

        jtex_descuento.setText("descuento");
        jtex_descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtex_descuentoKeyReleased(evt);
            }
        });

        jtex_total.setText("total");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        ComboProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(ComboProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ComboProveedor)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jtex_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtex_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtex_sub_total, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtex_descuento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtex_total, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtex_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtex_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtex_sub_total, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtex_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtex_total, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        table_detalle_articulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Unidad", "Cantidad", "Precio", "Sub total", "Descuento", "IGV", "Total"
            }
        ));
        jScrollPane4.setViewportView(table_detalle_articulo);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGenerar.setBackground(new java.awt.Color(10, 95, 1));
        btnGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGenerarMousePressed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/agregar.png"))); // NOI18N
        jLabel9.setText("Generar");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });

        javax.swing.GroupLayout btnGenerarLayout = new javax.swing.GroupLayout(btnGenerar);
        btnGenerar.setLayout(btnGenerarLayout);
        btnGenerarLayout.setHorizontalGroup(
            btnGenerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnGenerarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnGenerarLayout.setVerticalGroup(
            btnGenerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        btnEliminar.setBackground(new java.awt.Color(10, 95, 1));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminarMousePressed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/delete.png"))); // NOI18N
        jLabel10.setText("Eliminar");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });

        javax.swing.GroupLayout btnEliminarLayout = new javax.swing.GroupLayout(btnEliminar);
        btnEliminar.setLayout(btnEliminarLayout);
        btnEliminarLayout.setHorizontalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btnEliminarLayout.setVerticalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        btn_pdf.setBackground(new java.awt.Color(10, 95, 1));
        btn_pdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_pdfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_pdfMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_pdfMousePressed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/edit.png"))); // NOI18N
        jLabel11.setText("PDF");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });

        javax.swing.GroupLayout btn_pdfLayout = new javax.swing.GroupLayout(btn_pdf);
        btn_pdf.setLayout(btn_pdfLayout);
        btn_pdfLayout.setHorizontalGroup(
            btn_pdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_pdfLayout.setVerticalGroup(
            btn_pdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_pdf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarMouseEntered
        this.btnGenerar.setBackground(new Color(0, 128, 0));
        this.btnGenerar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnGenerarMouseEntered

    private void btnGenerarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarMouseExited
        this.btnGenerar.setBackground(new Color(10, 95, 1));
    }//GEN-LAST:event_btnGenerarMouseExited

    private void btnGenerarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarMousePressed

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        this.btnEliminar.setBackground(new Color(0, 128, 0));
        this.btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        this.btnEliminar.setBackground(new Color(10, 95, 1));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMousePressed

    private void btn_pdfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pdfMouseEntered
        this.btn_pdf.setBackground(new Color(0, 128, 0));
        this.btn_pdf.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_pdfMouseEntered

    private void btn_pdfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pdfMouseExited
        this.btn_pdf.setBackground(new Color(10, 95, 1));
    }//GEN-LAST:event_btn_pdfMouseExited

    private void btn_pdfMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pdfMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pdfMousePressed

    private void Producto_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Producto_tableMouseClicked
        try {
            int index = Producto_table.getSelectedRow();
            descri = Producto_table.getValueAt(index, 0).toString();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_Producto_tableMouseClicked

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        registrar();
    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        this.estilo_windows();
        this.seleccionar_pdf();
    }//GEN-LAST:event_jLabel11MousePressed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed

        int fila;
        int resp;

        try {
            fila = table_detalle_articulo.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar la fila a eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                resp = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar este fila?", "eliminar", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_NO_OPTION) {

                    modelo2 = (DefaultTableModel) table_detalle_articulo.getModel();
                    modelo2.removeRow(fila);
                    calculatTotal();
                }
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        cargar_datos();
    }//GEN-LAST:event_jLabel12MousePressed

    private void btn_agregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarMouseEntered

    private void btn_agregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarMouseExited

    private void btn_agregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMousePressed
        cargar_datos();

    }//GEN-LAST:event_btn_agregarMousePressed

    private void jtex_precioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtex_precioKeyReleased
        if (!"".equals(this.jtex_precio.getText())) {
            int cant = Integer.parseInt(this.jtex_cantidad.getText());
            double pre = Double.parseDouble(this.jtex_precio.getText());
            double to = (cant * pre);
            this.jtex_sub_total.setText("" + to);
            this.jtex_total.setText("" + to);
        }
    }//GEN-LAST:event_jtex_precioKeyReleased

    private void jtex_descuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtex_descuentoKeyReleased
        if (!"".equals(this.jtex_descuento.getText())) {
            double sub = Double.parseDouble(this.jtex_sub_total.getText());
            double des = Double.parseDouble(this.jtex_descuento.getText());
            double to = (sub - des);
            this.jtex_total.setText("" + to);
        }
    }//GEN-LAST:event_jtex_descuentoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboProveedor;
    private javax.swing.JTable Producto_table;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JPanel btnGenerar;
    private javax.swing.JPanel btn_agregar;
    private javax.swing.JPanel btn_pdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jtex_Total;
    private javax.swing.JTextField jtex_cantidad;
    private javax.swing.JTextField jtex_descuento;
    private javax.swing.JTextField jtex_descuento1;
    private javax.swing.JTextField jtex_fecha;
    private javax.swing.JTextField jtex_igv1;
    private javax.swing.JLabel jtex_numero;
    private javax.swing.JTextField jtex_precio;
    private javax.swing.JTextField jtex_sub_total;
    private javax.swing.JTextField jtex_subtotal1;
    private javax.swing.JTextField jtex_total;
    private javax.swing.JTable table_detalle_articulo;
    // End of variables declaration//GEN-END:variables

    private void loadTableMateria() {
        try {
            TableColumn columna;
            this.ArticuloTableModel = ProductoBo.ListaTable();
            this.Producto_table.setModel(this.ArticuloTableModel);
//            setAnchoColumnas();
            columna = this.Producto_table.getColumnModel().getColumn(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void loadComboProveedor() {
        try {
            Proveedor = PersonBo.obtenerPersona(JFDashboard.tipo_p);
            ComboProveedor.setModel(Proveedor);
            ComboProveedor.setPreferredSize(new Dimension(600, 22));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }

    private void numero_compra() {

        try {
            String serie = CompraBo.NumId();
            if (serie == null) {
                jtex_numero.setText("00001");
            } else {
                int increment = Integer.parseInt(serie);
                increment = increment + 1;
                if (increment <= 10) {
                    jtex_numero.setText("0000" + increment);
                } else if (increment >= 10 && increment <= 99) {
                    jtex_numero.setText("000" + increment);
                } else if (increment >= 100 && increment <= 999) {
                    jtex_numero.setText("0" + increment);
                } else if (increment >= 1000 && increment <= 9999) {
                    jtex_numero.setText("0" + increment);
                } else if (increment >= 10000 && increment <= 99999) {
                    jtex_numero.setText("0" + increment);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargar_ragistro_compra() {
        modelo2 = (DefaultTableModel) table_detalle_articulo.getModel();
        ArrayList lista = new ArrayList();
        if (descri != null) {
            lista.add(descri);
            lista.add(unidad);
            lista.add(canti);
            lista.add(precio);
            lista.add(subtotal1);
            lista.add(descuento);
            lista.add(igv);
            lista.add(total);
            Object[] ob = new Object[8];
            ob[0] = lista.get(0);
            ob[1] = lista.get(1);
            ob[2] = lista.get(2);
            ob[3] = lista.get(3);
            ob[4] = lista.get(4);
            ob[5] = lista.get(5);
            ob[6] = lista.get(6);
            ob[7] = lista.get(7);

            modelo2.addRow(ob);
            limpiar_variables();
            table_detalle_articulo.setModel(modelo2);
            calculatTotal();

        }
    }

    private void calculatTotal() {
        double tot = 0.0, sbto = 0.0, des = 0.0, igv = 0.0;
        for (int i = 0; i < table_detalle_articulo.getRowCount(); i++) {
            subtotal1 = Double.parseDouble(table_detalle_articulo.getValueAt(i, 4).toString());
            descuento1 = Double.parseDouble(table_detalle_articulo.getValueAt(i, 5).toString());
            igv1 = Double.parseDouble(table_detalle_articulo.getValueAt(i, 6).toString());
            total1 = Double.parseDouble(table_detalle_articulo.getValueAt(i, 7).toString());

            sbto = redondear(sbto + subtotal1);
            des = redondear(des + descuento1);
            igv = redondear(igv + igv1);
            tot = redondear(tot + total1);
        }
        this.jtex_subtotal1.setText("" + sbto + "0");
        this.jtex_descuento1.setText("" + des + "0");
        this.jtex_igv1.setText("" + igv + "0");
        this.jtex_Total.setText("" + tot + "0");

    }

    private void limpiar_variables() {
//        id = 0;
//        descri = "";
////        dias = 0;
////        horas = 0;
//        precio = 0.0;
//        total = 0.0;
    }

    private void registrar() {
        try {
            cargar_datos_compra();

            String idT = CompraBo.NumId();
            id = Integer.parseInt(idT);
            System.out.println("id de compra " + id);

            guardar_articulo();

            limpiarTodo();
            numero_compra();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error " + ex);
        }

    }

    private void guardar_compra() {
        try {
            objCompra.setId_trabajador(JFDashboard.usuaa);
            objCompra.setId_proveedor(this.ComboProveedor.getSelectedItem().toString());
            objCompra.setFecha_compra(this.jtex_fecha.getText());
           
            objCompra.setCodigo(this.jtex_numero.getText());
        
            objCompra.setSub_total(Double.parseDouble(this.jtex_subtotal1.getText()));
            objCompra.setIgv(Double.parseDouble(this.jtex_igv1.getText()));
            objCompra.setDescuento(Double.parseDouble(this.jtex_descuento1.getText()));
            objCompra.setTotal(Double.parseDouble(this.jtex_Total.getText()));
            objCompra.setArchivo(this.archivo);

            this.guardar_archivo_folder();

            if (CompraBo.grabarCompra(objCompra)) {
                JOptionPane.showMessageDialog(this, "Se Registró Correctamente", "MENSAJE --> Compra", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "No se pudo Registrar", "MENSAJE --> Compra", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "MENSAJE --> COMPRA", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardar_articulo() {
        try {

            for (int i = 0; i < table_detalle_articulo.getRowCount(); i++) {
                objArticulo.setId_compra(id);
                objArticulo.setId_producto(table_detalle_articulo.getValueAt(i, 0).toString());
                objArticulo.setId_unidad(table_detalle_articulo.getValueAt(i, 1).toString());
                objArticulo.setCantidad(Integer.parseInt(table_detalle_articulo.getValueAt(i, 2).toString()));
                objArticulo.setPrecio(Double.parseDouble(table_detalle_articulo.getValueAt(i, 3).toString()));
                objArticulo.setSub_total(Double.parseDouble(table_detalle_articulo.getValueAt(i, 4).toString()));
                objArticulo.setDescuento(Double.parseDouble(table_detalle_articulo.getValueAt(i, 5).toString()));
                objArticulo.setTotal(Double.parseDouble(table_detalle_articulo.getValueAt(i, 7).toString()));

                ArticuloBo.grabarArticulo(objArticulo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "MENSAJE --> DETALLE TICKET", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarTodo() {
        this.jtex_descuento1.setText("");
        this.jtex_igv1.setText("");
       
        this.jtex_fecha.setText("");
        this.jtex_Total.setText("");
        this.jtex_subtotal1.setText("");
        
        this.archivo = "";
        for (int i = 0; i < modelo2.getRowCount(); i++) {
            modelo2.removeRow(i);
            i = i - 1;
        }
    }

    private void limpiar() {
     
        this.jtex_fecha.setText("");
        
        this.jtex_cantidad.setText("");
        this.jtex_total.setText("");
        this.jtex_descuento.setText("");
        this.jtex_sub_total.setText("");
        this.jtex_precio.setText("");
    }

    private void plaseholder() {
        TextPrompt prueba0 = new TextPrompt("Cantidad", this.jtex_cantidad);
        TextPrompt prueba1 = new TextPrompt("Total", this.jtex_total);
        TextPrompt prueba2 = new TextPrompt("Ingrese la fecha", this.jtex_fecha);
        TextPrompt prueba3 = new TextPrompt("Descuento", this.jtex_descuento);
      
        TextPrompt prueba6 = new TextPrompt("Subtotal", this.jtex_sub_total);
        TextPrompt prueba7 = new TextPrompt("Precio", this.jtex_precio);
    }

    private double redondear(double num) {
        return Math.rint(num * 100) / 100;
    }

    private void cargar_datos() {
        if (!"".equals(descri)) {
            if (this.jtex_total.getText().equals("") || this.jtex_cantidad.getText().equals("")
                    || this.jtex_precio.getText().equals("") || this.jtex_sub_total.getText().equals("")) {

                javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos, ¡ANIMAL!\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                cargar_varibles();
                cargar_ragistro_compra();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un articulo \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cargar_varibles() {
       
        igv = 0.0;
        canti = Integer.parseInt(this.jtex_cantidad.getText());
        total = Double.parseDouble(this.jtex_total.getText());
        descuento = Double.parseDouble(this.jtex_descuento.getText());
        subtotal1 = Double.parseDouble(this.jtex_sub_total.getText());
        precio = Double.parseDouble(this.jtex_precio.getText());
    }

    private void estilo_windows() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(jpBaja_articulo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void seleccionar_pdf() {
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("Archivos", "pdf", "xlsx", "docx", "pptx");
        j.setFileFilter(fi);
        int se = j.showOpenDialog(this);
        if (se == 0) {
            this.archivo = j.getSelectedFile().getName();
            System.out.println("nombre de archivo: " + archivo);
            this.ruta_archivo = j.getSelectedFile().getAbsolutePath();

        } else {
        }
    }

    private void guardar_archivo_folder() {
        String text = this.archivo;
        String archivo = destino + text;
        File folder = new File(this.destino);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        this.enviar_archivo(this.ruta_archivo, archivo);
    }

    private static void enviar_archivo(String ruta, String archivo) {
        try {
            Path rut = Paths.get(ruta);
            Path ar = Paths.get(archivo);
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            Files.copy(rut, ar, options);
        } catch (IOException e) {
            System.err.println(e.toString());
        }

    }

    private void cargar_datos_compra() {
        if ( this.jtex_fecha.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos, ¡ANIMAL!\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else if (!"".equals(this.archivo)) {
            System.out.println("Archivo cargado " + archivo);
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione el archivo PDF, ¡ANIMAL!\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        guardar_compra();
    }
}
