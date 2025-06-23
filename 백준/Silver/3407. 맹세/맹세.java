import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<String> elements = new HashSet<>(Arrays.asList(
            "h", "he", "li", "be", "b", "c", "n", "o", "f",
            "ne", "na", "mg", "al", "si", "p", "s", "cl", "ar",
            "k", "ca", "sc", "ti", "v", "cr", "mn", "fe", "co",
            "ni", "cu", "zn", "ga", "ge", "as", "se", "br", "kr",
            "rb", "sr", "y", "zr", "nb", "mo", "tc", "ru", "rh",
            "pd", "ag", "cd", "in", "sn", "sb", "te", "i", "xe",
            "cs", "ba", "hf", "ta", "w", "re", "os", "ir", "pt",
            "au", "hg", "tl", "pb", "bi", "po", "at", "rn",
            "fr", "ra", "rf", "db", "sg", "bh", "hs", "mt", "ds",
            "rg", "cn", "fl", "lv", "la", "ce", "pr", "nd",
            "pm", "sm", "eu", "gd", "tb", "dy", "ho", "er", "tm",
            "yb", "lu", "ac", "th", "pa", "u", "np", "pu", "am",
            "cm", "bk", "cf", "es", "fm", "md", "no", "lr"
    ));


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            System.out.println(bt(0, s.length(), s, new boolean[s.length()]) ? "YES" : "NO");
        }
    }


    static boolean bt(int i, int L, String s, boolean[] dp) {
        if (i == L) {
            return true;
        }


        if (dp[i]) return false;
        dp[i] = true;


        if (i + 1 <= L && elements.contains(s.substring(i, i + 1))) {
            if (bt(i + 1, L, s, dp)) {
                return true;
            }
        }

        if (i + 2 <= L && elements.contains(s.substring(i, i + 2))) {
            if (bt(i + 2, L, s, dp)) {
                return true;
            }
        }

        return false;
    }
}