import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        set.add(0);

        int a = 0;
        for (int i = 1; i <= N; i++) {
            if (a - i < 0 || set.contains(a - i)) {
                a = a + i;
            }
            else {
                a = a - i;
            }
            set.add(a);
        }

        System.out.println(a);
    }
}
