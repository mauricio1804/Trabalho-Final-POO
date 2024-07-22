package armazenamento;

/**
 * Interface para gerenciar a pontuação dos jogadores.
 * Permite adicionar jogadores e obter suas pontuações.
 *
 * @author Luiz Eduardo
 * @version 1.0
 */
public interface GerenciaJogadores {

    /**
     * Adiciona um jogador com uma pontuação especificada.
     * Se o jogador já existir, a pontuação é atualizada.
     *
     * @param nome O nome do jogador.
     * @param pontuacao A pontuação a ser atribuída ao jogador.
     */
    void adicionarJogador(String nome, int pontuacao);

    /**
     * Obtém a pontuação de um jogador.
     * Se o jogador não existir, retorna 0.
     *
     * @param nome O nome do jogador.
     * @return A pontuação do jogador. Se o jogador não existir, retorna 0.
     */
    int obterPontuacao(String nome);
}
