package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

   static {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
      } 
      catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
      }
   }

   public static Connection conectar() throws SQLException {
      String servidor = "localhost";
      String porta = "3306";
      String database = "softwrap";
      String usuario = "root";
      String senha = "Softwrap2020@";
      return DriverManager
         	.getConnection("jdbc:mysql://"+servidor+":"+porta+
            "/"+database+"?user="+usuario+"&password="+senha);
   }

   public static void desconectar(Connection conn) throws SQLException {
      conn.close();
   }
}