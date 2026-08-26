package src;
import java.util.Scanner;

public class Main {

        public static void main(String[] args){
                Scanner teclado = new Scanner(System.in);
                Sesion sesion = new Sesion(teclado);
                boolean check = false;
                while(!check){
                        
                        int eleccion = Utilidades.menu(teclado);
                        //cada sesion de juegos tiene su propio bucle del que hay que salirse del todo para llegar al menu asi que solo hay
                        //que llamar a la funcion
                        switch(eleccion){
                                case 1:
                                        sesion.juegoFechas();
                                        break;
                                case 0:
                                        check = true;
                                        break;
        
                        }
                }
                System.out.println("Chao pescao 👶🏿");
                
                
        }
        
        
}
