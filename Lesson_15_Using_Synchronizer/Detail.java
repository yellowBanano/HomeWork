package Lesson_15_Using_Synchronizer;

import java.util.Arrays;
import java.util.Random;

public class Detail {
    private String name;

    public Detail() {
        this.name = Arrays.asList("Head", "Left Arm", "Right Arm", "Body", "Left Leg", "Right Leg", "CPU", "RAM", "HDD")
                .get(new Random().nextInt(9));
    }

    public String getName() {
        return name;
    }
}
