import java.util.Scanner;

public class Principal3 {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        //creo el objeto de la tarea 3 para poder llamarla en mi menu
        Tarea3String comprobar= new Tarea3String();

        int opcion;
        //
        do {
            /*la opcion llama a mostrar menu, en base a opcion introducida en el menu,
            dependieendo de esta me hara un caso u otro*/
            opcion= mostrarMenu();

            switch (opcion){
                case 1:
                    System.out.print("Introduce el DNI a comprobar: ");
                    String nif= sc.nextLine();

                    if (comprobar.esCorrectoNIF(nif)){
                        System.out.println("El NIF introducido, " + nif + " es correcto.");
                    }else{
                        System.out.println("El NIF introducido, " + nif + " es incorrecto.");
                    }
                    System.out.println();

                    break;
                case 2:
                    System.out.print("Introduce una frase o palabra: ");
                    String frase= sc.nextLine();

                    System.out.print("La frase/palabra sin vocales: ");
                    System.out.println(comprobar.quitaVocales(frase));
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Introduce una oracion: ");
                    String oracion= sc.nextLine();

                    System.out.print("La oracion sin espacios en blanco: ");
                    System.out.println(comprobar.quitaEspaciosSobrantes(oracion));
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Introduce una oracion: ");
                    String oracionEspacio= sc.nextLine();

                    System.out.print("La oracion sin espacios en blanco: ");
                    System.out.println(comprobar.invertir(oracionEspacio));
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;
            }

        }while (opcion<=5);

    }

    /*metodo para ir mostrando el menu*/
    public static int mostrarMenu(){
        Scanner sc= new Scanner(System.in);
        int opcion;
        //mostrar menu siempre que la aopcion introducida sea menos que 0 o mayor que 4
        do {
            System.out.println("Menú: ");
            System.out.println("1- Comprobar DNI.");
            System.out.println("2- Quitar vocales de una palabra/frase.");
            System.out.println("3- Quitar espacios de una frase.");
            System.out.println("4- Invertir el orden de una palabra/frase");
            System.out.println("5- Salir");

            System.out.print("Introduce una opcion del menú: ");
            opcion=sc.nextInt();
        }while (opcion<0 || opcion>5);

        return opcion;
    }
}
