package Lesson_15_Without_Synchronizer;

import java.util.*;

public class MadScientist {
    private String name;
    private Map<String, Integer> availableDetails = new HashMap<>();
    private int numberOfConstructedRobots = 0;
    private Minion personalMinion;

    public MadScientist(String name) {
        this.name = name;
        availableDetails.put("Head", 0);
        availableDetails.put("Left Arm", 0);
        availableDetails.put("Right Arm", 0);
        availableDetails.put("Body", 0);
        availableDetails.put("Left Leg", 0);
        availableDetails.put("Right Leg", 0);
        availableDetails.put("CPU", 0);
        availableDetails.put("RAM", 0);
        availableDetails.put("HDD", 0);
        personalMinion = new Minion();
    }

    public void constructRobots() {
        numberOfConstructedRobots = availableDetails.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getValue))
                .get().getValue();
    }

    public long numberOfDetailsOnStock() {
        return availableDetails
                .entrySet().stream()
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public void sendMinionToWork(Dump dump) {
        personalMinion.stealDetailsFromDump(dump);
    }

    public int getNumberOfConstructedRobots() {
        return numberOfConstructedRobots;
    }

    public String getName() {
        return name;
    }

    public class Minion {
        private static final int MAX_STAMINA_OF_MINION = 2;
        private List<Detail> lootBag = new ArrayList<>();
        private int stamina = MAX_STAMINA_OF_MINION;

        private void returnWithLootToMaster() {
            lootBag.forEach(detail -> availableDetails.put(detail.getName(), availableDetails.get(detail.getName()) + 1));
            lootBag.clear();
        }

        private void stealDetailsFromDump(Dump dump) {
            if (isTired()) {
                rest();
                return;
            }
            List<Detail> details = dump.getAvailableDetailsOnTheDump();
            int randomSizeOfBag = new Random().nextInt(4) + 1;
            for (int i = 0; i < randomSizeOfBag; i++) {
                if (dump.hasDetails()) {
                    int indexOfFoundDetail = 0;
                    lootBag.add(details.get(indexOfFoundDetail));
                    details.remove(indexOfFoundDetail);
                }
            }
            System.out.println("Мастер " + name + (lootBag.size() > 0
                    ? (", я принес " + lootBag.size() + " деталь(-и)")
                    : ", я ничего не принес ٩(͡๏̯͡๏)۶"));
            stamina -= lootBag.size();
            returnWithLootToMaster();
        }

        private boolean isTired() {
            return stamina <= 0;
        }

        private void rest() {
            System.out.println("Мастер " + name + ", я устал. Отдохну этой ночью.");
            stamina = MAX_STAMINA_OF_MINION;
        }
    }
}
