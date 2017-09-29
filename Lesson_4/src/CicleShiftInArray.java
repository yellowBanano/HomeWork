package Lesson_4_HW;

import java.util.Arrays;

public class CicleShiftInArray {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int numberOfIteration = 1;
        System.out.println(Arrays.toString(array));
        cicleShiftToRightSide(array, numberOfIteration);
        System.out.println(Arrays.toString(array));
    }

    public static void cicleShiftToRightSide(int[] array, int numberOfIteration) {
        for (int iteration = 0; iteration < numberOfIteration; iteration++) {
            int tempVariable = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = tempVariable;
        }
    }
}
