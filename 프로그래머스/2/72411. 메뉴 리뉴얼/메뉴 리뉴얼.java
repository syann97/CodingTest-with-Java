import java.util.*;

class Solution {
    static Map<Integer, Integer> courseMap;
    static Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
        map = new HashMap<>();
        for (int i = 0; i < course.length; i++) {
            courseMap.put(course[i], i);
        }
        
        for (String order : orders) {
            char[] words = order.toCharArray();
            Arrays.sort(words);
            combination(words, 0, new StringBuilder());
        }
        
        int[] max = new int[course.length];
        ArrayDeque<String>[] courseString = new ArrayDeque[course.length];
        for (int i = 0; i < course.length; i++) {
            courseString[i] = new ArrayDeque<>();
            max[i] = 2;
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int size = entry.getKey().length();
            int index = courseMap.get(size);
            int count = entry.getValue();
            if (max[index] < count) {
                max[index] = count;
                courseString[index].clear();
                courseString[index].offer(entry.getKey());
            } 
            else if (max[index] == count) {
                courseString[index].offer(entry.getKey());
            }
        }
        
        Set<String> sort = new TreeSet<>();
        for (int i = 0; i < course.length; i++) {
            while(!courseString[i].isEmpty()) {
                sort.add(courseString[i].poll());
            }
        }
        
        int size = sort.size();
        String[] answer = new String[size];
        
        int index = 0;
        for (String s : sort) {
            answer[index++] = s;
        }
        
        return answer;
    }
    
    static void combination(char[] words, int index, StringBuilder sb) {
        if (index == words.length) {
            if (courseMap.containsKey(sb.length())) {
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            }
            return;
        }
        
        combination(words, index+1, sb);
        combination(words, index+1, sb.append(words[index]));
        sb.setLength(sb.length()-1);
    }
}