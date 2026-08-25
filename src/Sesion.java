package src;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

//clase con la logica de una sesion de usuario
public class Sesion {

    
    private Scanner teclado;
    private Partidas partida;
    //ruta en la que se encuentra el proyecto
    private Path rutaActual = Paths.get("").toAbsolutePath();
    //ruta del directorio donde se crearan los ficheros de informacion
    private String estadisticasRuta = rutaActual + "/storage/estadisticas.txt";
    private String intentosRuta = rutaActual + "/storage/intentos.txt";

    private final String WELCOME_MSG = "Bienvenido al juego de las fechas, ahora tendras que calcular el dia de la semana de una fecha. Empezar(Y)  Salir(N)  Estadisticas(E)";
    private final String CHOICE_MSG = "Ha terminado el juegos. Jugar de nuevo(Y)  Salir al menu(N)  Estadisticas(E)";
    private final String ESTD_MSG = "Inserta el numero de intentos del que quieres ver estadisticas";
  

    public Sesion(Scanner scanner){
        this.teclado = scanner;
        partida = new Partidas();
    }

    // public static void imprimirRuta(){
    //     Path rutaActual = Paths.get("").toAbsolutePath();
    //     System.out.println(rutaActual);
    // }

    public void juegoFechas(){
        char respuesta = Utilidades.leerYNE(teclado, WELCOME_MSG);
        if(respuesta == 'Y'){
            while(respuesta == 'Y'){
                this.partida.partidaFechas(this.teclado);
                respuesta = Utilidades.leerYNE(teclado, CHOICE_MSG);
            }
        }
        if(respuesta == 'E'){
            int numIntentos = Utilidades.leerNumero(teclado, CHOICE_MSG, respuesta, respuesta)
        }
    }

}
