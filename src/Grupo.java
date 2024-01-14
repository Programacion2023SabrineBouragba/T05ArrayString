import java.util.Arrays;
import java.util.Scanner;

public class Grupo {

    private String nombreGrupo;
    private String[] alumnos;
    private Asignatura[] asignaturas;
    private int totalAlumnos;
    private int totalAsignaturas;


    //constructor
    public Grupo(String nombreGrupo, int totalAlumnos, int totalAsignaturas){
        //asignar nombre del grupo
        this.nombreGrupo= nombreGrupo;

        //asigna cantidad de alumnos
        this.totalAlumnos= totalAlumnos;
        //array donde estaran los nombres de los alumnos, en base a lo introducido en totalAlumnos
        this.alumnos= new String[totalAlumnos];

        //asigna el total de asignaturas q hay
        this.totalAsignaturas= totalAsignaturas;
        //array de objetos Asignatura para almacenar las asignaturas, la longitud determinada por totalAsignaturas
        this.asignaturas= new Asignatura[totalAsignaturas];
    }

    //metodo para introducir los nombres de los alumnos, en base a total alumnos
    public void leerAlumnos(){
        Scanner sc= new Scanner(System.in);

        //empezando en 1, con maximo el parametro totalalumnos
        for(int i=1; i<=totalAlumnos; i++){
            //ir introduciendo nombre, y que lo vaya almacenando en un array de string
            System.out.print("Introduce el nombre del alumno " +i+": ");
            alumnos[i]= sc.next();
        }

        //ordenar array de alumnos de forma ascendente, por orden
        Arrays.sort(alumnos);
    }

    //metodo para mostrar los nombres de los alumnos
    public String mostrarAlumnos() {
        String nombre = "";
        //recorremos el array, de principio a fin
        for (String i : alumnos) {
            //vamos imprimiendo los nombres
            System.out.println(i + ", ");
            //se almacenan en esta variable, para q el metodo me la pueda devolver
            nombre = i;
        }
        return nombre;
    }

    //metodo para introducir las asignarutas
    public void leerAsignaturas(){
        Scanner sc= new Scanner(System.in);

        //recorriendo el total de asignaturas
        for(int i=0; i<totalAsignaturas; i++){
            //ir introduciendo los nombres de las asignaturas
            System.out.print("Introduce el nombre de la asignatura: ");
            String nombreAsignatura= sc.next();
            //las voy almacenando en el array asignaturas
            asignaturas[i]= new Asignatura(nombreAsignatura);
            //en cada celda tenfo un alumno donde tengo que ir introduciendo las notas
            asignaturas[i].leerNotas(totalAlumnos);

            /*en la clase asignatura[por cada celda en la que esta el bucle for],
            * llamo al metodo leernotas (totalalumnos), es decir, por cada asignatura que introduzca
            * leera las notas de todos los alumnos que haya*/
        }
    }

    public String mostrarAsignatura(){
        //variable para ir guardando cada asignatura, mientras va aumentando el array
        String asignatura="";
        //empezando en 0, hasta el ttotal de asignatura
        for (int i=0; i<totalAsignaturas; i++){
            //el string q haya en la celda actual, que lo gguarde en la variable, para despues mostrarla
            asignatura+=asignaturas[i];
        }
        return asignatura;
    }


