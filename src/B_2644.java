import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2644 {
    static int a; // 탐색 시작
    static int b; // 탐색 도착
    static ArrayList<ArrayList<Integer>> arr; // 인접리스트
    static boolean[] visitied; // 방문 리스트
    static int count = -1; //dfs 리턴

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); // 시작
        b = Integer.parseInt(st.nextToken()); //방문
        arr = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) { //이것도 N+1로 받아준다
            arr.add(new ArrayList<Integer>()); // 인접리스트 추가
        }
        visitied = new boolean[N + 1]; // 인덱스 사용하기 위해서 N+1 0번은 안써
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향인지 단방향인지 모르겠는데 일단 양방향으로 구현
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
        dfs(a, 0);
        System.out.println(count);


    }

    public static void dfs(int a, int cnt) {
        visitied[a] = true;
        for (int i = 0; i < arr.get(a).size(); i++) {
            int next = arr.get(a).get(i);
            if (visitied[next] == false) {
                if (next == b) {
                    count = cnt + 1;
                    return; // 함수 탈출
                }
                dfs(next, cnt + 1);

            }

        }

    }
}



