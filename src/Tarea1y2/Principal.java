package Tarea1y2;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int opcion;

        Asignatura asignatura = new Asignatura("Programación");

        do{
            /*llamo a la función menu, me muestra el menu
              y con el switch me muestra cada opcion con su funcion*/
            opcion= mostrarMenu();
            //creamos objeto

            switch (opcion) {
                case 1:
                    //introducir las notas
                    System.out.print("Introduce el total de alumnos: ");
                    int totalAlumnos= sc.nextInt();

                    //llamamos al metodo
                    asignatura.leerNotas(totalAlumnos);
                    break;

                case 2:
                    //mostrar notas
                    System.out.println(asignatura.toString());

                    break;

                case 3:
                    //mostrar la media de las notas introducidas
                    System.out.println("Media de las notas " + asignatura.media());
                    break;

                case 4:
                    //mostrar la nota mas baja
                    System.out.println("Nota más baja: " + asignatura.minimo());
                    break;

                case 5:
                    //mostrar la nota mas alta
                    System.out.println("Nota más alta: " + asignatura.maximo());
                    break;

                case 6:
                    //mostrar el total de suspensos
                    System.out.println("Total suspensos: " + asignatura.totalSuspensos());
                    break;

                case 7:
                    //mostrar el total de aprobados
                    System.out.println("Total aprobados: " + asignatura.totalAprobados());
                    break;

                case 8:
                    //cambiar nota
                    System.out.print("Introduce el número del alumno: ");
                    //leemos numero de alumno y la nota actualizada
                    int numAlumno= sc.nextInt();
                    double nuevaNota = sc.nextDouble();

                    //llamamos al metodo
                    asignatura.cambiarNota(nuevaNota, numAlumno);
                    break;

                case 9:
                    //mostrar la nota del alumno con mas nota
                    System.out.println("Mejor nota: " + asignatura.mejorAlumno());
                    break;

                case 10:
                    //mostrar la nota del alumno con menos nota
                    System.out.println("Peor nota: " + asignatura.peorAlumno());
                    break;

                case 11:
                    //ver la nota de un alumno específico
                    System.out.print("Introduce el número del alumno: ");
                    int numAlu= sc.nextInt();
                    //el usuario empieza a contar desde 1, mientras que el array empieza a contar desde 0, por eso el -1
                    System.out.println(asignatura.notaAlumno(numAlu-1));
                    break;

                case 12:
                    //obtener el array de índices de aprobados
                    dameAprobados();
                    break;

                case 13:
                    //obtener el array de índices de suspensos
                    dameSuspensos();
                    break;

                default:
                    break;
            }


        }while(opcion <=13);

    }

    /**
     * la funcion menú donde me irá mostrando el menú
     */
    static int mostrarMenu(){

        /*declaro el scanner y la variable opcion*/
        Scanner sc= new Scanner(System.in);
        int opcion;

        /*bucle que me vaya mostrando el menú
        si no se introduce el numero adecuado*/
        do{
            System.out.println("Menú: ");
            System.out.println("1. Introducir notas");
            System.out.println("2. Mostrar notas");
            System.out.println("3. Mostrar media");
            System.out.println("4. Mostrar minimo");
            System.out.println("5. Mostrar maximo");
            System.out.println("6. Total suspensos");
            System.out.println("7. Total aaprobados");
            System.out.println("8. Cambiar nota");
            System.out.println("9. Mejor alumno");
            System.out.println("10. Peor alumno");
            System.out.println("11. Ver nota alumno");
            System.out.println("12. Dame total aprobados");
            System.out.println("13. Dame total suspensos");



            /*pedimos al usuario el numero*/
            System.out.print("Introduce una opción del menú: ");
            opcion=sc.nextInt();

        }while (opcion>13);

        return opcion;
    }

    public static void dameAprobados(){
        //creo el objeto de asignatura para que me llame a la clase asignatura
        Asignatura asignatura= new Asignatura("");

        //creo el array en base a dameAprobados de la clase asignatura
        int[] aprobados= asignatura.dameAprobados();

        //for para recorrer el array aprobaados, y me vaya mostrando los aprobados
        for (int i: aprobados){
            System.out.println(i + ", ");
        }
    }

    public static void dameSuspensos(){
        //creo el objeto de asignatura para que me llame a la clase asignatura

        Asignatura asignatura= new Asignatura("");

        //creo el array en base a dameAprobados de la clase asignatura
        int[] suspensos= asignatura.dameSuspensos();

        //for para recorrer el array aprobaados, y me vaya mostrando los aprobados
        for (int i: suspensos){
            System.out.println(i + ", ");
        }
    }

}
