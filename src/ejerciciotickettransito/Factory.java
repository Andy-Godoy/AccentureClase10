package ejerciciotickettransito;

import ejerciciotickettransito.gentickets.*;

public class Factory {
    public static sensorvelocidad.Sensor crearSensorVelocidad() {
        return new sensorvelocidad.Sensor();
    }
    public static sensorclima.Sensor crearSensorClima() {
        return new sensorclima.Sensor();
    }
    private static GeneradorTicketTxt crearGeneradorTicketTxt() {
        return new GeneradorTicketTxt(
            z -> new com.google.gson.Gson().toJson(z),
            "C:\\tickets\\"
        );
    }
    public static Procesador crearProcesador() {
        GeneradorTicket generadorTicket = 
                new GeneradorTicketCompleto(
                        crearGeneradorTicketTxt(),
                        new GeneradorTicketSQL()
                );
        
        return new Procesador(generadorTicket);
    }
}
