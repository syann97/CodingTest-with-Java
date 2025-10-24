import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[] word = br.readLine().toCharArray();

        for (int i = 0; i < N / 2; i++) {
            int j = N - 1 - i;

            if (word[i] == '?' && word[j] == '?') {
                word[i] = 'a';
                word[j] = 'a';
            }

            else {
                if (word[i] != '?') word[j] = word[i];
                else word[i] = word[j];
            }
        }

        if (N % 2 == 1 && word[N/2] == '?') word[N/2] = 'a';
        for (char c : word) sb.append(c);

        System.out.println(sb);
    }
}