import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] box;
    static int M;
    static int N;
    static Queue<int[]> queue = new ArrayDeque<>();
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int days = 0;
    public static void main(String[] args) throws IOException {
		    // init var
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        // init box
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // start logic
        initQueue();
        bfs();
        if (isRipened()) System.out.println(days);
        else System.out.println(-1);
    }


    static boolean isRipened() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cord = queue.poll();
            int y = cord[0];
            int x = cord[1];
            int d = cord[2];

            days = Math.max(days, d);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < M && 0 <= ny && ny < N && box[ny][nx] == 0) {
                    queue.add(new int[]{ny, nx, d+1});
                    box[ny][nx] = 1;
                }
            }
        }
    }

    static void initQueue() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) queue.add(new int[]{i, j, 0});
            }
        }
    }
}