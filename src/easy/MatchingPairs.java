package easy;
/*
Approach:


Initialize a counter variable with 0.
Iterate over the first string from the starting character to ending character.
If the character extracted from the first string is found in the second string, then increment the value of the counter by 1.
The final answer will be count/2 as the duplicates are not being considered.
Output the value of counter
Below is the implementation of the above approach
 */
import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class MatchingPairs {

    // Add any helper functions you may need here


    int matchingPairs(String s, String t) {
        Set<String> unMatched = new HashSet<String>();
        Set<Character> matched = new HashSet<Character>();
        int count = 0;
        boolean isDup = false;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == t.charAt(i)) {
                count++;
                if(matched.contains(s.charAt(i))) {
                    isDup = true;
                }
                matched.add(s.charAt(i));
            } else {
                unMatched.add(s.charAt(i) + "" + t.charAt(i));
            }
        }

        if(count == s.length()) {
            return isDup ? count :  count - 2;
        }

        if(count == s.length() - 1) {
            String onlyUnmatched = (String)unMatched.toArray()[0];
            if(isDup || matched.contains(onlyUnmatched.charAt(0)) || matched.contains(onlyUnmatched.charAt(1)))
                return count;
            return count - 1;
        }

        for(String um:unMatched) {
            if(unMatched.contains(um.charAt(1)+""+um.charAt(0))) {
                return count + 2;
            }
        }

        Set<Character> unMatchedS = new HashSet<>();
        Set<Character> unMatchedT = new HashSet<>();

        for(String um : unMatched) {
            if(unMatchedS.contains(um.charAt(1)) || unMatchedT.contains(um.charAt(0))) {
                return count + 1;
            }
            unMatchedS.add(um.charAt(0));
            unMatchedT.add(um.charAt(1));
        }
        return count;
    }




    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() {
        String s_1 = "abcde";
        String t_1 = "adcbe";
        int expected_1 = 5;
        int output_1 = matchingPairs(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String t_2 = "abcd";
        int expected_2 = 2;
        int output_2 = matchingPairs(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new MatchingPairs().run();
    }
}
