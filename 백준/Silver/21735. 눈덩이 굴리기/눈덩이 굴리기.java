import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] snows = new int[N+3];

        for (int i = 1; i <= N; i++) {
            snows[i] = Integer.parseInt(st.nextToken());
        }

        bt(0, 0, 1, N, M, snows);
        System.out.println(answer);
    }


    static void bt(int now, int time, int size, int N, int M, int[] snows) {
        if (now >= N || time == M) {
            answer = Math.max(answer, size);
            return;
        }

        bt(now + 1, time + 1, size + snows[now + 1], N, M, snows);
        bt(now + 2, time + 1, (size / 2) + snows[now + 2], N, M, snows);
    }
}