import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Node {
    int z;
    int y;
    int x;
    int dist;
    public Node (int z, int y, int x, int dist) {
        this.z = z;
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}

public class Main {
    static StringTokenizer st;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        System.out.println(bfs(N, M, K, board));

    }

    private static int bfs(int N, int M, int K, char[][] board) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0, 0));
        boolean[][][] visited = new boolean[K+1][N][M];
        visited[0][0][0] = true;

        int ey = N-1;
        int ex = M-1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int z = node.z;
            int y = node.y;
            int x = node.x;
            int dist = node.dist;

            if (y == ey && x == ex) return dist + 1;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (!visited[z][ny][nx] && board[ny][nx] == '0') {
                        visited[z][ny][nx] = true;
                        q.offer(new Node(z, ny, nx, dist + 1));
                    }
                    if (z < K) {
                        int nz = z + 1;
                        if (!visited[nz][ny][nx] && board[ny][nx] == '1') {
                            visited[nz][ny][nx] = true;
                            q.offer(new Node(nz, ny, nx, dist + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
