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
        if (total >= min) return;

        if (sy > 0 && sx == 0) {
            if (!checkRow(square, sy - 1)) return;
        }
        if (sx > 0 && sy == 2) {
            if (!checkCol(square, sx - 1)) return;
        }

        if (sy == 3) {
            if (checkDiagonal(square)) {
                min = Math.min(min, total);
            }
            return;
        }

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


    static boolean checkDiagonal(int[][] square) {
        int diagonal_left = square[0][0] + square[1][1] + square[2][2];
        int diagonal_right = square[0][2] + square[1][1] + square[2][0];
        return (diagonal_left == 15 && diagonal_right == 15);
    }

    static boolean checkRow(int[][] square, int row) {
        return square[row][0] + square[row][1] + square[row][2] == 15;
    }

    static boolean checkCol(int[][] square, int col) {
        return square[0][col] + square[1][col] + square[2][col] == 15;
    }
}
