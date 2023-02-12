public class EjercicioMatriz {  // Matriz = cuadrícula
    
    public static void main(String[] args) {
        
        for (int fila = 0; fila <= 10; fila++) {
            //for (int columna = 0; columna <= 10; columna++) {
                //if (columna > fila) {
                    //break;  // rompe el ciclo for más interno aunque la condición siga siendo true
                //}
            for (int columna = 0; columna < fila; columna++) {    
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}