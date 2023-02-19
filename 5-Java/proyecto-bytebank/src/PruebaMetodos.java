public class PruebaMetodos {
    public static void main(String[] args) {
        Cuenta miCuenta = new Cuenta();
        miCuenta.saldo = 300;
        miCuenta.depositar(200);
        System.out.println(miCuenta.saldo);

        miCuenta.retirar(100);
        System.out.println(miCuenta.saldo);

        Cuenta cuentaDeJimena = new Cuenta();
        cuentaDeJimena.depositar(1000);
        //cuentaDeJimena.transferir(400, miCuenta);
        boolean puedeTransferir = cuentaDeJimena.transferir(400, miCuenta);

        //if (cuentaDeJimena.transferir(400, miCuenta)) {
        if (puedeTransferir) {
            System.out.println("Transferencia exitosa");
        } else {
            System.out.println("No es posible");
        }

        System.out.println(cuentaDeJimena.saldo);
        System.out.println(miCuenta.saldo);
    }
}
