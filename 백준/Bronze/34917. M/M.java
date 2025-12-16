import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            char[][] board = new char[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (j == 0 || j == N-1 || (i <= N/2 && (i == j || j == N - i - 1))) {
                        board[i][j] = '#';
                    }
                    else board[i][j] = '.';
                }
            }
            print(board, sb);
        }
        System.out.println(sb);
    }

    private static void print(char[][] board, StringBuilder sb) {
        for (int i = 0; i < board.length; i++) {
            for (char c : board[i]) {
                sb.append(c);
            }
            sb.append("\n");
        }
    }
}
