import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    static long[] tree;
    static long[] lazy;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        size = 1;

        while (size < N) {
            size *= 2;
        }

        tree = new long[size << 1];
        lazy = new long[size << 1];


        st = new StringTokenizer(br.readLine());
        for (int i = size; i < size + N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
        }

        // init
        for (int i = size - 1; i > 0; i--) {
            tree[i] = tree[i << 1] + tree[(i << 1) | 1];
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            
            if (command == 1) {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                lazy(left, right, value);
            }
            else {
                int target = Integer.parseInt(st.nextToken());
                sb.append(search(target, target)).append('\n');
            }
        }

        System.out.print(sb);
    }

    static void update(int index, int start, int end, int left, int right, long value) {
        if (right < start || left > end) {
            return;
        }

        if (left <= start && end <= right) {
            tree[index] += (end - start + 1L) * value;
            lazy[index] += value;
            return;
        }

        int mid = (start + end) / 2;

        pushDown(index, start, end, mid);

        update(index<<1, start, mid, left, right, value);
        update((index<<1)|1, mid + 1, end, left, right, value);

        tree[index] = tree[index << 1] + tree[(index<<1)|1];
    }

    private static void pushDown(int index, int start, int end, int mid) {
        if (lazy[index] != 0) {
            int leftChild = index << 1;
            int rightChild = (index << 1) | 1;

            tree[leftChild] += (mid - start + 1L) * lazy[index];
            tree[rightChild] += (end - mid) * lazy[index];

            lazy[leftChild] += lazy[index];
            lazy[rightChild] += lazy[index];

            lazy[index] = 0;
        }
    }

    static void lazy(int left, int right, long value) {
        update(1, 1, size, left, right, value);
    }

    static long retrieve(int index, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[index];
        }

        int mid = (start + end) / 2;

        pushDown(index, start, end, mid);

        return retrieve(index<<1, start, mid, left, right)
            + retrieve((index<<1)|1, mid + 1, end, left, right);
    }

    static long search(int left, int right) {
        return retrieve(1, 1, size, left, right);
    }
}
