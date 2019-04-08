package ejerciciotickettransito;

import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;

public interface Procesable {
    void procesar(
                DatosVehiculo datosvehiculo, 
                TipoClima tipoClima,
                boolean esSabado);
}
