import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1647 { //prim 알고리즘
    static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static ArrayList<ArrayList<Node>> arr; //인접 리스트

    static boolean[] visited;

    static int N, M; // n노드의수, m 엣지의 수

    static int treeSum;

    static int maxEdge; // 마을을 2개로 나눌거니까 길이 가장 긴 길을 기준으로 나누면 최소 값이 나온다

    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr.get(u).add(new Node(v, w));
            arr.get(v).add(new Node(u, w));  //무방향 그래프
        }
        visited = new boolean[N + 1];
        prim(1);
        System.out.println(treeSum - maxEdge);
    }

    public static void prim(int start) {
        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        treeSum = 0;
        maxEdge = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.node]) continue;
            visited[current.node] = true;
            treeSum += current.weight;
            maxEdge = Math.max(maxEdge, current.weight);

            for (Node next : arr.get(current.node)) {
                pq.offer(new Node(next.node, next.weight));
            }
        }
    }
}
