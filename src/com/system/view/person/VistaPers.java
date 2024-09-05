package com.system.view.person;


import com.system.business.PersonBo;
import com.system.identity.Person;
import com.system.view.JFDashboard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;


public class VistaPers extends javax.swing.JPanel {

    public static char op;
    protected static boolean estado = false;
    Person obj = new Person();

    public VistaPers() {
        initComponents();
        visible_boton(JFDashboard.est);
        cargar_tabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PanelVistaPer = new javax.swing.JPanel();
        btnAdd = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
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

        PanelVistaPer.setBackground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout PanelVistaPerLayout = new javax.swing.GroupLayout(PanelVistaPer);
        PanelVistaPer.setLayout(PanelVistaPerLayout);
        PanelVistaPerLayout.setHorizontalGroup(
            PanelVistaPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelVistaPerLayout.setVerticalGroup(
            PanelVistaPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        jPanel2.add(PanelVistaPer, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 750, 340));

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
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/edit.png"))); // NOI18N
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

        jPanel6.setBackground(new java.awt.Color(21, 67, 96));
        jPanel6.setPreferredSize(new java.awt.Dimension(122, 32));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 0, 204));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/5.png"))); // NOI18N
        jLabel1.setText("Listar");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, 40));

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

        jPanel8.setBackground(new java.awt.Color(21, 67, 96));
        jPanel8.setPreferredSize(new java.awt.Dimension(122, 32));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel8MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/update.png"))); // NOI18N
        jLabel3.setText("Actualizar");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, -1, 40));

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
        this.cargar_ragistro_actualizar();

    }//GEN-LAST:event_btnAddMousePressed

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
        this.cargar_tabla();
    }//GEN-LAST:event_jPanel6MousePressed

    private void jPanel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MousePressed
        if (!" ".equals(lista_eliminar.nom)) {
            try {
                Person material = PersonBo.validarPerson(lista_eliminar.nom,lista_eliminar.dni);
                lista_eliminar.id = material.getId();
                op = 'M';
                estado = true;
                this.cargar_ragistro_actualizar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el usuario",
                    "TRABAJADOR", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jPanel8MousePressed

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        this.btnAdd.setBackground(new Color(40, 116, 166));
        this.btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        this.btnAdd.setBackground(new Color(21, 67, 96));
    }//GEN-LAST:event_btnAddMouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        this.jPanel6.setBackground(new Color(40, 116, 166));
        this.jPanel6.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        this.jPanel6.setBackground(new Color(21, 67, 96));
    }//GEN-LAST:event_jPanel6MouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        this.btnEliminar.setBackground(new Color(40, 116, 166));
        this.btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        this.btnEliminar.setBackground(new Color(21, 67, 96));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        this.jPanel8.setBackground(new Color(40, 116, 166));
        this.jPanel8.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        this.jPanel8.setBackground(new Color(21, 67, 96));
    }//GEN-LAST:event_jPanel8MouseExited

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
        if (!"".equals(lista_eliminar.nom)) {          
            try {
                char opt = 'E';
                Person material = PersonBo.validarPerson(lista_eliminar.nom,lista_eliminar.dni);
                int id = material.getId();
                if (opt == 'E') {
                    obj.setId(id);
                    int rpta = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar",
                            "Persona", JOptionPane.YES_NO_OPTION);
                    if (rpta == 0) {
                        if (PersonBo.EliminarPerson(obj)) {
                            JOptionPane.showMessageDialog(this, "Se Eliminó Correctamente", "Persona",
                                    JOptionPane.INFORMATION_MESSAGE);
                            this.cargar_tabla();
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo Eliminar", "Persona",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), " Perosnal", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el Material", "Material", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JPanel PanelVistaPer;
    private javax.swing.JPanel btnAdd;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables

    protected void cargar_tabla() {
        lista_eliminar p1 = new lista_eliminar();
        p1.setSize(750, 343);
        p1.setLocation(0, 0);

        PanelVistaPer.removeAll();
        PanelVistaPer.add(p1, BorderLayout.CENTER);
        PanelVistaPer.revalidate();
        PanelVistaPer.repaint();
    }

    private void cargar_ragistro_actualizar() {
        // Abrir sección
        registro_actualizar p1 = new registro_actualizar();
        p1.setSize(750, 343);
        p1.setLocation(0, 0);

        PanelVistaPer.removeAll();
        PanelVistaPer.add(p1, BorderLayout.CENTER);
        PanelVistaPer.revalidate();
        PanelVistaPer.repaint();
    }
    private void visible_boton(boolean est) {
        if (est == true) {
            this.btnEliminar.setVisible(false);
           
            
        }
    }
}
