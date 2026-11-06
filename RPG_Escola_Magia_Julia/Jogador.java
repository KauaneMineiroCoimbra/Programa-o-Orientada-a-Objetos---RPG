import java.util.Scanner;

public class Jogador extends Criatura {
    private int nivelConhecimento = 1;
    private int poderAgua = 10;
    private int poderFogo = 0;
    private int poderTerra = 0;
    private int poderVento = 0;
    private int moradoresAjudados = 0;

    public Jogador(String nome) {
        super(nome, 120);
    }

    public int getNivelConhecimento() {
        return nivelConhecimento;
    }

    public int getMoradoresAjudados() {
        return moradoresAjudados;
    }

    public void ajudouMorador() {
        moradoresAjudados++;
        aumentarConhecimento(1);
    }

    public void aumentarConhecimento(int quantidade) {
        nivelConhecimento += quantidade;
        System.out.println("★ Seu conhecimento mágico aumentou para nível " + nivelConhecimento + "!");
    }

    public void desbloquear(String elemento) {
        if (elemento.equals("fogo")) {
            poderFogo = 18;
        } else if (elemento.equals("terra")) {
            poderTerra = 24;
        } else if (elemento.equals("vento")) {
            poderVento = 30;
        }
    }

    public void praticar(String elemento) {
        if (elemento.equals("agua")) {
            poderAgua += 4;
            System.out.println("A água dança ao redor de suas mãos!");
            System.out.println("Poder da Água: " + poderAgua);
        } else if (elemento.equals("fogo") && poderFogo > 0) {
            poderFogo += 4;
            System.out.println("A chama fica mais firme!");
            System.out.println("Poder do Fogo: " + poderFogo);
        } else if (elemento.equals("terra") && poderTerra > 0) {
            poderTerra += 4;
            System.out.println("O chão responde ao seu chamado!");
            System.out.println("Poder da Terra: " + poderTerra);
        } else if (elemento.equals("vento") && poderVento > 0) {
            poderVento += 4;
            System.out.println("O vento gira em volta do cajado!");
            System.out.println("Poder do Vento: " + poderVento);
        }
    }

    public void mostraStatus() {
        System.out.println("\n========== LIVRO DO APRENDIZ ==========");
        mostraVida();
        System.out.println("Aprendiz: " + getNome());
        System.out.println("Nível de conhecimento: " + nivelConhecimento);
        System.out.println("Água: " + poderAgua);
        System.out.println("Fogo: " + (poderFogo == 0 ? "bloqueado" : poderFogo));
        System.out.println("Terra: " + (poderTerra == 0 ? "bloqueado" : poderTerra));
        System.out.println("Vento: " + (poderVento == 0 ? "bloqueado" : poderVento));
        System.out.println("Moradores ajudados: " + moradoresAjudados + "/5");
        System.out.println("========================================");
    }

    private int poder(String elemento) {
        if (elemento.equals("agua")) return poderAgua;
        if (elemento.equals("fogo")) return poderFogo;
        if (elemento.equals("terra")) return poderTerra;
        return poderVento;
    }

    public void lancarMagia(String elemento, Inimigo inimigo, Scanner sc) {
        int dano = poder(elemento);
        if (dano <= 0) {
            System.out.println("Essa magia ainda está bloqueada.");
            return;
        }

        System.out.println("\nEscolha o comando mágico para " + elemento.toUpperCase() + ":");
        System.out.println("1) >>");
        System.out.println("2) <<");
        System.out.println("3) ^^");
        System.out.print("Comando: ");
        String comando = sc.nextLine().trim();

        boolean acertou = false;

        if (elemento.equals("agua") && comando.equals(">>")) acertou = true;
        if (elemento.equals("fogo") && comando.equals("^^")) acertou = true;
        if (elemento.equals("terra") && comando.equals("<<")) acertou = true;
        if (elemento.equals("vento") && comando.equals(">>")) acertou = true;

        if (acertou) {
            System.out.println("✨ FEITIÇO CONJURADO! ✨");
            inimigo.tomaDano(dano);
        } else {
            System.out.println("O comando saiu torto! O feitiço perdeu força.");
            inimigo.tomaDano(Math.max(5, dano / 3));
        }
    }

    @Override
    public void fazAtaque(Criatura criatura) {
        criatura.tomaDano(poderAgua);
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Eu ainda sou um pequeno aprendiz, mas vou aprender!");
    }

    @Override
    public void fraseMorte() {
        System.out.println("Meu livro de magia caiu no chão...");
    }
}
