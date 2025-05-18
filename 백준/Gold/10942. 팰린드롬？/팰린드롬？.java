import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N+1];
        int[][] dp = new int[N+1][N+1];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int end = 1; end <= N; end++) {
            dp[end][end] = 1;
            for (int start = end - 1; start >= 1; start--) {
                int length = end - start + 1;
                if (length == 2) dp[start][end] = numbers[start] == numbers[end] ? 1 : 0;
                else dp[start][end] = numbers[start] == numbers[end] && dp[start+1][end-1] == 1 ? 1 : 0 ;
            }
        }

        int M = Integer.parseInt(br.readLine());

        while (M --> 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start][end]).append("\n");
        }
        System.out.print(sb);
    }
}
