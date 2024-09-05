package com.system.view;

import com.system.business.UsuarioBo;
import com.system.conexion.TextPrompt;
import com.system.identity.Usuario;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author llaguento carlos cesar
 */
public class JFLogin extends javax.swing.JFrame {

    private String usua;
    private String pass;
    int xMouse, yMouse;

    public JFLogin() {
        initComponents();
         this.setLocationRelativeTo(null);
        plaseholder();
        jblestado(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jblusuario = new javax.swing.JLabel();
        jblpass = new javax.swing.JLabel();
        btn_ingresar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtex_pass = new javax.swing.JPasswordField();
        jtex_usua = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 450));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/icon_usuario.png"))); // NOI18N
        jLabel5.setFocusable(false);
        jLabel5.setInheritsPopupMenu(false);
        jLabel5.setRequestFocusEnabled(false);
        jLabel5.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 60, 70));

        jPanel2.setBackground(new java.awt.Color(46, 134, 193));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("WELCOME TO THE SYSTEM");

        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("log in to continue");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)))
                .addGap(43, 43, 43))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 90));

        jSeparator1.setBackground(new java.awt.Color(46, 134, 193));
        jSeparator1.setForeground(new java.awt.Color(46, 134, 193));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 290, 10));

        jSeparator2.setBackground(new java.awt.Color(46, 134, 193));
        jSeparator2.setForeground(new java.awt.Color(46, 134, 193));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 290, -1));

        jblusuario.setForeground(new java.awt.Color(255, 0, 0));
        jblusuario.setText("campo vacío");
        jPanel1.add(jblusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 290, -1));

        jblpass.setForeground(new java.awt.Color(255, 0, 0));
        jblpass.setText("campo vacío");
        jPanel1.add(jblpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 290, -1));

        btn_ingresar.setBackground(new java.awt.Color(46, 134, 193));
        btn_ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ingresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ingresarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ingresarMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ingresar");

        javax.swing.GroupLayout btn_ingresarLayout = new javax.swing.GroupLayout(btn_ingresar);
        btn_ingresar.setLayout(btn_ingresarLayout);
        btn_ingresarLayout.setHorizontalGroup(
            btn_ingresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ingresarLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );
        btn_ingresarLayout.setVerticalGroup(
            btn_ingresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 290, 30));

        jtex_pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtex_pass.setBorder(null);
        jtex_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtex_passKeyPressed(evt);
            }
        });
        jPanel1.add(jtex_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 290, 30));

        jtex_usua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtex_usua.setBorder(null);
        jtex_usua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtex_usuaKeyPressed(evt);
            }
        });
        jPanel1.add(jtex_usua, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 290, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresarMousePressed
        ingresar_sistema();
    }//GEN-LAST:event_btn_ingresarMousePressed

    private void btn_ingresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresarMouseEntered
        this.btn_ingresar.setBackground(new Color(1, 179, 251));
        this.btn_ingresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_ingresarMouseEntered

    private void btn_ingresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresarMouseExited
        this.btn_ingresar.setBackground(new Color(46,134,193));
    }//GEN-LAST:event_btn_ingresarMouseExited

    private void jtex_usuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtex_usuaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtex_pass.requestFocus();
        }
    }//GEN-LAST:event_jtex_usuaKeyPressed

    private void jtex_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtex_passKeyPressed
         if (evt.getKeyCode() == evt.VK_ENTER) {
             this.ingresar_sistema();
        }
    }//GEN-LAST:event_jtex_passKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jblpass;
    private javax.swing.JLabel jblusuario;
    private javax.swing.JPasswordField jtex_pass;
    private javax.swing.JTextField jtex_usua;
    // End of variables declaration//GEN-END:variables

    private void plaseholder() {
        TextPrompt prueba0 = new TextPrompt(" Ingrese el usuario", this.jtex_usua);
        TextPrompt prueba1 = new TextPrompt(" Ingrese la contraseña", this.jtex_pass);
    }

    private void ingresar_sistema() {
        if (this.jtex_usua.getText().trim().isEmpty()) {
            this.jblusuario.setVisible(true);
            this.jblusuario.setText("Campo vacío");
        } else if (this.jtex_pass.getText().trim().isEmpty()) {
            this.jblpass.setVisible(true);
            this.jblpass.setText("Campo vacío");
        } else {
            try {
                usua = this.jtex_usua.getText().trim();
                pass = new String(this.jtex_pass.getText()).trim();
                Usuario usuario = UsuarioBo.validarUsuario(usua, pass);
                JFDashboard.adm = usuario.getRol();
                JFDashboard.usuaa = usuario.getPersona();
                JFDashboard.usua = usuario.getUsuario();
                String usu = usuario.getRol();

                if (usu.equals("empleado")) {
                    JFDashboard.est = true;
                } else {
                    JFDashboard.est = false;
                }

                //visualizar panel principal
                new JFDashboard().setVisible(true);
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "USUARIO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void jblestado(boolean b) {
        this.jblusuario.setVisible(b);
        this.jblpass.setVisible(b);
    }
}
