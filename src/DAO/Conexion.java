
package DAO;

import java.sql.*;


public class Conexion {
    
    public Connection conectar(){
        
        Connection con=null;
      //  Ubuntu_Mysqlpaco123
        try{            
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://127.0.0.1:3306/magicbd";
            String user="root";
            String pass="";
            con = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception ex){            
            System.out.println("Ha sido imposible crear la conexion");
        }
        
       return con; 
    }
    
    public void desconectar(Connection con){
        
        try{
            if (con!=null) con.close();
            
        } catch(Exception ex){
            
            System.out.println("Ha sido imposible cerrar la conexion");
        }
        
    }
    
}
