import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Node {
    int y, x;
    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] area = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean isPopulationMovement = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        boolean moved = bfs(area, visited, i, j, N, L, R);
                        if (moved) isPopulationMovement = true;
                    }
                }
            }
            if (!isPopulationMovement) break;
            count++;
        }
        System.out.println(count);
    }

    static boolean bfs(int[][] area, boolean[][] visited, int sy, int sx, int N, int L, int R) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        ArrayDeque<Node> open = new ArrayDeque<>();
        q.offer(new Node(sy, sx));
        open.offer(new Node(sy, sx));
        visited[sy][sx] = true;

        int total = area[sy][sx];

        while (!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
                    int diff = Math.abs(area[y][x] - area[ny][nx]);
                    if (L <= diff && diff <= R) {
                        visited[ny][nx] = true;
                        total += area[ny][nx];
                        q.offer(new Node(ny, nx));
                        open.offer(new Node(ny, nx));
                    }
                }
            }
        }

        if (open.size() == 1) return false;

        int newPopulation = total / open.size();
        for (Node node : open) {
            area[node.y][node.x] = newPopulation;
        }
        return true;
    }
}