import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[] col = new boolean[N];
        boolean[] diagonal_left = new boolean[N * 2];
        boolean[] diagonal_right = new boolean[N * 2];

        bt(N, 0, col, diagonal_left, diagonal_right);
        System.out.println(count);
    }

    static void bt(int N, int y, boolean[] col, boolean[] diagonal_left, boolean[] diagonal_right) {
        if (y == N) {
            count++;
            return;
        }
        
        for (int x = 0; x < N; x++) {
            int left = y + x;
            int right = y - x < 0 ? N + Math.abs(y - x) : y - x;

            if (!col[x] && !diagonal_left[left] && !diagonal_right[right]) {
                col[x] = true;
                diagonal_left[left] = true;
                diagonal_right[right] = true;
                bt(N, y + 1, col, diagonal_left, diagonal_right);
                col[x] = false;
                diagonal_left[left] = false;
                diagonal_right[right] = false;
            }
        }
    }
}
