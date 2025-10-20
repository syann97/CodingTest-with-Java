import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] plates = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            plates[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(plates);

        int start = 0;
        int end = N - 1;

        int min = 0;
        int max = 0;

        while (start <= end) {
            if (start == end) {
                max += plates[start];
            }
            else {
                min += plates[start];
                max += plates[end];
            }
            start++;
            end--;
        }

        System.out.printf("%d %d", min, max);
    }
}