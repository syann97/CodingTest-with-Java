import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<String, String> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        map.put("animal", "Panthera tigris");
        map.put("tree", "Pinus densiflora");
        map.put("flower", "Forsythia koreana");

        String s;
        while (!(s = br.readLine()).equals("end")) {
            sb.append(map.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}
