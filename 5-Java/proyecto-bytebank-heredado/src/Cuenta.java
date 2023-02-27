class Cuenta {
    private double saldo;
    private int agencia = 1;
    private int numero;
    private Cliente titular = new Cliente(); 

    private static int total;


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

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean retirar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, Cuenta cuenta) {
        if (this.saldo >= valor) {
            this.saldo = this.saldo - valor;
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
