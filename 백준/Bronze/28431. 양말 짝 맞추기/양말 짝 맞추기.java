import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new LinkedList<>();
        
        int N = 5;
        
        while(N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            int index = list.indexOf(num);

            if (index == -1) list.add(num);
            else list.remove(index);
        }

        System.out.println(list.get(0));
    }
}
