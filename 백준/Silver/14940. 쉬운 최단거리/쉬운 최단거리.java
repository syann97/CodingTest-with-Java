import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static StringTokenizer st;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int ey = 0;
        int ex = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    ey = i;
                    ex = j;
                }
                else if (map[i][j] == 1) map[i][j] = -1;
            }
        }
        dfs(map, ey, ex);
    }

    static void dfs(int[][] map, int ey, int ex) {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};
        ArrayDeque<Node> q = new ArrayDeque<>();
        map[ey][ex] = 0;
        q.offer(new Node(ey, ex));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                if (0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] != 0 && map[ny][nx] == -1) {
                    map[ny][nx] = map[node.y][node.x] + 1;
                    q.offer(new Node(ny, nx));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
