import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1240 {
    static ArrayList<ArrayList<node>> arr; // 인접 리스트 생성

    static boolean[] visitied;  // 방문 배열 생성

    static int N; // 노드의 수 2~1000 N-1개 받음

    static int M; // M 개 받자

    static int distance;

    static Queue<node> q;


    public static class node {
        int node;
        int weight;

        public node(int node, int weight) { // 생성자 생성
            this.node = node;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) {
            arr.add(new ArrayList<>());  // 인접 리스트 추가
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr.get(u).add(new node(v, w));
            arr.get(v).add(new node(u, w)); // 양방향 노드 생성
        }

        for (int i = 0; i < M; i++) {
            distance = 0;  // 거리 초기화
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            dfs(from, to);
            System.out.println(distance);
        }

    }


    public static void dfs(int from, int to) {
        visitied = new boolean[N + 1]; // 인덱스 활용
        q = new LinkedList<>();
        q.add(new node(from, 0));
        visitied[from] = true;

        while (!q.isEmpty()) {
            node e = q.poll();
            if (e.node == to) {
                distance += e.weight;
                break;
            }
            for (node n : arr.get(e.node)) {
                if (!visitied[n.node]) {
                    q.add(new node(n.node, e.weight + n.weight)); //큐에 노드간의 거리를 전부 더해서 다음으로 넘겨준다
                    //from 이 4라고 가정햇을때 인접한 노드는 3, 2가 있으니 (3, 0+(4와3의거리)), (2, 0+(4와2의 거리)) 이런식으로 계속 넘겨주면 결국에 목표값을 찾게 된다.
                    visitied[n.node] = true;
                }

            }


        }

    }


}
