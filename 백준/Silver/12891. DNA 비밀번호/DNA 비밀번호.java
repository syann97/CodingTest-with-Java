import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            if (str.charAt(i) == 'A') a--;
            else if (str.charAt(i) == 'C') c--;
            else if (str.charAt(i) == 'G') g--;
            else if (str.charAt(i) == 'T') t--;
        }

        int i = 0;
        int j = p-1;
        int ans = 0;
        char ci = str.charAt(0);
        char cj = ' ';

        while (true) {
            if (a <= 0 && c <= 0 && g <= 0 && t <= 0) ans++;

            if (ci == 'A') a++;
            else if (ci == 'C') c++;
            else if (ci == 'G') g++;
            else if (ci == 'T') t++;
            i++;
            if (i >= s) break;
            ci = str.charAt(i);

            j++;
            if (j >= s) break;
            cj = str.charAt(j);
            if (cj == 'A') a--;
            else if (cj == 'C') c--;
            else if (cj == 'G') g--;
            else if (cj == 'T') t--;
        }
        System.out.println(ans);
    }
}