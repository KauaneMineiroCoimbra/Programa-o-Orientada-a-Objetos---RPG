import java.util.Scanner;

public class Jogo {
    private static Scanner sc = new Scanner(System.in);
    private static Jogador jogador;

    public static void main(String[] args) {
        inicio();

        aulaAgua();
        aulaFogo();
        aulaTerra();
        aulaVento();

        praticaLivre();

        servicoMoradores();
        encontroBoots();

        finalDoJogo();
    }

    private static void inicio() {
        titulo();

        System.out.println("Professor Walter: Bem vindo, pequeno(a) feiticeiro(a)!");
        System.out.println("Professor Walter: Esta é a Escola Arcana de Vale Lume.");
        System.out.println("Professor Walter: Aqui você vai aprender magia aos poucos.");
        System.out.println("Professor Walter: Primeiro precisamos saber quem você é.");
        System.out.print("\nDigite o nome do seu aprendiz: ");
        String nome = sc.nextLine();

        while (nome.trim().isEmpty()) {
            System.out.print("Digite um nome válido: ");
            nome = sc.nextLine();
        }

        jogador = new Jogador(nome);

        pausa();
        dialogoWalter();
        jogador.mostraStatus();
        pausa();
    }

    private static void titulo() {
        System.out.println("\n");
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║          ESCOLA ARCANA DE VALE LUME              ║");
        System.out.println("║       O APRENDIZ E O MONSTRO BOOTS               ║");
        System.out.println("║             RPG criado por Julia                 ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    private static void dialogoWalter() {
        System.out.println("\nProfessor Walter: Antes de começar, escolha como responder.");
        System.out.println("1) 'Estou pronto para aprender!'");
        System.out.println("2) 'Espero não explodir a escola...'");
        System.out.println("3) 'Professor, posso começar agora?'");
        int escolha = lerOpcao(1, 3);

        if (escolha == 1) {
            System.out.println("Walter sorri: Essa vontade vai levar você longe.");
        } else if (escolha == 2) {
            System.out.println("Walter ri: Explosões acontecem. Só não perto da biblioteca.");
        } else {
            System.out.println("Walter: Gostei da coragem. Vamos começar!");
        }
    }

    private static void aulaAgua() {
        cabecalho("AULA 1 — A LANÇA DE ÁGUA");
        System.out.println("Professor Walter: A primeira magia será a Lança de Água.");
        System.out.println("Professor Walter: Observe o comando e repita quando chegar sua vez.");
        System.out.println("\nProfessor Walter ergue o cajado...");
        System.out.println("Walter: Para a água, o comando é >>");
        System.out.print("\nDigite o comando >> : ");
        String comando = sc.nextLine();

        if (comando.equals(">>")) {
            System.out.println("SPLASH! Uma pequena lança de água surge!");
            conquista("LANÇA DE ÁGUA DESBLOQUEADA");
            jogador.aumentarConhecimento(1);
        } else {
            System.out.println("A água caiu no chão. Walter: Tudo bem! Tente novamente.");
            repetirComando(">>");
            conquista("LANÇA DE ÁGUA DESBLOQUEADA");
            jogador.aumentarConhecimento(1);
        }

        praticaElemento("agua");
    }

    private static void aulaFogo() {
        cabecalho("AULA 2 — A LANÇA DE FOGO");
        System.out.println("Professor Walter: Agora vamos trabalhar com uma energia mais quente.");
        System.out.println("Walter: O comando da chama é ^^");
        System.out.println("1) Tentar o feitiço");
        System.out.println("2) Pedir uma explicação");
        System.out.println("3) Perguntar se é perigoso");
        int escolha = lerOpcao(1, 3);

        if (escolha == 2) {
            System.out.println("Walter: Concentre-se no alvo e use ^^. Simples assim.");
        } else if (escolha == 3) {
            System.out.println("Walter: É perigoso somente se você esquecer o que aprendeu.");
        }

        System.out.print("Digite ^^ : ");
        String comando = sc.nextLine();
        if (!comando.equals("^^")) {
            System.out.println("Walter: Respire. Vamos repetir.");
            repetirComando("^^");
        }

        jogador.desbloquear("fogo");
        System.out.println(" FWOOSH! A Lança de Fogo foi desbloqueada!");
        conquista("LANÇA DE FOGO DESBLOQUEADA");
        jogador.aumentarConhecimento(1);
        praticaElemento("fogo");
    }

    private static void aulaTerra() {
        cabecalho("AULA 3 — A LANÇA DE TERRA");
        System.out.println("Professor Walter: Terra é força e equilíbrio.");
        System.out.println("Walter: O comando será <<");
        System.out.println("1) 'Vou tentar.'");
        System.out.println("2) 'Preciso de mais calma.'");
        System.out.println("3) 'Pode confiar em mim.'");
        int escolha = lerOpcao(1, 3);

        if (escolha == 1) {
            System.out.println("Walter: Então mostre sua concentração.");
        } else if (escolha == 2) {
            System.out.println("Walter: Muito bem. Um bom feiticeiro não tem pressa.");
        } else {
            System.out.println("Walter: Eu acredito em você.");
        }

        repetirComando("<<");
        jogador.desbloquear("terra");
        System.out.println("🪨 CRACK! A Lança de Terra nasceu.");
        conquista("LANÇA DE TERRA DESBLOQUEADA");
        jogador.aumentarConhecimento(1);
        praticaElemento("terra");
    }

    private static void aulaVento() {
        cabecalho("AULA 4 — A LANÇA DE VENTO");
        System.out.println("Professor Walter: Falta apenas dominar o elemento mais rápido.");
        System.out.println("Walter: O vento responde ao comando >>");
        System.out.println("1) 'Vou correr junto com o vento!'");
        System.out.println("2) 'Quero aprender com cuidado.'");
        System.out.println("3) 'O vento parece divertido!'");
        int escolha = lerOpcao(1, 3);

        if (escolha == 1) {
            System.out.println("Walter: Só não corra para fora da sala!");
        } else if (escolha == 2) {
            System.out.println("Walter: Excelente postura.");
        } else {
            System.out.println("Walter: Divertido e poderoso.");
        }

        repetirComando(">>");
        jogador.desbloquear("vento");
        System.out.println(" WHOOSH! A Lança de Vento foi desbloqueada.");
        conquista("TODAS AS LANÇAS DESBLOQUEADAS");
        jogador.aumentarConhecimento(1);
        praticaElemento("vento");
    }

    private static void repetirComando(String esperado) {
        String comando = sc.nextLine();
        while (!comando.equals(esperado)) {
            System.out.println("Professor Walter: Quase! O comando é " + esperado);
            System.out.print("Tente novamente: ");
            comando = sc.nextLine();
        }
        System.out.println(" Comando perfeito!");
    }

    private static void praticaElemento(String elemento) {
        System.out.println("\nProfessor Walter: Antes de sair, faça um pequeno treino.");
        System.out.println("Digite 1 para praticar " + elemento + " ou 2 para seguir.");
        int escolha = lerOpcao(1, 2);
        if (escolha == 1) {
            jogador.praticar(elemento);
            jogador.aumentarConhecimento(1);
            System.out.println("★ Você praticou e ficou um pouco mais forte!");
        }
    }

    private static void praticaLivre() {
        cabecalho("TREINO LIVRE — PÁTIO DOS ELEMENTOS");
        System.out.println("Professor Walter: Você já conhece quatro lanças.");
        System.out.println("Professor Walter: Praticar ajuda a aumentar seus poderes.");
        System.out.println("Você pode treinar até 3 vezes antes de sair.");

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nTreino " + i + "/3");
            System.out.println("1) Água");
            System.out.println("2) Fogo");
            System.out.println("3) Terra");
            System.out.println("4) Vento");
            System.out.println("5) Não treinar");
            int escolha = lerOpcao(1, 5);

            if (escolha == 5) {
                System.out.println("Você guarda energia para a missão.");
                break;
            }

            if (escolha == 1) jogador.praticar("agua");
            if (escolha == 2) jogador.praticar("fogo");
            if (escolha == 3) jogador.praticar("terra");
            if (escolha == 4) jogador.praticar("vento");

            jogador.aumentarConhecimento(1);
        }

        jogador.mostraStatus();
        pausa();
    }

