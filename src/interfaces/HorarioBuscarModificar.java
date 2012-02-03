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


public class HorarioBuscarModificar extends javax.swing.JDialog {
    MiModelo modelo;
    
    public HorarioBuscarModificar() {
        initComponents();
        buscarDia();
    }

    public void buscarDia() {
        try{
            String buscar = String.valueOf(jComboBoxDia.getSelectedItem());
            buscarHorarios(buscar);
        }
        catch(Exception e){
        }
    }
    
    //public void elegirHorario() throws NumberFormatException, HeadlessException {
    public void elegirHorario(){
        int fila, horario;
        fila = jTableHorarios.getSelectedRow();
        //System.out.println(fila);
        //System.out.println(String.valueOf(jTableEstudiantes.getValueAt(fila,0)));
        if (fila == -1)
            JOptionPane.showMessageDialog(null,"Error: Es necesario seleccionar un horario","Busqueda de Horario",JOptionPane.INFORMATION_MESSAGE) ;
        else{
            dispose();

            horario = Integer.parseInt(String.valueOf(jTableHorarios.getValueAt(fila,0))); 
            HorarioModificar modificar = new HorarioModificar(horario);
            modificar.setLocation(300,200);
            modificar.setVisible(true);
        }
    }
    
    public void limpiarTabla(){
       modelo.setRowCount(0);
       modelo.setColumnCount(0);
    }   

    public void buscarHorarios(String buscar){
        GestorBD bd = new GestorBD();
        bd.getConnection();
        ResultSet rs = null;
        try {
            rs = bd.consulta("Select * From `icba`.`horario` "
                    + "Where dia = '"+buscar+"' AND estado = '1' Order By horaInicio, horaFinal"); 
        } catch (SQLException ex) {
            Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
        
       limpiarTabla();
       modelo.addColumn("ID Horario");
       modelo.addColumn("Horario Inicial");
       modelo.addColumn("Horario Final");
       //modelo.addColumn("Apellido Materno");
       //modelo.addColumn("Estado");
      
        try {
            // Bucle para cada resultado en la consulta
            while (rs.next()){
               // Se crea un array que será una de las filas de la tabla.
               Object [] fila = new Object[3]; // Hay tres columnas en la tabla
               
               // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
               for (int i=0;i<3;i++)
                  if (i<1)
                      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                  else
                      fila[i] = rs.getObject(i+2);
                      /*if ("true".equals(String.valueOf(rs.getObject(17))))
                          fila[i] = "Activo";
                      else
                          fila[i] = "Inactivo";*/
               modelo.addRow(fila);      // Se añade al modelo la fila completa.
            }          
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar ingresar lo datos" + ex);
        }        
    }
    
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanelFondo = new javax.swing.JPanel();
        jComboBoxDia = new javax.swing.JComboBox();
        jLabelDia = new javax.swing.JLabel();
        jScrollPaneLista = new javax.swing.JScrollPane();
        modelo = new MiModelo();
        jTableHorarios = new JTable(modelo);
        jButton1 = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver Horarios");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" }));
        jComboBoxDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDiaActionPerformed(evt);
            }
        });
        jPanelFondo.add(jComboBoxDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 150, 30));

        jLabelDia.setFont(new java.awt.Font("Harrington", 0, 24));
        jLabelDia.setText("Día");
        jPanelFondo.add(jLabelDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        /*
        jTableHorarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableHorarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneLista.setViewportView(jTableHorarios);

        jPanelFondo.add(jScrollPaneLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 520, 200));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.jpg"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jPanelFondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar2.jpg"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorderPainted(false);
        jButtonCancelar.setContentAreaFilled(false);
        jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(73, 91));
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
        jPanelFondo.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 140, -1));

        jButtonEditar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar1.jpg"))); // NOI18N
        jButtonEditar.setText("Elegir");
        jButtonEditar.setBorderPainted(false);
        jButtonEditar.setContentAreaFilled(false);
        jButtonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEditar.setPreferredSize(new java.awt.Dimension(73, 91));
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
        jPanelFondo.add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 140, -1));

        getContentPane().add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 470));

        pack();
    }//GEN-END:initComponents

    private void jComboBoxDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDiaActionPerformed
        buscarDia();
    }//GEN-LAST:event_jComboBoxDiaActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        elegirHorario();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonEditarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            elegirHorario();
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JComboBox jComboBoxDia;
    private javax.swing.JLabel jLabelDia;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPaneLista;
    private javax.swing.JTable jTableHorarios;
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
