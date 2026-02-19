import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Node implements Comparable<Node> {
    int y;
    int x;
    int w;

    public Node(int y, int x, int w) {
        this.y = y;
        this.x = x;
        this.w = w;
    }

    @Override
    public int compareTo (Node o) {
        return this.w - o.w;
    }
}


class Main {
    static StringTokenizer st;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] area = new int[501][501];

        int N = Integer.parseInt(br.readLine());
        if (N > 0) init(br, area, N, 1);

        int M = Integer.parseInt(br.readLine());
        if (M > 0) init(br, area, M, -1);

        if (N == 0 && M == 0) System.out.println(0);
        else System.out.println(bfs(area));
    }

    private static void init(BufferedReader br, int[][] area, int n, int value) throws IOException {
        int x1, x2, y1, y2;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            if (x1 > x2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
            }

            if (y1 > y2) {
                int tmp = y1;
                y1 = y2;
                y2 = tmp;
            }

            for (int i = y1; i <= y2; i++) {
                for (int j = x1; j <= x2; j++) {
                    area[i][j] = value;
                }
            }
        }
    }

    private static int bfs(int[][] area) {
        int[][] count = new int[501][501];

        for (int i = 0; i<= 500; i++) {
            Arrays.fill(count[i], Integer.MAX_VALUE);
        }
        count[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int y = node.y;
            int x = node.x;
            int w = node.w;

            if (w > count[y][x]) continue;

            if (y == 500 && x == 500) return w;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (0 <= ny && ny <= 500 && 0 <= nx && nx <= 500 && area[ny][nx] != -1) {
                    int nw = w + area[ny][nx];
                    if (count[ny][nx] > nw) {
                        count[ny][nx] = nw;
                        pq.offer(new Node(ny, nx, nw));
                    }
                }
            }
        }
        return -1;
    }
}
