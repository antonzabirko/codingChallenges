package isPalindromePermutation;

public class isPalindromePermutation {
    public static boolean isPalindromePermutation(String str) {
        // Seems to be an O(n) problem at best
        // Has to have an even number of non-space characters. You can have one odd number.
        // Assuming ASCII
        char[] letters = new char[128];
        boolean oddFlag = false;

        // Populate the char array with the count of letters
        for (char a : str.toCharArray()) {
            letters[a]++;
        }
        // Check that all chars are even except the spaces
        for (int x : letters) {
            if ((x % 2) != 0) {
                // If we have more than one odd, it cannot be structured as a palindrome.
                if (oddFlag) {
                    return false;
                }
                oddFlag = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("ali la"));
    }
}
