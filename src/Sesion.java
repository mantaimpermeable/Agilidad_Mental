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
        try {
            char respuesta = 'X';
            while(respuesta != 'N')
            respuesta = Utilidades.leerYNE(teclado, WELCOME_MSG);
            if(respuesta == 'Y'){
                while(respuesta == 'Y'){
                    this.partida.partidaFechas(this.teclado, intentosRuta, new Fechas());
                    respuesta = Utilidades.leerYNE(teclado, CHOICE_MSG);
                }
                //si dentro del ciclo del primer Y la respuesta es N entonces cambiamos a cualquier otro caracter para salir de cualquier if y volver a 
                //la primera pregunta del menu sin que la respuesta == N y que nos saque del while principal
                if(respuesta == 'N') respuesta = 'X';
            }
            if(respuesta == 'E'){
                int max = Ficheros.leerIntentos(intentosRuta).length;
                int numIntentos = Utilidades.leerNumero(teclado, ESTD_MSG, 1, max);
                String[] estadisticas = Ficheros.ultimasEstadisticas(intentosRuta, numIntentos);
                System.out.printf("Tu media de los ultimos %d intentos es de %f segundos y %f % de acierto", numIntentos, estadisticas[1], estadisticas[0]);
            }
            
        } catch (Exception e) {
            System.out.printf("An exception has ocurred %s", e.getMessage());
        } finally{
            System.out.println("Saliendo del juego de fechas... Hasta la luego cara huevo");
        }
    }

}
