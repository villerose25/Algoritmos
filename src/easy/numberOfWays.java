package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class numberOfWays {

    public static int numberOfWays(int[] arr, int k) {

        Map<Integer, Integer> mOriginal = new HashMap<Integer,Integer>();
        Map<Integer, Integer> mFaltante = new HashMap<Integer,Integer>();
        List<Integer> arrList = new ArrayList<>();
        int pairs = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int faltante = k-arr[i];
            // llenar 2 mapas con el numero de veces que se encuentra el arr[i] y faltante
            int count = mFaltante.getOrDefault(faltante,0);
            mFaltante.put(arr[i], count+1);

            count = mOriginal.getOrDefault(arr[i], 0);

            mOriginal.put(arr[i], count + 1);

        }

        for(int i = 0; i< n; i++) {

        }
        for(Map.Entry<Integer, Integer> entry : mOriginal.entrySet()) {
            int faltante = k - entry.getKey();
            if(mOriginal.containsKey(faltante))
            {
                int count = mOriginal.get(faltante);
                pairs = pairs + count;
            }
        }



        return pairs/2;
    }
}
