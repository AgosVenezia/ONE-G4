import java.util.Iterator;

public class Clase17 {

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

        //for (int i)
        //for (Alumno alumno : curso1.getAlumnos()) {
            
        //}
        
        //curso1.getAlumnos().stream().filter().forEach(alumno -> System.out.println(alumno));

        Iterator<Alumno> alumnoIterator = curso1.getAlumnos().iterator();

        while (alumnoIterator.hasNext()){
            System.out.println(alumnoIterator.next());
        }

        alumnoIterator.next();
    }
}

/*
Entonces no sabemos si vamos a trabajar con set, con list, entonces nuestro atributo va a ser un collection y cualquier situación, lo cambiamos. Ahora, si ya sabíamos, si es set, tenemos que también utilizar nuestro equals y hashCode para poder hacer las comparaciones por el hash, qué es lo que el hashSet y el linked hashSet piden. Entonces existen esos pequeños detalles que de acuerdo a nuestras necesidades van a surgir por qué usar uno, por qué usar el otro.
En la mayoría de las situaciones va a ser también un poco de performance, porque por ejemplo queremos adicionar una lista, un valor a una lista o queremos modificar una lista, tal vez más rápido sea el hashSet. Queremos remover, tal vez los dos sean iguales. Queremos la posición tal, tal vez sea mejor el list. No nos interesa la posición, puede ser el hashSet. Queremos recorrer una lista con un while, podemos utilizar el iterator. Queremos recorrerlo con lambda, podemos utilizar el forEach de lambda. Queremos utilizar filter, podemos utilizar el forEach del mismo modo. Podemos convertir nuestra lista en string y utilizamos el filter también.
*/