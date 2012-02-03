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


public final class EstudianteBuscarActualizar extends javax.swing.JDialog {   
    //DefaultTableModel modelo;
    MiModelo modelo;

    public EstudianteBuscarActualizar() {
        inicializar();
        //initComponents();
        jTextFieldBuscar.requestFocus();
    }

    public void buscarEstudiante() {
        try{
            String buscar = jTextFieldBuscar.getText();
            buscarEstudiantes(buscar);
        }
        catch(Exception e){
            
        }
    }

    public void elegirEstudiante() throws NumberFormatException, HeadlessException {
        int fila, alumno;
        fila = jTableEstudiantes.getSelectedRow();
        if (fila == -1)
            JOptionPane.showMessageDialog(null,"Error: Es necesario seleccionar un estudiante","Registro",JOptionPane.INFORMATION_MESSAGE) ;
        else{
        
            //System.out.println(fila);
            //System.out.println(String.valueOf(jTableEstudiantes.getValueAt(fila,0)));
            dispose();

            alumno = Integer.parseInt(String.valueOf(jTableEstudiantes.getValueAt(fila,0))); 
            EstudianteModificar editarestudiante=new EstudianteModificar(alumno);
            editarestudiante.setLocation(300,0);
            editarestudiante.setVisible(true);
        }
    }

    public void inicializar(){ 
        //Componentes
        jPanelFondo = new JPanel();
        jButtonBuscar = new JButton();
        jLabelNombreEstudiante = new JLabel();
        jTextFieldBuscar = new JTextField();
        jTableEstudiantes = new JTable();
        jButtonEditar = new JButton();
        jButtonCancelar = new JButton();
        jScrollPaneLista = new JScrollPane();
        
        
        //Color del fondo
        jPanelFondo.setBackground(new Color(255, 255, 255));
        jButtonBuscar.setBackground(new Color(255, 255, 255));
        jLabelNombreEstudiante.setBackground(new Color(255, 255, 255));
        jTextFieldBuscar.setBackground(new Color(255, 255, 255));
        jTableEstudiantes.setBackground(new Color(255, 255, 255));
        jButtonEditar.setBackground(new Color(255, 255, 255));
        jButtonCancelar.setBackground(new Color(255, 255, 255));
        jScrollPaneLista.setBackground(new Color(255, 255, 255));

        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Buscar Estudiante");
              
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
        jButtonEditar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/editar1.jpg")));
        jButtonEditar.setText("Elegir");
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
               
        jLabelNombreEstudiante.setFont(new Font("Harrington", 0, 24));
        jLabelNombreEstudiante.setText("Estudiante");

        jTextFieldBuscar.setFont(new Font("Tahoma", 0, 18));

        //modelo = new DefaultTableModel();
        modelo = new MiModelo();
        jTableEstudiantes = new JTable(modelo); 
        
        jTableEstudiantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        jScrollPaneLista.setViewportView(jTableEstudiantes);

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabelNombreEstudiante)
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
                            .addComponent(jLabelNombreEstudiante))))
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
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jScrollPaneLista = new javax.swing.JScrollPane();
        jTableEstudiantes = new javax.swing.JTable();
        jLabelNombreEstudiante = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Estudiante");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.jpg"))); // NOI18N
        jButtonBuscar.setBorder(null);
        jButtonBuscar.setBorderPainted(false);
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
        jPanelFondo.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 19, 86, 62));

        jTextFieldBuscar.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });
        jPanelFondo.add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 39, 268, -1));

        jScrollPaneLista.setBackground(new java.awt.Color(255, 255, 255));

        jTableEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneLista.setViewportView(jTableEstudiantes);

        jPanelFondo.add(jScrollPaneLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 107, 723, 192));

        jLabelNombreEstudiante.setFont(new java.awt.Font("Harrington", 0, 24));
        jLabelNombreEstudiante.setText("Estudiante");
        jPanelFondo.add(jLabelNombreEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 35, -1, -1));

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar2.jpg"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorder(null);
        jButtonCancelar.setBorderPainted(false);
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
        jPanelFondo.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 317, -1, -1));

        jButtonEditar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar1.jpg"))); // NOI18N
        jButtonEditar.setText("Elegir");
        jButtonEditar.setBorder(null);
        jButtonEditar.setBorderPainted(false);
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
        jPanelFondo.add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 317, 115, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            rs = bd.consulta("Select * From `icba`.`estudiante` "
                    + "Where (nombre like '"+buscar+"%' "
                    + "or apellidoPaterno like '"+buscar+"%' "
                    + "or apellidoMaterno like '"+buscar+"%') "
                    + "AND estado = '1'"); 
        } catch (SQLException ex) {
            Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
        
       limpiarTabla();
       modelo.addColumn("ID Estudiante");
       modelo.addColumn("Nombre");
       modelo.addColumn("Apellido Paterno");
       modelo.addColumn("Apellido Materno");
       modelo.isCellEditable(0, 0);
       
        try {
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
        buscarEstudiante();
}//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        elegirEstudiante();
}//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonBuscarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            buscarEstudiante();
    }//GEN-LAST:event_jButtonBuscarKeyPressed

    private void jTextFieldBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            buscarEstudiante();
        //buscarEstudiante();
    }//GEN-LAST:event_jTextFieldBuscarKeyPressed

    private void jButtonEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonEditarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            elegirEstudiante();
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

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        buscarEstudiante();
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JLabel jLabelNombreEstudiante;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPaneLista;
    private javax.swing.JTable jTableEstudiantes;
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

