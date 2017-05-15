/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author widemos
 */
public class CarreraBD {

    public List<Carrera> listaCarreras() {

        List<Carrera> lista = new ArrayList<>();

        Connection conexion = GestorBD.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM carreras";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Carrera c = new Carrera(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getDouble("distancia")
                );

                lista.add(c);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

        return lista;

    }

    public void insertarCarrera(Carrera carrera) {

        Connection conexion = GestorBD.conectar();

        try {

            String sql = "INSERT INTO carreras VALUES (?,?,?)";

            PreparedStatement st = conexion.prepareStatement(sql);

            st.setNull(1, java.sql.Types.NULL);
            st.setString(2, carrera.getNombre());
            st.setDouble(3, carrera.getDistancia());

            int filas = st.executeUpdate();
            if (filas == 1) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    carrera.setId(rs.getInt(1));
                }
            }

            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

    }

}
