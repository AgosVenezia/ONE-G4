public abstract class Cuenta {
    //private double saldo;
    // Protected es accesible desde las clases hijas
    protected double saldo;
    private int agencia = 1;
    private int numero;
    private Cliente titular = new Cliente(); 

    private static int total;

    // Puede tener constructores por defecto y personalizados también
    public Cuenta(int agencia, int numero) {
        if (agencia <= 0) {
            System.out.println("No se permite 0");
            this.agencia = 1;
        } else {
            this.agencia = agencia;
        }
        total++;
        System.out.println("Se van creando: " + total + " cuentas");

    }

    // Métodos abstractos sólo en clases abstractas
    public abstract void depositar(double valor); //{
        //this.saldo += valor;
    //}

    /*public boolean retirar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } //else if (cuentaBloqueada)
        return false;
    }*/

    // Validaciones o control de excepciones van al principio del método.
    public void retirar(double valor) throws SaldoInsuficienteException {
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException("No tienes saldo");
        }
        this.saldo -= valor;
    }

    //public boolean transferir(double valor, Cuenta cuenta) throws SaldoInsuficienteException {
    public boolean transferir(double valor, Cuenta cuenta) {

        if (this.saldo >= valor) {
            try {
                //this.saldo = this.saldo - valor;
                this.retirar(valor);
            } catch (SaldoInsuficienteException e) {
                e.printStackTrace();
            }
            cuenta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    public double getSaldo() { 
        return this.saldo;
    }

    public void setAgencia (int agencia) {
        if (agencia > 0) {
            this.agencia = agencia;
        } else {
            System.out.println("No están permitidos valores negativos");
        }
    }

    public int getAgencia() {
        return this.agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero > 0) {
            this.numero = numero;
        }
    }

    public void setTitular (Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return titular;
    }

    public static int getTotal() {
        return Cuenta.total;
    }
}
