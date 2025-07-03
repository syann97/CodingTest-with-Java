import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int y;
    int x;
    int c;
    public Node (int y, int x, int c) {
        this.y = y;
        this.x = x;
        this.c = c;
    }
}

public class Main {
    static final int MAX = Integer.MAX_VALUE;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] maze = new char[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            maze[i] = s.toCharArray();
        }

        System.out.println(bfs(N, M, maze));
    }


    static int bfs (int N, int M, char[][] maze) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0));


        int[][] visited = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(visited[i], MAX);
        }

        visited[0][0] = 0;


        while(!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            int c = node.c;

            if (visited[y][x] < c) continue;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                int nc = c;

                if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;

                if (maze[ny][nx] == '1') {
                    nc += 1;
                }

                if (visited[ny][nx] > nc) {
                    visited[ny][nx] = nc;
                    q.offer(new Node(ny, nx, nc));
                }
            }
        }

        return visited[M-1][N-1];
    }
}
