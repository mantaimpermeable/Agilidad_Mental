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
}
