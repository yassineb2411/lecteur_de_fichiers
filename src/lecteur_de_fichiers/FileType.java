package lecteur_de_fichiers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileType implements IFileReader {
    protected String filePath;
    protected BufferedReader reader;

    public FileType(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void openFile() throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    @Override
    public void closeFile() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    @Override
    public abstract String readFile() throws IOException;

    public abstract void displayContent() throws IOException;

    public abstract void displayContentReversed() throws IOException;

    public abstract void displayContentPalindromic() throws IOException;

    public abstract boolean compare(FileType anotherFile) throws IOException;
}
