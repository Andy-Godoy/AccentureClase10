package ejerciciotickettransito.gentickets;

import ejerciciotickettransito.Ticket;
import procesobatch.ConnectionFactory;
import java.sql.*;

public class GeneradorTicketSQL implements GeneradorTicket {
    public GeneradorTicketSQL() {
    }
    public void generar(Ticket t) {
        java.sql.Connection conn = null;
        
        try {
            conn = ConnectionFactory.crearConexion();
            Statement stm = conn.createStatement();
            
            StringBuilder strSQL = new StringBuilder();
        
            strSQL
                .append("INSERT INTO tickets ")
                .append("(id, patente, tipoVechiculo, velocidadMedida, importeMulta) ")
                .append("VALUES (")
                .append("'" + t.id + "'")
                .append(",'" + t.datosVehiculo.patente + "',")
                .append("'" + t.datosVehiculo.tipoVehiculo.toString() +"',")
                .append(t.datosVehiculo.velocidadMedida)
                .append(",")
                .append(t.multa)
                .append(");");
        
            System.out.println(strSQL.toString());
            stm.execute(strSQL.toString());
            stm.close();
            
            stm.execute(strSQL.toString());
            stm.close();
        }
        catch (Exception ex) {
        }
        finally {
            if (conn != null) {
                try { conn.close(); } catch (Exception ex) {}
            }
        }
    }
}
