package src;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
public class Ficheros {
    private PrintWriter writer;
    private BufferedReader reader;

    //ponemos estos objetos pero antes de meterlos en el constructor hay que inicializarlos con un FileReader y con un BufferdReader + filewriter
    public Ficheros(PrintWriter escritor, BufferedReader lector){
        this.writer = escritor;
        this.reader = lector;
    }

    public void escribir(String informacion) throws IOException{ writer.print(informacion); }

    // String file = Files.readString(Path.of(ruta));
    //metodo para leer el archivo de intentos
    public String[] leerIntentos(String ruta) throws IOException{ return Files.readString(Path.of(ruta)).split(Fechas.SEPARATOR); }
}