    private static void servicoMoradores() {
        cabecalho("MISSÃO — O DIA DE CUIDAR DOS JARDINS");
        System.out.println("Professor Walter: Agora você vai conhecer os moradores.");
        System.out.println("Walter: Cada jardim tem uma praga diferente.");
        System.out.println("Walter: Use seu Livro para estudar antes de começar.");

        LivroMagia.apresentar();
        pausa();

        for (int i = 1; i <= 5; i++) {
            System.out.println("\n========== MORADOR " + i + " DE 5 ==========");
            System.out.println("Um morador precisa de ajuda no jardim.");

            System.out.println("1) 'Pode deixar, eu vou ajudar!'");
            System.out.println("2) 'Qual é o problema do jardim?'");
            System.out.println("3) 'Vou consultar meu livro primeiro.'");
            int fala = lerOpcao(1, 3);

            if (fala == 2) {
                System.out.println("Morador: As pragas tomaram conta das flores!");
            } else if (fala == 3) {
                System.out.println("Você consulta o livro e identifica a praga.");
                System.out.println("A melhor escolha é usar uma magia com cuidado.");
            } else {
                System.out.println("Morador: Muito obrigado, jovem feiticeiro!");
            }

            resolverJardim(i);
            jogador.ajudouMorador();
            System.out.println(" Jardim limpo! Morador agradece.");
        }

        System.out.println("\nProfessor Walter: Você ajudou todos os cinco moradores!");
        conquista("GUARDIÃO DOS CINCO JARDINS");
        jogador.mostraStatus();
        pausa();
    }

