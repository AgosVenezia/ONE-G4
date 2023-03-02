//public abstract class Autenticable extends Funcionario {
//public abstract interface Autenticable extends Funcionario {
public interface Autenticable {
// Las intefaces no pueden tener métodos implementados

    //private String clave;

    /*
    //public default void setClave(String clave) {
    public void setClave(String clave) {
        this.clave = clave;
    }
    */

    // En una interfaz, todos los métodos son abstractos, no puede tener métodos públicos
    //public abstract void setClave(String clave);
    public void setClave(String clave);
    // Por buenas prácticas, se omite la palabra reservada abstract

    /*public boolean iniciarSesion(String clave) {
        return clave == "AluraCursosOnline";
    }*/

    //public abstract boolean iniciarSesion(String clave);
    public boolean iniciarSesion(String clave);

    /*@Override
    public double getBonificacion() {
        return 0;
    }*/

}
