import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int K;
    static int answer;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] kits = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }
        bt(kits, new boolean[N], 500, 0);
        System.out.println(answer);
    }

    static void bt(int[] kits, boolean[] visited, int weight, int count) {
        if (weight < 500) return;
        if (count == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bt(kits, visited, weight + kits[i] - K, count + 1);
                visited[i] = false;
            }
        }
    }
}