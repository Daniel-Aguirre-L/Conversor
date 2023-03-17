package aplicaciones;

public enum Moneda {
    DOLAR("USD", "Dolar"),
    EURO("EUR", "Euro"),
    PESO("COP", "Peso Colombiano"),
    LIBRA("GBP", "LibraEsterlina"),
    YEN("JPY", "Yen Japones"),
    WON("KRW", "Won Surcoreano");

    private final String codigo;
    private final String descripcion;

    Moneda(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    @Override
    public String toString() {
        return descripcion;
    }
}
