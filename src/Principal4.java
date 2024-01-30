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
                    System.out.print("Introduce la semana: ");
                    int semana= sc.nextInt();
                    semana-=1;
                    System.out.print("Introduce el día: ");
                    int dia= sc.nextInt();
                    dia-=1;
                    System.out.print("Introduce el número de ventas: ");
                    int valor= sc.nextInt();

                    ventas.guardaVentas(semana, dia, valor);
                    break;
                case 2:
                    System.out.println(ventas);

                    break;
                case 3:
                    System.out.print("Introduce la semana a comprobar: ");
                    int semanaEsp= sc.nextInt();
                    semanaEsp-=1;
                    String numeros= ventas.totalSemana(semanaEsp);
                    System.out.println(numeros);


                    break;
                case 4:
                    System.out.print("Introduce el el día a comprobar (todoas las semanas mismo dia): ");
                    int diaComp= sc.nextInt();
                    diaComp-=1;
                    int resultado= ventas.totalDiaSemana(diaComp);
                    System.out.println("La suma del día elegido en todas las semanas es de " + resultado + " ventas");
                    break;


                case 5:
                    System.out.println("Saliendo... ");
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
            System.out.println("1- Guardar ventas.");
            System.out.println("2- Mostrar ventas.");
            System.out.println("3- Total de las semana");
            System.out.println("4- Total dia de cada semana");
            System.out.println("5- Salir");

            System.out.print("Introduce una opcion del menú: ");
            opcion=sc.nextInt();
        }while (opcion<0 || opcion>5);

        return opcion;
    }

}
