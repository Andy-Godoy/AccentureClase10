package ejerciciotickettransito;

import sensorvelocidad.*;
import sensorclima.*;

public class Init {
    public static void main(String[] args) {
        sensorvelocidad.Sensor sensorvelocidad = Factory.crearSensorVelocidad();
        sensorclima.Sensor sensorclima = Factory.crearSensorClima();
        Procesable procesador = Factory.crearProcesador();
        
        while (true) {
            DatosVehiculo datosVehiculo = sensorvelocidad.sensarVehiculo();
            TipoClima tipoClima = sensorclima.sensar();
            boolean esSabado = (new java.util.Date().getDay() == 6);
            
            procesador.procesar(datosVehiculo, tipoClima, esSabado);            
            System.out.println(datosVehiculo);
            System.out.println(sensorclima.sensar());
        }
    }
}
