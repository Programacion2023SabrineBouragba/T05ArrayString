import java.util.Scanner;

public class Asignatura {
    Scanner sn= new Scanner(System.in);

    private final String nombreAsignatura;
    private double[] listaNotas;


    //constructor un parametro
    public Asignatura(String nombreAsignatura){
        this.nombreAsignatura= nombreAsignatura;
    }

    //constructor dos parametro
    public Asignatura(String nombreAsignatura, double[] listaNotas){
        this.nombreAsignatura= nombreAsignatura;
        this.listaNotas= listaNotas;
    }

    //metodo para leer notas
    public void leerNotas(int totalAlumnos){

        //comprobar si hemos creado el array
        //si esta creado
        if (listaNotas!=null){

            System.out.println("Notas ya introducidas, desea introducirlas de nuevo (s/n)?");
            String respuesta= sn.next();

            if (respuesta.equalsIgnoreCase("s")){
                //volver a introducir las notas
                listaNotas= new double[totalAlumnos];

                //los arrays siempre empiezan por la posicion 0, y en este caso va aumentando
                for (int i = 0; i < totalAlumnos; i++) {
                    //ir leyendo las notas y comprobando que se han introducido bien
                    System.out.print("Introduce la nota del alumno " + (i + 1) + ": ");
                    double nota = sn.nextDouble();

                    //si se introduce un numero menor oque 0 o mayor que 10
                    if (nota<0 || nota>10){
                        System.out.println("Error: La nota debe estar en el rango de 0 a 10.");
                        /*hago que la i disminuya si se cumple la condicon, por ejemplo si en el
                         * alumno 0 se introcuce un 11, en vez de que el for vaya a por la celda
                         * 1, baje y vuelva a introducir la celda 0*/
                        i--;
                    }else {
                        //si se ha introducido bien la nota, que se guarde en el array
                        listaNotas[i]= nota;
                    }

                }
            }
            //si no esta creado el array de notas
        }else{

            listaNotas= new double[totalAlumnos];

            for (int i = 0; i < totalAlumnos; i++) {
                //ir leyendo las notas y comprobando que se han introducido bien
                System.out.print("Introduce la nota del alumno " + (i + 1) + ": ");
                double nota = sn.nextDouble();

                if (i<0 || i>10){
                    System.out.println("Error: La nota debe estar en el rango de 0 a 10.");
                    /*hago que la i disminuya si se cumple la condicon, por ejemplo si en el
                     * alumno 0 se introcuce un 11, en vez de que el for vaya a por la celda
                     * 1, baje y vuelva a introducir la celda 0*/
                    i--;
                }else {
                    //si se ha introducido bien la nota, que se guarde en el array
                    listaNotas[i]= nota;
                }


            }
        }

        //mostrar las notas
        System.out.println("Notas introducidas: ");
        for (int i=0; i< listaNotas.length; i++){
            System.out.print("Alumno " + (i+1)+ ": " + listaNotas[i] + "\n ");
        }
    }

    //metodo toString
    @Override
    public String toString(){
        String frase= nombreAsignatura + ":\n";

        if (listaNotas != null) {
            //si hay notas

            /*recorremos el array de notas y agregamos cada nota con su respectivo número de alumno, ejemplo,
             cuando muestre la celda 0, imprimira, "Alumno 1: nota"*/
            for (int i = 0; i < listaNotas.length; i++) {
                frase+= "Alumno " + (i + 1) + ": " + listaNotas[i];
            }
        } else {
            //si no hay notas
            frase+= "Sin notas por el momento";
        }

        // Devolvemos el resultado final
        return frase;
    }


    public double media(){
        double suma=0;
        //comprobar que el array no este vacio
        if (listaNotas != null) {
            //si hay notas, empezamos a recorrer el array y sumando las notas que vayan apareciendo
            for (double listaNota : listaNotas) {
                suma += listaNota;
            }
            //devuelve la suma de las notas entre la longitud del array
            return suma / listaNotas.length;

        } else {
            //si no hay notas
            return -1;
        }
    }


