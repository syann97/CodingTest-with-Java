import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] tree;
    
    static class Runner {
        int ability;
        int position;

        Runner(int ability, int position) {
            this.ability = ability;
            this.position = position;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int L = 1;

        while (N > L) {
            L <<= 1;
        }

        tree = new long[L << 1];
        Runner[] rank = new Runner[N];
        
        for (int i = 0; i < N; i++) {
            int ability = Integer.parseInt(br.readLine());
            rank[i] = new Runner(ability, i);
        }

        Arrays.sort(rank, (a, b) -> Integer.compare(b.ability, a.ability));

        long[] answer = new long[N];

        for (int i = 0; i < N; i++) {
            int pos = rank[i].position;
            
            long possible = search(1, 0, L - 1, 0, pos - 1);
            answer[pos] = possible + 1;
            
            tree[L + pos] = 1;
            update(L + pos);
        }

        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append('\n');
        }

        System.out.print(sb);
    }
    
    static void update(int index) {
        while (index > 1) {
            index >>= 1;
            tree[index] = tree[index << 1] + tree[(index << 1) | 1];
        }
    }

    static long search(int index, int start, int end, int left, int right) {
        if (end < left || right < start) {
            return 0;
        }
        
        if (left <= start && end <= right) {
            return tree[index];
        }
        
        int mid = start + ((end - start) >> 1);
        return search(index << 1, start, mid, left, right)
            + search((index << 1) | 1, mid + 1, end, left, right);
    }
}