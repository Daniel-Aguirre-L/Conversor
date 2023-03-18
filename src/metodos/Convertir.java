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

    public static double convertirDivisas(double valor, String monedaInicial, String monedaFinal) {
        double euroRate = 1.0;
        double dollarRate = 1.0623;
        double sterlingRate = 0.8749;
        double yenRate = 141.2526;
        double wonRate = 1388.0572;
        double pesoRate = 5147.3746;

        double fromRate;
        double toRate;

        // Determinar las tasas de cambio de la moneda de origen y destino
        switch (monedaInicial) {
            case "Dolares" -> fromRate = dollarRate;
            case "Euros" -> fromRate = euroRate;
            case "Libras Esterlinas" -> fromRate = sterlingRate;
            case "Yenes Japoneses" -> fromRate = yenRate;
            case "Wons Surcoreanos" -> fromRate = wonRate;
            case "Pesos Colombianos" -> fromRate = pesoRate;
            default -> {
                System.out.println("Moneda de origen no válida");
                return 0.0;
            }
        }

        switch (monedaFinal) {
            case "Dolares" -> toRate = dollarRate;
            case "Euros" -> toRate = euroRate;
            case "Libras Esterlinas" -> toRate = sterlingRate;
            case "Yenes Japoneses" -> toRate = yenRate;
            case "Wons Koreanos" -> toRate = wonRate;
            case "Pesos Colombianos" -> toRate = pesoRate;
            default -> {
                System.out.println("Moneda de destino no válida");
                return 0.0;
            }
        }

        // Calcular el monto convertido

        return valor * (toRate / fromRate);
    }
}

