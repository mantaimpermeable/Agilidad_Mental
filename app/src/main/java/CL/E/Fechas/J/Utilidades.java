package CL.E.Fechas.J;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {

    private static final String ERROR_MSG = "Por favor, introduce un número válido.";
    private static final String NUMBER_MSG = "El número debe estar entre [%d] y [%d].";
    private static final String[] DIAS_SEMANA = {"domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado"}; //Sin mayusculas o tildes

    public static String leerString(Scanner teclado, String mensaje){
        System.out.println(mensaje);
        return teclado.nextLine();
    }

    public static String[] getDiasSemana() { return DIAS_SEMANA; }

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
    
    public static String obtenerDiaDiferente(String dia) {
        String[] dias = {"domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado"};
        for (String posible : dias) {
            if (!posible.equalsIgnoreCase(dia)) {
                return posible;
            }
        }
        return "lunes";
    }

    public static String leerDia(Scanner teclado, String[] dias, String err_mensaje) { 
        String intento = teclado.next();
        boolean bien = false;
        do{
            for (int i = 0; i < dias.length; i++) {
                if (intento.equals(dias[i])) bien = true;
            }

            if(!bien) System.out.println(err_mensaje);
            intento = teclado.nextLine();
        }while(!bien);

        return intento;
    }

      public static String getCalculated(int dia, int mes, int año) {
         //guardamos los codigos correspondientes a cada mes
        int [] codMes = {0,3,2,5,0,3,5,1,4,6,2,4};

        //lo llamamos year para no confundir porque este año puede cambiar
        
        if(mes < 3) año -= 1;

        //algoritmo de sakamoto
        return DIAS_SEMANA[(año + año/4 - año/100 + año/400 + codMes[mes -1] + dia) % 7];
        
    }

    public static int dayMax(int mes) {
        
        return switch(mes){
            case 1,3,5,7,8,10,12  ->  31;
            case 4, 6, 9, 11  ->  30;
            case 2 ->  28;
            default -> -1;
        };
    }
}
