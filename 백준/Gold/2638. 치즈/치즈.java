import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


class Pos {
    int y;
    int x;

    public Pos (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] melt = new int[R][C];

        int count = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(melt[i], -1);

            for (int j = 0; j < C; j++) {
                if (st.nextToken().equals("1")) {
                    melt[i][j] = 2;
                    count++;
                }
            }
        }

        System.out.println(bfs(melt, R, C, count));
    }

    static String bfs(int[][] melt, int r, int c, int count) {
        ArrayDeque<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(0, 0));
        melt[0][0] = -1;

        int hour = 0;
        ArrayDeque<Pos> tmp = new ArrayDeque<>();

        // 현재 단계에서 공기이면서 방문 된 곳 : -2,
        // 현재 단계에서 공기이지만 방문 안된 곳 : -1,
        // 다음 단계에서 공기가 되는 공간 : 0 -> tmp에 의해서 바로 -2가 됨
        // 아직 치즈가 덜 녹은 상태 : 1 이상
        while (!q.isEmpty()) {

            while (!q.isEmpty()) {
                Pos pos = q.poll();

                int y = pos.y;
                int x = pos.x;

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (0 <= ny && ny < r && 0 <= nx && nx < c && melt[ny][nx] != -2) {
                        // case 1. 현재 공기이지만 방문되지 않은 공간 (-1)
                        // 이어서 이번 단계에서 전파
                        if (melt[ny][nx] == -1) {
                            melt[ny][nx]--;
                            q.offer(new Pos(ny, nx));
                        }

                        // case 2. 현재 공기가 아니지만 다음 차례에 공기가 되면서 방문되는 공간 (아무것도 안함)
                        // 이번 단계에서는 전파를 하지 않음
                        // 이 부분은 tmp에 저장되어 for문 끝난 후 처리

                        // case 3. 현재 치즈이지만 방문함으로써 공기가 되면서 방문되는 공간 (1 -> 0)
                        else if (melt[ny][nx] == 1) {
                            melt[ny][nx]--;
                            tmp.offer(new Pos(ny, nx));
                        }

                        // case 4. 현재 치즈이면서 방문해도 치즈인 경우
                        else if (melt[ny][nx] == 2) melt[ny][nx]--;
                    }
                }
            }

            if (!tmp.isEmpty()) hour += 1;
            if (count - tmp.size() == 0) return Integer.toString(hour);

            count -= tmp.size();
            q = tmp;
            tmp = new ArrayDeque<>();
        }

        return Integer.toString(hour);
    }
}
