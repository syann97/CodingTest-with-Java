import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int z;
    int dist;

    public Node(int x, int y, int z, int dist) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.dist = dist;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][][] map = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = tmp.charAt(j);
                map[0][i][j] = c;
                map[1][i][j] = c;
            }
        }

        System.out.println(bfs(map, N, M));


    }

    static int bfs(int[][][] map, int N, int M) {
        int ey = N-1;
        int ex = M-1;
        int[][][] visited = new int[2][N][M];

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0, 1));

        while (!q.isEmpty()) {
            Node node = q.pop();
            int x = node.x;
            int y = node.y;
            int z = node.z;
            int dist = node.dist;

            if (x == ex && y == ey) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    // z 가 0인 경우 돌파 가능
                    if (z == 0) {
                        if (map[0][ny][nx] == '1' && (visited[1][ny][nx] == 0 || dist + 1 < visited[1][ny][nx])) {
                            visited[1][ny][nx] = dist + 1;
                            q.offer(new Node(nx, ny, 1, dist + 1));
                        }
                    }
                    if (map[z][ny][nx] == '0' && (visited[z][ny][nx] == 0 || dist + 1 < visited[z][ny][nx])) {
                        visited[z][ny][nx] = dist + 1;
                        q.offer(new Node(nx, ny, z, dist + 1));
                    }
                }
            }
        }
        return -1;
    }

}