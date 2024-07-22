package armazenamento;

import Jogodavelha.Jogador;
import entradadedados.Console;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela gestão dos jogadores utilizando ArrayLists.
 * Esta classe permite adicionar jogadores, obter pontuações, e salvar e carregar
 *
 * @author Luiz Eduardo
 * @version 1.0
 * dados dos jogadores em um arquivo.
 */
public class GerenciajogadoresArrayList implements GerenciaJogadores {

    /**
     * Lista que armazena os nomes dos jogadores.
     */
    private ArrayList<String> nomes;

    /**
     * Lista que armazena as pontuações correspondentes aos nomes dos jogadores.
     */
    private ArrayList<Integer> pontuacoes;

    /**
     * Nome do arquivo onde os dados dos jogadores são armazenados.
     */
    private final String arquivo = "HistoricoJogadores.txt";

    /**
     * Instância da classe Console para entrada de dados.
     */
    private Console console;

    /**
     * Construtor da classe. Inicializa as listas de nomes e pontuações, e carrega
     * os dados dos jogadores a partir do arquivo.
     */
    public GerenciajogadoresArrayList() {
        nomes = new ArrayList<>();
        pontuacoes = new ArrayList<>();
        console = new Console();
        carregarJogadores(); // Carrega os dados ao inicializar
    }

    /**
     * Adiciona um jogador ou atualiza a pontuação de um jogador existente.
     * Os dados são salvos no arquivo após a adição ou atualização.
     *
     * @param nome      O nome do jogador a ser adicionado ou atualizado.
     * @param pontuacao A pontuação a ser atribuída ao jogador.
     */
    public void adicionarJogador(String nome, int pontuacao) {
        int index = nomes.indexOf(nome);
        if (index != -1) {
            pontuacoes.set(index, pontuacao); // Atualiza a pontuação existente
        } else {
            nomes.add(nome); // Adiciona um novo jogador
            pontuacoes.add(pontuacao);
        }
        salvarJogadores(); // Salva os dados sempre que adicionar ou atualizar um jogador
    }

    /**
     * Obtém a pontuação atual de um jogador.
     *
     * @param nome O nome do jogador cuja pontuação será retornada.
     * @return A pontuação do jogador. Retorna 0 se o jogador não for encontrado.
     */
    public int obterPontuacao(String nome) {
        int index = nomes.indexOf(nome);
        if (index != -1) {
            return pontuacoes.get(index);
        }
        return 0;
    }

    /**
     * Carrega os dados dos jogadores a partir do arquivo.
     * Cada linha do arquivo deve estar no formato "nome:pontuacao".
     */
    public void carregarJogadores() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    String nome = partes[0];
                    int pontuacao = Integer.parseInt(partes[1]);
                    nomes.add(nome);
                    pontuacoes.add(pontuacao);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Continuando com lista vazia.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Salva os dados dos jogadores no arquivo.
     * Cada entrada no arquivo é escrita no formato "nome:pontuacao".
     */
    private void salvarJogadores() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (int i = 0; i < nomes.size(); i++) {
                bw.write(nomes.get(i) + ":" + pontuacoes.get(i));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lista todos os jogadores e suas pontuações.
     *
     * @return Uma lista de objetos Jogador representando todos os jogadores e suas pontuações.
     */
    public List<Jogador> listarJogadores() {
        List<Jogador> jogadores = new ArrayList<>();
        for (int i = 0; i < nomes.size(); i++) {
            jogadores.add(new Jogador(nomes.get(i), pontuacoes.get(i)));
        }
        return jogadores;
    }
}
