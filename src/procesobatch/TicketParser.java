package procesobatch;

import com.google.gson.Gson;

public class TicketParser {
    com.google.gson.Gson gson;

    public TicketParser() {
        gson = new Gson();
    }
    public Ticket parse(String s) {
        Ticket t = gson.fromJson(s, Ticket.class);
        return t;
    }
}
