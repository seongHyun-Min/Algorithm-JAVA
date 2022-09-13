import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2606 {
    public static boolean[] visitied; //방문 리스트 dfs에서 쓰기위해서 클래스 변수로 선언, main에서 사용하려고 static
    public static ArrayList<ArrayList<Integer>> arr; // 인접 리스트 또한 dfs에서 쓰기 위하여 클래스 변수로 선언, ;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visitied = new boolean[N + 1]; //방문리스트 생성 인덱스 사용 위해 N+1
        // 인접 리스트 생성
        arr = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<N+1;i++){
            arr.add(new ArrayList<Integer>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방향 노드 삽입
            arr.get(u).add(v);
            arr.get(v).add(u);
        }dfs(1); //1과 연결된 리스트 들만 true일테니까 visitied 배열 뒤저서 true 갯수 출력
        int count=0;
        for(int i=1; i<visitied.length; i++){
            if(visitied[i] ==true){
                count ++;
            }
        }
        System.out.println(count-1); // -1을 해준 이유는 1은 방문하므로 반드시 true 그러나
        // 1을 통해서 걸리게 되는 수를 출력해야되므로 1을 제거



    }
    static void dfs(int x){
        visitied[x] =true;
        for(int i=0; i<arr.get(x).size(); i++){
            int tmp = arr.get(x).get(i);
            if(visitied[tmp] == false){
                dfs(tmp);
            }
        }
    }
}