    private static void resolverJardim(int numero) {
        if (numero == 1) {
            System.out.println("Praga: Matinho Mordiscante.");
            System.out.println("Dica: a magia de Terra funciona muito bem.");
            System.out.println("1) Usar Terra");
            System.out.println("2) Usar Água");
            System.out.println("3) Usar Vento");
            int escolha = lerOpcao(1, 3);
            if (escolha == 1) {
                System.out.println("🪨 A terra cobre as raízes e o matinho para de crescer.");
            } else {
                System.out.println(" A magia funciona! Só levou um pouco mais de esforço.");
            }
        } else if (numero == 2) {
            System.out.println("Praga: Erva-Cócega.");
            System.out.println("Dica: vento pode afastar suas folhas.");
            escolhaMagiaSimples("Vento");
        } else if (numero == 3) {
            System.out.println("Praga: Trepadeira Sussurrante.");
            System.out.println("Dica: água acalma a planta.");
            escolhaMagiaSimples("Água");
        } else if (numero == 4) {
            System.out.println("Praga: Erva-Cócega gigante.");
            System.out.println("Dica: você já tem experiência suficiente para tentar qualquer elemento.");
            escolhaMagiaSimples("Fogo");
        } else {
            System.out.println("Praga final: uma mistura de todas as pragas!");
            System.out.println("Professor Walter: Agora confio na sua escolha.");
            escolhaMagiaSimples("qualquer magia");
        }
    }

    private static void escolhaMagiaSimples(String dica) {
        System.out.println("Escolha:");
        System.out.println("1) Seguir a dica (" + dica + ")");
        System.out.println("2) Tentar outra magia");
        int escolha = lerOpcao(1, 2);
        if (escolha == 1) {
            System.out.println(" A magia certa resolve o problema rapidamente!");
        } else {
            System.out.println(" A magia funciona graças ao seu treinamento!");
        }
    }

