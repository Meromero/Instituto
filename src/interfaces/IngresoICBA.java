package interfaces;

public class IngresoICBA extends javax.swing.JDialog {

    public IngresoICBA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        jButtonIniciarSesion = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        PasswordIngreso = new javax.swing.JPasswordField();
        UsuarioIngreso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonLogo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Instituto Cultural Boliviano Alemán");
        setBackground(java.awt.Color.white);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonIniciarSesion.setBackground(new java.awt.Color(255, 255, 255));
        jButtonIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ingresar.jpg"))); // NOI18N
        jButtonIniciarSesion.setText("Iniciar Sesión");
        jButtonIniciarSesion.setBorderPainted(false);
        jButtonIniciarSesion.setContentAreaFilled(false);
        jButtonIniciarSesion.setFocusPainted(false);
        jButtonIniciarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonIniciarSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 95, 120));

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar2.jpg"))); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.setFocusPainted(false);
        jButtonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 98, 110));

        PasswordIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 200, 29));

        UsuarioIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(UsuarioIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 200, 29));

        jLabel2.setFont(new java.awt.Font("Harrington", 0, 24));
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        jLabel1.setFont(new java.awt.Font("Harrington", 0, 24));
        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        jButtonLogo.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icbaPeq.jpg"))); // NOI18N
        jButtonLogo.setBorderPainted(false);
        jButtonLogo.setContentAreaFilled(false);
        jButtonLogo.setFocusPainted(false);
        jPanel1.add(jButtonLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 190, 130));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 510));

        pack();
    }//GEN-END:initComponents

    private void PasswordIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordIngresoActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_PasswordIngresoActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        System.exit(1);
}//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarSesionActionPerformed
        String dato;
     /* entidadusuario=new EntidadUsuario();
               ser = new Servicio();
            ser.conectarse();
      try{

                     ResultSet resultad;

            //dato ="SELECT * FROM usuario where pk_usuario ='"+dato+"' and  password='"+dato+"'";
      dato ="SELECT * FROM usuario where pk_usuario ='"+datoobtenido+"'";
            resultad=  ser.ConsultarDatosTabla(dato);
      //ResultSetMetaData rsmd = resultad.getRow()


      while(resultad.next())
      {

            entidadusuario.setLoginUsuario(resultad.getString(1));
            entidadusuario.setPasswordUsuario(resultad.getString(2));


      }
         }catch(SQLException e)
      {
          System.out.println("no pudo recuperar resultado");
      }


      if(entidadusuario.getLoginUsuario().equals(datoobtenido))
      {*/
        hide();
      /*}
      else
      {
                JOptionPane.showMessageDialog(null,"Ingreso mal el Usuario o la contraseña","Error al ingreso",JOptionPane.INFORMATION_MESSAGE) ;
      }*/



        // TODO add your handling code here:
}//GEN-LAST:event_jButtonIniciarSesionActionPerformed

    private void UsuarioIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioIngresoActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_UsuarioIngresoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IngresoICBA dialog = new IngresoICBA(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordIngreso;
    private javax.swing.JTextField UsuarioIngreso;
    private javax.swing.JButton jButtonIniciarSesion;
    private javax.swing.JButton jButtonLogo;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
