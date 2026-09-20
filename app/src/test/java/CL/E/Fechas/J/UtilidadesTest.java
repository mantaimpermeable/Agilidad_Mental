package CL.E.Fechas.J;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

//test de la clase utilidades
public class UtilidadesTest {

    private static final String GEN_MSG = "LLamalava llamababa esto es un string general";
    private static final String D_ERR_MSG = "Introduce un dia de la semana valido";

    // @Test void leerNumeroTest() {
    //     assertEquals(5, Utilidades.leerNumero(scanner, GEN_MSG, 1, 10));
    //     assertFalse(Utilidades.leerNumero(scanner, GEN_MSG, 1, 10) < 1);
    //     assertFalse(Utilidades.leerNumero(scanner, GEN_MSG, 1, 10) > 10);
    //     assertFalse(GEN_MSG.equals(Utilidades.leerNumero(scanner, GEN_MSG, 1, 10)));
    // }

    // @Test 
    // void leerDia(){
    //     assertEquals("domingo", Utilidades.leerDia(scanner("domingo"), Utilidades.getDiasSemana(), D_ERR_MSG ));
    //     assertEquals("martes", Utilidades.leerDia(scanner("martes"), Utilidades.getDiasSemana(), D_ERR_MSG ));
    //     assertEquals("lunes", Utilidades.leerDia(scanner("lUneS"), Utilidades.getDiasSemana(), D_ERR_MSG ));
        
    // }

    @Test 
    void dayMaxTest(){
        assertEquals(31, Utilidades.dayMax(1), "Si el me es enero devolver 31 dias");
        assertEquals(30, Utilidades.dayMax(4), "Si el me es abril devolver 31 dias");
        assertEquals(28, Utilidades.dayMax(2), "Si el me es febrero devolver 31 dias");
    }

    private static Scanner scanner(String input) {return new Scanner(input + System.lineSeparator());}
}
