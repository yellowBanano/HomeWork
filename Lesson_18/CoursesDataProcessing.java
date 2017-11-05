package Lesson_18;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CoursesDataProcessing {

    private static final File source = new File("src" + File.separator + "Lesson_18", "log file.txt");

    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("\nВыберите вариант отчета:\n 1. В виде временных отрезков\n 2. В виде общего времени");
            System.out.print("Ваш выбор: ");
            String choice = new Scanner(System.in).nextLine();
            if (choice.toLowerCase().equals("exit")) {
                return;
            } else if (choice.equals("1")) {
                Report timeIntervalReport = new TimeIntervalReport(source);
                timeIntervalReport.generateReport();
            } else if (choice.equals("2")) {
                Report timeActivityReport = new TimeActivityReport(source);
                timeActivityReport.generateReport();
            } else {
                System.out.println("Неверная комманда. Повторите выбор.");
            }
        }
    }
}
