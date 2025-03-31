import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int H;
    static int W;
    static int X;
    static int Y;
    static int[][] A;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        A = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (i >= X && j >= Y) A[i][j] = A[i][j]-A[i-X][j-Y];
                sb.append(A[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
