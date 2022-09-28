import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1753 {

    static ArrayList<ArrayList<Node>> arr; // 인접리스트

    static int[] dist; // 거리 저장 리스트

    static boolean[] visited; //방문 리스트

    static int K; // 시작 정점의 번호

    static int V; // 노드의  수 short path에서  방문리스트 초기화시 필요


    static int INF = Integer.MAX_VALUE;

    public static class Node implements Comparable<Node> {
        int endNode;
        int weight;

        public Node(int endNode, int weight) {
            this.endNode = endNode;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 수 vertex
        int E = Integer.parseInt(st.nextToken()); // 엣지의 수 Edge
        K = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        dist = new int[V + 1];
        for (int i = 1; i <= V + 1; i++) {
            arr.add(new ArrayList<>()); // 인접리스트 생성
        }
        Arrays.fill(dist, INF); // 거리 방문 배열에 INF 모두 투입
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); //시작 방향
            int v = Integer.parseInt(st.nextToken()); //도착 방향
            int w = Integer.parseInt(st.nextToken()); //가중치

            arr.get(u).add(new Node(v, w));
        }
        ShortPath(K);
        // Arrays.stream(dist).forEach(System.out::println); 테스트코드
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else System.out.println(dist[i]);


        }
    }

    public static void ShortPath(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[V + 1];
        pq.add(new Node(start, 0));
        dist[start] = 0; // 자기자신에서 자기자신으로 가는 거리는 항상 0

        while (!(pq.isEmpty())) {
            Node e = pq.poll();

            if (visited[e.endNode]) continue; //방문 햇으면 탐색 안해
            visited[e.endNode] = true;

            for (Node N : arr.get(e.endNode)) {
                if (dist[N.endNode] > dist[e.endNode] + N.weight) {
                    //dist[e.endNode] 이 노드 까지 누적 거리의 합
                    // 누적거리의합이랑 지금 노드에서 다음 노드 까지의 거리보다
                    // 지금 저장된 최소거리의 dist[N.endNode] 보다 크다면 노드를 바꿔준다
                    dist[N.endNode] = dist[e.endNode] + N.weight;
                    pq.offer(new Node(N.endNode, dist[N.endNode]));
                }
            }
        }
    }
}


