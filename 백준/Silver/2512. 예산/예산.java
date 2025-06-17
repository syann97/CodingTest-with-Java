import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] requests = new int[N];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, requests[i]);
        }

        int M = Integer.parseInt(br.readLine());
        Arrays.sort(requests);

        System.out.println(bs(0, max, requests, M, 0));
    }

    static boolean isPossible (int limit, int M, int[] requests) {
        int sum = 0;
        for (int request : requests) {
            sum += Math.min(request, limit);
        }
        return M >= sum;
    }

    static int bs(int s, int e, int[] requests, int M, int ans) {
        if (s > e) return ans;

        int m = (s + e) / 2;

        return isPossible(m, M, requests) ? bs(m + 1, e, requests, M, m) : bs(s, m - 1, requests, M, ans);
    }
}
