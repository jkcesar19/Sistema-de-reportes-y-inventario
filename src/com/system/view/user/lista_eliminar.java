package com.system.view.user;



import com.system.business.UsuarioBo;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class lista_eliminar extends javax.swing.JPanel {

    private DefaultTableModel UsuarioTableModel;
    private int index;
    protected static int id = 0;
    protected static String usu;
    protected static String con;
    protected static String per;
    protected static String rol;
    


    public lista_eliminar() {
        initComponents();
        UsuarioTable.fixTable(jScrollPane1);
        loadTablePerson();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UsuarioTable = new com.system.table.Table();

        setBackground(new java.awt.Color(204, 0, 204));
        setPreferredSize(new java.awt.Dimension(739, 331));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(739, 331));

        UsuarioTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(UsuarioTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.table.Table UsuarioTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void loadTablePerson() {
        try {
            TableColumn columna;
            this.UsuarioTableModel = UsuarioBo.ListaTable();
            this.UsuarioTable.setModel(this.UsuarioTableModel);
//            setAnchoColumnas();
            columna = this.UsuarioTable.getColumnModel().getColumn(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargar_datos_actualizar_eliminar(MouseEvent evt) {
        try {
            index = this.UsuarioTable.getSelectedRow();
            per = this.UsuarioTable.getValueAt(index, 0).toString();
            usu = this.UsuarioTable.getValueAt(index, 1).toString();
            rol = this.UsuarioTable.getValueAt(index, 2).toString();   
        } catch (Exception e) {

        }
    }
}
