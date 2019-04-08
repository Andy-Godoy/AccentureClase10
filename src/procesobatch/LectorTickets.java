package procesobatch;

import java.io.File;
import java.io.FileNotFoundException;

public class LectorTickets {
    private String path;

    public LectorTickets(String path) {
        this.path = path;
    }
    public boolean hayTickets() {
        File carpeta = new File(path);
        if (!carpeta.isDirectory()) {
            throw new RuntimeException("Cuidado que no me pasaste una carpeta");
        }
        String[] listaArchivos = carpeta.list();
        
        return (listaArchivos.length > 0);
    }
    public String leerTicket() throws Exception {
        File carpeta = new File(path);
        String[] listaArchivos = carpeta.list();
        
        java.io.FileReader lectorArchivo = new java.io.FileReader(this.path + "\\" + listaArchivos[0]);
        java.io.BufferedReader lector = new java.io.BufferedReader(lectorArchivo);
        
        String ret = lector.readLine();
        lector.close();
        
        return ret;
    }
    public void notificarTransaccionRealizada(String id) {
        String path = this.path + "\\" + id + ".log";
        new File(path).delete();
    }
}
