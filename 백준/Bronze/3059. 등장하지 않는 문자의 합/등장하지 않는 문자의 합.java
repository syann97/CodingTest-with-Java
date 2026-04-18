import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            boolean[] alphabet = new boolean[26];
            for (char c : br.readLine().toCharArray()) {
                alphabet[c - 65] = true;
            }

            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (!alphabet[i]) count += 65 + i;
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
