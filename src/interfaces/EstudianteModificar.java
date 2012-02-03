package interfaces;

import com.mysql.jdbc.ResultSet;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

 class EstudianteModificar extends javax.swing.JFrame {
    int id;
    String carnet;
    GestorBD bd;

    public EstudianteModificar() {
        initComponents();

    }
    
    EstudianteModificar (int fila){
        id = fila;
        int idEstudiante = fila;
        
        initComponents();
        crearGrupoBotones();
        limitarTams();
        bd = new GestorBD();
        
        try {
            bd.getConnection();
            ResultSet rs = bd.consulta("SELECT * FROM `icba`.`estudiante` WHERE idEstudiante = "+idEstudiante);
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
            jTextFieldTelefonoEstudiante.setText(telefono);
            
            String celular = rs.getString("celular");
            jTextFieldCelularEstudiante.setText(celular);
            
            String direccion = rs.getString("direccion");
            jTextFieldDireccion.setText(direccion);
            
            String email = rs.getString("email");
            jTextFieldEmail.setText(email);
            
            String nombrePadre = rs.getString("nombrePadre");
            jTextFieldNombrePadre.setText(nombrePadre);
            
            String telefonoPadre = rs.getString("telefonoPadre");
            jTextFieldTelefonoPadre.setText(telefonoPadre);
            
            String nombreMadre = rs.getString("nombreMadre");
            jTextFieldNombreMadre.setText(nombreMadre);
            
            String telefonoMadre = rs.getString("telefonoMadre");
            jTextFieldTelefonoMadre.setText(telefonoMadre);    
            
            
            String ocupacion = rs.getString("ocupacion");
            jTextFieldOcupacion.setText(ocupacion);   
            
            String celularMadre = rs.getString("celularMadre");
            jTextFieldCelularMadre.setText(celularMadre);   
            
            String celularPadre = rs.getString("celularPadre");
            jTextFieldCelularPadre.setText(celularPadre);   
            
            String motivoEstudio = rs.getString("motivoEstudio");
            
            String alemaniaMotivo = rs.getString("alemaniaMotivo");
                    
            String alemaniaDuracion = rs.getString("alemaniaDuracion");   
            
            
            if ("Razones de Trabajo".equals(motivoEstudio)){
                jRadioButtonTrabajo.setSelected(true); 
            }
            else
            if ("Empresa Alemana".equals(motivoEstudio)){
                jRadioButtonEmpresaAlemana.setSelected(true);      
            }
            else
            if ("Pregrado".equals(motivoEstudio)){
                jRadioButtonPregrado.setSelected(true);     
            }
            else
            if ("Posgrado".equals(motivoEstudio)){
                jRadioButtonPosgrado.setSelected(true);     
            }
            else
            if ("Viaje".equals(motivoEstudio)){
                jRadioButtonViaje.setSelected(true); 
            }
            else{
                jRadioButtonOtro.setSelected(true);
                jTextFieldMotivoEstudio.setText(motivoEstudio);
            }
            
            if ("No".equals(alemaniaMotivo)){
                jRadioButtonAlemaniaNo.setSelected(true); 
            }
            else{
                jRadioButtonAlemaniaSi.setSelected(true);
                jTextFieldAlemaniaMotivo.setText(alemaniaMotivo);
                jTextFieldAlemaniaDuracion.setText(alemaniaDuracion);
            }
              
            }
            rs.close();        
                    
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al hacer la consulta a la BD" + ex);
        }        
    }

    
    public static JRadioButton getSelection(ButtonGroup group){
            for (Enumeration e=group.getElements(); e.hasMoreElements(); )
            {
                JRadioButton b = (JRadioButton)e.nextElement();
                if (b.getModel() == group.getSelection())
                {
                    return b;
                }
            }

            return null;
    }

    public void cerrarVentana() {
        try {
            bd.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteModificar.class.getName()).log(Level.SEVERE, null, ex);
        }
         dispose();
    }

    public void guardarBaseDatos(){
        boolean repetido, datosIngresados;
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
            String telefono = jTextFieldTelefonoEstudiante.getText();
            String celular = jTextFieldCelularEstudiante.getText();
            String direccion = jTextFieldDireccion.getText();
            String email = jTextFieldEmail.getText();
            String nombrePadre = jTextFieldNombrePadre.getText();
            String telefonoPadre = jTextFieldTelefonoPadre.getText();
            String nombreMadre = jTextFieldNombreMadre.getText();
            String telefonoMadre = jTextFieldTelefonoMadre.getText();
 
            JRadioButton rbMotivoEstudio = getSelection(grupoBotonesMotivo);
            String motivoEstudio;
            
            if ("Otro".equals(rbMotivoEstudio.getText())){
                motivoEstudio = jTextFieldMotivoEstudio.getText();
            }
            else{
                motivoEstudio = rbMotivoEstudio.getText();
            }
                
            JRadioButton rbEstadia = getSelection(grupoBotonesEstadiaAlemania);
            String alemaniaDuracion; 
            String alemaniaMotivo;
            if ("Sí".equals(rbEstadia.getText())){
                alemaniaDuracion = jTextFieldAlemaniaDuracion.getText();
                alemaniaMotivo = jTextFieldAlemaniaMotivo.getText();      
            }
            else{
                alemaniaMotivo = rbEstadia.getText();
                alemaniaDuracion = rbEstadia.getText();
            }
            
            String celularMadre = jTextFieldCelularMadre.getText();
            String celularPadre = jTextFieldCelularPadre.getText();
            String ocupacion = jTextFieldOcupacion.getText();                
            
            repetido = false;
            repetido = verificarPosibleRepeticion(ci);
            
            datosIngresados = verificarCamposObligatorios(nombre, apellidoPaterno, apellidoMaterno, ci);
            
            if (repetido){
                JOptionPane.showMessageDialog(null,"Error al actualizar: El estudiante ya se encuentra registrado en la base de datos","Actualizacion de Datos de Estudiante",JOptionPane.INFORMATION_MESSAGE) ;
                jTextFieldCI.setText(carnet);
            }
            else if (datosIngresados){
                JOptionPane.showMessageDialog(null,"Error al actualizar: No se han ingreasado todos los campos obligatorios","Actualizacion de Datos de Estudiante",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldNombre.requestFocus();
            }             
            else{
                String sentencia = "UPDATE `icba`.`estudiante` SET `nombre` = '"+nombre+"',"
                        + "`apellidoPaterno` = '"+apellidoPaterno+"',"
                        + "`apellidoMaterno` = '"+apellidoMaterno+"',"
                        + "`ci` = '"+ci+"',"
                        + "`fechaNacimiento` = '"+fechaNacimiento+"',"
                        + "`lugarNacimiento` = '"+lugarNacimiento+"',"
                        + "`telefono` = '"+telefono+"',"
                        + "`celular` = '"+celular+"',"
                        + "`direccion` = '"+direccion+"',"
                        + "`email` = '"+email+"',"
                        + "`nombrePadre` = '"+nombrePadre+"',"
                        + "`telefonoPadre` = '"+telefonoPadre+"',"
                        + "`nombreMadre` = '"+nombreMadre+"',"
                        + "`telefonoMadre` = '"+telefonoMadre+"',"
                        + "`motivoEstudio` = '"+motivoEstudio+"',"

                        + "`celularPadre` = '"+celularPadre+"',"
                        + "`celularMadre` = '"+celularMadre+"',"
                        + "`ocupacion` = '"+ocupacion+"',"
                        + "`alemaniaMotivo` = '"+alemaniaMotivo+"',"
                        + "`alemaniaDuracion` = '"+alemaniaDuracion+"' "                        
                        
                        + "WHERE `estudiante`.`idEstudiante` = "+idEstudiante+";";    
                
                bd.modificarBD(sentencia);            
                
                JOptionPane.showMessageDialog(null,"Los datos del estudiante fueron actualizados exitosamente","Actualizacion de Datos de Estudiante",JOptionPane.INFORMATION_MESSAGE) ;
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
        jTextFieldOcupacion = new javax.swing.JTextField();
        jLabelOcupacion = new javax.swing.JLabel();
        jPanelDatosContacto = new javax.swing.JPanel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelCelularEstudiante = new javax.swing.JLabel();
        jLabelTelefonoEstudiante = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldNombrePadre = new javax.swing.JTextField();
        jLabelNombreMadre = new javax.swing.JLabel();
        jLabelNombrePadre = new javax.swing.JLabel();
        jLabelCelularPadre = new javax.swing.JLabel();
        jLabelTelefonoPadre = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jTextFieldTelefonoEstudiante = new javax.swing.JTextField();
        jTextFieldCelularEstudiante = new javax.swing.JTextField();
        jTextFieldTelefonoPadre = new javax.swing.JTextField();
        jTextFieldCelularPadre = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jTextFieldNombreMadre = new javax.swing.JTextField();
        jLabelTelefonoMadre = new javax.swing.JLabel();
        jTextFieldTelefonoMadre = new javax.swing.JTextField();
        jTextFieldCelularMadre = new javax.swing.JTextField();
        jLabelCelularMadre = new javax.swing.JLabel();
        jPanelEstudiosAleman = new javax.swing.JPanel();
        jLabelMensajeMotivo = new javax.swing.JLabel();
        jRadioButtonTrabajo = new javax.swing.JRadioButton();
        jRadioButtonEmpresaAlemana = new javax.swing.JRadioButton();
        jRadioButtonPregrado = new javax.swing.JRadioButton();
        jRadioButtonOtro = new javax.swing.JRadioButton();
        jRadioButtonViaje = new javax.swing.JRadioButton();
        jRadioButtonPosgrado = new javax.swing.JRadioButton();
        jLabelMensajeViaje = new javax.swing.JLabel();
        jRadioButtonAlemaniaSi = new javax.swing.JRadioButton();
        jRadioButtonAlemaniaNo = new javax.swing.JRadioButton();
        jTextFieldAlemaniaMotivo = new javax.swing.JTextField();
        jTextFieldAlemaniaDuracion = new javax.swing.JTextField();
        jLabelEstudiosAlemania = new javax.swing.JLabel();
        jLabelCelularMadre1 = new javax.swing.JLabel();
        jLabelTelefonoMadre2 = new javax.swing.JLabel();
        jTextFieldMotivoEstudio = new javax.swing.JTextField();
        jLabelTelefonoMadre3 = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar Datos de Estudiante");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanelDatosPersonales.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));
        jPanelDatosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCI.setText("C.I. o Pasaporte");
        jPanelDatosPersonales.add(jLabelCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 19));

        jLabelNombre.setText("Nombre");
        jPanelDatosPersonales.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabelApellidoMaterno.setText("Apellido Materno");
        jPanelDatosPersonales.add(jLabelApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabelFechaNacimiento.setText("Fecha de Nacimiento");
        jPanelDatosPersonales.add(jLabelFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

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

        jCalendarFechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDatosPersonales.add(jCalendarFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

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

        jTextFieldOcupacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldOcupacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldOcupacionKeyTyped(evt);
            }
        });
        jPanelDatosPersonales.add(jTextFieldOcupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 220, -1));

        jLabelOcupacion.setText("Ocupación Actual");
        jPanelDatosPersonales.add(jLabelOcupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 110, 20));

        jPanelDatosContacto.setBackground(new java.awt.Color(255, 255, 255));
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

        jTextFieldNombrePadre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNombrePadreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombrePadreKeyTyped(evt);
            }
        });
        jPanelDatosContacto.add(jTextFieldNombrePadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 220, -1));

        jLabelNombreMadre.setText("Nombre de la Madre");
        jPanelDatosContacto.add(jLabelNombreMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 20));

        jLabelNombrePadre.setText("Nombre del Padre");
        jPanelDatosContacto.add(jLabelNombrePadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        jLabelCelularPadre.setText("Celular");
        jPanelDatosContacto.add(jLabelCelularPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, 20));

        jLabelTelefonoPadre.setText("Teléfono");
        jPanelDatosContacto.add(jLabelTelefonoPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, 20));
        jPanelDatosContacto.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 72, 30, 30));
        jPanelDatosContacto.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 610, 10));

        jTextFieldTelefonoEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoEstudianteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoEstudianteKeyTyped(evt);
            }
        });
        jPanelDatosContacto.add(jTextFieldTelefonoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 90, -1));

        jTextFieldCelularEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCelularEstudianteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCelularEstudianteKeyTyped(evt);
            }
        });
        jPanelDatosContacto.add(jTextFieldCelularEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 90, -1));

        jTextFieldTelefonoPadre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoPadreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoPadreKeyTyped(evt);
            }
        });
        jPanelDatosContacto.add(jTextFieldTelefonoPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 90, -1));

        jTextFieldCelularPadre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCelularPadreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCelularPadreKeyTyped(evt);
            }
        });
        jPanelDatosContacto.add(jTextFieldCelularPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 90, -1));
        jPanelDatosContacto.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, 610, 10));

        jTextFieldNombreMadre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNombreMadreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreMadreKeyTyped(evt);
            }
        });
        jPanelDatosContacto.add(jTextFieldNombreMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 220, -1));

        jLabelTelefonoMadre.setText("Teléfono");
        jPanelDatosContacto.add(jLabelTelefonoMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, 20));

        jTextFieldTelefonoMadre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoMadreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoMadreKeyTyped(evt);
            }
        });
        jPanelDatosContacto.add(jTextFieldTelefonoMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 90, -1));

        jTextFieldCelularMadre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCelularMadreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCelularMadreKeyTyped(evt);
            }
        });
        jPanelDatosContacto.add(jTextFieldCelularMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 90, -1));

        jLabelCelularMadre.setText("Celular");
        jPanelDatosContacto.add(jLabelCelularMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, 20));

        jPanelEstudiosAleman.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEstudiosAleman.setBorder(javax.swing.BorderFactory.createTitledBorder("Estudio del Alemán"));
        jPanelEstudiosAleman.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMensajeMotivo.setText("Motivo principal por el que estudia alemán");
        jPanelEstudiosAleman.add(jLabelMensajeMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 31, -1, -1));

        jRadioButtonTrabajo.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonTrabajo.setText("Razones de Trabajo");
        jRadioButtonTrabajo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonTrabajoItemStateChanged(evt);
            }
        });
        jRadioButtonTrabajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButtonTrabajoKeyPressed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 55, -1, -1));

        jRadioButtonEmpresaAlemana.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonEmpresaAlemana.setText("Empresa Alemana");
        jRadioButtonEmpresaAlemana.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonEmpresaAlemanaItemStateChanged(evt);
            }
        });
        jRadioButtonEmpresaAlemana.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButtonEmpresaAlemanaKeyPressed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonEmpresaAlemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, -1, -1));

        jRadioButtonPregrado.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonPregrado.setText("Pregrado");
        jRadioButtonPregrado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonPregradoItemStateChanged(evt);
            }
        });
        jRadioButtonPregrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButtonPregradoKeyPressed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonPregrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 73, -1, 30));

        jRadioButtonOtro.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonOtro.setText("Otro");
        jRadioButtonOtro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonOtroItemStateChanged(evt);
            }
        });
        jRadioButtonOtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButtonOtroKeyPressed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonOtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jRadioButtonViaje.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonViaje.setText("Viaje");
        jRadioButtonViaje.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonViajeItemStateChanged(evt);
            }
        });
        jRadioButtonViaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButtonViajeKeyPressed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jRadioButtonPosgrado.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonPosgrado.setText("Posgrado");
        jRadioButtonPosgrado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonPosgradoItemStateChanged(evt);
            }
        });
        jRadioButtonPosgrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButtonPosgradoKeyPressed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonPosgrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 93, -1, 30));

        jLabelMensajeViaje.setText("Ha estado en Alemania?");
        jPanelEstudiosAleman.add(jLabelMensajeViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jRadioButtonAlemaniaSi.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonAlemaniaSi.setText("Sí");
        jRadioButtonAlemaniaSi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonAlemaniaSiItemStateChanged(evt);
            }
        });
        jRadioButtonAlemaniaSi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButtonAlemaniaSiKeyPressed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonAlemaniaSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        jRadioButtonAlemaniaNo.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonAlemaniaNo.setText("No");
        jRadioButtonAlemaniaNo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonAlemaniaNoItemStateChanged(evt);
            }
        });
        jRadioButtonAlemaniaNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButtonAlemaniaNoKeyPressed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonAlemaniaNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        jTextFieldAlemaniaMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAlemaniaMotivoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAlemaniaMotivoKeyTyped(evt);
            }
        });
        jPanelEstudiosAleman.add(jTextFieldAlemaniaMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 90, -1));

        jTextFieldAlemaniaDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAlemaniaDuracionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAlemaniaDuracionKeyTyped(evt);
            }
        });
        jPanelEstudiosAleman.add(jTextFieldAlemaniaDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 90, -1));

        jLabelEstudiosAlemania.setText("Estudios en Alemania");
        jPanelEstudiosAleman.add(jLabelEstudiosAlemania, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, 20));

        jLabelCelularMadre1.setText("Duración");
        jPanelEstudiosAleman.add(jLabelCelularMadre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, 20));

        jLabelTelefonoMadre2.setText("Especificar");
        jPanelEstudiosAleman.add(jLabelTelefonoMadre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, 20));

        jTextFieldMotivoEstudio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldMotivoEstudioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMotivoEstudioKeyTyped(evt);
            }
        });
        jPanelEstudiosAleman.add(jTextFieldMotivoEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 90, -1));

        jLabelTelefonoMadre3.setText("Motivo");
        jPanelEstudiosAleman.add(jLabelTelefonoMadre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, 20));

        jPanelBotones.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanelBotones.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 160, -1));

        jButtonGuardar.setBackground(new java.awt.Color(255, 255, 255));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 5, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanelDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanelDatosContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanelEstudiosAleman, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 25, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanelDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jPanelDatosContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(10, 10, 10)
                    .addComponent(jPanelEstudiosAleman, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }//GEN-END:initComponents

    public boolean verificarPosibleRepeticion(String ci){
        String sentencia = "Select * From `icba`.`estudiante` "
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
            Logger.getLogger(EstudianteRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    
 
    public boolean verificarCamposObligatorios(String nombre, String apellidoPaterno, String apellidoMaterno, String ci){
        if ("".equals(nombre) || "".equals(apellidoPaterno) || "".equals(apellidoMaterno) || "".equals(ci))
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
            jTextFieldTelefonoEstudiante.requestFocus();
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
         saltarTextField(jTextFieldCI,evt);
     }//GEN-LAST:event_jTextFieldCIKeyPressed

     private void jTextFieldOcupacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldOcupacionKeyTyped
         validarDatosIngresados(evt);
     }//GEN-LAST:event_jTextFieldOcupacionKeyTyped

     private void jTextFieldOcupacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldOcupacionKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldDireccion.requestFocus();
     }//GEN-LAST:event_jTextFieldOcupacionKeyPressed

     private void jTextFieldDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDireccionKeyTyped
         validarDireccion(evt);
     }//GEN-LAST:event_jTextFieldDireccionKeyTyped

     private void jTextFieldDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDireccionKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldEmail.requestFocus();
     }//GEN-LAST:event_jTextFieldDireccionKeyPressed

     private void jTextFieldTelefonoEstudianteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoEstudianteKeyTyped
         validarNumerosIngresados(evt);
     }//GEN-LAST:event_jTextFieldTelefonoEstudianteKeyTyped

     private void jTextFieldTelefonoEstudianteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoEstudianteKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldCelularEstudiante.requestFocus();
     }//GEN-LAST:event_jTextFieldTelefonoEstudianteKeyPressed

     private void jTextFieldCelularEstudianteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCelularEstudianteKeyTyped
         validarNumerosIngresados(evt);
     }//GEN-LAST:event_jTextFieldCelularEstudianteKeyTyped

     private void jTextFieldCelularEstudianteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCelularEstudianteKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldNombrePadre.requestFocus();
     }//GEN-LAST:event_jTextFieldCelularEstudianteKeyPressed

     private void jTextFieldNombrePadreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombrePadreKeyTyped
         validarDatosIngresados(evt);
     }//GEN-LAST:event_jTextFieldNombrePadreKeyTyped

     private void jTextFieldNombrePadreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombrePadreKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldTelefonoPadre.requestFocus();
     }//GEN-LAST:event_jTextFieldNombrePadreKeyPressed

     private void jTextFieldNombreMadreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreMadreKeyTyped
         validarDatosIngresados(evt);
     }//GEN-LAST:event_jTextFieldNombreMadreKeyTyped

     private void jTextFieldNombreMadreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreMadreKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldTelefonoMadre.requestFocus();
     }//GEN-LAST:event_jTextFieldNombreMadreKeyPressed

     private void jTextFieldTelefonoPadreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoPadreKeyTyped
         validarNumerosIngresados(evt);
     }//GEN-LAST:event_jTextFieldTelefonoPadreKeyTyped

     private void jTextFieldTelefonoPadreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoPadreKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldCelularPadre.requestFocus();
     }//GEN-LAST:event_jTextFieldTelefonoPadreKeyPressed

     private void jTextFieldCelularPadreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCelularPadreKeyTyped
         validarNumerosIngresados(evt);
     }//GEN-LAST:event_jTextFieldCelularPadreKeyTyped

     private void jTextFieldCelularPadreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCelularPadreKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldNombreMadre.requestFocus();
     }//GEN-LAST:event_jTextFieldCelularPadreKeyPressed

     private void jTextFieldTelefonoMadreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoMadreKeyTyped
         validarNumerosIngresados(evt);
     }//GEN-LAST:event_jTextFieldTelefonoMadreKeyTyped

     private void jTextFieldTelefonoMadreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoMadreKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldCelularMadre.requestFocus();
     }//GEN-LAST:event_jTextFieldTelefonoMadreKeyPressed

     private void jTextFieldCelularMadreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCelularMadreKeyTyped
         validarNumerosIngresados(evt);
     }//GEN-LAST:event_jTextFieldCelularMadreKeyTyped

     private void jTextFieldCelularMadreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCelularMadreKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jRadioButtonTrabajo.requestFocus();
     }//GEN-LAST:event_jTextFieldCelularMadreKeyPressed

     private void jTextFieldMotivoEstudioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMotivoEstudioKeyTyped
         validarDatosIngresados(evt);
     }//GEN-LAST:event_jTextFieldMotivoEstudioKeyTyped

     private void jTextFieldMotivoEstudioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMotivoEstudioKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jRadioButtonAlemaniaSi.requestFocus();
     }//GEN-LAST:event_jTextFieldMotivoEstudioKeyPressed

     private void jTextFieldAlemaniaMotivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAlemaniaMotivoKeyTyped
         validarDatosIngresados(evt);
     }//GEN-LAST:event_jTextFieldAlemaniaMotivoKeyTyped

     private void jTextFieldAlemaniaMotivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAlemaniaMotivoKeyPressed
         if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jTextFieldAlemaniaDuracion.requestFocus();
     }//GEN-LAST:event_jTextFieldAlemaniaMotivoKeyPressed

     private void jTextFieldAlemaniaDuracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAlemaniaDuracionKeyTyped
         validarNumerosIngresados(evt);
     }//GEN-LAST:event_jTextFieldAlemaniaDuracionKeyTyped

     private void jTextFieldAlemaniaDuracionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAlemaniaDuracionKeyPressed
         if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jButtonGuardar.requestFocus();
     }//GEN-LAST:event_jTextFieldAlemaniaDuracionKeyPressed

     private void jRadioButtonOtroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonOtroItemStateChanged
         jTextFieldMotivoEstudio.setEnabled(true);
     }//GEN-LAST:event_jRadioButtonOtroItemStateChanged

     private void jRadioButtonViajeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonViajeItemStateChanged
         limpiarMotivo();
     }//GEN-LAST:event_jRadioButtonViajeItemStateChanged

     private void jRadioButtonPosgradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonPosgradoItemStateChanged
         limpiarMotivo();
     }//GEN-LAST:event_jRadioButtonPosgradoItemStateChanged

     private void jRadioButtonPregradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonPregradoItemStateChanged
         limpiarMotivo();
     }//GEN-LAST:event_jRadioButtonPregradoItemStateChanged

     private void jRadioButtonEmpresaAlemanaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonEmpresaAlemanaItemStateChanged
         limpiarMotivo();
     }//GEN-LAST:event_jRadioButtonEmpresaAlemanaItemStateChanged

     private void jRadioButtonTrabajoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonTrabajoItemStateChanged
         limpiarMotivo();
     }//GEN-LAST:event_jRadioButtonTrabajoItemStateChanged

     private void jRadioButtonAlemaniaNoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonAlemaniaNoItemStateChanged
         limpiarEstadia();
     }//GEN-LAST:event_jRadioButtonAlemaniaNoItemStateChanged

     private void jRadioButtonAlemaniaSiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonAlemaniaSiItemStateChanged
         jTextFieldAlemaniaMotivo.setEnabled(true);  
         jTextFieldAlemaniaDuracion.setEnabled(true);  
     }//GEN-LAST:event_jRadioButtonAlemaniaSiItemStateChanged

     private void jRadioButtonTrabajoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButtonTrabajoKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_DOWN)
            jRadioButtonEmpresaAlemana.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_RIGHT)
                jRadioButtonPregrado.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_ENTER || evt.getKeyCode()== KeyEvent.VK_SPACE){
                jRadioButtonTrabajo.setSelected(true);
                jRadioButtonAlemaniaSi.requestFocus();
            }
     }//GEN-LAST:event_jRadioButtonTrabajoKeyPressed

     private void jRadioButtonEmpresaAlemanaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButtonEmpresaAlemanaKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_UP)
            jRadioButtonTrabajo.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_RIGHT)
                jRadioButtonPosgrado.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_ENTER || evt.getKeyCode()== KeyEvent.VK_SPACE){
                jRadioButtonEmpresaAlemana.setSelected(true);
                jRadioButtonAlemaniaSi.requestFocus();
            }           
     }//GEN-LAST:event_jRadioButtonEmpresaAlemanaKeyPressed

     private void jRadioButtonPregradoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButtonPregradoKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_DOWN)
            jRadioButtonPosgrado.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_LEFT)
                jRadioButtonTrabajo.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_RIGHT)
                jRadioButtonViaje.requestFocus();                      
        else
            if (evt.getKeyCode()== KeyEvent.VK_ENTER || evt.getKeyCode()== KeyEvent.VK_SPACE){
                jRadioButtonPregrado.setSelected(true);
                jRadioButtonAlemaniaSi.requestFocus();
            }    
     }//GEN-LAST:event_jRadioButtonPregradoKeyPressed

     private void jRadioButtonPosgradoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButtonPosgradoKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_UP)
            jRadioButtonPregrado.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_RIGHT)
                jRadioButtonOtro.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_LEFT)
                jRadioButtonEmpresaAlemana.requestFocus();
        else                
            if (evt.getKeyCode()== KeyEvent.VK_ENTER || evt.getKeyCode()== KeyEvent.VK_SPACE){
                jRadioButtonPosgrado.setSelected(true);
                jRadioButtonAlemaniaSi.requestFocus();
            }     
     }//GEN-LAST:event_jRadioButtonPosgradoKeyPressed

     private void jRadioButtonViajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButtonViajeKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_DOWN)
            jRadioButtonOtro.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_LEFT)
                jRadioButtonPregrado.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_ENTER || evt.getKeyCode()== KeyEvent.VK_SPACE){
                jRadioButtonViaje.setSelected(true);
                jRadioButtonAlemaniaSi.requestFocus();
            }
     }//GEN-LAST:event_jRadioButtonViajeKeyPressed

     private void jRadioButtonOtroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButtonOtroKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_UP)
            jRadioButtonViaje.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_LEFT)
                jRadioButtonPosgrado.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_ENTER || evt.getKeyCode()== KeyEvent.VK_SPACE){
                jRadioButtonOtro.setSelected(true);
                jTextFieldMotivoEstudio.requestFocus();
            }     
     }//GEN-LAST:event_jRadioButtonOtroKeyPressed

     private void jRadioButtonAlemaniaSiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButtonAlemaniaSiKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_DOWN)
            jRadioButtonAlemaniaNo.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_ENTER || evt.getKeyCode()== KeyEvent.VK_SPACE){
                jRadioButtonAlemaniaSi.setSelected(true);
                jTextFieldAlemaniaMotivo.requestFocus();
            }   
     }//GEN-LAST:event_jRadioButtonAlemaniaSiKeyPressed

     private void jRadioButtonAlemaniaNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButtonAlemaniaNoKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_UP)
            jRadioButtonAlemaniaSi.requestFocus();
        else
            if (evt.getKeyCode()== KeyEvent.VK_ENTER || evt.getKeyCode()== KeyEvent.VK_SPACE){
                jRadioButtonAlemaniaNo.setSelected(true);
                jButtonGuardar.requestFocus();
            }    
     }//GEN-LAST:event_jRadioButtonAlemaniaNoKeyPressed

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
        if( (evt.getKeyCode()== KeyEvent.VK_ENTER))
            nombre.transferFocus();
            //nombre.nextFocus();
    }
    
    public void validarDatosIngresados(KeyEvent evt){
        char caracter = evt.getKeyChar();;

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
        char caracter = evt.getKeyChar();;

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
    
    public void limpiarMotivo(){
        jTextFieldMotivoEstudio.setEnabled(false);
        jTextFieldMotivoEstudio.setText("");    
    }
    
    public void limpiarEstadia(){
        jTextFieldAlemaniaMotivo.setEnabled(false);
        jTextFieldAlemaniaMotivo.setText(""); 
        
        jTextFieldAlemaniaDuracion.setEnabled(false);
        jTextFieldAlemaniaDuracion.setText("");    
    }    
    
    
    public void limitarTams(){ 
        jTextFieldApellidoMaterno.setDocument(new JTextFieldLimit(25));
        jTextFieldApellidoPaterno.setDocument(new JTextFieldLimit(25));
        jTextFieldCI.setDocument(new JTextFieldLimit(15));
        jTextFieldCelularEstudiante.setDocument(new JTextFieldLimit(8));

        jTextFieldDireccion.setDocument(new JTextFieldLimit(45));
        jTextFieldEmail.setDocument(new JTextFieldLimit(45));
        jTextFieldLugarNacimiento.setDocument(new JTextFieldLimit(45));
        jTextFieldNombre.setDocument(new JTextFieldLimit(25));
        jTextFieldNombreMadre.setDocument(new JTextFieldLimit(25));
        jTextFieldNombrePadre.setDocument(new JTextFieldLimit(25));
        
        jTextFieldMotivoEstudio.setDocument(new JTextFieldLimit(20));
        jTextFieldTelefonoEstudiante.setDocument(new JTextFieldLimit(7));
        
        jTextFieldTelefonoMadre.setDocument(new JTextFieldLimit(7));
        jTextFieldTelefonoPadre.setDocument(new JTextFieldLimit(7));
        
        jTextFieldCelularMadre.setDocument(new JTextFieldLimit(8));
        jTextFieldCelularPadre.setDocument(new JTextFieldLimit(8));
        jTextFieldOcupacion.setDocument(new JTextFieldLimit(25));
        jTextFieldAlemaniaDuracion.setDocument(new JTextFieldLimit(3));
        jTextFieldAlemaniaMotivo.setDocument(new JTextFieldLimit(25)); 
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EstudianteModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstudianteModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstudianteModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstudianteModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EstudianteModificar().setVisible(true);
            }
        });
    }   
    
    public void crearGrupoBotones(){
        //grupoBotonesMotivo = new ButtonGroup();
        grupoBotonesMotivo = new SelectButtonGroup();
        grupoBotonesMotivo.add(jRadioButtonViaje);
        grupoBotonesMotivo.add(jRadioButtonTrabajo);
        grupoBotonesMotivo.add(jRadioButtonPregrado);
        grupoBotonesMotivo.add(jRadioButtonPosgrado);
        grupoBotonesMotivo.add(jRadioButtonOtro);
        grupoBotonesMotivo.add(jRadioButtonEmpresaAlemana);
        
        //grupoBotonesEstadiaAlemania = new ButtonGroup();
        grupoBotonesEstadiaAlemania = new SelectButtonGroup();
        grupoBotonesEstadiaAlemania.add(jRadioButtonAlemaniaSi);
        grupoBotonesEstadiaAlemania.add(jRadioButtonAlemaniaNo);
        
        jTextFieldMotivoEstudio.setEnabled(false);
        jTextFieldAlemaniaMotivo.setEnabled(false);
        jTextFieldAlemaniaDuracion.setEnabled(false);

        
        
    
    }

    private SelectButtonGroup grupoBotonesMotivo;
    private SelectButtonGroup grupoBotonesEstadiaAlemania;
    
    
    /*private ButtonGroup grupoBotonesMotivo;
    private ButtonGroup grupoBotonesEstadiaAlemania;*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardar;
    private com.toedter.calendar.JCalendar jCalendarFechaNacimiento;
    private javax.swing.JLabel jLabelApellidoMaterno;
    private javax.swing.JLabel jLabelApellidoPaterno;
    private javax.swing.JLabel jLabelCI;
    private javax.swing.JLabel jLabelCelularEstudiante;
    private javax.swing.JLabel jLabelCelularMadre;
    private javax.swing.JLabel jLabelCelularMadre1;
    private javax.swing.JLabel jLabelCelularPadre;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEstudiosAlemania;
    private javax.swing.JLabel jLabelFechaNacimiento;
    private javax.swing.JLabel jLabelLugarNacimiento;
    private javax.swing.JLabel jLabelMensajeMotivo;
    private javax.swing.JLabel jLabelMensajeViaje;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombreMadre;
    private javax.swing.JLabel jLabelNombrePadre;
    private javax.swing.JLabel jLabelOcupacion;
    private javax.swing.JLabel jLabelTelefonoEstudiante;
    private javax.swing.JLabel jLabelTelefonoMadre;
    private javax.swing.JLabel jLabelTelefonoMadre2;
    private javax.swing.JLabel jLabelTelefonoMadre3;
    private javax.swing.JLabel jLabelTelefonoPadre;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelDatosContacto;
    private javax.swing.JPanel jPanelDatosPersonales;
    private javax.swing.JPanel jPanelEstudiosAleman;
    private javax.swing.JRadioButton jRadioButtonAlemaniaNo;
    private javax.swing.JRadioButton jRadioButtonAlemaniaSi;
    private javax.swing.JRadioButton jRadioButtonEmpresaAlemana;
    private javax.swing.JRadioButton jRadioButtonOtro;
    private javax.swing.JRadioButton jRadioButtonPosgrado;
    private javax.swing.JRadioButton jRadioButtonPregrado;
    private javax.swing.JRadioButton jRadioButtonTrabajo;
    private javax.swing.JRadioButton jRadioButtonViaje;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldAlemaniaDuracion;
    private javax.swing.JTextField jTextFieldAlemaniaMotivo;
    private javax.swing.JTextField jTextFieldApellidoMaterno;
    private javax.swing.JTextField jTextFieldApellidoPaterno;
    private javax.swing.JTextField jTextFieldCI;
    private javax.swing.JTextField jTextFieldCelularEstudiante;
    private javax.swing.JTextField jTextFieldCelularMadre;
    private javax.swing.JTextField jTextFieldCelularPadre;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLugarNacimiento;
    private javax.swing.JTextField jTextFieldMotivoEstudio;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreMadre;
    private javax.swing.JTextField jTextFieldNombrePadre;
    private javax.swing.JTextField jTextFieldOcupacion;
    private javax.swing.JTextField jTextFieldTelefonoEstudiante;
    private javax.swing.JTextField jTextFieldTelefonoMadre;
    private javax.swing.JTextField jTextFieldTelefonoPadre;
    // End of variables declaration//GEN-END:variables
}
