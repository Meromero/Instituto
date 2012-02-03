package interfaces;

import com.mysql.jdbc.ResultSet;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Date;


//public class UsuarioVer extends javax.swing.JFrame {  
public class UsuarioVer extends javax.swing.JDialog {  
    GestorBD bd;
    int id;
    
    public UsuarioVer(int alumno) {
        id = alumno;
        
        initComponents();
        deshabilitarCampos();
        
        bd = new GestorBD();
        bd.getConnection();
        veamos();
    }

    public void buscarUsuario() {
        dispose();
        
        UsuarioBuscarVer buscarusuario=new UsuarioBuscarVer();
        buscarusuario.setLocation(300,200);
        
        buscarusuario.setVisible(true);
    }

    
    public void deshabilitarCampos(){
        jTextFieldApellidoMaterno.setEditable(false);
        jTextFieldApellidoPaterno.setEditable(false);
        jTextFieldCI.setEditable(false);
        jTextFieldDireccion.setEditable(false);
        jTextFieldEmail.setEditable(false);
        jTextFieldLugarNacimiento.setEditable(false);
        jTextFieldNombre.setEditable(false);

        jTextFieldTelefono.setEditable(false); 
        jTextFieldCelular.setEditable(false);
        
        jTextFieldTipoUsuario.setEditable(false); 
        jTextFieldLogin.setEditable(false); 
        
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
        jLabelAlemaniaMotivo = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jTextFieldTipoUsuario = new javax.swing.JTextField();
        jPanelBotones = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonBuscarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos del Usuario");
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
        jPanelDatosPersonales.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 220, -1));
        jPanelDatosPersonales.add(jTextFieldCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 220, -1));
        jPanelDatosPersonales.add(jTextFieldLugarNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 220, -1));
        jPanelDatosPersonales.add(jCalendarFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));
        jPanelDatosPersonales.add(jTextFieldApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 220, -1));

        jLabelApellidoPaterno.setText("Apellido Paterno");
        jPanelDatosPersonales.add(jLabelApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
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
        jPanelDatosContacto.add(jTextFieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 220, -1));
        jPanelDatosContacto.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 220, -1));
        jPanelDatosContacto.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 72, 30, 30));
        jPanelDatosContacto.add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 90, -1));
        jPanelDatosContacto.add(jTextFieldCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 90, -1));

        getContentPane().add(jPanelDatosContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 640, -1));

        jPanelDatosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Usuario"));
        jPanelDatosUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMensajeMotivo.setText("Nombre de Usuario");
        jPanelDatosUsuario.add(jLabelMensajeMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabelAlemaniaMotivo.setText("Tipo");
        jPanelDatosUsuario.add(jLabelAlemaniaMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));
        jPanelDatosUsuario.add(jTextFieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 220, -1));
        jPanelDatosUsuario.add(jTextFieldTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 220, -1));

        getContentPane().add(jPanelDatosUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 640, 100));

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

        jButtonBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.jpg"))); // NOI18N
        jButtonBuscarUsuario.setText("Buscar");
        jButtonBuscarUsuario.setBorderPainted(false);
        jButtonBuscarUsuario.setContentAreaFilled(false);
        jButtonBuscarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBuscarUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarUsuarioActionPerformed(evt);
            }
        });
        jButtonBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonBuscarUsuarioKeyPressed(evt);
            }
        });
        jPanelBotones.add(jButtonBuscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 80));

        getContentPane().add(jPanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 10, -1, -1));

        pack();
    }//GEN-END:initComponents

    public void veamos(){
        int idEstudiante = id;
        
        try {
            ResultSet rs = bd.consulta("SELECT * FROM `icba`.`empleado` WHERE idEmpleado = "+idEstudiante);
            while (rs.next()){
            String nombre = rs.getString("nombre");
            jTextFieldNombre.setText(nombre);
            
            String apellidoPaterno = rs.getString("apellidoPaterno");
            jTextFieldApellidoPaterno.setText(apellidoPaterno);
            
            String apellidoMaterno = rs.getString("apellidoMaterno");
            jTextFieldApellidoMaterno.setText(apellidoMaterno);
            
            String ci = rs.getString("ci");
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
            
            if ("1".equals(tipoUsuario))
                jTextFieldTipoUsuario.setText("Profesor");
            else
                if ("2".equals(tipoUsuario))
                    jTextFieldTipoUsuario.setText("Secretaria"); 
            else
                if ("3".equals(tipoUsuario))
                    jTextFieldTipoUsuario.setText("Director"); 
            
            String login = rs.getString("login");
            jTextFieldLogin.setText(login);
            }
            rs.close();
         
            bd.cerrar();              
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al consultar la base de datos" + ex);
        }      
  }     
    

    private void jButtonBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarUsuarioActionPerformed
        buscarUsuario(); 
    }//GEN-LAST:event_jButtonBuscarUsuarioActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonBuscarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonBuscarUsuarioKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            buscarUsuario();
        else
            if(evt.getKeyCode()== KeyEvent.VK_DOWN)
                jButtonCancelar.requestFocus();
    }//GEN-LAST:event_jButtonBuscarUsuarioKeyPressed

    private void jButtonCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCancelarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            dispose();
        else
            if(evt.getKeyCode()== KeyEvent.VK_UP)
                jButtonBuscarUsuario.requestFocus();
    }//GEN-LAST:event_jButtonCancelarKeyPressed
        
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarUsuario;
    private javax.swing.JButton jButtonCancelar;
    private com.toedter.calendar.JCalendar jCalendarFechaNacimiento;
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
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefonoEstudiante;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelDatosContacto;
    private javax.swing.JPanel jPanelDatosPersonales;
    private javax.swing.JPanel jPanelDatosUsuario;
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
    private javax.swing.JTextField jTextFieldTipoUsuario;
    // End of variables declaration//GEN-END:variables
}