package armazenamento;

import Jogodavelha.Jogador;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável pela gestão dos jogadores, incluindo a adição de novos jogadores,
 * carregamento e salvamento de dados de jogadores em um arquivo.
 *
 * @author Luiz Eduardo
 * @version 1.0
 */
public class GerenciaJogadoresArquivo implements GerenciaJogadores {

    /**
     * Nome do arquivo onde os dados dos jogadores são armazenados.
     */
    private String arquivo;

    /**
     * Mapa que armazena o nome do jogador e sua pontuação.
     */
    private Map<String, Integer> jogadores;

    /**
     * Construtor da classe. Inicializa o mapa de jogadores e carrega os dados do arquivo.
     *
     * @param nomeArquivo O nome do arquivo onde os dados dos jogadores são armazenados.
     */
    public GerenciaJogadoresArquivo(String nomeArquivo) {
        arquivo = nomeArquivo;
        jogadores = new HashMap<>();
        carregarDados();
    }

    /**
     * Adiciona ou atualiza a pontuação de um jogador e salva os dados no arquivo.
     *
     * @param nome  O nome do jogador a ser adicionado ou atualizado.
     * @param pontuacao A pontuação a ser adicionada ao jogador.
     */
    public void adicionarJogador(String nome, int pontuacao) {
        // Atualiza a pontuação do jogador ou adiciona um novo jogador com a pontuação fornecida
        jogadores.put(nome, jogadores.getOrDefault(nome, 0) + pontuacao);
        salvarDados();
    }

    /**
     * Carrega os dados dos jogadores a partir do arquivo.
     * Cada linha do arquivo deve estar no formato "nome:pontuacao".
     */
    private void carregarDados() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                jogadores.put(partes[0], Integer.parseInt(partes[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Continuando com lista vazia.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtém a pontuação atual de um jogador.
     *
     * @param nome O nome do jogador cuja pontuação será retornada.
     * @return A pontuação do jogador. Retorna 0 se o jogador não for encontrado.
     */
    public int obterPontuacao(String nome) {
        return jogadores.getOrDefault(nome, 0);
    }

    /**
     * Salva os dados dos jogadores no arquivo.
     * Cada entrada no arquivo é escrita no formato "nome:pontuacao".
     */
    private void salvarDados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Map.Entry<String, Integer> entrada : jogadores.entrySet()) {
                bw.write(entrada.getKey() + ":" + entrada.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtém a lista de jogadores com suas pontuações.
     *
     * @return Uma lista de objetos Jogador representando todos os jogadores e suas pontuações.
     */
    public List<Jogador> getJogadores() {
        List<Jogador> list = new ArrayList<>();
        for (Map.Entry<String, Integer> x : jogadores.entrySet()) {
            list.add(new Jogador(x.getKey(), x.getValue()));
        }
        return list;
    }
}
