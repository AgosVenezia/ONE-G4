public class Contador extends Funcionario {
    
    @Override
    public double getBonificacion() {
        System.out.println("EJECUTANDO DESDE CONTADOR");
        //return super.getBonificacion();
        return 200;
    }
}
