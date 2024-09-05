package com.system.view;

import java.awt.Image;
import java.util.LinkedList;
import javax.swing.ImageIcon;

public class Principal extends javax.swing.JPanel {

    LinkedList<String> imagenPaths;
    int index = 0;

    public Principal() {
        initComponents();
//        cargar_imagen();
        mostrar_imagen();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Imagen_prin = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html>Brindamos servicios de mantenimiento preventivo en sistemas eléctricos de plantas<p> industriales, refrigeración, aire acondicionado, calefacción y ventilación en general.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("INFORMACIÓN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 180, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Porque Elegirnos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel4.setText("Profesionales en lo que hacemos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("<html>Somos una empresa creada por profesionales con amplia experiencia en servicios de montaje, instalación y mantenimiento de equipos eléctricos de plantas industriales, refrigeración en todas sus aplicaciones, aire acondicionado, con aplicación en plantas de procesos y minería. Nuestros profesionales se han desarrollado en la industria  por más de 20 años en las áreas de mantenimiento de plantas de procesos, generando durante este tiempo un amplio know-how que actualmente nos habilita para brindar un servicio de mantenimiento de calidad. Nuestro interés es desarrollar proyectos de alto impacto aumentando la productividad de los equipos.\n" +
            "\n" +
            "Nuestro trabajo nos llena de orgullo. Deje que los profesionales se encarguen de sus problemas.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 270, 910, -1));

        Imagen_prin.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.add(Imagen_prin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 1040, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagen_prin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void showImage(String name) {
        Image Myimagen = new ImageIcon(name).getImage();
        ImageIcon imagen = new ImageIcon(Myimagen.getScaledInstance(1035, 584, Image.SCALE_SMOOTH));
        Imagen_prin.setIcon(imagen);
    }

    private void mostrar_imagen() {
        imagenPaths = new LinkedList<>();
        imagenPaths.add("src/com/system/img/img1.jpg");
        String img = imagenPaths.get(index);
        showImage(img);
    }

  

}
