class Solution {
    public int solution(int n, int[] stations, int w) {
        int count = 0;
        int start = 1;
        int propagationArea = w * 2 + 1;
        
        for (int station : stations) {
            int end = station - w;
            
            if (start < end) {
                int area = end - start;
                count += area / propagationArea + (area % propagationArea != 0 ? 1 : 0);
            }
            start = station + w + 1;
        }
        
        int area = (n + 1) - start;
        if (area > 0) {
            count += area / propagationArea + (area % propagationArea != 0 ? 1 : 0);
        }

        return count;
    }
}