package compressString;

public class compressString {
    // O(n)
    public static String compressString(String s) {
        char temp = s.charAt(0),
             prevTemp = ' ';
        int run = 0;
        StringBuilder output = new StringBuilder("");

        // Find a run
        for (int i = 0; i < s.length(); i++) {
            run++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                output.append(s.charAt(i)).append(run);
                run = 0;
            }
        }
        return (s.length() >= output.length()) ? output.toString() : s;
    }

    public static void main(String[] args) {
        System.out.println(compressString("aaaaaaaaaaaaabbbbsdssssscccccfdddddiwdfcv"));
    }
}
