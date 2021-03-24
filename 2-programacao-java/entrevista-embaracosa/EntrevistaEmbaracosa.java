import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class EmbarrassingInterview {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nextWord;

        while ((nextWord = br.readLine()) != null) {
            boolean findRepetition = false;
            for (int i = 0; i <= nextWord.length() - 1; i++) {
                if (nextWord.substring(0, i).endsWith(nextWord.substring(i))) {
                    System.out.println(nextWord.substring(0, i));
                    findRepetition = true;
                }
            }
            if (!findRepetition) {
                System.out.println(nextWord);
            }
        }
    }
}