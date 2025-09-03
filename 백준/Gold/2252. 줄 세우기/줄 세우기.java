import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inDegrees = new int[N+1];
        List<Integer>[] graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph[v].add(u);
            inDegrees[u]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegrees[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int v = q.poll();
            sb.append(v).append(" ");

            for (int nv : graph[v]) {
                if (--inDegrees[nv] == 0) {
                    q.offer(nv);
                }
            }
        }
        System.out.println(sb);
    }
}