import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 선언
        int N = Integer.parseInt(br.readLine());
        long[] solutions = new long[N];
        long[] result = new long[2];
        Long min = Long.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 로직
        Arrays.sort(solutions);

        // 투 포인터 로직
        int start = 0;
        int end = N-1;

        while (start < end) {
            long two_solutions = solutions[start] + solutions[end];
            long solutions_abs = Math.abs(two_solutions);

            if (two_solutions == 0) {
                result[0] = solutions[start];
                result[1] = solutions[end];
                break;
            }

            else {
                if(solutions_abs < min) {
                    min = solutions_abs;
                    result[0] = solutions[start];
                    result[1] = solutions[end];
                }

                if (two_solutions < 0) start++;
                else end--;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
