import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    Time Complexity: O(N) -> We do a loop over our array
    Space Complexity: O(N) -> Due to creating a map

    Given a string, find the length of the longest substring without repeating characters
    Example:
    input: abcabcbb
    Output: 3 -> abc

    Use Slide window technique
    * Initialize our 2 pointers, left and right boat at 0
    * the 2 pointers will eventually contain the start and end position of the answer substring
    * intialize our 2 pointers, left and right, both at 0
    * Create an empty map, say we'll call it m
    * m will be have a key-value pair of <Char, position>
        char: char in the string
        pos: last position of the char in the string

 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static Integer lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        int answ = 0;
        int n = s.length();
        char[] elements = s.toCharArray();

        Character el;
        while(left < n && right < n){
            el = elements[right];
            if(m.containsKey(el))
                left = Math.max(left, m.get(el) + 1);

            m.put(el,right);

            answ = Math.max(answ, right - left + 1);
            right += 1;
        }

        return  answ;
    }
}
