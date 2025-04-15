import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 선언
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());
        long[] nums = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        int start = 0;
        int end = 0;
        long sum = nums[0];
        int answer = N+1;

        while (start <= end) {
            if (sum >= S) {
                answer = Math.min(answer, end - start + 1);
                sum -= nums[start];
                start++;
            }
            else {
                if (++end == N) break;
                sum += nums[end];
            }
        }

        if (answer > N) System.out.println(0);
        else System.out.println(answer);
    }
}
