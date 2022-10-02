import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1325_1 {
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;
    static int count =0;

    static int[] answer;

    static int N, M;

    // 최대 값을 찾는 알고리즘으로 하나하나 다 탐색해서 제일 많이 해킹할수 있는 노드를 다시 재방문 하는것보다
    // 모든 노드를 탐색한후 제일 방문 횟수가 높은 노드를 출력하면 된다.
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        N = Integer.parseInt(st.nextToken()); //노드의 수
        M = Integer.parseInt(st.nextToken()); // 엣지의 수

        for(int i=1; i<=N+1; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr.get(u).add(v); // 단방향 노드 삽입
        }
        answer = new int[N+1];
        for(int i=1; i<=N; i++){
            bfs(i);
        }
        int max =0;
        for(int i=1; i<answer.length; i++){
            max = Math.max(max, answer[i]);
        }
        for(int i=1; i<answer.length; i++){
            if(answer[i] ==max) System.out.print(i +" ");
        }





    }
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N+1];
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()){
            int tmp = q.poll();
            for(int i=0; i<arr.get(tmp).size(); i++){
                int next = arr.get(tmp).get(i);
                if(!visited[next]){
                    q.offer(next);
                    visited[next] =true;
                    answer[next] ++;
                }
            }
        }
    }
}
