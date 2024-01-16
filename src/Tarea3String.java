
public class Tarea3String {

    /*metodo para comprobar que el nif introducido sea correcto.
    * parde de información obtenida de:
    * https://es.stackoverflow.com/questions/325876/comprobar-si-un-car%C3%A1cter-de-un-string-es-un-n%C3%BAmero*/
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


    /*metodo para quitar vocales*/
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


    /*metodo para quitar espacios de una frase*/
    public String quitaEspaciosSobrantes(String frase){
        //String que reemplaza los espacios en blanco
        String sinEspacios= frase.replaceAll(" ", "*");

        return sinEspacios;
    }


    /*metodo para invertir con ciclos el orden de la frase introducida
    * ejemplo obtenido de:
    * https://parzibyte.me/blog/2019/02/20/invertir-cadena-string-java/ */

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

    /*metodo para calcular cuantas veces sale una palabra en una oracion
    *ejemplo y explicacion de split sacada de:
    * https://www.delftstack.com/es/howto/java/java-word-count/ */
    public int repeticiones(String frase, String palabra){
        /*dividir la frase introducipa en palabras, y almacenarlas en un array
        * "\\s+" significa que me divida el string a medida que hayan espacios*/
        String[] palabras= frase.split("\\s+");

        int contador=0;
        //recorro el array de palabras
        for (int i=0; i<palabras.length; i++){
            /*convierto el contenido de la posicion i del array en un string,
            para comprobar si es igual a la palabra introducida por el usuario*/
            String palabraString= new String(palabras[i]);
            //si el contenido de i, es igual a la palabra introducida por el usuario, que vaya aumentando el contador
            if (palabraString.matches(palabra)){
                contador++;
            }
        }

        //me devuelva la cantidad de vecs q se repite la palabra en la oracion++
        return contador;
    }

    public boolean palindromo(String frase){
        String invertido= invertir(frase.toLowerCase());
        if (frase.matches(invertido)){
            return true;
        }else{
            return false;
        }
    }

}
