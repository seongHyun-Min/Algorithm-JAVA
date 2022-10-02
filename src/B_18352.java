import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_18352 {

    static int N, M, K, X;

    static List<Integer> answer; // 정답 배열 선언


    static ArrayList<ArrayList<Integer>> arr;


    static int[] visited; // 방문 배열을 int로 선언 (가중치를 넣기 위해서)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 개수 (노드의 수)
        M = Integer.parseInt(st.nextToken()); // 도로의 개수 (엣지의 수)
        K = Integer.parseInt(st.nextToken()); // 가중치 K의 값
        X = Integer.parseInt(st.nextToken()); // 출발도시 X

        arr = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr.get(u).add(v);
            // 단방향 노드 삽입
        }
        visited = new int[N + 1];
        Arrays.fill(visited, -1); //방문 배열 초기화
        bfs(X);

        answer = new ArrayList<>();

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == K) answer.add(i);
        }

        if (answer.size() > 0) {
            Collections.sort(answer);
            answer.forEach(System.out::println);
        } else System.out.println(-1);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start]++;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 0; i < arr.get(tmp).size(); i++) {
                int next = arr.get(tmp).get(i);
                if (visited[next] == -1) {
                    visited[next] = visited[tmp] + 1;
                    q.add(next);
                }
            }
        }
    }
}


