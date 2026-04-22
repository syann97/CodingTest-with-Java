import java.util.*;

class Solution {
    static int N;
    public int solution(String s) {
        N = s.length();
        
        char[] arr = new char[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i);
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (isValid(arr, i)) answer++;
        }
        
        return answer;
    }
    
    
    static boolean isValid(char[] arr, int di) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int ni = (i + di) % N;
            char c = arr[ni];
            // 왼쪽 괄호면 넣기
            if (c == '[' || c == '{' || c == '(') {
                stack.addLast(c);
            }
            else {
                if (stack.isEmpty()) return false;
                char target = stack.peekLast();
                if ((c == ']' && target == '[') ||
                    (c == '}' && target == '{') ||
                    (c == ')' && target == '(')) {
                    stack.pollLast();
                }
                else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}