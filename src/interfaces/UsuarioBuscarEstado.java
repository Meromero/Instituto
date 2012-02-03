package interfaces;

import com.mysql.jdbc.ResultSet;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public final class UsuarioBuscarEstado extends javax.swing.JDialog {
    //DefaultTableModel modelo;
    MiModelo modelo;
    
    public UsuarioBuscarEstado() {
        inicializar();
        jTextFieldBuscar.requestFocus();
    }

    public void buscarUsuario() {
        try{
            String buscar = jTextFieldBuscar.getText();
            buscarEstudiantes(buscar);
        }
        catch(Exception e){
            
        }
    }

    public void editarEstado() throws NumberFormatException, HeadlessException {
        int fila, alumno;
        String sentencia, estado;
        fila = jTableUsuarios.getSelectedRow();
        if (fila == -1)
            JOptionPane.showMessageDialog(null,"Error: Es necesario seleccionar un usuario","Buscar Usuario",JOptionPane.INFORMATION_MESSAGE) ;
        else{
            alumno = Integer.parseInt(String.valueOf(jTableUsuarios.getValueAt(fila,0)));
            estado = String.valueOf(jTableUsuarios.getValueAt(fila,4));
            String buscar = jTextFieldBuscar.getText();

            GestorBD bd = new GestorBD(); 
            int idEstudiante = alumno;
            try {
                bd.getConnection();
                if ("Inactivo".equals(estado))
                    sentencia = "UPDATE `icba`.`empleado` SET `estado` = '1'"
                        + "WHERE `empleado`.`idEmpleado` = "+idEstudiante+";";
                else
                    sentencia = "UPDATE `icba`.`empleado` SET `estado` = '0'"
                        + "WHERE `empleado`.`idEmpleado` = "+idEstudiante+";";
                bd.modificarBD(sentencia);            
                bd.cerrar();             
            } catch (SQLException ex) {
                Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
            }     

            if ("Inactivo".equals(estado))
                JOptionPane.showMessageDialog(null,"Usuario habilitado exitosamente","Modificación de Estado",JOptionPane.INFORMATION_MESSAGE) ;
            else
                JOptionPane.showMessageDialog(null,"Usuario inhabilitado exitosamente","Modificación de Estado",JOptionPane.INFORMATION_MESSAGE) ;
            buscarEstudiantes(buscar);
        }
    }

    public void inicializar(){   
        //Componentes
        jPanelFondo = new javax.swing.JPanel();
        jButtonBuscar = new JButton();
        jLabelNombreUsuario = new JLabel();
        jTextFieldBuscar = new JTextField();
        jTableUsuarios = new javax.swing.JTable();
        jButtonEditar = new JButton();
        jButtonCancelar = new JButton();
        jScrollPaneLista = new JScrollPane();
        
        //Color del fondo
        jPanelFondo.setBackground(new Color(255, 255, 255));
        jButtonBuscar.setBackground(new Color(255, 255, 255));
        jLabelNombreUsuario.setBackground(new Color(255, 255, 255));
        jTextFieldBuscar.setBackground(new Color(255, 255, 255));
        jTableUsuarios.setBackground(new Color(255, 255, 255));
        jButtonEditar.setBackground(new Color(255, 255, 255));
        jButtonCancelar.setBackground(new Color(255, 255, 255));
        jScrollPaneLista.setBackground(new Color(255, 255, 255));
        
        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Buscar Usuario");

        jButtonBuscar.setBorder(null);
        jButtonBuscar.setBorderPainted(false);
        jButtonBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/buscar.jpg")));
        jButtonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonEditar.setBorder(null);
        jButtonEditar.setBorderPainted(false);
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar1.jpg"))); // NOI18N
        jButtonEditar.setText("Habilitar / Deshabilitar");
        jButtonEditar.setHorizontalTextPosition(SwingConstants.CENTER);
        jButtonEditar.setVerticalTextPosition(SwingConstants.BOTTOM);
        jButtonEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBorder(null);
        jButtonCancelar.setBorderPainted(false);
        jButtonCancelar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/cancelar2.jpg")));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
        jButtonCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
        jButtonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelNombreUsuario.setFont(new Font("Harrington", 0, 24));
        jLabelNombreUsuario.setText("Usuario");

        jTextFieldBuscar.setFont(new Font("Tahoma", 0, 18));      
        
        //modelo = new DefaultTableModel();
        modelo = new MiModelo();
        jTableUsuarios = new JTable(modelo);  
        
        jTableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jScrollPaneLista.setViewportView(jTableUsuarios);

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabelNombreUsuario)
                .addGap(36, 36, 36)
                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(238, 238, 238))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jScrollPaneLista, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombreUsuario))))
                .addGap(26, 26, 26)
                .addComponent(jScrollPaneLista, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonEditar))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanelFondo = new javax.swing.JPanel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jScrollPaneLista = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Usuario");

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombreUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNombreUsuario.setFont(new java.awt.Font("Harrington", 0, 24));
        jLabelNombreUsuario.setText("Usuario");
        jPanelFondo.add(jLabelNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jScrollPaneLista.setBackground(new java.awt.Color(255, 255, 255));

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneLista.setViewportView(jTableUsuarios);

        jPanelFondo.add(jScrollPaneLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 85, 723, 192));

        jButtonEditar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar1.jpg"))); // NOI18N
        jButtonEditar.setText("Habilitar / Deshabilitar");
        jButtonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        jPanelFondo.add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, 100));

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar2.jpg"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        jPanelFondo.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 140, -1));

        jButtonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.jpg"))); // NOI18N
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jButtonBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonBuscarKeyPressed(evt);
            }
        });
        jPanelFondo.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 70, 50));

        jTextFieldBuscar.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyPressed(evt);
            }
        });
        jPanelFondo.add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 250, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }//GEN-END:initComponents


    public void limpiarTabla(){
       modelo.setRowCount(0);
       modelo.setColumnCount(0);
    }
    
    public void buscarEstudiantes(String buscar){
        GestorBD bd = new GestorBD();
        bd.getConnection();
        ResultSet rs = null;
        try {
            rs = bd.consulta("Select * From `icba`.`empleado` "
                    + "Where nombre like '"+buscar+"%' "
                    + "or apellidoPaterno like '"+buscar+"%' "
                    + "or apellidoMaterno like '"+buscar+"%'"); 
        } catch (SQLException ex) {
            Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
        
       limpiarTabla();
       modelo.addColumn("ID Usuario");
       modelo.addColumn("Nombre");
       modelo.addColumn("Apellido Paterno");
       modelo.addColumn("Apellido Materno");
       modelo.addColumn("Estado");
      
        try {
            // Bucle para cada resultado en la consulta
            while (rs.next()){
               // Se crea un array que será una de las filas de la tabla.
               Object [] fila = new Object[5]; // Hay tres columnas en la tabla
               
               // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
               for (int i=0;i<5;i++)
                  if (i!=4)
                      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                  else
                      if ("true".equals(String.valueOf(rs.getObject(15))))
                          fila[i] = "Activo";
                      else
                          fila[i] = "Inactivo";
               modelo.addRow(fila);
            }          
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar ingresar lo datos" + ex);
        }        
    }
    
    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        buscarUsuario();
}//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        editarEstado();
}//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonBuscarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            buscarUsuario();
    }//GEN-LAST:event_jButtonBuscarKeyPressed

    private void jTextFieldBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyPressed
        buscarUsuario();
    }//GEN-LAST:event_jTextFieldBuscarKeyPressed

    private void jButtonEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonEditarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            editarEstado();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPaneLista;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTextFieldBuscar;
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