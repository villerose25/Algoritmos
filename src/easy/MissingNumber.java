package easy;

import java.util.Arrays;

/*

    given an array containing n distinct numbers taken from
    0,1,2,...,n fin the number that is missing from the array


    ex [3,0,1] -> the missing value is 2
    output: 2

   [9,6,4,2,3,5,7,0,1] --> output is 8

        // sorts are n(log n)
    //use a hashmap and do a loop
    // check if is not true, we can say is not present

    O(N) --> pass only once
    O(1) -> Space complexity
    1. Find sum of N
    2. Find sum of Array N
    3. substract the existing sum from the intended sum
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int currentSum = Arrays.stream(nums).sum();
        int n = nums.length;
        int intendedSum = n*(n+1)/2;

        return (intendedSum-currentSum);
    }
}
