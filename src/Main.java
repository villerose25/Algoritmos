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
        values = new Integer[]{1,2,2,3,4,4,4,4};// T 4 -> #answer [4,7]
        int target = 4;
        System.out.println(Arrays.toString(FindFirstAndLastPositionOfElementInSortedArray.searchRange(values, target)));
    }

    private static void validMountainInArray(){
        Integer[] values = new Integer[]{1,1,2,3,1};
        System.out.println(ValidMountainInArray.validMountainArray(values));
    }


}
