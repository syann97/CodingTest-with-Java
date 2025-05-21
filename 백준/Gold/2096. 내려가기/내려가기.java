import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 10000000;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] points = new int[3];
        int[] maxNow = new int[3];
        int[] minNow = new int[3];
        int[] maxNext = new int[3];
        int[] minNext = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int col = 0; col < 3; col++) {
            int point = Integer.parseInt(st.nextToken());
            maxNow[col] = point;
            minNow[col] = point;
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 3; col++) points[col] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 3; j++) {
                maxNext[j] = maxNow[j];
                minNext[j] = minNow[j];
                if (j > 0) {
                    maxNext[j] = Math.max(maxNext[j], maxNow[j-1]);
                    minNext[j] = Math.min(minNext[j], minNow[j-1]);
                }
                if (j < 2) {
                    maxNext[j] = Math.max(maxNext[j], maxNow[j + 1]);
                    minNext[j] = Math.min(minNext[j], minNow[j + 1]);
                }
                maxNext[j] += points[j];
                minNext[j] += points[j];
            }

            for (int col = 0; col < 3; col++) {
                maxNow[col] = maxNext[col];
                minNow[col] = minNext[col];
            }
        }

        int min = INF;
        int max = 0;

        for (int col = 0; col < 3; col++) {
            max = Math.max(max, maxNow[col]);
            min = Math.min(min, minNow[col]);
        }
        System.out.println(max + " " + min);
    }
}

