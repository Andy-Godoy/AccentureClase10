package ejerciciotickettransito.gentickets;

import ejerciciotickettransito.Ticket;

public class GeneradorTicketMock implements GeneradorTicket {
    private boolean ticketGenerado = false;
    public void generar(Ticket t) {
        ticketGenerado = true;
    }
    public boolean isTicketGenerado() {
        return ticketGenerado;
    }
}