    //metodo para que devuelva string con los alumnos y sus notas en cada asignatura
    @Override
    public String toString(){
        //calculamos linea a linea

        //formato= se doy un espacio de 30, pero solo ocupo el 25, para que haya distancia
        String principal= String.format("%-30.25s", "Alumno ");
        for (int i=0; i<totalAsignaturas; i++){
            /*le doy un formato distinto a las partes de la asignatura
            * la asignatura que ocupe solo 15, da igual el largo de la palabra
            * el % y el - es obligatorio el uso, las letras cambian dependiendo del tipo de dato con el que tratamos*/
            principal += String.format("%-15s", asignaturas[i].getNombreAsignatura());

            //a la primera frase que se le añada el nombre asignatura
        }

        principal+="\n";

        String lineas="";
        //bucle que me muestra el total de alumnos
        for (int i=0; i<totalAlumnos; i++){
            String muestrNotas="";
            /*en cada linea del alumno tendra un formato, igual que String principal
            * y por cada vuelta del bucle me muestre el alumno correspondiente*/
            String nombre= String.format("%-30.25s", alumnos[i]);

            //por cada alumno del bucle i, me vaya mostrando todas las asignaturas y las notas de ese alumno
            for(int j=0; j<totalAsignaturas; j++){
                //formato diferente a las lineas de las asignaturas, por cada asignatura, me muestra la nota correspondiente
                String notas= String.format("%-15.2f", asignaturas[j].notaAlumno(j));

                //string q me vaya almacenando las notas
                muestrNotas+=notas;
            }
            //string q almacene nombre + notas + un salto de linea
            lineas+=nombre+muestrNotas+"\n";
        }

        //que me devuelva el el String de la oracion principal y las lineas con el nombre y las notas
        return principal + lineas;
    }


    //metodo para que me muestre la media
    public String mostrarMedias(){
        double media;
        String frase="";

        //comprobar q hayan alumnos y asignaturas
        if (asignaturas!=null || alumnos !=null){
            //recorrer las asignaturas de una en una
            for (int i=0; i<totalAsignaturas; i++){
                double sumaNotas=0;

                //recorrer los alumnos de uno en uno
                for (int j=0; i<totalAlumnos; j++){
                    /*media = a la asignatura correspondiente en i, se le suma la nota de todos los alumnos
                    *para averiguar la media de esa asignatura, en base a lo q los alumnos han sacado*/
                    sumaNotas+= asignaturas[i].notaAlumno(j);
                }
                //calcular media en base a la suma total de las notas de todos los alumnos, y dividirla con el total de alumnos
                media= sumaNotas/ totalAlumnos;
                /*que me muestre la frase con formato 15 caracteres para el string, despues salto de linea,
                que hayan 2 numeros despues de la coma flotante, */
                frase+= String.format("%-15s\n%-2f", asignaturas[i].getNombreAsignatura(), media);
            }

        }else{
            System.out.println("Error\nAlumnos o asignaturas no introducidos.");
        }
        return frase;
    }

    //me ha ayudado Carlos
    //metodo para saber de las asignturas en cual se ha sacado la menor nota
    public String dameAsignaturaMinima(){
        String asignatura="";
        double sumaNotas=0;
        //comprobar q hayan alumnos y asignaturas
        if (asignaturas!=null || alumnos !=null){

            double notaMinima = 11;
            //empiezo a recorrer las asignaturas
            for (int i = 0; i < totalAsignaturas; i++) {

                //bucle q recorrre los alumno
                for (int j = 0; j < totalAlumnos; j++) {
                    /*si la asignatura en la q estoy, algun alumno tiene menos nota q la nota minima, se guarda*/
                    if ((asignaturas[i].notaAlumno(j)) < notaMinima) {
                        //guardo la nueva nota minima
                        notaMinima = asignaturas[i].notaAlumno(j);
                        //guardo el nombre de la asignatura
                        asignatura = asignaturas[i].getNombreAsignatura() + ": " +notaMinima;
                    }
                }
            }
        }else{
            System.out.println("Error\nAlumnos o asignaturas no introducidos.");
        }
        return asignatura;
    }


    //metodo para saber de las asignturas en cual se ha sacado la mayor nota
    public String dameAsignaturaMaxima(){
        String asignatura="";
        double sumaNotas=0;
        //comprobar q hayan alumnos y asignaturas
        if (asignaturas!=null || alumnos !=null){

            double notaMaxima = -1;
            //empiezo a recorrer las asignaturas
            for (int i = 0; i < totalAsignaturas; i++) {

                //bucle q recorrre los alumno
                for (int j = 0; j < totalAlumnos; j++) {
                    /*si la asignatura en la q estoy, algun alumno tiene menos nota q la nota minima, se guarda*/
                    if ((asignaturas[i].notaAlumno(j)) > notaMaxima) {
                        //guardo la nueva nota maxima
                        notaMaxima = asignaturas[i].notaAlumno(j);
                        //guardo el nombre de la asignatura
                        asignatura = asignaturas[i].getNombreAsignatura() + ": " +notaMaxima;
                    }
                }
            }
        }else{
            System.out.println("Error\nAlumnos o asignaturas no introducidos.");
        }
        return asignatura;
    }


