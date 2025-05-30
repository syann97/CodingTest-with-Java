import java.util.*;

class Node {
    String s;
    int dist;
    
    public Node (String s, int dist) {
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
                
                if (isConnect(s, ns) && !visited.contains(ns)) {
                    visited.add(ns);
                    q.offer(new Node(ns, dist + 1));
                }
            }
        }
        
        return 0;
    }
    
    static boolean isConnect(String s, String ns) {
        int count = 0;
            
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ns.charAt(i)) count++;   
        }
        
        return count == s.length() - 1;
    }
}