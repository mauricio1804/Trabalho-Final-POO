package Jogodavelha;

import entradadedados.Console;

/**
 * A classe Reverso representa um jogo da velha reverso com uma matriz 4x4.
 * Este jogo permite a participação de dois jogadores.
 *
 * @author Eduardo
 */
public class Reverso {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    /**
     * Construtor da classe Reverso.
     * Inicializa o tabuleiro do jogo.
     */
    public Reverso() {
        tabuleiro = new Tabuleiro();
    }

    /**
     * Inicializa os jogadores do jogo, solicitando seus nomes via console.
     * Lança uma exceção se os nomes fornecidos forem inválidos.
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

                jogador1 = new Jogador(nome1, 'X');

                String nome2 = console.lerString("Nome do jogador 2 (O): ");
                if (nome2 == null || nome2.trim().isEmpty()) {
                    throw new ExceptionNomeInserido("Nome do jogador não pode ser vazio.");
                }

                jogador2 = new Jogador(nome2, 'O');

                jogadoresValidos = true;
                jogadorAtual = jogador1;
            } catch (ExceptionNomeInserido e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Inicia o jogo da velha reverso.
     * Solicita a inicialização dos jogadores e controla o fluxo do jogo.
     */
    public void iniciar() {
        inicializarJogadores();
        boolean jogoEmAndamento = true;

        while (jogoEmAndamento) {
            tabuleiro.exibirTabuleiro();
            Jogada jogada = jogadorAtual.realizaJogada(tabuleiro);
            tabuleiro.marcar(jogada);

            if (tabuleiro.verificarVencedor(jogada)) {
                tabuleiro.exibirTabuleiro();
                System.out.println("Jogador " + jogadorAtual.getNome() + " perdeu! Você alinhou três colunas!");
                jogoEmAndamento = false;
                tabuleiro = new Tabuleiro();
            } else if (tabuleiro.verificarEmpate()) {
                tabuleiro.exibirTabuleiro();
                System.out.println("Empate");
                jogoEmAndamento = false;
                tabuleiro = new Tabuleiro();
            } else {
                alternarJogador();
            }
        }
    }

    /**
     * Alterna o jogador atual.
     */
    private void alternarJogador() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }
}