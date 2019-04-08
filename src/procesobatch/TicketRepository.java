package procesobatch;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TicketRepository {
    private java.sql.Connection conn;

    public TicketRepository(Connection conn) {
        this.conn = conn;
    }    
    public void grabar(Ticket t) throws SQLException {
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
    }
}
