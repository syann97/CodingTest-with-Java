import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] buckets = new int[1000001];
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            buckets[x] += g;
            max = Math.max(x, max);
        }

        int ices = 0;
        int idx = K;
        int window = Math.min(max, K * 2);
        for (int i = 0; i <= window; i++) {
            ices += buckets[i];
        }

        int answer = ices;
        while (++idx + K <= max) {
            ices -= buckets[idx - K - 1];
            ices += buckets[idx + K];
            answer = Math.max(answer, ices);
        }
        
        System.out.println(answer);
    }
}