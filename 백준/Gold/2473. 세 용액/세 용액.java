import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        long[] solutions = new long[N];
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);
        sol(N, solutions);
    }

    static void sol(int N, long[] solutions) {
        long min = Long.MAX_VALUE;
        long[] answer = new long[3];

        for (int i = 0; i < N-2; i++) {
            for (int j = i + 1; j < N-1; j++) {
                long twoSolutions = solutions[i] + solutions[j];

                int s = j + 1;
                int e = N - 1;

                while (s <= e) {
                    int m = (s + e) / 2;
                    long checkMin = Math.abs(twoSolutions + solutions[m]);

                    if (twoSolutions + solutions[m] == 0) {
                        System.out.println(solutions[i] + " " + solutions[j] + " " + solutions[m]);
                        return;
                    }

                    if (checkMin < min) {
                        min = checkMin;
                        answer[0] = solutions[i];
                        answer[1] = solutions[j];
                        answer[2] = solutions[m];
                    }


                    if (twoSolutions + solutions[m] > 0) e = m - 1;
                    else s = m + 1;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
