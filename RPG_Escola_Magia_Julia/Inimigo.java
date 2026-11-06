public abstract class Inimigo extends Criatura {
    private int ataque;

    public Inimigo(String nome, int vida, int ataque) {
        super(nome, vida);
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }

    @Override
    public void fazAtaque(Criatura criatura) {
        criatura.tomaDano(ataque);
    }
}
