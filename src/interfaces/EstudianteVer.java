package interfaces;

import com.mysql.jdbc.ResultSet;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.ButtonGroup;

public final class EstudianteVer extends javax.swing.JDialog {
    GestorBD bd;
    int id;
    String motivoEstudioGlobal, alemaniaMotivoGlobal, alemaniaDuracionGlobal;
    
    EstudianteVer(int alumno) {
        id = alumno;
        
        initComponents();
        deshabilitarCampos();
        crearGrupoBotones();
        desseleccionarBotones();
        
        bd = new GestorBD(); 
        bd.getConnection();
        veamos();
    }

    public void buscarEstudiante() {
        dispose();
        
        EstudianteBuscarVer buscarestudiante=new EstudianteBuscarVer();
        buscarestudiante.setLocation(300,200);
        
        buscarestudiante.setVisible(true);
    }

    public void deshabilitarCampos(){
        jTextFieldAlemaniaDuracion.setEditable(false);
        jTextFieldAlemaniaMotivo.setEditable(false);
        jTextFieldApellidoMaterno.setEditable(false);
        jTextFieldApellidoPaterno.setEditable(false);
        jTextFieldCI.setEditable(false);
        jTextFieldCelularEstudiante.setEditable(false);
        jTextFieldCelularMadre.setEditable(false);
        jTextFieldCelularPadre.setEditable(false);
        jTextFieldDireccion.setEditable(false);
        jTextFieldEmail.setEditable(false);
        jTextFieldLugarNacimiento.setEditable(false);
        jTextFieldNombre.setEditable(false);
        jTextFieldNombreMadre.setEditable(false);
        jTextFieldNombrePadre.setEditable(false);
        jTextFieldFechaNacimiento.setEditable(false);
        jTextFieldMotivoEstudio.setEditable(false);
        jTextFieldTelefonoEstudiante.setEditable(false);
        jTextFieldTelefonoMadre.setEditable(false);
        jTextFieldTelefonoPadre.setEditable(false);    
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanelDatosPersonales = new javax.swing.JPanel();
        jLabelCI = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidoMaterno = new javax.swing.JLabel();
        jLabelLugarNacimiento = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldCI = new javax.swing.JTextField();
        jTextFieldLugarNacimiento = new javax.swing.JTextField();
        jTextFieldApellidoMaterno = new javax.swing.JTextField();
        jLabelApellidoPaterno = new javax.swing.JLabel();
        jTextFieldApellidoPaterno = new javax.swing.JTextField();
        jTextFieldFechaNacimiento = new javax.swing.JTextField();
        jLabelOcupacion = new javax.swing.JLabel();
        jCalendarFechaNacimiento = new com.toedter.calendar.JCalendar();
        jLabelFechaNacimiento = new javax.swing.JLabel();
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
        jButtonBuscarEstudiante = new javax.swing.JButton();

        setTitle("Datos del Estudiante");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));
        jPanelDatosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCI.setText("C.I. o Pasaporte");
        jPanelDatosPersonales.add(jLabelCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 19));

        jLabelNombre.setText("Nombre");
        jPanelDatosPersonales.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabelApellidoMaterno.setText("Apellido Materno");
        jPanelDatosPersonales.add(jLabelApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabelLugarNacimiento.setText("Lugar de Nacimiento");
        jPanelDatosPersonales.add(jLabelLugarNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        jPanelDatosPersonales.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 220, -1));
        jPanelDatosPersonales.add(jTextFieldCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 220, -1));
        jPanelDatosPersonales.add(jTextFieldLugarNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 220, -1));
        jPanelDatosPersonales.add(jTextFieldApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 220, -1));

        jLabelApellidoPaterno.setText("Apellido Paterno");
        jPanelDatosPersonales.add(jLabelApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanelDatosPersonales.add(jTextFieldApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 220, -1));
        jPanelDatosPersonales.add(jTextFieldFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 220, -1));

        jLabelOcupacion.setText("Ocupación Actual");
        jPanelDatosPersonales.add(jLabelOcupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 110, 20));
        jPanelDatosPersonales.add(jCalendarFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        jLabelFechaNacimiento.setText("Fecha de Nacimiento");
        jPanelDatosPersonales.add(jLabelFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        getContentPane().add(jPanelDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 640, 240));

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
        jPanelDatosContacto.add(jTextFieldTelefonoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 90, -1));
        jPanelDatosContacto.add(jTextFieldCelularEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 90, -1));
        jPanelDatosContacto.add(jTextFieldTelefonoPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 90, -1));
        jPanelDatosContacto.add(jTextFieldCelularPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 90, -1));
        jPanelDatosContacto.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, 610, 10));
        jPanelDatosContacto.add(jTextFieldNombreMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 220, -1));

        jLabelTelefonoMadre.setText("Teléfono");
        jPanelDatosContacto.add(jLabelTelefonoMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, 20));
        jPanelDatosContacto.add(jTextFieldTelefonoMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 90, -1));
        jPanelDatosContacto.add(jTextFieldCelularMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 90, -1));

        jLabelCelularMadre.setText("Celular");
        jPanelDatosContacto.add(jLabelCelularMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, 20));

        getContentPane().add(jPanelDatosContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 640, 260));

        jPanelEstudiosAleman.setBorder(javax.swing.BorderFactory.createTitledBorder("Estudio del Alemán"));
        jPanelEstudiosAleman.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMensajeMotivo.setText("Motivo principal por el que estudia alemán");
        jPanelEstudiosAleman.add(jLabelMensajeMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 31, -1, -1));

        jRadioButtonTrabajo.setText("Razones de Trabajo");
        jRadioButtonTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTrabajoActionPerformed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 55, -1, -1));

        jRadioButtonEmpresaAlemana.setText("Empresa Alemana");
        jRadioButtonEmpresaAlemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEmpresaAlemanaActionPerformed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonEmpresaAlemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, -1, -1));

        jRadioButtonPregrado.setText("Pregrado");
        jRadioButtonPregrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPregradoActionPerformed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonPregrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 73, -1, 30));

        jRadioButtonOtro.setText("Otro");
        jRadioButtonOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOtroActionPerformed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonOtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jRadioButtonViaje.setText("Viaje");
        jRadioButtonViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonViajeActionPerformed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jRadioButtonPosgrado.setText("Posgrado");
        jRadioButtonPosgrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPosgradoActionPerformed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonPosgrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 93, -1, 30));

        jLabelMensajeViaje.setText("Ha estado en Alemania?");
        jPanelEstudiosAleman.add(jLabelMensajeViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jRadioButtonAlemaniaSi.setText("Sí");
        jRadioButtonAlemaniaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAlemaniaSiActionPerformed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonAlemaniaSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        jRadioButtonAlemaniaNo.setText("No");
        jRadioButtonAlemaniaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAlemaniaNoActionPerformed(evt);
            }
        });
        jPanelEstudiosAleman.add(jRadioButtonAlemaniaNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));
        jPanelEstudiosAleman.add(jTextFieldAlemaniaMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 90, -1));
        jPanelEstudiosAleman.add(jTextFieldAlemaniaDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 90, -1));

        jLabelEstudiosAlemania.setText("Estudios en Alemania");
        jPanelEstudiosAleman.add(jLabelEstudiosAlemania, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, 20));

        jLabelCelularMadre1.setText("Duración");
        jPanelEstudiosAleman.add(jLabelCelularMadre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, 20));

        jLabelTelefonoMadre2.setText("Especificar");
        jPanelEstudiosAleman.add(jLabelTelefonoMadre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, 20));
        jPanelEstudiosAleman.add(jTextFieldMotivoEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 90, -1));

        jLabelTelefonoMadre3.setText("Motivo");
        jPanelEstudiosAleman.add(jLabelTelefonoMadre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, 20));

        getContentPane().add(jPanelEstudiosAleman, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 640, 160));

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
        jPanelBotones.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 122, 160, -1));

        jButtonBuscarEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.jpg"))); // NOI18N
        jButtonBuscarEstudiante.setText("Buscar");
        jButtonBuscarEstudiante.setBorderPainted(false);
        jButtonBuscarEstudiante.setContentAreaFilled(false);
        jButtonBuscarEstudiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBuscarEstudiante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonBuscarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarEstudianteActionPerformed(evt);
            }
        });
        jButtonBuscarEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonBuscarEstudianteKeyPressed(evt);
            }
        });
        jPanelBotones.add(jButtonBuscarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 11, 160, 80));

        getContentPane().add(jPanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 210, 370));

        pack();
    }//GEN-END:initComponents

    public void inicializar(){
        int idEstudiante = id;


        jPanelDatosPersonales = new javax.swing.JPanel();
        jLabelCI = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidoMaterno = new javax.swing.JLabel();
        //jLabelFechaNacimiento = new javax.swing.JLabel();
        jLabelLugarNacimiento = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldCI = new javax.swing.JTextField();
        jTextFieldLugarNacimiento = new javax.swing.JTextField();
        //jCalendarFechaNacimiento = new com.toedter.calendar.JCalendar();
        jTextFieldApellidoMaterno = new javax.swing.JTextField();
        jLabelApellidoPaterno = new javax.swing.JLabel();
        jTextFieldApellidoPaterno = new javax.swing.JTextField();
        jTextFieldFechaNacimiento = new javax.swing.JTextField();
        //jLabeFechaNacimiento = new javax.swing.JLabel();
        jPanelDatosContacto = new javax.swing.JPanel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelCelularEstudiante = new javax.swing.JLabel();
        jLabelTelefonoEstudiante = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldNombrePadre = new javax.swing.JTextField();
        jLabelOcupacion = new javax.swing.JLabel();
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
        jPanelBotones = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        
        jButtonBuscarEstudiante = new javax.swing.JButton();
        /*jPanelEstudiosIcba = new javax.swing.JPanel();
        jLabelNivelAnterior = new javax.swing.JLabel();
        jLabelNivelActual = new javax.swing.JLabel();
        jLabelFechaInicio = new javax.swing.JLabel();*/

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));
        jPanelDatosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCI.setText("C.I. o Pasaporte");
        jPanelDatosPersonales.add(jLabelCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 19));

        jLabelNombre.setText("Nombre");
        jPanelDatosPersonales.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabelApellidoMaterno.setText("Apellido Materno");
        jPanelDatosPersonales.add(jLabelApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        //jLabelFechaNacimiento.setText("Fecha de Nacimiento");
        //jPanelDatosPersonales.add(jLabelFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jLabelLugarNacimiento.setText("Lugar de Nacimiento");
        jPanelDatosPersonales.add(jLabelLugarNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        jPanelDatosPersonales.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 220, -1));
        jPanelDatosPersonales.add(jTextFieldCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 220, -1));
        jPanelDatosPersonales.add(jTextFieldLugarNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 220, -1));
        //jPanelDatosPersonales.add(jCalendarFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));
        jPanelDatosPersonales.add(jTextFieldApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 220, -1));

        jLabelApellidoPaterno.setText("Apellido Paterno");
        jPanelDatosPersonales.add(jLabelApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanelDatosPersonales.add(jTextFieldApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 220, -1));
        jPanelDatosPersonales.add(jTextFieldFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 220, -1));

        jLabelOcupacion.setText("Ocupación Actual");
        //jPanelDatosPersonales.add(jLabeFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 110, 20));



        //jLabeFechaNacimiento.setText("Ocupación Actual");
        jPanelDatosPersonales.add(jLabelOcupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 110, 20));

        getContentPane().add(jPanelDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 640, 240));

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
        jPanelDatosContacto.add(jTextFieldTelefonoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 90, -1));
        jPanelDatosContacto.add(jTextFieldCelularEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 90, -1));
        jPanelDatosContacto.add(jTextFieldTelefonoPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 90, -1));
        jPanelDatosContacto.add(jTextFieldCelularPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 90, -1));
        jPanelDatosContacto.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, 610, 10));
        jPanelDatosContacto.add(jTextFieldNombreMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 220, -1));

        jLabelTelefonoMadre.setText("Teléfono");
        jPanelDatosContacto.add(jLabelTelefonoMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, 20));
        jPanelDatosContacto.add(jTextFieldTelefonoMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 90, -1));
        jPanelDatosContacto.add(jTextFieldCelularMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 90, -1));

        jLabelCelularMadre.setText("Celular");
        jPanelDatosContacto.add(jLabelCelularMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, 20));

        getContentPane().add(jPanelDatosContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 640, 260));

        jPanelEstudiosAleman.setBorder(javax.swing.BorderFactory.createTitledBorder("Estudio del Alemán"));
        jPanelEstudiosAleman.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMensajeMotivo.setText("Motivo principal por el que estudia alemán");
        jPanelEstudiosAleman.add(jLabelMensajeMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 31, -1, -1));

        jRadioButtonTrabajo.setText("Razones de Trabajo");
        jPanelEstudiosAleman.add(jRadioButtonTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 55, -1, -1));

        jRadioButtonEmpresaAlemana.setText("Empresa Alemana");
        jPanelEstudiosAleman.add(jRadioButtonEmpresaAlemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, -1, -1));

        jRadioButtonPregrado.setText("Pregrado");
        jPanelEstudiosAleman.add(jRadioButtonPregrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 73, -1, 30));

        jRadioButtonOtro.setText("Otro");
        jPanelEstudiosAleman.add(jRadioButtonOtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jRadioButtonViaje.setText("Viaje");
        jPanelEstudiosAleman.add(jRadioButtonViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jRadioButtonPosgrado.setText("Posgrado");
        jPanelEstudiosAleman.add(jRadioButtonPosgrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 93, -1, 30));

        jLabelMensajeViaje.setText("Ha estado en Alemania?");
        jPanelEstudiosAleman.add(jLabelMensajeViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jRadioButtonAlemaniaSi.setText("Sí");
        jPanelEstudiosAleman.add(jRadioButtonAlemaniaSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        jRadioButtonAlemaniaNo.setText("No");
        jPanelEstudiosAleman.add(jRadioButtonAlemaniaNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));
        jPanelEstudiosAleman.add(jTextFieldAlemaniaMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 90, -1));
        jPanelEstudiosAleman.add(jTextFieldAlemaniaDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 90, -1));

        jLabelEstudiosAlemania.setText("Motivo");
        jPanelEstudiosAleman.add(jLabelEstudiosAlemania, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, 20));

        jLabelCelularMadre1.setText("Duración");
        jPanelEstudiosAleman.add(jLabelCelularMadre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, 20));

        jLabelTelefonoMadre2.setText("Especificar");
        jPanelEstudiosAleman.add(jLabelTelefonoMadre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, 20));
        jPanelEstudiosAleman.add(jTextFieldMotivoEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 90, -1));

        getContentPane().add(jPanelEstudiosAleman, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 640, 160));

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar2.jpg"))); // NOI18N
        jButtonCancelar.setText("Cancelar");

        jButtonBuscarEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.jpg"))); // NOI18N
        jButtonBuscarEstudiante.setText("Buscar");
        jButtonBuscarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarEstudianteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonBuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButtonCancelar)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 210, 370));

        /*jPanelEstudiosIcba.setBorder(javax.swing.BorderFactory.createTitledBorder("En el ICBA"));

        jLabelNivelAnterior.setText("Nivel Anterior");

        jLabelNivelActual.setText("Nivel Actual");

        jLabelFechaInicio.setText("Fecha de Inicio");

        javax.swing.GroupLayout jPanelEstudiosIcbaLayout = new javax.swing.GroupLayout(jPanelEstudiosIcba);
        jPanelEstudiosIcba.setLayout(jPanelEstudiosIcbaLayout);
        jPanelEstudiosIcbaLayout.setHorizontalGroup(
            jPanelEstudiosIcbaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstudiosIcbaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelEstudiosIcbaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFechaInicio)
                    .addComponent(jLabelNivelActual)
                    .addComponent(jLabelNivelAnterior))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanelEstudiosIcbaLayout.setVerticalGroup(
            jPanelEstudiosIcbaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEstudiosIcbaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelNivelAnterior)
                .addGap(27, 27, 27)
                .addComponent(jLabelNivelActual)
                .addGap(27, 27, 27)
                .addComponent(jLabelFechaInicio)
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanelEstudiosIcba, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, 190, 160));*/

        pack();        
        
        
        
        GestorBD bd = new GestorBD(); 
        try {
            bd.getConnection();
            //System.out.println(fila);
            //System.out.println(idEstudiante);
            ResultSet rs = bd.consulta("SELECT * FROM `icba`.`estudiante` WHERE idEstudiante = "+idEstudiante);
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
            
            //String fechaNacimiento = rs.getString("fechaNacimiento");
            //String fechaNacimiento = String.valueOf(rs.getDate("fechaNacimiento"));
            //System.out.println(fechaNacimiento);
            //jTextFieldFechaNacimiento.setText(fechaNacimiento);
            
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
            
            
            
            
            String celularMadre = rs.getString("celularMadre");
            jTextFieldCelularMadre.setText(celularMadre); 
            
            String celularPadre = rs.getString("celularPadre");
            jTextFieldCelularPadre.setText(celularPadre); 
            
            String ocupacion = rs.getString("ocupacion");
            jTextFieldFechaNacimiento.setText(ocupacion);            

            
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
         
            bd.cerrar();              
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar actualizar lo datos" + ex);
        }        
    }
    
    public void veamos(){
        int idEstudiante = id;
        
        try {
            //System.out.println(fila);
            //System.out.println(idEstudiante);
            ResultSet rs = bd.consulta("SELECT * FROM `icba`.`estudiante` WHERE idEstudiante = "+idEstudiante);
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
            
            
            String celularMadre = rs.getString("celularMadre");
            jTextFieldCelularMadre.setText(celularMadre); 
            
            String celularPadre = rs.getString("celularPadre");
            jTextFieldCelularPadre.setText(celularPadre); 
            
            String ocupacion = rs.getString("ocupacion");
            jTextFieldFechaNacimiento.setText(ocupacion);            

            
            String motivoEstudio = rs.getString("motivoEstudio");
            motivoEstudioGlobal = motivoEstudio;
            
            String alemaniaMotivo = rs.getString("alemaniaMotivo");
            alemaniaMotivoGlobal = alemaniaMotivo;     
            
            String alemaniaDuracion = rs.getString("alemaniaDuracion");   
            alemaniaDuracionGlobal = alemaniaDuracion;
            
            seleccionarBoton();
           
            }
            rs.close();
         
            bd.cerrar();              
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al consultar la base de datos" + ex);
        }      
  }  
    
    
    private void jButtonBuscarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarEstudianteActionPerformed
        buscarEstudiante();     
    }//GEN-LAST:event_jButtonBuscarEstudianteActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jRadioButtonTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTrabajoActionPerformed
        seleccionarBoton();
    }//GEN-LAST:event_jRadioButtonTrabajoActionPerformed

    private void jRadioButtonEmpresaAlemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEmpresaAlemanaActionPerformed
        seleccionarBoton();
    }//GEN-LAST:event_jRadioButtonEmpresaAlemanaActionPerformed

    private void jRadioButtonPregradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPregradoActionPerformed
        seleccionarBoton();
    }//GEN-LAST:event_jRadioButtonPregradoActionPerformed

    private void jRadioButtonPosgradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPosgradoActionPerformed
        seleccionarBoton();
    }//GEN-LAST:event_jRadioButtonPosgradoActionPerformed

    private void jRadioButtonViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonViajeActionPerformed
        seleccionarBoton();
    }//GEN-LAST:event_jRadioButtonViajeActionPerformed

    private void jRadioButtonOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOtroActionPerformed
        seleccionarBoton();
    }//GEN-LAST:event_jRadioButtonOtroActionPerformed

    private void jRadioButtonAlemaniaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAlemaniaSiActionPerformed
        seleccionarBoton();
    }//GEN-LAST:event_jRadioButtonAlemaniaSiActionPerformed

    private void jRadioButtonAlemaniaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAlemaniaNoActionPerformed
        seleccionarBoton();
    }//GEN-LAST:event_jRadioButtonAlemaniaNoActionPerformed

    private void jButtonBuscarEstudianteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonBuscarEstudianteKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            buscarEstudiante();
        else
            if(evt.getKeyCode()== KeyEvent.VK_DOWN)
                jButtonCancelar.requestFocus();
    }//GEN-LAST:event_jButtonBuscarEstudianteKeyPressed

    private void jButtonCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCancelarKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            dispose();
        else
            if(evt.getKeyCode()== KeyEvent.VK_UP)
                jButtonBuscarEstudiante.requestFocus();
    }//GEN-LAST:event_jButtonCancelarKeyPressed

    
    
    public void crearGrupoBotones(){
        grupoBotonesMotivo = new ButtonGroup();
        grupoBotonesMotivo.add(jRadioButtonViaje);
        grupoBotonesMotivo.add(jRadioButtonTrabajo);
        grupoBotonesMotivo.add(jRadioButtonPregrado);
        grupoBotonesMotivo.add(jRadioButtonPosgrado);
        grupoBotonesMotivo.add(jRadioButtonOtro);
        grupoBotonesMotivo.add(jRadioButtonEmpresaAlemana);
        
        grupoBotonesEstadiaAlemania = new ButtonGroup();
        grupoBotonesEstadiaAlemania.add(jRadioButtonAlemaniaSi);
        grupoBotonesEstadiaAlemania.add(jRadioButtonAlemaniaNo);
    }
    
    public void seleccionarBoton(){
        desseleccionarBotones();
        
        if ("Razones de Trabajo".equals(motivoEstudioGlobal)){
                jRadioButtonTrabajo.setSelected(true); 
            }
            else
            if ("Empresa Alemana".equals(motivoEstudioGlobal)){
                jRadioButtonEmpresaAlemana.setSelected(true);      
            }
            else
            if ("Pregrado".equals(motivoEstudioGlobal)){
                jRadioButtonPregrado.setSelected(true);     
            }
            else
            if ("Posgrado".equals(motivoEstudioGlobal)){
                jRadioButtonPosgrado.setSelected(true);     
            }
            else
            if ("Viaje".equals(motivoEstudioGlobal)){
                jRadioButtonViaje.setSelected(true); 
            }
            else{
                jRadioButtonOtro.setSelected(true);
                jTextFieldMotivoEstudio.setText(motivoEstudioGlobal);
            }
           
        if ("No".equals(alemaniaMotivoGlobal)){
                jRadioButtonAlemaniaNo.setSelected(true); 
            }
            else{
                jRadioButtonAlemaniaSi.setSelected(true);
                jTextFieldAlemaniaMotivo.setText(alemaniaMotivoGlobal);
                jTextFieldAlemaniaDuracion.setText(alemaniaDuracionGlobal);
        }  
        
        jPanelDatosPersonales.transferFocus();
    }
    
    public void desseleccionarBotones(){
        jRadioButtonViaje.setSelected(false);
        jRadioButtonTrabajo.setSelected(false);
        jRadioButtonPregrado.setSelected(false);
        jRadioButtonPosgrado.setSelected(false);
        jRadioButtonOtro.setSelected(false);
        jRadioButtonEmpresaAlemana.setSelected(false);
    }
    
    private ButtonGroup grupoBotonesMotivo;
    private ButtonGroup grupoBotonesEstadiaAlemania;    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarEstudiante;
    private javax.swing.JButton jButtonCancelar;
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
    private javax.swing.JTextField jTextFieldFechaNacimiento;
    private javax.swing.JTextField jTextFieldLugarNacimiento;
    private javax.swing.JTextField jTextFieldMotivoEstudio;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreMadre;
    private javax.swing.JTextField jTextFieldNombrePadre;
    private javax.swing.JTextField jTextFieldTelefonoEstudiante;
    private javax.swing.JTextField jTextFieldTelefonoMadre;
    private javax.swing.JTextField jTextFieldTelefonoPadre;
    // End of variables declaration//GEN-END:variables
}
