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

        int[] sizes = new int[N];
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
            sum += sizes[i];
        }

        System.out.println(bs(0, sum, M, sizes));
    }

    static boolean isPossible(int M, int limit, int[] sizes) {
        int count = 0;
        int sum = 0;
        for (int size : sizes) {
            if (sum + size > limit) {
                count++;
                sum = size;
            }
            else
                sum += size;

            if (count == M || size > limit) return false;
        }
        return true;
    }

    static int bs (int s, int e, int M, int[] sizes) {
        
        while (s <= e) {
            int m = (s + e) / 2;

            if (isPossible(M, m, sizes))
                e = m - 1;
            else
                s = m + 1;
        }
        return s;
    }
}
