import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] square = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int number = Integer.parseInt(st.nextToken());
                square[i][j] = number;
            }
        }

        bt(square, 0, 0, 0, new boolean[10]);
        System.out.println(min);
    }

    static void bt(int[][] square, int sy, int sx, int total, boolean[] used) {
        if (sy == 3) {
            if (isMagicSquare(square)) {
                min = Math.min(min, total);
            }
            return;
        }

        if (total >= min) return;

        int ny = sx + 1 == 3 ? sy + 1 : sy;
        int nx = sx + 1 == 3 ? 0 : sx + 1;

        for (int num = 1; num <= 9; num++) {
            if (!used[num]) {
                int tmp = square[sy][sx];
                used[num] = true;
                square[sy][sx] = num;

                bt(square, ny, nx, total + Math.abs(tmp - num), used);

                used[num] = false;
                square[sy][sx] = tmp;
            }
        }
    }


    static boolean isMagicSquare(int[][] square) {
        int diagonal_left = 0;
        int diagonal_right = 0;
        int[] cols = {0, 0, 0};
        int[] rows = {0, 0, 0};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rows[i] += square[i][j];
                cols[j] += square[i][j];
                if (i == j) diagonal_left += square[i][j];
                if (i + j == 2) diagonal_right += square[i][j];
            }
        }

        if (diagonal_left != 15) return false;
        if (diagonal_right != 15) return false;
        for (int i = 0; i < 3; i++) if (cols[i] != 15 || rows[i] != 15) return false;

        return true;
    }
}
