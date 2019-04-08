package ejerciciotickettransito;

import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;

public class ProcesadorLogger implements Procesable {
    
    private Procesable __procesar;
    private String pathLogger;

    public ProcesadorLogger(Procesable __procesar, String pathLogger) {
        this.__procesar = __procesar;
        this.pathLogger = pathLogger;
    }
    
    public void procesar(DatosVehiculo datosvehiculo, TipoClima tipoClima, boolean esSabado) {
        // Toda la logica del logger
        // una vez que finaliza ahi le patea la pelota al procesar posta
        __procesar.procesar(datosvehiculo, tipoClima, esSabado);
    }
}
