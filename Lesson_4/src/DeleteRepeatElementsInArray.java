package Lesson_4_HW;

import java.util.Arrays;
import java.util.Random;

public class DeleteRepeatElementsInArray {
    public static void main(String[] args) {
        int size = 100;
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(array));
        array = checkAndDeleteRepeatElementsInArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] checkAndDeleteRepeatElementsInArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    array = removeElementInArray(array, j);
                    j = 0;
                }
            }
        }
        return array;
    }

    public static int[] removeElementInArray(int[] originalArray, int index) {
        if (index >= 0 && index < originalArray.length) {
            int[] finalArray = new int[originalArray.length - 1];
            for (int i = 0, j = 0; i < originalArray.length; i++) {
                if (i != index) {
                    finalArray[j] = originalArray[i];
                    j++;
                }
            }
            return finalArray;
        }
        return originalArray;
    }
}
