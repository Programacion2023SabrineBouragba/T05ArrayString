import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        int opcion;
        int numero;

        do{
            /*llamo a la función menu me muestra el menu
              y con el switch me muestra cada opcion con su funcion*/
            opcion= mostrarMenu();
            switch (opcion){
                case 1:

                case 2:

                case 3:

                case 4:

                case 5:

                default:
            }

            /*si el numero introducido es 9
            no volver a mostrar el menu, es decir sale del programa*/
        }while(opcion != 9);

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
            System.out.println("1. Tabla de multiplicar");
            System.out.println("2. Saluda");
            System.out.println("3. Números primos");
            System.out.println("4. Sumar n enteros");
            System.out.println("5. Multiplicar n enteros");


            /*pedimos al usuario el numero
             si el numero introducido es menor que 1 o mayor que 5
             volver a mostrar el menu*/
            System.out.print("Introduce una opción del menú: ");
            opcion=sc.nextInt();

        }while (opcion<1 || opcion>5);

        return opcion;
    }

}
