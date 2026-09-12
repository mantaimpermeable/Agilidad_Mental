package CL.E.Fechas.J;

import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class PartidaFechasTest {

    @Test
    void partidaFechas_DevuelveTrue() throws IOException {
        Partidas partidas = new Partidas();
        Fechas fecha = new Fechas();
        Path rutaTemporal = Files.createTempFile("partida", ".txt");

        try {
            //la entrada del scanner simula que el usuario introduce la respuesta correcta
            Scanner teclado = new Scanner(fecha.getDiaSemana() + System.lineSeparator());

            boolean resultado = partidas.partidaFechas(teclado, rutaTemporal.toString(), fecha);

            //resultado ya es un booleano de por si
            assertTrue(resultado);
            String contenido = Files.readString(rutaTemporal);
            //En el archivo temporal tiene que estar la fecha y guardado el resultado positivo
            assertTrue(contenido.contains(fecha.makeDate()));
            assertTrue(contenido.contains("true"));
        } finally {
            Files.deleteIfExists(rutaTemporal);
        }
    }

    @Test
    void partidaFechas_DevuelveFalse() throws IOException {
        Partidas partidas = new Partidas();
        Fechas fecha = new Fechas();
        String diaIncorrecto = Utilidades.obtenerDiaDiferente(fecha.getDiaSemana());
        Path rutaTemporal = Files.createTempFile("partida", ".txt");

        try {
            Scanner teclado = new Scanner(diaIncorrecto + System.lineSeparator());

            boolean resultado = partidas.partidaFechas(teclado, rutaTemporal.toString(), fecha);

            //igual que con el devuelve true pero con valores de un dia incorrecto
            assertFalse(resultado);
            String contenido = Files.readString(rutaTemporal);
            assertTrue(contenido.contains(fecha.getDiaSemana()));
            assertTrue(contenido.contains("false"));
        } finally {
            Files.deleteIfExists(rutaTemporal);
        }
    }
}