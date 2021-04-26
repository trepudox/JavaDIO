package exceptions;

public class App {

    public static Object metodo() throws ContaException {
        try {
            int conta = 1 / 0;
            return conta;
        } catch (Exception e) {
            throw new ContaException("Ocorreu um erro ao fazer a conta", e);
        }

        //return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println();
        try{
            metodo();
        } catch (ContaException e) {
            System.out.println("Um erro ocorreu ao executar o metodo");
            System.out.println("Erro: " + e);
            System.out.println("Raiz: " + e.getCause());
        } finally {
            System.out.println("\nFim");
        }
    }
}
