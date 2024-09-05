package com.system.view.product;


import com.system.conexion.TextPrompt;
import com.system.identity.Producto;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;


public class registro_producto extends javax.swing.JPanel {

   Producto objProducto = new Producto();
    char opt = 'N';

    public registro_producto() {
        initComponents();
        plaseholder();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jtex_producto = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBxMarca = new javax.swing.JComboBox<>();
        jtex_caracteristicas = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(739, 325));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(739, 325));

        btnAgregar.setBackground(new java.awt.Color(0, 51, 51));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
        });
        btnAgregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/agregar.png"))); // NOI18N
        jLabel1.setText("Agregar");
        btnAgregar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, 107, -1));

        jComboBxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 578, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtex_caracteristicas)
                    .addComponent(jtex_producto))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jtex_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtex_caracteristicas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed
        switch (opt) {
            case 'N':
                if (this.jtex_producto.getText().equals("")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    this.jtex_producto.requestFocus();
                } else {
                    this.registrar();
                }
                break;
            case 'M':

                break;
        }
    }//GEN-LAST:event_btnAgregarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAgregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBxMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtex_caracteristicas;
    private javax.swing.JTextField jtex_producto;
    // End of variables declaration//GEN-END:variables

    private void plaseholder() {
        TextPrompt prueba0 = new TextPrompt(" Ingrese el producto a registrar", this.jtex_producto);
        

    }

    private void registrar() {
        this.cargar_obj();
        try {
            if (ProductoBo.grabarProducto(objProducto)) {
                JOptionPane.showMessageDialog(null, "Se Registró Correctamente", "MENSAJE --> Producto", JOptionPane.INFORMATION_MESSAGE);
                this.cargar_registro_actualiza();
                this.limpiarcampos();

            } else {
                JOptionPane.showMessageDialog(this, "No se pudo Registrar", "MENSAJE --> Producto", JOptionPane.ERROR_MESSAGE);
                this.limpiarcampos();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "MENSAJE --> Producto", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargar_obj() {

     objProducto.setProducto(this.jtex_producto.getText());
        
    }

    private void limpiarcampos() {
        this.jtex_producto.setText("");
        
    }

    private void cargar_registro_actualiza() throws Exception {
//        registro_actualiza p1 = new registro_actualiza();
//        p1.setSize(750, 343);
//        p1.setLocation(0, 0);
//
//        PanelVistaMat.removeAll();
//        PanelVistaMat.add(p1, BorderLayout.CENTER);
//        PanelVistaMat.revalidate();
//        PanelVistaMat.repaint();
    }
}