    public double minimo(){
        //comprobar que el array no este vacio
        if (listaNotas != null) {
            //si hay notas

            /*igualamos la variable a la primera nota del array, y a partir de esta
            * vamos viendo si las celdas que vienen su contenido es menor que la primera celda */
            double notaMenor= listaNotas[0];
            for (double listaNota : listaNotas) {
                /*si el contenido de la celda actual es menor que la celda 0, cambiar a celda actual
                 * si no es menor, sigue con el bucle*/
                if (listaNota < notaMenor) {
                    notaMenor = listaNota;
                }
            }
            //devuelve la nota mas baja de entre la longitud del array
            return notaMenor;

        } else {
            //si no hay notas
            return -1;
        }
    }


    public double maximo(){
        //comprobar que el array no este vacio
        if (listaNotas != null) {
            //si hay notas

            /*igualamos la variable a la primera nota del array, y a partir de esta
             * vamos viendo si las celdas que vienen su contenido es mayor que el anterior*/
            double notaMayor= listaNotas[0];
            for (double listaNota : listaNotas) {
                /*si el contenido de la celda actual es mayor que la celda 0, cambiar a celda actual
                 * si no es mayor, sigue con el bucle hasta que acabe la longitud del array*/
                if (listaNota > notaMayor) {
                    notaMayor = listaNota;
                }
            }
            //devuelve la nota maxima de entre la longitud del array
            return notaMayor;

        } else {
            //si no hay notas
            return -1;
        }
    }


    public int totalSuspensos(){
        //comprobar que el array no este vacio
        if (listaNotas != null) {
            //si hay notas

            int suspensos= 0;
            //el for recorre el array desde 0 hasta su ultima celda
            for (double listaNota : listaNotas) {
                /*si el contenido de la celda actual es menor que 5, aumentar contador de susoensos*/
                if (listaNota < 5) {
                    suspensos++;
                }
            }
            //devuelve los suspensos que hay entre la longitud del array
            return suspensos;

        } else {
            //si no hay notas
            return -1;
        }
    }


    //metodo para calcular el total de aprobados
    public int totalAprobados(){
        //comprobar que el array no este vacio
        if (listaNotas != null) {
            //si hay notas

            //el for recorre el array
            int aprobadas= 0;
            for (double listaNota : listaNotas) {
                /*si el contenido de la celda actual es mayor igual que 5, aumentar contador de aprobados*/
                if (listaNota >= 5) {
                    aprobadas++;
                }
            }
            //devuelve los aprobados que hay entre la longitud del array
            return aprobadas;

        } else {
            //si no hay notas
            return -1;
        }
    }


    //metodo para cambiar nota, que no me devuelve nada
    public void cambiarNota(double nota, int numAlumno){
        //comprobar que el array no este vacio
        if (listaNotas != null) {
            //si hay notas
            //comprobar que el indice del alumno sea correcto
            if(numAlumno>=0 && numAlumno< listaNotas.length){ //si el numero es mayor igual que 0 y esta dentro del rando del array
                //comprobar que la nota introducida sea mayor igual que 0
                if (nota>=0){
                    listaNotas[numAlumno]= nota; //en el array, se introduce el indice del alumno, y se cambia la nota
                    System.out.println("Alumno " + (numAlumno+1) + "se a cambiado a: " + nota);
                }else{
                    System.out.println("Nota introducida no válida.");
                }

            }else {
                //si no coincide el indice introducido con las celdas del array listanotas
                System.out.println("Indice del alumno incorrecto.");
            }

        }
    }


