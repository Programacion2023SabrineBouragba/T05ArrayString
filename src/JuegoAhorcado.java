import java.util.Scanner;

public class JuegoAhorcado {
    private int  intentos=5;
    private char[] palabrasecreta;
    private  int intentosRestantes;


    public void Partida(String palabrasecreta){
        palabrasecreta= palabrasecreta.toLowerCase();

        Scanner sc= new Scanner(System.in);

        //array char con la longitud de la palabra secreta, y con el bucle for, voy cogiendo las letras y almacenandolas
        char[] palabra= new char[palabrasecreta.length()];
        for (int i=0; i<palabrasecreta.length(); i++){
            palabra[i]= palabrasecreta.charAt(i);
        }

        char[] respuestas= new char[palabra.length];

        //por cada letra q haya en la palabra mostar guion
        for (int guiones=0; guiones< respuestas.length; guiones++){
            respuestas[guiones]= '_';
        }

        int aciertos=0;
        //mientras tenga vidas
        while (intentos> 0){
            System.out.print("Introduce una letra: ");
            String letra= sc.next();
            letra= letra.toLowerCase();

            //almaceno la letra intrducida, que estaria en la posicion 0
            char letraIntroducida= letra.charAt(0);

            //recorro la palabrasecreta, comprobando si la letra introducida es igual a una de las letras de la palabra
            for(int i=0; i< palabra.length; i++){
                if (palabra[i]== letraIntroducida){
                    respuestas[i]= palabra[i];
                    palabra[i]=' ';
                    aciertos++;

                }
            }

            System.out.println(respuestas);

            //si no ha acertado se le resta una vida, si los aciertos igualan la longitud de la palabra, romper
            if (aciertos==0){
                intentos--;
            }else if(aciertos== respuestas.length){
                break;
            }
        }

        //mensajes final si acierta o pierde
        if (aciertos== respuestas.length){
            System.out.println("¡Enhorabuena, las has acertado todas!");
        }else{
            System.out.println("La palabra era: " + palabrasecreta);
        }

    }

}
