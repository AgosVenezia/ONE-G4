public class CrearCuenta {
    public static void main(String[] args) {
        // Variable          = Valor
        // Variable (hace referencia) -> 123FFD (lugar en la memoria)
        Cuenta primeraCuenta = new Cuenta(001);
        //primeraCuenta.saldo = 1000;
        primeraCuenta.depositar(200);
        //primeraCuenta.pais = "Perú"; // No compila!
        System.out.println(primeraCuenta.getSaldo());

        // primeraCuenta.saldo += 100;
        primeraCuenta.depositar(100);
        System.out.println(primeraCuenta.getSaldo());

        Cuenta segundaCuenta = new Cuenta(002); // La palabra reservada new inicializa
        //segundaCuenta.saldo = 500;
        segundaCuenta.depositar(500);
        
        //System.out.println(segundaCuenta.saldo);
        //System.out.println(segundaCuenta.agencia); // Compila, pero inicializa en 0 o 0.0

        System.out.println("Primera Cuenta tiene " + primeraCuenta.getSaldo());
        System.out.println("Segunda Cuenta tiene " + segundaCuenta.getSaldo());
        
        System.out.println(segundaCuenta.getSaldo());
        System.out.println(segundaCuenta.getAgencia());
        
        System.out.println(primeraCuenta); // Ubicación de memoria: Cuenta@15db9742
        System.out.println(segundaCuenta); // Ubicación de memoria: Cuenta@6d06d69c

        System.out.println(primeraCuenta.getAgencia());
        System.out.println(primeraCuenta.getNumero());

        System.out.println(segundaCuenta.getAgencia()); 

        // segundaCuenta.agencia = 146;
        segundaCuenta.setAgencia(146);
        System.out.println("Ahora la segunda cuenta esta en la agencia " + segundaCuenta.getAgencia());
        
        if (primeraCuenta == segundaCuenta) {
            System.out.println("Son el mismo objeto");
        } else {
            System.out.println("Son diferentes objetos");
        }

        if (primeraCuenta.getSaldo() == segundaCuenta.getSaldo()) {
            System.out.println("Son el mismo objeto");
        } else {
            System.out.println("Son diferentes objetos");
        }

        System.out.println(primeraCuenta);
        System.out.println(segundaCuenta);

    }
}
