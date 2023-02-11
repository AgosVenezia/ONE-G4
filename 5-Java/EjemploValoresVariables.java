public class EjemploValoresVariables {
    public static void main(String[] args) {
        
        int numero1 = 5;
        int numero2 = 9;

        System.out.println(numero2); // 9

        numero2 = numero1; // 5
        System.out.println(numero2);

        numero1 = 88;
        // numero2 = ????
        System.out.println(numero2); // Sigue siendo 5 porque ya se le asignó ese valor anteriormente

        String saludo = "Hola, mi nombre es ";
        String nombre = "Rómulo ";
        String continuacion = "y mi edad es ";
        int edad = 100;
        System.out.println (saludo + nombre + continuacion + edad);

    }
}