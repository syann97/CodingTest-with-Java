import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] lights = new int[N];
        int[][] dp = new int[N][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], MAX);
        }

        int tmp;
        for (int end = 0; end < N; end++) {
            dp[end][end] = 0;
            for (int start = end - 1; start >= 0; start--) {
                for (int mid = start; mid < end; mid++) {
                    tmp = dp[start][mid] + dp[mid+1][end];
                    if (lights[start] != lights[mid+1]) tmp += 1;
                    dp[start][end] = Math.min(dp[start][end], tmp);
                }
            }
        }
        System.out.println(dp[0][N-1]);
    }
}