package entradadedados;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Classe responsável por tocar efeitos sonoros especiais no jogo.
 * Utiliza a API Java Sound para reproduzir arquivos de áudio.
 *
 * @author Luiz Eduardo
 * @version 1.0
 */

public class EasterEgg {

    /**
     * Toca o som de suspeita associado a um easter egg.
     * O som é reproduzido a partir do arquivo "CCP.wav" localizado no diretório "src/jogodavelha".
     */
    public void EntradaSuspeitaCCP() {
        try {
            File somArquivo = new File("src/jogodavelha/CCP.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(somArquivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.err.println("Erro ao tocar som de suspeita: " + e.getMessage());
        }
    }

    /**
     * Toca o som de vitória.
     * O som é reproduzido a partir do arquivo "somVitoria.wav" localizado no diretório "src/jogodavelha".
     */
    public void tocarSomDeVitoria() {
        try {
            File somArquivo = new File("src/jogodavelha/somVitoria.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(somArquivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.err.println("Erro ao tocar som de vitória: " + e.getMessage());
        }
    }
}
