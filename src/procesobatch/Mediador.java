package procesobatch;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mediador {
    private LectorTickets lectorTickets;
    private TicketParser ticketParser;
    private TicketRepository ticketRepository;

    public Mediador(LectorTickets lectorTickets, TicketParser ticketParser, TicketRepository ticketRepository) {
        this.lectorTickets = lectorTickets;
        this.ticketParser = ticketParser;
        this.ticketRepository = ticketRepository;
    }
    public void procesar() {
        Ticket t = null;
        while (true) {
            if (lectorTickets.hayTickets()==false) {
                try {
                    Thread.sleep(2000);
                    continue;
                } catch (InterruptedException ex) {
                }
            }
            try {
                String contenidoTicket = lectorTickets.leerTicket();            
                t = ticketParser.parse(contenidoTicket);
            
                ticketRepository.grabar(t);
                lectorTickets.notificarTransaccionRealizada(t.id);
            }
            catch (SQLIntegrityConstraintViolationException ex) {
                lectorTickets.notificarTransaccionRealizada(t.id);
            }
            catch (Exception ex) {
                System.out.println("No se pudo procesar el ticket");
                System.out.println(ex.getMessage()); 
            }
        }
    }
}
