package Lesson_4_HW;

import java.util.Arrays;
import java.util.Random;

public class UnionTwoArrays {
    public static void main(String[] args) {
        Random random = new Random();
        int[] firstArray = new int[random.nextInt(10)];
        int[] secondArray = new int[random.nextInt(10)];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = random.nextInt(100);
        }
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(firstArray));
        System.out.println(Arrays.toString(secondArray));
        System.out.println(Arrays.toString(uniteTwoArrays(firstArray, secondArray)));
    }

    public static int[] uniteTwoArrays(int[] firstArray, int[] secondArray) {
        int comboSize = firstArray.length + secondArray.length;
        int[] finalArray = new int[comboSize];
        for (int i = 0, j = 0; i + j < comboSize; ) {
            if (i < firstArray.length) {
                finalArray[i + j] = firstArray[i];
                i++;
            }
            if (j < secondArray.length) {
                finalArray[i + j] = secondArray[j];
                j++;
            }
        }
        return finalArray;
    }
}
