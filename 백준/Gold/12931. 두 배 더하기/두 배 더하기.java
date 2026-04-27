import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] A;
    static int N;
    static int zeroCount;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(greedy());
    }

    private static int greedy() {
        int totalCount = 0;
        while (true) {
            int oddCount = 0;
            int tmpZeroCount = 0;

            for (int current : A) {
                if (current == 0) continue;
                if (current % 2 == 1) {
                    if (current == 1) tmpZeroCount++;
                    oddCount++;
                }
            }

            if (oddCount > 0) totalCount += oddCount;
            zeroCount += tmpZeroCount;

            if (zeroCount == N) return totalCount;

            for (int i = 0; i < N; i++) {
                if (A[i] == 0) continue;
                A[i] >>= 1;
            }

            totalCount++;
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        zeroCount = 0;
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (A[i] == 0) zeroCount++;
        }
    }
}
