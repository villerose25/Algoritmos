/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.HashMap;

public class Anagrama {
    public static void main(String args[]) {
      //String word1 = "Listen";
      //String word2 = "silent";
      String searchWord = "hello";
      String targetWord = "ab";//"lol";

        if(anagrammedIndexOf(searchWord, targetWord) == -1)
            System.out.println("The word is not in any index.");
        else
            System.out.println("Index of anagram: " + anagrammedIndexOf(searchWord, targetWord));

     // if (isAnagram(word1, word2))
     //   System.out.println(word1 + " and " + word2 + " are anagrams");
     //else
     //   System.out.println(word1 + " and " + word2 + " are NOT anagrams");
    }
    
    public static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        
        HashMap<Character, Integer> cMap = new HashMap<Character, Integer>();
        
            // Iterar primer palabra y guardar en el mapa
        for (int i = 0; i < word1.length(); i++) {
            char c =  Character.toLowerCase(word1.charAt(i));
            int count = cMap.getOrDefault(c, 0);
            cMap.put(c, count + 1);
            int value = cMap.get(c);
            System.out.println("Key: " + c + " - Value: " + value);
        }
        
        for (int i = 0; i < word2.length(); i++) {
            char c = Character.toLowerCase(word2.charAt(i));
            int count = cMap.getOrDefault(c, 0);
            
            if(count == 0)
                return false; // no existe en el contexto actual
        
            cMap.put(c, count - 1);
            int value = cMap.get(c);
            System.out.println("Key: " + c + " - Value: " + value);
        }
        
        
        return true;
    }

    public static int anagrammedIndexOf(String search, String target) {
        // string original es menor que la busqueda
        if(search.length()<target.length())
            return -1;

        // inicializador del indice en search
        int i=0; // string original indice
        int size = target.length(); // busqueda de palabras

        //holltllo -> llo
        while((i + size) <= search.length()) {
            String subsWord = search.substring(i,i+size);

            if (isAnagram(subsWord, target))
                return i;

            i +=1;

        }
        return -1;
    }
}
