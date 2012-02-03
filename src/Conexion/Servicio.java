/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexion;

/**
 *
 * @author General
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Programador
 */
public class Servicio {
     Connection conexion = null;
     Statement sqlstatement;
    /*
     */
    public Connection getConexion(){
        return this.conexion;
    }
    public void conectarse()
    {

        try {

            if(conexion == null || conexion.isClosed()){



                   try{Class.forName("oracle.jdbc.OracleDriver") ;

                        try{
                        conexion = DriverManager.getConnection(
                                                 "jdbc:oracle:thin:@192.168.153.128:1521:ICBA",
                                                 "USERICBA","USERICBA");

                        }catch(SQLException q){
                        q.printStackTrace();
                        System.out.println("Error al crear la conexion");
                        }
                      }catch(ClassNotFoundException e){
                        System.out.println("Error al cargar el Driver");
                        e.printStackTrace(); }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("conexion exitosa");
    }

    public void desconectarse(){
        try{
            conexion.close();
            sqlstatement.close();
        }catch(Exception e){
            System.out.println("Error al desconectarse de la BD");
        }
    }
    public ResultSet ConsultarDatosTabla(String sql) throws SQLException
    {   ResultSet resultado=null;
        if( getConexion() !=null)
        {

                sqlstatement=conexion.createStatement();
                resultado=sqlstatement.executeQuery(sql);


        }

     return resultado;
    }
    public boolean IngresarDatos(String sql) throws SQLException
    {

        if( getConexion() !=null)
        {

            sqlstatement=conexion.createStatement();
            sqlstatement.executeUpdate(sql);
            return true;
        }else
        {

        return false;
        }
    }
}