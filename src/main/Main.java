package main;

import dao.VehiculoDAO;
import dto.Vehiculo;

public class Main {

    public static void main(String[] args) {

        Vehiculo v1 = new Vehiculo(
                0,
                "5678DEF",
                "Toyota",
                "Corolla",
                45,
                "Disponible"
        );

        VehiculoDAO dao = new VehiculoDAO();

        dao.insertarVehiculo(v1);

        dao.mostrarVehiculos();
    }
}