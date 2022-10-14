import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_9372 {
     static ArrayList<ArrayList<Integer>> arr;

     static boolean[] visited;

     static int T; // 테스트 케이스

    static int M, N;

    static Queue<Integer> q;

    static int count;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while(true){
            if(T == 0) break;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new ArrayList<>();
            for(int i=1; i<=N+1; i++){
                arr.add(new ArrayList<>());
            }
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr.get(u).add(v);
                arr.get(v).add(u);
            }
            visited = new boolean[N+1];
            count =0;
            BFS(1); // 이걸로 완전 탐색
            // 무방향 그래프기 때문에 어떤걸 넣어도 상관없어
            T--;
            System.out.println(count -1);

        }

    }
    public static void BFS(int start){
        q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int tmp = q.poll();
            count ++;

            for(int i=0; i<arr.get(tmp).size(); i++){
                int next = arr.get(tmp).get(i);
                if(visited[next]) continue;
                visited[next] =true;
                q.offer(next);
            }

        }
    }
}
