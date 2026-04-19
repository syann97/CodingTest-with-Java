import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] P = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        System.out.println(greedy(N, M, P));
    }

    private static String greedy(int N, int M, int[] P) {
        int minIdx = 0;
        for (int i = 1; i < N; i++) {
            if (P[i] <= P[minIdx]) minIdx = i;
        }

        int minNZIdx = -1;
        for (int i = 1; i < N; i++) {
            if (minNZIdx == -1 || P[i] <= P[minNZIdx]) minNZIdx = i;
        }

        if (minNZIdx == -1 || M < P[minNZIdx]) return "0";

        List<Integer> digits = new ArrayList<>();
        digits.add(minNZIdx);
        int rest = M - P[minNZIdx];

        while (rest >= P[minIdx]) {
            digits.add(minIdx);
            rest -= P[minIdx];
        }

        for (int i = 0; i < digits.size(); i++) {
            int current = digits.get(i);

            for (int j = N - 1; j > current; j--) {
                int extraCost = P[j] - P[current];
                if (rest >= extraCost) {
                    rest -= extraCost;
                    digits.set(i, j);
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int d : digits) sb.append(d);
        return sb.toString();
    }
}