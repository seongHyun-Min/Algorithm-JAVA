import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_5972 {
    public static class Node implements Comparable<Node>{
        int node;
        int weight;

        public Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; // 우선순위 큐 사용을 위한 Comparable 상속
        }
    }

    static ArrayList<ArrayList<Node>> arr; // 인접 리스트 선언

    static int N, M; // N =노드 , M = 엣지

    static boolean[] visited; // 방문 배열 선언

    static int[] dist; // 거리 배열 선언



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=1; i<=N+1; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr.get(u).add(new Node(v, w));
            arr.get(v).add(new Node(u, w)); //양방향 노드 삽입
        }
        dijkstra(1);
        System.out.println(dist[N]);
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N+1];
        dist[start] = 0;
        pq.offer(new Node(start ,0));


        while(!(pq.isEmpty())){
            Node tmp = pq.poll();
            if(visited[tmp.node]) continue;
            visited[tmp.node] = true;

            for(Node n: arr.get(tmp.node)){
                if(dist[n.node] > dist[tmp.node] + n.weight){
                    dist[n.node] = dist[tmp.node] + n.weight;
                    pq.offer(new Node(n.node, dist[n.node]));

                }
            }

        }
    }
}
