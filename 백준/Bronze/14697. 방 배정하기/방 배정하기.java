import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] rooms = new int[3];
        for (int i = 0; i < 3; i++) {
            rooms[i] = Integer.parseInt(st.nextToken());
        }
        int N = Integer.parseInt(st.nextToken());
        System.out.println(dp(rooms, N));
    }

    static int dp (int[] rooms, int N) {
        boolean[] dp = new boolean[N+1];
        dp[0] = true;

        for (int room : rooms) {
            for (int j = room; j <= N; j++) {
                if (dp[j - room]) dp[j] = true;
            }
        }

        return dp[N] ? 1 : 0;
    }
}
