import java.util.Scanner;

public class JuegoAhorcado {
    private int  intentos=5;
    private char[] palabrasecreta;
    private  int intentosRestantes;


    public void Partida(String palabrasecreta){
        palabrasecreta= palabrasecreta.toUpperCase();

        Scanner sc= new Scanner(System.in);

        //array char con la longitud de la palabra secreta, y con el bucle for, voy cogiendo las letras y almacenandolas
        char[] palabra= new char[palabrasecreta.length()];
        char[] repuestopalabra= new char[palabrasecreta.length()];
        for (int i=0; i<palabrasecreta.length(); i++){
            palabra[i]= palabrasecreta.charAt(i);
            repuestopalabra[i]= palabrasecreta.charAt(i);
        }


        char[] respuestas= new char[palabra.length];

        //por cada letra q haya en la palabra mostar guion
        for (int guiones=0; guiones< respuestas.length; guiones++){
            respuestas[guiones]= '_';
        }


        //mientras tenga vidas
        while (intentos> 0){
            boolean aciertos=false;

            System.out.print("Introduce una letra: ");
            String letra= sc.next();
            letra= letra.toUpperCase();

            //almaceno la letra intrducida, que estaria en la posicion 0
            char letraIntroducida= letra.charAt(0);

            //recorro la palabrasecreta, comprobando si la letra introducida es igual a una de las letras de la palabra
            for(int i=0; i< palabra.length; i++){
                if (palabra[i]== letraIntroducida){
                    respuestas[i]= palabra[i];
                    palabra[i]=' ';
                    aciertos= true;

                }
            }

            System.out.println(respuestas);

            //si no ha acertado se le resta una vida, si los aciertos igualan la longitud de la palabra, romper
            if (!aciertos){
                System.out.println("Letra incorrecta.");
                --intentos;
                System.out.println("Te quedan " + intentos + " intentos.");
            }else if(respuestas== repuestopalabra){
                System.out.println("¡Enhorabuena, las has acertado todas!");
                break;
            }

        }
        if (intentos==0){
            System.out.println("No te quedan vidas");
            System.out.println("La palabra correcta es: " + palabrasecreta);
        }

    }

}
