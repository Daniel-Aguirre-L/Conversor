package listas;

public enum Moneda {
    DOLAR("USD", "Dolares"),
    EURO("EUR", "Euros"),
    PESO("COP", "Pesos Colombianos"),
    LIBRA("GBP", "Libras Esterlinas"),
    YEN("JPY", "Yenes Japoneses"),
    WON("KRW", "Wons Surcoreanos");

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
