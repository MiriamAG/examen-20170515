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
public class CorredorBD {

    public List<Corredor> listaCorredores() {

        List<Corredor> lista = new ArrayList<>();

        Connection conexion = GestorBD.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM corredores";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Corredor c = new Corredor(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getInt("dorsal"),
                        rs.getInt("categoria")
                );

                lista.add(c);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

        return lista;

    }

    public void insertarCorredor(Corredor corredor) {

        Connection conexion = GestorBD.conectar();

        try {

            String sql = "INSERT INTO corredores VALUES (?,?,?,?)";

            PreparedStatement st = conexion.prepareStatement(sql);

            st.setNull(1, java.sql.Types.NULL);
            st.setString(2, corredor.getNombre());
            st.setInt(3, corredor.getDorsal());
            st.setInt(4, corredor.getCategoria());

            int filas = st.executeUpdate();
            if (filas == 1) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    corredor.setId(rs.getInt(1));
                }
            }
            
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        GestorBD.desconectar();

    }

}