    private static void encontroBoots() {
        cabecalho("FINAL DO DIA — O MONSTRO BOOTS");
        System.out.println("O sol começa a se esconder atrás da escola.");
        System.out.println("Você escuta um barulho no jardim...");
        System.out.println("CLANK... CLANK... BZZZT...");
        System.out.println("Professor Walter: Afaste-se!");
        System.out.println("Um monstro feito de ferramentas, engrenagens e peças de jardim aparece.");
        System.out.println("Seu nome é BOOTS.");

        Boots boots = new Boots();
        boots.fraseApresentacao();

        System.out.println("\nWalter: A batalha é simples.");
        System.out.println("Walter: Você pode tentar quantas vezes precisar.");
        System.out.println("Walter: Se perder, retorna para o início da batalha com suas magias.");
        pausa();

        int tentativa = 1;

        while (boots.estaVivo()) {
            System.out.println("\n========== BATALHA — TENTATIVA " + tentativa + " ==========");
            jogador.restauraVida();
            boots = new Boots();

            while (jogador.estaVivo() && boots.estaVivo()) {
                jogador.mostraVida();
                boots.mostraVida();

                System.out.println("\nEscolha sua estratégia:");
                System.out.println("1) Lança de Água — ataque seguro");
                System.out.println("2) Lança de Fogo — ataque forte");
                System.out.println("3) Lança de Terra — ataque equilibrado");
                System.out.println("4) Lança de Vento — ataque mais poderoso");
                System.out.println("5) Ver status");
                int escolha = lerOpcao(1, 5);

                if (escolha == 5) {
                    jogador.mostraStatus();
                    continue;
                }

                String elemento = "agua";
                if (escolha == 2) elemento = "fogo";
                if (escolha == 3) elemento = "terra";
                if (escolha == 4) elemento = "vento";

                jogador.lancarMagia(elemento, boots, sc);

                if (boots.estaVivo()) {
                    System.out.println("\nBoots prepara seu ataque...");
                    boots.fazAtaque(jogador);
                }
            }

            if (!jogador.estaVivo()) {
                System.out.println("\n Você foi derrotado, mas isso não é o fim!");
                System.out.println("Walter: Um aprendiz pode tentar novamente.");
                System.out.println("Você retorna ao início da batalha.");
                jogador.restauraVida();
                tentativa++;
            } else {
                boots.fraseMorte();
                conquista("MESTRE DAS QUATRO LANÇAS");
                break;
            }
        }
    }

    private static void finalDoJogo() {
        cabecalho("FINAL — A FESTA DE VALE-LUME");

        System.out.println("Os cinco moradores chegam correndo.");
        System.out.println("Morador 1: Obrigado por salvar nossos jardins!");
        System.out.println("Morador 2: Você realmente aprendeu magia!");
        System.out.println("Morador 3: O jardim está lindo novamente!");
        System.out.println("Morador 4: Viva o aprendiz!");
        System.out.println("Morador 5: Temos um novo guardião!");

        System.out.println("\nProfessor Walter: Hoje você chegou como pequeno aprendiz...");
        System.out.println("Professor Walter: ...e terminou o dia como um verdadeiro guardião.");
        System.out.println("Professor Walter: Mas lembre-se: a escola ainda guarda muitos segredos.");

        conquista("FIM DO PRIMEIRO DIA");
        jogador.mostraStatus();

        System.out.println("\n✨✨✨ PARABÉNS! ✨✨✨");
        System.out.println("Você completou o primeiro dia na Escola Arcana de Vale-Lume.");
        System.out.println("Ainda há muito para aprender...");
        System.out.println("\nObrigado por jogar!");
        System.out.println("RPG criado por JULIA 💜");
        System.out.println("Em breve: novas aulas, novas magias e novos monstros!");
    }

    private static void conquista(String texto) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║          ★ CONQUISTA ★            ║");
        System.out.println("║ " + texto);
        System.out.println("╚════════════════════════════════════╝\n");
    }

    private static void cabecalho(String texto) {
        System.out.println("\n\n==================================================");
        System.out.println(texto);
        System.out.println("==================================================");
    }

    private static int lerOpcao(int minimo, int maximo) {
        while (true) {
            System.out.print("Escolha: ");
            String entrada = sc.nextLine();

            try {
                int opcao = Integer.parseInt(entrada);
                if (opcao >= minimo && opcao <= maximo) {
                    return opcao;
                }
            } catch (NumberFormatException e) {
                // continua pedindo
            }

            System.out.println("Opção inválida. Escolha entre " + minimo + " e " + maximo + ".");
        }
    }

    private static void pausa() {
        System.out.println("\nPressione ENTER para continuar...");
        sc.nextLine();
    }
}
