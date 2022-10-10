import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2251 {

    static class AB{
        int A;
        int B;
        public AB(int A, int B){
            this.A = A;
            this.B = B;
        }
    }
    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited; //A B의 무게가 있으면 C는 자동으로 나오므로 A B 방문 배열만 선언
    static int[] now;
    static boolean[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        now = new int[3];
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());

        visited = new boolean[201][201];
        answer = new boolean[201];

        Queue<AB> q = new LinkedList<>();
        q.offer(new AB(0, 0)); // 처음 시작하는 물통의 크기는 0
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!q.isEmpty()) {
            AB tmp = q.poll();
            int A = tmp.A;
            int B = tmp.B;
            int C = now[2] - A - B;
            for (int i = 0; i < 6; i++) {
                int[] next = {A, B, C};
                next[Receiver[i]] += next[Sender[i]];
                next[Sender[i]] = 0;
                if (next[Receiver[i]] > now[Receiver[i]]) { // 물이 최대값 보다 넘친다면
                    //초과하는 만큼 다시 이전 물통에 넣어줌
                    next[Sender[i]] = next[Receiver[i]] - now[Receiver[i]];
                    next[Receiver[i]] = now[Receiver[i]]; //초과한 물통은 최대로 채워준
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.offer(new AB(next[0], next[1]));
                    if (next[0] == 0) { // 첫번쨰 물통이 비어잇을때만 넣어줘야하니까
                        answer[next[2]] = true;
                    }
                }
            }
        }
        for(int i=0; i<answer.length; i++){ //boolean 배열을 활용해 인덱스로 출력
            if(answer[i]) System.out.print(i +" ");
        }


    }
}
