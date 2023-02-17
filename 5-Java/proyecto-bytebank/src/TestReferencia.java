public class TestReferencia {
    public static void main(String[] args) {
        Cuenta primeraCuenta = new Cuenta();
        primeraCuenta.saldo = 200;

        Cuenta segundaCuenta = primeraCuenta;
        segundaCuenta.saldo = 100; //Interfiere porque ambas apuntan a la misma dirección de memoria

        System.out.println("Saldo primera cuenta: " + primeraCuenta.saldo);
        System.out.println("Saldo segunda cuenta: " + segundaCuenta.saldo);

        segundaCuenta.saldo += 400;
        System.out.println("Saldo primera cuenta: " + primeraCuenta.saldo);

        System.out.println(primeraCuenta); // Ubicación de memoria: Cuenta@15db9742
        System.out.println(segundaCuenta); // Ubicación de memoria: Cuenta@15db9742

        if (primeraCuenta == segundaCuenta) {
            System.out.println("Son el mismo objeto");
        }

    }
}
