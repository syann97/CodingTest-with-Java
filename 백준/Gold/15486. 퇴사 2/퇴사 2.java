import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Schedule {
    int T;
    int P;

    public Schedule (int T, int P) {
        this.T = T;
        this.P = P;
    }
}

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Schedule[] schedules = new Schedule[N+1];
        int[] dp = new int[N+2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            schedules[i] = new Schedule(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if (i + schedules[i].T <= N+1) {
                dp[i + schedules[i].T] = Math.max(dp[i + schedules[i].T], dp[i] + schedules[i].P);
            }
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }
        System.out.println(dp[N+1]);
    }
}
