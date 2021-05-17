import java.util.ArrayList;
import java.util.Arrays;

public class BoatsToSavePeople {

    /*
    TIME COMPLEXITY
    O(N Log(N))
    El loopong es O(N)

    SPACE COMPLEXITY: O(N)
    Esto es por el sorting que internamente usa O(N)
    variables
    people
    limit
    boats
    limit = 4
    1. sort el array [1,2,3] --> 2 botes --> O(NLOG(N))
        bote 1 -> 1,3
        bote 2 -> solo el 2
    2. poner el mas liviano y el mas pesado
    3. mover izquierda y derechas

    Ejemplo 2. [1,2,3,3]
    Limite 3
    bote 1 => 1+3 es mas grande que el limite -> bote par el 3
    bote 2 => mismo caso -> bote pare el segundo 3
    bote 3 => 1,2 -> es igual al limite -> se van juntos en el bote

    Luego el final excede el pointer inicial
     */
    public static void main(String args[]) {
       Integer[] people = new Integer[]{1,2,3,3};
       int limit = 3;

        System.out.println("Numero de botes: " + numRescueBoats(people, limit));

    }

    public static Integer numRescueBoats(Integer[]people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats_number = 0;
        while(left <= right) {
            if(left == right) { //pointing same person
                boats_number += 1;
                break;
            }

            // poner 2 personas en un bote
            if(people[left] + people[right] <= limit)
                left += 1;

            right -= 1;
            boats_number += 1;
        }

        return  boats_number;
    }
}
