import java.util.Arrays;

import easy.CountPrimes;
import easy.HashMaps;
import easy.MissingNumber;

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


        int[] valuesInt = new int[]{0,3,1,2,5};
        //System.out.println(MissingNumber.missingNumber(valuesInt));

        //primos del 12 es 5
        //primos del 34 es 11
        //System.out.println("primes count: " + CountPrimes.countPrimes(34)); //5

        valuesInt = new int[]{3,2,1,5};
        valuesInt = new int[]{1,2,1,3};
        //System.out.println("primes count: " + Arrays.toString(HashMaps.twoSums(valuesInt, 8))); //[0,3]
        //System.out.println("contains duplicate: " + HashMaps.containsDuplicate(valuesInt)); //[0,3]

        valuesInt = new int[]{3,2,3,2,1,2};
        System.out.println("Mayor occurrences: " + HashMaps.majorityElement(valuesInt)); //1

        String[] arr = new String[]{"tan","tac", "ant", "cat", "act", "bat"};
        System.out.println("Get grouped anagrams+ " + HashMaps.groupAnagrams(arr));
    }

    private static void validMountainInArray(){
        Integer[] values = new Integer[]{1,1,2,3,1};
        System.out.println(ValidMountainInArray.validMountainArray(values));
    }


}
