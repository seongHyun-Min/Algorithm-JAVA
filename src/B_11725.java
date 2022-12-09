import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11725 {
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;
    static int N;

    static int[] parent;

    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>()); //인접리스트 생성
        }
        visited = new boolean[N+1];
        parent = new int[N+1]; // 부모노드 저장
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr.get(u).add(v);
            arr.get(v).add(u);
            //양방향 노드 삽입
        }
        dfs(1);
        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }

    }
    public static void dfs(int start){
        visited[start] = true;

        for(int i : arr.get(start)){
            if(visited[i]) continue;
            visited[i] = true;
            parent[i] = start;
            dfs(i);
        }
    }
}
