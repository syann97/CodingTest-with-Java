class Solution {
    public int solution(int n, int w, int num) {
        // arr로 시뮬레이션만큼 쌓기
        // 짝수 홀수 구분해서 왼쪽 오른쪽 채우기
        // 올라가면서 찾기? 
        
        int h = n / w + (n % w == 0 ? 0 : 1);
        
        // 박스 번호 위치와 높이 찾기
        int row = (num - 1) / w;
        int col = (num - 1) % w;
        
        if (row % 2 == 1) {
            col = (w-1) - col;
        }
        
        int count = 0;
        int index = 0;
        int id = 1;
        for (int i = 0; i < h; i++) {
            if (i % 2 == 0) {
                System.out.println("왼쪽");
                for (int j = 0; j < w; j++) {
                    if (j == col && i >= row) count++;
                    if (--n == 0) return count;
                }
            }
            else {
                System.out.println("오른쪽");
                for (int j = w-1; j >= 0; j--) {
                    if (j == col && i >= row) count++;
                    if (--n == 0) return count;
                }
            }
        }
        
        return count;
    }
}