    /**metodo que devuelve la media de todas las asignaturas de un alumno*/
    public double dameAlumnoMedia(int numAlumno){  //numAlumno del alumno determinado por usuario
        double media=0;

        //comprobar q hayan alumnos y asignaturas
        if (asignaturas!=null || alumnos !=null){

            //empiezo a recorrer las asignaturas
            for (int i = 0; i < totalAsignaturas; i++) {
                //por cada asignatura q recorre el bucle, a media le sumo la nota de esa asignatura
                media+= asignaturas[i].notaAlumno(numAlumno);
            }
            media/=totalAsignaturas;

        }else{
            System.out.println("Error\nAlumnos o asignaturas no introducidos.");
        }

        return media;
    }


    /**metodo para ver la cabtidad de suspensos q tiene el alumno introducido*/
    public int dameAlumnoSuspenso(int numAlumno){  //numAlumno del alumno determinado por usuario
        int suspensos=0;

        //comprobar q hayan alumnos y asignaturas
        if (asignaturas!=null || alumnos !=null){

            //empiezo a recorrer las asignaturas
            for (int i = 0; i < totalAsignaturas; i++) {
                //por cada asignatura q recorre el bucle, comprueba el if si es menor q 5
                if ( asignaturas[i].notaAlumno(numAlumno)<5){
                    suspensos++;
                }
            }


        }else{
            System.out.println("Error\nAlumnos o asignaturas no introducidos.");
        }

        return suspensos;
    }


    /** metodo que me da el nombre del alumno con la mejor media*/
    public String dameMejorAlumnoMedia(){

        String mejorAlumno="";

        if (asignaturas!=null || alumnos !=null){
            //variable con la mjr nota
            double mejorMedia=-1;

            //recorre todos los alumnos
            for (int i=0; i<totalAlumnos; i++){
                /*si del metodo dame alumnos media,
                el alumno i tiene mayor nota que mejor media, que se actualice el valor mejormedia*/
                if ((dameAlumnoMedia(i)> mejorMedia)){
                    //guardar la nueva media
                    mejorMedia= dameAlumnoMedia(i);
                    //guardar el nombre del alumno
                    mejorAlumno= alumnos[i];
                }
            }
        }else{
            System.out.println("Error\nAlumnos o asignaturas no introducidos.");
        }

        return mejorAlumno;
    }


    /** metodo que me va mostrando los alumnos y sus medias*/
    public String muestraMediaAlumnos(){
        String alumnoMasMedia="";

        if (asignaturas!=null || alumnos !=null){
            //recorro los alumnos para coger sus nombres
            for (int i=0; i<totalAlumnos; i++){
                //se muestran los nombres dependiendo de i, asignandoles un formato de 15 caracteres
                //muestre la media del alumno correspondiente a i
                alumnoMasMedia+= String.format("%-15s", alumnos[i], dameAlumnoMedia(i));

            }

        }else{
            System.out.println("Error\nAlumnos o asignaturas no introducidos.");
        }
        return alumnoMasMedia + "\n";
    }


    /**metodo para mostrar q alumnos tienen la posibilaidad de repetir curso*/
    public void muestraRepetidores(){
        if (asignaturas!=null || alumnos !=null){
            //recorro los alumnos para coger sus nombres
            for (int i=0; i<totalAlumnos; i++){
                /*si en el alumno q estoy, sus suspensos son mayores o igual q 2, imprimir nombre
                * utilizo em metodo ya creado para contar los suspensos de cada alumno*/
                if (dameAlumnoSuspenso(i)>=2){
                    System.out.println(alumnos[i]);
                }

            }

        }else{
            System.out.println("Error\nAlumnos o asignaturas no introducidos.");
        }
    }



}
