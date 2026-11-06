public class Demonion extends Inimigo {

    public Demonion() {
        super("Demonion", 500, 200);
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Eu sou o pior inimigo de todos! Muhahahaha!");
    }

    @Override
    public void fraseMorte() {
        System.out.println("Eu vou me vingar...");
    }
}
