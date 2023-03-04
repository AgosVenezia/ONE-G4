//public class Cliente extends Autenticable {
public class Cliente implements Autenticable {
// Una interfaz no puede extender de una clase
// No puedo extender de una interfaz pero puedo implementarla
    
    private String nombre;
    private String documento;
    private String telefono;

    private AutenticacionUtil util;

    //private String clave;

    public Cliente() {
        this.util = new AutenticacionUtil();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento (String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono (String telefono) {
        this.telefono = telefono;
    }

    /*@Override
    public boolean iniciarSesion(String clave) {
        if (this.clave == clave) {
            return true;
        }
        return false;
    }*/

    @Override
    public boolean iniciarSesion(String clave) {
        //return this.clave == clave;
        return this.util.iniciarSesion(clave);
    }

    @Override
    public void setClave(String clave) {
        //this.clave = clave;
        this.setClave(clave);
    }
}
