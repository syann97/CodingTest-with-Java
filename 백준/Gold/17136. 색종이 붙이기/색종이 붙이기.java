import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int min = 26;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] area = new int[10][10];

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0, area, new int[]{0, 5, 5, 5, 5, 5}, 0);
        System.out.println(min == 26 ? -1 : min);
    }


    static void bfs(int y, int x, int[][] area, int[] paperCount, int count) {
        if (y == 10) {
            min = Math.min(min, count);
            return;
        }

        if (count >= min) return;

        int ny = x + 1 == 10 ? y + 1 : y;
        int nx = x + 1 == 10 ? 0 : x + 1;

        if (area[y][x] == 1) {
            int maxSize = checkPossibleSize(y, x, area);
            for (int size = 5; size >= 1; size--) {
                if (size <= maxSize && paperCount[size] > 0) {
                    for (int row = y; row < y + size; row++) {
                        for (int col = x; col < x + size; col++) {
                            area[row][col] = 0;
                        }
                    }
                    paperCount[size]--;

                    bfs(ny, nx, area, paperCount, count + 1);

                    for (int row = y; row < y + size; row++) {
                        for (int col = x; col < x + size; col++) {
                            area[row][col] = 1;
                        }
                    }
                    paperCount[size]++;
                }
            }
        }
        else {
            bfs(ny, nx, area, paperCount, count);
        }
    }



    private static int checkPossibleSize(int y, int x, int[][] area) {
        for (int size = 5; size >= 1; size--) {
            if (y + size > 10 || x + size > 10) continue;

            boolean possible = true;
            for (int i = y; i < y + size && possible; i++) {
                for (int j = x; j < x + size; j++) {
                    if (area[i][j] != 1) {
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) return size;
        }

        return 0;
    }
}
