package Lesson_18;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TextReader implements Reader {
    @Override
    public String read(File source) {
        try {
            return Files.lines(Paths.get(source.getAbsolutePath()))
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
