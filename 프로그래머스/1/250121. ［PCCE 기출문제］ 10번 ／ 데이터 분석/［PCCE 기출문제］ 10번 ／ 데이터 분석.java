import java.util.*;

class Solution {
    static Map<String, Integer> order;
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        order = new HashMap<>();
        order.put("code", 0);
        order.put("date", 1);
        order.put("maximum", 2);
        order.put("remain", 3);
        
        // data = [code, date, maximum, remain]
        
        ArrayList<int[]> validData = new ArrayList<>();
        
        for (int[] d : data) {
            if (d[order.get(ext)] < val_ext) {
                validData.add(d);
            }
        }
        
        
        
        return sort(validData, sort_by);
    }
    
    static int[][] sort(ArrayList<int[]> validData, String sort_by) {
        Collections.sort(validData, (o1, o2) -> {
           return o1[order.get(sort_by)] - o2[order.get(sort_by)];
        });
        
        return validData.stream().toArray(int[][]::new);
    }
}