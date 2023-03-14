import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Clase11 {

    // TODO: https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html
    // TODO: https://docs.oracle.com/javase/8/docs/api/index.html?java/util/Collection.html

    public static void main(String[] args) {

        String alumno1 = "Luis Miguel";
        String alumno2 = "Pepito los palotes";
        String alumno3 = "Juan Carlos";
        String alumno4 = "Pedro Pedrito";
        String alumno5 = "Gustavo Sanchez";
        String alumno6 = "Marcia Maria";
        //String alumno7 = "Marcia Maria"; // Con set no se puede repetir el mismo nombre
        //String alumno8 = "Gustavo Sanchez";

        Set<String> listaAlumnos = new HashSet<>();

        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);
        listaAlumnos.add(alumno4);
        listaAlumnos.add(alumno5);
        listaAlumnos.add(alumno6);

        for (String alumno: listaAlumnos) {
            System.out.println(alumno);
        }

    }
}

/*
El orden en un set, prácticamente no tiene un orden, mejor dicho, un set. Él va a almacenarlo tipo en un círculo y va a colocar todos los alumnos dentro de ese círculo. Entonces de obtener uno va a ser un poco más difícil. Ya no existe una posición específica. Esa es una gran diferencia prácticamente lo que tenemos en la clase, utilizando la interface set. Implementando la clase, la implementación a través de la HashSet.
*/