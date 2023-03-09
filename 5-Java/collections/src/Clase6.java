import java.util.ArrayList;

public class Clase6 {

    public static void main(String[] args) {

        //Curso curso1 = new Curso("Java",30, new ArrayList<>());
        Curso curso1 = new Curso("Java",30);
        curso1.addAula(new Aula("ArrayList"));
        curso1.addAula(new Aula("List"));
        curso1.addAula(new Aula("LinkedList"));


        ArrayList<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);

        System.out.println(cursos.get(0).getAulaList());
    }
}

/*
Entonces, aquí lo que estamos viendo en la clase 6, es utilizar la clase curso para adicionar una lista dentro de esa clase. Una vez hecho esto, hemos adicionado una clase llamada ArrayList y después hemos impreso esa misma clase.
*/