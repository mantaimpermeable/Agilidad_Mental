package src;
import java.io.IOException;
import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;

//Clase  para partidas o logicas en bloques sobre los distintos juegos, sin ninguna conexion
public class Partidas {

    public boolean partidaFechas(Scanner teclado, String ruta, Fechas fecha){  
        //Le comunicamos al usuario la fecha
        System.out.println("Adivina que dia de la semana fue el: " + fecha.makeDate());
        //preguntamos por una respuesta y medimo el tiempo
        Instant inicio = Instant.now();
        String intento = teclado.nextLine();
        Instant fin = Instant.now();
        double segundos = Duration.between(inicio, fin).toNanos() / 1_000_000_000.0;

        boolean exito = fecha.isCorrect(intento);

        // if(exito) {System.out.println("Es correcto");}
        // else System.out.println("Error, el dia de la semana era un: " + fecha.getDiaSemana());
        String mensaje = exito ? "Es correcto" : String.format("Error, el dia de la semana era un: %s", fecha.getDiaSemana());
        System.out.println(mensaje);
        System.out.printf("Has tardado %f segundos\n", segundos);

        try {
            Ficheros.escribir(fecha.toRawString(exito, segundos), ruta);
        } catch (IOException e) {
            System.out.printf("An exception has ocurred %s", e.getMessage());
        }
        return exito;
    }
}
