import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int dist;

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
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
        int[][] maze = new int[N][M];


        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = tmp.charAt(j);
            }
        }
        System.out.println(bfs(maze, N, M));
    }

    static int bfs(int[][] maze, int N, int M) {
        int ey = N-1;
        int ex = M-1;
        maze[0][0] = 0;

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node node = q.pop();
            int x = node.x;
            int y = node.y;

            if (x == ex && y == ey) {
                return node.dist + 1;
            }

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (0 <= ny && ny < N && 0 <= nx && nx < M && maze[ny][nx] == '1') {
                    maze[ny][nx] = '0';
                    q.offer(new Node(nx, ny, node.dist + 1));
                }
            }
        }
        return -1;
    }

}