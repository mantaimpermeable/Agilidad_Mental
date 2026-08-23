public class Fechas {
    
    // Atributos privados de la clase
    private int dia;
    private int mes;
    private int año;
    private int[] random;

    public Fechas(){
        //Ya veremos que pongo en el constructor
    }


    //metodo para dar un numero random
    private int randomize(int min, int max) {return (int)(Math.random() * ( max - min + 1 ) + min);}
    
    //metodo para dar una fecha random
    public int[] fecha(){
        int daymax = 0;
        
        this.mes = randomize(1,12);
        this.año = randomize(1900,2100);

        switch(this.mes){
            case 1,3,5,7,8,10,12:
                daymax=31;
                break;
            case 4, 6, 9, 11:
                daymax = 30;
                break;
            case 2 :
                daymax = 28;
                break;
        }

        if(this.mes == 2 && this.año % 4 == 0) daymax = 29;

        this.dia = randomize(1, daymax);

        this.random = new int[]{this.dia, this.mes, this.año};
        
        return this.random;

    }
    //metodo para imprimir

    //metodo para calcular dia de la semana

    //booleano para comprobar si es correcto


}
