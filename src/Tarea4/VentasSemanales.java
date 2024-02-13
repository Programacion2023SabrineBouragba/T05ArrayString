package Tarea4;

public class VentasSemanales {
    private int numSemanas;
    private int[][] seguimientos;

    /**constructor recibe numero de semanas y en base a eso inicia el array en ceros*/
    public VentasSemanales(int numSemanas){
        this.numSemanas= numSemanas;
        this.seguimientos= new int[numSemanas][7];  //fila de numSemanas variables y 7 columnas fijas

        //for para inicializar la matriz con ceros
        for (int i=0; i<numSemanas; i++){   //recorremos la fila num de semanas
            for (int j=0; j<7; j++){        //por cada columna de la semana
                seguimientos[i][j]=0;       //iniciamos la mtriz con 0
            }
        }
    }

    /**metodo donde se iran guardando las ventas de un dia especifico y una semana especifica,
     * las tres introducidas por el usuario*/
    public void guardaVentas(int semana, int dia, int valor){
        //en la matriz seguimiento buscamos las celdas que concuerden con la info dada(día y semana) y almacenamos el valor
        seguimientos[semana][dia]= valor;
    }

    /**metodo donde se inicializan los valores del array en 0, igual que el constructor Tarea4.VentasSemanales*/
    public void inicializarVentas(){
        for (int i=0; i<numSemanas; i++){   //recorremos la fila num de semanas
            for (int j=0; j<7; j++){        //por cada columna de la semana
                seguimientos[i][j]=0;       //iniciamos la mtriz con 0
            }
        }
    }


    /**metodo donde me devuelve un String con formato, que contiene una tabla con las semanas,
     * los dias de la semana y la cantidad de ventas que han habido ese dia*/
    @Override   //para indicarle que es un metodo donde sobreescribo
    public String toString(){

        //creo el string builder donde guardare las lineas de las variables tabuladas
        StringBuilder resultado= new StringBuilder();
        StringBuilder result= new StringBuilder();
        resultado.append(String.format("%-10s", "Semana "));
        resultado.append(String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes","Sábado", "Domingo"));

        //recorro el numero de semanas y las voy imprimiendo
        for (int i=0; i<numSemanas; i++){
            result.append(String.format("%-10s", "S" + (i+1)));
            //recorro los dias de la semana y voy imprimiendo los valores relacionados con la semana(i), y los dias de la semana(j)
            for (int j=0; j<7; j++){
                result.append(String.format("%-12d", seguimientos[i][j]));
            }
            result.append("\n");
        }
        return resultado + "\n" +result + "\n";
    }

    /**metodo para ver las ventas de la semana indicada por el usuario*/
    public String totalSemana(int semana){
        //Stringbuilder para darle formato a mi tabla(resultado final)
        StringBuilder resultado= new StringBuilder();
        /*asigno a cada dia de la semana un espacio y al acabar un salto de línea
        para que me muestre las ventas*/
        resultado.append(String.format("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes","Sábado", "Domingo"));

        //recorro los días de la semana
        for (int j=0; j<7; j++){
            /*resultado final de la semana introducida por el usuario,
            donde cada valor del dia correspondiente(j) , darle un espacio */
            resultado.append(String.format("%-10d", seguimientos[semana][j]));
        }

        return resultado.toString();
    }

    /**metodo donde el usuario introduce un día, y se calcula la suma de ese dia en cada semana*/
    public int totalDiaSemana(int dia){
        int suma=0;

        //recooremos el numero de semanas
        for (int i=0; i<numSemanas; i++){
            //vamos sumando de cada semana(i), el valor del día introducido por el usuario
            suma+= seguimientos[i][dia];
        }

        return suma;
    }

    /**metodo*/
    public int mediaDiaSemana(int dia){
        return totalDiaSemana(dia)/numSemanas;
    }

}
