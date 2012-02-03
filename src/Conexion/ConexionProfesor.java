/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexion;

import Entidades.Profesor;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor Hugo
 */
public class ConexionProfesor {
    GestorBD ser;
    //Servicio ser;

    public ConexionProfesor()
    {
        //ser=new Servicio();
        ser=new GestorBD();
    }
    public void MostrarProfesor() throws SQLException
    {
        System.out.print("entro a mostrar Profesor");
      ResultSet resultad;
      try{
      resultad=  ser.consulta("SELECT * FROM EMPLEADO");
      while(resultad.next())
      {
            System.out.print(resultad.getString(1));
      }

      }catch(SQLException e)
      {
          System.out.println("no pudo recuperar resultado");
      }
       ser.cerrar();
    }
    public void Borrar()
    {
        System.out.println("booooorarrr");
    }
    public  void CrearProfesor(Profesor profe)
    {boolean resul;
                ser.getConnection();
                
                 
//                String dato="INSERT INTO `icba`.`empleado` VALUES (NULL, 'BBBB', 'BBBB', 'BBBB', '2222', '2222', '2222', 'BBBB', 'BBB@BBB.COM', NULL, NULL, '', NULL, NULL)";
                  String dato="INSERT INTO `icba`.`empleado` VALUES (NULL, '"+profe.getNombre()+"','"+profe.getApPaterno()+"','"+profe.getApMaterno()+"','"+profe.getCIProfesor()+"','"+profe.getTelefono()+"','"+profe.getCelular()+"','"+profe.getDireccion()+"','"+profe.getEmail()+"','"+profe.getFechaNacimiento()+"','"+"NULL"+"','P','"+"NULL"+"','"+"NULL"+"');";

                 System.out.println(dato);
                //String dato="INSERT INTO `icba`.`empleado` (`idEmpleado`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `ci`, `telefono`, `celular`, `direccion`, `email`, `fechaNacimiento`, `lugarNacimiento`, `tipoUsuario`, `login`, `password`) VALUES (NULL, 'miguel', 'cardozo', 'zabala', '3454274', '444', '5005', 'pacata', 'general', '2011-10-11', NULL, 'P', NULL, NULL);";

                try {
                    System.out.println("antes");
                       ser.modificarBD(dato);
                    System.out.println("despues");
                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null,"Error al grabar intente de nuevo o consulte con su administrador","Error al grabar",JOptionPane.INFORMATION_MESSAGE) ;
                }

                JOptionPane.showMessageDialog(null,"Se registro un nuevo cliente","Registro de Cliente",JOptionPane.INFORMATION_MESSAGE) ;

    }
    public void ModificarCliente(Profesor profe)
    {
        boolean resul;
        ser.getConnection();

        String dato="update cliente set DIRECCION='"+profe.getDireccion()+"',TELEFONO='"+profe.getTelefono()+"',CELULAR='"+profe.getCelular()+"',NOMBRE='"+profe.getNombre()+"',APELLIDO_PAT='"+profe.getApPaterno()+"',APELLIDO_MAT='"+profe.getApMaterno()+"' where PK_CLIENTE='"+profe.getCIProfesor()+"'";
        try {

                  ser.modificarBD(dato);
                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null,"Error al grabar intente de nuevo o consulte con su administrador","Error al grabar",JOptionPane.INFORMATION_MESSAGE) ;
                }

                JOptionPane.showMessageDialog(null,"Se modifico datos del  cliente","Modificar Cliente Cliente",JOptionPane.INFORMATION_MESSAGE) ;

    }
}
