package src;
public class Fechas {
    
    // Atributos privados de la clase
    private int dia;
    private int mes;
    private int año;
    private int[] random;
    private int resultado;
    private final String[] DIAS_SEMANA = {"domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado"}; //Sin mayusculas o tildes
    public static final String SEPARATOR = "--------------------"; //20

    public Fechas(){
        //initialize all random values with fecha() function
        fecha();
        this.resultado = calculate();
    }

    //getters
    public int getDia(){ return this.dia; }
    public int getMes(){ return this.mes; }
    public int getAño(){ return this.año; }
    public int[] getFecha(){ return this.random; }
    public String getDiaSemana() { return this.DIAS_SEMANA[this.resultado]; }

    //metodo para dar un numero random
    private int randomize(int min, int max) {return (int) (Math.random() * ( max - min + 1 ) + min );}
    
    //metodo para dar una fecha random
    private void fecha(){
        int daymax = 0;
        
        this.mes = randomize(1,12);
        this.año = randomize(0,2200);

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
    }

    //metodo para imprimir
    public String makeDate(){ 
         String randomDate = String.valueOf(this.random[0]) + "/" + String.valueOf(this.random[1]) + "/" + String.valueOf(this.random[2]);
        return randomDate;
    }

    //algoritmo de sakamoto
    private int calculate(){
        //guardamos los codigos correspondientes a cada mes
        int [] codMes = {0,3,2,5,0,3,5,1,4,6,2,4};

        //lo llamamos year para no confundir porque este año puede cambiar
        int year = this.año;
        if(this.mes < 3) year -= 1;

        //algoritmo de sakamoto
        return (year + year/4 - year/100 + year/400 + codMes[this.mes -1] + this.dia) % 7;
    }
    //booleano para comprobar si es correcto

    public boolean isCorrect(String intento) { return (intento.toLowerCase() == this.DIAS_SEMANA[this.resultado]); }

    public String toRawString(boolean intento, double tiempo){
        StringBuilder raw = new StringBuilder();
        raw.append(String.format("%s\n", makeDate())); //fecha random
        raw.append(String.format("%s\n", this.resultado)); //dia correcto
        raw.append(String.format("%b\n", intento)); // resultado del intento del usuario
        raw.append(String.format("%f\n", tiempo)); //tiempo tardado en resolver
        raw.append(String.format("%s\n", SEPARATOR)); //Separador para separar cada juego

        return raw.toString();
    }


}
