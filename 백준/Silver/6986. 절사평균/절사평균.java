import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        BigDecimal[] A = new BigDecimal[N];

        for (int i = 0; i < N; i++) {
            A[i] = new BigDecimal(br.readLine());
        }
        Arrays.sort(A);

        trimmedMean(N, K, A);
        adjustedMean(N, K, A);
    }

    static void trimmedMean(int N, int K, BigDecimal[] A) {
        int count = N - (2 * K);
        BigDecimal sum = BigDecimal.ZERO;

        for (int i = K; i < N - K; i++) {
            sum = sum.add(A[i]);
        }

        BigDecimal avg = sum.divide(BigDecimal.valueOf(count), 10, RoundingMode.HALF_UP);
        avg = avg.setScale(2, RoundingMode.HALF_UP);

        System.out.println(avg);
    }

    static void adjustedMean(int N, int K, BigDecimal[] A) {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal left = A[K].multiply(BigDecimal.valueOf(K));
        BigDecimal right = A[N - K - 1].multiply(BigDecimal.valueOf(K));
        sum = sum.add(left).add(right);

        for (int i = K; i < N - K; i++) {
            sum = sum.add(A[i]);
        }

        BigDecimal avg = sum.divide(BigDecimal.valueOf(N), 10, RoundingMode.HALF_UP);
        avg = avg.setScale(2, RoundingMode.HALF_UP);

        System.out.println(avg);
    }
}
