package ejerciciotickettransito;

import sensorvelocidad.DatosVehiculo;

public class Ticket {
    public final String id;
    public final  DatosVehiculo datosVehiculo;
    public final int multa;

    public Ticket(DatosVehiculo datosVehiculo, int multa) {
        id = java.util.UUID.randomUUID().toString();
        this.datosVehiculo = datosVehiculo;
        this.multa = multa;
    }
}
