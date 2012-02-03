package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class JPanelImagen extends javax.swing.JPanel {
    ImageIcon imagen;

    public JPanelImagen(String nombre) {
        initComponents();
        imagen = new ImageIcon(getClass().getResource(nombre));
        setSize(imagen.getIconWidth(), imagen.getIconHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension dim= getSize();
        g.drawImage(imagen.getImage(), 0, 0, dim.width,dim.height, this);
        setOpaque(false);
        super.paintComponent(g);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}