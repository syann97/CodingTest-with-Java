import java.util.*;

class SongInfo implements Comparable<SongInfo>{
    int index;
    int count;
    
    public SongInfo(int index, int count) {
        this.index = index;
        this.count = count;
    }
    
    @Override
    public int compareTo(SongInfo o) {
        if (this.count == o.count) {
            return this.index - o.index;
        }
        return o.count - this.count;
    }
    
    @Override
    public String toString() {
        return "[" + index + ", " + count + "]";
    }
}


class Solution {
    static int N;
    public int[] solution(String[] genres, int[] plays) {
        N = genres.length;
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, PriorityQueue<SongInfo>> genreBest = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            if (!genreCount.containsKey(genres[i])) {
                genreCount.put(genres[i], plays[i]);
                
                PriorityQueue<SongInfo> pq = new PriorityQueue<>();
                pq.offer(new SongInfo(i, plays[i]));
                genreBest.put(genres[i], pq);
            }
            else {
                genreCount.put(genres[i], genreCount.get(genres[i]) + plays[i]);
                PriorityQueue<SongInfo> tmp = genreBest.get(genres[i]);
                tmp.offer(new SongInfo(i, plays[i]));
                genreBest.put(genres[i], tmp);
            }
        }
        
        
        ArrayList<Map.Entry<String, Integer>> genreList = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : genreCount.entrySet()) {
            genreList.add(entry);
        }
        
        genreList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        
        int size = 0;
        for (Map.Entry<String, PriorityQueue<SongInfo>> entry : genreBest.entrySet()) {
            size += Math.min(entry.getValue().size(), 2);
        }
        
        int[] answer = new int[size];

        
        int index = 0;
        for (Map.Entry<String, Integer> entry : genreList) {
            String genre = entry.getKey();
            PriorityQueue<SongInfo> tmp = genreBest.get(genre);
            
            int insertCount = Math.min(tmp.size(), 2);
            while (insertCount -- > 0) {
                answer[index] = tmp.poll().index;
                index++;
            }
        }
        
        // 장르 명, 장르별 재생 횟수, 개별 재생 횟수, 고유 번호 (index)
        return answer;
    }
}