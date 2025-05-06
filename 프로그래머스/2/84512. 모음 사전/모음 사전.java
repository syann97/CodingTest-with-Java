class Solution {
    static int count = 0;
    static int answer = 0;
    static char[] words = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        bt(0, "", word);
        return answer;
    }
    
    static boolean bt(int length, String s, String word) {
        if (s.equals(word)) {
                answer = count;
                return true;
        }
        if (length == 5) return false;
            
        for (int i = 0; i < 5; i++) {
            count++;
            if (bt(length + 1, s + words[i], word)) return true;
        }
        return false;
    }
}