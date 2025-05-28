import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue; // 도달 불가능한 상태는 생략

            for (int j = 1; j <= 3 && i + j <= N; j++) {
                String substring = s.substring(i, i + j);
                if (isValid(substring)) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }
        System.out.println(dp[N]);
    }


    static boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        return 1 <= num && num <= 641;
    }
}
