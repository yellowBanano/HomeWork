import java.util.Comparator;

public class StudentsComparators {

    public static class FullNameComparator implements Comparator<Student> {

        @Override
        public int compare(Student student1, Student student2) {
            return student1.getName().compareTo(student2.getName())
                    + student1.getSurname().compareTo(student2.getSurname());
        }
    }

    public static class AgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student student1, Student student2) {
            return student1.getAge() <= student2.getAge() ? 1 : -1;
        }
    }

    public static class AverageRatingComparator implements Comparator<Student> {

        @Override
        public int compare(Student student1, Student student2) {
            return student1.getMarkThatDeterminesYourLife() <= student2.getMarkThatDeterminesYourLife() ? 1 : -1;
        }
    }
}
