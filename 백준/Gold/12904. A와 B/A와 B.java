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

        System.out.println(greedy());
    }

    private static String greedy() {
        int N = word.length - L;
        int start = 0;
        int end = word.length - 1;
        boolean isReverse = false;

        while (N --> 0) {
            char lastChar;

            if (isReverse) {
                lastChar = word[start];
            } else {
                lastChar = word[end];
            }

            if (lastChar == 'A') {
                if (isReverse) {
                    start++;
                } else {
                    end--;
                }
            } else {
                if (isReverse) {
                    start++;
                } else {
                    end--;
                }
                isReverse = !isReverse;
            }
        }

        StringBuilder tmp = new StringBuilder();
        String result;

        if (isReverse) {
            tmp.append(new String(word, start, L)).reverse();
        } else {
            tmp.append(new String(word, start, L));
        }

        result = tmp.toString();

        return S.equals(result) ? "1" : "0";
    }
}
