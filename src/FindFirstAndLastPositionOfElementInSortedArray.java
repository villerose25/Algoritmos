/*
    given an array of integers nums  sorted in ascending order
    Find the starting and ending position of a given target value.
    [10,11,11,11,14,15]

    TIME COMPLEXITY: O(LOG(N)) -> This is due the fact that the search is binary search
    SPACE COMPLEXITUY: O(1)
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(Integer[] nums, int target) {
        int left = getFirstPosition(nums, target);
        int right = getLastPosition(nums, target);

        return new int[]{left, right};
    }

    public static int getFirstPosition(Integer[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while(left <= right) {
            mid = (left + right)/2;
            if(nums[mid] == target){
                if(mid-1 >=0 && nums[mid-1] != target || mid ==0) //first time to see the target
                    return mid;
                right = mid - 1;
            } else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }

    public static int getLastPosition(Integer[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while(left <= right) {
            mid = (left + right)/2;
            if(nums[mid] == target){
                if(mid + 1 < nums.length && nums[mid+1] != target || mid == nums.length-1) //first time to see the target
                    return mid;
                left = mid + 1;
            } else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
}
