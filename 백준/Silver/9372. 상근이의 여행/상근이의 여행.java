import java.io.IOException;

class Reader {
    private final int SIZE = 1 << 13;
    private byte[] buffer = new byte[SIZE];
    private int size, index;

    private byte read() throws IOException {
        if (size == index) {
            size = System.in.read(buffer, index = 0, SIZE);

            if (size < 0) {
                buffer[0] = -1;
            }
        }
        return buffer[index++];
    }

    int nextInt() throws IOException {
        int n = 0;
        byte c;
        boolean isMinus = false;

        while ((c = read()) <= 32);

        if (c == 45) {
            isMinus = true;
            c = read();
        }

        do n = (n << 3) + (n << 1) + (c & 15);
        while (48 <= (c = read()) && c <= 57);

        return isMinus ? ~n+1 : n;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        while (T --> 0) {
            int V = in.nextInt();
            int E = in.nextInt();

            for (int i = 0; i < E; i++) {
                in.nextInt();
                in.nextInt();
            }
            sb.append(V-1).append("\n");
        }
        System.out.print(sb);
    }
}
