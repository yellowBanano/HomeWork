package Lesson_15_Without_Synchronizer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Dump {
    private List<Detail> availableDetailsOnTheDump = Collections.synchronizedList(new LinkedList<>());

    public Dump() {
        IntStream.range(0, 20)
                .forEach(i -> availableDetailsOnTheDump.add(new Detail()));
    }

    public void plantEmission() {
        int randomEmission = new Random().nextInt(4) + 1;
        IntStream.range(0, randomEmission)
                .forEach(i -> availableDetailsOnTheDump.add(new Detail()));
        System.out.println("Завод выбросил " + randomEmission + " ненужную(-ых) деталь(-и)");
    }

    public synchronized boolean hasDetails() {
        return !availableDetailsOnTheDump.isEmpty();
    }

    public synchronized List<Detail> getAvailableDetailsOnTheDump() {
        return availableDetailsOnTheDump;
    }
}
