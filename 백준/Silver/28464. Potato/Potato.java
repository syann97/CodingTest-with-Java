import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Table implements Comparable<Table> {
    int num;
    int count;

    public Table (int num, int count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(Table o) {
        if (this.count == o.count) return Integer.compare(this.num, o.num);
        return Integer.compare(this.count, o.count);
    }
}

class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeSet<Table> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(new Table(i, Integer.parseInt(st.nextToken())));
        }

        int max = 0;
        int min = 0;

        Table t;
        while(!set.isEmpty()) {
            t = set.pollLast();
            max += t.count;

            if (set.isEmpty()) break;

            t = set.pollFirst();
            min += t.count;
        }

        System.out.println(min + " " + max);
    }
}