import java.util.*;

class Solution {
    static int N;
    static Map<String, List<Integer>> routeMap;
    static String[][] tickets;
    static String[] answer;
    public String[] solution(String[][] t) {
        tickets = t;
        N = tickets.length;
        Arrays.sort(tickets, (o1, o2) -> {
			if (o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
			return o1[0].compareTo(o2[0]);
		});
        
        
        routeMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String key = tickets[i][0];
            
            if (!routeMap.containsKey(key)) {
                routeMap.put(key, new ArrayList<>());
            }
            routeMap.get(key).add(i);
        }
        
        String[] route = new String[N+1];
        route[0] = "ICN";
        dfs(1, route, new boolean[N]);
        return answer;
    }
    
    static boolean dfs(int n, String[] route, boolean[] visited) {
        if (n == N + 1) { 
            answer = route;
            return true; 
        }
        
        String current = route[n-1];
        if (!routeMap.containsKey(current)) return false;

        for (int ticketIdx : routeMap.get(current)) {
            if (!visited[ticketIdx]) {
                visited[ticketIdx] = true;
                route[n] = tickets[ticketIdx][1];
                
                if (dfs(n + 1, route, visited)) return true;
                
                visited[ticketIdx] = false;
            }
        }
        return false;
    }
}