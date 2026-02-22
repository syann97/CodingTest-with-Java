import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];

        int I, T;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            I = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            if (T <= N) {
                for (int i = N; i >= T; i--) {
                    dp[i] = Math.max(dp[i - T] + I, dp[i]);
                }
            }
        }

        System.out.println(dp[N]);
    }
}