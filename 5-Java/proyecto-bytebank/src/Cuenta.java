// Modificadores de acceso
// Public - visible desde cualquier parte del código
// Private - nadie puede modificarlo, sólo se modifica desde ciertos métodos (GETTER/SETTER)

// entidad Cuenta:
class Cuenta {
    //double saldo;
    private double saldo;
    //private int agencia;
    private int agencia = 1;
    //int agencia = 15; // inicializa con 15 en todas las instancias
    private int numero;
    //String titular;
    //Cliente titular;
    private Cliente titular = new Cliente(); // Cuando inicializa una cuenta, también inicializa al cliente
    
    private static int total = 0; // Static: la variable no es de la instancia, es de la clase. La variable no va a ser alterada por la instancia, sino por la clase (cuenta).
    
    //public Cuenta() {  // Cuando modificás el constructor, lo tenés que crear manualmente.

    //}
    
    // Constructor: método que se genera automáticamente y retorna el objeto cuenta.
    // Podemos manejar el método desde su construcción y se utiliza para inicializar los atributos.
    
    public Cuenta(int agencia) {
        if (agencia <= 0) {
            System.out.println("No se permite 0");
            this.agencia = 1;
        } else {
            this.agencia = agencia;
        }
        total++;
        //System.out.println("Aquí se crea una nueva cuenta");
        System.out.println("Se van creando: " + total + " cuentas");

    }

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

    //public double obtenerSaldo() {
    public double getSaldo() { // Convención. GET, obtener. SET, asignar.
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
