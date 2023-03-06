public class Flujo3 {
    public static void main(String[] args) {
        System.out.println("Inicio main");
        try {
            metodo1();
        //} catch (MiException | ArithmeticException e) {
        //} catch (Exception e) {
        } catch (MiException e) {
            e.printStackTrace();
        }
        System.out.println("Fin main");
      }
      
      private static void metodo1() throws MiException {
        System.out.println("Inicio metodo1");
        metodo2();
        System.out.println("Fin metodo1");
      }

      private static void metodo2() throws MiException {
          System.out.println("Inicio metodo2");
          //int a = 50/0;
          //Cuenta c = null;
          //c.deposita();
          throw new MiException("Mi excepción fue lanzada");

        }

    // THROW: lanzar directamente el objeto en forma de excepción
}
