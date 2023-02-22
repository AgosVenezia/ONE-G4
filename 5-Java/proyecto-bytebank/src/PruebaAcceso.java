public class PruebaAcceso {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta();
        //cuenta.saldo = 200;
        //cuenta.obtenerSaldo() = 200; // Un método no se puede igualar
        cuenta.setAgencia(22);
        cuenta.depositar(400);
        cuenta.retirar(300);
        //cuenta.saldo = cuenta.saldo -300; // Aun es public 

        //System.out.println(cuenta.saldo); // 200, no deja retirar porque el valor es mayor que el saldo
        System.out.println(cuenta.getSaldo()); // Inicializa en cero
        System.out.println(cuenta.getAgencia());
    }
}
