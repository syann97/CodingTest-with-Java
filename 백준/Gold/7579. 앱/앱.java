import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] c = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int total_cost = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            total_cost += c[i];
        }

        int[] dp = new int[total_cost + 1];


        for (int i = 0; i < N; i++) {
            for (int j = total_cost; j >= c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-c[i]] + A[i]);
            }
        }

        for (int i = 0; i <= total_cost; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}
