package ejerciciotickettransito.gentickets;

import ejerciciotickettransito.Ticket;

public class GeneradorTicketCompleto implements GeneradorTicket {
    private GeneradorTicketTxt generadorTicketTxt;
    private GeneradorTicketSQL generadorTicketSQL;

    public GeneradorTicketCompleto(GeneradorTicketTxt generadorTicketTxt, GeneradorTicketSQL generadorTicketSQL) {
        this.generadorTicketTxt = generadorTicketTxt;
        this.generadorTicketSQL = generadorTicketSQL;
    }
    
    public void generar(Ticket t) {
        generadorTicketTxt.generar(t);
        generadorTicketSQL.generar(t);
    }
    
    
}
