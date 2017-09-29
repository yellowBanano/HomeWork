package Lesson_4_HW;

import java.util.*;

public class ConvertTwoIntoOneDimensionalArray {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] array = new int[random.nextInt(10)][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[random.nextInt(10)];
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
        System.out.println(Arrays.deepToString(array));
        System.out.println(Arrays.toString(linearize(array)));
    }

    public static int[] linearize(int[][] originalArray) {
        int size = 0;
        for (int i = 0; i < originalArray.length; i++) {
            size += originalArray[i].length;
        }
        int[] finalArray = new int[size];
        for (int i = 0, k = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[i].length; j++) {
                finalArray[k] = originalArray[i][j];
                k++;
            }
        }
        return finalArray;
    }
}
