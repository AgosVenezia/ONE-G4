// No se puede extender de dos clases (en JAVA)

// POLIMORFISMO:
// Es la capacidad de un objeto de ser referenciado por varios tipos.
// Tenemos polimorfismo cuando una clase se extiende de otra o también cuando una clase implementa una interfaz.
public class Administrador extends Funcionario implements Autenticable {

    //private String clave;

    private AutenticacionUtil util;

    
    // Composición de objetos (new util):
    // Un objeto dentro de otro que es iniciliazado automáticamente.
    public Administrador() {
        this.util = new AutenticacionUtil();
    }

    /*public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean iniciarSesion(String clave) {
        return clave == "AluraCursosOnline";
    }*/

    @Override
    public double getBonificacion() {
        return this.getSalario();
    }

    @Override
    public void setClave(String clave) {
        //this.clave = clave;
        this.util.setClave(clave);
    }

    @Override
    public boolean iniciarSesion(String clave) {
        //return this.clave == clave;
        return this.util.iniciarSesion(clave);
    }
}
