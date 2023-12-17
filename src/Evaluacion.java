import java.util.Scanner;

public class Evaluacion {
    //propiedades
    private String nombreAsignatura;
    private double[] listaNotas; //[] porque es un Array

    //constructores
    public Evaluacion(String nombreAsignatura){
        this.nombreAsignatura= nombreAsignatura;
    }
    public Evaluacion(String nombreAsignatura, double[] listaNotas){
        this.nombreAsignatura= nombreAsignatura;
        this.listaNotas=listaNotas;
    }

    //getters y setters
    public String getNombreAsignatura(){
        return nombreAsignatura;
    }
    public void setNombreAsignatura(String nombreAsignatura){
        this.nombreAsignatura=nombreAsignatura;
    }

    public double[] getListaNotas(){
        return listaNotas;
    }
    public void setListaNotas(double[] listaNotas){
        this.listaNotas=listaNotas;
    }


    public void leerNotas(int totalAlumnos){
        Scanner sc= new Scanner(System.in);
        //si el array tiene notas, preguntar
        if (listaNotas!= null){
            System.out.println("Notas ya introducidas, ¿desea introducirlas de nuevo?(s/n)");
            String resp= sc.nextLine();

            if (resp.equalsIgnoreCase("s")){
                listaNotas= new double[totalAlumnos];
                for (int i=0; i<totalAlumnos; i++){
                    do{
                        System.out.println("Introduce la nota:");
                        listaNotas[i]= sc.nextDouble();
                    }while(listaNotas[i]<0 || listaNotas[i]>10);
                }
            }

        //si el array esta vacio
        }else{
            //crear array e introducir notas
            listaNotas= new double[totalAlumnos];

            for (int i=0; i<totalAlumnos; i++){
                do{
                    System.out.println("Introduce la nota:");
                    listaNotas[i]= sc.nextDouble();
                }while(listaNotas[i]<0 || listaNotas[i]>10);
            }
        }
    }




    //sobrecarga
    public String toString(){
        String resultado= "Nombre asignatura: " + nombreAsignatura + "\n";

        if(listaNotas!= null){
            //.length para saber la lomgitud del array
            for (int i=0; i<listaNotas.length; i++){
                resultado+= "Alumno" + (i+1)+ ": " + listaNotas[i] + "\n";
            }
        }else{
            resultado+= "Sin notas de momento";
        }

        return resultado;
    }




    public double media(){
        if(listaNotas!= null){
            double suma=0;
            for(int i=0; i<listaNotas.length; i++){
                suma+= listaNotas[i];
            }
            return suma/ listaNotas.length;
        }else{
            return -1;
        }
    }

    public double minimo() {
        if (listaNotas != null) {
            double min = listaNotas[0];
            for (int i = 1; i < listaNotas.length; i++) {
                if (listaNotas[i] < min) {
                    min = listaNotas[i];
                }
            }
            return min;
        } else {
            return -1;
        }
    }


    public double maximo() {
        if (listaNotas != null) {
            double max = listaNotas[0];
            for (int i = 1; i < listaNotas.length; i++) {
                if (listaNotas[i] > max) {
                    max = listaNotas[i];
                }
            }
            return max;
        } else {
            return -1;
        }
    }


    public int totalSuspensos(){
        if(listaNotas!= null){

        }
    }
}
