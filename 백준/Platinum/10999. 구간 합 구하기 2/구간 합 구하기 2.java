import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    static long[] tree;
    static long[] lazy;
    static int size;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 초기화
        // N이 2의 배수가 되는 구간 찾기
        size = 1;

        while (size < N) {
            size *= 2;
        }

        tree = new long[size << 1];
        lazy = new long[size << 1];


        // leaf node
        for (int i = size; i < size + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        // init
        for (int i = size - 1; i > 0; i--) {
            tree[i] += tree[i<<1] + tree[(i<<1)|1];
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // a=1
            // 갱신 -> b번째부터 c번째 수에 d를 더하기
            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                lazy(b, c, d);
            }
            // a=2
            // 조회 -> b번째부터 c번째까지
            else {
                sb.append(search(b, c)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void update(int index, int start, int end, int left, int right, long value) {
        // left right 범위에 딱맞는 위치
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
