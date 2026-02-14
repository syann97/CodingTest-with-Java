import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringTokenizer st;
    static final int MAX = 100000;
    static ArrayList<Integer> primes = new ArrayList<>();
    static long[] even;
    static long[] odd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(f(a, b));
        }

        System.out.println(sb);
    }

    private static void init() {
        boolean[] isNotPrime = new boolean[MAX + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i <= MAX; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);

                if ((long)i * i <= MAX) {
                    for (int j = i * i; j <= MAX; j += i) {
                        isNotPrime[j] = true;
                    }
                }
            }
        }

        even = new long[primes.size()];
        odd = new long[primes.size()];
        long e = 0;
        long o = 0;
        for (int i = 0; i < primes.size(); i++) {
            int n = primes.get(i);

            if (i % 2 == 0) {
                even[i] = e += 3L * n;
                odd[i] = o -= n;
            }
            else {
                even[i] = e -= n;
                odd[i] = o += 3L * n;
            }
        }
    }

    static long f(int a, int b) {
        int si = -1;
        int ei = -1;

        int s = 0;
        int e = primes.size() - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            int cp = primes.get(m);

            if (cp >= a) {
                si = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        s = 0;
        e = primes.size() - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            int cp = primes.get(m);

            if (cp <= b) {
                ei = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        if (si == -1 || ei == -1 || si > ei) return 0;

        if (si % 2 == 0) {
            return even[ei] - (si > 0 ? even[si - 1] : 0);
        } else {
            return odd[ei] - (si > 0 ? odd[si - 1] : 0);
        }
    }
}
