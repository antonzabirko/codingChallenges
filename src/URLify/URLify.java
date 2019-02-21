package URLify;

public class URLify {
    // Best that comes to mind is O(n).
    public static String urlify(String s) {
        int length = s.length(),
            spaces = 0,
            outLength = 0,
            count = s.length() - 1;
        char[] url;

        // Count spaces first to create a char array large enough.
        // We need to allocate 3 locations for every 1 space location.
        for (char x : s.toCharArray()) {
            if (x == ' ') {
                spaces++;
            }
        }
        outLength = length + (spaces * 2);
        url = new char[outLength];
        //replace spaces
        for (int i = outLength - 1; i >= 0; i--) {
            if (s.charAt(count) == (' ')) {
                url[i] = '0';
                url[i - 1] = '2';
                url[i - 2] = '%';
                i -= 2;
            } else {
                url[i] = s.charAt(count);
            }
            count--;
        }
        return new String(url);
    }

    public static void main(String[] args) {
        System.out.println(urlify("Hello there - spaces are replaced with something."));
    }
}
