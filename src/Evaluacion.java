import java.util.Scanner;

public class Evaluacion {
    Scanner sn= new Scanner(System.in);

    private String nombreAsignatura;
    private double[] listaNotas;


    //constructor un parametro
    public Evaluacion(String nombreAsignatura){
        this.nombreAsignatura= nombreAsignatura;
    }

    //constructor dos parametro
    public Evaluacion(String nombreAsignatura, double[] listaNotas){
        this.nombreAsignatura= nombreAsignatura;
        this.listaNotas= listaNotas;
    }

    //metodo para leer notas
    public void leerNotas(int totalAlumnos){

        //comprobar si hemos creado el array
        //si esta creado
        if (listaNotas!=null){

            System.out.println("Notas ya introducidas, desea introducirlas de nuevo (s/n)?");
            String respuesta= sn.next();

            if (respuesta.equalsIgnoreCase("s")){
                //volver a introducir las notas
                listaNotas= new double[totalAlumnos];

                //los arrays siempre empiezan por la posicion 0
                for (int i = 0; i < totalAlumnos; i++) {
                    //ir leyendo las notas y comprobando que se han introducido bien
                    System.out.print("Introduce la nota del alumno " + (i + 1) + ": ");
                    double nota = sn.nextDouble();

                    if (i<0 || i>10){
                        System.out.println("Error: La nota debe estar en el rango de 0 a 10.");
                        /*hago que la i disminuya si se cumple la condicon, por ejemplo si en el
                         * alumno 0 se introcuce un 11, en vez de que el for vaya a por el alumno
                         * 1, baje y vuelva a introducir la nota del alumno 0*/
                        i--;
                    }else {
                        listaNotas[i]= nota;
                    }

                }
            }
            //si no esta creado
        }else{
            //si el array no esta creado
            listaNotas= new double[totalAlumnos];

            for (int i = 0; i < totalAlumnos; i++) {
                //ir leyendo las notas y comprobando que se han introducido bien
                System.out.print("Introduce la nota del alumno " + (i + 1) + ": ");
                double nota = sn.nextDouble();

                if (i<0 || i>10){
                    System.out.println("Error: La nota debe estar en el rango de 0 a 10.");
                    /*hago que la i disminuya si se cumple la condicon, por ejemplo si en el
                     * alumno 0 se introcuce un 11, en vez de que el for vaya a por el alumno
                     * 1, baje y vuelva a introducir la nota del alumno 0*/
                    i--;
                }else {
                    listaNotas[i]= nota;
                }


            }
        }

        //mostrar las notas
        System.out.println("Notas introducidas: ");
        for (int i=0; i< listaNotas.length; i++){
            System.out.print("Alumno " + (i+1)+ ": " + listaNotas[i]);
        }
    }

    //metodo toString

}
