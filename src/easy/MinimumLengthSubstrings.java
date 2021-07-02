package easy;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class MinimumLengthSubstrings {

    // Add any helper functions you may need here


    int minLengthSubstring(String s, String t) {
        // Write your code here
        int sn = s.length(), tn = t.length();
        if (sn < tn) {
            return -1;
        }
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        int charFoundInSubStr = 0;
        Map<Character, Integer> tmap = new HashMap<>();
        for(int i=0; i<tn; i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> smap = new HashMap<>();
        // "matchPos" is used to store matching character position,
        // after finding a substring, instead of moving one character from last start position we can just
        // jump to the next matching character after start
        List<Integer> matchPos = new ArrayList<>();
        for(int i=0; i<sn; i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
            if (tmap.containsKey(s.charAt(i))) {
                if (start == -1) {
                    start = i;
                }
                matchPos.add(i);
                if (tmap.get(s.charAt(i)) == smap.get(s.charAt(i))) {
                    charFoundInSubStr++;
                    while(charFoundInSubStr == tn) {
                        char sc = s.charAt(start);
                        if (minLen == Integer.MAX_VALUE ||  minLen > i-start+1) {
                            minLen = i-start+1;
                        }
                        smap.put(sc, smap.get(sc)-1);
                        if (tmap.containsKey(sc) && smap.get(sc) < tmap.get(sc)) {
                            charFoundInSubStr--;
                        }
                        start++;
                    }
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? -1: minLen;
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
    public void run() throws IOException {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) throws IOException {
        new MinimumLengthSubstrings().run();
    }
}