//public class Cliente extends Autenticable {
public class Cliente implements Autenticable {
// Una interfaz no puede extender de una clase
    
    private String nombre;
    private String documento;
    private String telefono;
    
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

    public boolean iniciarSesion(String clave) {
        return false;
    }

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
