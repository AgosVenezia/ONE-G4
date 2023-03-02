// No se puede extender de dos clases (en JAVA)
public class Administrador extends Funcionario implements Autenticable {

    /*private String clave;

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean iniciarSesion(String clave) {
        return clave == "AluraCursosOnline";
    }*/

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
