package Jogodavelha;

import armazenamento.*;
import armazenamento.GerenciaJogadoresArquivo;
import entradadedados.Console;
import entradadedados.EasterEgg;

/**
 * Representa o jogo da velha.
 * Gerencia a inicialização dos jogadores, a execução do jogo, a alternância de turnos, e a gestão das vitórias.
 *
 * @author Mauricio
 * @version 1.0
 */
public class Jogo {
    /**
     * O tabuleiro do jogo.
     */
    private Tabuleiro tabuleiro;

    /**
     * O jogador 1 (marca 'X').
     */
    private Jogador jogador1;

    /**
     * O jogador 2 (marca 'O').
     */
    private Jogador jogador2;

    /**
     * O jogador que está realizando a jogada atual.
     */
    private Jogador jogadorAtual;

    /**
     * O gerenciador de jogadores para salvar e carregar os dados dos jogadores.
     */
    private GerenciaJogadoresArquivo gerenciaJogadores;

    /**
     * Construtor para inicializar o jogo.
     * Cria um novo tabuleiro e configura o gerenciador de jogadores com o arquivo "Histórico De Jogadores".
     */
    public Jogo() {
        tabuleiro = new Tabuleiro();
        gerenciaJogadores = new GerenciaJogadoresArquivo("Histórico De Jogadores");
    }

    /**
     * Inicializa os jogadores, solicitando seus nomes e validando a entrada.
     * Configura o jogador atual como o jogador 1.
     */
    private void inicializarJogadores() {
        Console console = new Console();
        boolean jogadoresValidos = false;

        while (!jogadoresValidos) {
            try {
                String nome1 = console.lerString("Nome do jogador 1 (X): ");
                if (nome1 == null || nome1.trim().isEmpty()) {
                    throw new ExceptionNomeInserido("Nome do jogador não pode ser vazio.");
                }
                if (nome1.equals("MATUE") || nome1.equals("Matue") || nome1.equals("matue")) {
                    EasterEgg easterEgg = new EasterEgg();
                    easterEgg.EntradaSuspeitaCCP();
                }

                jogador1 = new Jogador(nome1, 'X');
                gerenciaJogadores.adicionarJogador(jogador1.getNome(), jogador1.getVitorias());

                String nome2 = console.lerString("Nome do jogador 2 (O): ");
                if (nome2 == null || nome2.trim().isEmpty()) {
                    throw new ExceptionNomeInserido("Nome do jogador não pode ser vazio.");
                }
                if (nome2.equals("MATUE") || nome2.equals("Matue") || nome2.equals("matue")) {
                    EasterEgg easterEgg = new EasterEgg();
                    easterEgg.EntradaSuspeitaCCP();
                }

                jogador2 = new Jogador(nome2, 'O');
                gerenciaJogadores.adicionarJogador(jogador2.getNome(), jogador2.getVitorias());

                jogadoresValidos = true;
                jogadorAtual = jogador1;

            } catch (ExceptionNomeInserido e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Inicia o jogo, alternando turnos entre os jogadores até que haja um vencedor ou um empate.
     * Atualiza a pontuação dos jogadores e exibe o resultado final.
     */
    public void iniciar() {
        inicializarJogadores();
        boolean jogoEmAndamento = true;
        EasterEgg easterEgg = new EasterEgg();

        while (jogoEmAndamento) {
            tabuleiro.exibirTabuleiro();
            Jogada jogada = jogadorAtual.realizaJogada(tabuleiro);
            tabuleiro.marcar(jogada);

            if (tabuleiro.verificarVencedor(jogada)) {
                tabuleiro.exibirTabuleiro();
                System.out.println("Jogador " + jogadorAtual.getNome() + " venceu!");
                jogadorAtual.adicionaVitorias();
                gerenciaJogadores.adicionarJogador(jogador1.getNome(), jogador1.getVitorias());
                gerenciaJogadores.adicionarJogador(jogador2.getNome(), jogador2.getVitorias());
                exibirPontuacao();
                easterEgg.tocarSomDeVitoria();
                jogoEmAndamento = false;
                tabuleiro = new Tabuleiro();

            } else if (tabuleiro.verificarEmpate()) {
                tabuleiro.exibirTabuleiro();
                System.out.println("Empate");
                gerenciaJogadores.adicionarJogador(jogador1.getNome(), jogador1.getVitorias());
                gerenciaJogadores.adicionarJogador(jogador2.getNome(), jogador2.getVitorias());
                exibirPontuacao();
                easterEgg.tocarSomDeVitoria();
                jogoEmAndamento = false;
                tabuleiro = new Tabuleiro();
            } else {
                alternarJogador();
            }
        }
    }

    /**
     * Exibe a lista de jogadores e suas pontuações.
     */
    public void jogadores() {
        for (Jogador j : gerenciaJogadores.getJogadores()) {
            System.out.println("Jogador: " + j.getNome() + " Pontuação: " + j.getVitorias());
        }
    }

    /**
     * Exibe a pontuação atual dos jogadores.
     */
    private void exibirPontuacao() {
        System.out.println("Pontuação:");
        System.out.println(jogador1.getNome() + ": " + jogador1.getVitorias() + " vitórias");
        System.out.println(jogador2.getNome() + ": " + jogador2.getVitorias() + " vitórias");
    }

    /**
     * Alterna o jogador atual entre o jogador 1 e o jogador 2.
     */
    private void alternarJogador() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }
}
