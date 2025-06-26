import java.io.IOException;
import java.util.Arrays;

class Reader {
    private final int SIZE = 1 << 19;
    private byte[] buffer = new byte[SIZE];
    private int size, index;

    private byte read() throws IOException {
        if (size == index) {
            size = System.in.read(buffer, index = 0, SIZE);

            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }

    int nextInt() throws IOException {
        int n = 0;
        byte c;
        boolean isMinus = false;

        while ((c = read()) <= 32);


        if (c == 45) {
            isMinus = true;
            c = read();
        }

        do n = (n << 3) + (n << 1) + (c & 15);
        while (48 <= (c = read()) && c <= 57);

        return isMinus ? ~n+1 : n;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();

        int N = in.nextInt();
        int K = in.nextInt();

        int[] L = new int[N];

        for (int i = 1; i < N; i++) L[i] = in.nextInt();

        int[][] dp = new int[2][N];
        Arrays.fill(dp[0], 1);
        Arrays.fill(dp[1], 1);

        int max = 0;

        for (int i = 1; i < N; i++) {
            if (L[i] <= K) {
                dp[0][i] = dp[0][i-1] + 1;
                dp[1][i] = dp[1][i-1] + 1;
            }
            else {
                if (dp[0][i-1] >= 0) dp[1][i] = dp[0][i-1] + 1;
            }
            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }
        System.out.println(max);
    }
}