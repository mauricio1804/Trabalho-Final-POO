package entradadedados;

import java.util.Scanner;

/**
 * Classe responsável por fornecer métodos para entrada de dados do usuário via console.
 * Utiliza a classe {@link Scanner} para ler diferentes tipodas.s de entra
 *
 * @author Mauricio
 * @version 1.0
 */
public class Console {
    private Scanner leia;

    /**
     * Construtor da classe Console. Inicializa o objeto Scanner para leitura de entradas.
     */
    public Console() {
        leia = new Scanner(System.in);
    }

    /**
     * Lê uma entrada do usuário do tipo String.
     *
     * @param mensagem A mensagem a ser exibida para o usuário antes da entrada.
     * @return A entrada do usuário como uma String.
     */
    public String lerString(String mensagem) {
        System.out.println(mensagem);
        return leia.nextLine();
    }

    /**
     * Lê uma entrada do usuário do tipo inteiro.
     * Se a entrada não for um número inteiro, o método continua solicitando uma nova entrada.
     *
     * @param mensagem A mensagem a ser exibida para o usuário antes da entrada.
     * @return A entrada do usuário como um inteiro.
     */
    public int lerInt(String mensagem) {
        System.out.println(mensagem);
        while (!leia.hasNextInt()) {
            System.out.println("Entrada inválida. " + mensagem);
            leia.next();
        }
        return leia.nextInt();
    }
}
