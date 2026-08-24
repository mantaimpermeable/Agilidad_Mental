package src;
import java.util.Scanner;

//Clase  para partidas o logicas en bloques sobre los distintos juegos, sin ninguna conexion
public class Partidas {
    private Fechas fecha;

    public boolean partidaFechas(Scanner teclado){
        //asignamos a nuestra fecha un nuevo dia random
        fecha = new Fechas();
        //Le comunicamos al usuario la fecha
        System.out.println("Adivina que dia de la semana fue el: " + fecha.makeDate());
        String intento = teclado.next();
        boolean exito = fecha.isCorrect(intento);
        if(exito) System.out.println("Es correcto");
        else System.out.println("Error, el dia de la semana era un: " + fecha.getDiaSemana());

        return exito;
    }
}
