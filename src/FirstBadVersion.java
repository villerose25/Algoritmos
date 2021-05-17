/*
    TIME COMPLEXITY:
    SPACE COMPLEXITY:
Give a number N that represent amount of version and a function that accepts
a number and returns wether it's a bad version or not. Find the first bad version of the array
1. Find the mid between the 2 pointers
2. NOTE if a version is bad, all versions after it are bad.
3. if mid is a bad version, set end to mid

EXAMPLE.
N: 6 First bad Version:3
    start = 1
    End = 6
    Mid = (1+6)/2=3

// answer = 10;
 */
public class FirstBadVersion {
    // if Mid is not a bad version, set start to mid+1
    public static int firstBadVersion(int n) {
        int left = 1; //first version
        int right = n; // last version
        int mid;

        while(left<right) {
            mid = (right + left) / 2;
            if (!isBadVersion(mid)) //all after bad
                left = mid+1; //bad becomes after mid
            else
                right = mid; //mid is bad version we do not care what comes next
        }
        return left;
    }

    public static boolean isBadVersion(int version) {
        int first_bad_version = 3;
        return version >= first_bad_version;
    }
}
