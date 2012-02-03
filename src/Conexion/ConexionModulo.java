/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexion;

import Entidades.Modulo;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author General
 */
public class ConexionModulo {
GestorBD ser;
    //Servicio ser;

    public ConexionModulo()
    {
        //ser=new Servicio();
        ser=new GestorBD();
    }
    public void MostrarProfesor() throws SQLException
    {
        System.out.print("entro a mostrar MODULO");
      ResultSet resultad;
      try{
      resultad=  ser.consulta("SELECT * FROM MODULO");
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
    public  void CrearModulo(Modulo mod)
    {boolean resul;
                ser.getConnection();

            String dato="INSERT INTO `icba`.`modulo` VALUES (NULL, '"+mod.gettipo()+"','"+mod.getNivel()+"','"+mod.getsubNivel()+"','"+mod.getcantidadClases()+"','"+mod.getCosto()+"','"+mod.getTipoModulo()+"','"+mod.getfechaInicio()+"','"+mod.getfechaFin()+"');";
            try {
                       ser.modificarBD(dato);
                    
                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null,"Error al grabar intente de nuevo o consulte con su administrador","Error al grabar",JOptionPane.INFORMATION_MESSAGE) ;
                }

                

    }
    public void ModificarModulo(Modulo profe)
    {
        boolean resul;
        ser.getConnection();

        String dato="update modulo set tipo='"+profe.gettipo()+"',nivel='"+profe.getNivel()+"',subnivel='"+profe.getsubNivel()+"',cantidadClases='"+profe.getcantidadClases()+"',costo='"+profe.getCosto()+"',tipoModulo='"+profe.getTipoModulo()+"',fechaInicio='"+profe.getfechaInicio()+"',fechaFin='"+profe.getfechaFin()+"' where idModulo='"+profe.idModulo()+"'";
        
        try {

                  ser.modificarBD(dato);
                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null,"Error al grabar intente de nuevo o consulte con su administrador","Error al grabar",JOptionPane.INFORMATION_MESSAGE) ;
                }

                JOptionPane.showMessageDialog(null,"Se modifico datos del  cliente","Modificar Cliente Cliente",JOptionPane.INFORMATION_MESSAGE) ;

    }
}
