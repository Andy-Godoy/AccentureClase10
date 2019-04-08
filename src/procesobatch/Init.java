package procesobatch;

import java.sql.*;

public class Init {
    public static void main(String[] args) throws Exception {
        Factory.getMediador().procesar();
    }
}
