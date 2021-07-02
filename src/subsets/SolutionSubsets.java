package subsets;

import java.util.*;

public class SolutionSubsets {

    static void SolutionSubsets(int[] nums, List<Set<Integer>> ans, Set<Integer> cur, int index) {
        if(index >= nums.length)
            return;

        ans.add(cur);
        System.out.println(Arrays.toString(ans.toArray()));

        for(int i = index; i < nums.length; i++) {
            if(!cur.contains(nums[i])){
                cur.add(nums[i]);
                SolutionSubsets(nums,ans,cur,i);
                cur.remove(0);
            }
        }
    }

    static public void subsets(int[] nums) {
        // cur will have the elements that are currently appended
        List<Set<Integer>> ans = new ArrayList<Set<Integer>>();
        Set<Integer> cur = new HashSet<Integer>();
        SolutionSubsets(nums,ans,cur,0);

        for(Set<Integer> l : ans) {
            System.out.println(Arrays.toString(l.toArray()));
            String arr = Arrays.toString(l.toArray());
        }
    }

    public static void main(String[] args){
        int[] n = new int[]{1,2};

        subsets(n);


    }
}
