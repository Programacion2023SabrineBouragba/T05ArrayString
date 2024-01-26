public class VentasSemanales {
    private int numSemanas;
    private int[][] seguimientos;

    //constructor
    public VentasSemanales(int numSemanas){
        this.numSemanas= numSemanas;
        this.seguimientos= new int[numSemanas][7];  //fila de numSemanas variables y 7 columnas fijas

        //for para inicializar la matriz con ceros
        for (int i=0; i<numSemanas; i++){   //recorremos la fila num de semanas
            for (int j=0; j<7; i++){        //por cada columna de la semana
                seguimientos[i][j]=0;       //iniciamos la mtriz con 0
            }
        }
    }

    public void guardaVentas(int semana, int dia, int valor){
        //en la matriz seguimiento buscamos las celdas que concuerden con la info dada y almacenamos el valor
        seguimientos[semana][dia]= valor;
    }

    public void inicializarVentas(){
        for (int i=0; i<numSemanas; i++){   //recorremos la fila num de semanas
            for (int j=0; j<7; i++){        //por cada columna de la semana
                seguimientos[i][j]=0;       //iniciamos la mtriz con 0
            }
        }
    }


    public String toString() {
        StringBuilder resultado= new StringBuilder();
        resultado.append(String.format("%-15s", "Semana "));
        resultado.append(String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "   ","Sábado", "Domingo"));

        for (int i=0; i<numSemanas; i++){
            System.out.print("S" + (i+1) + " ");
            for (int j=0; j<7; j++){
                resultado.append(String.format("%-10d", seguimientos[i][j]));
                System.out.print(" ");
            }
            System.out.println("\n");
        }
        return resultado.toString();
    }

    public String totalSemana(int semana){
        StringBuilder resultado= new StringBuilder();
        resultado.append(String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "   ","Sábado", "Domingo"));

        for (int j=0; j<7; j++){
            resultado.append(String.format("%-10d", seguimientos[semana][j]));
            System.out.print(" ");
        }
        System.out.println("\n");

        return resultado.toString();
    }

    public int totalDiaSemana(int dia){
        int suma=0;

        for (int i=0; i<numSemanas; i++){
            suma+= seguimientos[i][dia];
        }

        return suma;
    }

    public int mediaDiaSemana(int dia){
        return totalDiaSemana(dia)/numSemanas;
    }
}
