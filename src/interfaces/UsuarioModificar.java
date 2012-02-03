package interfaces;

import com.mysql.jdbc.ResultSet;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class UsuarioModificar extends javax.swing.JDialog {  
    int id;
    String carnet;
    GestorBD bd;
    
    public UsuarioModificar(int fila) {
        id = fila;
        int idEstudiante = fila;
        
        initComponents();
        limitarTams();
        bd = new GestorBD();
                
        try {
            bd.getConnection();
            ResultSet rs = bd.consulta("SELECT * FROM `icba`.`empleado` WHERE idEmpleado = "+idEstudiante);
            while (rs.next()){
            String nombre = rs.getString("nombre");
            jTextFieldNombre.setText(nombre);
            
            String apellidoPaterno = rs.getString("apellidoPaterno");
            jTextFieldApellidoPaterno.setText(apellidoPaterno);
            
            String apellidoMaterno = rs.getString("apellidoMaterno");
            jTextFieldApellidoMaterno.setText(apellidoMaterno);
            
            String ci = rs.getString("ci");
            carnet = ci;
            jTextFieldCI.setText(ci);
            
            Date fechaNacimiento = rs.getDate("fechaNacimiento");
            jCalendarFechaNacimiento.setDate(fechaNacimiento);
            
            String lugarNacimiento = rs.getString("lugarNacimiento");
            jTextFieldLugarNacimiento.setText(lugarNacimiento);
            
            String telefono = rs.getString("telefono");
            jTextFieldTelefono.setText(telefono);
            
            String celular = rs.getString("celular");
            jTextFieldCelular.setText(celular);
            
            String direccion = rs.getString("direccion");
            jTextFieldDireccion.setText(direccion);
            
            String email = rs.getString("email");
            jTextFieldEmail.setText(email);

            String tipoUsuario = rs.getString("tipoUsuario");
            jComboBoxTipoUsuario.setSelectedIndex(Integer.parseInt(tipoUsuario)-1);

            String login = rs.getString("login");
            jTextFieldLogin.setText(login);
            
            String password = rs.getString("password");
            jPasswordFieldPassword.setText(password);
            jPasswordFieldRetypePassword.setText(password);
            }
            rs.close();        
                  
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al hacer la consulta a la BD" + ex);
        }
        
    }

    public void cerrarVentana() {
        try {
            bd.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioModificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }

    public void guardarBaseDatos() throws HeadlessException {
        boolean repetido, incorrectoPass, loginRepetido, datosIngresados, camposLogin;
        int idEstudiante = id;
        try {
            String nombre = jTextFieldNombre.getText();
            String apellidoPaterno = jTextFieldApellidoPaterno.getText();
            String apellidoMaterno = jTextFieldApellidoMaterno.getText();
            String ci = jTextFieldCI.getText();
            
            
            Date dateNacimiento = jCalendarFechaNacimiento.getDate(); 
            String ano = Integer.toString(dateNacimiento.getYear()+1900);
            String mes = Integer.toString(dateNacimiento.getMonth()+1);
            String dia = Integer.toString(dateNacimiento.getDate());
            String fechaNacimiento = ano + "-" + mes + "-" + dia;
        
            String lugarNacimiento = jTextFieldLugarNacimiento.getText();
            String telefono = jTextFieldTelefono.getText();
            String celular = jTextFieldCelular.getText();
            String direccion = jTextFieldDireccion.getText();
            String email = jTextFieldEmail.getText();
              
            String tipoUsuario = String.valueOf(jComboBoxTipoUsuario.getSelectedIndex()+1);
        
            String login = jTextFieldLogin.getText();
            String password = jPasswordFieldPassword.getText();     
            String repassword = jPasswordFieldRetypePassword.getText(); 
            
            incorrectoPass = false;
            incorrectoPass = verificarRetypePassword(password, repassword);
            
            repetido = false; 
            repetido = verificarPosibleRepeticion(ci);
            
            loginRepetido = verificarLogin(login);
            
            datosIngresados = verificarCamposObligatorios(nombre, apellidoPaterno, apellidoMaterno, ci);
            
            camposLogin = verificarCamposLogin(login, password, repassword);
            
            if (repetido){
                JOptionPane.showMessageDialog(null,"Error al actualizar: El usuario ya se encuentra registrado en la base de datos","Actualizacion de Datos de Usuario",JOptionPane.INFORMATION_MESSAGE) ;
                jTextFieldCI.setText(carnet);
            }
            else if (incorrectoPass){
                JOptionPane.showMessageDialog(null,"Error al actualizar: Las contraseñas introducidas no coiciden, vuelva a intentarlo","Actualizacion de Datos de Usuario",JOptionPane.INFORMATION_MESSAGE) ;   
                jPasswordFieldPassword.requestFocus();
            }
            else if (loginRepetido){
                JOptionPane.showMessageDialog(null,"Error al actualizar: El login ya se encuentra registrado en la base de datos","Actualizacion de Datos de Usuario",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldLogin.requestFocus();
            }
            else if (datosIngresados){
                JOptionPane.showMessageDialog(null,"Error al actualizar: No se han ingreasado todos los campos obligatorios","Actualizacion de Datos de Usuario",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldNombre.requestFocus();
            }  
           else if (camposLogin){
                JOptionPane.showMessageDialog(null,"Error al actualizar: No se han ingreasado todos los campos de usuario (login y passwords)","Actualizacion de Datos de Usuario",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldLogin.requestFocus();
            }             
            else{
                String sentencia = "UPDATE `icba`.`empleado` SET `nombre` = '"+nombre+"',"
                        + "`apellidoPaterno` = '"+apellidoPaterno+"',"
                        + "`apellidoMaterno` = '"+apellidoMaterno+"',"
                        + "`ci` = '"+ci+"',"
                        + "`telefono` = '"+telefono+"',"
                        + "`celular` = '"+celular+"',"
                        + "`direccion` = '"+direccion+"',"
                        + "`email` = '"+email+"',"
                        + "`fechaNacimiento` = '"+fechaNacimiento+"',"
                        + "`lugarNacimiento` = '"+lugarNacimiento+"',"
                        + "`tipoUsuario` = '"+tipoUsuario+"',"
                        + "`login` = '"+login+"',"
                        + "`password` = '"+password+"' "                        
                        
                        + "WHERE `empleado`.`idEmpleado` = "+idEstudiante+";";    
                
                bd.modificarBD(sentencia);            
                
                JOptionPane.showMessageDialog(null,"Los datos del usuario fueron actualizados exitosamente","Actualizacion de Datos de Usuario",JOptionPane.INFORMATION_MESSAGE) ;
                bd.cerrar();
                dispose();
            }
            
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar actualizar lo datos" + ex);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanelDatosPersonales = new javax.swing.JPanel();
        jLabelCI = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidoMaterno = new javax.swing.JLabel();
        jLabelFechaNacimiento = new javax.swing.JLabel();
        jLabelLugarNacimiento = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldCI = new javax.swing.JTextField();
        jTextFieldLugarNacimiento = new javax.swing.JTextField();
        jCalendarFechaNacimiento = new com.toedter.calendar.JCalendar();
        jTextFieldApellidoMaterno = new javax.swing.JTextField();
        jLabelApellidoPaterno = new javax.swing.JLabel();
        jTextFieldApellidoPaterno = new javax.swing.JTextField();
        jPanelDatosContacto = new javax.swing.JPanel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelCelularEstudiante = new javax.swing.JLabel();
        jLabelTelefonoEstudiante = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldCelular = new javax.swing.JTextField();
        jPanelDatosUsuario = new javax.swing.JPanel();
        jLabelMensajeMotivo = new javax.swing.JLabel();
        jLabelMensajeViaje = new javax.swing.JLabel();
        jLabelAlemaniaMotivo = new javax.swing.JLabel();
        jLabelMotivoEstudios = new javax.swing.JLabel();
        jComboBoxTipoUsuario = new javax.swing.JComboBox();
        jTextFieldLogin = new javax.swing.JTextField();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jPasswordFieldRetypePassword = new javax.swing.JPasswordField();
        jPanelBotones = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar Datos de Usuario");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));
        jPanelDatosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCI.setText("C.I. o Pasaporte");
        jPanelDatosPersonales.add(jLabelCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 19));

        jLabelNombre.setText("Nombre");
        jPanelDatosPersonales.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabelApellidoMaterno.setText("Apellido Materno");
        jPanelDatosPersonales.add(jLabelApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabelFechaNacimiento.setText("Fecha de Nacimiento");
        jPanelDatosPersonales.add(jLabelFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        jLabelLugarNacimiento.setText("Lugar de Nacimiento");
        jPanelDatosPersonales.add(jLabelLugarNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyTyped(evt);
            }
        });
        jPanelDatosPersonales.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 220, -1));

        jTextFieldCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCIKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCIKeyTyped(evt);
            }
        });
        jPanelDatosPersonales.add(jTextFieldCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 220, -1));

        jTextFieldLugarNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldLugarNacimientoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLugarNacimientoKeyTyped(evt);
            }
        });
        jPanelDatosPersonales.add(jTextFieldLugarNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 220, -1));
        jPanelDatosPersonales.add(jCalendarFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jTextFieldApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoMaternoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoMaternoKeyTyped(evt);
            }
        });
        jPanelDatosPersonales.add(jTextFieldApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 220, -1));

        jLabelApellidoPaterno.setText("Apellido Paterno");
        jPanelDatosPersonales.add(jLabelApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jTextFieldApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoPaternoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoPaternoKeyTyped(evt);
            }
        });
        jPanelDatosPersonales.add(jTextFieldApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 220, -1));

        getContentPane().add(jPanelDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 640, 200));

        jPanelDatosContacto.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Contacto"));
        jPanelDatosContacto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDireccion.setText("Dirección");
        jPanelDatosContacto.add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, 30));

        jLabelEmail.setText("E-mail");
        jPanelDatosContacto.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 54, -1, 30));

        jLabelCelularEstudiante.setText("Celular");
        jPanelDatosContacto.add(jLabelCelularEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

        jLabelTelefonoEstudiante.setText("Teléfono");
        jPanelDatosContacto.add(jLabelTelefonoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jTextFieldDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDireccionKeyTyped(evt);
            }
        });
        jPanelDatosContacto.add(jTextFieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 220, -1));

        jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldEmailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEmailKeyTyped(evt);
            }
        });
        jPanelDatosContacto.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 220, -1));
        jPanelDatosContacto.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 72, 30, 30));

        jTextFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoKeyTyped(evt);
            }
        });
        jPanelDatosContacto.add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 90, -1));

        jTextFieldCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCelularKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCelularKeyTyped(evt);
            }
        });
        jPanelDatosContacto.add(jTextFieldCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 90, -1));

        getContentPane().add(jPanelDatosContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 640, -1));

        jPanelDatosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Usuario"));
        jPanelDatosUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMensajeMotivo.setText("Nombre de Usuario");
        jPanelDatosUsuario.add(jLabelMensajeMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabelMensajeViaje.setText("Repetir Contraseña");
        jPanelDatosUsuario.add(jLabelMensajeViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabelAlemaniaMotivo.setText("Tipo");
        jPanelDatosUsuario.add(jLabelAlemaniaMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jLabelMotivoEstudios.setText("Contraseña");
        jPanelDatosUsuario.add(jLabelMotivoEstudios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 20));

        jComboBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Profesor", "Secretaria", "Director" }));
        jComboBoxTipoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxTipoUsuarioKeyPressed(evt);
            }
        });
        jPanelDatosUsuario.add(jComboBoxTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 220, -1));

        jTextFieldLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldLoginKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLoginKeyTyped(evt);
            }
        });
        jPanelDatosUsuario.add(jTextFieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 220, -1));

        jPasswordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyTyped(evt);
            }
        });
        jPanelDatosUsuario.add(jPasswordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 220, -1));

        jPasswordFieldRetypePassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldRetypePasswordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldRetypePasswordKeyTyped(evt);
            }
        });
        jPanelDatosUsuario.add(jPasswordFieldRetypePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 220, -1));

        getContentPane().add(jPanelDatosUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 640, 160));

        jPanelBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar2.jpg"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorderPainted(false);
        jButtonCancelar.setContentAreaFilled(false);
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
        jPanelBotones.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, -1));

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar1.JPG"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setBorderPainted(false);
        jButtonGuardar.setContentAreaFilled(false);
        jButtonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jButtonGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonGuardarKeyPressed(evt);
            }
        });
        jPanelBotones.add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 90));

        getContentPane().add(jPanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 10, -1, -1));

        pack();
    }//GEN-END:initComponents

    
    public boolean verificarPosibleRepeticion(String ci){
        String sentencia = "Select * From `icba`.`empleado` "
                    + "Where ci = '"+ci+"'";
        ResultSet rs = null;
        try {
            rs = bd.consulta(sentencia);
            if (rs.next() && (ci == null ? carnet != null : !ci.equals(carnet))){
                //System.out.println(ci);
                //System.out.println(carnet);
                return true; 
            }
                                
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
 
    public boolean verificarRetypePassword(String password, String repassword){
        if (password == null ? repassword != null : !password.equals(repassword)){
            //System.out.println("Hey you");
            return true;
        }
        else    
            return false;
    }
  
    public boolean verificarLogin(String login){
        String sentencia = "Select * From `icba`.`empleado` "
                    + "Where login = '"+login+"'";
        ResultSet rs = null;
        try {
            rs = bd.consulta(sentencia);
            if (rs.next())
                return true;                
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean verificarCamposObligatorios(String nombre, String apellidoPaterno, String apellidoMaterno, String ci){
        if ("".equals(nombre) || "".equals(apellidoPaterno) || "".equals(apellidoMaterno) || "".equals(ci))
            return true;
        return false;
    }    
    
    public boolean verificarCamposLogin(String login, String password, String repassword){
        if ("".equals(login) || "".equals(password) || "".equals(repassword))
            return true;
        return false; 
    }
    
    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        guardarBaseDatos();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        cerrarVentana();
    }//GEN-LAST:event_jButtonCancelarActionPerformed
    
    private void jTextFieldEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))    
            jTextFieldTelefono.requestFocus();
    }//GEN-LAST:event_jTextFieldEmailKeyPressed

    private void jTextFieldEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyTyped
        validarMail(evt);
    }//GEN-LAST:event_jTextFieldEmailKeyTyped

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped
        validarDatosIngresados(evt);
    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    private void jTextFieldNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldApellidoPaterno.requestFocus();
    }//GEN-LAST:event_jTextFieldNombreKeyPressed

    private void jTextFieldApellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPaternoKeyTyped
        validarDatosIngresados(evt);
    }//GEN-LAST:event_jTextFieldApellidoPaternoKeyTyped

    private void jTextFieldApellidoPaternoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPaternoKeyPressed
        saltarTextField(jTextFieldApellidoPaterno,evt);
    }//GEN-LAST:event_jTextFieldApellidoPaternoKeyPressed

    private void jTextFieldApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoMaternoKeyTyped
        validarDatosIngresados(evt);
    }//GEN-LAST:event_jTextFieldApellidoMaternoKeyTyped

    private void jTextFieldApellidoMaternoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoMaternoKeyPressed
        saltarTextField(jTextFieldApellidoMaterno,evt);
    }//GEN-LAST:event_jTextFieldApellidoMaternoKeyPressed

    private void jTextFieldLugarNacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLugarNacimientoKeyTyped
        validarDatosIngresados(evt);
    }//GEN-LAST:event_jTextFieldLugarNacimientoKeyTyped

    private void jTextFieldLugarNacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLugarNacimientoKeyPressed
        saltarTextField(jTextFieldLugarNacimiento,evt);
    }//GEN-LAST:event_jTextFieldLugarNacimientoKeyPressed

    private void jTextFieldCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCIKeyTyped
        validarNumerosIngresados(evt);
    }//GEN-LAST:event_jTextFieldCIKeyTyped

    private void jTextFieldCIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCIKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldDireccion.requestFocus();
    }//GEN-LAST:event_jTextFieldCIKeyPressed

    private void jTextFieldDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDireccionKeyTyped
        validarDireccion(evt);
    }//GEN-LAST:event_jTextFieldDireccionKeyTyped

    private void jTextFieldDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDireccionKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldEmail.requestFocus();
    }//GEN-LAST:event_jTextFieldDireccionKeyPressed

    private void jTextFieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoKeyTyped
        validarNumerosIngresados(evt);
    }//GEN-LAST:event_jTextFieldTelefonoKeyTyped

    private void jTextFieldTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldCelular.requestFocus();
    }//GEN-LAST:event_jTextFieldTelefonoKeyPressed

    private void jTextFieldCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCelularKeyTyped
        validarNumerosIngresados(evt);
    }//GEN-LAST:event_jTextFieldCelularKeyTyped

    private void jTextFieldCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCelularKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jComboBoxTipoUsuario.requestFocus();
    }//GEN-LAST:event_jTextFieldCelularKeyPressed

    private void jTextFieldLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLoginKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jPasswordFieldPassword.requestFocus();
    }//GEN-LAST:event_jTextFieldLoginKeyPressed

    private void jTextFieldLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLoginKeyTyped
        validarMail(evt);
    }//GEN-LAST:event_jTextFieldLoginKeyTyped


    private void jComboBoxTipoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxTipoUsuarioKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldLogin.requestFocus();
    }//GEN-LAST:event_jComboBoxTipoUsuarioKeyPressed

    private void jPasswordFieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jPasswordFieldRetypePassword.requestFocus();
    }//GEN-LAST:event_jPasswordFieldPasswordKeyPressed

    private void jPasswordFieldPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyTyped
        validarMail(evt);
    }//GEN-LAST:event_jPasswordFieldPasswordKeyTyped

    private void jPasswordFieldRetypePasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldRetypePasswordKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jButtonGuardar.requestFocus();
    }//GEN-LAST:event_jPasswordFieldRetypePasswordKeyPressed

    private void jPasswordFieldRetypePasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldRetypePasswordKeyTyped
        validarMail(evt);
    }//GEN-LAST:event_jPasswordFieldRetypePasswordKeyTyped

    private void jButtonGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonGuardarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            guardarBaseDatos();
        else
            if(evt.getKeyCode()== KeyEvent.VK_DOWN)
                jButtonCancelar.requestFocus();
    }//GEN-LAST:event_jButtonGuardarKeyPressed

    private void jButtonCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCancelarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            cerrarVentana();
        else
            if(evt.getKeyCode()== KeyEvent.VK_UP)
                jButtonGuardar.requestFocus();
    }//GEN-LAST:event_jButtonCancelarKeyPressed
    
 
    
    public void saltarTextField(JTextField nombre, KeyEvent evt){
        if( (evt.getKeyCode()== KeyEvent.VK_ENTER) || (evt.getKeyCode()== KeyEvent.VK_TAB))
            nombre.transferFocus();
    }
    
    public void validarDatosIngresados(KeyEvent evt){
        char caracter = evt.getKeyChar();

        if( ((caracter < 'A') || (caracter > 'Z'))&&
                ((caracter < 'a') || (caracter > 'z'))&&
                ((caracter != 'á') && (caracter != 'é') && (caracter != 'í') 
                && (caracter != 'ó') && (caracter != 'ú') && (caracter != 'ñ') && (caracter != 'Ñ') 
                && (caracter != 'Á') && (caracter != 'É') && (caracter != 'Í') 
                && (caracter != 'Ó') && (caracter != 'Ú'))&&
                (caracter != ' '))
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
    }
    
    public void validarNumerosIngresados(KeyEvent evt){
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE))
              evt.setKeyChar((char)KeyEvent.VK_CLEAR);// ignorar el evento de teclado
    }
    
    public void validarMail(KeyEvent evt){
        char caracter = evt.getKeyChar();

        if(((caracter < 'A') || (caracter > 'Z'))&&
                ((caracter < 'a') || (caracter > 'z'))&&
                (caracter!='@')&&(caracter!='.')&&(caracter!='-')&&(caracter!='_')&&
                ((caracter < '0') || (caracter > '9'))&&
                ((caracter != KeyEvent.VK_BACK_SPACE))) {

            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
        }       
    }
    
    public void validarDireccion(KeyEvent evt){
        char caracter = evt.getKeyChar();

        if( ((caracter < 'A') || (caracter > 'Z'))&&
                ((caracter < 'a') || (caracter > 'z'))&&
                ((caracter != 'á') && (caracter != 'é') && (caracter != 'í') 
                && (caracter != 'ó') && (caracter != 'ú') && (caracter != 'ñ') && (caracter != 'Ñ') 
                && (caracter != 'Á') && (caracter != 'É') && (caracter != 'Í') 
                && (caracter != 'Ó') && (caracter != 'Ú'))&&
                
                ((caracter != '#') && (caracter != '.') && (caracter != '_') 
                && (caracter != '-') && (caracter != '(') && (caracter != ')') && (caracter != ','))&&
                
                ((caracter < '0') || (caracter > '9')) &&
                (caracter != ' '))
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);        
    }
    
    
    public void limitarTams(){ 
        jTextFieldApellidoMaterno.setDocument(new JTextFieldLimit(25));
        jTextFieldApellidoPaterno.setDocument(new JTextFieldLimit(25));
        jTextFieldCI.setDocument(new JTextFieldLimit(15));
        jTextFieldCelular.setDocument(new JTextFieldLimit(8));

        jTextFieldDireccion.setDocument(new JTextFieldLimit(45));
        jTextFieldEmail.setDocument(new JTextFieldLimit(45));
        jTextFieldLugarNacimiento.setDocument(new JTextFieldLimit(45));
        jTextFieldNombre.setDocument(new JTextFieldLimit(25));
        
        jTextFieldTelefono.setDocument(new JTextFieldLimit(7));
        
        jTextFieldLogin.setDocument(new JTextFieldLimit(20));
        jPasswordFieldPassword.setDocument(new JTextFieldLimit(20));
        jPasswordFieldRetypePassword.setDocument(new JTextFieldLimit(20));
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardar;
    private com.toedter.calendar.JCalendar jCalendarFechaNacimiento;
    private javax.swing.JComboBox jComboBoxTipoUsuario;
    private javax.swing.JLabel jLabelAlemaniaMotivo;
    private javax.swing.JLabel jLabelApellidoMaterno;
    private javax.swing.JLabel jLabelApellidoPaterno;
    private javax.swing.JLabel jLabelCI;
    private javax.swing.JLabel jLabelCelularEstudiante;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFechaNacimiento;
    private javax.swing.JLabel jLabelLugarNacimiento;
    private javax.swing.JLabel jLabelMensajeMotivo;
    private javax.swing.JLabel jLabelMensajeViaje;
    private javax.swing.JLabel jLabelMotivoEstudios;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefonoEstudiante;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelDatosContacto;
    private javax.swing.JPanel jPanelDatosPersonales;
    private javax.swing.JPanel jPanelDatosUsuario;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JPasswordField jPasswordFieldRetypePassword;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldApellidoMaterno;
    private javax.swing.JTextField jTextFieldApellidoPaterno;
    private javax.swing.JTextField jTextFieldCI;
    private javax.swing.JTextField jTextFieldCelular;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldLugarNacimiento;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}