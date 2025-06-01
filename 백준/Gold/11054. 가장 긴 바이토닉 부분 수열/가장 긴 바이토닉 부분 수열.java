import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // LIS + LDS
        int[] increase_dp = new int[N];
        int[] decrease_dp = new int[N];

        // 1로 변경
        Arrays.fill(increase_dp, 1);
        Arrays.fill(decrease_dp, 1);

        // LIS
        for (int i = 1;  i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) increase_dp[i] = Math.max(increase_dp[i], increase_dp[j] + 1);
            }
        }


        // LDS (뒤에서부터 보는 것이 핵심)
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    decrease_dp[i] = Math.max(decrease_dp[i], decrease_dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, increase_dp[i] + decrease_dp[i]);
        }
        System.out.println(max - 1);
    }
}
