import java.util.*;


class Node {
    int v;
    Node node;
    
    public Node (int v, Node node) {
        this.v = v;
        this.node = node;
    }
}


class Solution {
    static Node[] pipeA;
    static Node[] pipeB;
    static Node[] pipeC;
    static int max;
    static int K;
    static int N;
    public int solution(int n, int infection, int[][] edges, int k) {
        max = 0;
        K = k;
        N = n;
        
        // 초기화
        pipeA = new Node[n+1];
        pipeB = new Node[n+1];
        pipeC = new Node[n+1];
        
        // [x, y, type]
        // 파이프 A, B, C 로 나누기
        // 각각의 연결을 별도로 저장
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if (edge[2] == 1) {
                setPipe(pipeA, u, v);
            }
            else if (edge[2] == 2) {
                setPipe(pipeB, u, v);
            }
            else {
                setPipe(pipeC, u, v);
            }
        }
        
        boolean[] tmp = new boolean[n+1];
        tmp[infection] = true;
        
        
        dfs(0, tmp, 0);
        
        return max;
    }
    
    static void setPipe(Node[] pipe, int u, int v) {
        pipe[u] = new Node(v, pipe[u]);
        pipe[v] = new Node(u, pipe[v]);
    }
    
    static int getMax(boolean[] current) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (current[i]) count++;
        }
        
        
        return count;
    }
    
    
    
    static void dfs(int turn, boolean[] current, int type) {
        if (turn == K) {
            int currentMax = getMax(current);
            max = Math.max(max, currentMax);
            return;
        }
        
        // A 가 열린 경우
        ArrayDeque<Integer> save = copy(current);
        
        
        
        if (type != 1) {
            bfs(save, current, pipeA);
            dfs(turn + 1, current, 1);
            restore(save, current);
        }
        // B가 열린 경우
        
        
        if (type != 2) {
            bfs(save, current, pipeB);
            dfs(turn + 1, current, 2);
            restore(save, current);
        }
        
        // C가 열린 경우
        if (type != 3) {
            bfs(save, current, pipeC);
            dfs(turn + 1, current, 3);
            restore(save, current);
        }
    }
    
    static ArrayDeque<Integer> copy(boolean[] current) {
        ArrayDeque<Integer> tmp = new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
            if (current[i]) tmp.add(i);
        }
        
        return tmp;
    }
    
    static void bfs(ArrayDeque<Integer> save, boolean[] current, Node[] pipe) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for (int index : save) {
            q.offer(index);
        }
        
        
        while (!q.isEmpty()) {
            int v = q.poll();
            
            for (Node node = pipe[v]; node != null; node = node.node) {
                int nv = node.v;
                
                if (!current[nv]) {
                    current[nv] = true;
                    q.offer(nv);
                }
            }
        }
    }
    
    static void restore(ArrayDeque<Integer> save, boolean[] current) {
        Arrays.fill(current, false);
        for (int index : save) {
            current[index] = true;
        }
    }
}