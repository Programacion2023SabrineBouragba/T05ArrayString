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
                    System.out.print("Introduce la oración: ");
                    String oracionContador= sc.nextLine();

                    System.out.print("Introduce la palabra a comprobar: ");
                    String palabra= sc.nextLine();

                    int contador=comprobar.repeticiones(oracionContador, palabra);
                    System.out.println("La palabra " + palabra + " sale " + contador + " veces.");

                    break;

                case 6:
                    //reconocer, amad a la dama, salas
                    System.out.print("Introduce oracion para ver si es palindrome: ");
                    String frasePalindromo= sc.nextLine();

                    if (comprobar.palindromo(frasePalindromo)){
                        System.out.println("La oracion introducida es palindromo");
                    }else{
                        System.out.println("La oracion introducida no es palindromo");
                    }
                    System.out.println();

                    break;

                case 7:
                    System.out.print("Introduce la palabra a cifrar: ");
                    String mensaje= sc.nextLine();

                    System.out.println("El mensaje cifrado es: " + comprobar.cifrar(mensaje));

                    break;

                case 8:
                    System.out.print("Introduce la palabra a descifrar: ");
                    String mensajeCifrado= sc.nextLine();

                    System.out.println("El mensaje descifrado es: " + comprobar.descifrar(mensajeCifrado));
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
            System.out.println("1- Comprobar DNI.");
            System.out.println("2- Quitar vocales de una palabra/frase.");
            System.out.println("3- Quitar espacios de una frase.");
            System.out.println("4- Invertir el orden de una palabra/frase");
            System.out.println("5- Introduce una oracion y la palabra a contar");
            System.out.println("6- Comprobar si la oracion es palindromo");
            System.out.println("7- Cifrar mensaje");
            System.out.println("8- Descifrar mensaje");

            System.out.print("Introduce una opcion del menú: ");
            opcion=sc.nextInt();
        }while (opcion<0 || opcion>10);

        return opcion;
    }
}
