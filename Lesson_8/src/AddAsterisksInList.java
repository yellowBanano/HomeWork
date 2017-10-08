import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddAsterisksInList {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        list.add("this");
        list.add("is");
        list.add("lots");
        list.add("of");
        list.add("fun");
        list.add("for");
        list.add("every");
        list.add("Java");
        list.add("programmer");

        System.out.println(list);
        markLength4(list);
        System.out.println(list);
    }

    public static void markLength4(List<String> list) {
        List<Integer> listOfIndex = new ArrayList<>();
        int addition = 0;
        for (String string : list) {
            if (string.length() == 4) {
                listOfIndex.add(list.indexOf(string) + addition);
                addition++;
            }
        }
        for (Integer index : listOfIndex) {
            list.add(index, "****");
        }
    }
}
