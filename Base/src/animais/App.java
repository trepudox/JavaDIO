package animais;

public class App {
    public static void main(String[] args) {

//        Cavalo cavalo = new Cavalo("cavalo", 10);
//        Cachorro cachorro = new Cachorro("cachorro", 11);
//
//        cachorro.correr();
//        System.out.println("cachcorro correu \n");
//        cavalo.correr();



        Pardal pardal = new Pardal("passaro", 2);

        System.out.println(pardal.getNome());
        pardal.voar();
        System.out.println(pardal.getNome());
    }
}
