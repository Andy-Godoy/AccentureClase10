package ejerciciotickettransito;

import sensorclima.TipoClima;
import sensorvelocidad.TipoVehiculo;

public class Limites {
    private static int[][] limites = {{130,110,90},{90,80,70},{130,110,90},{60,60,60}};

    public static int obtenerLimite(TipoVehiculo v, TipoClima c) {
        return limites[v.ordinal()][c.ordinal()];
    }
}
