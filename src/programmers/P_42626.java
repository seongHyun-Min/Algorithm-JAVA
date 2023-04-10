package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class P_42626 {


    public static int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        //우선순위큐 기본이 오름차순 정렬
        int count = 0;
        for (int i = 0; i < scoville.length; i++) {
            if (scoville[i] < K) count++;
            pq.offer(scoville[i]);
        }

        //2개 뽑아야하니 Empty()말고 사이즈로
        while (pq.size() >= 2 && count != 0) {
            int current1 = pq.poll();
            int current2 = pq.poll();
            if (current1 < K) count--;
            if (current2 < K) count--;
            int mix = current1 + (current2 * 2);
            if (mix < K) count++;
            answer++;
            pq.offer(mix);
        }
        //큐에서 나왔는데 count가 0이 아니면 -1리턴
        if (count != 0) {
            return -1;
        } else {
            return answer;
        }
    }
}
