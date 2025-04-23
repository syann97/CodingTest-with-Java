import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int H;
    static int W;
    static boolean[][] area;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        area = new boolean[H][W];
        int[] blocks = new int[W];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < W; j++) {
            int block = Integer.parseInt(st.nextToken());
            for (int i = H-block; i < H; i++) {
                area[i][j] = true;
            }
        }

        for (int i = 0; i < H; i++) {
            int start = -1;
            for (int j = 0; j < W; j++) {
                if (area[i][j]) {
                    if (start != -1) {
                        answer += j - start - 1;
                    }
                    start = j;
                }
            }
        }
        System.out.println(answer);
    }
}