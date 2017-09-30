import java.util.Scanner;

public class ConvertationOfRomanNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println("Строка: " + string);
        System.out.println("Римские -> Арабские: " + convertRomanNumbers(string));
    }

    private static int convertRomanNumbers(String string) {
        final int M = 1000;
        final int D = 500;
        final int C = 100;
        final int L = 50;
        final int X = 10;
        final int V = 5;
        final int I = 1;
        char[] charArray = string.toCharArray();
        char[] charOfRomanNumbers = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        char[] valueOfRomanNumbers = new char[]{M, D, C, L, X, V, I};
        int number = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charOfRomanNumbers.length; j++) {
                if (charArray[i] == charOfRomanNumbers[j]) {
                    if (i < charArray.length - 1 && j >= 2 && charArray[i + 1] == charOfRomanNumbers[j - 2]) {
                        number += valueOfRomanNumbers[j - 2] - valueOfRomanNumbers[j];
                        i++;
                        break;
                    } else if (i < charArray.length - 1  && j >= 1 && charArray[i + 1] == charOfRomanNumbers[j - 1]) {
                        number += valueOfRomanNumbers[j - 1] - valueOfRomanNumbers[j];
                        i++;
                        break;
                    } else {
                        number += valueOfRomanNumbers[j];
                        break;
                    }
                }
            }
        }
        return number;
    }
}
