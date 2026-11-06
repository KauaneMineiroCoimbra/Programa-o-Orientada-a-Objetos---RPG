public class Boots extends Inimigo {

    public Boots() {
        super("Boots, o Monstro das Ferramentas Perdidas", 360, 35);
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("\nBOOTs: BIIIIIP! BZZZT! Quem ousa mexer no meu jardim?");
        System.out.println("BOOTs: Eu sou o guardiao dos comandos perdidos!");
    }

    @Override
    public void fraseMorte() {
        System.out.println("\nBOOTs: Bzz... talvez... eu só precisasse de uma manutenção...");
        System.out.println("BOOTs se desfaz em pequenas engrenagens luminosas.");
    }
}
