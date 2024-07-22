package Jogodavelha;

/**
 * Representa o tabuleiro do jogo da velha.
 * Gerencia a exibição do tabuleiro, marcação de jogadas, e verificação de vencedores e empates.
 *
 * @author Eduardo
 * @version 1.0
 */
public class Tabuleiro {
    /**
     * Matriz que representa o tabuleiro do jogo.
     */
    private char[][] tabuleiro;

    /**
     * Código de cor para texto azul.
     */
    private static final String RESET = "\u001B[0m";
    private static final String AZUL = "\u001B[34m";
    private static final String VERDE = "\u001B[32m";

    /**
     * Construtor que inicializa o tabuleiro com espaços em branco.
     */
    public Tabuleiro() {
        tabuleiro = new char[4][4];
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    /**
     * Marca uma jogada no tabuleiro.
     *
     * @param jogada A jogada a ser marcada no tabuleiro.
     */
    public void marcar(Jogada jogada) {
        tabuleiro[jogada.getLinha()][jogada.getColuna()] = jogada.getJogador().getMarca();
    }

    /**
     * Retorna a cor da marca com base no jogador.
     *
     * @param jogador A marca do jogador ('X' ou 'O').
     * @return O código de cor correspondente à marca do jogador.
     */
    private String CorDaMarca(char jogador) {
        switch (jogador) {
            case 'X':
                return AZUL;
            case 'O':
                return VERDE;
            default:
                return RESET;
        }
    }

    /**
     * Exibe o tabuleiro atual, com as marcas dos jogadores.
     */
    public void exibirTabuleiro() {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                char jogador = tabuleiro[i][j];
                String cor = CorDaMarca(jogador);
                System.out.print(cor + jogador + RESET);
                if (j < 3) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 3) {
                System.out.println("--+---+--");
            }
        }
    }

    /**
     * Verifica se a posição no tabuleiro está disponível para uma jogada.
     *
     * @param linha A linha a ser verificada.
     * @param coluna A coluna a ser verificada.
     * @return {@code true} se a posição está disponível, {@code false} caso contrário.
     */
    public boolean verificaPosicao(int linha, int coluna) {
        return tabuleiro[linha][coluna] == ' ';
    }

    /**
     * Verifica se há um vencedor após uma jogada.
     *
     * @param jogada A jogada realizada que pode ter causado a vitória.
     * @return {@code true} se houver um vencedor, {@code false} caso contrário.
     */
    public boolean verificarVencedor(Jogada jogada) {
        char marca = jogada.getJogador().getMarca();
        int linha = jogada.getLinha();
        int coluna = jogada.getColuna();

        // Verificar linha
        if (tabuleiro[linha][1] == marca && tabuleiro[linha][2] == marca && tabuleiro[linha][3] == marca) {
            return true;
        }

        // Verificar coluna
        if (tabuleiro[1][coluna] == marca && tabuleiro[2][coluna] == marca && tabuleiro[3][coluna] == marca) {
            return true;
        }

        // Verificar diagonais
        if (linha == coluna && tabuleiro[1][1] == marca && tabuleiro[2][2] == marca && tabuleiro[3][3] == marca) {
            return true;
        }
        if (tabuleiro[1][3] == marca && tabuleiro[2][2] == marca && tabuleiro[3][1] == marca) {
            return true;
        }

        return false;
    }

    /**
     * Verifica se o jogo terminou em empate.
     *
     * @return {@code true} se o tabuleiro estiver cheio e não houver vencedor, {@code false} caso contrário.
     */
    public boolean verificarEmpate() {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
