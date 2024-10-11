package com.system.view.trabajador;

import com.system.business.PersonBo;
import com.system.conexion.TextPrompt;
import com.system.identity.Person;
import static com.system.view.trabajador.VistaPers.PanelVistaTrabajador;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

public class registro_actualizar extends javax.swing.JPanel {

    Person objPerson = new Person();

    public registro_actualizar() {
        initComponents();
        plaseholder();

        cargar_campos(VistaPers.estado);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jtex_nom = new javax.swing.JTextField();
        jtex_dni = new javax.swing.JTextField();
        jtex_direc = new javax.swing.JTextField();
        jtex_tel = new javax.swing.JTextField();
        jtex_corr = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtex_nunnciado_registro = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(739, 325));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(739, 325));

        btnAgregar.setBackground(new java.awt.Color(0, 51, 51));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/img/agregar.png"))); // NOI18N
        jLabel1.setText("Agregar");

        javax.swing.GroupLayout btnAgregarLayout = new javax.swing.GroupLayout(btnAgregar);
        btnAgregar.setLayout(btnAgregarLayout);
        btnAgregarLayout.setHorizontalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAgregarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        btnAgregarLayout.setVerticalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAgregarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jtex_nunnciado_registro.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtex_nunnciado_registro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtex_nunnciado_registro.setText("REGSITRO DE TRABAJADOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtex_nom)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtex_direc, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtex_corr, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtex_dni, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addComponent(jtex_tel))
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jtex_nunnciado_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jtex_nunnciado_registro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtex_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtex_direc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtex_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtex_corr, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtex_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
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
        switch (VistaPers.op) {
            case 'N':
                if (this.jtex_nom.getText().equals("") || this.jtex_dni.getText().equals("")
                        || this.jtex_tel.getText().equals("") || this.jtex_direc.getText().equals("")
                        || this.jtex_corr.getText().equals("")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    this.jtex_nom.requestFocus();
                } else {
                    this.registrar();
                }
                break;
            case 'M':

                this.modificar();

                break;
        }
    }//GEN-LAST:event_btnAgregarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAgregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtex_corr;
    private javax.swing.JTextField jtex_direc;
    private javax.swing.JTextField jtex_dni;
    private javax.swing.JTextField jtex_nom;
    private javax.swing.JLabel jtex_nunnciado_registro;
    private javax.swing.JTextField jtex_tel;
    // End of variables declaration//GEN-END:variables

    private void plaseholder() {
        TextPrompt prueba0 = new TextPrompt(" Ingrese el nombre completo", this.jtex_nom);
        TextPrompt prueba1 = new TextPrompt(" Ingrese la dirección", this.jtex_direc);
        TextPrompt prueba2 = new TextPrompt(" Ingrese el N° DNI", this.jtex_dni);
        TextPrompt prueba3 = new TextPrompt(" Ingrese el teléfono", this.jtex_tel);
        TextPrompt prueba4 = new TextPrompt(" Ingrese el correo", this.jtex_corr);

    }

    private void registrar() {
        this.cargar_obj();
        try {
            if (PersonBo.grabarPerson(objPerson)) {
                JOptionPane.showMessageDialog(null, "Se Registró Correctamente", "MENSAJE --> Personal", JOptionPane.INFORMATION_MESSAGE);
                this.cargar_tabla();
                this.limpiarcampos();

            } else {
                JOptionPane.showMessageDialog(this, "No se pudo Registrar", "MENSAJE --> Personal", JOptionPane.ERROR_MESSAGE);
                this.limpiarcampos();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "MENSAJE --> Personal", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargar_obj() {
        objPerson.setRazonsocial(this.jtex_nom.getText());
        objPerson.setDoc(this.jtex_dni.getText());
        objPerson.setId_d(1);
        objPerson.setId_p(1);
        objPerson.setDireccion(this.jtex_direc.getText());
        objPerson.setTelefono(this.jtex_tel.getText());
        objPerson.setCorreo(this.jtex_corr.getText());
        objPerson.setEstado(1);
    }

    private void limpiarcampos() {
        this.jtex_nom.setText("");
        this.jtex_direc.setText("");
        this.jtex_dni.setText("");
        this.jtex_corr.setText("");
        this.jtex_tel.setText("");
    }

    private void modificar() {
        this.cargar_obj();
        try {
            if (PersonBo.modificarPerson(objPerson)) {
                JOptionPane.showMessageDialog(null, "Se Registró Correctamente", "MENSAJE --> Personal", JOptionPane.INFORMATION_MESSAGE);
                this.cargar_tabla();
                this.limpiarcampos();

            } else {
                JOptionPane.showMessageDialog(this, "No se pudo Registrar", "MENSAJE --> Personal", JOptionPane.ERROR_MESSAGE);
                this.limpiarcampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "MENSAJE --> Personal", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargar_campos(boolean estado) {
        if (VistaPers.estado == true) {
            objPerson.setId(lista_eliminar.id);
            this.jtex_nom.setText(lista_eliminar.nom);
            this.jtex_direc.setText(lista_eliminar.dir);
            this.jtex_dni.setText("" + lista_eliminar.dni);
            this.jtex_corr.setText(lista_eliminar.correo);
            this.jtex_tel.setText("" + lista_eliminar.tel);
        } else {
            limpiarcampos();
        }

    }

    private void cargar_tabla() {
        lista_eliminar p1 = new lista_eliminar();
        p1.setSize(750, 343);
        p1.setLocation(0, 0);

        PanelVistaTrabajador.removeAll();
        PanelVistaTrabajador.add(p1, BorderLayout.CENTER);
        PanelVistaTrabajador.revalidate();
        PanelVistaTrabajador.repaint();
    }
}
