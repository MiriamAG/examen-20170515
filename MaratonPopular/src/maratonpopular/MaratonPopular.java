package maratonpopular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author widemos
 */
public class MaratonPopular {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            String controlador = "org.sqlite.JDBC";
            String cadenaconex = "jdbc:sqlite:bd/corredores.sqlite";

            Class.forName(controlador);
            Connection cn;
            cn = DriverManager.getConnection(cadenaconex);
            Statement st = cn.createStatement();
            String sql1 = "SELECT * FROM corredores";
            ResultSet rs = st.executeQuery(sql1);

            while (rs.next()) {
                System.out.print("Nombre: " + rs.getString("nombre"));
                System.out.println(" Edad: " + rs.getString("edad"));
                System.out.println(" Dorsal: " + rs.getString("dorsal"));
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Controlador no válido");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
