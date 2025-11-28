import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G+1];

        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }

        int count = 0;
        while (count < P) {
            int airplane = Integer.parseInt(br.readLine());
            if (!union(airplane)) break;
            count++;
        }

        System.out.println(count);
    }


    private static boolean union(int a) {
        int b = find(a);

        if (b == 0) return false;

        parent[b] = find(b-1);

        return true;
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
