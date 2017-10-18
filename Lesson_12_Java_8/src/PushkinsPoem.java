import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PushkinsPoem {

    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static void main(String[] args) throws IOException {
        Map<Character, Integer> alphabet = new LinkedHashMap<>();

        fillMapWithString(alphabet, ALPHABET);

        File filePoem = new File("Lesson_12", "poem.txt");
        filePoem.createNewFile();

        Files.lines(Paths.get(filePoem.getAbsolutePath()))
                .map(String::toLowerCase)
                .map(CharSequence::chars)
                .peek(bytes -> bytes
                        .filter(integer -> ALPHABET.contains((char) integer + ""))
                        .forEach(b -> alphabet.put((char) b, alphabet.get((char) b) + 1)))
                .forEach(System.out::println);

        System.out.println(alphabet);
    }

    public static void fillMapWithString(Map<Character, Integer> map, String string) {
        for (char letter : string.toCharArray()) {
            map.put(letter, 0);
        }
    }
}
