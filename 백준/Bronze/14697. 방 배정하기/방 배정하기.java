import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N+1];

        System.out.println(bf(0, A, B, C, N, visited) ? 1 : 0);
    }

    private static boolean bf(int count, int a, int b, int c, int n, boolean[] visited) {
        if (count == n) return true;

        visited[count] = true;

        if (count + a <= n && !visited[count+a] && bf(count + a, a, b, c, n, visited)) return true;
        if (count + b <= n && !visited[count+b] && bf(count + b, a, b, c, n, visited)) return true;
        if (count + c <= n && !visited[count+c] && bf(count + c, a, b, c, n, visited)) return true;

        return false;
    }
}
