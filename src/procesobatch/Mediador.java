package procesobatch;

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
                Ticket t = ticketParser.parse(contenidoTicket);
            
                ticketRepository.grabar(t);
                lectorTickets.notificarTransaccionRealizada(t.id);
            }
            catch (Exception ex) {
                System.out.println("No se pudo procesar el ticket");
            }
        }
    }
}
