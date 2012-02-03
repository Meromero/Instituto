package interfaces;

import com.mysql.jdbc.ResultSet;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class AulaBuscarEstado extends javax.swing.JDialog {
    MiModelo modelo;
    
    public AulaBuscarEstado() {
        initComponents();
        buscarAula();
    }

    public void buscarAula() {
        try{
            String buscar = jTextFieldAula.getText();
            buscarAulas(buscar);
        }
        catch(Exception e){
        }
    }
    
    public void elegirAula(){
        int fila, aula;
        String sentencia, estado;
        
        fila = jTableAulas.getSelectedRow();
        if (fila == -1)
            JOptionPane.showMessageDialog(null,"Error: Es necesario seleccionar una aula","Busqueda de Aula",JOptionPane.INFORMATION_MESSAGE) ;
        else{
            aula = Integer.parseInt(String.valueOf(jTableAulas.getValueAt(fila,0)));
            estado = String.valueOf(jTableAulas.getValueAt(fila,3));
            String buscar = jTextFieldAula.getText();

            GestorBD bd = new GestorBD(); 
            int idAula = aula;
            try {
                bd.getConnection();
                if ("Inactivo".equals(estado))
                    sentencia = "UPDATE `icba`.`aula` SET `estado` = '1'"
                        + "WHERE `aula`.`idAula` = "+idAula+";";
                else
                    sentencia = "UPDATE `icba`.`aula` SET `estado` = '0'"
                        + "WHERE `aula`.`idAula` = "+idAula+";";
                bd.modificarBD(sentencia);            
                bd.cerrar();             
            } catch (SQLException ex) {
                Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
            }     

            if ("Inactivo".equals(estado))
                JOptionPane.showMessageDialog(null,"Aula habilitada exitosamente","Modificación de Estado",JOptionPane.INFORMATION_MESSAGE) ;
            else
                JOptionPane.showMessageDialog(null,"Aula inhabilitada exitosamente","Modificación de Estado",JOptionPane.INFORMATION_MESSAGE) ;
            buscarAulas(buscar);
        }
    }
    
    public void limpiarTabla(){
       modelo.setRowCount(0);
       modelo.setColumnCount(0);
    }   

    public void buscarAulas(String buscar){
        GestorBD bd = new GestorBD();
        bd.getConnection();
        ResultSet rs = null;
        try {
            rs = bd.consulta("Select * From `icba`.`aula` Where (sigla like '%"+buscar+"%') Order By sigla"); 
        } catch (SQLException ex) {
            Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
        
       limpiarTabla();
       modelo.addColumn("ID Aula");
       modelo.addColumn("Sigla");
       modelo.addColumn("Capacidad");
       modelo.addColumn("Estado");
      
        try {
            // Bucle para cada resultado en la consulta
            while (rs.next()){
               // Se crea un array que será una de las filas de la tabla.
               Object [] fila = new Object[4]; // Hay tres columnas en la tabla
               
               // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
               for (int i=0;i<4;i++)
                  if (i<3) 
                      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                  else
                      if (i!=3) //Aumentamos dos para saltarnos la columna del dia
                        fila[i] = rs.getObject(i+2);
                      else
                      if ("true".equals(String.valueOf(rs.getObject(5))))
                          fila[i] = "Activo";
                      else
                          fila[i] = "Inactivo";
               modelo.addRow(fila);      // Se añade al modelo la fila completa.
            }          
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar ingresar lo datos" + ex);
        }        
    }
    
    

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanelFondo = new javax.swing.JPanel();
        jLabelAula = new javax.swing.JLabel();
        jScrollPaneLista = new javax.swing.JScrollPane();
        modelo = new MiModelo();
        jTableAulas = new JTable(modelo);
        jButtonBuscar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jTextFieldAula = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Aulas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelAula.setFont(new java.awt.Font("Harrington", 0, 24));
        jLabelAula.setText("Aula");
        jPanelFondo.add(jLabelAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        /*
        jTableAulas.setModel(new javax.swing.table.DefaultTableModel(
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
        */
        jTableAulas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneLista.setViewportView(jTableAulas);

        jPanelFondo.add(jScrollPaneLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 520, 200));

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.jpg"))); // NOI18N
        jButtonBuscar.setBorderPainted(false);
        jButtonBuscar.setContentAreaFilled(false);
        jButtonBuscar.setFocusPainted(false);
        jButtonBuscar.setFocusable(false);
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanelFondo.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar2.jpg"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorderPainted(false);
        jButtonCancelar.setContentAreaFilled(false);
        jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(137, 99));
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
        jPanelFondo.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, 100));

        jButtonEditar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar1.jpg"))); // NOI18N
        jButtonEditar.setText("Habilitar / Deshabilitar");
        jButtonEditar.setBorderPainted(false);
        jButtonEditar.setContentAreaFilled(false);
        jButtonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEditar.setPreferredSize(new java.awt.Dimension(137, 99));
        jButtonEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        jButtonEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonEditarKeyPressed(evt);
            }
        });
        jPanelFondo.add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, 100));
        jPanelFondo.add(jTextFieldAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 170, 30));

        getContentPane().add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 480));

        pack();
    }//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        elegirAula();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonEditarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            elegirAula();
        else
            if(evt.getKeyCode()== KeyEvent.VK_RIGHT)
                jButtonCancelar.requestFocus();
    }//GEN-LAST:event_jButtonEditarKeyPressed

    private void jButtonCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCancelarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            dispose();
        else
            if(evt.getKeyCode()== KeyEvent.VK_LEFT)
                jButtonEditar.requestFocus();
    }//GEN-LAST:event_jButtonCancelarKeyPressed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        buscarAula();
    }//GEN-LAST:event_jButtonBuscarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JLabel jLabelAula;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPaneLista;
    private javax.swing.JTable jTableAulas;
    private javax.swing.JTextField jTextFieldAula;
    // End of variables declaration//GEN-END:variables

    public class MiModelo extends DefaultTableModel{
       @Override
       public boolean isCellEditable (int row, int column){
           // Aquí devolvemos true o false según queramos que una celda
           // identificada por fila,columna (row,column), sea o no editable
           //if (column == 3)
              //return true;
           return false;
       }
    }   
}
