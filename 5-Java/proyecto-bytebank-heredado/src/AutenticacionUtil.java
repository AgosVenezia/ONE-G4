public class AutenticacionUtil {
    
    private String clave;

    public boolean iniciarSesion(String clave) {
        return this.clave == clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}

/* UTILITARIOS: 
Métodos que no le pertenecen a ninguna clase pero ayudan a no repetir código.
Con composiciones e interfaces tendremos más flexibilidad con nuestro código, ya que no estaremos apegados al acoplamiento que propone la herencia.
*/