import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class CCTV {
    int y;
    int x;
    int number;
    public CCTV (int y, int x, int number) {
        this.y = y;
        this.x = x;
        this.number = number;
    }
}

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer = Integer.MAX_VALUE;
    static int[][] directions = {
            {},
            {0},
            {0, 2},
            {0, 1},
            {0, 1, 2},
            {0, 1, 2, 3}
    };
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] area = new int[N][M];
        ArrayList<CCTV> cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= area[i][j] && area[i][j] <= 5) {
                    cctv.add(new CCTV(i, j, area[i][j]));
                }
            }
        }
        bt(0, area, cctv, new int[cctv.size()]);
        System.out.println(answer);
    }

    static void bt (int n, int[][] area, ArrayList<CCTV> cctvList, int[] select) {
        if (n == cctvList.size()) {
            int[][] copyArea = new int[N][M];
            for (int i = 0; i < N; i++) {
                copyArea[i] = area[i].clone();
            }

            for (int i = 0; i < cctvList.size(); i++) {
                CCTV cctv = cctvList.get(i);
                copyArea[cctv.y][cctv.x] = -1;

                int rotation = select[i];
                for (int direction : directions[cctv.number]) {
                    int nd = (rotation + direction) % 4;
                    int ny = cctv.y;
                    int nx = cctv.x;

                    while (true) {
                        ny += dy[nd];
                        nx += dx[nd];
                        if (ny < 0 || ny >= N || nx < 0 || nx >= M || copyArea[ny][nx] == 6) break;
                        if (copyArea[ny][nx] == 0) copyArea[ny][nx] = -1;
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyArea[i][j] == 0) count++;
                }
            }
            answer = Math.min(answer, count);
            return;
        }

        CCTV cctv = cctvList.get(n);
        int rotate = cctv.number == 5 ? 1 : cctv.number == 2 ? 2 : 4;

        for (int d = 0; d < rotate; d ++) {
            select[n] = d;
            bt(n + 1, area, cctvList, select);
        }
    }
}
