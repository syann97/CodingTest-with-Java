import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("0")) break;

            int n = Integer.parseInt(s);

            List<String> submits = new ArrayList<>();
            submits.add(st.nextToken());

            for (int i = 1; i < n; i++) {
                String tmp = st.nextToken();
                if(!submits.isEmpty() && !tmp.equals(submits.get(submits.size() - 1))) {
                    submits.add(tmp);
                }
            }

            for (String submit : submits) {
                sb.append(submit).append(" ");
            }
            sb.append("$").append("\n");
        }
        System.out.println(sb);
    }
}
