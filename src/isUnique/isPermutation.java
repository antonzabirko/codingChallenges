package isUnique;

import java.util.HashMap;

public class isPermutation {

    // Space-expensive
    // Runtime: O(n)
    public static boolean isPermutation(String strA, String strB) {
        HashMap<Character, Integer> charMapA = new HashMap<Character, Integer>(),
                                    charMapB = new HashMap<Character, Integer>();
        int length = strA.replaceAll("\\s", "").length(),
            _largestMapSize;

        // Strings must be the same length, or they are not permutations.
        if (length != strB.replaceAll("\\s", "").length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            Character _currentCharA = strA.charAt(i),
                      _currentCharB = strB.charAt(i);

            if (charMapA.containsKey(_currentCharA)) {
                charMapA.put(_currentCharA, charMapA.get(_currentCharA) + 1);
                charMapB.put(_currentCharB, charMapB.get(_currentCharB) + 1);
            } else {
                charMapA.put(_currentCharA, 1);
                charMapB.put(_currentCharB, 1);
            }
        }
        for (int i = 0; i < strA.length(); i++) {
            Character currentChar = strA.charAt(i);

            if (!charMapA.get(currentChar).equals(charMapB.get(currentChar))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutationOptimized(String s, String t) {
        char[] chars = s.toCharArray();
        int[] letters = new int[128]; // Here we will store letters - of which ASCII has 128. ASCII is assumed.

        // Optimization trick for uneven lengths
        if (s.length() != t.length()) {
            return false;
        }

        for (char x : chars) {
            letters[x]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char letter = t.charAt(i);
            if (letters[letter] > 0) {
                letters[letter]--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(isPermutation("Hello", "sHllo"));
        System.out.println(isPermutationOptimized("Hello", "eHllo"));
    }
}
