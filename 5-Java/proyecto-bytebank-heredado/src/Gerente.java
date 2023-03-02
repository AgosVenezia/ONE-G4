//                   extiende de
//public class Gerente extends Funcionario {
public class Gerente extends Funcionario implements Autenticable {

// GERENTE hereda todo de FUNCIONARIO, pero F nada de G.
    
    /*private String clave;

    public void setClave (String clave) {
        this.clave = clave;
    }

    public boolean iniciarSesion (String clave) {
        return clave == "AluraCursosOnline";
    }*/

    // Sobre-escritura de método
    // Es la misma firma del método pera la estoy repitiendo en la clase hija, según su propia lógica
    public double getBonificacion() {
        System.out.println("EJECUTANDO DESDE GERENTE");
        //return this.salario;  // No compila
        //return super.getSalario();
        // Con la palabra reservada super tenemos acceso a los métodos de la clase padre
        //return super.getSalario() + (super.getSalario() * 0.1);
        //return super.getSalario() + super.getBonificacion(); // No abstracta
        return super.getSalario() + this.getSalario() * 0.05;
    }

    // Si la clase es abstracta no estoy obligado a instanciar los métodos abstractos

    @Override
    public double getBonificacion() {
        return 0;
    }

    @Override
    public boolean iniciarSesion(String clave) {
        return false;
    }

    @Override
    public void setClave(String clave) {
        
    }

}
