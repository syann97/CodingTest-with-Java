import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[100001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int client = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= 100000 - cost; j++) {
                dp[j+cost] = Math.max(dp[j+cost], dp[j] + client);
            }
        }
        System.out.println(printAnswer(dp, C));
    }

    static int printAnswer(int[] dp, int C) {
        for (int i = 1; i <= 100000; i++) {
            if (dp[i] >= C) {
                return i;
            }
        }
        return -1;
    }
}