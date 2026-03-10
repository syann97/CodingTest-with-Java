import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] grid = new boolean[101][101];

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dragonCurve(x, y, d, g, grid);
        }

        System.out.println(countDragonCurve(grid));
    }

    private static int countDragonCurve(boolean[][] grid) {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (grid[i][j] && grid[i][j+1] && grid[i+1][j] && grid[i+1][j+1]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dragonCurve(int x, int y, int d, int g, boolean[][] grid) {
        ArrayList<Integer> curveList = new ArrayList<>();
        curveList.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = curveList.size() - 1; j >= 0; j--) {
                curveList.add((curveList.get(j) + 1) % 4);
            }
        }

        grid[y][x] = true;
        for (int nd : curveList) {
            y += dy[nd];
            x += dx[nd];
            grid[y][x] = true;
        }
    }
}
