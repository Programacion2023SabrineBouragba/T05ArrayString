import java.util.Scanner;

public class Principal2 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        //pido al usuario nombre del grupo, numero alumnos y cantidad de asignaturas
        System.out.print("Introduce el nombre de tu grupo: ");
        String nombreGrupo= sc.nextLine();

        System.out.print("Introduce la cantidad de alumnos: ");
        int totalAlumnos= sc.nextInt();

        System.out.print("Introduce la cantidad de asignaturas: ");
        int totalAsignaturas= sc.nextInt();

        //creo objeto grupo con los datos introducidos por el usuario
        Grupo grupo= new Grupo(nombreGrupo, totalAlumnos, totalAsignaturas);


        int opcion;
        do{
            /*llamo a la función menu, me muestra el menu
              y con el switch me muestra cada opcion con su funcion*/
            opcion= mostrarMenu();
            //creamos objeto

            switch (opcion) {
                case 1:
                    //introducir alumnos
                    grupo.leerAlumnos();

                    //mostrar los alumnos introducidos
                    System.out.println("Los alumnos introducidos son: ");
                    grupo.mostrarAlumnos();
                    break;

                case 2:
                    grupo.leerAsignaturas();
                    break;

                case 3:
                    grupo.toString();
                    break;

                case 4:
                    System.out.println("Asignaturas introducidas: ");
                    grupo.mostrarAsignatura();
                    break;

                case 5:
                    grupo.mostrarMedias();
                    break;

                case 6:
                    System.out.println("La asignatura con menos nota es: " + grupo.dameAsignaturaMinima());
                    break;

                case 7:
                    System.out.println("La asignatura con menos nota es: " + grupo.dameAsignaturaMaxima());
                    break;

                case 8:
                    System.out.println("El alumno con mejor media es: " + grupo.dameMejorAlumnoMedia());
                    break;

                case 9:
                    System.out.println("Las medias de los alumnos: " + grupo.muestraMediaAlumnos());
                    break;

                case 10:
                    System.out.println("Posibles repetidores: ");
                    grupo.muestraRepetidores();
                    break;

                case 11:

                    break;

                case 12:

                    break;

                case 13:
                    System.out.println("Saliendo...");
                    break;

                default:
                    break;
            }


        }while(opcion <13);

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
            System.out.println("1. Introducir alumnos");
            System.out.println("2. Introducir notas asignatura");
            System.out.println("3. Mostrar grupo y notas");
            System.out.println("4. Ver asignaturas");
            System.out.println("5. Ver media asignaturas");
            System.out.println("6. Ver asignatura menor mínimo");
            System.out.println("7. Ver asignatura mayor máximo");
            System.out.println("8. Mostrar el alumno con mejor media");
            System.out.println("9. Muestra media de los alumnos");
            System.out.println("10. Muestra repetidores");
            System.out.println("11. Analiza Asignaturas");
            System.out.println("12. - Analiza curso");
            System.out.println("13. Salir");



            /*pedimos al usuario el numero*/
            System.out.print("Introduce una opción del menú: ");
            opcion=sc.nextInt();

        }while (opcion>13);

        return opcion;
    }
}



