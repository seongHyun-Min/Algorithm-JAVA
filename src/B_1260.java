import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1260 {
    public static ArrayList<ArrayList<Integer>> array;
    public static boolean[] visitied;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken()); //시작할 노드


        array = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n + 1; i++) {
            array.add(new ArrayList<Integer>());
        } //인접리스트 생성

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            array.get(s).add(e);
            array.get(e).add(s); //양방향 그래프 인접노드 생성
        }

        for (int i = 1; i <= n; i++) { //인접리스트 중 번호가 가장 작은 노드기준으로 정렬해야하므로 for문을 이용한 정렬
            Collections.sort(array.get(i));
        }
        // 방문리스트 초기화
        visitied = new boolean[n + 1];
        dfs(v);
        System.out.println();
        visitied = new boolean[n + 1];
        // bfs 방문 리스트 초기화
        bfs(v);


    }

    public static void dfs(int n) {
        System.out.print(n + " ");
        visitied[n] = true;
        for (int i = 0; i < array.get(n).size(); i++) {
            int next = array.get(n).get(i);
            if (visitied[next] == false) {
                dfs(next);
            }
        }
        //노드가 끊어지면 연결안됨
        //더 이상 방문할 수 있는 점이 없는 경우 종료한다.
    }
    public static void bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visitied[n] = true;


        while(!queue.isEmpty()){
            int now = queue.poll(); //객체를 꺼내서 반환 없으면 null반환
            System.out.print(now + " ");
            for(int i=0; i<array.get(now).size(); i++){
                int next = array.get(now).get(i);
                if(visitied[next] == false){
                    visitied[next] = true;
                    queue.add(next); //FIFO 선입선출
                }
            }
        }
    }
}
