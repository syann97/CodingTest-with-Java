import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] answer = {3, 7};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        if (N < 3) {
            System.out.println(answer[N-1]);
        }
        else {
            dp[0] = 3;
            dp[1] = 7;
            for (int i = 2; i < N; i++) {
                dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901;
            }
            System.out.println(dp[N-1]);
        }
    }
}
