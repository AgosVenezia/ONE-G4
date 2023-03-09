import java.util.ArrayList;
import java.util.List;

public class Clase7 {

    public static void main(String[] args) {

        Curso curso1 = new Curso("Java",30) ;
        curso1.addAula(new Aula("ArrayList"));
        curso1.addAula(new Aula("List"));
        curso1.addAula(new Aula("LinkedList"));
        curso1.addAula(new Aula("Inmutable")); // Desde aquí si se puede añadir

        List<Aula> aulaList = curso1.getAulaList();
        //aulaList.add(new Aula("Inmutable")); // Como es inmutable, ya no se puede modificar el contenido de la lista desde aquí

        ArrayList<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);

        //System.out.println(cursos.get(0).getAulaList());

        System.out.println(aulaList);
    }
}