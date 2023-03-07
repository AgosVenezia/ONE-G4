public class TestConexion {
    
    public static void main(String[] args) throws Exception {
        
        /*
        //Conexion con = new Conexion();
        Conexion con = null;
        try {
            con = new Conexion();
            con.leerDatos();
            //con.cerrar();
        } catch (IllegalStateException ex) {
            //System.out.println("Recibiendo exception");
            ex.printStackTrace();
            //con.cerrar();
        } finally {  // De una u otra forma. Opcional.
            System.out.println("Ejecutando finally");
            //con.cerrar();
            if (con != null) {
                con.cerrar();
            //} else {
                //con = new Conexion();
                //con.cerrar();
            }
        }
        */

        // Try with resources. Recursos porque cierra.
        try (Conexion con = new Conexion()) {
            con.leerDatos();
        } catch (IllegalStateException ex) {
            System.out.println("Ejecutando catch");
            ex.printStackTrace();
        }
    }
}

/*
El bloque finally es opcional cuando hay bloque catch.

El bloque finally siempre será ejecutado (sin o con excepción).

El bloque finally es normalmente utilizado para cerrar un recurso como conexión o transacción.
*/