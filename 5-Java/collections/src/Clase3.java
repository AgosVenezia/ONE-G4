import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clase3 {
    
    public static void main(String[] args) {
        String curso1 = "Geometría";
        String curso2 = "Física";
        String curso3 = "Química";
        String curso4 = "Historia";

        ArrayList<String> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        System.out.println(cursos);

        // Ordena de forma ascendente
        Collections.sort(cursos);
        System.out.println(cursos);
        cursos.sort(Comparator.naturalOrder());
        System.out.println(cursos);
        //cursos.stream().sorted().collect(Collectors.toList()); // Devuelve una lista nueva
        List<String> cursosList = cursos.stream().sorted().collect(Collectors.toList());
        System.out.println(cursosList);

        // Ordena de forma descendente
        Collections.sort(cursos, Collections.reverseOrder());
        System.out.println(cursos);
        cursos.sort(Comparator.reverseOrder());
        System.out.println(cursos);

    }
}

/* 
Tres formas de ordenar: utilizando la clase collections, utilizando el método sort del mismo ArrayList o también utilizando streams.
*/