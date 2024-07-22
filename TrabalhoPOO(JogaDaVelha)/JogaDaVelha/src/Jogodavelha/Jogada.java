package Jogodavelha;

/**
 * Representa uma jogada em um jogo da velha.
 * Cada jogada inclui o jogador que está fazendo a jogada, e as coordenadas (linha e coluna) onde a jogada será feita.
 *
 * @author Mauricio
 * @version 1.0
 */
public class Jogada {
    private Jogador jogador;
    private int linha;
    private int coluna;

    /**
     * Construtor para criar uma nova jogada.
     *
     * @param jogador O jogador que está fazendo a jogada.
     * @param linha A linha do tabuleiro onde a jogada será feita.
     * @param coluna A coluna do tabuleiro onde a jogada será feita.
     */
    public Jogada(Jogador jogador, int linha, int coluna){
        this.jogador = jogador;
        this.linha = linha;
        this.coluna = coluna;
    }

    /**
     * Retorna o jogador que está fazendo a jogada.
     *
     * @return O jogador associado à jogada.
     */
    public Jogador getJogador() {
        return jogador;
    }

    /**
     * Retorna a linha onde a jogada será feita.
     *
     * @return A linha do tabuleiro onde a jogada será feita.
     */
    public int getLinha(){
        return linha;
    }

    /**
     * Retorna a coluna onde a jogada será feita.
     *
     * @return A coluna do tabuleiro onde a jogada será feita.
     */
    public int getColuna(){
        return coluna;
    }
}
