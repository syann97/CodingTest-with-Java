import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] kits = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bt(kits, new boolean[N], 500, 0));
    }

    static int bt(int[] kits, boolean[] visited, int weight, int count) {
        if (count == N) return 1;

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int nextWeight = weight + kits[i] - K;
                if (nextWeight >= 500) {
                    visited[i] = true;
                    answer += bt(kits, visited, nextWeight, count + 1);
                    visited[i] = false;
                }
            }
        }
        return answer;
    }
}