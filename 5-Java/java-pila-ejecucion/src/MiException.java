// Si extiendo de exceptión, le tengo que indicar que lance mi excepción
//public class MiException extends RuntimeException {  // UNCHECKED
public class MiException extends Exception {  // CHECKED
    
    public MiException() {
        super();
    }

    public MiException(String message) {
        super(message);
    }
}

// MiException es CHECKED, verificada, el compilador no me deja seguir adelante si yo no trato la excepción.