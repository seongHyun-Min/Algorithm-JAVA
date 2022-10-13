import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1197 {//최소 스패닝 트리

    //최소 스패닝트리는 주어진 그래프의 모든 정점들을 연결하는 부분 그래프중에서 그 가중치의 합이 최소인 트리이며
    // 사이클이 없고 edge 가 N-1인 트리이다.
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

    static ArrayList<ArrayList<Node>> arr; //인접

    static boolean[] visited;

    static int N, M; //N 노드의 수 M 엣지의 수

    static PriorityQueue<Node> pq;

    static int treeWeight;


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
            st = new StringTokenizer(br.readLine()); //무방향 그래프
            //방향 그래프 알려주지 않음
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(u).add(new Node(v, w));
            arr.get(v).add(new Node(u, w));
        }
        visited = new boolean[N + 1];
        prim(1); //어떠한 노드로 잡아도 상관없이 Tmst가 나오는 알고리즘
        System.out.println(treeWeight);

    }

    public static void prim(int start) {
        treeWeight = 0;

        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.node]) continue;
            visited[current.node] = true;
            treeWeight += current.weight;

            for (Node next : arr.get(current.node)) {
                pq.offer(new Node(next.node, next.weight));
            }
        }
    }
}

