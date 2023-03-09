import java.util.*;
import java.util.stream.Collectors;

public class Clase10 {

    public static final List<List<Integer>> listas = new ArrayList<List<Integer>>(){
        {
            add(new LinkedList<>());
            add(new ArrayList<>());
        }
    };

    public static void main(String[] args) {
        Curso curso1 = new Curso("Historia",30) ;
        Curso curso2 = new Curso("Algebra",10) ;
        Curso curso3 = new Curso("Aritmetica",20) ;
        Curso curso4 = new Curso("Geometria",50) ;
        Curso curso5 = new Curso("Fisica",60) ;
        Curso curso6 = new Curso("Quimica",80) ;
        Curso curso7 = new Curso("Quimica",70) ;
        Curso curso8 = new Curso("Fisica",30) ;



        ArrayList<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        cursos.add(curso5);
        cursos.add(curso6);
        cursos.add(curso7);
        cursos.add(curso8);


        //List<Curso> cursoList = cursos.stream().filter(curso -> !curso.getNombre().equalsIgnoreCase("Ruby")).sorted(Comparator.comparingInt(Curso::getTiempo)).collect(Collectors.toList());

        System.out.println(cursos.stream().filter(curso -> !curso.getNombre().equalsIgnoreCase("Historia")).mapToInt(Curso::getTiempo).sum());

        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).sum());

        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).average());
        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).average().getAsDouble());

        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).max());
        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).max().getAsInt());

        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).min());
        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).min().getAsInt());

        Map<String, List<Curso>> groupCurso = cursos.stream().collect(Collectors.groupingBy(Curso::getNombre));

        groupCurso.forEach((key , value) -> System.out.println(key + " - " + value.size()));

        System.out.println(cursos.parallelStream().mapToInt(Curso::getTiempo).sum());

    }
}

/*
El parallelStream se va a encargar de hacer tipo un stream en threads. ¿Qué cosa? Cuando yo tengo en threads por ejemplo él va a separar el número de cursos, tenemos cuatro cursos, él va a separar en cuatro threads. Así supongamos que nosotros queramos sumar toda una cantidad, podemos obtener un resultado mucho más rápido que hacer un stream simple por ejemplo. ¿Para qué opción utilizar parallelStream y para cuál no? Voy a dar un ejemplo. Imaginemos que nosotros queremos el número máximo, y queremos el número máximo utilizando el parallelStream. Al tener cuatro threads, puede ser que el número máximo él tenga como 50, porque ese fue el último stream que obtuvo, y no 60, ahí podemos hacer un error. Igual con el mínimo. Si queremos un filtro con geometría o aritmética, va a ser más rápido, porque él va a separar en cuatro threads, como que va a dividir en cuatro bloques nuestra lista y va a procurar aritmética mucho más rápido. La búsqueda será mejor.
*/