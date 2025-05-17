import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Schedule {
    int T;
    int P;

    public Schedule (int T, int P) {
        this.T = T;
        this.P = P;
    }
}

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            
            int next = i + T;
            if (next <= N+1) dp[next] = Math.max(dp[next], dp[i] + P);
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }
        System.out.println(dp[N+1]);
    }
}
