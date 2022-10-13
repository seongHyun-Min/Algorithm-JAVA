import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1922 {
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

    static ArrayList<ArrayList<Node>> arr; // 인접

    static boolean[] visited;

    static int N, M; // N 노드의 수, M 엣지의 수

    static PriorityQueue<Node> pq; // weight를 비교할 우선순위 큐

    static int treeSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
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
            arr.get(v).add(new Node(u, w));
        }
        visited = new boolean[N + 1];
        prim(1); // N =1  어떤 노드로 잡아도 반드시 Tmst 하나가 존재하는 증명
        System.out.println(treeSum);
    }

    public static void prim(int start) {
        treeSum = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.node]) continue;
            visited[current.node] = true;

            treeSum += current.weight;

            for (Node next : arr.get(current.node)) {
                pq.offer(new Node(next.node, next.weight));
            }
        }
    }
}

