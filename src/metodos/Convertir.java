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

        double fromRate = 0.0;
        double toRate = 0.0;

        // Determinar las tasas de cambio de la moneda de origen y destino
        if (monedaInicial.equals("USD")) {
            fromRate = dollarRate;
        } else if (monedaInicial.equals("EUR")) {
            fromRate = euroRate;
        } else if (monedaInicial.equals("GBP")) {
            fromRate = sterlingRate;
        } else if (monedaInicial.equals("JPY")) {
            fromRate = yenRate;
        } else if (monedaInicial.equals("KRW")) {
            fromRate = wonRate;
        } else if (monedaInicial.equals("COP")) {
            fromRate = pesoRate;
        } else {
            System.out.println("Moneda de origen no válida");
            return 0.0;
        }

        if (monedaFinal.equals("USD")) {
            toRate = dollarRate;
        } else if (monedaFinal.equals("EUR")) {
            toRate = euroRate;
        } else if (monedaFinal.equals("GBP")) {
            toRate = sterlingRate;
        } else if (monedaFinal.equals("JPY")) {
            toRate = yenRate;
        } else if (monedaFinal.equals("KRW")) {
            toRate = wonRate;
        } else if (monedaFinal.equals("COP")) {
            toRate = pesoRate;
        } else {
            System.out.println("Moneda de destino no válida");
            return 0.0;
        }

        // Calcular el monto convertido
        double convertedAmount = valor * (toRate / fromRate);

        return convertedAmount;
    }
}

