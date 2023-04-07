package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P_42587 {


    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Print> q = new LinkedList<>();
        int lo = 0;
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Print(priorities[i], lo++));
        }
        int count = 0;
        while (!q.isEmpty()) {
            boolean flag = false; //큐에 큰 값이 있는지 없는지 확인
            Print current = q.poll();
            for (Print p : q) {
                //큐를 다 뒤질거야
                if (current.weight < p.weight) {
                    flag = true;
                    break;
                }
            }
            //큰 값이 있다면 큐에서 뺸 값을 다시 넣어줘야지
            if (flag) {
                q.offer(current);
            } else {
                //그게 아니면 그냥 빠지는거니까 count올려
                count++;
                //그리고 혹시 빠저나온값이 내가 원하는 위치에 값이면 break
                if (current.lo == location) {
                    answer = count;
                    break;
                }
            }


        }
        return answer;
    }

    static class Print {
        int weight; //우선순위
        int lo; //로케이션

        public Print(int weight, int lo) {
            this.weight = weight;
            this.lo = lo;
        }


        @Override
        public String toString() {
            return "Print{" + "weight=" + weight + ", lo=" + lo + '}';
        }
    }
}
