public class PruebaConstructor {
    public static void main(String[] args) {
        //Cuenta cuenta = new Cuenta();
        //Cuenta cuenta = new Cuenta(-33);
        
        // clase variable = instancia  // la clase define a la instancia
        Cuenta cuenta1 = new Cuenta(555); // El constructor te obliga a informar los parámetros desde su nacimiento.
        //cuenta.setAgencia(-4);
        //cuenta.setAgencia(665);
        Cuenta cuenta2 = new Cuenta(330);
        Cuenta cuenta3 = new Cuenta(912); // Las tres tienen en común la variable static

        System.out.println(cuenta1.getAgencia()); // No cuenta valores negativos e inicializa con 0 por defecto
    }
}
