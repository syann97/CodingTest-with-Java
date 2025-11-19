import java.io.IOException;
import java.util.HashMap;


class Reader {
    private final int SIZE = 1 << 13;
    private byte[] buffer = new byte[SIZE];
    private int index, size;

    int nextInt() throws IOException {
        int n = 0;
        byte c;
        boolean isMinus = false;

        while ((c = read()) <= ' ');

        if (c == '-') {
            isMinus = true;
            c = read();
        }

        do {
            n = (n << 3) + (n << 1) + (c & 15);
        } while (isNumber(c = read()));

        return isMinus ? ~n + 1 : n;
    }


    String nextString() throws IOException {
        StringBuilder sb = new StringBuilder();
        byte c;

        while ((c = read()) <= ' ');

        do {
            sb.append((char) c);
        } while (isAlphabet(c = read()) || isNumber(c));

        return sb.toString();
    }

    private boolean isNumber(byte c) {
        return c >= '0' && c <= '9';
    }

    private boolean isAlphabet(byte c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }


    private byte read() throws IOException {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);

            if (size < 0) {
                buffer[0] = -1;
            }
        }

        return buffer[index++];
    }
}


class Main {
    static int[] parent = new int[200000];
    static int[] size = new int[200000];
    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        StringBuilder sb = new StringBuilder();
        int T = r.nextInt();

        while (T --> 0) {
            HashMap<String, Integer> map = new HashMap<>();
            int F = r.nextInt();

            int index = 0;
            for (int i = 0; i < F; i++) {
                String a = r.nextString();
                String b = r.nextString();

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
