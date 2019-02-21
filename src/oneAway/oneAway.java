package oneAway;

public class oneAway {
    public static boolean oneAway(String s, String t) {
        // Do 3 checks sequentially.
        // Should be O(n) runtime.
        // Implemented with two hash maps. This creates a high space complexity.
        if (s.length() == t.length()) {
            // Check replacement
            return isReplaceable(s, t);
        } else if (Math.abs(s.length() - t.length()) == 1) {
            // Difference between the two strings is 1 character
            // Here we check both insertion and removal
            return isSingleDifference(s, t);
        }
        return false;
    }

    public static boolean isReplaceable(String s, String t) {
        // We're going to assume that the difference from "HI" to "HI" is one away through infinite ways.
        boolean differenceFlag = true;

        // We know that the length of both strings is the same, so we can use one loop.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                differenceFlag = true;
                if (differenceFlag) {
                    differenceFlag = false;
                }
            }
        }
        return differenceFlag;
    }

    public static boolean isSingleDifference(String a, String b) {
        // We have to iterate over the smaller string and make sure that the strings are identical aside from
        // one character.
        int iA = 0, iB = 0;
        boolean failFlag = false;

        while (iA < a.length() && iB < b.length()) {
            if (a.charAt(iA) != b.charAt(iB)) {
                if (iA != iB) {
                    return false;
                } else {
                    failFlag = true;
                    iB++;
                }
            } else {
                iA++;
                iB++;
            }
        }
        return !failFlag;
    }

    public static void main(String[] args) {
        System.out.println(oneAway("Hello", "Hebl"));
        System.out.println(oneAway("Hello", "Hello"));
        System.out.println(oneAway("Hello", "Hell"));
        System.out.println(oneAway("Hello", "Hel"));
    }
}
