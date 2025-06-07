import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting (int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> meetings = new PriorityQueue<>((o1, o2) -> {
            if (o1.end == o2.end) return o1.start - o2.start;
            return o1.end - o2.end;
        });


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.offer(new Meeting(start, end));
        }

        int count = 0;
        int end = 0;
        while(!meetings.isEmpty()) {
            Meeting meeting = meetings.poll();
            if (end <= meeting.start) {
                count++;
                end = meeting.end;
            }
        }

        System.out.println(count);
    }
}

