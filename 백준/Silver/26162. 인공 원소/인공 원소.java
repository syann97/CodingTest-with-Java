import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Main {
    static boolean[] isPrime = new boolean[117];
    static boolean[] sumIsPrime = new boolean[119];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Arrays.fill(isPrime, 2, isPrime.length, true);

        for (int i = 2; i <= 116; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * 2; j <= 116; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = 4; i <= 118; i++) {
            if (isPrime[i - 2]) {
                sumIsPrime[i] = true;
                continue;
            }
            for (int j = 3; j <= i - 3; j += 2) {
                int k = i - j;
                if (isPrime[j] && isPrime[k]) {
                    sumIsPrime[i] = true;
                    break;
                }
            }
        }

        while (N --> 0) {
            sb.append(sumIsPrime[Integer.parseInt(br.readLine())] ? "Yes" : "No").append("\n");
        }
        System.out.println(sb);
    }
}