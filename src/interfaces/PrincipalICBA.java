package interfaces;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

public class PrincipalICBA extends javax.swing.JFrame {
    public PrincipalICBA() {
        initComponents();
        panel = new JPanelImagen("JPanelICBA1.png");
        this.add(panel,BorderLayout.CENTER);
        this.pack();
        setSize(panel.getWidth(), panel.getHeight());
        Bloquear();

        IngresoICBA ingreso = new IngresoICBA(this,true);
        ingreso.setLocation(350, 200);
        ingreso.show();
    }
    @Override
    public Image getIconImage(){
        Image imagen=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Iconoicba1.png"));
        return imagen;
    }

    public void  Bloquear()
    {
        //MenuCaja.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jToolBar1 = new javax.swing.JToolBar();
        Nuevoestudiante = new javax.swing.JButton();
        Inscripcion = new javax.swing.JButton();
        BotonBarraPagar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenuItem45 = new javax.swing.JMenuItem();
        MenuCertificado = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem52 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuEstudiante = new javax.swing.JMenu();
        RegistrarEstudiante = new javax.swing.JMenuItem();
        ModificarEstudiante = new javax.swing.JMenuItem();
        ModificarEstadoEstudiante = new javax.swing.JMenuItem();
        VerEstudiante = new javax.swing.JMenuItem();
        MenuInscripcion = new javax.swing.JMenu();
        InscripcionModulo = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        MenuCaja = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenuItem49 = new javax.swing.JMenuItem();
        jMenuItem50 = new javax.swing.JMenuItem();
        jMenuItem51 = new javax.swing.JMenuItem();
        MenuAsistencia = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem46 = new javax.swing.JMenuItem();
        jMenuItem47 = new javax.swing.JMenuItem();
        MenuModulos = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        MenuHorarioyAula = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        RegistrarHorario = new javax.swing.JMenuItem();
        ModificarHorario = new javax.swing.JMenuItem();
        ModificarEstadoHorario = new javax.swing.JMenuItem();
        VerHorario = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        RegistrarAula = new javax.swing.JMenuItem();
        ModificarAula = new javax.swing.JMenuItem();
        ModificarEstadoAula = new javax.swing.JMenuItem();
        VerAula = new javax.swing.JMenuItem();
        MenuUsuario = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        ModificarUsuario = new javax.swing.JMenuItem();
        ModificarEstadoUsuario = new javax.swing.JMenuItem();
        VerUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INSTITUTO CULTURAL BOLIVIANO ALEMAN");
        setBackground(new java.awt.Color(255, 255, 0));
        setIconImage(getIconImage());

        jToolBar1.setRollover(true);

        Nuevoestudiante.setBackground(new java.awt.Color(255, 51, 0));
        Nuevoestudiante.setForeground(new java.awt.Color(102, 0, 0));
        Nuevoestudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonNuevoEstudiantePrueba.jpg"))); // NOI18N
        Nuevoestudiante.setText("Registrar");
        Nuevoestudiante.setToolTipText("Registrar Estudiante Nuevo");
        Nuevoestudiante.setFocusable(false);
        Nuevoestudiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Nuevoestudiante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Nuevoestudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoestudianteActionPerformed(evt);
            }
        });
        jToolBar1.add(Nuevoestudiante);

        Inscripcion.setToolTipText("Inscribir Estudiante");
        Inscripcion.setBackground(new java.awt.Color(255, 51, 0));
        Inscripcion.setForeground(new java.awt.Color(153, 0, 0));
        Inscripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonInscripcionprueba.jpg"))); // NOI18N
        Inscripcion.setText("Inscripcion");
        Inscripcion.setFocusable(false);
        Inscripcion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Inscripcion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Inscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscripcionActionPerformed(evt);
            }
        });
        jToolBar1.add(Inscripcion);

        BotonBarraPagar.setToolTipText("Pagar cuotas");
        BotonBarraPagar.setBackground(new java.awt.Color(255, 51, 0));
        BotonBarraPagar.setForeground(new java.awt.Color(153, 0, 0));
        BotonBarraPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonPagarPrueba.jpg"))); // NOI18N
        BotonBarraPagar.setText("Pagar");
        BotonBarraPagar.setFocusable(false);
        BotonBarraPagar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonBarraPagar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonBarraPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBarraPagarActionPerformed(evt);
            }
        });
        jToolBar1.add(BotonBarraPagar);

        jButton2.setBackground(new java.awt.Color(255, 51, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonAsistenciaPrueba.jpg"))); // NOI18N
        jButton2.setText("Control");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMaximumSize(new java.awt.Dimension(59, 77));
        jButton2.setMinimumSize(new java.awt.Dimension(55, 75));
        jButton2.setPreferredSize(new java.awt.Dimension(59, 77));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jMenuBar1.setBackground(new java.awt.Color(255, 204, 102));
        jMenuBar1.setForeground(new java.awt.Color(153, 0, 0));

        jMenu1.setBackground(new java.awt.Color(255, 204, 102));
        jMenu1.setForeground(new java.awt.Color(153, 0, 0));
        jMenu1.setText("Archivo");

        jMenuItem25.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem25.setText("Estadisticas");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem25);

        jMenu2.setText("Notificaciones");

        jMenuItem39.setText("Programar");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem39);

        jMenuItem40.setText("Modificar");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem40);

        jMenuItem41.setText("Eliminar");
        jMenu2.add(jMenuItem41);

        jMenuItem45.setText("Ver");
        jMenu2.add(jMenuItem45);

        jMenu1.add(jMenu2);

        MenuCertificado.setText("Certificados");

        jMenuItem20.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem20.setText("Imprimir");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        MenuCertificado.add(jMenuItem20);

        jMenuItem52.setText("Cargar Certificados");
        jMenuItem52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem52ActionPerformed(evt);
            }
        });
        MenuCertificado.add(jMenuItem52);

        jMenu1.add(MenuCertificado);
        jMenu1.add(jSeparator1);

        jMenuItem1.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        MenuEstudiante.setForeground(new java.awt.Color(153, 0, 0));
        MenuEstudiante.setText("Gestion Estudiante");
        MenuEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEstudianteActionPerformed(evt);
            }
        });

        RegistrarEstudiante.setBackground(new java.awt.Color(254, 204, 102));
        RegistrarEstudiante.setText("Registrar");
        RegistrarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarEstudianteActionPerformed(evt);
            }
        });
        MenuEstudiante.add(RegistrarEstudiante);

        ModificarEstudiante.setBackground(new java.awt.Color(254, 204, 102));
        ModificarEstudiante.setText("Modificar");
        ModificarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarEstudianteActionPerformed(evt);
            }
        });
        MenuEstudiante.add(ModificarEstudiante);

        ModificarEstadoEstudiante.setBackground(new java.awt.Color(254, 204, 102));
        ModificarEstadoEstudiante.setText("Modificar Estado");
        ModificarEstadoEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarEstadoEstudianteActionPerformed(evt);
            }
        });
        MenuEstudiante.add(ModificarEstadoEstudiante);

        VerEstudiante.setBackground(new java.awt.Color(254, 204, 102));
        VerEstudiante.setText("Ver");
        VerEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerEstudianteActionPerformed(evt);
            }
        });
        MenuEstudiante.add(VerEstudiante);

        jMenuBar1.add(MenuEstudiante);

        MenuInscripcion.setBackground(new java.awt.Color(254, 204, 102));
        MenuInscripcion.setForeground(new java.awt.Color(153, 0, 0));
        MenuInscripcion.setText("Gestion Inscripciones");

        InscripcionModulo.setBackground(new java.awt.Color(254, 204, 102));
        InscripcionModulo.setText("Inscribir");
        InscripcionModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscripcionModuloActionPerformed(evt);
            }
        });
        MenuInscripcion.add(InscripcionModulo);

        jMenuItem36.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem36.setText("Modificar");
        MenuInscripcion.add(jMenuItem36);

        jMenuItem37.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem37.setText("Eliminar");
        MenuInscripcion.add(jMenuItem37);

        jMenuItem38.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem38.setText("Ver");
        MenuInscripcion.add(jMenuItem38);

        jMenuBar1.add(MenuInscripcion);

        MenuCaja.setForeground(new java.awt.Color(153, 0, 0));
        MenuCaja.setText("Gestion Caja");
        MenuCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCajaActionPerformed(evt);
            }
        });

        jMenu15.setBackground(new java.awt.Color(254, 204, 102));
        jMenu15.setText("Pagos");

        jMenuItem6.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem6.setText("Pagar Cuota");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem6);

        jMenuItem7.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem7.setText("Modificar Cuota");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem7);

        jMenuItem30.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem30.setText("Eliminar Cuota");
        jMenu15.add(jMenuItem30);

        jMenuItem42.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem42.setText("Ver Cuotas");
        jMenu15.add(jMenuItem42);

        MenuCaja.add(jMenu15);

        jMenu16.setBackground(new java.awt.Color(254, 204, 102));
        jMenu16.setText("Programacion Pagos");

        jMenuItem23.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem23.setText("Programar");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem23);

        jMenuItem24.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem24.setText("Modificar");
        jMenu16.add(jMenuItem24);

        jMenuItem43.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem43.setText("Eliminar");
        jMenu16.add(jMenuItem43);

        jMenuItem44.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem44.setText("Ver");
        jMenu16.add(jMenuItem44);

        MenuCaja.add(jMenu16);

        jMenu3.setText("Descuentos");

        jMenuItem48.setText("Programar ");
        jMenuItem48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem48ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem48);

        jMenuItem49.setText("Modificar");
        jMenu3.add(jMenuItem49);

        jMenuItem50.setText("Eliminar");
        jMenu3.add(jMenuItem50);

        jMenuItem51.setText("Ver");
        jMenu3.add(jMenuItem51);

        MenuCaja.add(jMenu3);

        jMenuBar1.add(MenuCaja);

        MenuAsistencia.setBackground(new java.awt.Color(254, 204, 102));
        MenuAsistencia.setForeground(new java.awt.Color(153, 0, 0));
        MenuAsistencia.setText("Gestion Asistencia");

        jMenuItem21.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem21.setText("Control ");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        MenuAsistencia.add(jMenuItem21);

        jMenuItem22.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem22.setText("Modificar");
        MenuAsistencia.add(jMenuItem22);

        jMenuItem46.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem46.setText("Eliminar");
        MenuAsistencia.add(jMenuItem46);

        jMenuItem47.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem47.setText("Ver");
        MenuAsistencia.add(jMenuItem47);

        jMenuBar1.add(MenuAsistencia);

        MenuModulos.setForeground(new java.awt.Color(153, 0, 0));
        MenuModulos.setText("Administracio de Modulos");

        jMenu7.setBackground(new java.awt.Color(254, 204, 102));
        jMenu7.setText("Gestion Modulo");

        jMenuItem14.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem14.setText("Crear");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem14);

        jMenuItem15.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem15.setText("Modificar");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem15);

        jMenuItem28.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem28.setText("Estado");
        jMenu7.add(jMenuItem28);

        jMenuItem34.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem34.setText("Ver");
        jMenu7.add(jMenuItem34);

        MenuModulos.add(jMenu7);

        jMenu10.setText("Asignacion Modulo");

        jMenuItem9.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem9.setText("Asignar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem9);

        jMenuItem13.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem13.setText("Modificar");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem13);

        jMenuItem29.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem29.setText("Estado");
        jMenu10.add(jMenuItem29);

        jMenuItem35.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem35.setText("Ver");
        jMenu10.add(jMenuItem35);

        MenuModulos.add(jMenu10);

        jMenuBar1.add(MenuModulos);

        MenuHorarioyAula.setForeground(new java.awt.Color(153, 0, 0));
        MenuHorarioyAula.setText("Administrar Horario y Aula");

        jMenu12.setText("Gestion Horario");

        RegistrarHorario.setBackground(new java.awt.Color(254, 204, 102));
        RegistrarHorario.setText("Crear");
        RegistrarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarHorarioActionPerformed(evt);
            }
        });
        jMenu12.add(RegistrarHorario);

        ModificarHorario.setBackground(new java.awt.Color(254, 204, 102));
        ModificarHorario.setText("Modificar");
        ModificarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarHorarioActionPerformed(evt);
            }
        });
        jMenu12.add(ModificarHorario);

        ModificarEstadoHorario.setBackground(new java.awt.Color(254, 204, 102));
        ModificarEstadoHorario.setText("Modificar Estado");
        ModificarEstadoHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarEstadoHorarioActionPerformed(evt);
            }
        });
        jMenu12.add(ModificarEstadoHorario);

        VerHorario.setBackground(new java.awt.Color(254, 204, 102));
        VerHorario.setText("Ver");
        VerHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerHorarioActionPerformed(evt);
            }
        });
        jMenu12.add(VerHorario);

        MenuHorarioyAula.add(jMenu12);

        jMenu13.setText("Gestion Aula");

        RegistrarAula.setBackground(new java.awt.Color(254, 204, 102));
        RegistrarAula.setText("Crear");
        RegistrarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarAulaActionPerformed(evt);
            }
        });
        jMenu13.add(RegistrarAula);

        ModificarAula.setBackground(new java.awt.Color(254, 204, 102));
        ModificarAula.setText("Modificar");
        ModificarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarAulaActionPerformed(evt);
            }
        });
        jMenu13.add(ModificarAula);

        ModificarEstadoAula.setBackground(new java.awt.Color(254, 204, 102));
        ModificarEstadoAula.setText("Modificar Estado");
        ModificarEstadoAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarEstadoAulaActionPerformed(evt);
            }
        });
        jMenu13.add(ModificarEstadoAula);

        VerAula.setBackground(new java.awt.Color(254, 204, 102));
        VerAula.setText("Ver");
        VerAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerAulaActionPerformed(evt);
            }
        });
        jMenu13.add(VerAula);

        MenuHorarioyAula.add(jMenu13);

        jMenuBar1.add(MenuHorarioyAula);

        MenuUsuario.setBackground(new java.awt.Color(254, 204, 102));
        MenuUsuario.setForeground(new java.awt.Color(153, 0, 0));
        MenuUsuario.setText("Gestion Usuario");
        MenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUsuarioActionPerformed(evt);
            }
        });

        jMenuItem8.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem8.setText("Resgistrar ");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        MenuUsuario.add(jMenuItem8);

        ModificarUsuario.setBackground(new java.awt.Color(254, 204, 102));
        ModificarUsuario.setText("Modificar");
        ModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarUsuarioActionPerformed(evt);
            }
        });
        MenuUsuario.add(ModificarUsuario);

        ModificarEstadoUsuario.setBackground(new java.awt.Color(254, 204, 102));
        ModificarEstadoUsuario.setText("Modificar Estado");
        ModificarEstadoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarEstadoUsuarioActionPerformed(evt);
            }
        });
        MenuUsuario.add(ModificarEstadoUsuario);

        VerUsuario.setBackground(new java.awt.Color(254, 204, 102));
        VerUsuario.setText("Ver");
        VerUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerUsuarioActionPerformed(evt);
            }
        });
        MenuUsuario.add(VerUsuario);

        jMenuBar1.add(MenuUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(731, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(1);        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem1ActionPerformed

    private void InscripcionModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscripcionModuloActionPerformed
        //InscripcionEstudianteNuevo inscripcion=new InscripcionEstudiante(this,true);
        InscripcionEstudianteNuevo inscripcion=new InscripcionEstudianteNuevo();
        
        inscripcion.setLocation((panel.getWidth())/4,(panel.getHeight())/6);
        inscripcion.setVisible(true);
        
        
        /*        InscripcionEstudiante inscripcion=new InscripcionEstudiante(this,true);
        inscripcion.setLocation((panel.getWidth())/4,(panel.getHeight())/6);
        inscripcion.setVisible(true);*/
}//GEN-LAST:event_InscripcionModuloActionPerformed

    private void MenuCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCajaActionPerformed

        // TODO add your handling code here:
        
}//GEN-LAST:event_MenuCajaActionPerformed

    private void RegistrarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarEstudianteActionPerformed
        EstudianteRegistrar registroestudiante = new EstudianteRegistrar();
        //registroestudiante.setLocation((panel.getWidth())/4,(panel.getHeight())/6);
        registroestudiante.setLocation((panel.getWidth())/4,0);
        registroestudiante.setVisible(true);
}//GEN-LAST:event_RegistrarEstudianteActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        UsuarioRegistrar registroestudiante = new UsuarioRegistrar();
        registroestudiante.setLocation((panel.getWidth())/4,(panel.getHeight())/6);
        registroestudiante.setVisible(true);      
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void ModificarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarEstudianteActionPerformed
          EstudianteBuscarActualizar editarestudiante=new EstudianteBuscarActualizar();
          editarestudiante.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
          editarestudiante.setVisible(true);
    }//GEN-LAST:event_ModificarEstudianteActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        AsignarModulo asignarmodulo=new AsignarModulo(this,true);
        asignarmodulo.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        CrearModulo crearmodulo=new CrearModulo(this,true);
        crearmodulo.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        crearmodulo.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        ModificarModulo editarmodulo=new ModificarModulo(this,true);
        editarmodulo.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        ModificarAsignacion editarasignacion=new ModificarAsignacion(this,true);
        editarasignacion.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        // TODO add your handling code here:
        RegistrarPago pagar=new RegistrarPago(this,true);
        pagar.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        pagar.setVisible(true);
}//GEN-LAST:event_jMenuItem6ActionPerformed

    private void ModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarUsuarioActionPerformed
        UsuarioBuscarActualizar editarusuario=new UsuarioBuscarActualizar();
        editarusuario.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        editarusuario.setVisible(true);        
    }//GEN-LAST:event_ModificarUsuarioActionPerformed

    private void RegistrarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarAulaActionPerformed
        AulaRegistrar registrar = new AulaRegistrar();
        registrar.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        registrar.setVisible(true);  
    }//GEN-LAST:event_RegistrarAulaActionPerformed

    private void ModificarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarHorarioActionPerformed
        HorarioBuscarModificar editar = new HorarioBuscarModificar();
        editar.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        editar.setVisible(true);
    }//GEN-LAST:event_ModificarHorarioActionPerformed

    private void RegistrarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarHorarioActionPerformed
        // TODO add your handling code here:
        /*CrearHorario registrar=new CrearHorario(this,true);
        registrar.setVisible(true);*/
        
        HorarioRegistrar registrar = new HorarioRegistrar();
        registrar.setVisible(true);
        
    }//GEN-LAST:event_RegistrarHorarioActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
       // EditarCuota editarcuota=new EditarCuota(this,true);
       // editarcuota.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        ImprimirCertificado imprimircertificado=new ImprimirCertificado(this,true);
        imprimircertificado.setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
        ControlAsistencia controasistencia=new ControlAsistencia(this,true);
        controasistencia.setVisible(true);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        ProgramacionPagos programacionpagos=new ProgramacionPagos(this,true);
        programacionpagos.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        // TODO add your handling code here:
        Estadisticas estadisticas=new Estadisticas(this,true);
        estadisticas.setVisible(true);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void MenuEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuEstudianteActionPerformed

    private void NuevoestudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoestudianteActionPerformed
        // TODO add your handling code here:
        /*EstudianteRegistrarAntiguo registroestudiante = new EstudianteRegistrarAntiguo(this,true);
        registroestudiante.setLocation((panel.getWidth())/4,(panel.getHeight())/6);
        registroestudiante.setVisible(true);*/
    }//GEN-LAST:event_NuevoestudianteActionPerformed

    private void InscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscripcionActionPerformed
        // TODO add your handling code here:
        InscripcionEstudiante inscripcion=new InscripcionEstudiante(this,true);
        inscripcion.setLocation((panel.getWidth())/4,(panel.getHeight())/6);
        inscripcion.setVisible(true);
    }//GEN-LAST:event_InscripcionActionPerformed

    private void BotonBarraPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBarraPagarActionPerformed
        // TODO add your handling code here:
        RegistrarPago pagar=new RegistrarPago(this,true);
        pagar.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        pagar.setVisible(true);
    }//GEN-LAST:event_BotonBarraPagarActionPerformed

    private void ModificarEstadoEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarEstadoEstudianteActionPerformed
        EstudianteBuscarEstado estado = new EstudianteBuscarEstado();
        estado.setLocation(300,200);
        
        //this.dispose();
        estado.setVisible(true); 
        //EstadoEstudiante estadoestudiante=new EstadoEstudiante(this,true);
       // estadoestudiante.setVisible(true);
    }//GEN-LAST:event_ModificarEstadoEstudianteActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        // TODO add your handling code here:
        ProgramarNotificacion programarnotificacion=new ProgramarNotificacion(this,true);
        programarnotificacion.setVisible(true);

    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem48ActionPerformed
        // TODO add your handling code here:
        ProgramarDescuento programardescuento= new ProgramarDescuento(this,true);
        programardescuento.setVisible(true);
    }//GEN-LAST:event_jMenuItem48ActionPerformed

    private void jMenuItem52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem52ActionPerformed
        // TODO add your handling code here:
        CargarCetificados cargarcertificados=new CargarCetificados(this,true);
        cargarcertificados.setVisible(true);
    }//GEN-LAST:event_jMenuItem52ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        // TODO add your handling code here:
        ModificarNotificacion modificarnotificacion=new ModificarNotificacion(this,true);
        modificarnotificacion.setVisible(true);
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void VerEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerEstudianteActionPerformed
        EstudianteBuscarVer buscarestudiante=new EstudianteBuscarVer();
        buscarestudiante.setLocation(300,200);
        buscarestudiante.setVisible(true);        
    }//GEN-LAST:event_VerEstudianteActionPerformed

    private void VerUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerUsuarioActionPerformed
        UsuarioBuscarVer buscarusuario=new UsuarioBuscarVer();
        buscarusuario.setLocation(300,200);
        buscarusuario.setVisible(true);    
    }//GEN-LAST:event_VerUsuarioActionPerformed

    private void MenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUsuarioActionPerformed
        UsuarioBuscarActualizar buscarusuario=new UsuarioBuscarActualizar();
        buscarusuario.setLocation(300,200);
        buscarusuario.setVisible(true);    
    }//GEN-LAST:event_MenuUsuarioActionPerformed

    private void ModificarEstadoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarEstadoUsuarioActionPerformed
        UsuarioBuscarEstado estado = new UsuarioBuscarEstado();
        estado.setLocation(300,200);
        estado.setVisible(true); 
    }//GEN-LAST:event_ModificarEstadoUsuarioActionPerformed

    private void VerHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerHorarioActionPerformed
        HorarioVer buscar = new HorarioVer();
        buscar.setLocation(300,200);
        buscar.setVisible(true); 
    }//GEN-LAST:event_VerHorarioActionPerformed

    private void ModificarEstadoHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarEstadoHorarioActionPerformed
        HorarioBuscarEstado buscar = new HorarioBuscarEstado();
        buscar.setLocation(300,200);
        buscar.setVisible(true); 
    }//GEN-LAST:event_ModificarEstadoHorarioActionPerformed

    private void ModificarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarAulaActionPerformed
        AulaBuscarModificar editar = new AulaBuscarModificar();
        editar.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        editar.setVisible(true);
    }//GEN-LAST:event_ModificarAulaActionPerformed

    private void ModificarEstadoAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarEstadoAulaActionPerformed
        AulaBuscarEstado buscar = new AulaBuscarEstado();
        buscar.setLocation(300,200);
        buscar.setVisible(true); 
    }//GEN-LAST:event_ModificarEstadoAulaActionPerformed

    private void VerAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerAulaActionPerformed
        AulaBuscarVer buscar = new AulaBuscarVer();
        buscar.setLocation(300,200);
        buscar.setVisible(true); 
    }//GEN-LAST:event_VerAulaActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalICBA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBarraPagar;
    private javax.swing.JButton Inscripcion;
    private javax.swing.JMenuItem InscripcionModulo;
    private javax.swing.JMenu MenuAsistencia;
    private javax.swing.JMenu MenuCaja;
    private javax.swing.JMenu MenuCertificado;
    private javax.swing.JMenu MenuEstudiante;
    private javax.swing.JMenu MenuHorarioyAula;
    private javax.swing.JMenu MenuInscripcion;
    private javax.swing.JMenu MenuModulos;
    private javax.swing.JMenu MenuUsuario;
    private javax.swing.JMenuItem ModificarAula;
    private javax.swing.JMenuItem ModificarEstadoAula;
    private javax.swing.JMenuItem ModificarEstadoEstudiante;
    private javax.swing.JMenuItem ModificarEstadoHorario;
    private javax.swing.JMenuItem ModificarEstadoUsuario;
    private javax.swing.JMenuItem ModificarEstudiante;
    private javax.swing.JMenuItem ModificarHorario;
    private javax.swing.JMenuItem ModificarUsuario;
    private javax.swing.JButton Nuevoestudiante;
    private javax.swing.JMenuItem RegistrarAula;
    private javax.swing.JMenuItem RegistrarEstudiante;
    private javax.swing.JMenuItem RegistrarHorario;
    private javax.swing.JMenuItem VerAula;
    private javax.swing.JMenuItem VerEstudiante;
    private javax.swing.JMenuItem VerHorario;
    private javax.swing.JMenuItem VerUsuario;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem47;
    private javax.swing.JMenuItem jMenuItem48;
    private javax.swing.JMenuItem jMenuItem49;
    private javax.swing.JMenuItem jMenuItem50;
    private javax.swing.JMenuItem jMenuItem51;
    private javax.swing.JMenuItem jMenuItem52;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    private JPanelImagen panel;
}
