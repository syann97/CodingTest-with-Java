import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Node {
    int y;
    int x;

    public Node (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int count = 0;

        for (int i = 0; i < N; i++) {
            count += getAnswer(map, i, N, L, true);
            count += getAnswer(map, i, N, L, false);
        }

        System.out.println(count);
    }

    static int getAnswer(int[][] map, int pos, int N, int L, boolean isRow) {
        int[] right = new int[N];

        right[N-1] = 1;


        int current = isRow ? map[pos][N-1] : map[N-1][pos];
        for (int i = N-2; i >= 0; i--) {
            int next = isRow ? map[pos][i] : map[i][pos];
            if (current != next) {
                current = next;
                right[i] = 1;
            }
            else {
                right[i] = right[i+1] + 1;
            }
        }

        current = isRow ? map[pos][0] : map[0][pos];
        int stack = 1;

        for (int i = 1; i < N; i++) {
            int next = isRow ? map[pos][i] : map[i][pos];
            if (next == current) {
                stack++;
            }
            else if (next == current - 1) {
                if (right[i] >= L) {
                    current = next;
                    stack = -L+1;
                }
                else return 0;
            }
            else if (next == current + 1 && stack >= L) {
                current = next;
                stack = 1;
            }
            else return 0;
        }

        return 1;
    }
}
