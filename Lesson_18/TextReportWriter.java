package Lesson_18;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class TextReportWriter implements ReportWriter {

    @Override
    public void writeReport(String text, String reportTitle) {
        File folder = new File("src" + File.separator + "Lesson_18", "Reports");
        if (!folder.exists()) {
            folder.mkdir();
        }

        File destination = new File(folder, reportTitle + ".txt");

        try (Writer writer = new PrintWriter(destination)) {
            destination.createNewFile();
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Отчет из расписания создан.");
    }
}
