package procesobatch;

import java.sql.Connection;

public class Factory {
    public static Mediador getMediador() throws Exception {
        Connection conn = ConnectionFactory.crearConexion();
        
        LectorTickets lectorTickets = new LectorTickets("c:\\tickets");
        TicketParser ticketParser = new TicketParser();
        TicketRepository ticketRepository = new TicketRepository(conn);
        
        return new Mediador(lectorTickets, ticketParser, ticketRepository);
    }
}
