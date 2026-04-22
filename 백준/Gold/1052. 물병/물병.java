import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> q = new ArrayList<>();

        int rest = N;
        int amount = 1;
        while (rest > 0) {
            if (rest % 2 == 1) {
                q.add(amount);
                rest -= 1;
            }
    
            rest /= 2;
            amount <<= 1;
        }

        if (q.size() <= K) System.out.println(0);
        else {
            int answer = q.get(q.size()-K);

            for (int i = 0; i < q.size()-K; i++) {
                answer -= q.get(i);
            }

            System.out.println(answer);
        }
    }
}
