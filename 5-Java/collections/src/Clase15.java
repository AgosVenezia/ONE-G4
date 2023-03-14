//import java.util.Collection;
//import java.util.HashSet;

public class Clase15 {

    public static void main(String[] args) {

        Curso curso1 = new Curso("Historia",30) ;

        Alumno alumno1 = new Alumno("Luis Miguel", "001");
        Alumno alumno2 = new Alumno("Pepito los palotes", "002");
        Alumno alumno3 = new Alumno("Juan Carlos", "003");
        Alumno alumno4 = new Alumno("Pedro Pedrito", "004");
        Alumno alumno5 = new Alumno("Gustavo Sanchez", "005");
        Alumno alumno6 = new Alumno("Marcia Maria", "006");
        Alumno alumno7 = new Alumno("Claudia Patricia", "007");

        //Collection<Alumno> listaAlumnos = new HashSet<>();
        
        curso1.addAlumno(alumno1);
        curso1.addAlumno(alumno2);
        curso1.addAlumno(alumno3);
        curso1.addAlumno(alumno4); 
        curso1.addAlumno(alumno5);
        curso1.addAlumno(alumno6);
        curso1.addAlumno(alumno7);

        Alumno alumnoNuevo = new Alumno("Luis Miguel", "001");

        System.out.println(alumno1.equals(alumnoNuevo));
        //System.out.println(listaAlumnos.contains(alumnoNuevo));
        //System.out.println(curso1.contains(alumnoNuevo));
        //System.out.println(curso1.getAlumnos().contains(alumnoNuevo));
        System.out.println(curso1.verificaAlumno(alumnoNuevo));
    }
}

/*
Prácticamente lo que estuvimos haciendo aquí ¿qué cosa fue? Fue prácticamente externalizar, dejar un poco más responsabilidad a nuestra clase curso, prácticamente, para que él tenga todo lo que sea relacionado a alumno, aula, tal vez matrícula, lo que sea necesario.
Y aquí en nuestros ejemplos utilizar prácticamente lo que necesitamos, que sería adicionar. Ya no necesitamos aquí adicionar porque ya tenemos el método adicionar y eso facilita también, ¿qué cosa? Que podemos cambiar los tipos que nosotros queramos y solamente ejecutamos en un solo lado y prácticamente va a afectar a todas nuestras clases que utilizan ese tipo de implementación.
Esa parte es muy importante siempre usarla. No dejar que muchas cosas de lógica estén dentro prácticamente de alguna regla, sino que prácticamente todo esté dentro de nuestras clases que estamos creando. Y en la parte de ejecución simplemente tengamos ya los métodos ya para usar.
*/