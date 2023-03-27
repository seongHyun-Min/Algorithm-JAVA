import javax.sound.midi.Receiver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class B_2251 {
    static int[] sender = {0, 0, 1, 1, 2, 2}; // 0-> 1, 0-> 2 , 1 -> 0 , 1->2, 2-> 0 , 2->1 갈수 있는 모든 경우의수
    static int[] recevier = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static ArrayList<Integer> answer;

    static Queue<Bottle> q = new LinkedList<>();

    static int[] max ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        max = new int[3];
        max[0] = Integer.parseInt(st.nextToken());
        max[1] = Integer.parseInt(st.nextToken());
        max[2] = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        visited = new boolean[201][201];

        BFS();
        Collections.sort(answer);
        for(int i: answer){
            System.out.print(i + " ");
        }

    }
    static public void BFS(){
        q.add(new Bottle(0, 0, max[2]));
        visited[0][0] = true;
        answer.add(max[2]);
        while(!q.isEmpty()){
            Bottle current = q.poll();
            int A = current.a;
            int B = current.b;
            int C = current.c;
            for(int k=0; k<6; k++){
                int[] next = {A, B, C};
                //    static int[] sender = {0, 0, 1, 1, 2, 2}; // 0-> 1, 0-> 2 , 1 -> 0 , 1->2, 2-> 0 , 2->1 갈수 있는 모든 경우의수
                //    static int[] recevier = {1, 2, 0, 2, 0, 1};
                next[recevier[k]] += next[sender[k]]; //k=0 이면 0-> 1 A -> B로 감
                next[sender[k]] =0;
                if(next[recevier[k]] > max[recevier[k]]){
                    next[sender[k]] = next[recevier[k]] - max[recevier[k]]; // 넘친물을 다시 sender에 넣어줌
                    next[recevier[k]] =max[recevier[k]];
                }
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    q.offer(new Bottle(next[0],next[1],next[2]));
                    if(next[0] ==0){ //A가 0일 때
                        answer.add(next[2]);

                    }

                }
            }
        }


    }


    static public class Bottle {
        int a;
        int b;

        int c;

        public Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}

