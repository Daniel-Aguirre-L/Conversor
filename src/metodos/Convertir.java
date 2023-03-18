package metodos;

public class Convertir {

    public static double convertirTemperatura(double valor, String medidaInicial, String medidaFinal) {
        double resultado = 0;
        switch (medidaInicial) {
            case "Celsius" -> {
                if (medidaFinal.equals("Fahrenheit")) {
                    resultado = valor * 1.8 + 32;
                } else if (medidaFinal.equals("Kelvin")) {
                    resultado = valor + 273.15;
                }
            }
            case "Fahrenheit" -> {
                if (medidaFinal.equals("Celsius")) {
                    resultado = (valor - 32) / 1.8;
                } else if (medidaFinal.equals("Kelvin")) {
                    resultado = (valor + 459.67) / 1.8;
                }
            }
            case "Kelvin" -> {
                if (medidaFinal.equals("Celsius")) {
                    resultado = valor - 273.15;
                } else if (medidaFinal.equals("Fahrenheit")) {
                    resultado = valor * 1.8 - 459.67;
                }
            }
            default -> System.out.println("Unidad de medida no válida.");
        }
        return resultado;
    }

}
