package aplicaciones;

public enum Temperatura {
    CELSIUS ("Grados Celsius"),
    FAHRENHEIT ("Grados Fahrenheit");
    private final String descripcion;

    Temperatura (String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
}
