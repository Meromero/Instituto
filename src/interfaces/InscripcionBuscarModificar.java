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


public class InscripcionBuscarModificar extends javax.swing.JDialog {
    MiModelo modelo;
    GestorBD bd;

    int idEstudiante;
    int idModulo;
    
    public InscripcionBuscarModificar() {
        initComponents();
        buscarInscripcion();
    }

    public void cerrarVentana() {
        try {
            bd.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }
    
    public void buscarInscripcion() {
        try{
            String buscar = jTextFieldAula.getText();
            buscarInscripciones(buscar);
        }
        catch(Exception e){
        }
    }
    
    public void elegirInscripcion(){
        int fila, inscripcion;
        fila = jTableInscripciones.getSelectedRow();

        if (fila == -1)
            JOptionPane.showMessageDialog(null,"Error: Es necesario seleccionar una inscripción","Busqueda de Inscripciones",JOptionPane.INFORMATION_MESSAGE) ;
        else{
            dispose();

            inscripcion = Integer.parseInt(String.valueOf(jTableInscripciones.getValueAt(fila,0))); 
            AulaModificar modificar = new AulaModificar(inscripcion);
            modificar.setLocation(300,200);
            modificar.setVisible(true);
        }
    }
    
    public void limpiarTabla(){
       modelo.setRowCount(0);
       modelo.setColumnCount(0);
    }   

    public void buscarInscripciones(String buscar){
        GestorBD bd = new GestorBD();
        bd.getConnection();
        ResultSet rs = null;
        try {
            if ("estudiantes".equals(buscar))
                rs = bd.consulta("Select * From `icba`.`inscripcion` WHERE idEstudiante = " + idEstudiante); // like '%"+buscar+"%') AND estado = '1' Order By sigla"); 
        } catch (SQLException ex) {
            Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
        
       limpiarTabla();
       
       
       //modelo.addColumn("Apellido Materno");
       //modelo.addColumn("Estado");
      
        try {
            if ("estudiantes".equals(buscar)){
                modelo.addColumn("Id Inscripcion");
                modelo.addColumn("Id Estudiante");
                modelo.addColumn("Id Asignación");
            }
                
            // Bucle para cada resultado en la consulta
            while (rs.next()){
               // Se crea un array que será una de las filas de la tabla.
               Object [] fila = new Object[3]; // Hay tres columnas en la tabla
               
               // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
               for (int i=0;i<3;i++)
                  //if (i<1)
                      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                  //else
                  //    fila[i] = rs.getObject(i+2);
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
        jLabelAula = new javax.swing.JLabel();
        jScrollPaneLista = new javax.swing.JScrollPane();
        modelo = new MiModelo();
        jTableInscripciones = new JTable(modelo);
        jButtonBuscar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jTextFieldAula = new javax.swing.JTextField();
        jButtonBuscarModulo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonBuscarEstudiante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Inscripciones");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setPreferredSize(new java.awt.Dimension(570, 431));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelAula.setFont(new java.awt.Font("Harrington", 0, 24));
        jLabelAula.setText("ó");
        jPanelFondo.add(jLabelAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        /*
        jTableInscripciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableInscripciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneLista.setViewportView(jTableInscripciones);

        jPanelFondo.add(jScrollPaneLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 520, 200));

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
        jPanelFondo.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

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
        jPanelFondo.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 140, -1));

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
        jPanelFondo.add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 140, -1));

        jTextFieldAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAulaActionPerformed(evt);
            }
        });
        jPanelFondo.add(jTextFieldAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 50, 30));

        jButtonBuscarModulo.setText("Modulos");
        jPanelFondo.add(jButtonBuscarModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 90, -1));

        jLabel2.setText("Realizar búsqueda por ");
        jPanelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jButtonBuscarEstudiante.setText("Estudiantes");
        jButtonBuscarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarEstudianteActionPerformed(evt);
            }
        });
        jPanelFondo.add(jButtonBuscarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        getContentPane().add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 470));

        pack();
    }//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        elegirInscripcion();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonEditarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            elegirInscripcion();
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
        buscarInscripcion();
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTextFieldAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAulaActionPerformed

    private void jButtonBuscarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarEstudianteActionPerformed
        InscripcionBuscarEstudiante buscar = new InscripcionBuscarEstudiante();
        buscar.setModal(true);
        buscar.setVisible(true); 
       
        idEstudiante = buscar.alumno;
        buscarInscripciones("estudiantes");
    }//GEN-LAST:event_jButtonBuscarEstudianteActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonBuscarEstudiante;
    private javax.swing.JButton jButtonBuscarModulo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAula;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPaneLista;
    private javax.swing.JTable jTableInscripciones;
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
