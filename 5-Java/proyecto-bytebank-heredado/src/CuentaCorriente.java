public class CuentaCorriente extends Cuenta {
    
    public CuentaCorriente(int agencia, int numero) {
        super(agencia, numero);
    }

    // Sobrescribe el método de la clase padre
    @Override // Nunca borrar (deja de sobreescribir)
    // La firma tiene que ser igual que el padre
    //public boolean retirar(double valor) {
    public void retirar(double valor) throws SaldoInsuficienteException {
        double comision = 0.2;
        //return super.retirar(valor + comision);
        super.retirar(valor + comision);

    }

    @Override
    public void depositar(double valor) {
        this.saldo = this.saldo + valor;
    }
}
