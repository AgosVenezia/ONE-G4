//                   extiende de
public class Gerente extends Funcionario {
// GERENTE hereda todo de FUNCIONARIO, pero F nada de G.
    
    private String clave;

    public void setClave (String clave) {
        this.clave = clave;
    }

    public boolean iniciarSesion (String clave) {
        return clave == "AluraCursosOnline";
    }

    // Sobre-escritura de método
    // Es la misma firma del método pera la estoy repitiendo en la clase hija, según su propia lógica
    public double getBonificacion() {
        //return this.salario;  // No compila
        //return super.getSalario();
        // Con la palabra reservada super tenemos acceso a los métodos de la clase padre
        //return super.getSalario() + (super.getSalario() * 0.1);
        return super.getSalario() + super.getBonificacion();
    }

}
