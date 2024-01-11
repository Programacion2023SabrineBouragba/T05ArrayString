import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        int opcion;

        do{
            /*llamo a la función menu, me muestra el menu
              y con el switch me muestra cada opcion con su funcion*/
            opcion= mostrarMenu();
            switch (opcion) {
                case 1:
                    //introducir las notas

                    break;

                case 2:
                    //mostrar notas

                    break;

                case 3:
                    //mostrar la media de las notas introducidas

                    break;

                case 4:
                    //mostrar la nota mas baja

                    break;

                case 5:
                    //mostrar la nota mas alta

                    break;

                case 6:
                    //mostrar el total de suspensos

                    break;

                case 7:
                    //mostrar el total de aprobados

                    break;

                case 8:
                    //cambiar nota

                    break;

                case 9:
                    //mostrar la nota del alumno con mas nota

                    break;

                case 10:
                    //mostrar la nota del alumno con menos nota

                    break;

                case 11:
                    //ver la nota de un alumno específico

                    break;

                case 12:
                    //obtener el array de índices de aprobados

                    break;

                case 13:
                    //obtener el array de índices de suspensos
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

    public static void nombreAsignatura(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre asignatura");
        String nombre= sc.next();

        Asignatura asignatura= new Asignatura(nombre);

    }


}
