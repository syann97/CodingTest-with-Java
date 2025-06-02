import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static final int N = 10;
    static final int M = 2000;
    static long[][] dp = new long[N+1][M+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        for (int i = 1; i <= M; i++) dp[1][i] = i;

        for (int i = 2; i <= N; i++) {
            for (int j = (int)Math.pow(2, i-1); j <= M; j++) {
                dp[i][j] = dp[i-1][j/2] + dp[i][j-1];
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(dp[n][m]).append("\n");
        }
        System.out.println(sb);
    }
}
