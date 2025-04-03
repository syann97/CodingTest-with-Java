import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] towers = new int[N+1];
        int[] dp = new int[N+1];
        int best = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
            if (towers[i] > best) {
                best = towers[i];
                sb.append(0).append(' ');
                continue;
            }
            for (int j = i-1; j >= 0; j--) {
                if (towers[j] > towers[i]) {
                    dp[i] = j;
                    break;
                }
                if (dp[j] == 0) {
                    dp[i] = 0;
                    continue;
                }
                j = dp[j]+1;
            }
            sb.append(dp[i]).append(' ');
        }
        System.out.println(sb);
    }
}
