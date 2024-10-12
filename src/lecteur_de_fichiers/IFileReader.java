package lecteur_de_fichiers;

public interface IFileReader {
    void openFile() throws java.io.IOException;
    void closeFile() throws java.io.IOException;
    String readFile() throws java.io.IOException;
}
