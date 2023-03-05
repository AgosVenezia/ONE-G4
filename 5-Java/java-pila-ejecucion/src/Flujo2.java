public class Flujo2 {
    public static void main(String[] args) {
        System.out.println("Inicio main");
        metodo1();
        System.out.println("Fin main");
      }
      
      private static void metodo1() {
        System.out.println("Inicio metodo1");
        try {
            metodo2();
        } catch (MiException me) {
            me.printStackTrace();
        }
        //metodo2();
        System.out.println("Fin metodo1");
      }

      private static void metodo2() throws MiException {
          System.out.println("Inicio metodo2");
          //ArithmeticException ae = new ArithmeticException();
          //throw ae; // Lanzar una excepción
          //throw new ArithmeticException();
          throw new MiException("Mi excepción fue lanzada");
          //System.out.println("Fin metodo2");
        }

    // THROW: lanzar directamente el objeto en forma de excepción
}
