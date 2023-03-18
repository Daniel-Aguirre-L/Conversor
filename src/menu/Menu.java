package menu;

import listas.Moneda;
import listas.Temperatura;
import listas.TipoDeConversion;
import metodos.Convertir;
import metodos.ConvertirApi;

import javax.swing.*;
import java.util.Arrays;

public class Menu extends JFrame {

    // Método para obtener los valores de una enumeración como un arreglo de cadenas de texto
    public static <Enums extends Enum<Enums>> String[] getEnumValues(Class<Enums> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .map(Enum::toString)
                .toArray(String[]::new);
    }

    // Obtener los valores de las enumeraciones como arreglos de cadenas de texto
    String[] aplicacion = getEnumValues(TipoDeConversion.class);
    String[] seleccion = getEnumValues(Moneda.class);
    String[] seleccion2 = getEnumValues(Temperatura.class);

    public Menu() {
        String menuAplicacion;
        String menuSeleccion1;
        String menuSeleccion2;
        double valor;


        do {
            // Mostrar el menú de conversiones y obtener las opciónes seleccionadas por el usuario
            menuAplicacion = (String) JOptionPane.showInputDialog(null,
                    "Selecciona una opción de conversión", "Menu de selección", JOptionPane.QUESTION_MESSAGE,
                    null, aplicacion, aplicacion);
            if (menuAplicacion == null) {
                continue; // Salir del ciclo actual y volver a mostrar el menú principal
            }
            switch (menuAplicacion) {

                //Menus para el conversor de divisas offline usando ratios predeterminados
                case "Conversor de Divisas" -> {
                    menuSeleccion1 = (String) JOptionPane.showInputDialog(null,
                            "Seleccione la moneda de origen", "Conversor de Divisas", JOptionPane.QUESTION_MESSAGE,
                            null, seleccion, seleccion[0]);
                    if (menuSeleccion1 == null) {
                        continue; // Salir del ciclo actual y volver a mostrar el menú principal
                    }
                    menuSeleccion2 = (String) JOptionPane.showInputDialog(null,
                            "Seleccione la moenda de destino", "Conversor de Divisas", JOptionPane.QUESTION_MESSAGE,
                            null, seleccion, seleccion[0]);
                    if (menuSeleccion2 == null) {
                        continue; // Salir del ciclo actual y volver a mostrar el menú principal
                    }
                    if (menuSeleccion1.equals(menuSeleccion2)) {
                        JOptionPane.showMessageDialog(null, "No hay nada que convertir");
                    }
                    if (!menuSeleccion1.equals(menuSeleccion2)) {
                        try {
                            valor = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor a convertir"));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido");
                            continue;
                        }
                        //Se usa el metodo de la clase Convertir
                        double resultado = Convertir.convertirDivisas(valor, menuSeleccion1, menuSeleccion2);
                        String mensaje = String.format("%.2f %s equivalen a %.2f %s", valor, menuSeleccion1, resultado, menuSeleccion2);
                        JOptionPane.showMessageDialog(null, mensaje);
                    }
                }

                //Menus para el conversor de temperaturas
                case "Conversor de Temperatura" -> {
                    menuSeleccion1 = (String) JOptionPane.showInputDialog(null,
                            "Seleccione la unidad de temperatura de origen", "Conversor de Temperatura", JOptionPane.QUESTION_MESSAGE,
                            null, seleccion2, seleccion2[0]);
                    if (menuSeleccion1 == null) {
                        continue; // Salir del ciclo actual y volver a mostrar el menú principal
                    }
                    menuSeleccion2 = (String) JOptionPane.showInputDialog(null,
                            "Seleccione la unidad de temperatura de destino", "Conversor de Temperatura", JOptionPane.QUESTION_MESSAGE,
                            null, seleccion2, seleccion2[0]);
                    if (menuSeleccion2 == null) {
                        continue; // Salir del ciclo actual y volver a mostrar el menú principal
                    }
                    if (menuSeleccion1.equals(menuSeleccion2)) {
                        JOptionPane.showMessageDialog(null, "No hay nada que convertir");
                    }
                    if (!menuSeleccion1.equals(menuSeleccion2)) {
                        try {
                            valor = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor a convertir"));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido");
                            continue;
                        }
                        //Se usa el metodo de la clase Convertir
                        double resultado = Convertir.convertirTemperatura(valor, menuSeleccion1, menuSeleccion2);
                        String mensaje = String.format("%.2f %s equivalen a %.2f %s", valor, menuSeleccion1, resultado, menuSeleccion2);
                        JOptionPane.showMessageDialog(null, mensaje);
                    }
                }

                //Menu para el conversor de divisas usando la API
                case "Conversor de Divisas Online" -> {
                    menuSeleccion1 = ((Moneda) JOptionPane.showInputDialog(null,
                            "Seleccione la moenda de origen", "Conversor de Divisas", JOptionPane.QUESTION_MESSAGE,
                            null, Moneda.values(), Moneda.values()[0])).getCodigo();
                    menuSeleccion2 = ((Moneda) JOptionPane.showInputDialog(null,
                            "Seleccione la moneda de destino", "Conversor de Divisas", JOptionPane.QUESTION_MESSAGE,
                            null, Moneda.values(), Moneda.values()[0])).getCodigo();
                    if (menuSeleccion1.equals(menuSeleccion2)) {
                        JOptionPane.showMessageDialog(null, "No hay nada que convertir");
                    }
                    if (!menuSeleccion1.equals(menuSeleccion2)) {
                        try {
                            valor = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor a convertir"));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido");
                            continue;
                        }
                        //Se usa el metodo de la clase ConvertirApi la cual realiza la request
                        try {
                            double resultado = Double.parseDouble(ConvertirApi.Api(menuSeleccion1, menuSeleccion2, valor));
                            JOptionPane.showMessageDialog(null, String.format("%.2f", valor) + " " + menuSeleccion1 + " = " +
                                    String.format("%.2f", resultado) + " " + menuSeleccion2);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error al convertir las monedas. " + e.getMessage());
                        }
                    }
                }
                default -> JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (JOptionPane.showConfirmDialog(null, "¿Desea hacer otra conversión?",
                "Nuevo cálculo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(null, "Gracias por usar el programa. El programa se cerrará ahora.");
    }
}
