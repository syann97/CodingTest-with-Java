import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        int count = 0;
        boolean[] isEaten = new boolean[N];

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == 'H') {
                int start = Math.max(0, i - K);
                int end = Math.min(N-1, i + K);

                for (int j = start; j <= end; j++) {
                    if (s.charAt(j) == 'P' && !isEaten[j]) {
                        count++;
                        isEaten[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
