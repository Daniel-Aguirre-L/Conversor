import aplicaciones.Moneda;
import aplicaciones.Temperatura;
import aplicaciones.TipoDeConversion;
import metodos.Convertir;
import javax.swing.*;
import java.util.Arrays;
public class Menu extends JFrame {

    public static <Enums extends Enum<Enums>> String[] getEnumValues(Class<Enums> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .map(Enum::toString)
                .toArray(String[]::new);
    }
    String[] aplicacion = getEnumValues(TipoDeConversion.class);
    String[] seleccion = getEnumValues(Moneda.class);
    String[] seleccion2 = getEnumValues(Temperatura.class);

    public Menu() {
        String menuAplicacion;
        String menuSeleccion1;
        String menuSeleccion2;
        double valor = 0;

       menuAplicacion = (String) JOptionPane.showInputDialog(null,
                "Selecciona una opción de conversión","Menu", JOptionPane.QUESTION_MESSAGE,
                null,aplicacion,aplicacion);

        switch (menuAplicacion) {
            case "Conversor de Divisas":
                menuSeleccion1 = (String) JOptionPane.showInputDialog(null,
                        "De","Moneda", JOptionPane.QUESTION_MESSAGE,
                        null,seleccion,seleccion[0]);

                menuSeleccion2 = (String) JOptionPane.showInputDialog(null,
                        "A","Moneda", JOptionPane.QUESTION_MESSAGE,
                        null,seleccion,seleccion[0]);
                if (menuSeleccion1.equals(menuSeleccion2)) {
                    JOptionPane.showMessageDialog(null, "No hay nada que convertir");
                }
                if (!menuSeleccion1.equals(menuSeleccion2))  {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor a convertir"));
                }
                JOptionPane.showMessageDialog(null,Convertir.convertirTemperatura
                        (valor,menuSeleccion1,menuSeleccion2) + menuSeleccion2);
                break;


            case "Conversor de Temperatura":
                menuSeleccion1 = (String) JOptionPane.showInputDialog(null,
                        "De","Te", JOptionPane.QUESTION_MESSAGE,
                        null,seleccion2,seleccion2[0]);

                menuSeleccion2 = (String) JOptionPane.showInputDialog(null,
                        "A","Te", JOptionPane.QUESTION_MESSAGE,
                        null,seleccion2,seleccion2[0]);
                if (menuSeleccion1.equals(menuSeleccion2) ) {
                    JOptionPane.showMessageDialog(null,"No hay nada que convertir");
                }
                if (!menuSeleccion1.equals(menuSeleccion2))  {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor a convertir"));
                }
                JOptionPane.showMessageDialog(null,Convertir.convertirTemperatura
                        (valor,menuSeleccion1,menuSeleccion2)+ " Grados " + menuSeleccion2);
        }
    }

}
