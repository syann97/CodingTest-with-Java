import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        int[] answer = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < N + 1; i++) {
            int cnt = 0;
            visited = new boolean[N+1];
            dfs(i);
            for (int j = 1; j < N + 1; j++) {
                if (visited[j])
                    cnt++;
            }
            answer[i] = cnt;
        }

        int max = 0;
        int idx = 0;
        for (int i = 1; i < N + 1; i++) {
            if (max < answer[i]) {
                max = answer[i];
                idx = i;
            }
        }
        System.out.println(idx);
    }

    static void dfs(int index) {
        visited[index] = true;
        while (!visited[parent[index]]) {
            dfs(parent[index]);
        }
    }
}