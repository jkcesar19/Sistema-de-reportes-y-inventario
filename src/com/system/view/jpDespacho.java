package com.system.view;

import com.system.business.ArticuloBo;
import com.system.business.DespachoBo;
import com.system.business.Detalle_DespachoBo;
import com.system.business.PersonBo;
import com.system.conexion.TextPrompt;
import com.system.identity.Articulo;
import com.system.identity.Despacho;
import com.system.identity.Detalle_Despacho;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class jpDespacho extends javax.swing.JPanel {

    private DefaultTableModel ArticuloTableModel;
    private DefaultComboBoxModel Proveedor;

    DefaultTableModel modelo2 = new DefaultTableModel();
    Despacho objCompra = new Despacho();
    Articulo objArticulo = new Articulo();
    Detalle_Despacho objDetalle = new Detalle_Despacho();

    private int index = -1;
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
    private int can;

    private double precio;
    private double total;
    private double igv;
    private double descuento;
    private double subtotal;
    private double subtotal1;
    private double total1;
    private double descuento1;
    private double igv1;
    private boolean st = false;
    private char opt;

    public jpDespacho() {
        initComponents();
        limpiar();
        loadTableMateria();
        loadComboProveedor();
        personalizarJtable();
        personalizarJtable1();

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
        jtex_descripcion = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Articulo_table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btn_agregar = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jtex_cantidad = new javax.swing.JTextField();
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
        jLabel2.setText("DESPACHO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 8, 200, 30));

        jtex_numero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jPanel2.add(jtex_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 147, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("#NUM:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 40));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtex_descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtex_descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("lista de articulos"));

        Articulo_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Articulo"
            }
        ));
        Articulo_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Articulo_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Articulo_table);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            .addGroup(btn_agregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        btn_agregarLayout.setVerticalGroup(
            btn_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_agregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jtex_cantidad.setText("cantidad");
        jtex_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtex_cantidadKeyReleased(evt);
            }
        });
        jPanel4.add(jtex_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, 32));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Personal"));

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        table_detalle_articulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCIÓN", "CANTIDAD"
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
                .addContainerGap(21, Short.MAX_VALUE))
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
                .addContainerGap(17, Short.MAX_VALUE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
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

    private void Articulo_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Articulo_tableMouseClicked
        try {
            index = Articulo_table.getSelectedRow();
            id = Integer.parseInt(Articulo_table.getValueAt(index, 0).toString());
            descri = Articulo_table.getValueAt(index, 1).toString();
            canti = Integer.parseInt(Articulo_table.getValueAt(index, 2).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_Articulo_tableMouseClicked

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        registrar();
    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
//        this.estilo_windows();
//        this.seleccionar_pdf();
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

    private void jtex_cantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtex_cantidadKeyReleased
        if (!"".equals(this.jtex_cantidad.getText())) {
            can = Integer.parseInt(this.jtex_cantidad.getText());
            if (canti >= can) {
            } else {
                JOptionPane.showMessageDialog(this, " La cantidad ingresad es mayor al stock", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, " Ingrese la cantidad", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jtex_cantidadKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Articulo_table;
    private javax.swing.JComboBox<String> ComboProveedor;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JPanel btnGenerar;
    private javax.swing.JPanel btn_agregar;
    private javax.swing.JPanel btn_pdf;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JTextField jtex_cantidad;
    private javax.swing.JTextField jtex_descripcion;
    private javax.swing.JLabel jtex_numero;
    private javax.swing.JTable table_detalle_articulo;
    // End of variables declaration//GEN-END:variables

    private void loadTableMateria() {
        try {
            TableColumn columna;
            this.ArticuloTableModel = ArticuloBo.ListaTable();
            this.Articulo_table.setModel(this.ArticuloTableModel);
            columna = this.Articulo_table.getColumnModel().getColumn(0);
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
            String serie = DespachoBo.NumId();
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
        if (id != 0) {
            lista.add(id);
            lista.add(descri);
            lista.add(canti);
            Object[] ob = new Object[3];
            ob[0] = lista.get(0);
            ob[1] = lista.get(1);
            ob[2] = lista.get(2);

            modelo2.addRow(ob);
            limpiar();
            limpiar_variables();
            table_detalle_articulo.setModel(modelo2);

        }
    }

    private void limpiar_variables() {
        descri = "";
        canti = 0;
    }

    private void registrar() {
        try {

            cargar_datos_despacho();

            if (st == true) {
                String idT = DespachoBo.NumId();
                id = Integer.parseInt(idT);
                System.out.println("id de compra " + id);

                actualizar_articulo();

                guardar_detalle_despacho();

                limpiarTodo();
                loadTableMateria();
                personalizarJtable1();

                numero_compra();
                limpiarDescrip();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error " + ex);
        }

    }

    private void guardar_compra() {
        try {
            objCompra.setId_usuario(JFDashboard.usuaa);
            objCompra.setId_personal(this.ComboProveedor.getSelectedItem().toString());
            objCompra.setDescripcion(this.jtex_descripcion.getText());
            objCompra.setNumero(Integer.parseInt(this.jtex_numero.getText()));

            if (DespachoBo.grabarDespacho(objCompra)) {
                JOptionPane.showMessageDialog(this, "Se Registró Correctamente", "MENSAJE --> Despacho", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "No se pudo Registrar", "MENSAJE --> Despacho", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "MENSAJE --> DESPACHO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardar_detalle_despacho() {
        try {
            for (int i = 0; i < table_detalle_articulo.getRowCount(); i++) {
                objDetalle.setId_despacho(id);
                objDetalle.setId_articulo(Integer.parseInt(table_detalle_articulo.getValueAt(i, 0).toString()));
                objDetalle.setCantidad(Integer.parseInt(table_detalle_articulo.getValueAt(i, 2).toString()));
                Detalle_DespachoBo.grabarDetalle_Despacho(objDetalle);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "MENSAJE --> DETALLE TICKET", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizar_articulo() {
        try {
            for (int i = 0; i < Articulo_table.getRowCount(); i++) {
                objArticulo.setId(Integer.parseInt(Articulo_table.getValueAt(i, 0).toString()));
                objArticulo.setStock_final(Integer.parseInt(Articulo_table.getValueAt(i, 2).toString()));
                int sta = Integer.parseInt(Articulo_table.getValueAt(i, 2).toString());
                if (sta != 0) {
                    objArticulo.setEst(1);
                } else {
                    objArticulo.setEst(0);
                }

                ArticuloBo.ModificarArticulo(objArticulo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "MENSAJE --> DETALLE TICKET", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarTodo() {

        for (int i = 0; i < modelo2.getRowCount(); i++) {
            modelo2.removeRow(i);
            i = i - 1;
        }
    }

    private void limpiar() {

        this.jtex_cantidad.setText("");

    }

    private void plaseholder() {
        TextPrompt prueba0 = new TextPrompt("Cantidad", this.jtex_cantidad);
        TextPrompt prueba1 = new TextPrompt("Ingrese una descripción de los articulos entregados al personal", this.jtex_descripcion);
    }

    private double redondear(double num) {
        return Math.rint(num * 100) / 100;
    }

    private void cargar_datos() {
        if (!"".equals(descri)) {
            if (this.jtex_cantidad.getText().equals("")) {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos, ¡POR FAVOR!\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                int total = canti - can;
                ArticuloTableModel.setValueAt(total, index, 2);
                cargar_varibles();
                cargar_ragistro_compra();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un articulo \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cargar_varibles() {
        canti = Integer.parseInt(this.jtex_cantidad.getText());

    }

    private void estilo_windows() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(jpDespacho.class.getName()).log(Level.SEVERE, null, ex);
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

    private void cargar_datos_despacho() {
        if (this.jtex_descripcion.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Escriba la descripción, ¡POR favor!\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            st = false;
        } else {
            guardar_compra();
            st = true;
        }

    }

    private void personalizarJtable() {
        this.table_detalle_articulo.getColumnModel().getColumn(0).setMinWidth(40);
        this.table_detalle_articulo.getColumnModel().getColumn(0).setMaxWidth(40);

        this.table_detalle_articulo.getColumnModel().getColumn(2).setMinWidth(90);
        this.table_detalle_articulo.getColumnModel().getColumn(2).setMaxWidth(90);
    }

    private void personalizarJtable1() {

        this.Articulo_table.getColumnModel().getColumn(0).setMinWidth(40);
        this.Articulo_table.getColumnModel().getColumn(0).setMaxWidth(40);

        this.Articulo_table.getColumnModel().getColumn(2).setMinWidth(50);
        this.Articulo_table.getColumnModel().getColumn(2).setMaxWidth(50);
    }

    private void limpiarDescrip() {
     this.jtex_descripcion.setText("");
    }
}
