import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RatingBoard {

    public static void main(String[] args) {

        List<Student> ratingBoard = new ArrayList<>();

        ratingBoard.add(new Student("Артем", "Мельников ", 20, 9.33));
        ratingBoard.add(new Student("Владислав", "Мильто ", 19, 9.33));
        ratingBoard.add(new Student("Сергей", "Прокопенко", 22, 9.29));
        ratingBoard.add(new Student("Софья", "Билык", 19, 9.86));
        ratingBoard.add(new Student("Джейсон", "Стейтем", 21, 5));

        System.out.println(ratingBoard);
        System.out.println("\n---Сортировка по полному имени:");
        Collections.sort(ratingBoard, new StudentsComparators.FullNameComparator());
        System.out.println(ratingBoard);
        System.out.println("\n---Сортировка по возрасту:");
        Collections.sort(ratingBoard, new StudentsComparators.AgeComparator());
        System.out.println(ratingBoard);
        System.out.println("\n---Сортировка по среднему баллу:");
        Collections.sort(ratingBoard, new StudentsComparators.AverageRatingComparator());
        System.out.println(ratingBoard);

        showTeachersFavorite(ratingBoard);
    }

    public static void showTeachersFavorite(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        Student topStudent = students.get(0);
        while (iterator.hasNext()) {
            Student suspiciousStudent = iterator.next();
            if (suspiciousStudent.getMarkThatDeterminesYourLife() > topStudent.getMarkThatDeterminesYourLife()) {
                topStudent = suspiciousStudent;
            }
        }
        System.out.println("\nЛюбимчик преподавателей это:" + topStudent);
    }
}
