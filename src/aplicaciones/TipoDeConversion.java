package aplicaciones;

public enum TipoDeConversion {

    DIVISASONLINE ("Divisas Online"),
    DIVISAS ("Conversor de Divisas"),
    TEMPERATURA ("Conversor de Temperatura");
    private final String descripcion;

    TipoDeConversion(String descripcion) {
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
