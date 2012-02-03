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
        //Image imagen=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Iconoicba1.png"));
        Image imagen=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/IcbaPeq.jpg"));
        return imagen;
    }

    public void  Bloquear(){
        //MenuCaja.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jMenuBar1 = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        Estadisticas = new javax.swing.JMenuItem();
        MenuNotificaciones = new javax.swing.JMenu();
        NotificacionesProgramar = new javax.swing.JMenuItem();
        NotificacionesModificar = new javax.swing.JMenuItem();
        NotificacionesEliminar = new javax.swing.JMenuItem();
        NotificacionesVer = new javax.swing.JMenuItem();
        MenuCertificados = new javax.swing.JMenu();
        CertificadosImprimir = new javax.swing.JMenuItem();
        CertificadosCargar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuUsuario = new javax.swing.JMenu();
        UsuarioRegistrar = new javax.swing.JMenuItem();
        UsuarioModificar = new javax.swing.JMenuItem();
        UsuarioModificarEstado = new javax.swing.JMenuItem();
        UsuarioVer = new javax.swing.JMenuItem();
        MenuEstudiante = new javax.swing.JMenu();
        EstudianteRegistrar = new javax.swing.JMenuItem();
        EstudianteModificar = new javax.swing.JMenuItem();
        EstudianteModificarEstado = new javax.swing.JMenuItem();
        EstudianteVer = new javax.swing.JMenuItem();
        MenuInscripcion = new javax.swing.JMenu();
        InscripcionRegistrar = new javax.swing.JMenuItem();
        InscripcionModificar = new javax.swing.JMenuItem();
        InscripcionModificarEstado = new javax.swing.JMenuItem();
        InscripcionVer = new javax.swing.JMenuItem();
        MenuHorarioyAula = new javax.swing.JMenu();
        MenuHorario = new javax.swing.JMenu();
        HorarioRegistrar = new javax.swing.JMenuItem();
        HorarioModificar = new javax.swing.JMenuItem();
        HorarioModificarEstado = new javax.swing.JMenuItem();
        HorarioVer = new javax.swing.JMenuItem();
        MenuAula = new javax.swing.JMenu();
        AulaRegistrar = new javax.swing.JMenuItem();
        AulaModificar = new javax.swing.JMenuItem();
        AulaModificarEstado = new javax.swing.JMenuItem();
        AulaVer = new javax.swing.JMenuItem();
        MenuAdministracionModulos = new javax.swing.JMenu();
        MenuModulo = new javax.swing.JMenu();
        ModuloCrear = new javax.swing.JMenuItem();
        ModuloModificar = new javax.swing.JMenuItem();
        ModuloModificarEstado = new javax.swing.JMenuItem();
        ModuloVer = new javax.swing.JMenuItem();
        MenuAsignacion = new javax.swing.JMenu();
        AsignacionRegistrar = new javax.swing.JMenuItem();
        AsignacionModificar = new javax.swing.JMenuItem();
        AsignacionModificarEstado = new javax.swing.JMenuItem();
        AsignacionVer = new javax.swing.JMenuItem();
        MenuCaja = new javax.swing.JMenu();
        MenuPagos = new javax.swing.JMenu();
        PagosPagarCuota = new javax.swing.JMenuItem();
        PagosModificarCuota = new javax.swing.JMenuItem();
        PagosEliminarCuota = new javax.swing.JMenuItem();
        PagosVerCuota = new javax.swing.JMenuItem();
        MenuProgramacionPagos = new javax.swing.JMenu();
        ProgPagosProgramar = new javax.swing.JMenuItem();
        ProgPagosModificar = new javax.swing.JMenuItem();
        ProgPagosEliminar = new javax.swing.JMenuItem();
        ProgPagosVer = new javax.swing.JMenuItem();
        MenuDescuentos = new javax.swing.JMenu();
        DescuentosProgramar = new javax.swing.JMenuItem();
        DescuentosModificar = new javax.swing.JMenuItem();
        DescuentosEliminar = new javax.swing.JMenuItem();
        DescuentosVer = new javax.swing.JMenuItem();
        MenuAsistencia = new javax.swing.JMenu();
        AsistenciaControl = new javax.swing.JMenuItem();
        AsistenciaModificar = new javax.swing.JMenuItem();
        AsistenciaEliminar = new javax.swing.JMenuItem();
        AsistenciaVer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Instituto Cultural Boliviano Alemán");
        setBackground(new java.awt.Color(255, 255, 0));
        setIconImage(getIconImage());

        jMenuBar1.setBackground(new java.awt.Color(255, 204, 102));
        jMenuBar1.setForeground(new java.awt.Color(153, 0, 0));

        MenuArchivo.setBackground(new java.awt.Color(255, 204, 102));
        MenuArchivo.setForeground(new java.awt.Color(153, 0, 0));
        MenuArchivo.setText("Archivo");

        Estadisticas.setBackground(new java.awt.Color(254, 204, 102));
        Estadisticas.setText("Estadisticas");
        Estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadisticasActionPerformed(evt);
            }
        });
        MenuArchivo.add(Estadisticas);

        MenuNotificaciones.setBackground(new java.awt.Color(254, 204, 102));
        MenuNotificaciones.setForeground(new java.awt.Color(153, 0, 0));
        MenuNotificaciones.setText("Notificaciones");

        NotificacionesProgramar.setBackground(new java.awt.Color(254, 204, 102));
        NotificacionesProgramar.setText("Programar");
        NotificacionesProgramar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificacionesProgramarActionPerformed(evt);
            }
        });
        MenuNotificaciones.add(NotificacionesProgramar);

        NotificacionesModificar.setBackground(new java.awt.Color(254, 204, 102));
        NotificacionesModificar.setText("Modificar");
        NotificacionesModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificacionesModificarActionPerformed(evt);
            }
        });
        MenuNotificaciones.add(NotificacionesModificar);

        NotificacionesEliminar.setBackground(new java.awt.Color(254, 204, 102));
        NotificacionesEliminar.setText("Eliminar");
        MenuNotificaciones.add(NotificacionesEliminar);

        NotificacionesVer.setBackground(new java.awt.Color(254, 204, 102));
        NotificacionesVer.setText("Ver");
        MenuNotificaciones.add(NotificacionesVer);

        MenuArchivo.add(MenuNotificaciones);

        MenuCertificados.setBackground(new java.awt.Color(254, 204, 102));
        MenuCertificados.setForeground(new java.awt.Color(153, 0, 0));
        MenuCertificados.setText("Certificados");
        MenuCertificados.setContentAreaFilled(false);

        CertificadosImprimir.setBackground(new java.awt.Color(254, 204, 102));
        CertificadosImprimir.setText("Imprimir");
        CertificadosImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CertificadosImprimirActionPerformed(evt);
            }
        });
        MenuCertificados.add(CertificadosImprimir);

        CertificadosCargar.setBackground(new java.awt.Color(254, 204, 102));
        CertificadosCargar.setText("Cargar Certificados");
        CertificadosCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CertificadosCargarActionPerformed(evt);
            }
        });
        MenuCertificados.add(CertificadosCargar);

        MenuArchivo.add(MenuCertificados);
        MenuArchivo.add(jSeparator1);

        jMenuItem1.setBackground(new java.awt.Color(254, 204, 102));
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuArchivo.add(jMenuItem1);

        jMenuBar1.add(MenuArchivo);

        MenuUsuario.setBackground(new java.awt.Color(254, 204, 102));
        MenuUsuario.setForeground(new java.awt.Color(153, 0, 0));
        MenuUsuario.setText("Gestion Usuario");
        MenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUsuarioActionPerformed(evt);
            }
        });

        UsuarioRegistrar.setBackground(new java.awt.Color(254, 204, 102));
        UsuarioRegistrar.setText("Resgistrar ");
        UsuarioRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioRegistrarActionPerformed(evt);
            }
        });
        MenuUsuario.add(UsuarioRegistrar);

        UsuarioModificar.setBackground(new java.awt.Color(254, 204, 102));
        UsuarioModificar.setText("Modificar");
        UsuarioModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioModificarActionPerformed(evt);
            }
        });
        MenuUsuario.add(UsuarioModificar);

        UsuarioModificarEstado.setBackground(new java.awt.Color(254, 204, 102));
        UsuarioModificarEstado.setText("Modificar Estado");
        UsuarioModificarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioModificarEstadoActionPerformed(evt);
            }
        });
        MenuUsuario.add(UsuarioModificarEstado);

        UsuarioVer.setBackground(new java.awt.Color(254, 204, 102));
        UsuarioVer.setText("Ver");
        UsuarioVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioVerActionPerformed(evt);
            }
        });
        MenuUsuario.add(UsuarioVer);

        jMenuBar1.add(MenuUsuario);

        MenuEstudiante.setBackground(new java.awt.Color(254, 204, 102));
        MenuEstudiante.setForeground(new java.awt.Color(153, 0, 0));
        MenuEstudiante.setText("Gestion Estudiante");
        MenuEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEstudianteActionPerformed(evt);
            }
        });

        EstudianteRegistrar.setBackground(new java.awt.Color(254, 204, 102));
        EstudianteRegistrar.setText("Registrar");
        EstudianteRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstudianteRegistrarActionPerformed(evt);
            }
        });
        MenuEstudiante.add(EstudianteRegistrar);

        EstudianteModificar.setBackground(new java.awt.Color(254, 204, 102));
        EstudianteModificar.setText("Modificar");
        EstudianteModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstudianteModificarActionPerformed(evt);
            }
        });
        MenuEstudiante.add(EstudianteModificar);

        EstudianteModificarEstado.setBackground(new java.awt.Color(254, 204, 102));
        EstudianteModificarEstado.setText("Modificar Estado");
        EstudianteModificarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstudianteModificarEstadoActionPerformed(evt);
            }
        });
        MenuEstudiante.add(EstudianteModificarEstado);

        EstudianteVer.setBackground(new java.awt.Color(254, 204, 102));
        EstudianteVer.setText("Ver");
        EstudianteVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstudianteVerActionPerformed(evt);
            }
        });
        MenuEstudiante.add(EstudianteVer);

        jMenuBar1.add(MenuEstudiante);

        MenuInscripcion.setBackground(new java.awt.Color(254, 204, 102));
        MenuInscripcion.setForeground(new java.awt.Color(153, 0, 0));
        MenuInscripcion.setText("Gestion Inscripciones");

        InscripcionRegistrar.setBackground(new java.awt.Color(254, 204, 102));
        InscripcionRegistrar.setText("Inscribir");
        InscripcionRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscripcionRegistrarActionPerformed(evt);
            }
        });
        MenuInscripcion.add(InscripcionRegistrar);

        InscripcionModificar.setBackground(new java.awt.Color(254, 204, 102));
        InscripcionModificar.setText("Modificar");
        InscripcionModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscripcionModificarActionPerformed(evt);
            }
        });
        MenuInscripcion.add(InscripcionModificar);

        InscripcionModificarEstado.setBackground(new java.awt.Color(254, 204, 102));
        InscripcionModificarEstado.setText("Modificar Estado");
        MenuInscripcion.add(InscripcionModificarEstado);

        InscripcionVer.setBackground(new java.awt.Color(254, 204, 102));
        InscripcionVer.setText("Ver");
        MenuInscripcion.add(InscripcionVer);

        jMenuBar1.add(MenuInscripcion);

        MenuHorarioyAula.setBackground(new java.awt.Color(254, 204, 102));
        MenuHorarioyAula.setForeground(new java.awt.Color(153, 0, 0));
        MenuHorarioyAula.setText("Administrar Horario y Aula");

        MenuHorario.setBackground(new java.awt.Color(254, 204, 102));
        MenuHorario.setForeground(new java.awt.Color(153, 0, 0));
        MenuHorario.setText("Gestion Horario");

        HorarioRegistrar.setBackground(new java.awt.Color(254, 204, 102));
        HorarioRegistrar.setText("Crear");
        HorarioRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorarioRegistrarActionPerformed(evt);
            }
        });
        MenuHorario.add(HorarioRegistrar);

        HorarioModificar.setBackground(new java.awt.Color(254, 204, 102));
        HorarioModificar.setText("Modificar");
        HorarioModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorarioModificarActionPerformed(evt);
            }
        });
        MenuHorario.add(HorarioModificar);

        HorarioModificarEstado.setBackground(new java.awt.Color(254, 204, 102));
        HorarioModificarEstado.setText("Modificar Estado");
        HorarioModificarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorarioModificarEstadoActionPerformed(evt);
            }
        });
        MenuHorario.add(HorarioModificarEstado);

        HorarioVer.setBackground(new java.awt.Color(254, 204, 102));
        HorarioVer.setText("Ver");
        HorarioVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorarioVerActionPerformed(evt);
            }
        });
        MenuHorario.add(HorarioVer);

        MenuHorarioyAula.add(MenuHorario);

        MenuAula.setBackground(new java.awt.Color(254, 204, 102));
        MenuAula.setForeground(new java.awt.Color(153, 0, 0));
        MenuAula.setText("Gestion Aula");

        AulaRegistrar.setBackground(new java.awt.Color(254, 204, 102));
        AulaRegistrar.setText("Crear");
        AulaRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AulaRegistrarActionPerformed(evt);
            }
        });
        MenuAula.add(AulaRegistrar);

        AulaModificar.setBackground(new java.awt.Color(254, 204, 102));
        AulaModificar.setText("Modificar");
        AulaModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AulaModificarActionPerformed(evt);
            }
        });
        MenuAula.add(AulaModificar);

        AulaModificarEstado.setBackground(new java.awt.Color(254, 204, 102));
        AulaModificarEstado.setText("Modificar Estado");
        AulaModificarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AulaModificarEstadoActionPerformed(evt);
            }
        });
        MenuAula.add(AulaModificarEstado);

        AulaVer.setBackground(new java.awt.Color(254, 204, 102));
        AulaVer.setText("Ver");
        AulaVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AulaVerActionPerformed(evt);
            }
        });
        MenuAula.add(AulaVer);

        MenuHorarioyAula.add(MenuAula);

        jMenuBar1.add(MenuHorarioyAula);

        MenuAdministracionModulos.setBackground(new java.awt.Color(254, 204, 102));
        MenuAdministracionModulos.setForeground(new java.awt.Color(153, 0, 0));
        MenuAdministracionModulos.setText("Administracio de Modulos");

        MenuModulo.setBackground(new java.awt.Color(254, 204, 102));
        MenuModulo.setForeground(new java.awt.Color(153, 0, 0));
        MenuModulo.setText("Gestion Modulo");

        ModuloCrear.setBackground(new java.awt.Color(254, 204, 102));
        ModuloCrear.setText("Crear");
        ModuloCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModuloCrearActionPerformed(evt);
            }
        });
        MenuModulo.add(ModuloCrear);

        ModuloModificar.setBackground(new java.awt.Color(254, 204, 102));
        ModuloModificar.setText("Modificar");
        ModuloModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModuloModificarActionPerformed(evt);
            }
        });
        MenuModulo.add(ModuloModificar);

        ModuloModificarEstado.setBackground(new java.awt.Color(254, 204, 102));
        ModuloModificarEstado.setText("Modificar Estado");
        MenuModulo.add(ModuloModificarEstado);

        ModuloVer.setBackground(new java.awt.Color(254, 204, 102));
        ModuloVer.setText("Ver");
        MenuModulo.add(ModuloVer);

        MenuAdministracionModulos.add(MenuModulo);

        MenuAsignacion.setBackground(new java.awt.Color(254, 204, 102));
        MenuAsignacion.setForeground(new java.awt.Color(153, 0, 0));
        MenuAsignacion.setText("Asignacion Modulo");

        AsignacionRegistrar.setBackground(new java.awt.Color(254, 204, 102));
        AsignacionRegistrar.setText("Asignar");
        AsignacionRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignacionRegistrarActionPerformed(evt);
            }
        });
        MenuAsignacion.add(AsignacionRegistrar);

        AsignacionModificar.setBackground(new java.awt.Color(254, 204, 102));
        AsignacionModificar.setText("Modificar");
        AsignacionModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignacionModificarActionPerformed(evt);
            }
        });
        MenuAsignacion.add(AsignacionModificar);

        AsignacionModificarEstado.setBackground(new java.awt.Color(254, 204, 102));
        AsignacionModificarEstado.setText("Modificar Estado");
        MenuAsignacion.add(AsignacionModificarEstado);

        AsignacionVer.setBackground(new java.awt.Color(254, 204, 102));
        AsignacionVer.setText("Ver");
        MenuAsignacion.add(AsignacionVer);

        MenuAdministracionModulos.add(MenuAsignacion);

        jMenuBar1.add(MenuAdministracionModulos);

        MenuCaja.setBackground(new java.awt.Color(254, 204, 102));
        MenuCaja.setForeground(new java.awt.Color(153, 0, 0));
        MenuCaja.setText("Gestion Caja");
        MenuCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCajaActionPerformed(evt);
            }
        });

        MenuPagos.setBackground(new java.awt.Color(254, 204, 102));
        MenuPagos.setForeground(new java.awt.Color(153, 0, 0));
        MenuPagos.setText("Pagos");

        PagosPagarCuota.setBackground(new java.awt.Color(254, 204, 102));
        PagosPagarCuota.setText("Pagar Cuota");
        PagosPagarCuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagosPagarCuotaActionPerformed(evt);
            }
        });
        MenuPagos.add(PagosPagarCuota);

        PagosModificarCuota.setBackground(new java.awt.Color(254, 204, 102));
        PagosModificarCuota.setText("Modificar Cuota");
        PagosModificarCuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagosModificarCuotaActionPerformed(evt);
            }
        });
        MenuPagos.add(PagosModificarCuota);

        PagosEliminarCuota.setBackground(new java.awt.Color(254, 204, 102));
        PagosEliminarCuota.setText("Eliminar Cuota");
        MenuPagos.add(PagosEliminarCuota);

        PagosVerCuota.setBackground(new java.awt.Color(254, 204, 102));
        PagosVerCuota.setText("Ver Cuotas");
        MenuPagos.add(PagosVerCuota);

        MenuCaja.add(MenuPagos);

        MenuProgramacionPagos.setBackground(new java.awt.Color(254, 204, 102));
        MenuProgramacionPagos.setForeground(new java.awt.Color(153, 0, 0));
        MenuProgramacionPagos.setText("Programacion Pagos");

        ProgPagosProgramar.setBackground(new java.awt.Color(254, 204, 102));
        ProgPagosProgramar.setText("Programar");
        ProgPagosProgramar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgPagosProgramarActionPerformed(evt);
            }
        });
        MenuProgramacionPagos.add(ProgPagosProgramar);

        ProgPagosModificar.setBackground(new java.awt.Color(254, 204, 102));
        ProgPagosModificar.setText("Modificar");
        MenuProgramacionPagos.add(ProgPagosModificar);

        ProgPagosEliminar.setBackground(new java.awt.Color(254, 204, 102));
        ProgPagosEliminar.setText("Eliminar");
        MenuProgramacionPagos.add(ProgPagosEliminar);

        ProgPagosVer.setBackground(new java.awt.Color(254, 204, 102));
        ProgPagosVer.setText("Ver");
        MenuProgramacionPagos.add(ProgPagosVer);

        MenuCaja.add(MenuProgramacionPagos);

        MenuDescuentos.setBackground(new java.awt.Color(254, 204, 102));
        MenuDescuentos.setForeground(new java.awt.Color(153, 0, 0));
        MenuDescuentos.setText("Descuentos");

        DescuentosProgramar.setBackground(new java.awt.Color(254, 204, 102));
        DescuentosProgramar.setText("Programar ");
        DescuentosProgramar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescuentosProgramarActionPerformed(evt);
            }
        });
        MenuDescuentos.add(DescuentosProgramar);

        DescuentosModificar.setBackground(new java.awt.Color(254, 204, 102));
        DescuentosModificar.setText("Modificar");
        MenuDescuentos.add(DescuentosModificar);

        DescuentosEliminar.setBackground(new java.awt.Color(254, 204, 102));
        DescuentosEliminar.setText("Eliminar");
        MenuDescuentos.add(DescuentosEliminar);

        DescuentosVer.setBackground(new java.awt.Color(254, 204, 102));
        DescuentosVer.setText("Ver");
        MenuDescuentos.add(DescuentosVer);

        MenuCaja.add(MenuDescuentos);

        jMenuBar1.add(MenuCaja);

        MenuAsistencia.setBackground(new java.awt.Color(254, 204, 102));
        MenuAsistencia.setForeground(new java.awt.Color(153, 0, 0));
        MenuAsistencia.setText("Gestion Asistencia");

        AsistenciaControl.setBackground(new java.awt.Color(254, 204, 102));
        AsistenciaControl.setText("Control ");
        AsistenciaControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsistenciaControlActionPerformed(evt);
            }
        });
        MenuAsistencia.add(AsistenciaControl);

        AsistenciaModificar.setBackground(new java.awt.Color(254, 204, 102));
        AsistenciaModificar.setText("Modificar");
        MenuAsistencia.add(AsistenciaModificar);

        AsistenciaEliminar.setBackground(new java.awt.Color(254, 204, 102));
        AsistenciaEliminar.setText("Eliminar");
        MenuAsistencia.add(AsistenciaEliminar);

        AsistenciaVer.setBackground(new java.awt.Color(254, 204, 102));
        AsistenciaVer.setText("Ver");
        MenuAsistencia.add(AsistenciaVer);

        jMenuBar1.add(MenuAsistencia);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
        );

        pack();
    }//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(1);        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem1ActionPerformed

    private void InscripcionRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscripcionRegistrarActionPerformed
        //InscripcionEstudianteNuevo inscripcion=new InscripcionEstudiante(this,true);
        InscripcionEstudianteRegistrar inscripcion=new InscripcionEstudianteRegistrar();
        
        inscripcion.setLocation((panel.getWidth())/4,(panel.getHeight())/6);
        inscripcion.setVisible(true);
        
        
        /*        InscripcionEstudiante inscripcion=new InscripcionEstudiante(this,true);
        inscripcion.setLocation((panel.getWidth())/4,(panel.getHeight())/6);
        inscripcion.setVisible(true);*/
}//GEN-LAST:event_InscripcionRegistrarActionPerformed

    private void MenuCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCajaActionPerformed

        // TODO add your handling code here:
        
}//GEN-LAST:event_MenuCajaActionPerformed

    private void EstudianteRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstudianteRegistrarActionPerformed
        EstudianteRegistrar registroestudiante = new EstudianteRegistrar();
        //registroestudiante.setLocation((panel.getWidth())/4,(panel.getHeight())/6);
        registroestudiante.setLocation((panel.getWidth())/4,0);
        registroestudiante.setVisible(true);
}//GEN-LAST:event_EstudianteRegistrarActionPerformed

    private void UsuarioRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioRegistrarActionPerformed
        UsuarioRegistrar registroestudiante = new UsuarioRegistrar();
        registroestudiante.setLocation((panel.getWidth())/4,(panel.getHeight())/6);
        registroestudiante.setVisible(true);      
    }//GEN-LAST:event_UsuarioRegistrarActionPerformed

    private void EstudianteModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstudianteModificarActionPerformed
          EstudianteBuscarActualizar editarestudiante=new EstudianteBuscarActualizar();
          editarestudiante.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
          editarestudiante.setVisible(true);
    }//GEN-LAST:event_EstudianteModificarActionPerformed

    private void AsignacionRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignacionRegistrarActionPerformed
        AsignarModulo asignarmodulo=new AsignarModulo(this,true);
        asignarmodulo.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_AsignacionRegistrarActionPerformed

    private void ModuloCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModuloCrearActionPerformed
        // TODO add your handling code here:
        CrearModulo crearmodulo=new CrearModulo(this,true);
        crearmodulo.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        crearmodulo.setVisible(true);
    }//GEN-LAST:event_ModuloCrearActionPerformed

    private void ModuloModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModuloModificarActionPerformed
        // TODO add your handling code here:
        ModificarModulo editarmodulo=new ModificarModulo(this,true);
        editarmodulo.setVisible(true);
    }//GEN-LAST:event_ModuloModificarActionPerformed

    private void AsignacionModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignacionModificarActionPerformed
        // TODO add your handling code here:
        ModificarAsignacion editarasignacion=new ModificarAsignacion(this,true);
        editarasignacion.setVisible(true);
    }//GEN-LAST:event_AsignacionModificarActionPerformed

    private void PagosPagarCuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagosPagarCuotaActionPerformed

        // TODO add your handling code here:
        RegistrarPago pagar=new RegistrarPago(this,true);
        pagar.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        pagar.setVisible(true);
}//GEN-LAST:event_PagosPagarCuotaActionPerformed

    private void UsuarioModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioModificarActionPerformed
        UsuarioBuscarActualizar editarusuario=new UsuarioBuscarActualizar();
        editarusuario.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        editarusuario.setVisible(true);        
    }//GEN-LAST:event_UsuarioModificarActionPerformed

    private void AulaRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AulaRegistrarActionPerformed
        AulaRegistrar registrar = new AulaRegistrar();
        registrar.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        registrar.setVisible(true);  
    }//GEN-LAST:event_AulaRegistrarActionPerformed

    private void HorarioModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorarioModificarActionPerformed
        HorarioBuscarModificar editar = new HorarioBuscarModificar();
        editar.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        editar.setVisible(true);
    }//GEN-LAST:event_HorarioModificarActionPerformed

    private void HorarioRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorarioRegistrarActionPerformed
        // TODO add your handling code here:
        /*CrearHorario registrar=new CrearHorario(this,true);
        registrar.setVisible(true);*/
        
        HorarioRegistrar registrar = new HorarioRegistrar();
        registrar.setVisible(true);
        
    }//GEN-LAST:event_HorarioRegistrarActionPerformed

    private void PagosModificarCuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagosModificarCuotaActionPerformed
        // TODO add your handling code here:
       // EditarCuota editarcuota=new EditarCuota(this,true);
       // editarcuota.setVisible(true);
    }//GEN-LAST:event_PagosModificarCuotaActionPerformed

    private void CertificadosImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CertificadosImprimirActionPerformed
        // TODO add your handling code here:
        ImprimirCertificado imprimircertificado=new ImprimirCertificado(this,true);
        imprimircertificado.setVisible(true);
    }//GEN-LAST:event_CertificadosImprimirActionPerformed

    private void AsistenciaControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsistenciaControlActionPerformed
        // TODO add your handling code here:
        ControlAsistencia controasistencia=new ControlAsistencia(this,true);
        controasistencia.setVisible(true);
    }//GEN-LAST:event_AsistenciaControlActionPerformed

    private void ProgPagosProgramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgPagosProgramarActionPerformed
        ProgramacionPagos programacionpagos=new ProgramacionPagos(this,true);
        programacionpagos.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_ProgPagosProgramarActionPerformed

    private void EstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadisticasActionPerformed
        // TODO add your handling code here:
        Estadisticas estadisticas=new Estadisticas(this,true);
        estadisticas.setVisible(true);
    }//GEN-LAST:event_EstadisticasActionPerformed

    private void MenuEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuEstudianteActionPerformed

    private void EstudianteModificarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstudianteModificarEstadoActionPerformed
        EstudianteBuscarEstado estado = new EstudianteBuscarEstado();
        estado.setLocation(300,200);
        
        //this.dispose();
        estado.setVisible(true); 
        //EstadoEstudiante estadoestudiante=new EstadoEstudiante(this,true);
       // estadoestudiante.setVisible(true);
    }//GEN-LAST:event_EstudianteModificarEstadoActionPerformed

    private void NotificacionesProgramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionesProgramarActionPerformed
        // TODO add your handling code here:
        ProgramarNotificacion programarnotificacion=new ProgramarNotificacion(this,true);
        programarnotificacion.setVisible(true);

    }//GEN-LAST:event_NotificacionesProgramarActionPerformed

    private void DescuentosProgramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescuentosProgramarActionPerformed
        // TODO add your handling code here:
        ProgramarDescuento programardescuento= new ProgramarDescuento(this,true);
        programardescuento.setVisible(true);
    }//GEN-LAST:event_DescuentosProgramarActionPerformed

    private void CertificadosCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CertificadosCargarActionPerformed
        // TODO add your handling code here:
        CargarCetificados cargarcertificados=new CargarCetificados(this,true);
        cargarcertificados.setVisible(true);
    }//GEN-LAST:event_CertificadosCargarActionPerformed

    private void NotificacionesModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionesModificarActionPerformed
        // TODO add your handling code here:
        ModificarNotificacion modificarnotificacion=new ModificarNotificacion(this,true);
        modificarnotificacion.setVisible(true);
    }//GEN-LAST:event_NotificacionesModificarActionPerformed

    private void EstudianteVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstudianteVerActionPerformed
        EstudianteBuscarVer buscarestudiante=new EstudianteBuscarVer();
        buscarestudiante.setLocation(300,200);
        buscarestudiante.setVisible(true);        
    }//GEN-LAST:event_EstudianteVerActionPerformed

    private void UsuarioVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioVerActionPerformed
        UsuarioBuscarVer buscarusuario=new UsuarioBuscarVer();
        buscarusuario.setLocation(300,200);
        buscarusuario.setVisible(true);    
    }//GEN-LAST:event_UsuarioVerActionPerformed

    private void MenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUsuarioActionPerformed
        UsuarioBuscarActualizar buscarusuario=new UsuarioBuscarActualizar();
        buscarusuario.setLocation(300,200);
        buscarusuario.setVisible(true);    
    }//GEN-LAST:event_MenuUsuarioActionPerformed

    private void UsuarioModificarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioModificarEstadoActionPerformed
        UsuarioBuscarEstado estado = new UsuarioBuscarEstado();
        estado.setLocation(300,200);
        estado.setVisible(true); 
    }//GEN-LAST:event_UsuarioModificarEstadoActionPerformed

    private void HorarioVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorarioVerActionPerformed
        HorarioVer buscar = new HorarioVer();
        buscar.setLocation(300,200);
        buscar.setVisible(true); 
    }//GEN-LAST:event_HorarioVerActionPerformed

    private void HorarioModificarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorarioModificarEstadoActionPerformed
        HorarioBuscarEstado buscar = new HorarioBuscarEstado();
        buscar.setLocation(300,200);
        buscar.setVisible(true); 
    }//GEN-LAST:event_HorarioModificarEstadoActionPerformed

    private void AulaModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AulaModificarActionPerformed
        AulaBuscarModificar editar = new AulaBuscarModificar();
        editar.setLocation((panel.getWidth())/4,(panel.getHeight())/8);
        editar.setVisible(true);
    }//GEN-LAST:event_AulaModificarActionPerformed

    private void AulaModificarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AulaModificarEstadoActionPerformed
        AulaBuscarEstado buscar = new AulaBuscarEstado();
        buscar.setLocation(300,200);
        buscar.setVisible(true); 
    }//GEN-LAST:event_AulaModificarEstadoActionPerformed

    private void AulaVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AulaVerActionPerformed
        AulaBuscarVer buscar = new AulaBuscarVer();
        buscar.setLocation(300,200);
        buscar.setVisible(true); 
    }//GEN-LAST:event_AulaVerActionPerformed

    private void InscripcionModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscripcionModificarActionPerformed
        InscripcionBuscarModificar inscripcion=new InscripcionBuscarModificar();
        inscripcion.setLocation((panel.getWidth())/4,(panel.getHeight())/6);
        inscripcion.setVisible(true);
    }//GEN-LAST:event_InscripcionModificarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalICBA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AsignacionModificar;
    private javax.swing.JMenuItem AsignacionModificarEstado;
    private javax.swing.JMenuItem AsignacionRegistrar;
    private javax.swing.JMenuItem AsignacionVer;
    private javax.swing.JMenuItem AsistenciaControl;
    private javax.swing.JMenuItem AsistenciaEliminar;
    private javax.swing.JMenuItem AsistenciaModificar;
    private javax.swing.JMenuItem AsistenciaVer;
    private javax.swing.JMenuItem AulaModificar;
    private javax.swing.JMenuItem AulaModificarEstado;
    private javax.swing.JMenuItem AulaRegistrar;
    private javax.swing.JMenuItem AulaVer;
    private javax.swing.JMenuItem CertificadosCargar;
    private javax.swing.JMenuItem CertificadosImprimir;
    private javax.swing.JMenuItem DescuentosEliminar;
    private javax.swing.JMenuItem DescuentosModificar;
    private javax.swing.JMenuItem DescuentosProgramar;
    private javax.swing.JMenuItem DescuentosVer;
    private javax.swing.JMenuItem Estadisticas;
    private javax.swing.JMenuItem EstudianteModificar;
    private javax.swing.JMenuItem EstudianteModificarEstado;
    private javax.swing.JMenuItem EstudianteRegistrar;
    private javax.swing.JMenuItem EstudianteVer;
    private javax.swing.JMenuItem HorarioModificar;
    private javax.swing.JMenuItem HorarioModificarEstado;
    private javax.swing.JMenuItem HorarioRegistrar;
    private javax.swing.JMenuItem HorarioVer;
    private javax.swing.JMenuItem InscripcionModificar;
    private javax.swing.JMenuItem InscripcionModificarEstado;
    private javax.swing.JMenuItem InscripcionRegistrar;
    private javax.swing.JMenuItem InscripcionVer;
    private javax.swing.JMenu MenuAdministracionModulos;
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenu MenuAsignacion;
    private javax.swing.JMenu MenuAsistencia;
    private javax.swing.JMenu MenuAula;
    private javax.swing.JMenu MenuCaja;
    private javax.swing.JMenu MenuCertificados;
    private javax.swing.JMenu MenuDescuentos;
    private javax.swing.JMenu MenuEstudiante;
    private javax.swing.JMenu MenuHorario;
    private javax.swing.JMenu MenuHorarioyAula;
    private javax.swing.JMenu MenuInscripcion;
    private javax.swing.JMenu MenuModulo;
    private javax.swing.JMenu MenuNotificaciones;
    private javax.swing.JMenu MenuPagos;
    private javax.swing.JMenu MenuProgramacionPagos;
    private javax.swing.JMenu MenuUsuario;
    private javax.swing.JMenuItem ModuloCrear;
    private javax.swing.JMenuItem ModuloModificar;
    private javax.swing.JMenuItem ModuloModificarEstado;
    private javax.swing.JMenuItem ModuloVer;
    private javax.swing.JMenuItem NotificacionesEliminar;
    private javax.swing.JMenuItem NotificacionesModificar;
    private javax.swing.JMenuItem NotificacionesProgramar;
    private javax.swing.JMenuItem NotificacionesVer;
    private javax.swing.JMenuItem PagosEliminarCuota;
    private javax.swing.JMenuItem PagosModificarCuota;
    private javax.swing.JMenuItem PagosPagarCuota;
    private javax.swing.JMenuItem PagosVerCuota;
    private javax.swing.JMenuItem ProgPagosEliminar;
    private javax.swing.JMenuItem ProgPagosModificar;
    private javax.swing.JMenuItem ProgPagosProgramar;
    private javax.swing.JMenuItem ProgPagosVer;
    private javax.swing.JMenuItem UsuarioModificar;
    private javax.swing.JMenuItem UsuarioModificarEstado;
    private javax.swing.JMenuItem UsuarioRegistrar;
    private javax.swing.JMenuItem UsuarioVer;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
    private JPanelImagen panel;
}
