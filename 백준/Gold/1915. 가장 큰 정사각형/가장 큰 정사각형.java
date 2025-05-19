import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[][] dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= M; j++) {
                if (tmp.charAt(j-1) - '0' == 0) continue;
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        System.out.println(answer * answer);
    }
}
