import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] isPossible = new boolean[26];
    static char[] changeAlphabet = new char[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        isPossible[1] = true;
        changeAlphabet[1] = 'd';

        isPossible[3] = true;
        changeAlphabet[3] = 'b';

        isPossible[15] = true;
        changeAlphabet[15] = 'q';

        isPossible[16] = true;
        changeAlphabet[16] = 'p';

        isPossible[8] = true;
        changeAlphabet[8] = 'i';

        isPossible[14] = true;
        changeAlphabet[14] = 'o';

        isPossible[21] = true;
        changeAlphabet[21] = 'v';

        isPossible[22] = true;
        changeAlphabet[22] = 'w';

        isPossible[23] = true;
        changeAlphabet[23] = 'x';

        StringBuilder tmp = new StringBuilder();
        boolean flag = false;

        while (true) {
            String s = br.readLine();
            if (s.equals("#")) break;


            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);

                if (!isPossible[c - 97]) {
                    flag = true;
                    break;
                }

                tmp.append(changeAlphabet[c - 97]);
            }

            if (!flag) {
                sb.append(tmp).append("\n");
            }
            else {
                sb.append("INVALID").append("\n");
                flag = false;
            }
            tmp.setLength(0);
        }

        System.out.println(sb);
    }
}
