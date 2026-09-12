package CL.E.Fechas.J;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FechasTest {
    private Fechas fecha;
     @Test void isCorrectTest() {
        fecha = new Fechas();
        String correcto = fecha.getDiaSemana();
        String incorrecto = Utilidades.obtenerDiaDiferente(fecha.getDiaSemana());

        assertTrue(fecha.isCorrect(correcto));
        assertFalse(fecha.isCorrect(incorrecto));
     }
}
