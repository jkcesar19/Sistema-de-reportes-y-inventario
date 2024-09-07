package com.system.view.product;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VistaProduc extends javax.swing.JPanel {

    public static char op;
    protected static boolean estado = false;

    public VistaProduc() {
        initComponents();
        cargar_tabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PanelVistaProducto = new javax.swing.JPanel();
        btnAdd = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnListar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setMaximumSize(new java.awt.Dimension(789, 449));
        setPreferredSize(new java.awt.Dimension(789, 449));

        jPanel1.setBackground(new java.awt.Color(40, 116, 166));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelVistaProducto.setBackground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout PanelVistaProductoLayout = new javax.swing.GroupLayout(PanelVistaProducto);
        PanelVistaProducto.setLayout(PanelVistaProductoLayout);
        PanelVistaProductoLayout.setHorizontalGroup(
            PanelVistaProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelVistaProductoLayout.setVerticalGroup(
            PanelVistaProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        jPanel2.add(PanelVistaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 750, 340));

        btnAdd.setBackground(new java.awt.Color(21, 67, 96));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/agregar.png"))); // NOI18N
        jLabel4.setText("Agregar");

        javax.swing.GroupLayout btnAddLayout = new javax.swing.GroupLayout(btnAdd);
        btnAdd.setLayout(btnAddLayout);
        btnAddLayout.setHorizontalGroup(
            btnAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        btnAddLayout.setVerticalGroup(
            btnAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, 40));

        btnListar.setBackground(new java.awt.Color(21, 67, 96));
        btnListar.setPreferredSize(new java.awt.Dimension(122, 32));
        btnListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnListarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnListarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnListarMousePressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 0, 204));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/edit.png"))); // NOI18N
        jLabel1.setText("Lista");

        javax.swing.GroupLayout btnListarLayout = new javax.swing.GroupLayout(btnListar);
        btnListar.setLayout(btnListarLayout);
        btnListarLayout.setHorizontalGroup(
            btnListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnListarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        btnListarLayout.setVerticalGroup(
            btnListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnListarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, 40));

        btnEliminar.setBackground(new java.awt.Color(21, 67, 96));
        btnEliminar.setPreferredSize(new java.awt.Dimension(122, 32));
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

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/delete.png"))); // NOI18N
        jLabel2.setText("Eliminar");

        javax.swing.GroupLayout btnEliminarLayout = new javax.swing.GroupLayout(btnEliminar);
        btnEliminar.setLayout(btnEliminarLayout);
        btnEliminarLayout.setHorizontalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEliminarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        btnEliminarLayout.setVerticalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, -1, 40));

        btnModificar.setBackground(new java.awt.Color(21, 67, 96));
        btnModificar.setPreferredSize(new java.awt.Dimension(122, 32));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnModificarMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/update.png"))); // NOI18N
        jLabel3.setText("Actualizar");

        javax.swing.GroupLayout btnModificarLayout = new javax.swing.GroupLayout(btnModificar);
        btnModificar.setLayout(btnModificarLayout);
        btnModificarLayout.setHorizontalGroup(
            btnModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnModificarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnModificarLayout.setVerticalGroup(
            btnModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, -1, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMousePressed
        this.btnAdd.setBackground(new Color(40, 116, 166));
        op = 'N';
        try
        {
            this.cargar_ragistro_actualizar();
        } catch (Exception ex)
        {
            Logger.getLogger(VistaProduc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAddMousePressed

    private void btnListarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMousePressed
        this.cargar_tabla();
    }//GEN-LAST:event_btnListarMousePressed

    private void btnModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMousePressed
//        if (!"".equals(lista_eliminar.usu))
//        {
//            try
//            {
//                op = 'M';
//                estado = true;
//                this.cargar_ragistro_actualizar();
//            } catch (Exception e)
//            {
//                JOptionPane.showMessageDialog(null, "Error " + e);
//            }
//
//        } else
//        {
//            JOptionPane.showMessageDialog(this, "Seleccione el usuario",
//                    "TRABAJADOR", JOptionPane.WARNING_MESSAGE);
//        }
//
    }//GEN-LAST:event_btnModificarMousePressed

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
//        if (!"".equals(lista_eliminar.usu))
//        {
//            char opt = 'E';
//            try
//            {
//
//                Usuario usuario = UsuarioBo.validarUsuarioId(lista_eliminar.per, lista_eliminar.usu);
//                int id = usuario.getId();
//                if (opt == 'E')
//                {
//                    objUsuario.setId(id);
//                    int rpta = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar",
//                            "Usuario", JOptionPane.YES_NO_OPTION);
//                    if (rpta == 0)
//                    {
//                        if (UsuarioBo.eliminarUsuario(objUsuario))
//                        {
//                            JOptionPane.showMessageDialog(this, "Se Eliminó Correctamente", "Usuario",
//                                    JOptionPane.INFORMATION_MESSAGE);
//                            this.cargar_tabla();
//                        } else
//                        {
//                            JOptionPane.showMessageDialog(this, "No se pudo Eliminar", "Usuario",
//                                    JOptionPane.ERROR_MESSAGE);
//                        }
//                    }
//                }
//            } catch (Exception e)
//            {
//                JOptionPane.showMessageDialog(this, e.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
//            }
//        } else
//        {
//            JOptionPane.showMessageDialog(this, "Seleccione el Usuario", "Usuario", JOptionPane.ERROR_MESSAGE);
//        }

    }//GEN-LAST:event_btnEliminarMousePressed

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        this.btnAdd.setBackground(new Color(40, 116, 166));
        this.btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        this.btnAdd.setBackground(new Color(21, 67, 96));
    }//GEN-LAST:event_btnAddMouseExited

    private void btnListarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMouseEntered
        this.btnListar.setBackground(new Color(40, 116, 166));
        this.btnListar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnListarMouseEntered

    private void btnListarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMouseExited
        this.btnListar.setBackground(new Color(21, 67, 96));
    }//GEN-LAST:event_btnListarMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        this.btnEliminar.setBackground(new Color(40, 116, 166));
        this.btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        this.btnEliminar.setBackground(new Color(21, 67, 96));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        this.btnModificar.setBackground(new Color(40, 116, 166));
        this.btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        this.btnModificar.setBackground(new Color(21, 67, 96));
    }//GEN-LAST:event_btnModificarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JPanel PanelVistaProducto;
    private javax.swing.JPanel btnAdd;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JPanel btnListar;
    private javax.swing.JPanel btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

    protected void cargar_tabla() {
        // Abrir sección
        lista_eliminar p1 = new lista_eliminar();
        p1.setSize(750, 343);
        p1.setLocation(0, 0);

        PanelVistaProducto.removeAll();
        PanelVistaProducto.add(p1, BorderLayout.CENTER);
        PanelVistaProducto.revalidate();
        PanelVistaProducto.repaint();
    }

    private void cargar_ragistro_actualizar() throws Exception {
        // Abrir sección
        registro_producto p1 = new registro_producto();
        p1.setSize(750, 343);
        p1.setLocation(0, 0);

        PanelVistaProducto.removeAll();
        PanelVistaProducto.add(p1, BorderLayout.CENTER);
        PanelVistaProducto.revalidate();
        PanelVistaProducto.repaint();
    }

    public void Te_ama(String si) {
        if (si.equals("si"))
        {
            amor_por_siempre();
        } else
        {
            a_llorar_a_otra_parte();
        }

    }

    private void amor_por_siempre() {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }

    private void a_llorar_a_otra_parte() {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }
}
