import java.util.Optional;

public class Clase18 {

     public static void main(String[] args) {

        Curso curso1 = new Curso("Historia",30) ;

        Alumno alumno1 = new Alumno("Luis Miguel", "001");
        Alumno alumno2 = new Alumno("Pepito los palotes", "002");
        Alumno alumno3 = new Alumno("Juan Carlos", "003");
        Alumno alumno4 = new Alumno("Pedro Pedrito", "004");
        Alumno alumno5 = new Alumno("Gustavo Sanchez", "005");
        Alumno alumno6 = new Alumno("Marcia Maria", "006");
        Alumno alumno7 = new Alumno("Claudia Patricia", "007");

        curso1.addAlumno(alumno1);
        curso1.addAlumno(alumno2);
        curso1.addAlumno(alumno3);
        curso1.addAlumno(alumno4);
        curso1.addAlumno(alumno5);
        curso1.addAlumno(alumno6);
        curso1.addAlumno(alumno7);

        curso1.getAlumnos().forEach(alumno -> System.out.println(alumno));

        //curso1.getAlumnos().stream().filter(a -> a.getCodigo().equalsIgnoreCase("003"));
        //curso1.getAlumnos().stream().filter(a -> "003".equalsIgnoreCase(a.getCodigo())).findFirst();
        Optional<Alumno> alumno = curso1.getAlumnos().stream().filter(a -> "003".equalsIgnoreCase(a.getCodigo())).findFirst();

        if(alumno.isPresent()){
            System.out.println(alumno.get());
        }

/*
Un mapa es una interfaz, hace parte del package java.util no posee métodos de la interfaz Collection, trabaja bajo un concepto de (llave, valor).
*/

        Alumno alumnoMap = curso1.getAlumnoMap().get("003");

        System.out.println(alumnoMap);

    }
}