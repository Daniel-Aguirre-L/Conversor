package listas;

public enum Temperatura {
    CELSIUS ("Celsius"),
    FAHRENHEIT ("Fahrenheit"),
    KELVIN ("Kelvin");
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
