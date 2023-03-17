public class Clase19 {

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

        //curso1.getAlumnos().forEach(alumno -> System.out.println(alumno));

        Alumno alumnoMap = curso1.getAlumnoMap().get("003");

/*
Un mapa trabaja bajo un concepto de (llave, valor), al tener una llave única por ejemplo un DNI, termina siendo más rápido la búsqueda de información.
*/

        //curso1.getAlumnoMap().forEach((key, value) -> {
        curso1.getAlumnoMap().forEach((codigo, alumno) -> {
            System.out.println(alumno);
        });

        System.out.println(alumnoMap);

    }
}

/*
Y aquí vamos a ver los siguiente. Primero, existen más tipos de mapas. Uno de ellos que podemos usar es el HashMap, que es el más común y tenemos también el LinkedHashMap. ¿Qué hacemos con el LinkedHashMap? Cada vez que nosotros hacemos un put, que sería nuestro add para un collection, cada vez que nosotros damos un Put estamos adicionando un valor a nuestro Map. Pero utilizando el LinkedHashMap lo adicionamos en orden, utilizando el HashMap, él lo va a adicionar de la forma que sea conveniente. Ese en un punto importante a tener presente. Utilidad no sabría decirlo, dependiendo de la necesidad tal vez se necesite colocar en orden, pero es importante también conocerlo. Para esto, por ejemplo, aquí ya vimos que con un get ya tenemos la posición, ya sabemos lo que queremos, el "003", el key "003". Entonces ya sabemos dónde está. Es como por ejemplo hicimos el ejemplo en la clase anterior, tenemos el mapa mundial. Queremos Rusia. Ya sabemos dónde está Rusia. Queremos Brasil, ya sabemos dónde está Brasil. Lo mismo funciona el mapa. Por eso también tiene ese nombre, entonces aquí tenemos getAlumnoMap().get("003"); ya sabe dénde ir. Entonces esa parte de ese uso se hace mucho más sipmle y mucho más rápido al utilizar una lista. Porque por ejemplo nosotros podemos utilizar aquí el alumnoMap, que sería aquí la lista de alumnos que es curso1.getAlumnoMap().forEach aquí utilizamos el key y el value, utilizamos nuestro lambda. Pero aquí key y value, porque estoy diciendo que yo quiero que el key en la posición y aquí sería el value, aquí puedo poner código. Y aquí puedo colocar alumno. Cualquier valor, solamente que tenemos que respetar que primero va a ser el key y el segundo va a ser el value. Entonces aquí damos aquí System.out.println y colocamos (alumno). Vamos a comentar, aquí, y vamos a ejecutar. También hace un list exactamente. Pero entonces tenemos una peculiaridad, una cosa bien interesante aquí. Nosotros cuando utilizamos ese forEach aquí estuvimos recorriendo prácticamente todos nuestros alumnos. Utilizamos ahí el filter, buscamos ahí uno por uno. El primero que tenga el 003 sale. Imaginémonos que tengamos un millón de registros y el 003 justo es nuestro último registro. Entonces, eso quiere decir que nuestro forEach va a ir hasta el último registro a buscar ese 003 y nos va a traer unos resultados. Eso tampoco es muy performático, por eso utilizamos el mapa. Si ya sabemos que eso de ahí va a ser único, es mejor utilizar mapa. Porque también tenemos las mismas propiedades para poder buscar en el mapa, para poder ver dentro de él y la parte del get se hace mucho más simple y fuera de todo eso se hace mucho más performático. Entonces eso es lo que quería dejar bien claro en esa parte. 
*/