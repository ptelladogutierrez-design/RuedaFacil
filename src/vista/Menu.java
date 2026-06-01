package vista;

import dao.VehiculoDAO;
import dto.Vehiculo;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    VehiculoDAO dao = new VehiculoDAO();

    public void iniciar() {

        int opcion;

        do {

            System.out.println("\n=== RUEDAFACIL ===");
            System.out.println("1. Gestionar vehículos");
            System.out.println("2. Gestionar clientes");
            System.out.println("3. Gestionar alquileres");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    menuVehiculos();

                    break;

                case 2:

                    System.out.println("Módulo clientes pendiente");

                    break;

                case 3:

                    System.out.println("Módulo alquileres pendiente");

                    break;

                case 4:

                    System.out.println("Saliendo...");

                    break;

                default:

                    System.out.println("Opción no válida");
            }

        } while (opcion != 4);
    }

    public void menuVehiculos() {

        int opcion;

        do {

            System.out.println("\n--- VEHÍCULOS ---");
            System.out.println("1. Ver vehículos");
            System.out.println("2. Añadir vehículo");
            System.out.println("3. Eliminar vehículo");
            System.out.println("4. Volver");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    mostrarVehiculos();

                    break;

                case 2:

                    insertarVehiculo();

                    break;

                case 3:

                    eliminarVehiculo();

                    break;

                case 4:

                    break;

                default:

                    System.out.println("Opción no válida");
            }

        } while (opcion != 4);
    }

    public void mostrarVehiculos() {

        ArrayList<Vehiculo> vehiculos = dao.obtenerVehiculos();

        System.out.println("\n--- LISTA DE VEHÍCULOS ---");

        for (Vehiculo v : vehiculos) {

            System.out.println(v);
        }
    }

    public void insertarVehiculo() {

        sc.nextLine();

        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Precio por día: ");
        double precio = sc.nextDouble();

        Vehiculo v = new Vehiculo(
                0,
                matricula,
                marca,
                modelo,
                precio,
                "Disponible"
        );

        dao.insertarVehiculo(v);
    }

    public void eliminarVehiculo() {

        System.out.print("ID del vehículo a eliminar: ");

        int id = sc.nextInt();

        dao.eliminarVehiculo(id);
    }

}
