import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Evaluacion evaluacion= new Evaluacion("Programacion");
        int opcion;

        do{
            /*llamo a la función menu, me muestra el menu
              y con el switch me muestra cada opcion con su funcion*/
            opcion= mostrarMenu();
            switch (opcion) {
                case 1:
                    //introducir las notas
                    System.out.print("Introduce el total de alumnos: ");
                    int totalAlumnos = new Scanner(System.in).nextInt();
                    evaluacion.leerNotas(totalAlumnos);
                    break;

                case 2:
                    //mostrar notas
                    System.out.println(evaluacion.toString());
                    break;

                case 3:
                    //mostrar la media de las notas introducidas
                    System.out.println("Media de las notas: " + evaluacion.media());
                    break;

                case 4:
                    //mostrar la nota mas baja
                    System.out.println("Nota mínima: " + evaluacion.minimo());
                    break;

                case 5:
                    //mostrar la nota mas alta
                    System.out.println("Nota máxima: " + evaluacion.maximo());
                    break;

                case 6:
                    //mostrar el total de suspensos
                    System.out.println("Total de suspensos: " + evaluacion.totalSuspensos());
                    break;

                case 7:
                    //mostrar el total de aprobados
                    System.out.println("Total aprobados: " + evaluacion.totalAprobados());
                    break;

                case 8:
                    //cambiar nota
                    System.out.print("Introduce el número del alumno: ");
                    int numAlumno = new Scanner(System.in).nextInt();
                    System.out.print("Introduce la nueva nota: ");
                    double nuevaNota = new Scanner(System.in).nextDouble();
                    evaluacion.cambiarNota(nuevaNota, numAlumno - 1);
                    break;

                case 9:
                    //mostrar la nota del alumno con mas nota
                    System.out.println("Mejor alumno: " + evaluacion.mejorAlumno());
                    break;

                case 10:
                    //mostrar la nota del alumno con menos nota
                    System.out.println("Peor alumno: " + evaluacion.peorAlumno());
                    break;

                case 11:
                    //ver la nota de un alumno específico
                    System.out.print("Introduce el número del alumno: ");
                    int indiceAlumno = new Scanner(System.in).nextInt();
                    System.out.println("Nota del alumno " + indiceAlumno + ": " + evaluacion.notaAlumno(indiceAlumno - 1));
                    break;

                case 12:
                    //obtener el array de índices de aprobados
                    int[] aprobados = evaluacion.dameAprobados();
                    if (aprobados != null) {
                        System.out.print("Índices de alumnos aprobados: ");
                        for (int i : aprobados) {
                            System.out.print(i + ", ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("No hay aprobados.");
                    }
                    break;

                case 13:
                    //obtener el array de índices de suspensos
                    int[] suspensos = evaluacion.dameSuspensos();
                    if (suspensos != null) {
                        System.out.print("Índices de alumnos suspensos: ");
                        for (int i : suspensos) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("No hay suspensos.");
                    }
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

}
