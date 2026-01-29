import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Numbers {
    int a;
    int b;
    int c;
    int d;

    public Numbers(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    void rotate () {
        int tmp = this.a;
        this.a = this.c;
        this.c = this.d;
        this.d = this.b;
        this.b = tmp;
    }

    double calculate() {
        return (double) this.a / this.c + (double) this.b / this.d;
    }
}

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Numbers numbers = new Numbers(A, B, C, D);
        double max = numbers.calculate();
        int answer = 0;

        for (int i = 1; i < 4; i++) {
            numbers.rotate();
            double comp = numbers.calculate();

            if (comp > max) {
                max = comp;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
