import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int K;
    static Queue<int[]> queue = new ArrayDeque<>();
    static int[] dx = {-1, 1, 0};
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queue.add(new int[]{N, 1});
        System.out.println(bfs());
    }

    static int bfs() {
        visited[N] = 1;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int t = tmp[1];

            if (x == K) {
                return t-1;
            }

            dx[2] = x;
            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i];
                if (0 <= nx && nx <= 100000 && visited[nx] == 0) {
                    visited[nx] = t+1;
                    queue.add(new int[]{nx, t+1});
                }
            }
        }
        return -1;
    }
}
