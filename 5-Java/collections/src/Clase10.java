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
El parallelStream se va a encargar de hacer tipo un stream en threads. ??Qu?? cosa? Cuando yo tengo en threads por ejemplo ??l va a separar el n??mero de cursos, tenemos cuatro cursos, ??l va a separar en cuatro threads. As?? supongamos que nosotros queramos sumar toda una cantidad, podemos obtener un resultado mucho m??s r??pido que hacer un stream simple por ejemplo. ??Para qu?? opci??n utilizar parallelStream y para cu??l no? Voy a dar un ejemplo. Imaginemos que nosotros queremos el n??mero m??ximo, y queremos el n??mero m??ximo utilizando el parallelStream. Al tener cuatro threads, puede ser que el n??mero m??ximo ??l tenga como 50, porque ese fue el ??ltimo stream que obtuvo, y no 60, ah?? podemos hacer un error. Igual con el m??nimo. Si queremos un filtro con geometr??a o aritm??tica, va a ser m??s r??pido, porque ??l va a separar en cuatro threads, como que va a dividir en cuatro bloques nuestra lista y va a procurar aritm??tica mucho m??s r??pido. La b??squeda ser?? mejor.
*/