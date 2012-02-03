package interfaces;

import com.mysql.jdbc.ResultSet;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class HorarioRegistrar extends javax.swing.JDialog {
    GestorBD bd;
    int horaIniDospuntos = 1, horaFinDospuntos = 1; 
    
    public HorarioRegistrar() {
        initComponents();
        
        limitarTams();
        bd = new GestorBD();
        bd.getConnection();
        
        jTextFieldHoraInicial.requestFocus();
        jTextFieldHoraInicial.selectAll();
    }

    public void cerrarVentana() {
        try {
            bd.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }

    public void guardarBaseDatos() throws HeadlessException {
        boolean repetido, datosIngresados, horaCorrectaIni, horaCorrectaFin, hora24Ini, hora24Fin, hora60Ini, hora60Fin,
                horaMayor;
        int registrosIni, registrosFin;
        String horaInicial = jTextFieldHoraInicial.getText();
        String horaFinal = jTextFieldHoraFinal.getText();
        String dia = String.valueOf(jComboBoxDia.getSelectedItem());
        horaCorrectaIni = false;
        horaCorrectaFin = false;
        hora24Ini = false;
        hora24Fin = false;
        hora60Ini = false;
        hora60Fin = false;
        horaMayor = false;
        try {           
            registrosIni = contarRegistros();  
            repetido = verificarPosibleRepeticion(horaInicial, horaFinal, dia); 
            
            datosIngresados = verificarCamposObligatorios(horaInicial, horaFinal);   
     
            horaCorrectaIni = formatoHora (horaInicial);
            horaCorrectaFin = formatoHora (horaFinal);
            
            hora24Ini = horaVeinticuatro(horaInicial);
            hora24Fin = horaVeinticuatro(horaFinal);
            
            hora60Ini = horaSesenta(horaInicial);
            hora60Fin = horaSesenta(horaFinal);
            
            horaMayor = horaMayor(horaInicial, horaFinal);
            
            //System.out.println(hora60Ini);
            //System.out.println(hora60Fin);
            
            if (repetido){
                JOptionPane.showMessageDialog(null,"Error al registrar: El horario ya se encuentra registrado en la base de datos","Registro de Horario",JOptionPane.INFORMATION_MESSAGE) ;
                jTextFieldHoraInicial.requestFocus();
            }
            else if (datosIngresados){
                JOptionPane.showMessageDialog(null,"Error al registrar: No se han ingreasado todos los campos obligatorios","Registro de Horario",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldHoraInicial.requestFocus();
            }   
            else if (horaCorrectaIni){
                JOptionPane.showMessageDialog(null,"Error al registrar: No se ha ingresado la hora inicial en el formato adecuado (HH:MM)","Registro de Horario",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldHoraInicial.requestFocus();
            } 
            else if (horaCorrectaFin){
                JOptionPane.showMessageDialog(null,"Error al registrar: No se ha ingresado la hora final en el formato adecuado (HH:MM)","Registro de Horario",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldHoraFinal.requestFocus();
            }
            else if (hora24Ini){
                JOptionPane.showMessageDialog(null,"Error al registrar: La hora inicial debe encontrarse en el rango de 0 a 23","Registro de Horario",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldHoraInicial.requestFocus();
            } 
            else if (hora24Fin){
                JOptionPane.showMessageDialog(null,"Error al registrar: La hora final debe encontrarse en el rango de 0 a 23","Registro de Horario",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldHoraFinal.requestFocus();
            }    
            else if (hora60Ini){
                JOptionPane.showMessageDialog(null,"Error al registrar: Los minutos deben encontrarse en el rango de 00 a 59","Registro de Horario",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldHoraInicial.requestFocus();
                jTextFieldHoraInicial.selectAll();
            } 
            else if (hora60Fin){
                JOptionPane.showMessageDialog(null,"Error al registrar: Los minutos deben encontrarse en el rango de 00 a 59","Registro de Horario",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldHoraFinal.requestFocus();
                jTextFieldHoraFinal.selectAll();
            }   
            else if (horaMayor){
                JOptionPane.showMessageDialog(null,"Error al registrar: La hora final debe ser posterior a la hora inicial","Registro de Horario",JOptionPane.INFORMATION_MESSAGE) ;   
                jTextFieldHoraInicial.requestFocus();
                jTextFieldHoraInicial.selectAll();
            }             
            else{
                String sentencia = "INSERT INTO `icba`.`horario` (`dia` ,`horaInicio` ,`horaFinal`) "
                        + "VALUES ('"+dia+"', '"+horaInicial+"', '"+horaFinal+"')";
                bd.modificarBD(sentencia);
                
                registrosFin = contarRegistros();
                
                if (registrosIni != registrosFin){
                    JOptionPane.showMessageDialog(null,"Horario registrado exitosamente","Registro de Horario",JOptionPane.INFORMATION_MESSAGE) ;
                    bd.cerrar();
                    dispose();
                }
                else
                    JOptionPane.showMessageDialog(null,"Hubo un error al intentar ingresar los datos","Registro de Horario",JOptionPane.INFORMATION_MESSAGE) ;           
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Hubo un error al intentar ingresar los datos","Registro de Horario",JOptionPane.INFORMATION_MESSAGE) ;
            //System.out.println("Hubo un problema al intentar ingresar lo datos" + ex);
        }
        catch (NumberFormatException ex){
            if (horaCorrectaIni == true){
                JOptionPane.showMessageDialog(null,"Error al registrar: La hora inicial debe tener el formato adecuado (HH:MM) y contener caracteres válidos","Registro de Horario",JOptionPane.INFORMATION_MESSAGE);
                jTextFieldHoraInicial.requestFocus();
                jTextFieldHoraInicial.selectAll();
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al registrar: La hora final debe tener el formato adecuado (HH:MM) y contener caracteres válidos","Registro de Horario",JOptionPane.INFORMATION_MESSAGE);
                jTextFieldHoraFinal.requestFocus();
                jTextFieldHoraFinal.selectAll();
            }
            //System.out.println("Hubo un problema al intentar ingresar lo datos" + ex);     
        }
        catch (StringIndexOutOfBoundsException ex){
            if (horaCorrectaIni == true){
                JOptionPane.showMessageDialog(null,"Error al registrar: La hora inicial debe tener el formato adecuado (HH:MM) y contener caracteres válidos","Registro de Horario",JOptionPane.INFORMATION_MESSAGE);
                jTextFieldHoraInicial.requestFocus();
                jTextFieldHoraInicial.selectAll();
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al registrar: La hora final debe tener el formato adecuado (HH:MM) y contener caracteres válidos","Registro de Horario",JOptionPane.INFORMATION_MESSAGE);
                jTextFieldHoraFinal.requestFocus();
                jTextFieldHoraFinal.selectAll();
            }
            //System.out.println("Hubo un problema al intentar ingresar lo datos" + ex);            
        }
    }
    
    
    public void limitarTams(){ 
        jTextFieldHoraInicial.setDocument(new JTextFieldLimit(5));
        jTextFieldHoraFinal.setDocument(new JTextFieldLimit(5));
        jTextFieldHoraInicial.setText("HH:MM");
        
        jTextFieldHoraFinal.setText("HH:MM");
    }

    public int contarRegistros(){
        String sentencia = "Select Count(*) From `icba`.`horario` ";
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
    
    public boolean verificarPosibleRepeticion(String horaInicial, String horaFinal, String dia){
        String sentencia = "Select * From `icba`.`horario` "
                    + "Where horaInicio = '"+horaInicial+"' AND  horaFinal = '"+horaFinal+"' AND dia = '"+dia+"'";
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
    
    
    public boolean verificarCamposObligatorios(String horaInicial,String horaFinal){
        if ("".equals(horaInicial) || "".equals(horaFinal))
            return true;
        return false;
    }     
    
    public boolean formatoHora (String hora){
        if ((hora.indexOf("H") >= 0) || (hora.indexOf("M") >= 0) || hora.indexOf(":") < 0 || hora.length()<5) 
            return true;
        else
            return false;
    }
        
    public boolean horaVeinticuatro(String hora){
        int horaEntera = Integer.parseInt(hora.substring(0, 2));
        
        //System.out.println(horaEntera);
        if (horaEntera > 23 || horaEntera < 0)
            return true;
        else
            return false;
    }
    
    public boolean horaSesenta(String hora){
        int horaEntera = Integer.parseInt(hora.substring(3, 5));
        
        //System.out.println(horaEntera);
        if (horaEntera > 59 || horaEntera < 0){
            return true;  
        }   
        else
            return false;
    }
   
    public boolean horaMayor(String horaIni, String horaFin){
        int horaEnteraIni = Integer.parseInt(horaIni.substring(0, 2));
        int horaEnteraFin = Integer.parseInt(horaFin.substring(0, 2));
        
        System.out.println(horaEnteraIni);
        System.out.println(horaEnteraFin);
        
        if (horaEnteraIni > horaEnteraFin)
            return true;  
        else{
            if (horaEnteraIni < horaEnteraFin)
                return false;
            else{
                horaEnteraIni = Integer.parseInt(horaIni.substring(3, 5));
                horaEnteraFin = Integer.parseInt(horaFin.substring(3, 5));

                System.out.println(horaEnteraIni);
                System.out.println(horaEnteraFin);

                if (horaEnteraIni >= horaEnteraFin)
                    return true;  
                else
                    return false;                
            }
        }    
    }    
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxDia = new javax.swing.JComboBox();
        jTextFieldHoraFinal = new javax.swing.JTextField();
        jTextFieldHoraInicial = new javax.swing.JTextField();
        jLabelDia = new javax.swing.JLabel();
        jLabelHoraFinal = new javax.swing.JLabel();
        jLabelHoraInicial = new javax.swing.JLabel();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Horario");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Horario"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" }));
        jComboBoxDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxDiaKeyPressed(evt);
            }
        });
        jPanel2.add(jComboBoxDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 130, -1));

        jTextFieldHoraFinal.setText("HH:MM");
        jTextFieldHoraFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldHoraFinalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHoraFinalKeyTyped(evt);
            }
        });
        jPanel2.add(jTextFieldHoraFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, -1));

        jTextFieldHoraInicial.setText("HH:MM");
        jTextFieldHoraInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldHoraInicialKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHoraInicialKeyTyped(evt);
            }
        });
        jPanel2.add(jTextFieldHoraInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 130, -1));

        jLabelDia.setText("Día");
        jPanel2.add(jLabelDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabelHoraFinal.setText("Hora Final");
        jPanel2.add(jLabelHoraFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabelHoraInicial.setText("Hora Inicial");
        jPanel2.add(jLabelHoraInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 190));

        jButtonRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar1.JPG"))); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setBorderPainted(false);
        jButtonRegistrar.setContentAreaFilled(false);
        jButtonRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        jPanel1.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 170, 100));

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
        jPanel1.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 241, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 360));

        pack();
    }//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        cerrarVentana();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        guardarBaseDatos();
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jTextFieldHoraInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHoraInicialKeyTyped
        validarHoraInicial(evt);
    }//GEN-LAST:event_jTextFieldHoraInicialKeyTyped

    private void jTextFieldHoraInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHoraInicialKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER)){
            jTextFieldHoraFinal.requestFocus();
            jTextFieldHoraFinal.selectAll();
        }
    }//GEN-LAST:event_jTextFieldHoraInicialKeyPressed

    private void jTextFieldHoraFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHoraFinalKeyTyped
        validarHoraFinal(evt);
    }//GEN-LAST:event_jTextFieldHoraFinalKeyTyped

    private void jTextFieldHoraFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHoraFinalKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jComboBoxDia.requestFocus();
    }//GEN-LAST:event_jTextFieldHoraFinalKeyPressed

    private void jComboBoxDiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxDiaKeyPressed
        if((evt.getKeyCode()== KeyEvent.VK_ENTER))
            jButtonRegistrar.requestFocus();
    }//GEN-LAST:event_jComboBoxDiaKeyPressed

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

    
    public void validarHoraInicial(KeyEvent evt){
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)&&(caracter!=':'))
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);// ignorar el evento de teclado       
        else    //si contiene menos de 3 caracteres
            if ((caracter==':') && (jTextFieldHoraInicial.getText().length() < 2)){
                //System.out.println(String.valueOf(jTextFieldHoraInicial.getText().length()));
                evt.setKeyChar((char)KeyEvent.VK_CLEAR);
            }
        else    //si contiene menos de 3 caracteres
            if ((caracter==':') && (jTextFieldHoraInicial.getText().length() > 2) && (jTextFieldHoraInicial.getText().indexOf(":") > 0))
                evt.setKeyChar((char)KeyEvent.VK_CLEAR);
        else    //si ingresaron ya : 
            if ((caracter==':') && (jTextFieldHoraInicial.getText().indexOf(":") >= 0))
                evt.setKeyChar((char)KeyEvent.VK_CLEAR); 

            
    }
    
    public void validarHoraFinal(KeyEvent evt){
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)&&(caracter!=':'))
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);// ignorar el evento de teclado       
        else
            if ((caracter==':') && jTextFieldHoraFinal.getText().indexOf(":") >= 0)
                evt.setKeyChar((char)KeyEvent.VK_CLEAR);// ignorar el evento de teclado 
        
    }    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JComboBox jComboBoxDia;
    private javax.swing.JLabel jLabelDia;
    private javax.swing.JLabel jLabelHoraFinal;
    private javax.swing.JLabel jLabelHoraInicial;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldHoraFinal;
    private javax.swing.JTextField jTextFieldHoraInicial;
    // End of variables declaration//GEN-END:variables
}