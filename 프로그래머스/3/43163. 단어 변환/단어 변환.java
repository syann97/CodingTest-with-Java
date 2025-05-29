import java.util.*;

class Node {
    String s;
    int dist;
    public Node(String s, int dist) {
        this.s = s;
        this.dist = dist;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(begin, 0));
        
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            String s = node.s;
            int dist = node.dist;
            
            if (s.equals(target)) return dist;
            
            for (int i = 0; i < words.length; i++) {
                String ns = words[i];
                if (s.equals(ns)) continue;
                
                if (!visited.contains(ns) && isConnect(s, ns)) {
                    visited.add(ns);
                    q.offer(new Node(ns, dist + 1));
                }
            }
        }
        
        return 0;
    }
    
    static boolean isConnect(String s1, String s2) {
        int count = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) count++;
        }
        
        return count == s1.length() - 1;
    }
}