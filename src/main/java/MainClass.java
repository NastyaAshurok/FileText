import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {
    public static void main(String[] args) throws IOException {
       /* Path path = Paths.get("src/main/resources/Text.txt");
        String text = new String(Files.readAllBytes(path));
        countRepeatedWords(text); */
countRepeatedWords("The promise to Abraham came true because he trusted a promise and chose to live differently than others. Think how likely it was for this promise to have failed, but instead it has happened, and is continuing to unfold, as it was stated  thousands of years ago.  The case is strong that the promise came true only because of the power and authority of the Promise-Maker.");

    }
    public static void countRepeatedWords(String wordToFind) {
        String[] words = wordToFind.split(" ");
        HashMap<String, Integer> wordMap = new LinkedHashMap<String, Integer>();

        for (String word : words) {
            wordMap.put(word,
                    (wordMap.get(word) == null ? 1 : (wordMap.get(word) + 1)));
        }

        System.out.println(wordMap);
    }

}
