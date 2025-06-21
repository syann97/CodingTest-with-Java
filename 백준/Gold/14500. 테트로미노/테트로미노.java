import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[][][] tetrominos =
            {
                    {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
                    {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
                    {{0, 0}, {0, 1}, {-1, 1}, {1, 0}}, {{0, 0}, {0, 1}, {-1, 0}, {1, 1}}, {{0, 0}, {1, 0}, {0, -1}, {1, 1}}, {{0, 0}, {1, 0}, {0, 1}, {1, -1}},
                    {{0, 0}, {1, -1}, {1, 0}, {1, 1}}, {{0, -1}, {0, 0}, {0, 1}, {1, 0}}, {{-1, 0}, {0, 0}, {1, 0}, {0, 1}}, {{-1, 0}, {0, 0}, {1, 0}, {0, -1}},
                    {{0, 0}, {1, 0}, {2, 0}, {2, -1}}, {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, {{0, 0}, {0, 1}, {0, 2}, {-1, 0}}, {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
                    {{0, 0}, {1, 0}, {2, 0}, {0, -1}}, {{0, 0}, {1, 0}, {2, 0}, {0, 1}}, {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, {{0, 0}, {0, 1}, {0, 2}, {-1, 2}}
            };
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] values = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                values[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int[][] tetromino : tetrominos) {
                    answer = Math.max(answer, getValue(i, j, N, M, tetromino, values));
                }
            }
        }
        System.out.println(answer);
    }

    static int getValue(int y, int x, int N, int M, int[][] shape, int[][] values) {
        int value = 0;
        for (int i = 0; i < shape.length; i++) {
            int ny = y + shape[i][0];
            int nx = x + shape[i][1];
            if (ny < 0 || ny >= N || nx < 0 || nx >= M) return -1;
            value += values[ny][nx];
        }
        return value;
    }
}