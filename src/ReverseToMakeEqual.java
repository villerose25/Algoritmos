import java.util.HashMap;
import java.util.Map;

public class ReverseToMakeEqual {
    public static void main (String[] args) {
        int[] arr_a = new int[]{1, 2, 3, 4};
        int[] arr_b = new int[]{1, 4, 3, 2};

        System.out.println("Are they equal?: " + areTheyEqual(arr_a, arr_b)); //190
    }

    static boolean areTheyEqual(int[] array_a, int[] array_b) {
        if(array_a.length != array_b.length)
            return false;

        Map<Integer, Integer> mapArray_a = new HashMap<>();

        // llenar mapa con el primer arreglo
        // [1, 2, 3, 4]
        for(Integer num : array_a) {
            int count = mapArray_a.getOrDefault(num, 0);

            mapArray_a.put(num, count+1);
        }
        // 1=1, 2=1, 3=1, 4=1

        // decrementar 1, 4, 3, 2
        for (Integer num : array_b) {
            int count = mapArray_a.getOrDefault(num, 0);

            // significa que est enumero no existe en el primer arreglo
            // por lo tanto ya no pueden ser iguales.
            if(count == 0)
                return false;

            mapArray_a.put(num, count-1);
        }

        return true;
    }
}
