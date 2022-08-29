import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//연결 요소 개수 구하기 bfs
public class B_11724 {
    public static ArrayList<ArrayList<Integer>> array;
    public static boolean[] visitied; //방문 배열 생성


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //노드의 수
        int M = Integer.parseInt(st.nextToken()); //엣지의 수

        visitied = new boolean[N + 1]; // 배열의 1번인덱스 부터 사용
        array = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N + 1; i++) {
            array.add(new ArrayList<Integer>());//배열안에 배열 넣기
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            array.get(u).add(v); // 양방향 그래프
            array.get(v).add(u);

        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (visitied[i] == false) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);

    }


    public static void dfs(int n){
        visitied[n] = true;
        for(int i=0; i<array.get(n).size(); i++){
            int next = array.get(n).get(i);
            if(visitied[next] == false){
                visitied[next] = true;
                dfs(next);
            }
        }
    }
}

