package com.system.view.user;

import com.system.business.PersonBo;
import com.system.business.RolBo;
import com.system.business.UsuarioBo;
import com.system.conexion.TextPrompt;
import com.system.identity.Usuario;
import static com.system.view.user.VistaUsuario.PanelVistaUsuario;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class registro_actualiza extends javax.swing.JPanel {

    Usuario objUsuario = new Usuario();
    private DefaultComboBoxModel Persona;
    private DefaultComboBoxModel comboRol;

    public registro_actualiza() throws Exception {
        initComponents();
        plaseholder();
        cargarComboPersona();
        cargarComboUnidad();
        cargar_campos(VistaUsuario.estado);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtContrasena = new javax.swing.JTextField();
        ComboPersona = new javax.swing.JComboBox<>();
        txtUsuario = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ComboRol = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(739, 325));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(739, 325));

        ComboPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregar.setBackground(new java.awt.Color(0, 51, 51));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
        });
        btnAgregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/agregar.png"))); // NOI18N
        jLabel2.setText("Agregar");
        btnAgregar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 0, 110, 30));

        ComboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ComboRol, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(ComboPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(ComboPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboRol, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed
        try {
            switch (VistaUsuario.op) {
                case 'N':
                    if (this.txtContrasena.getText().equals("") || this.txtUsuario.getText().equals("")) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                        this.txtUsuario.requestFocus();
                    } else {
                        this.registrar();
                    }
                    break;
                case 'M': {
                    this.modificar();
                }

                break;
            }
        } catch (Exception ex) {
            Logger.getLogger(registro_actualiza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboPersona;
    private javax.swing.JComboBox<String> ComboRol;
    private javax.swing.JPanel btnAgregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void plaseholder() {
        TextPrompt prueba0 = new TextPrompt(" Ingrese el usuario", this.txtUsuario);
        TextPrompt prueba4 = new TextPrompt(" ingrese la contraseña", this.txtContrasena);

    }

    private void registrar() {
        this.cargar_obj();
        try {
            if (UsuarioBo.grabarUsuario(objUsuario)) {
                JOptionPane.showMessageDialog(null, "Se Registró Correctamente", "MENSAJE --> Usuario", JOptionPane.INFORMATION_MESSAGE);
                this.cargar_tabla();
                this.limpiarcampos();

            } else {
                JOptionPane.showMessageDialog(this, "No se pudo Registrar", "MENSAJE --> Usuario", JOptionPane.ERROR_MESSAGE);
                this.limpiarcampos();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "MENSAJE --> Usuario", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargar_obj() {
        objUsuario.setPersona(this.ComboPersona.getSelectedItem().toString());
        objUsuario.setUsuario(this.txtUsuario.getText());
        objUsuario.setPassword(this.txtContrasena.getText());
        objUsuario.setRol(this.ComboRol.getSelectedItem().toString());

    }

    private void limpiarcampos() {

        this.txtContrasena.setText("");
        this.txtUsuario.setText("");
        this.ComboPersona.setSelectedIndex(0);
        this.ComboRol.setSelectedIndex(0);
    }

    private void modificar() throws Exception {

        this.cargar_obj();
        
        try {
            if (UsuarioBo.modificarUsuario(objUsuario)) {
                JOptionPane.showMessageDialog(null, "Se Registró Correctamente", "MENSAJE --> Usuario", JOptionPane.INFORMATION_MESSAGE);
                this.cargar_tabla();
                this.limpiarcampos();

            } else {
                JOptionPane.showMessageDialog(this, "No se pudo Registrar", "MENSAJE --> Usuario", JOptionPane.ERROR_MESSAGE);
                this.limpiarcampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "MENSAJE --> Usuario", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargar_campos(boolean estado) throws Exception {
        if (VistaUsuario.estado == true) {
            Usuario usuario = UsuarioBo.validarUsuarioId(lista_eliminar.per, lista_eliminar.usu);
            int id = usuario.getId();
            objUsuario.setId(id);
            this.ComboPersona.setSelectedItem(lista_eliminar.per);
            this.txtUsuario.setText(lista_eliminar.usu);
            this.txtContrasena.setText(usuario.getPassword());
            this.ComboRol.setSelectedItem(lista_eliminar.rol);
        }

    }

    private void cargar_tabla() {
        lista_eliminar p1 = new lista_eliminar();
        p1.setSize(750, 343);
        p1.setLocation(0, 0);

        PanelVistaUsuario.removeAll();
        PanelVistaUsuario.add(p1, BorderLayout.CENTER);
        PanelVistaUsuario.revalidate();
        PanelVistaUsuario.repaint();
    }

    private void cargarComboPersona() {
        try {
            Persona = PersonBo.obtenerPersona();
            ComboPersona.setModel(Persona);
            ComboPersona.setPreferredSize(new Dimension(600, 22));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }

    private void cargarComboUnidad() {
        try {
            comboRol = RolBo.obtenerRol();
            ComboRol.setModel(comboRol);
            ComboRol.setPreferredSize(new Dimension(600, 22));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }
}
