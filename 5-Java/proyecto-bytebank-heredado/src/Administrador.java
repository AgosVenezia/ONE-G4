// No se puede extender de dos clases (en JAVA)
public class Administrador extends Funcionario implements Autenticable {

    //private String clave;

    private AutenticacionUtil util;

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
