import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextStatistics {

    public static void main(String[] args) {
        System.out.println("---Вводите текст:---");
        String text = new Scanner(System.in).nextLine();
        printHighlightedWords(highlightWordsInText(text));
    }

    public static Map<String, Integer> highlightWordsInText(String text) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : text.split("\\W+")) {
            wordsMap.put(word, wordsMap.containsKey(word) ? wordsMap.get(word) + 1 : 1);
        }
        return wordsMap;
    }

    public static void printHighlightedWords(Map<String, Integer> map) {
        map.forEach((key, value) -> System.out.println("Слово \"" + key + "\" встречается " + value + " раз(а)"));
    }
}
