package Lesson_15_Using_Synchronizer;

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
        if (new Random().nextInt(100) + 1 > 90) {
            IntStream.range(0, 2 * randomEmission)
                    .forEach(i -> availableDetailsOnTheDump.add(new Detail()));
            System.out.println("Работники завода - настоящие трудяги. Сегодня выброс увеличен в 2 раза!");
            System.out.println("Завод выбросил " + 2 * randomEmission + " ненужную(-ых) деталь(-и)");
        } else {
            IntStream.range(0, randomEmission)
                    .forEach(i -> availableDetailsOnTheDump.add(new Detail()));
            System.out.println("Завод выбросил " + randomEmission + " ненужную(-ых) деталь(-и)");
        }
    }

    public synchronized void putSomeDetailTo(List<Detail> list) {
        if (!availableDetailsOnTheDump.isEmpty()) {
            int ind = availableDetailsOnTheDump.size() > 1
                    ? new Random().nextInt(availableDetailsOnTheDump.size() - 1)
                    : 0;
            list.add(availableDetailsOnTheDump.get(ind));
            availableDetailsOnTheDump.remove(ind);
        }
    }

    public List<Detail> getAvailableDetailsOnTheDump() {
        return availableDetailsOnTheDump;
    }
}
