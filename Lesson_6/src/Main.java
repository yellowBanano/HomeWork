import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координаты для первой точки:\n X = ");
        double x1 = scanner.nextDouble();
        System.out.print(" Y = ");
        double y1 = scanner.nextDouble();
        System.out.print("Введите координаты для второй точки:\n X = ");
        double x2 = scanner.nextDouble();
        System.out.print(" Y = ");
        double y2 = scanner.nextDouble();

        Point point1 = new Point(new OX(x1), new OY(y1));
        Point point2 = new Point(new OX(x2), new OY(y2));

        Rectangle rectangle = new Rectangle(point1, point2);

        System.out.println("Площадь прямоугольника = " + rectangle.space());
        System.out.println("Длина диагонали = " + rectangle.lengthOfDiagonal());
    }
}
