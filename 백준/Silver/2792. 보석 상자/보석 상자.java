import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] jewels = new int[M];
        int max = 0;
        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, jewels[i]);
        }

        System.out.println(bs(0, max, N, jewels));
    }

    static boolean isPossible(int N, int jealous, int[] jewels) {
        if (jealous == 0) return false;

        int count = 0;

        for (int jewel : jewels) {
            if (jewel % jealous == 0) count += jewel / jealous;
            else count += (jewel / jealous) + 1;

            if (count > N) return false;
        }
        return true;
    }

    static int bs (int s, int e, int N, int[] jewels) {

        while (s <= e) {
            int m = (s + e) / 2;

            if (isPossible(N, m, jewels))
                e = m - 1;
            else
                s = m + 1;
        }
        return s;
    }
}
