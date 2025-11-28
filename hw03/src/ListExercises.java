import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListExercises {
    /** Returns the total sum in a list of integers */
    public static int sum(List<Integer> L) {
        // TODO: Implement this method
        int sum = 0;
        for (int i = 0; i < L.size(); i++) {
            sum += L.get(i);
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Implement this method
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < L.size(); i++) {
            if(L.get(i) % 2 == 0) {
                temp.add(L.get(i));
            }
        }

        if(!temp.isEmpty()) {
            return temp;
        }

        return temp;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Implement this method
        List<Integer> temp = new ArrayList<>();

        for(int i = 0;i < L1.size();i += 1) {
            for(int j = 0;j < L2.size();j += 1) {
                if(L1.get(i) == L2.get(j)) {
                    temp.add(L1.get(i));
                }
            }
        }

        if(!temp.isEmpty()) {
            return temp;
        }

        return temp;
    }

    public static int countOccurrencesOfWord(List<String> words, String w) {
        // TODO: Implement this method
        return 0;
    }

    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Implement this method
        int count = 0;
        for(int i = 0;i < words.size();i += 1) {
            for(int j = 0;j < words.get(i).length();j += 1) {
                if(words.get(i).charAt(j) == c) {
                    count += 1;
                }
            }
        }

        if(count > 0) {
            return count;
        }

        return 0;
    }
}
