import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                boolean isConnected = st.nextToken().equals("1");

                if (isConnected) {
                    union(i + 1, j + 1);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            find(i);
        }

        st = new StringTokenizer(br.readLine());

        int firstCity = Integer.parseInt(st.nextToken());
        int p = find(firstCity);
        boolean flag = true;

        for (int i = 1; i < M; i++) {
            int nextCity = Integer.parseInt(st.nextToken());

            if (find(nextCity) != p) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }

    static int find (int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union (int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) return;

        parent[b] = a;
    }
}