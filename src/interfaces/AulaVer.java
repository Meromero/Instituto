package interfaces;

import com.mysql.jdbc.ResultSet;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AulaVer extends javax.swing.JDialog {
    int id;
    GestorBD bd;
    
    public AulaVer(int fila) {
        id = fila;
        int idAula = fila;
        initComponents();

        
        deshabilitarCampos();
        bd = new GestorBD();
        bd.getConnection();
        
        try {
            bd.getConnection();
            ResultSet rs = bd.consulta("SELECT * FROM `icba`.`aula` WHERE idAula = "+idAula);
            while (rs.next()){
            String sigla = rs.getString("sigla");
            jTextFieldSigla.setText(sigla);
            
            String capacidad = rs.getString("capacidad");
            jTextFieldCapacidad.setText(capacidad);
            
            String descripcion = rs.getString("equipo");
            jTextAreaDescripcion.setText(descripcion);
            }
            rs.close();        
                    
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al hacer la consulta a la BD" + ex);
        }

        jTextFieldSigla.requestFocus();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelDescripcion = new javax.swing.JLabel();
        jTextFieldSigla = new javax.swing.JTextField();
        jLabelSigla = new javax.swing.JLabel();
        jLabelCapacidad = new javax.swing.JLabel();
        jTextFieldCapacidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jButtonBuscarAula = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar Datos de Aula");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Aula"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDescripcion.setText("Descripción");
        jPanel2.add(jLabelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        jPanel2.add(jTextFieldSigla, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 270, -1));

        jLabelSigla.setText("Sigla");
        jPanel2.add(jLabelSigla, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabelCapacidad.setText("Capacidad");
        jPanel2.add(jLabelCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
        jPanel2.add(jTextFieldCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 270, -1));

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescripcion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 270, 160));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 450, 340));

        jButtonBuscarAula.setBackground(new java.awt.Color(255, 255, 255));
        jButtonBuscarAula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.jpg"))); // NOI18N
        jButtonBuscarAula.setText("Buscar");
        jButtonBuscarAula.setBorderPainted(false);
        jButtonBuscarAula.setContentAreaFilled(false);
        jButtonBuscarAula.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBuscarAula.setMaximumSize(new java.awt.Dimension(107, 101));
        jButtonBuscarAula.setMinimumSize(new java.awt.Dimension(107, 101));
        jButtonBuscarAula.setPreferredSize(new java.awt.Dimension(107, 101));
        jButtonBuscarAula.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonBuscarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarAulaActionPerformed(evt);
            }
        });
        jButtonBuscarAula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonBuscarAulaKeyPressed(evt);
            }
        });
        jPanel1.add(jButtonBuscarAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 170, 100));

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar2.jpg"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorderPainted(false);
        jButtonCancelar.setContentAreaFilled(false);
        jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancelar.setMaximumSize(new java.awt.Dimension(105, 99));
        jButtonCancelar.setMinimumSize(new java.awt.Dimension(105, 99));
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(105, 99));
        jButtonCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jButtonCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonCancelarKeyPressed(evt);
            }
        });
        jPanel1.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 520));

        pack();
    }//GEN-END:initComponents

    public void buscarAula() {
        dispose();
        
        AulaBuscarVer buscarusuario=new AulaBuscarVer();
        buscarusuario.setLocation(300,200);
        
        buscarusuario.setVisible(true);
    }
        
    public void cerrarVentana() {
        try {
            bd.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }
    
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        cerrarVentana();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonBuscarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarAulaActionPerformed
        buscarAula();
    }//GEN-LAST:event_jButtonBuscarAulaActionPerformed

    private void jButtonBuscarAulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonBuscarAulaKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            buscarAula();
        else
            if(evt.getKeyCode()== KeyEvent.VK_RIGHT)
                jButtonCancelar.requestFocus();
    }//GEN-LAST:event_jButtonBuscarAulaKeyPressed

    private void jButtonCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCancelarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            cerrarVentana();
        else
            if(evt.getKeyCode()== KeyEvent.VK_LEFT)
                jButtonBuscarAula.requestFocus();
    }//GEN-LAST:event_jButtonCancelarKeyPressed

   
    public void deshabilitarCampos(){ 
        jTextFieldSigla.setEditable(false);
        jTextFieldCapacidad.setEditable(false);
        jTextAreaDescripcion.setEditable(false);
        jTextFieldSigla.setBackground(Color.white);
        jTextFieldCapacidad.setBackground(Color.white);        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarAula;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelCapacidad;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelSigla;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFieldCapacidad;
    private javax.swing.JTextField jTextFieldSigla;
    // End of variables declaration//GEN-END:variables
}
