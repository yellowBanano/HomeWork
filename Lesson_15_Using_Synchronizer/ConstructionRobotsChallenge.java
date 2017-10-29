package Lesson_15_Using_Synchronizer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ConstructionRobotsChallenge {

    private static final Dump dump = new Dump();
    private static final MadScientist hubert = new MadScientist("Хьюберт");
    private static final MadScientist doc = new MadScientist("Док");
    private static final int NUMBER_OF_NIGHTS = 100;
    private static final int DURATION_OF_NIGHT_IN_MILLIS = 100;
    private static final CyclicBarrier barrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        PlantEmission emission = new PlantEmission(dump, barrier);
        ActionsOfScientist first = new ActionsOfScientist(hubert, barrier);
        ActionsOfScientist second = new ActionsOfScientist(doc, barrier);

        emission.start();
        first.start();
        second.start();

        try {
            emission.join();
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hubert.constructRobots();
        doc.constructRobots();
        System.out.println("\n" + hubert.getName() + " создал: " + hubert.getNumberOfConstructedRobots() + " роботов");
        System.out.println(doc.getName() + " создал: " + doc.getNumberOfConstructedRobots() + " роботов");
        System.out.println(selectTheWinner(hubert, doc));
    }

    private static class ActionsOfScientist extends Thread {
        private MadScientist scientist;
        private CyclicBarrier barrier;

        public ActionsOfScientist(MadScientist scientist, CyclicBarrier barrier) {
            this.scientist = scientist;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            for (int countOfNight = 1; countOfNight <= NUMBER_OF_NIGHTS; countOfNight++) {
                try {
                    barrier.await();
                    scientist.sendMinionToWork(dump);
                    Thread.sleep(DURATION_OF_NIGHT_IN_MILLIS);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class PlantEmission extends Thread {
        private Dump dump;
        private CyclicBarrier barrier;

        public PlantEmission(Dump dump, CyclicBarrier barrier) {
            this.dump = dump;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            for (int countOfNight = 1; countOfNight <= NUMBER_OF_NIGHTS; countOfNight++) {
                try {
                    System.out.println("------ " + countOfNight + "-ая ночь ------");
                    System.out.println("До: на свалке " + dump.getAvailableDetailsOnTheDump().size());
                    barrier.await();
                    dump.plantEmission();
                    Thread.sleep(DURATION_OF_NIGHT_IN_MILLIS);
                    System.out.println("Деталей у " + hubert.getName() + "а в наличии "
                            + hubert.numberOfDetailsOnStock());
                    System.out.println("Деталей у " + doc.getName() + "а в наличии "
                            + doc.numberOfDetailsOnStock());
                    System.out.println("После: на свалке " + dump.getAvailableDetailsOnTheDump().size());

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static String selectTheWinner(MadScientist first, MadScientist second) {
        return first.getNumberOfConstructedRobots() == second.getNumberOfConstructedRobots()
                ? "\nНичья"
                : "\nПобедитель - " + (first.getNumberOfConstructedRobots() > second.getNumberOfConstructedRobots()
                    ? first.getName()
                    : second.getName());
    }
}
