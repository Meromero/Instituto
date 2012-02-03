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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public final class UsuarioBuscarActualizar extends javax.swing.JDialog {
    //DefaultTableModel modelo;
    MiModelo modelo;
    //boolean columnasIngresadas = false;

    public UsuarioBuscarActualizar() {
        inicializar();  //clase final
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

    public void elegirUsuario() throws NumberFormatException, HeadlessException {
        int fila, usuario;
        fila = jTableUsuarios.getSelectedRow();
        //System.out.println(fila);
        //System.out.println(String.valueOf(jTableEstudiantes.getValueAt(fila,0)));
        if (fila == -1)
            JOptionPane.showMessageDialog(null,"Error: Es necesario seleccionar un usuario","Busqueda de Usuario",JOptionPane.INFORMATION_MESSAGE) ;
        else{
            dispose();

            usuario = Integer.parseInt(String.valueOf(jTableUsuarios.getValueAt(fila,0)));
            UsuarioModificar editarusuario=new UsuarioModificar(usuario);
            //UsuarioVer ver = new UsuarioVer(usuario);
            editarusuario.setLocation(300,200);
            editarusuario.setVisible(true);
        }
    }

    public void inicializar(){    
        //Componentes
        jPanelFondo = new JPanel();
        jButtonBuscar = new JButton();
        jLabelNombreUsuario = new JLabel();
        jTextFieldBuscar = new JTextField();
        jTableUsuarios = new JTable();
        jButtonVer = new JButton();
        jButtonCancelar = new JButton();
        jScrollPaneLista = new JScrollPane();

        //Color del fondo
        jPanelFondo.setBackground(new Color(255, 255, 255));
        jButtonBuscar.setBackground(new Color(255, 255, 255));
        jLabelNombreUsuario.setBackground(new Color(255, 255, 255));
        jTextFieldBuscar.setBackground(new Color(255, 255, 255));
        jTableUsuarios.setBackground(new Color(255, 255, 255));
        jButtonVer.setBackground(new Color(255, 255, 255));
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

        jButtonVer.setBorder(null);
        jButtonVer.setBorderPainted(false);
        jButtonVer.setIcon(new ImageIcon(getClass().getResource("/Imagenes/editar1.jpg")));
        jButtonVer.setText("Elegir");
        jButtonVer.setHorizontalTextPosition(SwingConstants.CENTER);
        jButtonVer.setVerticalTextPosition(SwingConstants.BOTTOM);
        jButtonVer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonVerActionPerformed(evt);
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
                .addComponent(jButtonVer, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jButtonVer))
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
        jButtonVer = new javax.swing.JButton();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jScrollPaneLista = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Usuario");

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonVer.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar1.jpg"))); // NOI18N
        jButtonVer.setText("Elegir");
        jButtonVer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerActionPerformed(evt);
            }
        });
        jButtonVer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonVerKeyPressed(evt);
            }
        });
        jPanelFondo.add(jButtonVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 115, -1));

        jLabelNombreUsuario.setFont(new java.awt.Font("Harrington", 0, 24));
        jLabelNombreUsuario.setText("Usuario");
        jPanelFondo.add(jLabelNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

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

        jPanelFondo.add(jScrollPaneLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 723, 192));

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
        jPanelFondo.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

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
        jPanelFondo.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 86, 60));

        jTextFieldBuscar.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyPressed(evt);
            }
        });
        jPanelFondo.add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 268, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
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
                    + "Where (nombre like '"+buscar+"%' "
                    + "or apellidoPaterno like '"+buscar+"%' "
                    + "or apellidoMaterno like '"+buscar+"%') "
                    + "AND estado = '1'"); 
        } catch (SQLException ex) {
            Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
        
       limpiarTabla();
       modelo.addColumn("ID Usuario");
       modelo.addColumn("Nombre");
       modelo.addColumn("Apellido Paterno");
       modelo.addColumn("Apellido Materno");
       //modelo.addColumn("Estado");
      
        try {
            // Bucle para cada resultado en la consulta
            while (rs.next()){
               // Se crea un array que será una de las filas de la tabla.
               Object [] fila = new Object[4]; // Hay tres columnas en la tabla
               
               // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
               for (int i=0;i<4;i++)
                  //if (i!=3)
                      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                  /*else
                      if ("true".equals(String.valueOf(rs.getObject(17))))
                          fila[i] = "Activo";
                      else
                          fila[i] = "Inactivo";*/
               modelo.addRow(fila);      // Se añade al modelo la fila completa.
            }          
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar ingresar lo datos" + ex);
        }        
    }    
    
    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        buscarUsuario();         
}//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerActionPerformed
        elegirUsuario();
}//GEN-LAST:event_jButtonVerActionPerformed

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

    private void jButtonVerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonVerKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            elegirUsuario();
        else
            if(evt.getKeyCode()== KeyEvent.VK_RIGHT)
                jButtonCancelar.requestFocus();
    }//GEN-LAST:event_jButtonVerKeyPressed

    private void jButtonCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCancelarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            dispose();
        else
            if(evt.getKeyCode()== KeyEvent.VK_LEFT)
                jButtonVer.requestFocus();
    }//GEN-LAST:event_jButtonCancelarKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonVer;
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
