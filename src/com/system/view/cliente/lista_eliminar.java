package com.system.view.cliente;

import com.system.business.PersonBo;
import com.system.view.jpRegistro;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class lista_eliminar extends javax.swing.JPanel {

    private DefaultTableModel PersonTableModel;
    private int index;
    protected static int id = 0;
    protected static String nom = " ";
    protected static String doc = " ";
    protected static String dir;
    protected static String tel;
    protected static String est;
    protected static String correo;
    

    public lista_eliminar() {
        initComponents();
        PersonTable.fixTable(jScrollPane1);
        loadTablePerson();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PersonTable = new com.system.table.Table();
        jtex_enunciado_lista = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 0, 204));
        setPreferredSize(new java.awt.Dimension(739, 331));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(739, 331));

        PersonTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        PersonTable.setShowHorizontalLines(false);
        PersonTable.setShowVerticalLines(false);
        PersonTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PersonTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(PersonTable);

        jtex_enunciado_lista.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtex_enunciado_lista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtex_enunciado_lista.setText("LISTA DE CLIENTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jtex_enunciado_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtex_enunciado_lista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void PersonTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonTableMousePressed
        cargar_datos_actualizar_eliminar(evt);
    }//GEN-LAST:event_PersonTableMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.table.Table PersonTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jtex_enunciado_lista;
    // End of variables declaration//GEN-END:variables

    private void loadTablePerson() {
        try {
            TableColumn columna;
            this.PersonTableModel = PersonBo.ListaTable(jpRegistro.tipo_persona);
            this.PersonTable.setModel(this.PersonTableModel);
//            setAnchoColumnas();
            columna = this.PersonTable.getColumnModel().getColumn(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargar_datos_actualizar_eliminar(MouseEvent evt) {
        try {
            index = this.PersonTable.getSelectedRow();

            nom = this.PersonTable.getValueAt(index, 0).toString();
            doc = this.PersonTable.getValueAt(index, 1).toString();
            dir = this.PersonTable.getValueAt(index, 2).toString();
            tel = this.PersonTable.getValueAt(index, 3).toString();
            correo = this.PersonTable.getValueAt(index, 4).toString();
        } catch (Exception e) {

        }
    }
}
