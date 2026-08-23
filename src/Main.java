package src;
public class Main {
        public static void main(String[] args){
                Fechas fecha = new Fechas();
                String date = fecha.makeDate();
                System.out.println(date);
                System.out.println(fecha.calculate());
        }
}
