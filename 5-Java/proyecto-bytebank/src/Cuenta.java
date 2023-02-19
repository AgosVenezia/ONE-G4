// entidad Cuenta:
class Cuenta {
    double saldo;
    int agencia;
    // int agencia = 15; // inicializa con 15 en todas las instancias
    int numero;
    String titular;

    // No retorna valor (void)
    public void depositar(double valor) {
        // Esta cuenta  Esta cuenta  Parámetro
        // This account This account
        // This object
        // this.salo  = this.saldo  +  valor
        // saldo = saldo + valor; 
        // this.saldo = this.saldo + valor;
        this.saldo += valor;
    }

    // Retorna valor (boolean)
    public boolean retirar(double valor) {
        if (this.saldo >= valor) {
            //this.saldo = this.saldo - valor;
            this.saldo -= valor;
            return true;
        //} else {
            //return false;
        }
        return false;
    }

    public boolean transferir(double valor, Cuenta cuenta) {
        if (this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            //cuenta.saldo = cuenta.saldo + valor;
            cuenta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }
}
