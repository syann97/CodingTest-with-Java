import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] diff = new int[N];

        st = new StringTokenizer(br.readLine());

        if (K >= N) System.out.println(0);
        else {
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            
            for (int i = 1; i < N; i++) {
                diff[i] = A[i] - A[i-1];
            }
            Arrays.sort(diff);

            int answer = 0;
            for(int i = 1; i <= N - K; i++) {
                answer += diff[i];
            }

            System.out.println(answer);
        }
    }
}

