import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Bridge {
    int y;
    int x;

    public Bridge(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while (N --> 0) {
            st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            if (operator.equals("all")) {
                for (int i = 1; i <= 20; i++) {
                    set.add(i);
                }
            }
            else if (operator.equals("empty")) {
                set.clear();
            }
            else {
                int num = Integer.parseInt(st.nextToken());
                if (operator.equals("add")) {
                    set.add(num);
                }
                else if (operator.equals("remove")) {
                    set.remove(num);
                }
                else if (operator.equals("check")) {
                    if (set.contains(num)) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                } else { // toggle
                    if (set.contains(num)) set.remove(num);
                    else set.add(num);
                }
            }
        }
        System.out.print(sb);
    }
}