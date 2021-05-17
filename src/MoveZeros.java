import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers, write a function to move all 0's
    to the end while maintaining the relative order of the other elements
    Time Complexity
    O(2*N) -> 2 separate loops = O(N) -> N is the size of the array
    Space Complexity: O(1)

    j=0
    for each num in input
        if(num!=0)
            nums[j] = num
            j+=1

    for every position x starting from j until input end
        nums[x]=0
 */
public class MoveZeros {
    public static void main (String[] args) {
        int[] arr = new int[]{0,1,0,3,12}; //1,3,12,0,0
        moveZeros(arr);
        moveZerosMap(arr);
    }

    // contar los no ceros, serian 3, entonces empezando del lugar 3+1 (j=3) serian ceros.
    public static void moveZeros(int[] nums) {
        int j = 0;
        int n = nums.length;
        for(Integer num : nums) {
            if(num != 0) {
                nums[j] = num;
                j += 1;
            }
        }

        for (int x = j; x< n; x++)
            nums[x] = 0;

        System.out.println(Arrays.toString(nums));
    }

    public static void moveZerosMap(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int j=0;

        for(int i =0; i < nums.length; i++){
            if(nums[i] != 0) {
                numsMap.put(i, nums[i]);
                j +=1;
            }

            int isZero = numsMap.getOrDefault(i,0);

            if (isZero == 0)
                numsMap.put(i,isZero);
        }

        for (Integer i : numsMap.values()) {
            System.out.println(i);
        }
    }
}
