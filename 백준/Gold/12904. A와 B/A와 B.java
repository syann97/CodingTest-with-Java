import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static int L;
    static char[] word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        L = S.length();
        word = br.readLine().toCharArray();

        System.out.println(greedy(0, word.length - 1, false));
    }

    private static String greedy(int start, int end, boolean isReverse) {
        if (Math.abs(end - start) + 1 == L) {
            StringBuilder tmp = new StringBuilder();
            String result;

            if (isReverse) tmp.append(new String(word, end, L)).reverse();
            else tmp.append(new String(word, start, L));

            result = tmp.toString();

            return S.equals(result) ? "1" : "0";
        }

        if (word[end] == 'A') {
            if (isReverse) return greedy(start, end + 1, true);
            else return greedy(start, end - 1, false);
        }
        else {
            if (isReverse) return greedy(end + 1, start, !isReverse);
            else return greedy(end - 1, start, !isReverse);
        }
    }
}