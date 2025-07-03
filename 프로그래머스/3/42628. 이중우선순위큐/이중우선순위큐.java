import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] order = operation.split(" ");
            
            if (order[0].equals("I")) {
                minPq.offer(Integer.parseInt(order[1]));
                maxPq.offer(Integer.parseInt(order[1]));
            }
            else {
                if (maxPq.isEmpty()) continue;
                
                if (order[1].equals("1")) minPq.remove(maxPq.poll());
                else maxPq.remove(minPq.poll());
            }
        }
        return maxPq.isEmpty() ? new int[] {0, 0} : new int[] {maxPq.poll(), minPq.poll()};
    }
}