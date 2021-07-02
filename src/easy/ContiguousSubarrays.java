package easy;

import java.util.*;
import java.util.ArrayDeque;
import java.util.Arrays;

/*
Example:
arr = [3, 4, 1, 6, 2]
output = [1, 3, 1, 5, 1]
Explanation:
For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
For index 1 - [4], [3, 4], [4, 1]
For index 2 - [1]
For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
For index 4 - [2]
 */
public class ContiguousSubarrays {


    public int[] countSubarrays(int[] arr) {
        if(arr.length == 0) return arr;
        int[] result = new int[arr.length];
        //Arrays.fill(result, 1);
        int n = arr.length;
        int[] arrL = new int[arr.length];
        int[] arrR = new int[arr.length];
        arrL[0] = 1;
        int leftMaxIndex =0;
        int i = 1;
        while(i < n) {
            if (arr[i] > arr[i - 1]) {
                if(arr[i] > arr[leftMaxIndex]){
                    // si el elemento es mayor al max que sigue,
                    // el elemento en i =
                    arrL[i] = arrL[i] + (i - leftMaxIndex);
                    leftMaxIndex = i;
                }else {
                    arrL[i] = arrL[i + 1] + 1;
                }

            } else {
                arrL[i] = 1;
            }
            i++;
        }

        System.out.println(Arrays.toString(arrL));

        int rightMaxIndex = arr.length-1;
        arrR[arr.length-1] = 1;

        for (i=arr.length-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                if(arr[i] > arr[rightMaxIndex]){
                    arrR[i] = arrR[rightMaxIndex] + (rightMaxIndex-i);
                    rightMaxIndex = i;
                } else {
                    arrR[i] = arrR[i+1] + 1;
                }
            } else {
                arrR[i] = 1;
            }
        }

        for ( i=0;i<arr.length;i++){
            result[i] = arrL[i] + arrR[i] - 1; // counting self twice so remove 1
        }
        return result;
    }

    // copiado
    public int[] countSubarraysC(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        Arrays.fill(output, 1);

        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        stack.add(0);
        for (int i = 1; i < n; i++) {
            while (stack.peek() != -1 && arr[i] > arr[stack.peek()])
                stack.pop();
            output[i] += i - stack.peek() - 1;
            stack.add(i);
        }

        stack.clear();
        stack.add(n);
        stack.add(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (stack.peek() != n && arr[i] > arr[stack.peek()])
                stack.pop();
            output[i] += stack.peek() - i - 1;
            stack.add(i);
        }

        return output;
    }

    public int[] countSubarrays2(int[] arr) {
        int[] result = new int[arr.length];
        if (arr.length == 0) return result;

        int[] l = new int[arr.length];
        int[] r = new int[arr.length];

        int leftMaxIndex = 0;
        l[0] = 1;
        // Start traversing from left and track index of the maxSoFar
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (arr[i] > arr[leftMaxIndex]) {
                    // if element at i is greater than maxSoFar, subarrays at i = subarrays at maxSoFar + diff between indices (since there will be few more from older maxSoFar to i)
                    l[i] = l[leftMaxIndex] + (i - leftMaxIndex);
                    leftMaxIndex = i;
                } else {
                    // if element at i is less than maxSoFar, subarrays at i = subarrays at i-1 + 1 (self)
                    l[i] = l[i - 1] + 1;
                }
            } else {
                // no new subarrays except for self when element at i is less than the element at i-1
                l[i] = 1;
            }
        }

        // do the same from right
        int rightMaxIndex = arr.length - 1;
        r[arr.length - 1] = 1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > arr[rightMaxIndex]) {
                    r[i] = r[rightMaxIndex] + (rightMaxIndex - i);
                    rightMaxIndex = i;
                } else {
                    r[i] = r[i + 1] + 1;
                }
            } else {
                r[i] = 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            result[i] = l[i] + r[i] - 1; // counting self twice so remove 1
        }
        return result;
    }
}
