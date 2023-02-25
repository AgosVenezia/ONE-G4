public class TestReferencias {
    public static void main(String[] args) {
        //Funcionario funcionario = new Funcionario();
        
        // El elemento más genérico puede ser adaptado al elemento más específico
        Funcionario funcionario = new Gerente();
        funcionario.setNombre("Diego");

        Gerente gerente = new Gerente();
        gerente.setNombre("Jimena");

        funcionario.setSalario(2000);
        gerente.setSalario(100000);

        // La referencia de funcionario no incluye los métodos de gerente 
        //funcionario.iniciarSesion("_ddddd"); // No compila
        gerente.iniciarSesion("_ddddd");
    }
}
