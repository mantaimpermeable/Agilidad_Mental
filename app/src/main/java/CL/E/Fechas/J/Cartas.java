package CL.E.Fechas.J;

public class Cartas {

    private final String [] CARTAS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "K", "Q"};
    private int cuenta = 0;
    private int barajas;
    private String[][] mazo;

    // se inicia una matriz con [mazos][CARTAS] en este orden
    /*
    2 3 4 5 6 7 8 9 10 A J K Q
    2 3 4 5 6 7 8 9 10 A J K Q
    2 3 4 5 6 7 8 9 10 A J K Q
    2 3 4 5 6 7 8 9 10 A J K Q
    */
    public Cartas(int barajas){
        this.barajas = barajas;
        this.mazo = new String[barajas][CARTAS.length];
        initMazo(barajas);
    }

    public int getMazos(){ return this.barajas; }
    public int getCuenta() { return this.cuenta; }

    private void initMazo(int barajas){
        for(int i = 0; i < barajas; i++){
            for(int j = 0; j < CARTAS.length; j++){
                this.mazo[i][j] = CARTAS[j];
            }
        }
    }

    public void imprMatr(){
        for(int i = 0; i < this.barajas; i++){
            for(int j = 0; j < CARTAS.length; j++){
                System.out.printf("%s ", mazo[i][j]);
            }
            System.out.println("");
        }
    }


}
