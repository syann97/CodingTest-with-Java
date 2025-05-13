import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] operator = {0, 0, 0, 0};
    static int[] numbers;
    static int M;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        M = N - 1;
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        bt(0, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void bt(int n, int total) {
        if (n == M) {
            min = Math.min(min, total);
            max = Math.max(max, total);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                bt(n+1, calTotal(numbers[n+1], total, i));
                operator[i]++;
            }
        }
    }

    private static int calTotal(int now, int total, int operator_idx) {
        if (operator_idx == 0) return total + now;
        if (operator_idx == 1) return total - now;
        if (operator_idx == 2) return total * now;
        else return total / now;
    }
}
