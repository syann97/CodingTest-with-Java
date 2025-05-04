import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int H;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        boolean[][] ladder = new boolean[H][N+2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a-1][b] = true;
        }
        bt(0, 0, ladder);
        System.out.println(answer);
    }

    static void bt(int n, int sy, boolean[][] ladder) {
        if (n > 3) return;
        
        if (isSatisfy(ladder)) {
            answer = answer == -1 ? n : Math.min(answer, n);
            return;
        }
        
        for (int i = sy; i < H; i++) {
            for (int j = 1; j < N; j++) {
                if (!ladder[i][j-1] && !ladder[i][j] && !ladder[i][j+1]) {
                    ladder[i][j] = true;
                    bt(n+1, i, ladder);
                    ladder[i][j] = false;
                }
            }
        }
    }

    static boolean isSatisfy(boolean[][] ladder) {
        for (int i = 1; i <= N; i++) {
            int x = i;
            int y = 0;
            while (y < H) {
                if (ladder[y][x]) x += 1;
                else if (ladder[y][x-1]) x-= 1;
                y++;
            }
            if (i != x) return false;
        }
        return true;
    }
}
