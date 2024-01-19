
public class Tarea3String {

    /**metodo para comprobar que el nif introducido sea correcto.
     * parde de información obtenida de:
     * <a href="https://es.stackoverflow.com/questions/325876/comprobar-si-un-car%C3%A1cter-de-un-string-es-un-n%C3%BAmero">...</a>*/
    public boolean esCorrectoNIF(String NIF){

        //commprobamos q no este nulo o que exceda 9 caracteres
        if (NIF.length()!=9){
            return false;
        }else {
            String numDni = "";
            /*vamos a recorrer los 8 digitos,
            comprobando en todo momento que se trata de digitos y no letras*/
            //desde la posicion 0, hasta la posicion 7
            for (int i=0; i<8; i++){
                //si el caracter actual, i, es diferente de digito, devolver falso
                if(!Character.isDigit(NIF.charAt(i))){
                    return false;
                }else{  //si el caracter es un digito, almacenar, para utilizar despues para averiguar la laetra
                    numDni+= NIF.charAt(i);
                }

            }

            //convertir del String NIF, el caracter 8(java empieza a contar desde 0), convertirlo en un caracter
            char letra= NIF.charAt(8);
            //comprobar que el char sea una letra
            if (!Character.isLetter(letra)){
                return false;
            }else{
                //crear array con las letras correctas que puede tener un DNI
                char[] letrasDni= {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
                /*como numdni es un string, tengo que pasarlo a int primero, y despues calcular el modulo*/
                int numero= Integer.parseInt(numDni);
                //con el nuevo int, calculo el modulo para averiguar la letra correcta
                int modulo= numero%23;

                //en base al modulo obtenido, obtener letra del array, ejemplo, si el modulo es 3, me devolvera 'A'
                char letraCalculada= letrasDni[modulo];

                //si la letra proporcioanada en el dni, coincide con la del array, devolver true
                return letra== letraCalculada;
            }

        }
    }


    /**metodo para quitar vocales*/
    public String quitaVocales(String frase){

        //en un array las vocales
        String[] vocales= {"a", "e", "i", "o", "u", "á", "é", "í", "ó", "ú","A", "E", "I", "O", "U", "Á", "É", "Í", "Ó", "Ú"};

        //igualo la nueva variable a la frase, donde guardare la frase sin vocales


        //recorro el array de vocales
        for (int i=0; i< vocales.length; i++){
            /*voy recorriendo el array vocales(i), y si en la frase dada,
            coincide alguna vocal, las voy eliminando de la frase, ejemplo:
            la palabra ANA, va recorriendo el array, hasta que encuente i=10 que corresponde con a mayuscula
            y las quita de la frase, asi en cualquier ejemplo*/
            frase= frase.replaceAll(vocales[i], "");
        }

        return frase;
    }


    /**metodo para quitar espacios de una frase*/
    public String quitaEspaciosSobrantes(String frase){
        //String que reemplaza los espacios en blanco
        frase= frase.replaceAll(" ", "*");

        return frase;
    }


    /**metodo para invertir con ciclos el orden de la frase introducida
     * ejemplo obtenido de:
     * <a href="https://parzibyte.me/blog/2019/02/20/invertir-cadena-string-java/">...</a> */

    public String invertir(String frase){
        //variable donde guardare la frase invertida
        String reves="";

        //recorremos frase de final a inicio
        //como se empieza desde 0 a la longitud, para invertir seria la longitud de la frase-1, hasta 0
        for (int i= frase.length()-1; i>=0; i--){
            /*mientras recorro la longitud de la palabra, en la variable reves se va
            almacenando el valor del caracter i, empezando de fin de la cadena, a inicio*/
            reves+= frase.charAt(i);
        }

        return reves;
    }

    /**metodo para calcular cuantas veces sale una palabra en una oracion
     *ejemplo y explicacion de split sacada de:
     * <a href="https://www.delftstack.com/es/howto/java/java-word-count/">...</a> */
    public int repeticiones(String frase, String palabra){
        /*dividir la frase introducipa en palabras, y almacenarlas en un array
        * "\\s+" significa que me divida el string a medida que hayan espacios*/
        String[] palabras= frase.split("\\s+");

        int contador=0;
        //recorro el array de palabras
        for (int i=0; i<palabras.length; i++){
            /*convierto el contenido de la posicion i del array en un string,
            para comprobar si es igual a la palabra introducida por el usuario*/
            String palabraString= palabras[i];
            //si el contenido de i, es igual a la palabra introducida por el usuario, que vaya aumentando el contador
            if (palabraString.matches(palabra)){
                contador++;
            }
        }

        //me devuelva la cantidad de vecs q se repite la palabra en la oracion++
        return contador;
    }

    /** metodo que verifica si una palabra/frase se escribe igual tanto del derecho como del reves
     * */
    public boolean palindromo(String frase){
        /*en la variable invertido, llamo al metodo invertir, para invertir el orden de la frase/palabra introducida,
        *pasandola a minuscula, y la guardo en dicha variable*/
        frase= frase.replace(" ","");
        String invertido= invertir(frase.toLowerCase());
        if (frase.matches(invertido)){
            return true;
        }else{
            return false;
        }
    }


    /**metodo para cifrar mensajes, donde cada letra del alfabeto se rota 3 veces en este caso
     * ejemplo, la a se convierte en d, entonces en una palabra que contenga a, se convertiran en d,
     * asi con todo el alfabeto.
     * Ejemplo obtenido de:
     * <a href="https://parzibyte.me/blog/2019/05/23/cifrado-cesar-java-algoritmo/">...</a>*/
    public String cifrar(String mensaje){
        //pasamos el mensaje a minusculas
        mensaje= mensaje.toLowerCase();

        //string donde allmaceno las letras del alfabeto en minuscula, tengo en cuenta la consonante 'ñ'
        String alfabeto= "abcdefghijklmnñopqrstuvwxyz";


        //donde se almacenara la cadena cifrada
        String cadenaCifrada="";

        //recorremos la longitud del mensaje introducido por el usuario
        for (int i=0; i<mensaje.length(); i++){
            //convertir la letra del mensaje de la posicion actual(i) en un caracter y almacenarlo
            char letraActual= mensaje.charAt(i);

            //si no es una letra, almacenarla tal cual
            if (!Character.isLetter(letraActual)){
                cadenaCifrada+= letraActual;
                continue;   //para indicarle que pase al siguiente ciclo(pasa al siguiente i)
            }


            //obtener la posicion actual de la letra en el alfabeto, ej. si es a me da la posicion 0 en el alfbeto
            int posicionActual= alfabeto.indexOf(letraActual);

            /*a la posicion actual, le sumo 3, para q se desplace 3 casillas,
            * utilizo el modulo por si se pasa de la longitud de mi alfabeto por si se pasa de 27,
            * ej. la z rotada 3 veces, me daria 30, pero mi alfabeto tiene 27 letras, me daria error,
            * asi que lo que hago es 30%27 (longitud de mi algabeto) y me dara la posicion 3, es decir se sustituira
            * por la letra c, asi con todo.*/
            //calcular la nueva posicion despues del desplazamiento
            int nuevaPosicion= (posicionActual + 3) % alfabeto.length();

            //obtener la letra cifrada y agregarla a la cadena
            char letraCifrada= alfabeto.charAt(nuevaPosicion);

            cadenaCifrada+=letraCifrada;
        }

        return cadenaCifrada;
    }


    /**metodo para descifrar mensajes, similar al metodo anterior, pero en vez de sumar casillas, se van restando*/
    public String descifrar(String cifrado){

        //string donde almaceno las letras del alfabeto en minuscula, tengo en cuenta la consonante 'ñ'
        String alfabeto= "abcdefghijklmnñopqrstuvwxyz";


        //donde se almacenara la cadena descifrada
        String cadenaDescifrada="";

        //recorremos la longitud del mensaje introducido por el usuario
        for (int i=0; i<cifrado.length(); i++){
            //convertir la letra del mensaje de la posicion actual(i) en un caracter y almacenarlo
            char letraActual= cifrado.charAt(i);

            //si no es una letra, almacenarla tal cual
            if (!Character.isLetter(letraActual)){
                cadenaDescifrada+= letraActual;
                continue;   //para indicarle que pase al siguiente ciclo(pasa al siguiente i)
            }


            //obtener la posicion actual de la letra en el alfabeto, ej. si es a me da la posicion 0 en el alfbeto
            int posicionActual= alfabeto.indexOf(letraActual);

            /*a la posicion actual, le resto 3, para q se desplace 3 casillas hacia atras,
             * utilizo el modulo por si se pasa de la longitud de mi alfabeto por si se pasa de 27,
             * ej. la z rotada 3 veces, me daria 30, pero mi alfabeto tiene 27 letras, me daria error,
             * asi que lo que hago es 30%27 (longitud de mi alfabeto) y me dara la posicion 3, es decir se sustituira
             * por la letra c, asi con todo.*/
            //calcular la nueva posicion despues del desplazamiento
            int nuevaPosicion= (posicionActual - 3) % alfabeto.length();

            /*si la nuevaposicion me da negativo, lo que hago es sumarle a la posicion la longitud del alfabeto
            * eso lo q va a hacer es restarle a la longitud del alfabeto la posicion (sin el negativo), y me dara la posicion correspondiente
            * ej. cl(mensaje cifrado), a c si le resto 3 posiciones, me dara -1, a este valor le sumo la longitud de mi alfabeto
            * y me devolvera la posicion de la letra z(aunque la longitud de mi alfabeto es de 27, java empieza a contar desde 0, por lo que va de 0 a 26),
            * la nueva posicion, y l si le resto 3, me da i, por lo q el mensaje descifrado seria 'zi'*/
            if (nuevaPosicion < 0) {
                nuevaPosicion += alfabeto.length();
            }

            //obtener la letra cifrada y agregarla a la cadena
            char letraDescifrada= alfabeto.charAt(nuevaPosicion);

            cadenaDescifrada+=letraDescifrada;
        }

        return cadenaDescifrada;
    }


    /**metodo para que me cuente cuantas veces se repiten los caracteres dentro de una frase*/
    public String cuentaCaracteres(String frase){
        //string donde almaceno las letras del alfabeto en minuscula, tengo en cuenta la consonante 'ñ'
        String alfabeto= "abcdefghijklmnñopqrstuvwxyz";

        //string donde almacenare el resultado
        String resultado="";
        //recorro el alfabeto
        for (int i=0; i<alfabeto.length(); i++){

            //a esta variable le asigno el valor de alfabeto dependiendo de la posicion de i
            String letraAbecedario= String.valueOf(alfabeto.charAt(i));

            //string donde almacenare la letra actual de la frase
            String letraActual;
            int contador=0;
            //recorro la longitud de la frase introducida por el usuario
            for (int j= 0; j<frase.length(); j++){
                //asigno a esta variable el valor de la letra de frase dependiendo en j
                letraActual= String.valueOf(frase.charAt(j));
                //si la letra actual(j) es igual sin considerar mayuscula o minuscula a la letra del abecedario(i), aumentar contador
                if (letraActual.equalsIgnoreCase(letraAbecedario)){
                    contador++;
                }
            }

            //si el contador es igual o mayor que 1, imprimir lo siguiente
            if (contador>=1){
                //almaceno en esta variable el valor de contador, me pasa de int a string
                String veces= String.valueOf(contador);

                //el resultado sera la letra abecedario actual(i) + numero de veces repetida(contador) + salto de linea
                resultado+= letraAbecedario + ": " + veces + " veces." + "\n";
            }
        }

        //me devuelva la frase final
        return resultado;
    }


}
