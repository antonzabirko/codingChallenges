package compressString;

public class compressString {
    public static String compressString(String s) {
        char temp = s.charAt(0);
        int run = 1;
        StringBuilder output = new StringBuilder("");

        // Find a run
        for (char x : s.toCharArray()) {
            System.out.println(run + " " + temp + " " + x);
            if (temp == x) {
                run++;
            } else {
                System.out.println(output.append(x).append(run));
                run = 1;
            }
            temp = x;
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aaabbbbccc"));
    }
}
