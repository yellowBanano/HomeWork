import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PushkinsPoem {

    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static void main(String[] args) throws IOException {
        Map<Character, Integer> alphabet = new LinkedHashMap<>();

        fillMapWithString(alphabet, ALPHABET);

        File filePoem = new File("Lesson_12", "poem.txt");
        filePoem.createNewFile();

        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(filePoem)))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                word = word.toLowerCase();
                for (char letter : word.toCharArray()) {
                    if (alphabet.containsKey(letter)) {
                        alphabet.put(letter, alphabet.get(letter) + 1);
                    }
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        printMap(alphabet);
    }

    public static void fillMapWithString(Map<Character, Integer> map, String string) {
        for (char letter : string.toCharArray()) {
            map.put(letter, 0);
        }
    }

    public static void printMap(Map<Character, Integer> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
