
public class Flujo {

	public static void main(String[] args) {
        System.out.println("Inicio main");
        metodo1();
        System.out.println("Fin de main");
    }

    private static void metodo1() {
        System.out.println("Inicio de metodo1");
        try {
            metodo2();
        } catch(ArithmeticException ex) {
            System.out.println("ArithmeticException");
        }
        System.out.println("Fin de metodo1");
    }

    private static void metodo2() {
        System.out.println("Inicio de metodo2");
        for(int i = 1; i <= 5; i++) {
            System.out.println(i);
            int a = i / 0;
        }
        Cuenta c = null;
        c.deposita();
        
        System.out.println("Fin de metodo2");
    }

	
}
