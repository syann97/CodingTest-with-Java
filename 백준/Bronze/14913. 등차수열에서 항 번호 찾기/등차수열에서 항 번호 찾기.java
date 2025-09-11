import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (a == k) {
            System.out.println(1);
            return;
        }

        if (d == 0 || (a < k && d < 0) || (a > k && d > 0)) {
            System.out.println("X");
            return;
        }

        int diff = k - a;
        if (diff % d == 0) {
            int n = (diff / d) + 1;
            if (n > 0) {
                System.out.println(n);
            } else {
                System.out.println("X");
            }
        } else {
            System.out.println("X");
        }
    }
}