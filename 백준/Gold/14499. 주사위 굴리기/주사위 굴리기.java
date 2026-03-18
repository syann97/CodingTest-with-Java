import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map =new int[N][M];
        int[][] dice = new int[4][3];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        st = new StringTokenizer(br.readLine());
        while (K-- > 0) {
            int op = Integer.parseInt(st.nextToken());
            if (move(op, dice, map, x, y)) {
                x += dx[op];
                y += dy[op];
                sb.append(dice[1][1]).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static boolean move(int op, int[][] dice, int[][] map, int x, int y) {
        int nx = x + dx[op];
        int ny = y + dy[op];

        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
            return false;
        }

        int tmp = dice[1][1];
        if (op == 1) {
            dice[1][1] = dice[1][0];
            dice[1][0] = dice[3][1];
            dice[3][1] = dice[1][2];
            dice[1][2] = tmp;
        }
        else if (op == 2) {
            dice[1][1] = dice[1][2];
            dice[1][2] = dice[3][1];
            dice[3][1] = dice[1][0];
            dice[1][0] = tmp;
        }
        else if (op == 3) {
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = dice[0][1];
            dice[0][1] = tmp;
        }
        else {
            dice[1][1] = dice[0][1];
            dice[0][1] = dice[3][1];
            dice[3][1] = dice[2][1];
            dice[2][1] = tmp;
        }

        if (map[nx][ny] == 0) {
            map[nx][ny] = dice[3][1];
        }
        else {
            dice[3][1] = map[nx][ny];
            map[nx][ny] = 0;
        }
        return true;
    }
}
