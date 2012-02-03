package interfaces;

import Conexion.ConexionModulo;
import Entidades.Modulo;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;

public class InscripcionEstudianteNuevo extends javax.swing.JDialog {
    GestorBD bd;
    Modulo modulo;
    int idAlumno;
    int idModulo;
    
    
    public InscripcionEstudianteNuevo() {
        initComponents();
        bd = new GestorBD(); 
        bd.getConnection();  
    }
  
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanelFondo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelNombre1 = new javax.swing.JLabel();
        jLabelApellidoPaterno1 = new javax.swing.JLabel();
        jTextFieldNivel = new javax.swing.JTextField();
        jTextFieldCurso = new javax.swing.JTextField();
        jTextFieldID1 = new javax.swing.JTextField();
        jButtonBuscarEstudiante1 = new javax.swing.JButton();
        jTextFieldModalidad = new javax.swing.JTextField();
        jLabelApellidoMaterno1 = new javax.swing.JLabel();
        jLabelApellidoMaterno2 = new javax.swing.JLabel();
        jTextFieldTipo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidoMaterno = new javax.swing.JLabel();
        jTextFieldApellidoMaterno = new javax.swing.JTextField();
        jLabelApellidoPaterno = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellidoPaterno = new javax.swing.JTextField();
        jTextFieldID = new javax.swing.JTextField();
        jButtonBuscarEstudiante = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inscripcion");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Modulo"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombre1.setText("Nivel (A1,B,C)");
        jPanel2.add(jLabelNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabelApellidoPaterno1.setText("Curso");
        jPanel2.add(jLabelApellidoPaterno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel2.add(jTextFieldNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 220, -1));
        jPanel2.add(jTextFieldCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 220, -1));
        jPanel2.add(jTextFieldID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 50, -1));

        jButtonBuscarEstudiante1.setText("Buscar");
        jButtonBuscarEstudiante1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarEstudiante1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBuscarEstudiante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));
        jPanel2.add(jTextFieldModalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 220, -1));

        jLabelApellidoMaterno1.setText("Modalidad (extens o reg)");
        jPanel2.add(jLabelApellidoMaterno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabelApellidoMaterno2.setText("Tipo (jovenes,part,niv)");
        jPanel2.add(jLabelApellidoMaterno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel2.add(jTextFieldTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 220, -1));

        jPanelFondo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 560, 170));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Estudiante"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombre.setText("Nombre");
        jPanel1.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabelApellidoMaterno.setText("Apellido Materno");
        jPanel1.add(jLabelApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel1.add(jTextFieldApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 220, -1));

        jLabelApellidoPaterno.setText("Apellido Paterno");
        jPanel1.add(jLabelApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jPanel1.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 220, -1));
        jPanel1.add(jTextFieldApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 220, -1));
        jPanel1.add(jTextFieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 50, -1));

        jButtonBuscarEstudiante.setText("Buscar");
        jButtonBuscarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarEstudianteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        jPanelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 560, 160));

        jButton1.setText("Inscribir");
        jPanelFondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, -1, -1));

        jButton2.setText("Cancelar");
        jPanelFondo.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, -1, -1));

        getContentPane().add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        pack();
    }//GEN-END:initComponents

    private void jButtonBuscarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarEstudianteActionPerformed
        InscripcionBuscarEstudiante buscar = new InscripcionBuscarEstudiante();
        buscar.setModal(true);
        buscar.setVisible(true); 
       
        idAlumno = buscar.alumno;
        //jTextFieldID.setText(String.valueOf(idAlumno));
       
        try {
            //System.out.println(fila);
            //System.out.println(idEstudiante);
            ResultSet rs = bd.consulta("SELECT * FROM `icba`.`estudiante` WHERE idEstudiante = "+idAlumno);
            while (rs.next()){
            String nombre = rs.getString("nombre");
            jTextFieldNombre.setText(nombre);
            
            String apellidoPaterno = rs.getString("apellidoPaterno");
            jTextFieldApellidoPaterno.setText(apellidoPaterno);
            
            String apellidoMaterno = rs.getString("apellidoMaterno");
            jTextFieldApellidoMaterno.setText(apellidoMaterno);
            }
            rs.close();
         
            bd.cerrar();              
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al consultar la base de datos" + ex);
        }        
       
       
    }//GEN-LAST:event_jButtonBuscarEstudianteActionPerformed

    private void jButtonBuscarEstudiante1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarEstudiante1ActionPerformed
        InscripcionBuscarModulo buscar = new InscripcionBuscarModulo();
        buscar.setModal(true);
        buscar.setVisible(true); 
       
        idModulo = buscar.modulo;
        jTextFieldID1.setText(String.valueOf(idModulo));
        
        
        
        /*modulo.setTipoModulo(jTextFieldModalidad.toString());
        modulo.settipo(jTextFieldTipo.toString());
        modulo.setNivel(jTextFieldNivel.toString());
        modulo.setsubNivel(jTextFieldCurso.toString());

        
        ConexionModulo conexionmodulo=new ConexionModulo();
        conexionmodulo.ModificarModulo(modulo);*/
        
        
        /*BuscarModulo buscarmodulo = new BuscarModulo(this, true);
        buscarmodulo.setLocation((getWidth())/4,(getHeight())/8);
        buscarmodulo.setVisible(true);

        modulo=buscarmodulo.modulo;

        
        costoModulo.setText(String.valueOf(modulo.getCosto()));
        costoLibroModulo.setText(String.valueOf(modulo.getCostoLibro()));
        cantidadClases.setText(String.valueOf(modulo.getcantidadClases()));
        //sub nivel
        if(modulo.getsubNivel().equals("1"))
            subNivelModulo.setSelectedIndex(0);
        if(modulo.getsubNivel().equals("2"))
            subNivelModulo.setSelectedIndex(1);
        if(modulo.getsubNivel().equals("3"))
            subNivelModulo.setSelectedIndex(2);
        if(modulo.getsubNivel().equals("4"))
            subNivelModulo.setSelectedIndex(3);
        if(modulo.getsubNivel().equals("1+"))
            subNivelModulo.setSelectedIndex(4);
        if(modulo.getsubNivel().equals("2+"))
            subNivelModulo.setSelectedIndex(5);
        if(modulo.getsubNivel().equals("3+"))
            subNivelModulo.setSelectedIndex(6);
        if(modulo.getsubNivel().equals("4+"))
            subNivelModulo.setSelectedIndex(7);
        //nivel
        if(modulo.getNivel().equals("A1"))
            nivelModulo.setSelectedIndex(0);
        if(modulo.getNivel().equals("A2"))
            nivelModulo.setSelectedIndex(1);
        if(modulo.getNivel().equals("B1"))
            nivelModulo.setSelectedIndex(2);
        if(modulo.getNivel().equals("B2"))
            nivelModulo.setSelectedIndex(3);
        if(modulo.getNivel().equals("C1"))
            nivelModulo.setSelectedIndex(4);
            // TIPO MODULO
       
        if(modulo.getTipoModulo().equals("CURSO REGULAR"))
            tipoModulo.setSelectedIndex(0);
        if(modulo.getTipoModulo().equals("CURSO  EXTENSIVO"))
            tipoModulo.setSelectedIndex(1);
        if(modulo.getTipoModulo().equals("CURSO  PARTICULAR"))
            tipoModulo.setSelectedIndex(2);
        // tipo (destinado a)
       
        if(modulo.gettipo().equals("NIÑOS(Mâuschen)"))
            destinadoA.setSelectedIndex(0);
        if(modulo.gettipo().equals("NIÑOS(KiKu)"))
            destinadoA.setSelectedIndex(1);
        if(modulo.gettipo().equals("JOVENES"))
            destinadoA.setSelectedIndex(2);
        if(modulo.gettipo().equals("ADULTOS"))
            destinadoA.setSelectedIndex(3);
        
        */
        
        
    }//GEN-LAST:event_jButtonBuscarEstudiante1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonBuscarEstudiante;
    private javax.swing.JButton jButtonBuscarEstudiante1;
    private javax.swing.JLabel jLabelApellidoMaterno;
    private javax.swing.JLabel jLabelApellidoMaterno1;
    private javax.swing.JLabel jLabelApellidoMaterno2;
    private javax.swing.JLabel jLabelApellidoPaterno;
    private javax.swing.JLabel jLabelApellidoPaterno1;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JTextField jTextFieldApellidoMaterno;
    private javax.swing.JTextField jTextFieldApellidoPaterno;
    private javax.swing.JTextField jTextFieldCurso;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldID1;
    private javax.swing.JTextField jTextFieldModalidad;
    private javax.swing.JTextField jTextFieldNivel;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTipo;
    // End of variables declaration//GEN-END:variables
 }
