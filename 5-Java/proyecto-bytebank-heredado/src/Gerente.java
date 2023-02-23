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

}
