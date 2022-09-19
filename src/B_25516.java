import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_25516 {
    static ArrayList<ArrayList<Integer>> arr; //인접 리스트
    static boolean[] visitied; //방문 리스트
    static int[] apple; //사과리스트
    static int N; //정점의 수
    static int K; //루트 노드의 거리 탐색할수 있는 범위 2개

    static int count; // 사과 딸수 있는 갯수

    // 8 2
    // 0 1 인접 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        apple = new int[N];
        visitied = new boolean[N];
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>()); //인접 리스트 붙히기
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr.get(u).add(v); //부모 자식 노드기 떄문에 양방향 x

        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < apple.length; i++) {
            apple[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0); //루트 노드에서 찾을수 있는 사과
        System.out.println(count);


    }

    public static void dfs(int i, int depth) { //depth 2까지만 탐색해야돼
        visitied[i] = true;
        if (apple[i] == 1) {
            count++;
            apple[i]--;
        }
            for (int x = 0; x < arr.get(i).size(); x++) {
                int next = arr.get(i).get(x);
                if (!visitied[next] &&depth<K) {
                    dfs(next,depth+1);
                }
            }
    }
}
