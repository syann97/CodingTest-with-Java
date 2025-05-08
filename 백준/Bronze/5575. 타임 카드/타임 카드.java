import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int sh = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());
            int ss = Integer.parseInt(st.nextToken());
            int eh = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int es = Integer.parseInt(st.nextToken());
            
            if (es < ss) {
                em--;
                es += 60 - ss;
            }
            else es -= ss;

            if (em < sm) {
                eh--;
                em += 60 - sm;
            }
            else em -= sm;
            eh -= sh;
            
            System.out.println(eh + " " + em + " " + es);
        }
    }
}
