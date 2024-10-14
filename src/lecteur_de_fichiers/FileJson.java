package lecteur_de_fichiers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class FileJson extends FileType {

    public FileJson(String filePath) {
        super(filePath);
    }

    @Override
    public String readFile() throws IOException {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(filePath);
        JsonElement jsonElement = JsonParser.parseReader(fileReader);
        fileReader.close();
        return gson.toJson(jsonElement);
    }

    @Override
    public void displayContent() throws IOException {
        String content = readFile();
        System.out.println(content);
    }

    @Override
    public void displayContentReversed() throws IOException {
        String content = readFile();
        String reversed = new StringBuilder(content).reverse().toString();
        System.out.println(reversed);
    }

    @Override
    public void displayContentPalindromic() throws IOException {
        String content = readFile();
        String palindromicContent = new StringBuilder(content).reverse().toString();
        System.out.println(palindromicContent);
    }

    @Override
    public boolean compare(FileType otherFile) throws IOException {
        if (otherFile instanceof FileJson) {
            String thisContent = this.readFile();
            String otherContent = otherFile.readFile();

            return thisContent.equals(otherContent);
        } else {
            throw new IllegalArgumentException("Les fichiers doivent être de type JSON pour être comparés.");
        }
    }
}
