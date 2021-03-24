import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class AbbreviatingBlogPosts {

    protected static Map<String, Integer> wordOcurrences;
    protected static Map<Character, String> abbreviations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!".".equals((line = br.readLine()))) {
            StringTokenizer st = new StringTokenizer(line);
            wordOcurrences = new HashMap<>();
            abbreviations = new TreeMap<>();
            while (st.hasMoreTokens()) {
                String nextWord = st.nextToken();
                if (nextWord.length() <= 2) continue;
                wordOcurrences.put(nextWord, wordOcurrences.containsKey(nextWord) ? wordOcurrences.get(nextWord) + 1 : 1);
                abbreviations.put(nextWord.charAt(0), bestShortWord(nextWord));
            }
            printOutput(line);
        }
    }

    private static String bestShortWord(String nextWord) {
        if (!abbreviations.containsKey(nextWord.charAt(0))) {
            return nextWord;
        }
        int newCharacterReduction = wordOcurrences.get(nextWord) * (nextWord.length() - 2);
        String abbreviatedCurrent = abbreviations.get(nextWord.charAt(0));
        int reductionCurrentCharacters = wordOcurrences.get(abbreviatedCurrent) * (abbreviatedCurrent.length() - 2);
        return newCharacterReduction > reductionCurrentCharacters ? nextWord : abbreviatedCurrent;
    }

    private static void printOutput(String line) {
        List<String> abbreviationsList = new ArrayList<>();
        for (Character c : abbreviations.keySet()) {
            String palavraAbreviada = abbreviations.get(c);
            line = line.replaceAll("\\b" + palavraAbreviada + "\\b", " " + c + ". ");
            abbreviationsList.add(c + ". = " + palavraAbreviada);
        }

        System.out.println(line.trim());
        System.out.println(abbreviationsList.size());
        abbreviationsList.forEach(System.out::println);
    }
}