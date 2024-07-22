package Jogodavelha;

/**
 * Exceção personalizada para indicar erros relacionados a nomes inseridos no jogo.
 * Esta exceção é lançada quando o nome fornecido não é válido.
 *
 * @Exception
 *
 * @author Luiz Eduardo
 * @version 1.0
 */
public class ExceptionNomeInserido extends RuntimeException {

    /**
     * Construtor que cria uma nova instância da exceção com uma mensagem específica.
     *
     * @param msg A mensagem que descreve o motivo da exceção.
     */
    public ExceptionNomeInserido(String msg) {
        super(msg);
    }
}
