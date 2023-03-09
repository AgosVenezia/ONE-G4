import java.util.*;
import java.util.stream.Collectors;

public class Clase9 {

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


        ArrayList<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);

        System.out.println(cursos); // Lista de todos los cursos

        Collections.sort(cursos,Comparator.comparing(Curso::getNombre).reversed());

        int tiempo = 0;
        for (Curso curso : cursos) {
            tiempo += curso.getTiempo();
        }
        System.out.println(tiempo); // Tiempo total de todos los cursos
        
        int mayor = 0;
        for (Curso curso : cursos) {
            if (curso.getTiempo() > mayor) {
                mayor = curso.getTiempo();
            }
        }
        System.out.println(mayor); // Tiempo máximo de todos los cursos

        int suma = 0;
        for(Curso curso: cursos) {
            if(!curso.getNombre().equalsIgnoreCase("Historia")) {
                suma += curso.getTiempo();
            }
        }
        System.out.println(suma); // Tiempo total de todos los cursos que no son Historia

        List<Curso> cursoList = cursos.stream().filter(curso -> !curso.getNombre().equalsIgnoreCase("Ruby")).sorted(Comparator.comparingInt(Curso::getTiempo)).collect(Collectors.toList());
        System.out.println(cursoList); // Lista de todos los cursos que no son Ruby

        System.out.println(cursos.stream().mapToInt(Curso::getTiempo)); // Espacio en memoria
        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).sum()); // Suma de los tiempos de todos los cursos
        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).max()); // Tiempo máximo de todos los cursos
        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).max().getAsInt()); // Tiempo máximo de todos los cursos como entero
        System.out.println(cursos.stream().mapToInt(Curso::getTiempo).min()); // Tiempo mínimo de todos los cursos
        
        System.out.println(cursos.stream().filter(curso -> !curso.getNombre().equalsIgnoreCase("Historia")).mapToInt(Curso::getTiempo).sum()); // Suma de los tiempos de todos los cursos que no son Historia

    }
}
