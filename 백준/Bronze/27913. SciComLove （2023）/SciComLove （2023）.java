import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static final String word = "SciComLove";
    static final int WORD_LEN = word.length();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N / WORD_LEN; i++) sb.append(word);
        sb.append(word, 0, N % WORD_LEN);
        char[] ch = sb.toString().toCharArray();
        
        int upperCount = 0;
        for (char c : ch) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int X = Integer.parseInt(br.readLine());
            int index = X - 1;

            char originalChar = ch[index];
            
            if (Character.isLowerCase(originalChar)) {
                ch[index] = Character.toUpperCase(originalChar);
                upperCount++;
            } else {
                ch[index] = Character.toLowerCase(originalChar);
                upperCount--;
            }
            result.append(upperCount).append("\n");
        }

        System.out.print(result);
    }
}