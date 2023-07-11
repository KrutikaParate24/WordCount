import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {

        String filePath = "input.txt";

        Map<String, Integer> wordCountMap = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Set the delimiter to split words by whitespace and punctuation marks
            scanner.useDelimiter("[\\s.,;:!?()\\[\\]\"]+");

            // Process each word in the file
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                // Increment the count for the word in the map
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }

            // Print the word count results
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                System.out.println(entry.getValue() + " " + entry.getKey());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        }
    }
}