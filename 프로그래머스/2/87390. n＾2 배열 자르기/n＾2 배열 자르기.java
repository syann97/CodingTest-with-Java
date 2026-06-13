class Solution {
    public int[] solution(int n, long left, long right) {
        long L = right - left + 1;
        int[] answer = new int[(int)L];
        
        int index = 0;
        for (long i = left; i <= right; i++) {
            int min = (int) (i / n + 1);
            
            answer[index++] = Math.max(min, (int)(i % n + 1));
        }

        return answer;
    }
}