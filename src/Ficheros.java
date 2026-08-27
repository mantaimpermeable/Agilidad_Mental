package src;
import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ficheros {
    // private PrintWriter writer;
    

    //ponemos estos objetos pero antes de meterlos en el constructor hay que inicializarlos con un FileReader y con un BufferdReader + filewrite

    public static void escribir(String informacion, String ruta) throws IOException{
        Files.writeString(
            Path.of(ruta),
            informacion,
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND
        );
        }

    // String file = Files.readString(Path.of(ruta));
    //metodo para leer el archivo de intentos
    public static String[] leerIntentos(String ruta) throws IOException{
        String contenido = Files.readString(Path.of(ruta)).trim();
        return contenido.isEmpty() ? new String[0] : contenido.split(Fechas.SEPARATOR);
    }

    public static String[] ultimasEstadisticas(String ruta, int numIntentos) throws IOException{
        String[] fichero = leerIntentos(ruta);
        double segundos = 0.0;
        double exitos = 0.0;
        
        //para que no se rompa si el usuario es subnormal
        int intentosAProcesar = Math.min(numIntentos, fichero.length);
        int startIndex = fichero.length - intentosAProcesar;
        //bucle for para  acumular las estadisticas
        for(int i = fichero.length - 1; i >= startIndex; i--){
            try (BufferedReader reader = new BufferedReader(new java.io.StringReader(fichero[i].trim()))) {
            //saltamos primeras dos lineas de la fecha y el dia de la semana
            reader.readLine();
            reader.readLine();
            if("true".equals(reader.readLine())) exitos += 1;
            segundos += Double.parseDouble(reader.readLine().replace(',', '.'));
            }
        }
        //calculamos los porcentajes
        exitos /= intentosAProcesar;
        segundos /= intentosAProcesar;

        return  new String[]{String.valueOf(exitos), String.valueOf(segundos)};
    }
}
