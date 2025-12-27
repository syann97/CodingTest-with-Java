import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("*")) break;

            boolean[] alphabet = new boolean[26];
            int count = 0;

            for (char c : s.toCharArray()) {
                if ('a' <= c && c <= 'z') {
                    if (!alphabet[c - 97]) {
                        alphabet[c - 97] = true;
                        count++;
                    }
                }
            }

            sb.append(count == 26 ? "Y" : "N").append("\n");
        }
        System.out.print(sb);
    }
}
