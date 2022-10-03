import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1238 {
    public static class Node implements Comparable<Node> {
        int Node;
        int weight;

        public Node(int Node, int weight) {
            this.Node = Node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }


    static ArrayList<ArrayList<Node>> arr; //인접 리스트

    static ArrayList<ArrayList<Node>> reverseArr; // 역방향 인접 리스트
    // party 에서 home으로 돌아온 인접 리스트 생성

    static boolean[] visited; // 방문리스트

    static int N, M, X;

    static int[] toDist; //가는 비용

    static int[] fromDist; //돌아 오는 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드의 수
        M = Integer.parseInt(st.nextToken()); // 엣지의 수
        X = Integer.parseInt(st.nextToken()); // 목표 지점 노드
        arr = new ArrayList<>();
        reverseArr = new ArrayList<>();
        toDist = new int[N + 1];
        fromDist = new int[N + 1];
        int maxValue = Integer.MAX_VALUE;
        Arrays.fill(toDist, maxValue);
        Arrays.fill(fromDist, maxValue);
        for (int i = 0; i <= N + 1; i++) {
            arr.add(new ArrayList<>());// 인접리스트 생성
            reverseArr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 단방향 노드 삽입
            arr.get(u).add(new Node(v, w));
            reverseArr.get(v).add(new Node(u, w)); //역방향 노드 삽입
        }
        Home(X);
        party(X);

        //System.out.println(Arrays.toString(fromDist));
        //System.out.println(Arrays.toString(toDist));
        // 배열 테스트 코드

        int max_Value = 0;

        for (int i = 1; i < N + 1; i++) {
            max_Value = Math.max(max_Value, (fromDist[i] + toDist[i]));
        }

        System.out.println(max_Value);


    }

    public static void Home(int start) { //우선 X에서 집으로 돌아오는 알고리즘
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N + 1]; //방문 리스트 초기화
        fromDist[start] = 0;
        pq.offer(new Node(start, 0)); //자기 자신으로 가는 것은 04

        while (!pq.isEmpty()) {
            // 큐가 빌때까지 돌려
            Node tmp = pq.poll();
            if (visited[tmp.Node]) continue; //방문 했으면 돌릴 필요 없어
            visited[tmp.Node] = true;

            for (Node n : arr.get(tmp.Node)) {
                if (fromDist[n.Node] > fromDist[tmp.Node] + n.weight) {
                    fromDist[n.Node] = fromDist[tmp.Node] + n.weight;

                    pq.offer(new Node(n.Node, fromDist[n.Node]));
                }
            }
        }
    }

    // X로 가는 shortPast 찾기
    //근데 이렇게 사용하려면 2번 노드를 목적지로 생각하는 모든 노드에 대해서
    //다익스트라 알고리즘을 사용해야 한다
    // 이런 비효율적인 방법 대신 ,단방향 간선을 반대로 저장하게 되면
    // 마찬 가지로 2번노드를 목적지 노드가 아닌 출발지 노드로 바꿀수 있다.
    //???
    public static void party(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N + 1];
        toDist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!(pq.isEmpty())) {
            Node tmp = pq.poll();
            if (visited[tmp.Node]) continue;
            visited[tmp.Node] = true;

            for (Node n : reverseArr.get(tmp.Node)) {
                if (toDist[n.Node] > toDist[tmp.Node] + n.weight) {
                    toDist[n.Node] = toDist[tmp.Node] + n.weight;
                    pq.offer(new Node(n.Node, toDist[n.Node]));
                }
            }
        }
    }
}

