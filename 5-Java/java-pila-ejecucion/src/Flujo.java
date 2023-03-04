// Una excepción es un objeto: tiene nombre y mensaje, atributos y métodos. Explica el error ocurrido.

public class Flujo {

    public static void main(String[] args) {
      System.out.println("Inicio main");
      metodo1();
      System.out.println("Fin main");
    }
    
    public static void metodo1() {
      System.out.println("Inicio metodo1");
      metodo2();
      System.out.println("Fin metodo1");
    }
    
    /*public static void metodo2() {
      System.out.println("Inicio metodo2");
      for(int i =1; i<= 5; i++) {
        System.out.println("i");
        int num = 0;
        int resultado = i/num; // / by zero
        System.out.println(resultado);
      }
      System.out.println("Fin metodo2");
    }*/

    public static void metodo2() {
        System.out.println("Inicio metodo2");
        for(int i =1; i<= 5; i++) {
          System.out.println("i");

          try { // Intenta esto

            if (i == 3) {
                int num = 0;
                int resultado = i/num; // / by zero
                System.out.println(resultado);
            }
            
            String test = null;
            System.out.println(test.toString());

        /*  } catch (ArithmeticException exception) { // Atrapa el error
            System.out.println("Atrapo Arithmetic");
            System.out.println(exception.getMessage());
            exception.printStackTrace();
          } catch (NullPointerException exception) { // Atrapa el error
            System.out.println("Atrapo NullPointer");
            System.out.println(exception.getMessage());
            exception.printStackTrace();
          } */

            } catch (ArithmeticException | NullPointerException exception) { // Atrapa el error
            System.out.println("Atrapo Excepción");
            System.out.println(exception.getMessage());
            exception.printStackTrace();
            }
        }
        System.out.println("Fin metodo2");
      }

  }