package Jogodavelha;

/**
 * exceção personalizada para indicar erros relacionados à verificação de posição no tabuleiro.
 * Esta exceção é lançada quando uma posição fornecida é inválida ou já está ocupada.
 *
 * @Exception
 *
 * @author Mauricio
 * @version 1.0
 */
public class ExceptionVerificaPosicao extends RuntimeException {

    /**
     * Construtor que cria uma nova instância da exceção com uma mensagem específica.
     *
     *
     * @param msg A mensagem que descreve o motivo da exceção.
     */
    public ExceptionVerificaPosicao(String msg) {
        super(msg);
    }
}
