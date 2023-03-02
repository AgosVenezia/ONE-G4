public class TestControlBonificacion {
    public static void main(String[] args) {
        //Funcionario diego = new Funcionario();
        Funcionario diego = new Contador();
        diego.setSalario(2000);

        Gerente jimena = new Gerente();
        jimena.setSalario(10000);

        Contador alexiz = new Contador();
        alexiz.setSalario(5000);

        ControlBonificacion controlBonificacion = new ControlBonificacion();

        // Llama al método más específico, si no lo tiene, va hasta el padre.
        
        controlBonificacion.registrarSalario(diego);
        controlBonificacion.registrarSalario(jimena);
        controlBonificacion.registrarSalario(alexiz);

    }
}
