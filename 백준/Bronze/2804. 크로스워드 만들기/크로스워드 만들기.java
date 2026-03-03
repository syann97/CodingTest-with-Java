import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();

        int N = A.length;
        int M = B.length;

        int row = 0;
        int col = 0;

        boolean flag = false;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                if (B[i] == A[j]) {
                    row = i;
                    col = j;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        char[][] puzzle = new char[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(puzzle[i], '.');
        }

        for (int j = 0; j < N; j++) {
            puzzle[row][j] = A[j];
        }

        for (int i = 0; i < M; i++) {
            puzzle[i][col] = B[i];
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(puzzle[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
