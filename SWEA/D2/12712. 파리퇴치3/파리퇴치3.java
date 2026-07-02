import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    static int[] plusDy = {-1, 0, 1, 0};
    static int[] plusDx = {0, -1, 0, 1};
    static int[] crossDy = {-1, -1, 1, 1};
    static int[] crossDx = {-1, 1, -1, 1};
    static int[][] area;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            area = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    answer = Math.max(answer, countKilledFlies(i, j));
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    static int countKilledFlies(int y, int x) {
        int plusCount = calKilledFiles(y, x, plusDy, plusDx);
        int crossCount = calKilledFiles(y, x, crossDy, crossDx);
        
        return Math.max(plusCount, crossCount);
    }

    static int calKilledFiles(int y, int x, int[] dy, int[] dx) {
        int count = area[y][x];
        int spread = M-1;

        for (int d = 0; d < 4; d++) {
            int ny = y;
            int nx = x;
            int moves = 0;

            while (ny + dy[d] >= 0 && ny + dy[d] < N &&
                nx + dx[d] >= 0 && nx + dx[d] < N && moves < spread) {
                ny += dy[d];
                nx += dx[d];
                count += area[ny][nx];
                moves++;
            }
        }

        return count;
    }
}