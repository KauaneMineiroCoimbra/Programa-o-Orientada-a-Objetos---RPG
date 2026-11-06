public abstract class Criatura {
    private String nome;
    private int vida;
    private int vidaMaxima;

    public Criatura(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public abstract void fazAtaque(Criatura criatura);
    public abstract void fraseApresentacao();
    public abstract void fraseMorte();

    public void tomaDano(int dano) {
        vida -= dano;
        if (vida < 0) {
            vida = 0;
        }
        System.out.println(nome + " recebeu " + dano + " de dano.");
    }

    public void cura(int quantidade) {
        vida += quantidade;
        if (vida > vidaMaxima) {
            vida = vidaMaxima;
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void mostraVida() {
        System.out.println(nome + " - Vida: " + vida + "/" + vidaMaxima);
    }

    public void restauraVida() {
        vida = vidaMaxima;
    }
}
