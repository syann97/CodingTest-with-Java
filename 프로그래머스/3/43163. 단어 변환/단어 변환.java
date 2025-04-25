import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    
    
    
    static int bfs(String begin, String target, String[] words) {
        int[] visited = new int[words.length + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int len = words.length;
        int s_len = begin.length();
        
        for (int i = 0; i < len; i++) {
            int count = 0;
            String s = words[i];
            
            for (int j = 0; j < s.length(); j++) {
                char c1 = s.charAt(j);
                char c2 = begin.charAt(j);
                if (c1 == c2) count++;
            }
            if (count == s.length()-1) {
                q.offer(i);
                visited[i] = 1;
            }
        }
        
        while (!q.isEmpty()) {
            int v = q.poll();
            
            if (words[v].equals(target)) return visited[v];
            
            for (int nv = 0; nv < len; nv++) {
                if (visited[nv] == 0) {
                    int count = 0;
                    String s1 = words[nv];
                    String s2 = words[v];
                    for (int j = 0; j < s_len; j++) {
                        char c1 = s1.charAt(j);
                        char c2 = s2.charAt(j);
                        if (c1 == c2) count++;
                    }
                    if (count == s_len - 1) {
                        q.offer(nv);
                        visited[nv] = visited[v] + 1;
                    }
                }
            }
        }
        return 0;
    }
}