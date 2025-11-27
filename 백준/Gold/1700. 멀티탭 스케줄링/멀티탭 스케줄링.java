import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class PlugInfo {
    int index;
    List<Integer> memo;

    public PlugInfo (int index, List<Integer> memo) {
        this.index = index;
        this.memo = memo;
    }
}

class PluggedItem implements Comparable<PluggedItem> {
    String name;
    int index;

    public PluggedItem (String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public int compareTo(PluggedItem o) {
        return Integer.compare(o.index, this.index);
    }
}

public class Main {
    static StringTokenizer st;
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(0);
        }
        else {
            st = new StringTokenizer(br.readLine());
            Map<String, PlugInfo> map = new HashMap<>();
            String[] order = new String[K];

            for (int i = 0; i < K; i++) {
                String name = st.nextToken();
                order[i] = name;
                PlugInfo plugInfo;

                if (!map.containsKey(name))
                    plugInfo = new PlugInfo(0, new ArrayList<>());
                else
                    plugInfo = map.get(name);

                plugInfo.memo.add(i);
                map.put(name, plugInfo);
            }

            Set<String> holes = new HashSet<>();
            PriorityQueue<PluggedItem> pq = new PriorityQueue<>();
            int count = 0;

            for (int i = 0; i < K; i++) {
                String name = order[i];
                if (holes.contains(name)) {
                    pq.offer(new PluggedItem(name, findNextIndex(map, name)));
                    continue;
                }

                if (holes.size() < N) {
                    holes.add(name);
                    pq.offer(new PluggedItem(name, findNextIndex(map, name)));
                }
                else {
                    if (!holes.contains(name)) {
                        while (true) {
                            PluggedItem pluggedItem = pq.poll();

                            if (holes.contains(pluggedItem.name)) {
                                holes.remove(pluggedItem.name);
                                break;
                            }
                        }
                    }
                    count++;
                    holes.add(name);
                    pq.offer(new PluggedItem(name, findNextIndex(map, name)));
                }
            }
            System.out.println(count);
        }
    }

    private static int findNextIndex(Map<String,PlugInfo> map, String name) {
        PlugInfo plugInfo = map.get(name);

        int nextPointer = plugInfo.index + 1;
        plugInfo.index = nextPointer;

        map.put(name, plugInfo);

        if (nextPointer >= plugInfo.memo.size()) {
            return K;
        }

        return plugInfo.memo.get(nextPointer);
    }
}
