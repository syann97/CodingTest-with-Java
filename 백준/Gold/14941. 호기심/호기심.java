import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringTokenizer st;
    static boolean[] isNotPrime = new boolean[100001];
    static ArrayList<Integer> primes = new ArrayList<>();
    static long[] even = new long[100001];
    static long[] odd = new long[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        eratosthenes();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(f(a, b));
        }

        System.out.println(sb);
    }

    private static void eratosthenes() {
        int index = 0;
        int MAX = 100000;
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i <= MAX; i++) {
            even[i] = even[i - 1];
            odd[i] = odd[i - 1];

            if (!isNotPrime[i]) {
                primes.add(i);

                if (index % 2 == 0) {
                    even[i] += (3L * i);
                    odd[i] -= i;
                } else {
                    even[i] -= i;
                    odd[i] += (3L * i);
                }

                if ((long)i * i <= MAX) {
                    for (int j = i * i; j <= MAX; j += i) {
                        isNotPrime[j] = true;
                    }
                }
                index++;
            }
        }
    }

    static long f(int a, int b) {
        int start = -1, end = -1;
        int si = -1;

        int s = 0;
        int e = primes.size() - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            int cp = primes.get(m);

            if (cp >= a) {
                start = cp;
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
                end = cp;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        if (start == -1 || end == -1) return 0;

        if (si % 2 == 0) {
            return even[end] - even[start - 1];
        } else {
            return odd[end] - odd[start - 1];
        }
    }
}
