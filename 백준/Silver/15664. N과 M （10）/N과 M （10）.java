import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(0, 0, nums, "");
        System.out.println(sb);
    }

    static void dfs(int n, int idx, int[] nums, String str) {
        if (n == M) {
            if (!set.contains(str)) {
                sb.append(str).append('\n');
                set.add(str);
            }
        }

        for (int i = idx; i < nums.length; i++) {
            dfs(n + 1, i + 1, nums, str + nums[i] + " ");
        }
    }
}
