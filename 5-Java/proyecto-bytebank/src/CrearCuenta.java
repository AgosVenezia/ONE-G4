public class CrearCuenta {
    public static void main(String[] args) {
        // Variable          = Valor
        // Variable (hace referencia) -> 123FFD (lugar en la memoria)
        Cuenta primeraCuenta = new Cuenta();
        primeraCuenta.saldo = 1000;
        // primeraCuenta.pais = "Perú"; // No compila!
        System.out.println(primeraCuenta.saldo);

        Cuenta segundaCuenta = new Cuenta(); // La palabra reservada new inicializa
        segundaCuenta.saldo = 500;
        System.out.println(segundaCuenta.saldo);
        System.out.println(segundaCuenta.agencia); // Compila, pero inicializa en 0 o 0.0

        System.out.println(primeraCuenta); // Ubicación de memoria: Cuenta@15db9742
        System.out.println(segundaCuenta); // Ubicación de memoria: Cuenta@6d06d69c

        if (primeraCuenta == segundaCuenta) {
            System.out.println("Son el mismo objeto");
        } else {
            System.out.println("Son diferentes objetos");
        }

        if (primeraCuenta.saldo == segundaCuenta.saldo) {
            System.out.println("Son el mismo objeto");
        } else {
            System.out.println("Son diferentes objetos");
        }

    }
}
