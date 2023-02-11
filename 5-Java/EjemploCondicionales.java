public class EjemploCondicionales {
    public static void main(String[] args) {  // ATAJO main
        System.out.println("Hello world");  // ATAJO sysout

        int edad = 17;
        int cantidad = 2;

        if (edad >=18)  // Sin llaves sólo ejecuta el primer comando, sino pasa al siguiente
            System.out.println("Usted puede entrar");
        System.out.println("Bienvenido");

        if (edad >=18) {
            System.out.println("Usted puede entrar");
        }
        else {
            if (cantidad >=2) {
                System.out.println("Usted es menor de edad pero está permitido su ingreso");
            } else
            System.out.println("Usted no está permitido a entrar");
        }
    }
}