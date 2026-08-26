package src;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {

    private static final String ERROR_MSG = "Por favor, introduce un número válido.";
    private static final String NUMBER_MSG = "El número debe estar entre [%d] y [%d].";

    public static String leerString(Scanner teclado, String mensaje){
        System.out.println(mensaje);
        return teclado.nextLine();
    }

    public static int leerNumero(Scanner teclado, String mensaje, int minimo, int maximo) {
        int output = minimo - 1; boolean correct = false;
        
        do {
            try {
                System.out.print(mensaje);
                output = teclado.nextInt();
                teclado.nextLine();
            
                if (output < minimo || output > maximo) System.out.println(String.format(NUMBER_MSG, minimo, maximo));
                else correct = true; 
                
            } catch (InputMismatchException ex) {
                System.out.println(ERROR_MSG);
                teclado.nextLine();
            }
        } while (!correct);

        return output;
    }

    public static char leerYNE(Scanner teclado, String mensaje){
        boolean check = false;
        String respuesta = "";
        while (!check) {
            respuesta = leerString(teclado, mensaje);
            switch (respuesta.toLowerCase()) {
                case "y":
                    respuesta = "Y";
                    check = true;
                    break;
                case "n":
                    respuesta = "N";
                    check = true;
                    break;
                case "e":
                    respuesta = "E";
                    check = true;
                    break;
                default:
                    check = false;
            }
        }
        return respuesta.charAt(0);
    }

    public static int menu(Scanner teclado){
        System.out.println("Bienvenido al programa de agilidad mental del goat, escoge el minijuego");
        System.out.println("Juego de fechas (1)");
        System.out.println("De momento eso es todo lo que tenemos ...");
        return Utilidades.leerNumero(teclado, "Tu eleccion: ", 0, 1);
        }
}
