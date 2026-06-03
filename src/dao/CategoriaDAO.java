package dao;

import conexion.ConexionBD;
import dto.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriaDAO {

    public void insertarCategoria(Categoria c) {

        String sql = "INSERT INTO categoria(nombre) VALUES (?)";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, c.getNombre());

            ps.executeUpdate();

            System.out.println("Categoria añadida");

        } catch (Exception e) {

            System.out.println("Error al insertar categoria");
        }
    }

    public ArrayList<Categoria> obtenerCategorias() {

        ArrayList<Categoria> lista = new ArrayList<>();

        String sql = "SELECT * FROM categoria";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Categoria c = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre")
                );

                lista.add(c);
            }

        } catch (Exception e) {

            System.out.println("Error al obtener categorias");
        }

        return lista;
    }
}