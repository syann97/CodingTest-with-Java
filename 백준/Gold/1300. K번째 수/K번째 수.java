import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());


        if (K == N * N || K <= 2) System.out.println(K);
        else {
            int s = 1;
            int e = K;

            while (s <= e) {
                int m = (s + e) / 2;
                int count = 0;

                for (int i = 1; i <= N; i++)
                    count += Math.min(m / i, N);
                
                if (count >= K)
                    e = m - 1;
                else
                    s = m + 1;
            }

            System.out.println(s);
        }
    }
}