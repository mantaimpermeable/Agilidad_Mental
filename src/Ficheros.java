package src;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileReader;

public class Ficheros {
    // private PrintWriter writer;
    

    //ponemos estos objetos pero antes de meterlos en el constructor hay que inicializarlos con un FileReader y con un BufferdReader + filewrite

    public static void escribir(String informacion, String ruta) throws IOException{
        PrintWriter writer = new PrintWriter(ruta);
        writer.print(informacion); 
        }

    // String file = Files.readString(Path.of(ruta));
    //metodo para leer el archivo de intentos
    public static String[] leerIntentos(String ruta) throws IOException{ return Files.readString(Path.of(ruta)).split(Fechas.SEPARATOR); }

    public static String[] ultimasEstadisticas(String ruta, int numIntentos) throws IOException{
        String[] fichero = leerIntentos(ruta);
        double segundos = 0.0;
        double exitos = 0.0;
        
        //para que no se rompa si el usuario es subnormal
        int startIndex = Math.max(0, fichero.length - numIntentos - 1);
        //bucle for para  acumular las estadisticas
        for(int i = fichero.length - 1; i > startIndex; i--){
            BufferedReader reader = new BufferedReader(new FileReader(fichero[i]));
            //saltamos primeras dos lineas de la fecha y el dia de la semana
            reader.readLine();
            reader.readLine();
            // exitos += Double.parseDouble(reader.readLine());
            if("true".equals(reader.readLine())) exitos += 1;
            segundos += Double.parseDouble(reader.readLine());
        }
        //calculamos los porcentajes
        exitos /= numIntentos;
        segundos /= numIntentos;

        return  new String[]{String.valueOf(exitos), String.valueOf(segundos)};
    }
}
