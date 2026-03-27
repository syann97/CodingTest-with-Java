import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Part {
    int v;
    int w;
    Part part;

    public Part (int v, int w, Part part) {
        this.v = v;
        this.w = w;
        this.part = part;
    }

    public String toString () {
        return "[" + v + ", " + w + ", " + part + " ]";
    }
}

public class Main {
    static StringTokenizer st;
    static int [][] needs;
    static Part[] graph;
    static int[] in;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new Part[N+1];
        in = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            in[X]++;
            graph[Y] = new Part(X, K, graph[Y]);
        }

        topologySort();
    }

    static void topologySort() {
        needs = new int[N+1][N+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> baseList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) {
                q.offer(i);
                baseList.add(i);
                needs[i][i] = 1;
            }
        }

        int v = 0;
        while (!q.isEmpty()) {
            v = q.poll();

            for (Part part = graph[v]; part != null; part = part.part) {
                int nv = part.v;
                int nw = part.w;

                for (int base : baseList) {
                    if (needs[v][base] > 0) {
                        needs[nv][base] += needs[v][base] * nw;
                    }
                }

                if (--in[nv] == 0) q.offer(nv);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int base : baseList) {
            sb.append(base).append(" ").append(needs[v][base]).append("\n");
        }

        System.out.print(sb);
    }
}
