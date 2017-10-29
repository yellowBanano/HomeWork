package Lesson_15_Without_Synchronizer;

public class ConstructionRobotsChallenge {

    public static final Dump dump = new Dump();
    public static final MadScientist hubert = new MadScientist("Хьюберт");
    public static final MadScientist doc = new MadScientist("Док");
    public static final int NUMBER_OF_NIGHTS = 100;
    public static final int DURATION_OF_NIGHT_IN_MILLIS = 100;

    public static void main(String[] args) {
        Thread hotNights = new Night(1);
        hotNights.start();
        try {
            hotNights.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hubert.constructRobots();
        doc.constructRobots();
        System.out.println("\n" + hubert.getName() + " создал: " + hubert.getNumberOfConstructedRobots() + " роботов");
        System.out.println(doc.getName() + " создал: " + doc.getNumberOfConstructedRobots() + " роботов");
        System.out.println("\nПобедитель - " + selectTheWinner(hubert, doc) + "!!!");
    }

    public static class Night extends Thread {
        private int countOfNights;

        public Night(int countOfNights) {
            this.countOfNights = countOfNights;
        }

        @Override
        public void run() {
            System.out.println("------ " + countOfNights + "-ая ночь ------");
            System.out.println("До: на свалке " + dump.getAvailableDetailsOnTheDump().size());

            Thread actionsOfFirstScientist = new ActionsOfScientist(hubert);
            Thread actionsOfSecondScientist = new ActionsOfScientist(doc);
            Thread plantEmission = new PlantEmission();

            if (countOfNights > 1) {
                plantEmission.start();
            }
            actionsOfFirstScientist.start();
            actionsOfSecondScientist.start();

            try {
                plantEmission.join();
                actionsOfFirstScientist.join();
                actionsOfSecondScientist.join();
                Thread.sleep(DURATION_OF_NIGHT_IN_MILLIS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Деталей у " + hubert.getName() + "а в наличии "
                    + hubert.numberOfDetailsOnStock());
            System.out.println("Деталей у " + doc.getName() + "а в наличии "
                    + doc.numberOfDetailsOnStock());
            System.out.println("После: на свалке " + dump.getAvailableDetailsOnTheDump().size());

            if (countOfNights < NUMBER_OF_NIGHTS) {
                Thread nextNight = new Night(++countOfNights);
                nextNight.start();
                try {
                    nextNight.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ActionsOfScientist extends Thread {
        MadScientist scientist;

        public ActionsOfScientist(MadScientist scientist) {
            this.scientist = scientist;
        }

        @Override
        public void run() {
            scientist.sendMinionToWork(dump);
        }
    }

    public static class PlantEmission extends Thread {

        @Override
        public void run() {
            dump.plantEmission();
        }
    }

    private static String selectTheWinner(MadScientist first, MadScientist second) {
        return first.getNumberOfConstructedRobots() == second.getNumberOfConstructedRobots()
                ? "Дружба"
                : first.getNumberOfConstructedRobots() > second.getNumberOfConstructedRobots()
                    ? first.getName()
                    : second.getName();
    }
}
