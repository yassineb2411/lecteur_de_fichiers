import lecteur_de_fichiers.FileTxt;
import lecteur_de_fichiers.FileType;
import java.io.IOException;

public class FileReader {
    public static void main(String[] args) {
        FileType fileTxt = new FileTxt("C:/Users/FlowUP/Desktop/fichiertest.txt");

        try {
            fileTxt.openFile();
            fileTxt.displayContent();
            fileTxt.displayContentReversed();
            fileTxt.displayContentPalindromic();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        } finally {
            try {
                fileTxt.closeFile();
            } catch (IOException e) {
                System.out.println("Erreur lors de la fermeture du fichier : " + e.getMessage());
            }
        }
    }
}
