public class EjemploScope {  //SCOPE es todo lo que está entre llaves {}
    public static void main(String[] args) {
        int edad = 21;
        int cantidadPersonas = 2;
        // System.out.println("El valor de la condición es: " + esPareja); // No compila porque esPareja todavía no está inicializada

        boolean esPareja;
        if (cantidadPersonas > 1) {
            esPareja = true;
        } else {
            esPareja = false; // Hay que inicializar las dos para que después compile
        }

        boolean puedeEntrar = edad >= 18 && esPareja;
        System.out.println("El valor de la condición es: " + esPareja);

        if (puedeEntrar) {
            System.out.println("Sea bienvenido");
        } else {
            System.out.println("Usted no está permitido a entrar");
        }
    }
}