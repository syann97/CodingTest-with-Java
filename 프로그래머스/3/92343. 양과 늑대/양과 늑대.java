import java.util.*;

class Solution {
    static List<Integer> candidate = new ArrayList<>();
    static int max = 0;
    static ArrayList<Integer>[] graph;
    public int solution(int[] info, int[][] edges) {
        graph = new ArrayList[info.length];
        
        for (int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            int[] nodes = edges[i];
            graph[nodes[0]].add(nodes[1]);
        }
        
        
        dfs(0, 0, 0, info, new ArrayList<>(List.of(0)));
        
        return max;
    }
    
    static void dfs(int node, int sheep, int wolf, int[] info, ArrayList<Integer> candidate) {
        if (info[node] == 0) sheep++;
        else wolf++;
        
        if (sheep <= wolf) return;
        
        max = Math.max(max, sheep);
        
        ArrayList<Integer> nextCandidate = new ArrayList<>(candidate);
        nextCandidate.addAll(graph[node]);
        nextCandidate.remove(Integer.valueOf(node));
        
        for (int nextNode : nextCandidate) {
            dfs(nextNode, sheep, wolf, info, new ArrayList<>(nextCandidate));
        }
    }
}