import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    // static 변수 정의
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int M;
    static Set<String> set = new HashSet<>();
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        bt(0, "");
        System.out.print(sb);
    }

    static void bt(int count, String tmp) {
        if (count == M) {
            if (!set.contains(tmp)) {
                sb.append(tmp).append('\n');
                set.add(tmp);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bt(count + 1, tmp + arr[i] + " ");
                visited[i] = false;
            }
        }
    }
}
