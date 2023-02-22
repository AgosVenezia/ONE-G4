public class PruebaMetodos {
    public static void main(String[] args) {
        Cuenta miCuenta = new Cuenta(005);
        //miCuenta.saldo = 300;
        miCuenta.depositar(200);
        //System.out.println(miCuenta.saldo);
        System.out.println(miCuenta.getSaldo());

        miCuenta.retirar(100);
        //System.out.println(miCuenta.saldo);
        System.out.println(miCuenta.getSaldo());

        Cuenta cuentaDeJimena = new Cuenta(006);
        cuentaDeJimena.depositar(1000);
        //cuentaDeJimena.transferir(400, miCuenta);
        boolean puedeTransferir = cuentaDeJimena.transferir(400, miCuenta);

        //if (cuentaDeJimena.transferir(400, miCuenta)) {
        if (puedeTransferir) {
            System.out.println("Transferencia exitosa");
        } else {
            System.out.println("No es posible");
        }

        //System.out.println(cuentaDeJimena.saldo);
        //System.out.println(miCuenta.saldo);
        System.out.println(cuentaDeJimena.getSaldo());
        System.out.println(miCuenta.getSaldo());
    }
}
