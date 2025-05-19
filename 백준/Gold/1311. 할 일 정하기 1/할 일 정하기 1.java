import java.io.*;
import java.util.*;

// 학습용 --> 헝가리안 알고리즘
public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] cost;
    static int[] u, v, p, way;
    static int[] minv;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][N + 1]; // 1-based indexing

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(hungarian());
    }

    static int hungarian() {
        u = new int[N + 1];
        v = new int[N + 1];
        p = new int[N + 1];
        way = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            p[0] = i;
            int j0 = 0;
            minv = new int[N + 1];
            used = new boolean[N + 1];
            Arrays.fill(minv, INF);

            do {
                used[j0] = true;
                int i0 = p[j0];
                int delta = INF;
                int j1 = 0;

                for (int j = 1; j <= N; j++) {
                    if (!used[j]) {
                        int cur = cost[i0][j] - u[i0] - v[j];
                        if (cur < minv[j]) {
                            minv[j] = cur;
                            way[j] = j0;
                        }
                        if (minv[j] < delta) {
                            delta = minv[j];
                            j1 = j;
                        }
                    }
                }

                for (int j = 0; j <= N; j++) {
                    if (used[j]) {
                        u[p[j]] += delta;
                        v[j] -= delta;
                    } else {
                        minv[j] -= delta;
                    }
                }
                j0 = j1;
            } while (p[j0] != 0);

            // Augmenting path backtracking
            do {
                int j1 = way[j0];
                p[j0] = p[j1];
                j0 = j1;
            } while (j0 != 0);
        }

        // 최소 비용은 -v[0]에 저장됨
        return -v[0];
    }
}