    //metodo para ver el alumno con mejor nota
    public double mejorAlumno(){
        //comprobar que el array no este vacio
        if (listaNotas != null) {
            //si hay notas

            /*igualamos la variable a la primera nota del array, y a partir de esta
             * vamos viendo si las celdas que vienen su contenido es menor que el anterior*/
            double notaMaxima= listaNotas[0];
            for (double listaNota : listaNotas) {
                /*si el contenido de la celda actual es mayor que la celda 0, cambiar a celda actual
                 * si no es menor, sigue con el bucle*/
                if (listaNota > notaMaxima) {
                    notaMaxima = listaNota;
                }
            }
            //devuelve la nota maxima de entre la longitud del array
            return notaMaxima;

        } else {
            //si no hay notas
            return -1;
        }
    }

    //metodo para ver el alumno con la nota mas baja
    public double peorAlumno(){
        //comprobar que el array no este vacio
        if (listaNotas != null) {
            //si hay notas

            /*igualamos la variable a la primera nota del array, y a partir de esta
             * vamos viendo si las celdas que vienen su contenido es menor que el anterior*/
            double notaMinima= listaNotas[0];
            for (double listaNota : listaNotas) {
                /*si el contenido de la celda actual es menor que la celda 0, cambiar a celda actual
                 * si no es menor, sigue con el bucle*/
                if (listaNota < notaMinima) {
                    notaMinima = listaNota;
                }
            }
            //devuelve la nota maxima de entre la longitud del array
            return notaMinima;

        } else {
            //si no hay notas
            return -1;
        }
    }


    //metodo para introducir el indice del alumno y que me muestre la nota correspondiente
    public double notaAlumno(int indiceAlumno){
        if(indiceAlumno>0 && indiceAlumno<= listaNotas.length){
            //si el numero es mayor que 0 y menor igual que el tamaño del array, que me devuelva la nota del alumno introducido
            return listaNotas[indiceAlumno];
        }else{
            //si el indice esta fuera de rango
            return -1;
        }
    }


    //metodo para que me de un array donde esta el indice de los que alumnos estan aprobados
    public int[] dameAprobados() {
        //verificamos si hay notas en la lista
        if (listaNotas != null && totalAprobados() > 0) {
            //creamos un array y llamamos al  metodo totalAprobados
            int[] arrayAprobados = new int[totalAprobados()];
            int indiceArray = 0;

            //bucle for para llenar el array con los índices de los alumnos aprobados
            for (int i = 0; i < listaNotas.length; i++) {
                //si la celda actual contiene nota mayor igual que 5, guardarlo en el array
                if (listaNotas[i] >= 5.0) {
                    arrayAprobados[indiceArray++] = i;
                }
            }

            return arrayAprobados;
        } else {
            //si no hay aprobados o no hay notas, devolver null
            return null;
        }
    }


    //metodo para que me de un array donde esta el indice de los que alumnos estan suspendidos
    public int[] dameSuspensos() {
        //verificamos si hay notas en la lista
        if (listaNotas != null && totalSuspensos() > 0) {
            //creamos un array y llamamos al  metodo totalAprobados
            int[] arraySuspensos = new int[totalSuspensos() ];
            int indiceArray = 0;

            // Utilizar un bucle for para llenar el array con los índices de los alumnos suspendidos
            for (int i = 0; i < listaNotas.length; i++) {
                //si la celda actual contiene nota menor que 5, guardarlo en el array suspensos
                if (listaNotas[i] > 5.0) {
                    arraySuspensos[indiceArray++] = i;
                }
            }

            return arraySuspensos;
        } else {
            //si no hay aprobados o no hay notas, devolver null
            return null;
        }
    }

    //metodo para índice del primer alumno que cumpla que la nota es menor que la dada.
    public int primerMenor(double nota){
        //verificamos si hay notas en la lista
        if (listaNotas != null) {
            //utilizamos un bucle for para encontrar el índice del primer alumno con nota menor
            for (int i = 0; i < listaNotas.length; i++) {
                //comprobamos si la nota del alumno en la posición actual es menor que la nota dada
                if (listaNotas[i] < nota) {
                    //devolvemos el índice del alumno
                    return i;
                }
            }
        }

        return -1;
    }
}
