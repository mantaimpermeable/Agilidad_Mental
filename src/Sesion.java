package src;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

//clase con la logica de una sesion de usuario
public class Sesion {

    
    private Scanner teclado;
    //ruta en la que se encuentra el proyecto
    private Path rutaActual = Paths.get("").toAbsolutePath();
    //ruta del directorio donde se crearan los ficheros de informacion
    private String estadisticasRuta = rutaActual + "/storage/estadisticas.txt";
    private String intentosRuta = rutaActual + "/storage/intentos.txt";
  

    public Sesion(Scanner scanner){
        this.teclado = scanner;
    }

    // public static void imprimirRuta(){
    //     Path rutaActual = Paths.get("").toAbsolutePath();
    //     System.out.println(rutaActual);
    // }

    public void juegoFechas(){

    }

}
