public class ValidMountainInArray {

    /*
      O(N) time
      O(1) space
     */
    public static boolean validMountainArray(Integer[] A) {
        if(A.length < 3)
            return false;

        int i =1;
        while (i < A.length && A[i] > A[i - 1])
            i +=1;

        if( i == 1 || i == A.length)
            return false;

        while (i < A.length && A[i] < A[i - 1])
            i +=1;

        return 1 == A.length;
    }

}
