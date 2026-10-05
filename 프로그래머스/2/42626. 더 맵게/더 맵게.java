import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int value : scoville) {
            pq.offer((long) value);
        }

        int shakeCnt = 0;

        while (pq.peek()<K) {
            if (pq.size() < 2) {
                return -1;
            }

            long first = pq.poll();
            long second = pq.poll();

            pq.offer(first + 2L * second);
            shakeCnt++;
        }

        return shakeCnt;
    }
}