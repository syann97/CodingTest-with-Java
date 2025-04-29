import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Node {
    int y;
    int x;
    int count;

    public Node(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}

public class Main {
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 도시 개수
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        System.out.println(bfs(map));
    }

    static int bfs(char[][] map) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '1') {
                    q.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int max = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            max = Math.max(max, node.count);

            for (int d = 0; d < 8; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new Node(ny, nx, node.count + 1));
                }
            }
        }
        return max;
    }
}