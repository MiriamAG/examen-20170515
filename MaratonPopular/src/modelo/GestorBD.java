package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author widemos
 */
public class GestorBD {

    private static Connection conexion;

    public static Connection conectar() {

        if (conexion == null) {
            try {
                String controlador = "org.sqlite.JDBC";
                String cadenaconex = "jdbc:sqlite:bd/corredores.sqlite";

                Class.forName(controlador);
                conexion = DriverManager.getConnection(cadenaconex);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return conexion;
    }

    public static void desconectar() {

        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
