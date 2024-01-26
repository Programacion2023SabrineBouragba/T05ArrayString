import java.util.Scanner;

public class Principal4 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        //creo el objeto de la tarea 3 para poder llamarla en mi menu
        VentasSemanales ventas= new VentasSemanales(4);

        int opcion;
        //
        do {
            /*la opcion llama a mostrar menu, en base a opcion introducida en el menu,
            dependieendo de esta me hara un caso u otro*/
            opcion= mostrarMenu();

            switch (opcion){
                case 1:

                    break;
                case 2:


                    break;
                case 3:


                    break;
                case 4:


                    break;

                case 5:


                    break;

                case 6:
                    //reconocer, amad a la dama, salas


                    break;

                case 7:


                    break;

                case 8:


                    break;

                case 9:


                    break;

                case 10:
                    System.out.println("Saliendo... ");
                    break;

            }

        }while (opcion<=10);

    }

    /*metodo para ir mostrando el menu*/
    public static int mostrarMenu(){
        Scanner sc= new Scanner(System.in);
        int opcion;
        //mostrar menu siempre que la aopcion introducida sea menos que 0 o mayor que 4
        do {
            System.out.println("Menú: ");
            System.out.println("1- Guardar ventas.");
            System.out.println("2- Inicializar ventas.");
            System.out.println("3- Mostrar ventas.");
            System.out.println("4- Total de las semana");
            System.out.println("5- Suma de dia semana");
            System.out.println("6- Total dia de cada semana");
            System.out.println("7- Media dia semana");
            System.out.println("8- Total semana");
            System.out.println("9- Media semana");
            System.out.println("10- Salir");

            System.out.print("Introduce una opcion del menú: ");
            opcion=sc.nextInt();
        }while (opcion<0 || opcion>11);

        return opcion;
    }

}
