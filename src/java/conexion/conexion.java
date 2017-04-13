package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    public Connection ConectorBd(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/ferreteria", "postgres", "system");
            return conn;
        }catch(Exception e){
            return null;
        }
    }
}
