package dto;

public class Cliente extends Persona{

    private String dni;
    private String telefono;

    public Cliente(int id, String nombre, String dni, String telefono) {
        super(id, nombre);
        this.dni = dni;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return nombre + " - " + dni;
    }
}