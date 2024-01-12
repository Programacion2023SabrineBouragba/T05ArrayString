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
}
