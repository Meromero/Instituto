package interfaces;

import Conexion.ConexionModulo;
import Entidades.Modulo;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InscripcionEstudianteRegistrar extends javax.swing.JDialog {
    GestorBD bd;
    Modulo modulo;
    int idEstudiante;
    int idModulo;
    
    
    public InscripcionEstudianteRegistrar() {
        initComponents();
        bd = new GestorBD(); 
        bd.getConnection();  
        idEstudiante = -1;
        idModulo = -1;
    }
  
    public void cerrarVentana() {
        try {
            bd.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanelFondo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelNombre1 = new javax.swing.JLabel();
        jLabelApellidoPaterno1 = new javax.swing.JLabel();
        jTextFieldNivel = new javax.swing.JTextField();
        jTextFieldCurso = new javax.swing.JTextField();
        jButtonBuscarModulo = new javax.swing.JButton();
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
        jButtonBuscarEstudiante = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inscripcion");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Modulo"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombre1.setText("Nivel");
        jPanel2.add(jLabelNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabelApellidoPaterno1.setText("Curso");
        jPanel2.add(jLabelApellidoPaterno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jTextFieldNivel.setEditable(false);
        jPanel2.add(jTextFieldNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 220, -1));

        jTextFieldCurso.setEditable(false);
        jPanel2.add(jTextFieldCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 220, -1));

        jButtonBuscarModulo.setText("Buscar");
        jButtonBuscarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarModuloActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBuscarModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        jTextFieldModalidad.setEditable(false);
        jPanel2.add(jTextFieldModalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 220, -1));

        jLabelApellidoMaterno1.setText("Modalidad");
        jPanel2.add(jLabelApellidoMaterno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabelApellidoMaterno2.setText("Tipo");
        jPanel2.add(jLabelApellidoMaterno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jTextFieldTipo.setEditable(false);
        jPanel2.add(jTextFieldTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 220, -1));

        jPanelFondo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 560, 170));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Estudiante"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombre.setText("Nombre");
        jPanel1.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabelApellidoMaterno.setText("Apellido Materno");
        jPanel1.add(jLabelApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jTextFieldApellidoMaterno.setEditable(false);
        jPanel1.add(jTextFieldApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 220, -1));

        jLabelApellidoPaterno.setText("Apellido Paterno");
        jPanel1.add(jLabelApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jTextFieldNombre.setEditable(false);
        jPanel1.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 220, -1));

        jTextFieldApellidoPaterno.setEditable(false);
        jPanel1.add(jTextFieldApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 220, -1));

        jButtonBuscarEstudiante.setText("Buscar");
        jButtonBuscarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarEstudianteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        jPanelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 560, 160));

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inscripcion.jpg"))); // NOI18N
        jButtonGuardar.setText("Inscribir");
        jButtonGuardar.setBorderPainted(false);
        jButtonGuardar.setContentAreaFilled(false);
        jButtonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jPanelFondo.add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 160, 130));

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
        jPanelFondo.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 160, 130));

        getContentPane().add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 540));

        pack();
    }//GEN-END:initComponents

    private void jButtonBuscarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarEstudianteActionPerformed
        InscripcionBuscarEstudiante buscar = new InscripcionBuscarEstudiante();
        buscar.setModal(true);
        buscar.setVisible(true); 
       
        idEstudiante = buscar.alumno;
        //jTextFieldID.setText(String.valueOf(idEstudiante));
       
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
            }
            rs.close();
         
            //bd.cerrar();              
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al consultar la base de datos" + ex);
        }        
    }//GEN-LAST:event_jButtonBuscarEstudianteActionPerformed

    private void jButtonBuscarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarModuloActionPerformed
        InscripcionBuscarModulo buscar = new InscripcionBuscarModulo();
        buscar.setModal(true);
        buscar.setVisible(true); 
       
        idModulo = buscar.modulo;
        //jTextFieldID1.setText(String.valueOf(idModulo));
        
        try {
            ResultSet rs = bd.consulta("SELECT * FROM `icba`.`modulo` WHERE idModulo = "+idModulo);

            while (rs.next()){
            String modalidad = rs.getString("tipoModulo");
            jTextFieldModalidad.setText(modalidad);
            
            String tipo = rs.getString("tipo");
            jTextFieldTipo.setText(tipo);
            
            String nivel = rs.getString("nivel");
            jTextFieldNivel.setText(nivel);
            
            String curso = rs.getString("subnivel");
            jTextFieldCurso.setText(curso);
            }
            rs.close();
         
            //bd.cerrar();              
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al consultar la base de datos" + ex);
        }
    }//GEN-LAST:event_jButtonBuscarModuloActionPerformed

    public int contarRegistros(){
        String sentencia = "Select Count(*) From `icba`.`inscripcion` ";
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
    
    public boolean verificarPosibleRepeticion(){
        String sentencia = "Select * From `icba`.`inscripcion` "
                    + "WHERE idEstudiante = " + idEstudiante + " AND idAsignacion = " + idModulo;
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
    
    public boolean verificarCamposObligatorios(){
        if (idEstudiante == -1 || idModulo == -1)
            return true;
        return false;
    }
    
    public void guardarBaseDatos() {
        boolean repetido, datosIngresados;
        int registrosIni, registrosFin;
              
        try {           
            registrosIni = contarRegistros();
            datosIngresados = verificarCamposObligatorios();
            
            if (datosIngresados){
                JOptionPane.showMessageDialog(null,"Error: No se han ingresado todos los campos obligatorios","Inscripción de Estudiante",JOptionPane.INFORMATION_MESSAGE) ;   
            }
            else{
                repetido = verificarPosibleRepeticion();
                
                if (repetido){
                    JOptionPane.showMessageDialog(null,"Error: El estudiante ya se encuentra inscrito en el modulo","Inscripción de Estudiante",JOptionPane.INFORMATION_MESSAGE) ;          
                    jTextFieldNombre.requestFocus();
                } 
                else{
                    String sentencia = "INSERT INTO `icba`.`inscripcion` (idEstudiante, idAsignacion) "
                            + "VALUES ("+idEstudiante+","+idModulo+")";
                    bd.modificarBD(sentencia);

                    registrosFin = contarRegistros();

                    if (registrosIni != registrosFin){
                        JOptionPane.showMessageDialog(null,"Estudiante inscrito exitosamente","Inscripción de Estudiante",JOptionPane.INFORMATION_MESSAGE) ;
                        bd.cerrar();
                        dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Hubo un error al intentar ingresar los datos a la base de datos","Inscripción de Estudiante",JOptionPane.INFORMATION_MESSAGE) ;           
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Hubo un error al intentar ingresar los datos a la base de datos","Inscripción de Estudiante",JOptionPane.INFORMATION_MESSAGE) ;
            System.out.println("Hubo un problema al intentar ingresar los datos a la base de datos" + ex);
        }
    }
    
    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        guardarBaseDatos();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        cerrarVentana();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarEstudiante;
    private javax.swing.JButton jButtonBuscarModulo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardar;
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
    private javax.swing.JTextField jTextFieldModalidad;
    private javax.swing.JTextField jTextFieldNivel;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTipo;
    // End of variables declaration//GEN-END:variables
 }