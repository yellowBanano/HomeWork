import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.*;

public class StringPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = new String(scanner.nextLine());
        StringBuilder stringWithoutPunctuation = new StringBuilder(string.replaceAll("\\W",""));
        System.out.println(stringWithoutPunctuation.toString()
                .equalsIgnoreCase(stringWithoutPunctuation.reverse().toString()) ? "Palindrome" : "Not palindrome");
    }
}
