import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SortFileOfIntegers {

    private static final int NUMBER_OF_VALUES = 100;
    private static final int BOUND = 20;

    public static void main(String[] args) throws IOException {
        File file = new File("Lesson_12", "SetOfIntegers.txt");
        System.out.println("Созднание файла прошло " + (file.createNewFile() ? "успешно" : "неудачно"));

        fillFileWithRandomValues(file, NUMBER_OF_VALUES, BOUND);
        sortFileWithIntegers(file);
    }

    private static void fillFileWithRandomValues(File file, int numberOfValues, int bound) {
        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < numberOfValues; i++) {
                writer.write(new Random().nextInt(bound) + (i % 10 == 9 ? "\n" : " "));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sortFileWithIntegers(File file) {
        List<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)))) {
            while (scanner.hasNext()) {
                list.add(Integer.parseInt(scanner.next()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(list);
        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i) + (i % 10 == 9 ? "\n" : " "));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

