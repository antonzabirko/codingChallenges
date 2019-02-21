package isUnique;

import java.util.HashMap;

public class isUnique {
    public static boolean isUnique(String str) {
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

        // O(n) runtime
        for (int i = 0; i < str.length(); i++) {
            Character currentChar = str.charAt(i);
            if (!charMap.containsKey(currentChar)) {
                charMap.put(currentChar, 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isUniqueNoStructures(String str) {

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("Hello"));
    }
}
