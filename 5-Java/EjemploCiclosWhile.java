public class EjemploCiclosWhile {

    public static void main(String[] args) {
        
        int contador = 0;

        while(contador <= 10) { // mientras que (condición=true)
            // Ejecuta esto
            System.out.println(contador);
            // contador = contador + 1;
            // contador += 3;
            contador++; // o ++contador;
        }
    }
}