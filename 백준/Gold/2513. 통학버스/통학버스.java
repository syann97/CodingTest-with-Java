import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Apart implements Comparable<Apart> {
    int pos;
    int count;

    public Apart (int pos, int count) {
        this.pos = pos;
        this.count = count;
    }

    @Override
    public int compareTo(Apart o) {
        return o.pos - this.pos;
    }
}


public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        PriorityQueue<Apart> left = new PriorityQueue<>();
        PriorityQueue<Apart> right = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            int absPos = Math.abs(pos - S);

            if (pos < S) left.offer(new Apart(absPos, count));
            else right.offer(new Apart(absPos, count));
        }

        int answer = 0;
        answer += greedy(left, K);
        answer += greedy(right, K);

        System.out.println(answer);
    }

    private static int greedy(PriorityQueue<Apart> pq, int K) {
        Apart current = null;
        int move = 0;

        // 묶음 단위 처리
        while (!pq.isEmpty()) {
            // 무조건 이번 루프에 이거 처리한다.
            current = pq.poll();

            // 그러면 몇 번 왕복하는지 체킹
            // 1~K까진 1로 나오게 해야되는데  / K를 하면 0이 나오고 K에서는 1이 나오네
            // current.count+K-1 로 K단위에서 엣지 처리와 +1 처리를 수행하자
            int aroundCount = (current.count + K -1) / K;

            // 일단 순회하는 만큼 move를 더하자
            move += (current.pos * aroundCount) * 2;
            // 그러면 이제 몇 번 순회하는지 알았으니 용량을 체킹하자 얼마가 남지?
            int rest = K * aroundCount - current.count;

            // 이제 남은 rest에 대해 이번 순회에 모두 처리하도록 하자
            // 우선 rest보다 작은 왕복 카운트에 대해서는 제거해버리자
            while (!pq.isEmpty() && rest > 0) {
                current = pq.peek();
                // 더 크거나 같은건 빼줘
                if (rest >= current.count) {
                    rest -= current.count;
                    pq.poll();
                }

                // rest보다 큰 건 count를 빼줘
                else {
                    current.count -= rest;
                    rest = 0;
                }
            }
        }

        return move;
    }
}