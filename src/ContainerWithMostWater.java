public class ContainerWithMostWater {
    // move the pointer pointing at the smallest building
    /*
    Time complexity: O(N) -> we do a single pass over our container
    Space Complexity: )(1) We do a single pass over our container

    1,8,6,2,5,4,8,3,7
    l = 0
    r = input length -1
    1. -> 1 y 7 -> max(0,1*8) = 8
    2 -> 8,7 -> max(8, min(7,8) * (8-1)) ->49
        is 8 < 7? No
    3 -> 1,3 movemos el de la derecha
        max(49, min(3,8) *97-1) =  49
        si 8<3 No
     4. y asi continuamente.
        8,4
        8,5
        8,2
        8,6 -> 8 se sale
        ----------
        | -> se cae el agua
        _________
        |       |
        ----------
     */
    public static int maxArea(Integer[] height) {
        int maxarea = 0;
        int l = 0;
        int r = height.length - 1;

        while(l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r-l));
            if(height[l] < height[r])
                l+=1;
            else
                r-=1;
        }

        return maxarea;
    }
}
