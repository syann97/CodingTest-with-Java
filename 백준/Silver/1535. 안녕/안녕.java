import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] hp = new int[N];
        int[] happy = new int[N];
        int[] dp = new int[100];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int damage = hp[i];
            for (int j = 99; j >= damage; j--) {
                dp[j] = Math.max(dp[j], dp[j - damage] + happy[i]);
            }
        }

        System.out.println(dp[99]);
    }
}