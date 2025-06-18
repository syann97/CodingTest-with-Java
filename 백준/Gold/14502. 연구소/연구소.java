import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] area = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bt(0, 0, 0, N, M, area);
        System.out.println(answer);
    }

    static void bt(int wallCount, int y, int x, int N, int M, int[][] area) {
        if (wallCount == 3) {
            answer = Math.max(answer, spread(N, M, area));
            return;
        }

        for (int i = y; i < N; i++) {
            for (int j = (i == y) ? x : 0; j < M; j++) {
                if (area[i][j] == 0) {
                    area[i][j] = 1;
                    bt(wallCount + 1, i, j + 1, N, M, area);
                    area[i][j] = 0;
                }
            }
        }
    }

    static int spread (int N, int M, int[][] area) {

        int count = N * M;
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<Node> q = new ArrayDeque<>();
        ArrayDeque<Node> infestedArea = new ArrayDeque<>();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] != 0) {
                    count--;
                    if (area[i][j] == 2) {
                        q.offer(new Node(i, j));
                        visited[i][j] = true;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && area[ny][nx] == 0) {
                    count--;
                    area[ny][nx] = 2;
                    visited[ny][nx] = true;
                    q.offer(new Node(ny, nx));
                    infestedArea.offer(new Node(ny, nx));
                }
            }
        }

        while (!infestedArea.isEmpty()) {
            Node node = infestedArea.poll();
            area[node.y][node.x] = 0;
        }

        return count;
    }
}
