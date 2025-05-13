import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Main {
    static int count = 0;
    static Set<String> set = new HashSet<>();
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        String[] numbers = new String[N];

        for (int i = 0; i < N; i++) numbers[i] = br.readLine();
        bt (0, numbers, new boolean[N], "");
        System.out.println(count);
    }

    static void bt(int n, String[] numbers, boolean[] visited, String number) {
        if (n == K) {
            if (!set.contains(number)) {
                set.add(number);
                count++;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bt(n+1, numbers, visited, number + numbers[i]);
                visited[i] = false;
            }
        }
    }
}
