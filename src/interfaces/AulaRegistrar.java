package interfaces;

import com.mysql.jdbc.ResultSet;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AulaRegistrar extends javax.swing.JDialog {
    GestorBD bd;
    
    public AulaRegistrar() {
        initComponents();
        
        limitarTams();
        bd = new GestorBD();
        bd.getConnection();
        
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
        jButtonRegistrar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Aula");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Aula"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDescripcion.setText("Descripción");
        jPanel2.add(jLabelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jTextFieldSigla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSiglaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSiglaKeyTyped(evt);
            }
        });
        jPanel2.add(jTextFieldSigla, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 270, -1));

        jLabelSigla.setText("Sigla");
        jPanel2.add(jLabelSigla, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabelCapacidad.setText("Capacidad");
        jPanel2.add(jLabelCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jTextFieldCapacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCapacidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCapacidadKeyTyped(evt);
            }
        });
        jPanel2.add(jTextFieldCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 270, -1));

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jTextAreaDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextAreaDescripcionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaDescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaDescripcion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 270, 160));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 450, 370));

        jButtonRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar1.JPG"))); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setBorderPainted(false);
        jButtonRegistrar.setContentAreaFilled(false);
        jButtonRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistrar.setMaximumSize(new java.awt.Dimension(107, 101));
        jButtonRegistrar.setMinimumSize(new java.awt.Dimension(107, 101));
        jButtonRegistrar.setPreferredSize(new java.awt.Dimension(107, 101));
        jButtonRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        jButtonRegistrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonRegistrarKeyPressed(evt);
            }
        });
        jPanel1.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 170, 100));

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

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        guardarBaseDatos();
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonRegistrarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            guardarBaseDatos();
        else
            if(evt.getKeyCode()== KeyEvent.VK_RIGHT)
                jButtonCancelar.requestFocus();
    }//GEN-LAST:event_jButtonRegistrarKeyPressed

    private void jButtonCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCancelarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            cerrarVentana();
        else
            if(evt.getKeyCode()== KeyEvent.VK_LEFT)
                jButtonRegistrar.requestFocus();
    }//GEN-LAST:event_jButtonCancelarKeyPressed

    private void jTextFieldSiglaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSiglaKeyTyped
        validarSigla(evt);
    }//GEN-LAST:event_jTextFieldSiglaKeyTyped

    private void jTextFieldSiglaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSiglaKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldCapacidad.requestFocus();
    }//GEN-LAST:event_jTextFieldSiglaKeyPressed

    private void jTextFieldCapacidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCapacidadKeyTyped
        validarCapacidad(evt);
    }//GEN-LAST:event_jTextFieldCapacidadKeyTyped

    private void jTextFieldCapacidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCapacidadKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextAreaDescripcion.requestFocus();
    }//GEN-LAST:event_jTextFieldCapacidadKeyPressed

    private void jTextAreaDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaDescripcionKeyTyped
        validarDescripcion(evt);
    }//GEN-LAST:event_jTextAreaDescripcionKeyTyped

    private void jTextAreaDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaDescripcionKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jButtonRegistrar.requestFocus();
    }//GEN-LAST:event_jTextAreaDescripcionKeyPressed

   public void validarSigla(KeyEvent evt){
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && ((caracter < 'A') || (caracter > 'Z'))
                && (caracter != KeyEvent.VK_BACK_SPACE))
              evt.setKeyChar((char)KeyEvent.VK_CLEAR);
    }
 
    public void validarCapacidad(KeyEvent evt){
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE))
              evt.setKeyChar((char)KeyEvent.VK_CLEAR);
    }
    
    public void validarDescripcion(KeyEvent evt){
        char caracter = evt.getKeyChar();

        if( ((caracter < 'A') || (caracter > 'Z'))&&
                ((caracter < 'a') || (caracter > 'z'))&&
                ((caracter != 'á') && (caracter != 'é') && (caracter != 'í') 
                && (caracter != 'ó') && (caracter != 'ú') && (caracter != 'ñ') && (caracter != 'Ñ') 
                && (caracter != 'Á') && (caracter != 'É') && (caracter != 'Í') 
                && (caracter != 'Ó') && (caracter != 'Ú'))&&
                
                ((caracter != '#') && (caracter != '.') && (caracter != '-') && (caracter != '(') 
                && (caracter != ')') && (caracter != ',')) &&
                
                ((caracter < '0') || (caracter > '9')) &&
                (caracter != ' '))
            evt.setKeyChar((char)KeyEvent.VK_CLEAR); 
    }
      
    public void limitarTams(){ 
        jTextFieldSigla.setDocument(new JTextFieldLimit(5));
        jTextFieldCapacidad.setDocument(new JTextFieldLimit(2));
        jTextAreaDescripcion.setDocument(new JTextFieldLimit(50));
    }
        
    public int contarRegistros(){
        String sentencia = "Select Count(*) From `icba`.`aula`";
        ResultSet rs = null;
        try {
            rs = bd.consulta(sentencia);
            rs.next();
            int cantidad = rs.getInt(1);
            return cantidad;           
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean verificarCamposObligatorios(String nombre,String capacidad, String descripcion){
        if ("".equals(nombre) || "".equals(capacidad) || "".equals(descripcion))
            return true;
        return false;
    }
    
    public boolean verificarPosibleRepeticion(String sigla){
        String sentencia = "Select * From `icba`.`aula` Where sigla = '"+sigla+"'";
        ResultSet rs = null;
        try {
            rs = bd.consulta(sentencia);
            if (rs.next())
                return true;                
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void guardarBaseDatos() throws HeadlessException {
        boolean repetido, datosIngresados;
        int registrosIni, registrosFin;
        
        String sigla = jTextFieldSigla.getText();
        String capacidad = jTextFieldCapacidad.getText();
        String descripcion = jTextAreaDescripcion.getText();
        
        System.out.println(sigla);
        System.out.println(capacidad);
        System.out.println(descripcion);

        try {           
            registrosIni = contarRegistros();  
            repetido = verificarPosibleRepeticion(sigla); 
            
            datosIngresados = verificarCamposObligatorios(sigla, capacidad, descripcion);   

            if (repetido){
                JOptionPane.showMessageDialog(null,"Error al registrar: El aula ya se encuentra registrada en la base de datos","Registro de Aula",JOptionPane.INFORMATION_MESSAGE) ;
                jTextFieldSigla.requestFocus();
            }
            else if (datosIngresados){
                JOptionPane.showMessageDialog(null,"Error al registrar: No se han ingreasado todos los campos obligatorios","Registro de Aula",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldSigla.requestFocus();
            }      
            else{
                String sentencia = "INSERT INTO `icba`.`aula` (`sigla` ,`capacidad` ,`equipo`) "
                        + "VALUES ('"+sigla+"', '"+capacidad+"', '"+descripcion+"')";
                bd.modificarBD(sentencia);
                
                registrosFin = contarRegistros();
                
                if (registrosIni != registrosFin){
                    JOptionPane.showMessageDialog(null,"Aula registrada exitosamente","Registro de Aula",JOptionPane.INFORMATION_MESSAGE) ;
                    bd.cerrar();
                    dispose();
                }
                else
                    JOptionPane.showMessageDialog(null,"Hubo un error al intentar ingresar los datos","Registro de Aula",JOptionPane.INFORMATION_MESSAGE) ;           
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Hubo un error al intentar ingresar los datos","Registro de Aula",JOptionPane.INFORMATION_MESSAGE) ;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonRegistrar;
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
