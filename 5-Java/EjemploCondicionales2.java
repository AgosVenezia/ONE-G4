public class EjemploCondicionales2 {
    public static void main(String[] args) {
        
        int edad = 17;
        int cantidadPersonas = 2;

        if (edad >= 18 || cantidadPersonas >= 2) {
            System.out.println("Usted puede entrar");
        } else {
            System.out.println("Usted no está permitido a entrar");
        }

        edad = 21;
        boolean esPareja = cantidadPersonas > 1;
        boolean puedeEntrar = edad >= 18 && esPareja;
        System.out.println("El valor de la condición es: " + esPareja);

        if (puedeEntrar) {
            System.out.println("Sea bienvenido");
        } else {
            System.out.println("Usted no está permitido a entrar");
        }


        int edad2 = 68;
        boolean esAnciano = edad2 >= 65;
        System.out.println (esAnciano);
    }
}

// Un signo = significa atribución de valor, mientras que dos == compara la igualdad