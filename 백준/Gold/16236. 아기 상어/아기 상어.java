import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


class BabyShark {
    int x, y, dist;
    public BabyShark(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] space;
    static int y;
    static int x;
    static int N;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int[] prey = new int[7];
    static int size = 2;
    static int count = 0;
    static int total_dist = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        space = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());

                // 아기 상어 좌표
                if (space[i][j] != 0) {
                    if (space[i][j] == 9) {
                        y = i;
                        x = j;
                    }
                    else {
                        prey[space[i][j]]++;
                    }
                }
            }
        }

        space[y][x] = 0;
        while (canEat()) {
            int move = bfs();
            if (move == -1) break;
            total_dist += move;
            eat();
        }
        System.out.println(total_dist);
    }

    // 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
    static boolean canEat() {
        for (int i = 1; i < Math.min(size, 7); i++) {
            if (prey[i] > 0) return true;
        }
        return false;
    }

    // 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
    static int bfs() {
        ArrayDeque<BabyShark> queue = new ArrayDeque<>();
        queue.offer(new BabyShark(x, y, 0));
        boolean[][] visited = new boolean[N][N];
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            BabyShark shark = queue.poll();
            x = shark.x;
            y = shark.y;
            int dist = shark.dist;

            if (space[y][x] != 0 && size > space[y][x]) {
                while (!queue.isEmpty()) {
                    BabyShark candidate = queue.poll();

                    if (candidate.dist > dist) break;
                    int cx = candidate.x;
                    int cy = candidate.y;

                    if (space[cy][cx] != 0 && size > space[cy][cx]) {
                        if (cy < y || (cy == y && cx < x)) {
                            y = cy;
                            x = cx;
                        }
                    }
                }
                prey[space[y][x]]--;
                space[y][x] = 0;
                return dist;
            }

            // 4방향 갱신
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                // 자신의 크기보다 큰 상어가 있는 경우 가지 못한다.
                if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx] && space[ny][nx] <= size) {
                    visited[ny][nx] = true;
                    queue.offer(new BabyShark(nx, ny, dist + 1));
                }
            }
        }
        return -1;
    }


    static void eat() {
        count++;
        if (count == size) {
            size++;
            count = 0;
        }
    }
}
