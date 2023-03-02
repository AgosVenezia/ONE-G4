/*
Existe otro concepto en los lenguajes OO que se llama sobrecarga que es mucho más simple que la sobreescritura y no depende de la herencia.

Por ejemplo, en nuestra clase Gerente, imagina otro nuevo método autenticar que recibe además de la contraseña también el login:
*/

/*
public class Gerente2 extends Funcionario {

    private int contraseña;

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public boolean autenticar(int contraseña) {
        if (this.contraseña == contraseña) {
            return true;
        } else {
            return false;
        }
    }

    // Nuevo método, recibiendo dos parámetros
    //public boolean autenticar(String login, int contraseña) {
        // implementación omitida
    //}

    // Otros métodos omitidos
}
*/

/*
Observe que hemos creado una nueva versión del método autenticar. Ahora tenemos dos métodos de autenticar en la misma clase que varían en el número o tipo de parámetros. Esto se llama sobrecarga de métodos.

La sobrecarga no tiene en cuenta la visibilidad o retorno del método, solo los parámetros y no depende de la herencia.
*/