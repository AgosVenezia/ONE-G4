public class EjemploCiclosFor {

    public static void main(String[] args) {
        
        //    variable          condición       ejecuta al FINAL
        for (int contador = 0; contador <= 10; contador ++) {
            System.out.println(contador);
        }

        // System.out.println(contador);  // no compila porque contador no existe fuera del scope del for
    }
    
}