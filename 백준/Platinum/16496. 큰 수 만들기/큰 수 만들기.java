    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.PriorityQueue;
    import java.util.StringTokenizer;

    class CompareString implements Comparable<CompareString> {
        String s;

        public CompareString (String s) {
            this.s = s;
        }

        public int compareTo(CompareString o) {
            return greedy(this.s, o.s);
        }

        private static int greedy(String a, String b) {
            if (a.equals(b)) return 0;

            String AB = a + b;
            String BA = b + a;

            for (int i = 0; i < a.length() + b.length(); i++) {
                if (AB.charAt(i) > BA.charAt(i)) return -1;
                else if (AB.charAt(i) < BA.charAt(i)) return 1;
            }

            return a.length() > b.length() ? 1 : -1;
        }

        @Override
        public String toString() {
            return this.s;
        }
    }

    public class Main {
        static StringTokenizer st;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            PriorityQueue<CompareString> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.offer(new CompareString(st.nextToken()));
            }

            while (!pq.isEmpty()) {
                sb.append(pq.poll());
            }

            System.out.println(sb.charAt(0) == '0' ? '0' : sb);
        }
    }
