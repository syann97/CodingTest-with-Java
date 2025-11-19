import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    static int[] parent;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            HashMap<String, Integer> map = new HashMap<>();
            int F = Integer.parseInt(br.readLine());
            parent = new int[F * 2];
            size = new int[F * 2];

            int index = 0;
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());

                String a = st.nextToken();
                String b = st.nextToken();

                int indexA = 0;
                int indexB = 0;

                if (!map.containsKey(a)) {
                    map.put(a, index);
                    indexA = index;

                    parent[index] = index;
                    size[index] = 1;
                    index++;
                }
                else indexA = map.get(a);

                if (!map.containsKey(b)) {
                    map.put(b, index);
                    indexB = index;

                    parent[index] = index;
                    size[index] = 1;
                    index++;
                }
                else indexB = map.get(b);

                int network = union(indexA, indexB);
                sb.append(network).append("\n");
            }
        }
        System.out.print(sb);
    }


    static int find (int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static int union (int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return size[x];
        
        int sizeX = size[x];
        int sizeY = size[y];

        if (sizeX > sizeY) {
            parent[y] = x;
            return size[x] += size[y];

        }
        else {
            parent[x] = y;
            return size[y] += size[x];
        }
    }
}