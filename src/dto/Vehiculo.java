package dto;

public class Vehiculo {

    private int id;
    private String matricula;
    private String marca;
    private String modelo;
    private double precioDia;
    private String estado;
    private int idCategoria;

    public Vehiculo() {
    }

    public Vehiculo(int id, String matricula, String marca,
                    String modelo, double precioDia,
                    String estado, int idCategoria) {

        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precioDia = precioDia;
        this.estado = estado;
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public String getEstado() {
        return estado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    @Override
    public String toString() {

        return id + " - " + matricula + " - " +
                marca + " - " + modelo +
                " - " + estado;
    }
}