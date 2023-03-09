import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Clase8 {

    public static final List<List<Integer>> listas = new ArrayList<List<Integer>>(){
        {
            add(new LinkedList<>()); // No es necesario repetir el <Integer>
            add(new ArrayList<>());
        }
    };

    public static void main(String[] args) {
        for(List<Integer> lista : listas) {
            final String nombreImplementacion = lista.getClass().getSimpleName();
            //add
            long inicio = System.currentTimeMillis();
            for (int i=0; i < 100000; i++) {
                lista.add(i);
            }
            long fin = System.currentTimeMillis();
            long duracion = fin - inicio;
            System.out.println(nombreImplementacion + " add: " + duracion);

            //get
            inicio = System.currentTimeMillis();
            for(int i = 0; i < 100000; i++) {
                lista.get(i);
            }
            fin = System.currentTimeMillis();
            duracion = fin - inicio;
            System.out.println(nombreImplementacion + " get: " + duracion);

            //remove
            inicio = System.currentTimeMillis();
            for(int i = 99999; i >= 0; i--) {
                lista.remove(i);
            }
            fin = System.currentTimeMillis();
            duracion = fin - inicio;
            System.out.println(nombreImplementacion + " remove: " + duracion);


            //LINKEDLIST: A <-> B1 <-> B2 <-> C <-> D

            //ARRAYLIST: A -> B1 -> B -> C -> D
        }

    }
}

/*
En el ArrayList, el get conseguimos hacer de una forma mucho más eficiente que LinkedList. El remove puede ser casi parecido. El add tuvo una cierta limitación en LinkedList, pero ahora viene lo siguiente. Cuando tenemos, vamos a comentar aquí, un LinkedList, la ventaja es que nosotros podemos adicionar en cualquier lugar de LinkedList, en cualquier posición y lo va a hacer de una forma más rápida que un ArrayList. Por ejemplo, en LinkedList, cuando crea una lista, va creando tipo una relación entre ellas. ¿Qué es lo que hace? Por ejemplo, queremos adicionar en esta posición, el LinkedList automáticamente, ¿qué hace? Quita esta lista de aquí, quita esto de aquí y lo entrelaza. Entonces aquí tendríamos B1 por ejemplo, y automáticamente tendría aquí el B2. Muy diferente al ArrayList. En ArrayList nosotros vamos tipo de un sentido. ¿Qué sucede? Cuando hacemos el ArrayList un add por ejemplo, ¿qué vamos a hacer? El ArrayList, si queremos en la posición 2, ¿qué va a hacer? Esta posición sería 0 y la posición 1. Pero sería el número 2. ¿Qué hacemos? El ArrayList hace aquí lo siguiente: remueve esto de aquí, adiciona entonces sería 3, 4 y5 y aquí colocaría el B1. Entonces, si nosotros tenemos una lista de 1.000.000 de registros, por ejemplo, imaginemos que los quiero adicionar en la posición 3. Él va a empujar desde la posición 4 hasta la posición 1.000.000, va a empujar toda la lista +1, +1, +1 y va a demorar bastante. Pero en el LinkedList, lo que él hace es simplemente, quita la relación de una, adiciona con otro y listo. Es mucho más eficiente. Pero para hacer los gets, es menos eficiente. Y el remove prácticamente sigue siendo casi igual en los 2. Entonces cada uno tiene sus ventajas, pero por eso también estuvimos viendo utilizar las interfaces. ¿Por qué? Porque imaginémonos que ya tenemos una lista, ya tenemos el sistema y utilizamos ArrayList y vemos que está demorando bastante. ¿Qué hacemos? Vamos a cambiarlo para el LinkedList. La parte de adicionar las posiciones está demorando bastante, entonces cambiamos para LinkedList. Y automáticamente toda nuestra lista se convirtió en LinkedList. Por eso es una gran ventaja trabajar prácticamente con nuestra interface lista y todas las implementaciones que usemos, las podemos cambiar de aquí a un tiempo.
*/