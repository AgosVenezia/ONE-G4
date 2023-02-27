public class ControlBonificacion {
    
    private double suma;

    public double registrarSalario(Funcionario funcionario) {
        this.suma = funcionario.getBonificacion() + this.suma;
        System.out.println("Cálculo actual: " + this.suma);
        return this.suma;
    }

    // Sobrecarga de métodos: 
    // Tienes un mismo método con el mismo nombre pero diferentes argumentos
    
    /*
    public double registrarSalario(Gerente gerente) {
        this.suma = gerente.getBonificacion() + this.suma;
        System.out.println("Cálculo actual: " + this.suma);
        return this.suma;
    }
    */

    /*
    public double registrarSalario(Contador contador) {
        this.suma = contador.getBonificacion() + this.suma;
        System.out.println("Cálculo actual: " + this.suma);
        return this.suma;
    }
    */
}
