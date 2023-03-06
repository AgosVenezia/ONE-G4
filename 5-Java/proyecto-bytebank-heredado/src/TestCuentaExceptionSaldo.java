public class TestCuentaExceptionSaldo {
    
    // Mala práctica que lance la excepción el método main.
    //public static void main(String[] args) throws SaldoInsuficienteException {
    public static void main(String[] args) {
        Cuenta cuenta = new CuentaAhorros(123, 456);
        cuenta.depositar(200);
        /*cuenta.retirar(200); // Se van creando: 1 cuentas
        cuenta.retirar(10); // Exception in thread "main" SaldoInsuficienteException: No tienes saldo*/
        try {
            cuenta.retirar(200);
            cuenta.retirar(10);
        } catch (SaldoInsuficienteException e) {
            e.printStackTrace();
        }
        
    }
}
