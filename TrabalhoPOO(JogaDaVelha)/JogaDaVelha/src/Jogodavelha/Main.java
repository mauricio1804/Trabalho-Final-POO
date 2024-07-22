package Jogodavelha;

import java.util.Scanner;
import armazenamento.*;

/**
 * Classe principal que inicia o jogo e exibe o menu para o usuário.
 *
 * @author Mauricio
 * @version 1.0
 */
public class Main {

    /**
     * Método principal que inicia o menu do jogo.
     *
     * @param args Argumentos da linha de comando, não utilizados aqui.
     */
    public static void main(String[] args) {
        menu();
    }

    /**
     * Exibe o menu principal do jogo e lida com as opções escolhidas pelo usuário.
     * O menu oferece as seguintes opções:
     * 1. Novo Jogo - Inicia um novo jogo.
     * 2. Extra - Modo extra.
     * 3. Histórico de jogadores - Permite ao usuário acessar o histórico de jogadores.
     * 4. Sair - Encerra o programa.
     */
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int leia;
        Jogo jogo = new Jogo(); // Instancia o objeto Jogo
        Reverso reverso = new Reverso(); // Instacia o modo extra

        do {
            System.out.println("=== Jogo Da Velha ===");
            System.out.println("1. Novo Jogo");
            System.out.println("2. Extra");
            System.out.println("3. Mostrar historico dos jogadores");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            leia = scanner.nextInt();

            switch (leia) {
                case 1:
                    System.out.println("Começando jogo");
                    jogo.iniciar(); // Inicia o jogo
                    break;
                case 2:
                    System.out.println("Modo sério ativado");
                    reverso.iniciar(); // modo extra do jogo
                    break;
                case 3:
                    jogo.jogadores(); // Exibe informações sobre jogadores existentes
                    break;
                case 4:
                    System.out.println("Jogo encerrado XD");
                    System.exit(0); // Encerra o programa
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (leia != 4);
    }
}
