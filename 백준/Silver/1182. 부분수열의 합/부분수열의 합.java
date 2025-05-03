import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int answer = bt(numbers, 0,0);
        System.out.println(S == 0 ? answer - 1 : answer);
    }

    static int bt (int[] numbers, int i, int sum) {
        if (i == N) return sum == S ? 1 : 0;

        int count = 0;
        count += bt(numbers, i + 1, sum);
        count += bt(numbers, i + 1, sum + numbers[i]);

        return count;
    }
}
