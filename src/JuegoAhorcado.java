import java.util.Scanner;

public class JuegoAhorcado {

    private String palabraSecreta;
    private char[] estado;
    private int intentos;


    /**constructor inicial, donde inicializo  las variables*/
    public JuegoAhorcado(String palabraSecreta, int intentos){
        //paso la palabra secreta a mayuscula
        this.palabraSecreta= palabraSecreta.toUpperCase();
        //igualo el array caracter a la longitud de la palabra secreta introducida
        this.estado= new char[palabraSecreta.length()];

        this.intentos= intentos;
    }


    /**metodo donde me mostrar los guiones dependiendo de la palabra secreta introducida,
     * y me mostrara las vidas que me quedan*/
    public void guiones(){
        //recorro el array donde esta la palabra secreta, sustituyendo cada celda por guiones
        for (int i=0; i< estado.length; i++){
            estado[i]= '_';
        }

        //mostrar el estado de la palabra, copiando la informacion del array, y pasandola a un String
        System.out.println(new String(estado));
    }


    /**metodo para comprobar que lo introducido sea letra y otra cosa distinta*/
    public boolean verificarLetra(char letraIntroducida){
        //verificamos que el char introducido sea letra, si no lo es devolvemos falso
        if (!Character.isLetter(letraIntroducida)){
            return false;
        }else{
            return true;
        }
    }


    /**metodo para ir comprobando la letra introducida, si no es correcta, restar una vida*/
    public void adivinarPalabra(char letraIntroducida){
        //paso la letra introducida a mayuscula
        letraIntroducida= Character.toUpperCase(letraIntroducida);

        //inicio booleano como falso
        boolean acierto=false;

        //recorro la palabra secreta
        for (int i=0; i<palabraSecreta.length(); i++){
            //si la letra introducida es igual a una letra de la palabra secreta(i)
            if (palabraSecreta.charAt(i)== letraIntroducida){
                //sustituyo en la celda correspondiente(i) de estado(donde los giones) por la letra introducida
                estado[i]= letraIntroducida;

                //cambiio el booleano a true, porque ha acertado la letra
                acierto= true;
            }
        }

        //si la letra que introduce no esta en la palabra secreta, restar una vida
        if (!acierto){
            intentos--;
            System.out.println("Letra incorrecta...");
        }
    }


    /**metodo para volver a iniciar la partida*/
    public void reiniciarPartida(){
        //vulevo a declarar el array estado segun la longitud de la palabra secreta
        estado= new char[palabraSecreta.length()];
        intentos= 5;
    }


    /**metodo para iniciar la partida del juego*/
    public void partida(){
        Scanner sc= new Scanner(System.in);

        //mostrar los guiones iniciales, segun la longitud de palabra
        guiones();

        //mientras aun tenga intentos
        while(intentos>0){
            System.out.println("Intentos: " + intentos);

            System.out.print("Introduce una letra: ");
            char letraIntroducida= sc.next().charAt(0);

            //verificamos la letra introducida llamando al metodo que la verifica, si esta es letra
            if (verificarLetra(letraIntroducida)){

                //ver si la letra introducida coincide con alguna letra de la palabra secreta
                adivinarPalabra(letraIntroducida);

                //mostrar el estado de la palabra secreta, es decir, si ha acertado, mostrar las letras correspondientes.
                System.out.println(estado);

                //si el array estado(que convierto a String) es igual a la palabra secreta, romper el bucle
                if (palabraSecreta.equals(new String(estado))){
                    System.out.println("Has ganado!");
                    break;
                }

            //si el caracter introducido al verificarlo no es cierto, devolver:
            }else{
                System.out.println("Caracter no valido");
            }
        }

        //si se le han acabado los intentos
        if (intentos==0){
            System.out.println("Has perdido!" + "La palabra secreta era: " + palabraSecreta);
        }


        //ver si usuario quiere volver a jugar
        System.out.println("¿Reiniciar partida? Introduce s/n");
        char respuesta= sc.next().charAt(0);

        if (Character.toLowerCase(respuesta)== 's'){
            reiniciarPartida();
            partida();
        }

    }

}

