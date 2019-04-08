package ejerciciotickettransito.gentickets;

import ejerciciotickettransito.ConversoraJSON;
import ejerciciotickettransito.Ticket;
import java.io.FileWriter;

public class GeneradorTicketTxt implements GeneradorTicket {
    private ConversoraJSON conversoraJSON;
    private String pathTickets;

    public GeneradorTicketTxt(ConversoraJSON conversoraJSON, String pathTickets) {
        this.conversoraJSON = conversoraJSON;
        this.pathTickets = pathTickets;
    }
    public void generar(Ticket t) {
        FileWriter escritorArchivo = null;
        try {
            String path = pathTickets + t.id + ".log";
            escritorArchivo = new FileWriter(path);
            escritorArchivo.write(conversoraJSON.convertir(t));
            escritorArchivo.flush();
        }
        catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        finally {
            if (escritorArchivo != null) {
                try { escritorArchivo.close(); } catch (Throwable tr) {}
            }
        }
    }
}
