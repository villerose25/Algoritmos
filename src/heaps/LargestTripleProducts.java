package heaps;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class LargestTripleProducts {

    // Add any helper functions you may need here


    int[] findMaxProduct(int[] arr) {
        // Write your code here
// **** sanity check(s) ****
        if (arr.length == 1)
            return new int[] { -1 };

        if (arr.length == 2)
            return new int[] { -1, -1 };

        // **** initialization ****
        int[] prods = new int[arr.length];
        prods[0]    = prods[1] = -1;
        int prod    = arr[0] * arr[1] * arr[2];
        prods[2]    = prod;

        // **** priority heap (implemented with a priority queue) ****
        PriorityQueue<Integer> maxVals = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return Integer.compare(x, y);
            }
        });
        maxVals.add(arr[0]);
        maxVals.add(arr[1]);
        maxVals.add(arr[2]);

        // **** traverse array O(n) ****
        for (int i = 3; i < arr.length; i++) {

            // **** update max values (if needed) ****
            if (arr[i] > maxVals.peek()) {

                // **** remove from head of the queue (smallest value) ****
                maxVals.remove();

                // **** add new highest value ****
                maxVals.add(arr[i]);

                // **** compute the max product ****
                Integer[] tmp = (Integer[]) maxVals.toArray(new Integer[0]);
                prod = tmp[0] * tmp[1] * tmp[2];
            }

            // **** set the max product in the array ****
            prods[i] = prod;
        }

        // **** return array of max products ****
        return prods;
    }












    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int[] arr_1 = {1, 2, 3, 4, 5};
        int[] expected_1 = {-1, -1, 6, 24, 60};
        int[] output_1 = findMaxProduct(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {-1, -1, 56, 56, 140, 140};
        int[] output_2 = findMaxProduct(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new LargestTripleProducts().run();
    }
}