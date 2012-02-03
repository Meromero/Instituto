package interfaces;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.*;


public final class EstudianteBuscarVer extends javax.swing.JDialog {
    //DefaultTableModel modelo;
    MiModelo modelo;
    //boolean columnasIngresadas = false;

    public EstudianteBuscarVer() {
        inicializar();  //clase final
        jTextFieldBuscar.requestFocus();
    }

    public void buscarEstudiante() {
        try{
            String buscar = jTextFieldBuscar.getText();
            //if (!"".equals(estudiante))
                buscarEstudiantes(buscar);
        }
        catch(Exception e){
            
        }
    }

    public void elegirEstudiante() throws NumberFormatException, HeadlessException {
        int fila, alumno;
        fila = jTableEstudiantes.getSelectedRow();
        //System.out.println(fila);
        //System.out.println(String.valueOf(jTableEstudiantes.getValueAt(fila,0)));
        if (fila == -1)
            JOptionPane.showMessageDialog(null,"Error: Es necesario seleccionar un estudiante","Busqueda de Estudiante",JOptionPane.INFORMATION_MESSAGE) ;
        else{
            dispose();

            alumno = Integer.parseInt(String.valueOf(jTableEstudiantes.getValueAt(fila,0))); 
            EstudianteVer ver = new EstudianteVer(alumno);
            ver.setLocation(300,0);
            ver.setVisible(true);
        }
    }

    public void inicializar(){    
        //Componentes
        jPanelFondo = new JPanel();
        jButtonBuscar = new JButton();
        jLabelNombreEstudiante = new JLabel();
        jTextFieldBuscar = new JTextField();
        jTableEstudiantes = new JTable();
        jButtonVer = new JButton();
        jButtonCancelar = new JButton();
        jButtonReporte = new JButton();
        jScrollPaneLista = new JScrollPane();

        //Color del fondo
        jPanelFondo.setBackground(new Color(255, 255, 255));
        jButtonBuscar.setBackground(new Color(255, 255, 255));
        jLabelNombreEstudiante.setBackground(new Color(255, 255, 255));
        jTextFieldBuscar.setBackground(new Color(255, 255, 255));
        jTableEstudiantes.setBackground(new Color(255, 255, 255));
        jButtonVer.setBackground(new Color(255, 255, 255));
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
        
        jLabelNombreEstudiante.setFont(new Font("Harrington", 0, 24));
        jLabelNombreEstudiante.setText("Estudiante");

        jTextFieldBuscar.setFont(new Font("Tahoma", 0, 18));
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            /*public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyPressed(evt);
            }*/
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });
        jPanelFondo.add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 268, -1));

        
        jButtonReporte.setText("Reporte");
        jButtonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteActionPerformed(evt);
            }
        });
        jPanelFondo.add(jButtonReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, -1, -1));
        
        
        
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
                .addComponent(jButtonVer, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(238, 238, 238)
                .addComponent(jButtonReporte))
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
                    .addComponent(jButtonVer)
                    .addComponent(jButtonReporte))
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
        jLabelNombreEstudiante = new javax.swing.JLabel();
        jScrollPaneLista = new javax.swing.JScrollPane();
        jTableEstudiantes = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Estudiante");

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

        jLabelNombreEstudiante.setFont(new java.awt.Font("Harrington", 0, 24));
        jLabelNombreEstudiante.setText("Estudiante");
        jPanelFondo.add(jLabelNombreEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });
        jPanelFondo.add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 268, -1));

        jButtonReporte.setText("Reporte");
        jButtonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteActionPerformed(evt);
            }
        });
        jPanelFondo.add(jButtonReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, -1, -1));

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
            rs = bd.consulta("Select * From `icba`.`estudiante` "
                    + "Where (nombre like '%"+buscar+"%' "
                    + "or apellidoPaterno like '%"+buscar+"%' "
                    + "or apellidoMaterno like '%"+buscar+"%') "
                    + "AND estado = '1'"); 
        } catch (SQLException ex) {
            Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
        
       limpiarTabla();
       modelo.addColumn("ID Estudiante");
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
        buscarEstudiante();
}//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerActionPerformed
        elegirEstudiante();
}//GEN-LAST:event_jButtonVerActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonBuscarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            buscarEstudiante();
    }//GEN-LAST:event_jButtonBuscarKeyPressed

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            buscarEstudiante();
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    private void jButtonVerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonVerKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            elegirEstudiante();
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

    private void jButtonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteActionPerformed
        GestorBD bd = new GestorBD();
        //bd.getConnection();
        Connection conn = bd.getConnection();
        try{
            Map parameters = new HashMap();
            parameters.put("Estudiantes", "ID");
            parameters.put("FECHA", new java.util.Date());
      
      
            JasperReport report = JasperCompileManager.compileReport("C:\\Users\\danrocar\\Desktop\\Reportes\\report1.jrxml");
                  //+ "C:\\informes JAsper\\JRXML\\InformeMySql.jrxml");
            //JasperPrint print = JasperFillManager.fillReport
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
          // Exporta el informe a PDF
            JasperExportManager.exportReportToPdfFile(print,
              "C:\\Users\\danrocar\\Desktop\\Reportes\\InformeEstudiantesMySQL.pdf");
          //Para visualizar el pdf directamente desde java
            JasperViewer.viewReport(print, false);          
        }
        catch(Exception e){
            e.printStackTrace();
        }
      
        /*finally {
        //Cleanup antes de salir
          try {
            if (conn != null) {
              conn.rollback();
              System.out.println("ROLLBACK EJECUTADO");
              conn.close();
            }
          }
          catch (Exception e) {
            e.printStackTrace();
          }
      }*/
    }//GEN-LAST:event_jButtonReporteActionPerformed

    /*static void inicializaLogger(){
        PatternLayout pat = new PatternLayout("[%-5p][%t] (%F:%L) : %m%n");
        Logger.getRootLogger().addAppender(new ConsoleAppender(pat));
        Logger.getRootLogger().setLevel(Level.DEBUG);
    }*/
   
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonReporte;
    private javax.swing.JButton jButtonVer;
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
