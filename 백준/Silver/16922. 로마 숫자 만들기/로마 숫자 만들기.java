import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    static int N;
    static int answer = 0;
    static boolean[][] visited;
    static int[] nums = {50, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1][50 * N + 1];
        bt(0, 0);
        System.out.println(answer);
    }

    static void bt(int n, int sum) {
        if (n == N) {
            if (!visited[n][sum]) {
                visited[n][sum] = true;
                answer++;
            }
            return;
        }
        
        if (!visited[n][sum]) {
            visited[n][sum] = true;
            for (int i = 0; i < 4; i++) {
                int next = sum + nums[i];
                if (!visited[n+1][next]) {
                    bt(n+1, next);
                }
            }
        }
    }
}
