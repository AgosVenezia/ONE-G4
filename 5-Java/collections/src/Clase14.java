//import com.alura.model.Alumno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;

public class Clase14 {

     public static void main(String[] args) {

        Alumno alumno1 = new Alumno("Luis Miguel", "001");
        Alumno alumno2 = new Alumno("Pepito los palotes", "002");
        Alumno alumno3 = new Alumno("Juan Carlos", "003");
        Alumno alumno4 = new Alumno("Pedro Pedrito", "004");
        Alumno alumno5 = new Alumno("Gustavo Sanchez", "005");
        Alumno alumno6 = new Alumno("Marcia Maria", "006");
        Alumno alumno7 = new Alumno("Claudia Patricia", "007");

        Collection<Alumno> listaAlumnos = new HashSet<>();
        //Collection<Alumno> listaAlumnos = new ArrayList<>();

        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);
        listaAlumnos.add(alumno4);
        listaAlumnos.add(alumno5);
        listaAlumnos.add(alumno6);
        listaAlumnos.add(alumno7);

        Alumno alumnoNuevo = new Alumno("Luis Miguel", "001");

        //System.out.println(listaAlumnos.contains(alumno1));
        System.out.println(alumno1.equals(alumnoNuevo));
        System.out.println(listaAlumnos.contains(alumnoNuevo));
    }
}

/*
El hash es un código del objeto que va a crear y cada vez que tenga un código parecido, lo va a agrupar en el mismo bloque. Tenemos que sobrescribir nuestra clase hash, nuestro método hashCode. Entonces quiere decir que nuestro string va a tener un código hash y cuando nosotros creamos nuestra lista HashSet, él ya va a agruparlo de acuerdo a los códigos que están siendo creados. Nuestros códigos hash, que son específicamente nombre.
Entonces cuando ya hagamos la búsqueda, por ejemplo, con el contains va a dar True. ¿Por qué? Porque él ya va a saber en cuál cajita él va entrar para buscar ese tipo de alumno que yo estoy queriendo, que por ejemplo sería Luis Miguel. Entonces, se hace mucho más fácil. Esa es una diferencia bien grande entre lo que hacemos con un ArrayList y lo que hacemos con un HashSet o con cualquier tipo de hash.
Por eso siempre es bueno, si utilizamos equals, tratemos de utilizar también el HashCode. Y si estamos utilizando una comparación con nombre, también que nuestro HashCode sea con un nombre. Porque así se va a hacer mucho más fácil después a nosotros tratar de cambiar, y aquí queremos que sea por ejemplo new ArrayList y va a ejecutar, y perfecto, va a dar true también.
*/