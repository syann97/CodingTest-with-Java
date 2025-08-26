import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            int answer = 0;
            String line = br.readLine();
            while (line != null && line.isEmpty()) {
                line = br.readLine();
            }

            st = new StringTokenizer(line);
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            char[][] box = new char[r][c];
            for (int i = 0; i < r; i++) {
                String s = br.readLine();
                box[i] = s.toCharArray();
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (box[i][j] == 'o') {
                        if (i - 1 >= 0 && i + 1 < r && (box[i - 1][j] == 'v' && box[i + 1][j] == '^')) {
                            answer++;
                        } else if (j - 1 >= 0 && j + 1 < c && (box[i][j - 1] == '>' && box[i][j + 1] == '<')) {
                            answer++;
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
