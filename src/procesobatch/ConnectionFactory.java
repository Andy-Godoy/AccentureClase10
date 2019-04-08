package procesobatch;

import java.sql.*;

public class ConnectionFactory {
    public static Connection crearConexion() throws Exception {
        try {
            String url = "jdbc:mysql://localhost/accclase10?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(url, "root", "");
            
            return conn;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}
