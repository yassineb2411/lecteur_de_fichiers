package lecteur_de_fichiers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FileTxt extends FileType {

    public FileTxt(String filePath) {
        super(filePath);
    }

    @Override
    public String readFile() throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }

        return content.toString();
    }


    @Override
    public void displayContent() throws IOException {
        String content = readFile();
        System.out.println(content);
    }

    @Override
    public void displayContentReversed() throws IOException {
        openFile();
        String content = readFile();
        if (content == null || content.isEmpty()) {
            System.out.println("Le contenu est vide.");
            closeFile();
            return;
        }

        System.out.println("Contenu inversé : ");
        String[] lines = content.split("\n");
        for (int i = lines.length - 1; i >= 0; i--) {
            System.out.println(lines[i]); // Affiche chaque ligne à l'envers
        }
        closeFile();
    }

    @Override
    public void displayContentPalindromic() throws IOException {
        openFile();
        String content = readFile();
        if (content == null || content.isEmpty()) {
            System.out.println("Le contenu est vide.");
            return;
        }

        StringBuilder palindromicContent = new StringBuilder(content).reverse();
        System.out.println("\n Contenu palindromique : " + palindromicContent.toString()); // Affiche le contenu palindromique
    }


    @Override
    public boolean compare(FileType anotherFile) throws IOException {
        return this.readFile().equals(anotherFile.readFile());
    }
}
