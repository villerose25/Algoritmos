package easy;

import java.util.*;

/* Given an array of integers and an integer target
    return indices of 2 numbers in the array that add up to the target number

    arr1[3,6,12,14] -> target is 15 --> indices 0,2

    x+y = target
    y -> current number
    x -> target - y

    Time complexity: O(n) we do a loop over an array of size N
    SPACE COMPLEXITY: O(N) We create a map to hold the value alongside it's index
 */
public class HashMaps {

    public static int[] twoSums(int[] arr, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int n = arr.length;

        for(int i =0; i< n; i ++){
            //goal es el segundo digito a buscar
            int goal = target - arr[i];
            if(m.containsKey(goal)) //si el numero 2 existe en el mapa?
                return new int[] {m.get(goal), i};
            m.put(arr[i], i);
        }
        return new int[]{-1,-1};
    }

    /*
    TIME COMPLEXITY: O(N) Only single loop
    SPACE COMPLEXITY: we have a map tht  hosts all elements
    Verify if an array contains duplicates
    -loop the array
    - for every num in input array,
        if map contains num
            return true;
        m[num] = 1
     */
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer,Integer>();

        for(int i = 0; i<nums.length; i++) {
            if (m.containsKey(nums[i]))
                return true;
            m.put(nums[i], nums[i]);
        }
        return false;
    }

    /*
    given an array of intengers of size N, find the majority element of the array
    A majority element appears more than n/2 times
    (n is the array size)
    [1,2,3,1,1] -> 1 because occurred 3 times

    TIME COMPLEXITY: O(2*N) -> O(N)-> 2 FORS
    SPACE COMPLEXITY: O(N) -> One map
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        // poner las veces que existe un elemento en el array
        for (int n : nums)
            m.put(n, m.getOrDefault(n,0) +1);

        // to check if current element is bigger than size/2
        int mayorValue=0;
        int mayorNum = -1;
        for(int n : nums) {
            if (m.get(n) > nums.length / 2)
                return n; // el que mas ocurrencias tiene
            else{
                if(mayorValue < m.get(n)) {
                    mayorValue = m.get(n);
                    mayorNum = n;
                }
            }
        }
        return mayorNum;
    }

    /*
        MEDIUM Given an array of strings, group anagrams together

    examples
    ["eat", "tea", "tan", "ate", "nat", "bat" ]

    output
    [
        ["ate", "eat", "tea"],
        ["nat", "tan"],
        ["bat"]
    ]

    TIME COMPLEXITY: O(N*M*Log(M)) ->
        N: length of the input array
        M: length of biggest string in the array
        M*Log(M) is due the fact that we sort each string
    SPACE COMPLEXITY:
    1. cREATE a hashmap of pair <String, Array>
    2. loop over the strings
    3. find the sorted version of current string, "hashed"
        key     Value
        [aet]   [eat, tea, ate]
        [ant]   [tan, nat]
        [abt]   [bat]
    4. append the current string to the array of hashed in our map
    answers = []
    hashMap = {}

    for every s in input
        hashed = findHash(s) #sorted version of s
        hashMap[hashed].append(s)

     for every value in hashMap.values
        answers.append(p)
    * */
    public static String groupAnagrams(String[] strs) {
        Map<String, String> m = new HashMap<>();
        String answers = "";

        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            // sorted list
            String hashed = Arrays.toString(c).replaceAll(",", "");
            //if hashed is not in the map already
            if(!m.containsKey(hashed)) {
                m.put(hashed, "");
            }
            String append = m.get(hashed) + "," + s;


            m.put(hashed, append);
        }

        String grouped = "";
        for (Map.Entry<String,String> p : m.entrySet()) {
            grouped = grouped + "[" + p.getValue().substring(1) + "]";
        }

        return grouped + "";
    }
}
