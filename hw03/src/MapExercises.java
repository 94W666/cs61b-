import org.apache.hc.core5.annotation.Internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        // TODO: Implement this method
        Map<Character,Integer> temp = new HashMap<>();

       for(int i = 0;i < 26;i += 1) {
           temp.put((char)('a' + i),i + 1);
       }

        return temp;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        // TODO: Implement this method
        Map<Integer,Integer> temp = new HashMap<>();

        for(int i = 0;i < nums.size();i += 1) {
            temp.put(nums.get(i), nums.get(i) * nums.get(i));
        }

        return temp;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        // TODO: Implement this method
        Map<String,Integer> temp = new HashMap<>();

        for(int i = 0;i < words.size();i += 1) {
            int count = 0;
            for(int j = 0;j < words.size();j += 1) {
                if(words.get(i).equals(words.get(j))) {
                    count += 1;
                }
            }
            temp.put(words.get(i),count);
        }

        return temp;
    }
}
