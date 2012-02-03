package interfaces;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;

public class GestorBD {
    String login = "root";
    String password = ""; 
    String dbName = "icba";
    String serverName = "localhost";
    Connection conexion = null;
    private MysqlDataSource dataSource;
    
    public GestorBD(){
        try{
            dataSource = new MysqlDataSource();
            dataSource.setUser(login);
            dataSource.setPassword(password);
            dataSource.setDatabaseName(dbName);
            dataSource.setServerName(serverName); 
            conexion = (Connection) dataSource.getConnection();  //establecemos conexion  
            if (conexion != null) {
                System.out.println("Conexión a base de datos... Ok");
            }
        }
        catch(Exception e){
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + e);
        }
    }

    public Connection getConnection(){
        try{
            return (Connection) dataSource.getConnection();
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }      
    }
    
    //Método para realizar una consulta
    public ResultSet consulta(String SQL) throws SQLException
    {
        try {
            Statement s = (Statement) this.conexion.createStatement();  // Creamos un tipo Statement que maneja las consultas 
            return (ResultSet) s.executeQuery (SQL);    // Retorno la consulta especificada
        }
        catch(SQLException ex){
            System.out.println("Hubo un problema al intentar ingresar lo datos");
            System.out.println(ex);
            return null;
        }
    }

    
    //Método para realizar una modificacion a la BD - Insert, Update, Delete
    public void modificarBD (String SQL) throws SQLException
    {
        try {
            Statement s = (Statement) this.conexion.createStatement(); //  Creamos un tipo Statement que maneja las consultas 
            s.executeUpdate(SQL);   //  Ejecutamos sentencia
        }
        catch(SQLException ex){
            System.out.println("Hubo un problema al intentar modificar lo datos");
            System.out.println(ex);
        }
    }
    
    //Cerramos la conexión previamente abierta
    public void cerrar() throws SQLException
    {
        this.conexion.close();
    }

}
