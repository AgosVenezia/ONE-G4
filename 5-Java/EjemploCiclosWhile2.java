public class EjemploCiclosWhile2 {
    
    public static void main(String[] args) {
        
        int contador = 0;
        int total = 0;

        while (contador <= 10){
            total = total + contador;
            System.out.println(total); // muestra la suma uno por uno
            contador++;
        }

        System.out.println(total); // muestra total de la suma
    }
}