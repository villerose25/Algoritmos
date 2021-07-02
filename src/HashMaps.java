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

    /* TIME O(N`2)
     SPACE: O(N)
    Given four lists A,B,C,D of integer values
    compute how many tuples (i,j,k,l) there are such that
    A[i] + B[j] + C[k] + D[l} is zero
    Want to count the number of opposite pairs
    1. Encontrar el par que sumen hasta un numero X en los arreglos A y B
    2. Encontrar el par de numeros en los otros 2 arreglos que sumen hasta -x
     */
    public static int fourSumcOUNT(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> m = new HashMap<>();
        int ans = 0;
        int sA = A.length;
        int sB = B.length;
        int sC = C.length;
        int sD = D.length;

        for (int i = 0; i < sA; i++) {
            int x = A[i];
            for (int j = 0; j < sB; j++) {
                int y = B[j];

                // first time that we seen the sumation result
                int count = m.getOrDefault(x + y, 0);
                m.put(x + y, count + 1);

            }
        }

        // second for
        for (int i =0; i < sC; i++) {
            int x=C[i];
            for (int j =0; j < sD; j++){
                int y = D[j];
                int target = -(x+y);

                if(m.containsKey(target))
                    ans += m.get(target) ;
            }
        }

        return  ans;
    }


    /*
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T
    s = "ADOBECODEBANCC" T="ABC"
    output BANC
     */
    public static String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = s.length();
        //
        if(len2 < len1)
            return "";

        Map<Character, Integer> hashPat = new HashMap<>();
        Map<Character, Integer> hashStr = new HashMap<>();

        for(int i = 0; i < len2; i++) {
            int count  = hashPat.getOrDefault(t.charAt(i), 0);
            hashPat.put(t.charAt(i), count + 1);
        }

        // initialize 4 variables
        int count = 0;
        int left = 0;
        int startIndex = -1; //initialize the current window
        float minLen = Float.POSITIVE_INFINITY;// minimum length of substring that contains the pattern
        int windowLen;
        for(int right = 0; right < len1; right++) {
            int countRight = hashStr.getOrDefault(s.charAt(right),0);
            hashStr.put(s.charAt(right), countRight +1);

            if(!hashPat.containsKey(s.charAt(right)))
                hashPat.put(s.charAt(right), 0);

            if(hashStr.get(s.charAt(right)) <= hashPat.get(s.charAt(right))) {
                count +=1; //the element occurs more than one in the string
            }

            // check if the count is currently equal  to the length of the pattern
            if(count == len2) {
                while(hashStr.get(s.charAt(left)) > hashPat.get(s.charAt(left))) {
                    // decrement the number of ocurances
                    hashStr.put(s.charAt(left), hashStr.get(s.charAt(left))-1);
                    left +=1;
                }
            }

            windowLen = right - left +1;
            if(minLen > windowLen){
                minLen = windowLen;
                startIndex = left;
            }
        }

        if(startIndex == -1)
            return  "";
        return s.substring(startIndex, startIndex +  (int)minLen);
    }
}
