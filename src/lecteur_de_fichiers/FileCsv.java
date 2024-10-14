package lecteur_de_fichiers;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileCsv extends FileType {

    public FileCsv(String filePath) {
        super(filePath);
    }

    @Override
    public String readFile() throws IOException {
        StringBuilder content = new StringBuilder();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> allRows = csvReader.readAll();

            for (String[] row : allRows) {
                content.append(String.join(",", row)).append("\n");
            }

        } catch (com.opencsv.exceptions.CsvException e) {
            e.printStackTrace();
            throw new IOException("Erreur lors de la lecture du fichier CSV.");
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
        String content = readFile();
        List<String> lines = content.lines().collect(Collectors.toList());
        for (int i = lines.size() - 1; i >= 0; i--) {
            System.out.println(lines.get(i));
        }
    }

    @Override
    public void displayContentPalindromic() throws IOException {
        String content = readFile();
        String palindromicContent = new StringBuilder(content).reverse().toString();
        System.out.println(palindromicContent);
    }

    @Override
    public boolean compare(FileType anotherFile) throws IOException {
        return this.readFile().equals(anotherFile.readFile());
    }
}
