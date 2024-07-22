package Jogodavelha;

import entradadedados.Console;

/**
 * Representa um jogador no jogo da velha.
 * Inclui informações sobre o nome do jogador, a marca (X ou O), e o número de vitórias.
 *
 * @author Mauricio
 * @version 1.0
 */
public class Jogador {
    /**
     * Nome do jogador.
     */
    private String nome;

    /**
     * Marca do jogador ('X' ou 'O').
     */
    private char marca;

    /**
     * Número de vitórias do jogador.
     */
    private int vitorias;

    /**
     * Construtor para criar um jogador com nome e marca especificados.
     *
     * @param nome  O nome do jogador.
     * @param marca A marca do jogador ('X' ou 'O').
     */
    public Jogador(String nome, char marca) {
        this.nome = nome;
        this.marca = marca;
        this.vitorias = 0; // Inicialmente, o número de vitórias é 0.
    }

    /**
     * Construtor para criar um jogador com nome especificado.
     * A marca é definida como um caractere nulo e as vitórias como 0.
     *
     * @param nome O nome do jogador.
     */
    public Jogador(String nome) {
        this.nome = nome;
        this.vitorias = 0; // Inicialmente, o número de vitórias é 0.
    }

    /**
     * Construtor para criar um jogador com nome e número de vitórias especificados.
     * A marca é definida como um caractere nulo.
     *
     * @param nome     O nome do jogador.
     * @param vitorias O número de vitórias do jogador.
     */
    public Jogador(String nome, int vitorias) {
        this.nome = nome;
        this.vitorias = vitorias;
    }

    /**
     * Obtém o nome do jogador.
     *
     * @return O nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a marca do jogador.
     *
     * @return A marca do jogador ('X' ou 'O').
     */
    public char getMarca() {
        return marca;
    }

    /**
     * Adiciona uma vitória ao número de vitórias do jogador.
     */
    public void adicionaVitorias() {
        this.vitorias++; // Incrementa o número de vitórias.
    }

    /**
     * Obtém o número de vitórias do jogador.
     *
     * @return O número de vitórias do jogador.
     */
    public int getVitorias() {
        return vitorias;
    }

    /**
     * Solicita ao jogador a realização de uma jogada.
     * O jogador deve fornecer a linha e a coluna para a jogada,
     * e a entrada é verificada para garantir que a posição é válida e não está ocupada.
     *
     * @param tabuleiro O tabuleiro onde a jogada será realizada.
     * @return Um objeto {@link Jogada} representando a jogada do jogador.
     */
    public Jogada realizaJogada(Tabuleiro tabuleiro) {
        Console console = new Console();
        int linha, coluna;
        while (true) {
            try {
                linha = console.lerInt("Jogador " + this.nome + " (" + this.marca + "), digite a linha (1-3): ");
                coluna = console.lerInt("Jogador " + this.nome + " (" + this.marca + "), digite a coluna (1-3): ");
                if (linha < 1 || coluna > 3 || coluna < 1 || linha > 3) {
                    throw new ExceptionVerificaPosicao("Posição incorreta, por favor insira uma entrada válida.");
                }
                if (!tabuleiro.verificaPosicao(linha, coluna)) {
                    throw new ExceptionVerificaPosicao("Posição já alocada, por favor insira outra.");
                }
                break; // Encerra o loop se a entrada for válida.
            } catch (ExceptionVerificaPosicao e) {
                System.out.println(e.getMessage());
            }
        }
        return new Jogada(this, linha, coluna);
    }
}
