import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] weights = new int[26];

        for (int i = 0; i < N; i++) {
            char[] spells = br.readLine().toCharArray();
            int L = spells.length;

            for (int j = 0; j < L; j++) {
                char c = spells[j];
                int digit = L - j - 1;

                weights[c - 65] += (int) Math.pow(10, digit);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (weights[i] != 0) pq.offer(weights[i]);
        }

        int answer = 0;
        int mul = 9;

        while(!pq.isEmpty()) {
            int weight = pq.poll();
            answer += weight * mul;
            mul--;
        }

        System.out.println(answer);
    }
}
