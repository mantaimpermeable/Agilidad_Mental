package src;
import java.io.IOException;
import java.util.Scanner;

//Clase  para partidas o logicas en bloques sobre los distintos juegos, sin ninguna conexion
public class Partidas {

    public boolean partidaFechas(Scanner teclado, String ruta, Fechas fecha){  
        //Le comunicamos al usuario la fecha
        System.out.println("Adivina que dia de la semana fue el: " + fecha.makeDate());
        String intento = teclado.next();
        boolean exito = fecha.isCorrect(intento);
        if(exito) System.out.println("Es correcto");
        else System.out.println("Error, el dia de la semana era un: " + fecha.getDiaSemana());

        try {
            Ficheros.escribir(fecha.toRawString(exito, 0), ruta);
        } catch (IOException e) {
            System.out.printf("An exception has ocurred %s", e.getMessage());
        }
        return exito;
    }
}
