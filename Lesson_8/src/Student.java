public class Student{

    private String name;
    private String surname;
    private int age;
    private double markThatDeterminesYourLife;

    public Student(String name, String surname, int age, double markThatDeterminesYourLife) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.markThatDeterminesYourLife = markThatDeterminesYourLife;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public double getMarkThatDeterminesYourLife() {
        return markThatDeterminesYourLife;
    }

    @Override
    public String toString() {
        return "\n" + getName() + " " + getSurname() + "(" + getAge() + ") - " + getMarkThatDeterminesYourLife();
    }
}
