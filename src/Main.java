import easy.ContiguousSubarrays;
import easy.numberOfWays;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {

        //validMountainInArray();

        Integer[] values = new Integer[]{1,8,6,2,5,4,8,3,7};
        //values = new Integer[]{2,1,1,2};
        //System.out.println(ContainerWithMostWater.maxArea(values));

        //Integer answer = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("fivestarreview");
        //System.out.println(answer);

        //values = new Integer[]{10,11,11,11,14,15}; //1,3
        //values = new Integer[]{1,2,2,3,4,4,4,4};// T 4 -> #answer [4,7]
        //int target = 4;
        //System.out.println(Arrays.toString(FindFirstAndLastPositionOfElementInSortedArray.searchRange(values, target)));


        //int[] valuesInt = new int[]{0,3,1,2,5};
        //System.out.println(MissingNumber.missingNumber(valuesInt));

        //primos del 12 es 5
        //primos del 34 es 11
        //System.out.println("primes count: " + CountPrimes.countPrimes(34)); //5

        //valuesInt = new int[]{3,2,1,5};
        //valuesInt = new int[]{1,2,1,3};
        //System.out.println("primes count: " + Arrays.toString(HashMaps.twoSums(valuesInt, 8))); //[0,3]
        //System.out.println("contains duplicate: " + HashMaps.containsDuplicate(valuesInt)); //[0,3]

       // valuesInt = new int[]{3,2,3,2,1,2};
        //System.out.println("Mayor occurrences: " + HashMaps.majorityElement(valuesInt)); //1

        //String[] arr = new String[]{"tan","tac", "ant", "cat", "act", "bat"};
        //System.out.println("Get grouped anagrams+ " + HashMaps.groupAnagrams(arr));

        //fourSumCount();
        //LRUCache();

        //contiguousArrays();
        numberOfWays();
    }

    private static void validMountainInArray(){
        Integer[] values = new Integer[]{1,1,2,3,1};
        System.out.println(ValidMountainInArray.validMountainArray(values));
    }

    public static void fourSumCount(){
        int[] A = new int[]{-1,1};
        int[] B = new int[]{1,-1};
        int[] C = new int[]{-2,2};
        int[] D = new int[]{2,-2};
        System.out.println(HashMaps.fourSumcOUNT(A,B,C,D));

    }

    public static void LRUCache() {

        LRUCache cache = new LRUCache(3);
        cache.putLRUCache(1,1000);
        cache.putLRUCache(2,2000);
        cache.putLRUCache(3,2000);
        //[1,2,3]
        System.out.println(cache.getLRUCache(1)); //10000
        //[2,3,1]
        cache.putLRUCache(4,4000);
        //least <= [3,1,4 => most]
        System.out.println(cache.getLRUCache(2)); //-1
        System.out.println(cache.getLRUCache(3)); //3000
        // [1,4,3]
    }

    private static void contiguousArrays(){
        ContiguousSubarrays c=new ContiguousSubarrays();
        int[] valuesInt = new int[]{3,4,1,6,2};
        System.out.println(Arrays.toString(c.countSubarrays2(valuesInt)));
    }

    private static void numberOfWays(){
        //int[] arr = new int[]{1,2,3,4,3};
        int[] arr = new int[] {1, 5, 3, 3, 3};
        int k = 6;
        System.out.println(numberOfWays.numberOfWays(arr, k));
    }
}
