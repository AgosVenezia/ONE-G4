public class PruebaEncapsulamiento {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(004);
        Cliente cliente = new Cliente();
        cliente.setNombre("Diego");
        cliente.setDocumento("fdfd343434");

        cuenta.setTitular(cliente);

        //System.out.println(cliente.getNombre());
        System.out.println(cliente);
        //System.out.println(cliente.getTitular().getNombre());
        //System.out.println(cliente.getTitular());
        //System.out.println(titular);
    }
}
