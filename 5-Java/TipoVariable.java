public class TipoVariable {

    public static void main(String[] args) {
        System.out.println("Hola Mundo!!!");

        int edad = 28;  //valores enteros
        System.out.println(edad);

        edad = 47;
        System.out.println(edad);

        edad = 46 + 88;
        System.out.println("Mi edad es " + edad);

        edad = 30;
        System.out.println("La edad es "+ edad + ", Felicitaciones!");

        double salario = 1250.56;  //valores decimales
        System.out.println(salario);

        double edad2 = 28;  //double acepta valores enteros
        System.out.println(edad2);

        double salarioMitad = salario / 2;
        System.out.println(salarioMitad);

        int division = 1250 / 3;  //la división con int redondea el resultado
        System.out.println(division);

        double peso = 4.0;
        int cantidad = 10;
        System.out.println (peso * cantidad);

        double precio = 5.5;
        int tickets = 4;
        System.out.println (precio * tickets);

        int dia = 4; 
        int otroDia = 4 + dia;
        System.out.println (otroDia);

        double variable1 = 230.89;
        int variable1Entero = (int) variable1; // Cast - fuerza la conversión a entero (no redondea, sólo corta los decimales)
        // COMENTARIO 
        // Este método imprime en consola
        System.out.println (variable1Entero);

        double resultado = variable1 + variable1Entero;
        System.out.println (resultado);

        int resultado2 = (int) variable1 + variable1Entero;
        System.out.println (resultado2);

        long prueba = 1222222222222222222L; // Soporta 64 bits, 2 a la 63 positivo y negativo, -1 porque tiene el cero  // Poner la L al final
        System.out.println (prueba);
        short numeroPequeno = 13555; // 2 a la 16
        System.out.println (numeroPequeno);
        byte numeroAunMasPequeno = 15; // Soporta 8 bytes
        System.out.println (numeroAunMasPequeno);
        float numeroDecimalPequeno = 2.5F; // Soporta decimales, pero es más pequeño que double // Poner la F al final
        System.out.println (numeroDecimalPequeno);

        int edadMarcos= 30;
        System.out.println ("La edad de Marcos es " + edadMarcos + "!");

        double edadM = 30.0;
        System.out.println ("La edad de Marcos es " + (int) edadM + "!");

    }
    
}