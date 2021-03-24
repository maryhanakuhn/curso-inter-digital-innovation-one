import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FindGreaterSubstring {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String string1, string2, minimum, maximum;
        while ((string1 = in.readLine()) != null) {
            string2 = in.readLine();
            if (string1.length() > string2.length()) {
                maximum = string1;
                minimum = string2;
            } else {
                maximum = string2;
                minimum = string1;
            }
            int minimumLength = minimum.length();
            int maximumS = minimumLength;
            boolean f = true;
            while (maximumS > 0 && f) {
                int diff = minimumLength - maximumS;
                for (int i = 0; i <= diff; i++) {
                    if (maximum.contains(minimum.substring(i, i + maximumS))) {
                        f = false;
                        maximumS++;
                        break;
                    }
                }
                maximumS--;
            }
            System.out.println(maximumS);
        }
        out.close();
    }
}
