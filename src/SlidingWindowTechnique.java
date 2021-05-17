import java.util.ArrayList;

public class SlidingWindowTechnique {

    public static void main (String[] args) {
        int k =2; // window
        int[] arr = new int[]{80, -50, 90, 100};

        System.out.println("Max sum: " + String.valueOf(maxSum(arr, k))); //190
    }

    public static Integer maxSum(int[] arr,  int windowSize) {
        int window_sum = 0;
        int max_sum = 0;
        int arraySize = arr.length;

        if(arraySize <= windowSize) {
            System.out.println("Invalid operation");
            return -1;
        }

        for (int i = 0; i < windowSize; i ++)
            window_sum += arr[i];

        // the sum of first window is the maximum
        max_sum = window_sum;

        // compute the sums of remaining window
        for(int i =0; i < arraySize-windowSize; i++) {
            // current window zum
            window_sum = window_sum - arr[i] + arr[i+windowSize];
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }
}
