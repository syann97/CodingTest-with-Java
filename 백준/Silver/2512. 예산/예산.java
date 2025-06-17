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
        System.out.println(bs(1, max, requests, M, 0));
    }

    static boolean isPossible (int limit, int M, int[] requests) {
        int sum = 0;
        for (int request : requests) {
            if (request > limit)
                sum += limit;
            else
                sum += request;
        }
        return M >= sum;
    }

    static int bs(int s, int e, int[] requests, int M, int ans) {
        while (s <= e) {
            int m = (s + e) / 2;

            if (isPossible(m, M, requests)) {
                s = m + 1;
                ans = m;
            }
            else e = m - 1;
        }

        return ans;
    }
}
