public class Conexion implements AutoCloseable {
// Inicializa un objeto, pero tiene que implementar la interfaz de AutoCloseable.
    
    public Conexion() {
        System.out.println("Abriendo conexión");
        //throw new IllegalStateException();
    }

    public void leerDatos() {
        System.out.println("Recibiendo datos");
        throw new IllegalStateException();
    }

    public void cerrar() {
        System.out.println("Cerrando conexión");
    }

    @Override
    public void close() throws Exception {
        cerrar();
    }

}

// Aplicaciones distribuidas: conjunto de aplicaciones que interactúan entre si para satisfacer las necesidades del negocio.