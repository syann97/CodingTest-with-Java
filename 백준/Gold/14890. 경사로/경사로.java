import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
            if (canBuildRoad(map, i, N, L, true)) count++;
            if (canBuildRoad(map, i, N, L, false)) count++;
        }

        System.out.println(count);
    }

    static boolean canBuildRoad(int[][] map, int pos, int N, int L, boolean isRow) {
        int[] suffixSameCount = new int[N];
        suffixSameCount[N - 1] = 1;

        int current = isRow ? map[pos][N-1] : map[N-1][pos];
        for (int i = N - 2; i >= 0; i--) {
            int nextHeight = isRow ? map[pos][i] : map[i][pos];
            if (current != nextHeight) {
                current = nextHeight;
                suffixSameCount[i] = 1;
            } else {
                suffixSameCount[i] = suffixSameCount[i + 1] + 1;
            }
        }

        current = isRow ? map[pos][0] : map[0][pos];
        int count = 1;

        for (int i = 1; i < N; i++) {
            int next = isRow ? map[pos][i] : map[i][pos];

            if (next == current) {
                count++;
            }
            else if (next == current - 1) {
                if (suffixSameCount[i] >= L) {
                    current = next;
                    count = -L + 1;
                } else {
                    return false;
                }
            }
            else if (next == current + 1) {
                if (count >= L) {
                    current = next;
                    count = 1;
                } else {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return true;
    }
}